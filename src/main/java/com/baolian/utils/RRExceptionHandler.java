package com.baolian.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException;
import org.apache.shiro.authz.AuthorizationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;

/**
 * 异常处理器
 *
 * @date 2016年10月27日 下午10:16:19
 */
@Component
public class RRExceptionHandler implements HandlerExceptionResolver {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public ModelAndView resolveException(HttpServletRequest request,
                                         HttpServletResponse response, Object handler, Exception ex) {
        R r = new R();
        try {
            response.setContentType("application/json;charset=utf-8");
            response.setCharacterEncoding("utf-8");
            boolean isDenied = ex.getMessage().contains("denied"); //检测访问是否是被数据库拒绝
            if (ex instanceof RRException) {
                r.put("code", ((RRException) ex).getCode());
                r.put("msg", ((RRException) ex).getMessage());
            } else if (ex instanceof DuplicateKeyException) {
                r = R.error("数据库中已存在该记录");
            } else if (ex instanceof AuthorizationException) {
                r = R.error("没有权限，请联系管理员授权");
            } else if (ex instanceof BadSqlGrammarException) {
                if (isDenied) {
                    r = R.error(403, "操作失败，没有权限访问数据库");
                } else {
                    r = R.error();
                }
            } else {
                r = R.error();
            }

            //记录异常日志
            logger.error(ex.getMessage(), ex);

            String json = JSON.toJSONString(r);
            response.getWriter().print(json);
        } catch (Exception e) {
            logger.error("RRExceptionHandler 异常处理失败", e);
        }
        return new ModelAndView();
    }
}

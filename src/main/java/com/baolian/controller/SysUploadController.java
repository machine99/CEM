package com.baolian.controller;

import com.baolian.entity.TestagentEntity;
import com.baolian.service.TestagentService;
import com.baolian.utils.FileUtils;
import com.baolian.utils.R;
import com.baolian.utils.RRException;
import com.baolian.utils.excel.ExcelUtils;
import com.baolian.utils.excel.Student;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 文件上传
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-03-25 12:13:26
 */
@RestController
@RequestMapping("sys/upload")
public class SysUploadController extends AbstractController {
    @Autowired
    private TestagentService testagentService;

    /**
     * 上传文件
     */
    @RequestMapping("/upload")
    @RequiresPermissions("sys:upload:all")
    public R upload(@RequestParam("file") MultipartFile file) throws RRException {
        if (file.isEmpty()) {
            throw new RRException("上传文件不能为空");
        }
        if (file.getSize() > FileUtils.FILE_SIZE_LIMIT) {
            throw new RRException("上传文件不能大于50MB");
        }
        String fileType = FileUtils.getFileExtension(file.getOriginalFilename());
        InputStream is = null;
        Collection list = null;
        try {
            is = file.getInputStream();
            // 上传文件处理
            list = ExcelUtils.readExcel(is, fileType, TestagentEntity.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (list != null) {
            for (Object o : list) {
                testagentService.save((TestagentEntity) o);
            }
        } else {
            throw new RRException("上传文件出错");
        }

        return R.ok().put("msg", "上传文件成功");
    }

    @RequestMapping("/download")
    @RequiresPermissions("sys:upload:all")
    public void download(HttpServletResponse response) throws RRException {

        System.out.println("download!!!!");
        Map<String, Object> map = new HashMap<String, Object>();
        List<TestagentEntity> list = testagentService.queryList(map);
        InputStream is = null;
        ServletOutputStream out = null;
        try {
            // is = new FileInputStream("F://student_info.xls");
            // Collection<Student> list = ExcelUtils.readExcel(is, "xls", Student.class);
            // for (Student student : list) {
            //     System.out.println(student);
            // }
            XSSFWorkbook workbook = ExcelUtils.<TestagentEntity>exportExcel("sheet1", TestagentEntity.class, list);
            response.setContentType("application/octet-stream");
            // response.setCharacterEncoding("UTF-8");
            String fileName = "testagent_all.xlsx";
            response.addHeader("Content-Disposition", "attachment; filename=" + fileName);
            // File outFile = new File("F://out.xlsx");
            out = response.getOutputStream();
            workbook.write(out);
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RRException("下载文件出错");
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

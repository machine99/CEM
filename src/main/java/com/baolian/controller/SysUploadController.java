package com.baolian.controller;

import com.alibaba.fastjson.JSON;
import com.baolian.utils.R;
import com.baolian.utils.RRException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
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
public class SysUploadController {

	/**
	 * 上传文件
	 */
	@RequestMapping("/upload")
	@RequiresPermissions("sys:upload:all")
	public R upload(@RequestParam("file") MultipartFile file) throws Exception {
		if (file.isEmpty()) {
			throw new RRException("上传文件不能为空");
		}

		// TODO 上传文件

		return R.ok().put("msg", null);
	}

}

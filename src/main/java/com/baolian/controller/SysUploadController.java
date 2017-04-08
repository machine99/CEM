package com.baolian.controller;

import com.baolian.utils.FileUtils;
import com.baolian.utils.R;
import com.baolian.utils.RRException;
import com.baolian.utils.excel.ExcelUtils;
import com.baolian.utils.excel.Student;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.scripting.support.StandardScriptUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;


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
        if (file.getSize() > FileUtils.FILE_SIZE_LIMIT) {
            throw new RRException("上传文件不能大于50MB");
        }
        String fileType = FileUtils.getFileExtension(file.getOriginalFilename());
        InputStream is = file.getInputStream();
        // 上传文件处理
        Collection list = ExcelUtils.readXls(is, fileType, Student.class);
        if (list != null) {
            for (Object o : list) {
                System.out.println(((Student) o).toString());
            }
        } else {
            throw new RRException("上传文件出错");
        }

        return R.ok().put("msg", "上传文件成功");
    }

}

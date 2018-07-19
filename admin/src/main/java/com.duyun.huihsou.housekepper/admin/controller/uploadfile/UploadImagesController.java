package com.duyun.huihsou.housekepper.admin.controller.uploadfile;

import com.alibaba.fastjson.JSONObject;
import com.duyun.huihsou.housekepper.admin.inteceptor.VisitorAccessible;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.UUID;


/**
 * @author haoshijing
 * @version 2018年05月08日 21:13
 **/
@Controller
@RequestMapping("/")
public class UploadImagesController {


    private static final String PATH = "admin/target/classes/static/images";
    @VisitorAccessible
    @RequestMapping(value = "uploadimages", method = RequestMethod.POST)
    @ResponseBody
    public String fileUpload(@RequestParam("file") MultipartFile file,
                             HttpServletRequest request) {
        String fileName = "";
        try {
            if (!file.isEmpty()) {
                BufferedOutputStream out = null;
                File fileSourcePath = new File(PATH);
                if (!fileSourcePath.exists()) {
                    fileSourcePath.mkdirs();
                }
                fileName = file.getOriginalFilename();

                    out = new BufferedOutputStream(
                            new FileOutputStream(new File(fileSourcePath, fileName)));

                out.write(file.getBytes());
                out.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
//        commonResult.setCodeAndMessage(ApiStatusCode.SUCCESS,"");
//        commonResult.setData(fileName);

        return JSONObject.toJSONString(request.getContextPath()+"/images/"+fileName);
    }

}

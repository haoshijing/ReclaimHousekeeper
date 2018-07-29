package com.duyun.huihsou.housekepper.admin.controller.uploadfile;

import com.alibaba.fastjson.JSONObject;
import com.duyun.huihsou.housekepper.admin.inteceptor.VisitorAccessible;
import org.apache.commons.lang3.RandomUtils;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;


/**
 * @author haoshijing
 * @version 2018年05月08日 21:13
 **/
@Controller
@RequestMapping("/")
public class UploadImagesController {


    @Value("${web.upload-path}")
    private String PATH;

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
        String path = request.getContextPath()+"/"+fileName;
        return JSONObject.toJSONString(path);
    }

    private Logger logger = LoggerFactory.getLogger(UploadImagesController.class);
    @Autowired
    private ResourceLoader resourceLoader ;
    @RequestMapping(method = RequestMethod.GET, value = "{filename:.+}")
    public void getFile(@PathVariable String filename, HttpServletResponse response) {
        try {
            Resource resource = resourceLoader.getResource(
                    "file:" + Paths.get(PATH + "/", filename).toString());
            InputStream inputStream = resource.getInputStream();
            ServletOutputStream out = response.getOutputStream();
            IOUtils.copy(inputStream, out);
            out.flush();
        } catch (Exception e) {
            logger.error("{}", e);
        }
    }

    /**
     * 上传图片
     * @param upfile
     * @param request
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/u/images")
    public Map<String, Object> images (MultipartFile upfile, HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> params = new HashMap<String, Object>();
        try {
            String basePath = PATH;
            String visitUrl = "/upload/";

            String fileName = upfile.getOriginalFilename();
            StringBuilder sb = new StringBuilder();
            //拼接保存路径
            sb.append(basePath).append("/").append(fileName);
            visitUrl = visitUrl.concat(fileName);
            File f = new File(sb.toString());
            if (!f.exists()) {
                f.getParentFile().mkdirs();
            }
            OutputStream out = new FileOutputStream(f);
            FileCopyUtils.copy(upfile.getInputStream(), out);
            params.put("state", "SUCCESS");
            params.put("url", visitUrl);
            params.put("size", upfile.getSize());
            params.put("original", fileName);
            params.put("type", upfile.getContentType());
        } catch (Exception e) {
            params.put("state", "ERROR");
        }
        return params;
    }

    }

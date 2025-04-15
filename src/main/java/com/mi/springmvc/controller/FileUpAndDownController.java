package com.mi.springmvc.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

@Controller
public class FileUpAndDownController {

    @RequestMapping("/testDownloadFile")
    public ResponseEntity<byte[]> testResponseEntity(HttpSession session) throws IOException {
        // 获取ServletContext对象
         ServletContext context = session.getServletContext();
        // 获取服务器中文件的真实路径
        String path = context.getRealPath("/static/img/1.jpg");
        // 创建输入流
        InputStream is = new FileInputStream(path);
        // 创建字节数组
        byte[] bytes = new byte[is.available()];
        // 将流读到字节数组中
        is.read(bytes);
        // 创建HttpHeaders对象设置响应头信息
        MultiValueMap<String, String> headers = new HttpHeaders();
        // 设置下载方式以及要下载文件的名字
        headers.add("Content-Disposition", "attachment;filename=1.jpg");
        // 设置响应状态码
        HttpStatus statusCode = HttpStatus.OK;
        // 创建ResponseEntity对象
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(bytes, headers, statusCode);
        // 关闭输入流
        is.close();
        return responseEntity;
    }

    @RequestMapping("/testUploadFile")
    public String testUploadFile(MultipartFile sourceFile, HttpSession session) throws IOException {
        // 获取上传文件的文件名
        String fileName = sourceFile.getOriginalFilename();
        // 获取上传文件的后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        // 将UUID作为文件名
        String uuid = UUID.randomUUID().toString().replaceAll(".", "");
        fileName = uuid + suffixName;
        // 通过ServletContext获取服务器中file目录的路径
        ServletContext context = session.getServletContext();
        String filePath = context.getRealPath("file");
        File targetFile = new File(filePath);
        // 判断filePath所对应路径是否存在
        if (!targetFile.exists()) {
            // 若不存在，则创建目录
            targetFile.mkdir();
        }
        String finalPath = filePath + File.separator + fileName;
        // sourceFile.transferTo(new File(finalPath));
        InputStream is = sourceFile.getInputStream();

        return "success";
    }
}

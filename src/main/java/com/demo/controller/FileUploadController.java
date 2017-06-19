package com.demo.controller;

import java.io.File;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Controller
public class FileUploadController {
    
    @RequestMapping("upload/upload.html")
    public String uploadhtml(){
        return "upload/upload";
    }
    
    @RequestMapping(value = "/upload", method = RequestMethod.POST)  
    public void upload(HttpServletRequest request,HttpServletResponse response,@RequestParam("file") CommonsMultipartFile file)  {  
        int i=1/0;
        try{  
            PrintWriter out;  
            boolean flag = false;  
            if(file.getSize() > 0){  
                String path = "D:/exe/";  
                String uploadPath = request.getSession().getServletContext().getRealPath(path);  
                System.out.println(uploadPath);  
                FileUtils.copyInputStreamToFile(file.getInputStream(), new File(path,file.getOriginalFilename()));  
                flag = true;  
            }  
            out = response.getWriter();  
            if(flag == true){  
                out.print("1");  
            }else{  
                out.print("2");  
            }  
        }catch(Exception e){  
            e.printStackTrace();  
        }  
          
    }  
}

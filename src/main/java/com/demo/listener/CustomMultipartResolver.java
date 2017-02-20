package com.demo.listener;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

public class CustomMultipartResolver extends CommonsMultipartResolver {
    
    @Resource  
    private FileUploadProgressListener progressListener;  
      
    public void setFileUploadProgressListener(FileUploadProgressListener progressListener){  
        this.progressListener = progressListener;  
    }  
    @Override
    public MultipartParsingResult parseRequest(HttpServletRequest request){  
        String encoding = determineEncoding(request);  
        FileUpload fileUpload = prepareFileUpload(encoding);  
        progressListener.setSession(request.getSession());  
        fileUpload.setProgressListener(progressListener);  
        try{  
            List<FileItem> fileItems = ((ServletFileUpload) fileUpload).parseRequest(request);  
            return parseFileItems(fileItems, encoding);  
        }catch(FileUploadBase.SizeLimitExceededException ex){  
            throw new MaxUploadSizeExceededException(fileUpload.getSizeMax(), ex);  
        }catch (FileUploadException e) {  
            throw new MultipartException("异常",e);  
        }  
    }  
}

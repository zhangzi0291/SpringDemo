package com.demo.listener;

import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.ProgressListener;
import org.springframework.stereotype.Component;

import com.demo.entity.Progress;

@Component
public class FileUploadProgressListener implements ProgressListener {

    private HttpSession session;  
    
    public void setSession(HttpSession session){  
        this.session = session;  
        Progress status = new Progress();  
        session.setAttribute("status", status);  
    }  
    
    @Override
    public void update(long pBytesRead, long pContentLength, int pItems) {
        Progress status = (Progress) session.getAttribute("status");  
        status.setBytesRead(pBytesRead);  
        status.setContentLength(pContentLength);  
        status.setItems(pItems);  
    }



}

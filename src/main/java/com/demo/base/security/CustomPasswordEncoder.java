package com.demo.base.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.demo.util.StringUtil;

@Component
public class CustomPasswordEncoder implements PasswordEncoder{

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Override
    public String encode(CharSequence rawPassword) {
        String pwd = rawPassword.toString();
        try {
            return StringUtil.md5Encode(pwd);
        } catch (Exception e) {
            logger.error("Exception ", e);
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        String pwd = rawPassword.toString();
        try {
            return StringUtil.md5Encode(pwd).equals(encodedPassword);
        } catch (Exception e) {
            logger.error("Exception ", e);
        }
        return false;
    }

}

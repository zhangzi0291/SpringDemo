package com.demo.base.security.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import com.demo.base.dao.BaseDao;
import com.demo.base.exception.DaoException;
import com.demo.base.security.dao.SysUsersDao;
import com.demo.base.security.dto.UsersRolesDto;
import com.demo.base.security.entity.SysAuthorities;
import com.demo.base.security.entity.SysUsers;
import com.demo.base.security.entity.SysUsersExample;
import com.demo.base.security.service.SysUsersService;
import com.demo.base.service.impl.BaseServiceImpl;

@Service("sysUsersService")
public class SysUsersServiceImpl extends BaseServiceImpl<SysUsers, SysUsersExample> implements SysUsersService{

    @Resource
    private SysUsersDao dao;
    
    @Override
    public BaseDao<SysUsers, SysUsersExample> getDao() throws DaoException {
        return dao;
    }

    @Override
    public List<GrantedAuthority> loadUserAuthoritiesByName(String username) {
        List<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();
        Map<String, Object> param = new HashMap<>();
        param.put("username", username);
        List<SysAuthorities> salist = dao.loadUserRoles(param);
        for (SysAuthorities sa : salist) {
            if(sa == null){
                continue;
            }
            SimpleGrantedAuthority authority = new SimpleGrantedAuthority(sa.getAuthorityName());
            auths.add(authority);
        }
        return auths;
    }

    @Override
    public SysUsers findByUserAccount(String userAccount) throws Exception {
        SysUsersExample example = new SysUsersExample();
        SysUsersExample.Criteria criteria = example.createCriteria();
        criteria.andUserAccountEqualTo(userAccount);
        List<SysUsers> list = dao.selectByExample(example);
        if(list!=null && !list.isEmpty()){
            SysUsers user = list.get(0);
            return user;
        }
        throw new Exception("查不到该用户");
    }

    
}

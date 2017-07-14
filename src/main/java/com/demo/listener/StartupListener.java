package com.demo.listener;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletContext;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletContextAware;

import com.demo.base.security.dao.SysAuthoritiesDao;
import com.demo.base.security.dao.SysAuthoritiesResourcesDao;
import com.demo.base.security.dao.SysResourcesDao;
import com.demo.base.security.dto.AuthoritiesResourcesDto;
import com.demo.base.security.entity.SysAuthorities;
import com.demo.base.security.entity.SysAuthoritiesExample;
import com.demo.util.StringUtil;

@Component
public class StartupListener implements ServletContextAware, InitializingBean{

    @Resource
    private SysResourcesDao sysResourcesDao;
    @Resource
    private SysAuthoritiesDao sysAuthoritiesDao;
    @Resource
    private SysAuthoritiesResourcesDao sysAuthoritiesResourcesDao;
    
    @Override
    public void setServletContext(ServletContext servletContext) {
        String basePath = servletContext.getContextPath();
        servletContext.setAttribute("basePath", basePath);
        servletContext.setAttribute("title", "平台");
        Map<String, Collection<ConfigAttribute>> resourceMap = loadResourceDefine();
        servletContext.setAttribute("resourceMap", resourceMap);
        
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        
    }

    private Map<String, Collection<ConfigAttribute>> loadResourceDefine() {
        Map<String, Collection<ConfigAttribute>> resourceMap = null;
        SysAuthoritiesExample saExample = new SysAuthoritiesExample();
        SysAuthoritiesExample.Criteria saCriteria = saExample.createCriteria();
        saCriteria.andEnabledEqualTo(1);
        List<SysAuthorities> salist = sysAuthoritiesDao.selectByExample(saExample);
        resourceMap = new HashMap<String, Collection<ConfigAttribute>>();
        for(SysAuthorities sa : salist){
            ConfigAttribute ca = new SecurityConfig(sa.getAuthorityName());
            Map<String, Object> param = new HashMap<>();
            param.put("authorityName", sa.getAuthorityName());
            List<AuthoritiesResourcesDto> ardtoList = sysAuthoritiesResourcesDao.selectResourceAndAuthorities(param);
//          for(AuthoritiesResourcesDto ardto : ardtoList){
            for(int i = 0; i<ardtoList.size(); i++){
                AuthoritiesResourcesDto ardto = ardtoList.get(i);
                String url = ardto.getResourceUrl();
                if(StringUtil.isEmpty(url)){
                    continue;
                }
                if (resourceMap.containsKey(url)) {
                    Collection<ConfigAttribute> value = resourceMap.get(url);
                    value.add(ca);
                    resourceMap.put(url, value);
                }else {
                    Collection<ConfigAttribute> atts = new ArrayList<ConfigAttribute>();
                    atts.add(ca);
                    resourceMap.put(url, atts);
                }
            }
        }
        return resourceMap;
    }

}

package com.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.base.Page;
import com.demo.util.SqLiteUtil;
import com.demo.util.StringUtil;

@Controller
public class PokemonController {
	@RequestMapping("poketable")
	public String poketable(){
		return "poketable";
	}
	@RequestMapping("getpoke")
	@ResponseBody
	public Map<String, Object> getpoke(Page page,String name,String attribute,String property){
		Map<String, Object> map =new HashMap<String, Object>();
		StringBuffer sql=new StringBuffer("select * from pokemon_list where 1=1 ");
		List<String > param =new ArrayList<>();
		if(StringUtil.isNotEmpty(name)){
			sql.append(" and name like ?");
			param.add("%"+name+"%");	
		}
		if(StringUtil.isNotEmpty(attribute)){
			sql.append(" and (attribute1 like ? or attribute2 like ?)");
			param.add("%"+attribute+"%");	
			param.add("%"+attribute+"%");	
		}
		if(StringUtil.isNotEmpty(property)){
			sql.append(" and (property1 like ? or property2 like ?)");
			param.add("%"+property+"%");	
			param.add("%"+property+"%");	
		}
		page.setOrderBy(sql);
		page.setPagination(sql);
		if(page.getLimit()!=null&&page.getOffset()!=null){
			param.add(page.getLimit().toString());
			param.add(page.getOffset().toString());	
		}
		List<Map<String, String>> list=SqLiteUtil.getRowValue(sql.toString(),param);
		sql=new StringBuffer("select count(1) total from pokemon_list where 1=1");
		param=new ArrayList<>();
		if(StringUtil.isNotEmpty(name)){
			sql.append(" and name like ?");
			param.add("%"+name+"%");	
		}
		if(StringUtil.isNotEmpty(attribute)){
			sql.append(" and (attribute1 like ? or attribute2 like ?)");
			param.add("%"+attribute+"%");	
			param.add("%"+attribute+"%");	
		}
		if(StringUtil.isNotEmpty(property)){
			sql.append(" and (property1 like ? or property2 like ?)");
			param.add("%"+property+"%");	
			param.add("%"+property+"%");	
		}
		List<Map<String, String>> totalrs=SqLiteUtil.getRowValue(sql.toString(),param);
		map.put("rows", list);
		map.put("total", totalrs.get(0).get("total"));
		return map;
	}
	
	@RequestMapping("pokeDetail")
	public String pokeDetail(Map<String , Object> map,String name){
//		map.put("name", name);
		StringBuffer sql=new StringBuffer("select * from pokemon_list where name='"+name+"'");
		List<Map<String, String>>list = SqLiteUtil.getRowValue(sql.toString());
		Map<String, String> param=list.get(0);
		String property1=param.get("property1");
		String property2=param.get("property2");
		String hide_property=param.get("hide_property");
		sql=new StringBuffer("select * from pokemon_property where 1=1 ");
		sql.append("and (");
		if (StringUtil.isNotEmpty(property1)) {
			sql.append("property_name ='").append(property1).append("'");
		}
		if (StringUtil.isNotEmpty(property2)) {
			sql.append("or property_name ='").append(property2).append("'");
		}
		if (StringUtil.isNotEmpty(hide_property)) {
			sql.append("or property_name ='").append(hide_property).append("'");
		}
		sql.append(")");
		List<Map<String, String>>propertyList = SqLiteUtil.getRowValue(sql.toString());
		map.put("pro",param);
		for(int i=0;i<propertyList.size();i++){
			if(hide_property.equals(propertyList.get(i).get("property_name"))){
				propertyList.get(i).put("hide", "1");
			}
		}
		map.put("property",propertyList);
		return "pokeDetail";
	}
}

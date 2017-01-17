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
	public Map<String, Object> getpoke(HttpServletRequest request,Page page,String name,String attribute,String property){
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
}

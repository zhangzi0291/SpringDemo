package com.demo.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class StringUtil {
	//phoneNum[0]移动，phoneNum[1]联通，phoneNum[2]电信
	private static final String[][] phoneNum={{"139","138","137","136","135","134","159","158","157","150","151","152","188"},
			{"130","131","132","156","155"},{"133","153","189"}};
	private static final Random random=new Random();
	
	
	public  static void main(String ... strings){
		System.out.println(reverse("aabbccddee"));
	}
	/**
	 * 
	  * 字符串是否为空的判断，空为true
	  *@param str
	  *@return 
	  *@date 2016年8月31日 上午11:05:20
	  *@author zxn
	 */
	public static boolean isEmpty(String str){
		return str==null||"".equals(str)?true:false;
	}

	/**
	 * 
	  * 获取随机手机号码
	  *@return 
	  *@date 2016年8月31日 上午11:05:06
	  *@author zxn
	 */
	public static String getRandomPhone(){
		//运营商
		int yys=random.nextInt(phoneNum.length);
		String phone=phoneNum[yys][random.nextInt(phoneNum[yys].length)];
		for(int i=0;i<8;i++){
			phone+=random.nextInt(10);
		}
		return phone;
	}
	
	/**
	 * 
	  * 字符串倒置
	  *@param str
	  *@return 
	  *@date 2016年8月31日 上午11:05:49
	  *@author zxn
	 */
	public static String reverse(String str){
		List<String > list=getList(str);
		Collections.reverse(list);
		str="";
		for(String s : list){
			str+=s;
		}
		return str;
	}
	
	private static List<String> getList(String str){
		List<String> list=new ArrayList<>();
		String [] s=str.split("");
		for(int i=0;i<s.length;i++){
			list.add(s[i]);
		}
		return list;
	}
	
	public static String getRdStr(int num){
		String[] s={"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","0",
				"1","2","3","4","5","6","7","8","9","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S",
				"T","U","V","W","X","Y","Z"};
		String str="";
		for(int i=0;i<num;i++){
			str+=s[random.nextInt(61)];
		}
		return str;
 	}
}

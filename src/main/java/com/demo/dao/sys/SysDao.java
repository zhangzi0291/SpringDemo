package com.demo.dao.sys;

import java.util.List;
import java.util.Map;

public interface SysDao {
	Integer findId();
	Map<String, String> findMoneyByUserId(String userId);
	List<Map<String, String>> getLoanAmount(String userId);
	List<Map<String, String>> getRepayment(String userId);
}

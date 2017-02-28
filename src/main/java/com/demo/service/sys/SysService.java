package com.demo.service.sys;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface SysService {
	BigDecimal findId();
	Map<String , String> findMoneyByUserId(String userId);
	List<Map<String, String>> getLoanAmount(String userId);
	List<Map<String, String>> getRepayment(String userId);
}

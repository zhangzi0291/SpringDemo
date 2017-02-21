package com.demo.base;

import java.util.Map;

public class RespBody {

	private String respMsg;
	
	private Map<String, Object> respInfo;
	
	private String respCode;

	public String getRespMsg() {
		return respMsg;
	}

	public void setRespMsg(String respMsg) {
		this.respMsg = respMsg;
	}

	public Map<String, Object> getRespInfo() {
		return respInfo;
	}

	public void setRespInfo(Map<String, Object> respInfo) {
		this.respInfo = respInfo;
	}

	public String getRespCode() {
		return respCode;
	}

	public void setRespCode(String respCode) {
		this.respCode = respCode;
	}

	@Override
	public String toString() {
		return "RespBody [respMsg=" + respMsg + ", respInfo=" + respInfo + ", respCode=" + respCode + "]";
	}
	
}

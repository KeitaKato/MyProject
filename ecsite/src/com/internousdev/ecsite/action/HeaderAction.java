package com.internousdev.ecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class HeaderAction extends ActionSupport implements SessionAware{

	public Map<String, Object> session;

	LoginDTO loginDTO = new LoginDTO();

	public String execute() {
		// 結果を格納
		String result = "ゲスト";
		if(loginDTO.getLoginFlg() == true) {
			result = loginDTO.getUserName();
		}
		return result;
	}
	public Map<String, Object> getsession() {
		return this.session;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		// TODO 自動生成されたメソッド・スタブ
		this.session = session;
	}
}

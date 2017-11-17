package com.internousdev.ecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class HeaderAction extends ActionSupport implements SessionAware{

	public Map<String, Object> session;

	//ユーザー名を格納
	private String name;

	LoginDTO loginDTO = new LoginDTO();

	public void setName(String name) {
		// フラグfalseの場合nameにゲストを
		if(loginDTO.getLoginFlg() == false) {
			name = "ゲスト";
		}else {
			name = session.get("login_user_name").toString();
		}
	}
	public String getName() {
		return name;
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

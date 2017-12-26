package com.internousdev.ecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.AddressDAO;
import com.internousdev.ecsite.dto.AddressDTO;
import com.opensymphony.xwork2.ActionSupport;

public class AddressAction extends ActionSupport implements SessionAware{

	public AddressDAO dao = new AddressDAO();

	public AddressDTO dto = new AddressDTO();

	private String name;

	private String postal;

	private int pref;

	private String city;

	private String room;

	private String number;

	public Map<String, Object> session;

	public String execute() {

		String result = SUCCESS;

		if(!session.containsKey("login_user_id")){
			result = ERROR;
		}else{

			dto = dao.selectAddressInfoDAO(session.get("login_user_id").toString());

			this.name = dto.getName();
			this.postal = dto.getPostal();
			this.pref = dto.getPref();
			this.city = dto.getCity();
			this.room = dto.getRoom();
			this.number = dto.getNumber();
		}

		return result;

	}

	@Override
	public void setSession(Map<String, Object> session) {
		// TODO 自動生成されたメソッド・スタブ
		this.session = session;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPostal() {
		return postal;
	}

	public void setPostal(String postal) {
		this.postal = postal;
	}

	public int getPref() {
		return pref;
	}

	public void setPref(int pref) {
		this.pref = pref;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

}

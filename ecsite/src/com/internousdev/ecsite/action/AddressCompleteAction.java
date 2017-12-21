package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.AddressCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class AddressCompleteAction extends ActionSupport implements SessionAware{

	private String name;

	private String postal;

	private int pref;

	private String city;

	private String room;

	private String number;

	private String addressDAOResult;

	AddressCompleteDAO dao = new AddressCompleteDAO();


	public Map<String, Object> session;

	public String execute() throws SQLException{

		addressDAOResult = dao.insertAddressDAO(session.get("login_user_id").toString(),name,postal,pref,city,room,number);




		return SUCCESS;
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

	public String getAddressDAOResult() {
		return addressDAOResult;
	}

	public void setAddressDAOResult(String addressDAOResult) {
		this.addressDAOResult = addressDAOResult;
	}

}

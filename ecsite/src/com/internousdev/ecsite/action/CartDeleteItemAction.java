package com.internousdev.ecsite.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.CartDeleteItemDAO;
import com.opensymphony.xwork2.ActionSupport;

public class CartDeleteItemAction extends ActionSupport implements SessionAware{

	public Map<String, Object> session;

	public List<Integer> idList = new ArrayList<>();

	private int index;

	CartDeleteItemDAO dao =new CartDeleteItemDAO();

	public String cartResult;

	public String execute() {
		dao.cartDeleteItem(idList.get(index),session.get("login_user_id").toString());
		return SUCCESS;

	}

	public String getCartResult() {
		return cartResult;
	}

	public void setCartResult(String cartResult) {
		this.cartResult = cartResult;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		// TODO 自動生成されたメソッド・スタブ
		this.session = session;
	}

	public List<Integer> getIdList() {
		return idList;
	}

	public void setIdList(List<Integer> idList) {
		this.idList = idList;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

}

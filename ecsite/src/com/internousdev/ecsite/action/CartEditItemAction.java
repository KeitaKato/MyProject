package com.internousdev.ecsite.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.CartEditItemDAO;
import com.internousdev.ecsite.dto.ItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class CartEditItemAction extends ActionSupport implements SessionAware{

	private int total_price = 0;

	CartEditItemDAO cartEditItemDAO = new CartEditItemDAO();

	public Map<String, Object> session;

	public List<ItemDTO> cartItemList = new ArrayList<>();

	public String execute() {

		cartItemList = cartEditItemDAO.getCartEditItemDAOinfo(session.get("login_user_id").toString());

		total_price = cartEditItemDAO.getTotal_price();

		return SUCCESS;

	}

	public int getTotal_price() {
		return total_price;
	}

	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		// TODO 自動生成されたメソッド・スタブ
		this.session = session;
	}
}

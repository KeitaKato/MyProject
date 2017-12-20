package com.internousdev.ecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.CartUpdateItemDAO;
import com.opensymphony.xwork2.ActionSupport;

public class CartUpdateItemAction extends ActionSupport implements SessionAware{

	public int select;

	public int id;

	public int price;

	public String deleteFlg;

	CartUpdateItemDAO dao =new CartUpdateItemDAO();

	public String cartResult;

	public Map<String,Object> session;

	public String execute() {
		System.out.println(select);
		System.out.println(id);
		System.out.println(price);
		System.out.println(session.get("login_user_id").toString());
		System.out.println(deleteFlg);

			int totalPrice = select * price;
			System.out.println(totalPrice);
		if(deleteFlg == null) {
			dao.cartUpdateItem(id,totalPrice,select, session.get("login_user_id").toString());
			cartResult = dao.getResult();
		}else if(deleteFlg.equals("on")){
			dao.cartDeleteItem(id,session.get("login_user_id").toString());
			cartResult = dao.getResult();
		}

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
		this.session = session;

	}

	public int getSelectList() {
		return select;
	}

	public void setSelectList(int select) {
		this.select = select;
	}

	public int getPriceList() {
		return price;
	}

	public void setPriceList(int price) {
		this.price = price;
	}

	public int getIdList() {
		return id;
	}

	public void setIdList(int id) {
		this.id = id;
	}

	public String getDeleteFlg() {
		return deleteFlg;
	}

	public void setDeleteFlg(String deleteFlg) {
		this.deleteFlg = deleteFlg;
	}


}

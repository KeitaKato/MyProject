package com.internousdev.ecsite.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.CartUpdateItemDAO;
import com.opensymphony.xwork2.ActionSupport;

public class CartUpdateItemAction extends ActionSupport implements SessionAware{

	private List<Integer> selectList = new ArrayList<>();

	private List<Integer> idList = new ArrayList<>();

	private List<Integer> priceList = new ArrayList<>();

	private int index;

	CartUpdateItemDAO dao =new CartUpdateItemDAO();

	public String cartResult;

	public Map<String,Object> session;

	public String execute() {
		System.out.println(selectList.get(index));
		System.out.println(idList.get(index));
		System.out.println(priceList.get(index));
		System.out.println(session.get("login_user_id").toString());

			int totalPrice = (int)selectList.get(index) * (int)priceList.get(index);
			System.out.println(totalPrice);

			dao.cartUpdateItem((int)idList.get(index),totalPrice,(int)selectList.get(index), session.get("login_user_id").toString());
		cartResult = dao.getResult();

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

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public List<Integer> getSelectList() {
		return selectList;
	}

	public void setSelectList(List<Integer> selectList) {
		this.selectList = selectList;
	}

	public List<Integer> getPriceList() {
		return priceList;
	}

	public void setPriceList(List<Integer> priceList) {
		this.priceList = priceList;
	}

	public List<Integer> getIdList() {
		return idList;
	}

	public void setIdList(List<Integer> idList) {
		this.idList = idList;
	}


}

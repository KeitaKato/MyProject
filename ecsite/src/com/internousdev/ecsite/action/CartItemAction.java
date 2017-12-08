package com.internousdev.ecsite.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.CartItemDAO;
import com.internousdev.ecsite.dto.CartItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class CartItemAction extends ActionSupport implements SessionAware{

	public int buyCount;

	private String cartResult;

	public Map<String, Object> session;

	private int totalPrice;

	CartItemDTO cartItemDTO = new CartItemDTO();

	CartItemDAO cartItemDAO = new CartItemDAO();

	public List<CartItemDTO> cartItemList = new ArrayList<>();

	public String execute() {
		String result = SUCCESS;

		if(session.containsKey("login_user_id")) {
			int id = (int) session.get("id");
			cartItemDAO.CartPlus(id, buyCount, session.get("userName").toString());

			cartResult = cartItemDAO.getCartResult();

			totalPrice = cartItemDAO.getTotalPrice();

			cartItemList.add(cartItemDTO);
		}else{
			result = ERROR;
		}
		return result;

	}

	public int getCount() {
		return buyCount;
	}

	public void setCount(int count) {
		this.buyCount = count;
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

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
}

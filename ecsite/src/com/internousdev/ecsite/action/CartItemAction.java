package com.internousdev.ecsite.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.CartItemDAO;
import com.internousdev.ecsite.dto.ItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class CartItemAction extends ActionSupport implements SessionAware{

	private int id;

	private int buyCount;

	private int total_price;

	private String itemImg;

	private String itemCategory;

	private String itemName;

	private int itemPrice;

	private String cartResult;

	public Map<String, Object> session;

	ItemDTO itemDTO = new ItemDTO();

	CartItemDAO cartItemDAO = new CartItemDAO();

	public List<ItemDTO> itemList = new ArrayList<>();

	public String execute() {
		String result = SUCCESS;

		total_price = buyCount * itemPrice;

		cartItemDAO.CartPlus(id, total_price, buyCount, (String)session.get("login_user_id"));

		cartResult = cartItemDAO.getCartResult();

		return result;
	}

	public int getCount() {
		return buyCount;
	}

	public void setCount(int count) {
		this.buyCount = count;
	}

	public Map<String, Object> getSession(){
		return session;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		// TODO 自動生成されたメソッド・スタブ
		this.session = session;
	}

	public String getCartResult() {
		return cartResult;
	}

	public void setCartResult(String cartResult) {
		this.cartResult = cartResult;
	}

	public String getItemImg() {
		return itemImg;
	}

	public void setItemImg(String itemImg) {
		this.itemImg = itemImg;
	}

	public String getItemCategory() {
		return itemCategory;
	}

	public void setItemCategory(String itemCategory) {
		this.itemCategory = itemCategory;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}

}

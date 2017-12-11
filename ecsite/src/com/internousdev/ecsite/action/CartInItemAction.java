package com.internousdev.ecsite.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.CartInItemDAO;
import com.internousdev.ecsite.dto.CartInItemDTO;
import com.internousdev.ecsite.dto.ItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class CartInItemAction extends ActionSupport implements SessionAware{

	public List<Integer> buyCountList = new ArrayList<>();

	public List<Integer> idList = new ArrayList<>();

	private String cartResult;

	public Map<String, Object> session;

	public int totalPrice;				//カート内の合計金額 を格納

	CartInItemDTO cartInItemDTO = new CartInItemDTO();

	CartInItemDAO cartInItemDAO = new CartInItemDAO();

	public List<ItemDTO> itemList = new ArrayList<>();

	public String execute() {
		String result = SUCCESS;

		ItemDTO itemDTO = (ItemDTO) session.get("itemDTO");

		if(session.containsKey("login_user_id")) {

			int forCount = 0;

			for(int id : idList) {


				int priceCount;				//buyCountList * cartItemDTO を格納

				priceCount = itemDTO.getItemPrice() * (int)buyCountList.get(forCount);
				cartInItemDAO.CartPlus(id, priceCount, (int)buyCountList.get(forCount), session.get("login_user_id").toString());

				cartResult = cartInItemDAO.getCartResult();

				totalPrice = cartInItemDAO.getTotal_price();

				itemDTO.setBuyConut((int)buyCountList.get(forCount));

				if(!session.containsKey(itemList)){
					session.put("itemList", itemList);
				}

				session.get(itemList.add(itemDTO));

				forCount++;
			}
		}else{
			result = ERROR;
		}
		return result;

	}

	public List<Integer> getbuyCountList() {
		return buyCountList;
	}

	public void setbuyCountList(List<Integer> buyCountList) {
		this.buyCountList = buyCountList;
	}

	public List<Integer> getId() {
		return buyCountList;

	}

	public void setIdList(List<Integer> idList) {
		this.idList = idList;
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

	public List<ItemDTO> getCartItemList() {
		return itemList;

	}
}

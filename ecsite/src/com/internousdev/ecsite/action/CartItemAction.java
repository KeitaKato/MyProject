package com.internousdev.ecsite.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dto.ItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class CartItemAction extends ActionSupport implements SessionAware{

	public int buyCount;

	public Map<String, Object> session;

	ItemDTO itemDTO = new ItemDTO();

	public List<ItemDTO> itemList = new ArrayList<>();

	public String execute() {
		String result = SUCCESS;
		if (session.get("itemDTO.getId()+itemList") == null) {
			itemList.add(itemDTO);
			session.put("itemDTO.getId()+itemList", itemList);
		}else {

		}
		int intCount = Integer.parseInt(session.get("count").toString());
		int intPrice = Integer.parseInt(session.get("item_price").toString());

		session.put("total_price", intCount * intPrice);

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

}

package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.DateilItemDAO;
import com.internousdev.ecsite.dto.ItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class DetailItemAction extends ActionSupport implements SessionAware{

	public Map<String, Object> session;

	private int id;

	private String itemName;

	private int itemPrice;

	private String itemCategory;

	private String itemImg;

	private DateilItemDAO itemDAO = new DateilItemDAO();

	private ItemDTO itemDTO = new ItemDTO();



	public String execute() throws SQLException{
		itemDTO = itemDAO.getItemDateilInfo(id);

		this.itemName = itemDTO.getItemName();
		this.itemPrice = itemDTO.getItemPrice();
		this.itemCategory = itemDTO.getItemCategory();
		this.itemImg = itemDTO.getItemImg();

		return SUCCESS;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		// TODO 自動生成されたメソッド・スタブ
		this.session = session;

	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getItemCategory() {
		return itemCategory;
	}

	public void setItemCategory(String itemCategory) {
		this.itemCategory = itemCategory;
	}

	public String getItemImg() {
		return itemImg;
	}

	public void setItemImg(String itemImg) {
		this.itemImg = itemImg;
	}



}

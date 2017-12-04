package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.ItemDAO;
import com.internousdev.ecsite.dto.ItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemLineupAction extends ActionSupport implements SessionAware{

	public Map<String, Object> session;

	private ItemDAO dao = new ItemDAO();

	public List<ItemDTO> itemList = new ArrayList<>();


	public String execute() throws SQLException{

	itemList = dao.getItemDAOInfo();
		return SUCCESS;

	}

	public List<ItemDTO> getItemList() {
		return itemList;

	}


	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;

	}

}

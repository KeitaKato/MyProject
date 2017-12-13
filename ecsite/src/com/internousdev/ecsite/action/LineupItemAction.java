package com.internousdev.ecsite.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.LineupItemDAO;
import com.internousdev.ecsite.dto.ItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class LineupItemAction extends ActionSupport implements SessionAware{

	public Map<String, Object> session;

	private LineupItemDAO dao = new LineupItemDAO();

	public List<ItemDTO> itemList = new ArrayList<>();


	public String execute() {

	itemList = dao.getItemLineupDAOInfo();
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

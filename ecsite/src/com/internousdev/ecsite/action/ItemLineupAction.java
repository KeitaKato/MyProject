package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.ItemLineupDAO;
import com.internousdev.ecsite.dto.ItemLineupDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemLineupAction extends ActionSupport implements SessionAware{
	
	private ItemLineupDAO dao = new ItemLineupDAO();
	
	public List<ItemLineupDTO> ItemList = new ArrayList<ItemLineupDTO>();
	
	
	public String execute() throws SQLException{
		
	}

}

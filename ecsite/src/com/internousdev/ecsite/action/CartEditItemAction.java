package com.internousdev.ecsite.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.CartEditItemDAO;
import com.internousdev.ecsite.dto.ItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class CartEditItemAction extends ActionSupport implements SessionAware{

	private int total_price = 0;

	CartEditItemDAO cartEditItemDAO = new CartEditItemDAO();

	public Map<String, Object> session;

	public List<ItemDTO> cartItemList = new ArrayList<>();

	public List<Integer> selectList = new ArrayList<>();

	public List<Integer> idList = new ArrayList<>();

	public List<Integer> priceList = new ArrayList<>();

	private String branch;

	private int index;

	public String execute() {

		String result = SUCCESS;

		cartItemList = cartEditItemDAO.getCartEditItemDAOinfo(session.get("login_user_id").toString());

		total_price = cartEditItemDAO.getTotal_price();

		if(branch == null){

		result = SUCCESS;

		}else if(branch.equals("regi")){
			result = ERROR;
		}

		return result;

	}

	public int getTotal_price() {
		return total_price;
	}

	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		// TODO 自動生成されたメソッド・スタブ
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

	public List<Integer> getIdList() {
		return idList;
	}

	public void setIdList(List<Integer> idList) {
		this.idList = idList;
	}

	public List<Integer> getPriceList() {
		return priceList;
	}

	public void setPriceList(List<Integer> priceList) {
		this.priceList = priceList;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}
}

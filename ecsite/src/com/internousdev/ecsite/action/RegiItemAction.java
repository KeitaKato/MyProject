package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.CartUpdateItemDAO;
import com.opensymphony.xwork2.ActionSupport;

public class RegiItemAction extends ActionSupport implements SessionAware{

	public Map<String, Object> session;

	private List<Integer> id = new ArrayList<>();

	private List<Integer> select = new ArrayList<>();

	private List<Integer> price = new ArrayList<>();

	private List<String> deleteFlg = new ArrayList<>();

	CartUpdateItemDAO updateDAO = new CartUpdateItemDAO();



	public String execute() throws SQLException{

		if(session.containsKey("login_user_id")){

			for(int i: id) {

				if(deleteFlg.get(i) == null) {
					int totalPrice = (int)select.get(i) * (int)price.get(i);
					updateDAO.cartUpdateItem(i,totalPrice,(int)select.get(i), session.get("login_user_id").toString());
				}else if(deleteFlg.get(i).equals("on")){
					updateDAO.cartDeleteItem(i, session.get("login_user_id").toString());
				}

			}

		}else{
			return ERROR;
		}


		return SUCCESS;

	}

	@Override
	public void setSession(Map<String, Object> session) {
		// TODO 自動生成されたメソッド・スタブ
		this.session = session;
	}

	public List<Integer> getId() {
		return id;
	}

	public void setId(List<Integer> id) {
		this.id = id;
	}

	public List<Integer> getSelect() {
		return select;
	}

	public void setSelect(List<Integer> select) {
		this.select = select;
	}

	public List<Integer> getPrice() {
		return price;
	}

	public void setPrice(List<Integer> price) {
		this.price = price;
	}

	public List<String> getDeleteFlg() {
		return deleteFlg;
	}

	public void setDeleteFlg(List<String> deleteFlg) {
		this.deleteFlg = deleteFlg;
	}


}

package com.internousdev.ecsite.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.CartUpdateItemDAO;
import com.opensymphony.xwork2.ActionSupport;

public class CartUpdateItemAction extends ActionSupport implements SessionAware{



	private List<Integer> idList = new ArrayList<>();

	private List<Integer> selectList = new ArrayList<>();

	private List<Integer> priceList = new ArrayList<>();

	private Integer deleteFlg;

	private Integer index = null;

	private String branch;

	CartUpdateItemDAO dao =new CartUpdateItemDAO();

	public String cartResult;

	public Map<String,Object> session;

	public String execute() {
		System.out.println(selectList);
		System.out.println(idList);
		System.out.println(priceList);
		System.out.println(session.get("login_user_id").toString());
		System.out.println(deleteFlg);
		System.out.println(index);
		System.out.println(branch);

		if(branch == null){

			if(deleteFlg == null) {
				int totalPrice = (int)selectList.get(index) * (int)priceList.get(index);
				dao.cartUpdateItem(idList.get(index),totalPrice,(int)selectList.get(index), session.get("login_user_id").toString());
			}else if(deleteFlg != null){
				dao.cartDeleteItem(idList.get((int)deleteFlg), session.get("login_user_id").toString());
			}

		}else if(branch.equals("regi")){

			int forCount = 0;

			for(int i: idList) {

				int totalPrice = (int)selectList.get(forCount) * (int)priceList.get(forCount);
				dao.cartUpdateItem(i,totalPrice,(int)selectList.get(forCount), session.get("login_user_id").toString());

				forCount++;

			}

		}
		return SUCCESS;
	}


	public String getCartResult() {
		return cartResult;
	}

	public void setCartResult(String cartResult) {
		this.cartResult = cartResult;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;

	}

	public List<Integer> getSelectList() {
		return selectList;
	}

	public void setSelectList(List<Integer> selectList) {
		this.selectList = selectList;
	}

	public List<Integer> getPriceList() {
		return priceList;
	}

	public void setPriceList(List<Integer> priceList) {
		this.priceList = priceList;
	}

	public List<Integer> getIdList() {
		return idList;
	}

	public void setIdList(List<Integer> idList) {
		this.idList = idList;
	}

	public Integer getDeleteFlg() {
		return deleteFlg;
	}

	public void setDeleteFlg(Integer deleteFlg) {
		this.deleteFlg = deleteFlg;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getBranch(){
		return branch;
	}

	public void setBranch(String branch){
		this.branch = branch;
	}


}

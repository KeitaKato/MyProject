package com.internousdev.ecsite.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.AddressDAO;
import com.internousdev.ecsite.dao.RegiCompleteItemDAO;
import com.internousdev.ecsite.dto.AddressDTO;
import com.internousdev.ecsite.dto.RegiItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class RegiCompleteItemAction extends ActionSupport implements SessionAware{

	private int total_price = 0;

	RegiCompleteItemDAO regiCompleteItemDAO = new RegiCompleteItemDAO();

	public Map<String, Object> session;

	public List<RegiItemDTO> regiItemList = new ArrayList<>();

	public List<Integer> selectList = new ArrayList<>();

	public List<Integer> idList = new ArrayList<>();

	public List<Integer> priceList = new ArrayList<>();

	public AddressDAO dao = new AddressDAO();

	public AddressDTO dto = new AddressDTO();

	private String name;

	private String postal;

	private int pref;

	private String city;

	private String room;

	private String number;

	private String branch;

	private int index;

	public String execute() {

		String result = SUCCESS;

		if(!session.containsKey("login_user_id")){
			result = ERROR;
		}else{

			dto = dao.selectAddressInfoDAO(session.get("login_user_id").toString());

			this.name = dto.getName();
			this.postal = dto.getPostal();
			this.pref = dto.getPref();
			this.city = dto.getCity();
			this.room = dto.getRoom();
			this.number = dto.getNumber();

			regiItemList = regiCompleteItemDAO.getRegiCompleteItemDAOinfo(session.get("login_user_id").toString());

			total_price = regiCompleteItemDAO.getTotal_price();
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

	public List<RegiItemDTO> getRegiItemList(){
		return regiItemList;
	}

	public void setRegiItemList(List<RegiItemDTO> regiItemList){
		this.regiItemList = regiItemList;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPostal() {
		return postal;
	}

	public void setPostal(String postal) {
		this.postal = postal;
	}

	public int getPref() {
		return pref;
	}

	public void setPref(int pref) {
		this.pref = pref;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
}

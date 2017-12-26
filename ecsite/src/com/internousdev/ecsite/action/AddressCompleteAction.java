package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.AddressCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class AddressCompleteAction extends ActionSupport implements SessionAware{

	private String name = null;

	private String postal = null;

	private int pref;

	private String city = null;

	private String room = null;

	private String number = null;

	private String addressDAOResult;

	List<String> errorMessage =new ArrayList<>();

	AddressCompleteDAO dao = new AddressCompleteDAO();


	public Map<String, Object> session;

	public String execute() throws SQLException{
		System.out.println(name);
		System.out.println(postal);
		System.out.println(city);
		System.out.println(room);
		System.out.println(number);


		List<String> checkResult =new ArrayList<String>(Arrays.asList("氏名","郵便番号","都道府県","住所","アパート名・マンション名","電話番号"));
		if(name.length() != 0){
			name = Normalizer.normalize(name, Normalizer.Form.NFKC);
			checkResult.set(0, "success");
		}
		if(postal.length() != 0){
			postal = Normalizer.normalize(postal, Normalizer.Form.NFKC);
			if(postal.matches("^[0-9]{7}$") == true){
				StringBuffer postalBfr = new StringBuffer(postal);
				postalBfr.insert(3, "-");
				postal = postalBfr.toString();
				checkResult.set(1, "success");
			}else if(postal.matches("^[0-9]{3}-[0-9]{4}$") == true){
				checkResult.set(1, "success");
			}else{
				checkResult.set(1, "7桁");
			}
		}
		if(pref != 0){
			checkResult.set(2, "success");
		}
		if(city.length() != 0){
			city = Normalizer.normalize(city, Normalizer.Form.NFKC);
			checkResult.set(3, "success");
		}
		if(room.length() != 0){
			room = Normalizer.normalize(room, Normalizer.Form.NFKC);
			checkResult.set(4, "success");
		}
		if(number.length() != 0){
			number = Normalizer.normalize(number, Normalizer.Form.NFKC);
			if(number.matches("^[0-9]{11}$") == true){
				StringBuffer numberBfr = new StringBuffer(number);
				numberBfr.insert(3, "-");
				numberBfr.insert(8, "-");
				number = numberBfr.toString();
				checkResult.set(5, "success");
			}else if(number.matches("^[0-9]{3}-[0-9]{4}-[0-9]{4}$") == true){
				checkResult.set(5, "success");
			}else{
				checkResult.set(5, "11桁");
			}
		}
		System.out.println(checkResult);

		boolean status=true;
		for(int i=0;checkResult.size()>i;i++){
			if((checkResult.get(i).toString()).equals("success")){
				if(status==true){
					status=true;
				}
			}else{
				status=false;
			}

		}

		if(status==true){
			addressDAOResult = dao.insertAddressDAO(session.get("login_user_id").toString(),name,postal,pref,city,room,number);
			return SUCCESS;

		}

		if(checkResult.equals("success") == true){
			addressDAOResult = dao.insertAddressDAO(session.get("login_user_id").toString(),name,postal,pref,city,room,number);

			return SUCCESS;
		}else{
			for(String check: checkResult){
				if(check.equals("success") == false){
					if(check.equals("7桁") == true){
						errorMessage.add("郵便番号は"+ check + "の数字で入力してください。");
					}else if(check.equals("11桁") == true){
						errorMessage.add("電話番号は"+check+"の数字で入力してください。");
					}else{
						errorMessage.add(check+"を入力してください。");
					}
				}
			}
			return ERROR;
		}
	}

	@Override
	public void setSession(Map<String, Object> session) {
		// TODO 自動生成されたメソッド・スタブ
		this.session = session;
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

	public String getAddressDAOResult() {
		return addressDAOResult;
	}

	public void setAddressDAOResult(String addressDAOResult) {
		this.addressDAOResult = addressDAOResult;
	}

	public List<String> getErrorMessage(){
		return errorMessage;
	}

	public void setErrorMessage(List<String> errorMessage){
		this.errorMessage = errorMessage;
	}

}

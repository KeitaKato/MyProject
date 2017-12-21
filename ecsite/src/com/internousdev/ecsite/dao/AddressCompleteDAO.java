package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.ecsite.dto.AddressDTO;
import com.internousdev.ecsite.util.DBConnector;
import com.internousdev.ecsite.util.DateUtil;

public class AddressCompleteDAO {

	private DBConnector dbConnector = new DBConnector();

	private Connection connection = dbConnector.getConnection();

	private DateUtil dateUtil = new DateUtil();

	AddressDTO dto = new AddressDTO();

	public String insertAddressDAO(String userId, String name, String postal, int pref, String city, String room, String number) {
		// TODO 自動生成されたメソッド・スタブ
		String selectSql = "SELECT * FROM user_address_transaction WHERE user_master_id=?";
		String insertSql = "INSERT into user_address_transaction (user_master_id,user_name,postal_code,prefectures_code,city,room,phone_number,insert_date) VALUES(?,?,?,?,?,?,?,?)";
		String updateSql = "UPDATE user_address_transaction SET user_name=?,postal_code=?,prefectures_code=?,city=?,room=?,phone_number=?, update_date=? WHERE user_master_id=?";
		String result = "住所が登録できませんでした。";

		try{
			PreparedStatement preparedStatement = connection.prepareStatement(selectSql);
			preparedStatement.setString(1, userId);
			ResultSet resultSet = preparedStatement.executeQuery();

			if(resultSet.next()){
				PreparedStatement updateStatement = connection.prepareStatement(updateSql);
				updateStatement.setString(1, name);
				updateStatement.setString(2, postal);
				updateStatement.setInt(3, pref);
				updateStatement.setString(4, city);
				updateStatement.setString(5, room);
				updateStatement.setString(6, number);
				updateStatement.setString(7, dateUtil.getDate());
				updateStatement.setString(8, userId);
				updateStatement.executeUpdate();
				result = "住所を更新しました。";

			}else{
				PreparedStatement insertStatement = connection.prepareStatement(insertSql);
				insertStatement.setString(1, userId);
				insertStatement.setString(2,name);
				insertStatement.setString(3, postal);
				insertStatement.setInt(4, pref);
				insertStatement.setString(5, city);
				insertStatement.setString(6, room);
				insertStatement.setString(7,number);
				insertStatement.setString(8, dateUtil.getDate());
				insertStatement.executeUpdate();
				result = "住所を登録しました。";

			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		try {
			connection.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

}

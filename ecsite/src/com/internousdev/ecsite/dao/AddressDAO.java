package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.ecsite.dto.AddressDTO;
import com.internousdev.ecsite.util.DBConnector;

public class AddressDAO {



	private DBConnector dbConnector = new DBConnector();

	private Connection connection = dbConnector.getConnection();

	AddressDTO dto = new AddressDTO();

	public AddressDTO selectAddressInfoDAO(String userId) {
		// TODO 自動生成されたメソッド・スタブ
		String selectSql = "SELECT * FROM user_address_transaction WHERE user_master_id=?";

		try{
			PreparedStatement preparedStatement = connection.prepareStatement(selectSql);
			preparedStatement.setString(1, userId);
			ResultSet resultSet = preparedStatement.executeQuery();

			if(resultSet.next()){

				dto.setName(resultSet.getString("user_name"));
				dto.setPostal(resultSet.getString("postal_code"));
				dto.setPref(resultSet.getInt("prefectures_code"));
				dto.setCity(resultSet.getString("city"));
				dto.setRoom(resultSet.getString("room"));
				dto.setNumber(resultSet.getString("phone_number"));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		try {
			connection.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return dto;
	}

}

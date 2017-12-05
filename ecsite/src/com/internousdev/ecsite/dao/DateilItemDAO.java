package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.ecsite.dto.ItemDTO;
import com.internousdev.ecsite.util.DBConnector;
public class DateilItemDAO {

	private DBConnector dbConnector = new DBConnector();

	private Connection connection = dbConnector.getConnection();

	private ItemDTO itemDTO = new ItemDTO();


	public ItemDTO getItemDateilInfo(int id) {

		String sql = "SELECT id, item_name, item_price, item_category, item_img FROM item_info_transaction where id=?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);

			ResultSet resultSet = preparedStatement.executeQuery();

			if(resultSet.next()) {
				itemDTO.setId(resultSet.getInt("id"));
				itemDTO.setItemName(resultSet.getString("item_name"));
				itemDTO.setItemPrice(resultSet.getString("item_price"));
				itemDTO.setItemCategory(resultSet.getString("item_category"));
				itemDTO.setItemImg(resultSet.getString("item_img"));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		try {
			connection.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return itemDTO;
	}

}

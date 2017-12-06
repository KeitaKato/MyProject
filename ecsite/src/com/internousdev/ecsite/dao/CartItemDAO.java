package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.ecsite.dto.ItemDTO;
import com.internousdev.ecsite.util.DBConnector;

public class CartItemDAO {

	private DBConnector dbConnector = new DBConnector();

	private Connection connection = dbConnector.getConnection();

	private ItemDTO itemDTO = new ItemDTO();


	public ItemDTO getCartItemInfo(int id) {

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

	public void CartPlus(int id,int total_price, int count, String userId) {

		String selectSql = "SELECT item_transaction_id, user_master_id from user_buy_item_transaction WEHRE item_transaction_id=? AND user_master_id=?";
		String insertSql = "INSERT INTO user_buy_item_transaction(item_transaction_id,toral_price,total_count,user_master_id) VALES(?,?,?,?)";
		String updateSql = "UPDATE user_buy_item_transaction SET item_transaction_id=?, user_master_id=? WHERE item_transaction_id=? AND user_master_id)";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(insertSql);
			preparedStatement.setInt(1, id);
			preparedStatement.setInt(2,total_price );
			preparedStatement.setInt(3,count);
			preparedStatement.setString(4,userId);

			preparedStatement.executeUpdate();
		} catch(SQLException e){
			e.printStackTrace();

		}
		try {
			connection.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}

	}
}

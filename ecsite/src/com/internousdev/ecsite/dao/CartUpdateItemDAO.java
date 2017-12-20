package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;

public class CartUpdateItemDAO {

	private String result;

	public void cartUpdateItem(int id, int totalPrice, int countSelect, String userId){

		DBConnector dbconnector = new DBConnector();
		Connection connection = dbconnector.getConnection();

		String sql = "UPDATE user_cart_item_transaction SET total_price=?, total_count=? WHERE item_transaction_id=? AND user_master_id=?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, totalPrice);
			preparedStatement.setInt(2, countSelect);
			preparedStatement.setInt(3, id);
			preparedStatement.setString(4,userId);

			preparedStatement.executeUpdate();

			result = "変更しました。";

		}catch(SQLException e){
			e.printStackTrace();
		}
		try {
			connection.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}

	}

	public void cartDeleteItem(int id, String userId ) {

		DBConnector dbconnector = new DBConnector();
		Connection connection = dbconnector.getConnection();

		String sql = "DELETE FROM user_cart_item_transaction WHERE item_transaction_id=? AND user_master_id=?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2,userId);

			preparedStatement.executeUpdate();

			setResult("削除しました。");

		}catch(SQLException e){
			e.printStackTrace();
		}
		try {
			connection.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}

	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}


}

package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;

public class CartItemDAO {

	private DBConnector dbConnector = new DBConnector();

	private Connection connection = dbConnector.getConnection();

	private String cartResult;

	String itemStockSql = "SELECT item_stock FROM item_info_transaction WHERE id=?";

	String selectSql = "SELECT * FROM user_buy_item_transaction WHERE item_transaction_id=? AND user_master_id=?";
	String insertSql = "INSERT INTO user_buy_item_transaction(item_transaction_id,total_price,total_count,user_master_id) VALUES(?,?,?,?)";
	String updateSql = "UPDATE user_buy_item_transaction SET total_price=?, total_count=? WHERE item_transaction_id=? AND user_master_id=?";

	String userSelectSql = "SELECT buy_total_price FROM login_user_transaction WHERE login_user_id=?";
	String userInsertSql = "INSERT INTO login_user_transaction(buy_item_price) WHERE login_user_id=? >= ?";
	String userUpdateSql = "UPDATE login_user_transaction SET total_price=? WHERE item_user_id=?";

	public void CartPlus(int id,int total_price, int count, String userId) {

		this.setCartResult("商品を追加できませんでした。");

		try {
			PreparedStatement itemStockPreparedStatement = connection.prepareStatement(itemStockSql);
			itemStockPreparedStatement.setInt(1, id);
			ResultSet itemStockResult = itemStockPreparedStatement.executeQuery();

			if(itemStockResult.next() && itemStockResult.getInt("item_stock") >= count) {
				PreparedStatement selectPreparedStatement = connection.prepareStatement(selectSql);
				selectPreparedStatement.setInt(1, id);
				selectPreparedStatement.setString(2, userId);
				ResultSet resultSet = selectPreparedStatement.executeQuery();

				if(resultSet.next()) {
					PreparedStatement updatePrepareStatement = connection.prepareStatement(updateSql);
					updatePrepareStatement.setInt(1, resultSet.getInt("total_price") + total_price);
					updatePrepareStatement.setInt(2, resultSet.getInt("total_count") + count);
					updatePrepareStatement.setInt(3, id);
					updatePrepareStatement.setString(4, userId);

					updatePrepareStatement.executeUpdate();

				}else {
					PreparedStatement insertPreparedStatement = connection.prepareStatement(insertSql);
					insertPreparedStatement.setInt(1, id);
					insertPreparedStatement.setInt(2,total_price );
					insertPreparedStatement.setInt(3,count);
					insertPreparedStatement.setString(4,userId);

					insertPreparedStatement.executeUpdate();

				}
				PreparedStatement userSelectPreparedStatement = connection.prepareStatement(userSelectSql);
				userSelectPreparedStatement.setString(1,userId);

				ResultSet userSelectResult = userSelectPreparedStatement.executeQuery();
				if(userSelectResult.next() && userSelectResult.getInt("buy_total_price") == 0) {
					PreparedStatement userInsertPreparedStatement = connection.prepareStatement(userInsertSql);
					userInsertPreparedStatement.setString(1, userId);
					userInsertPreparedStatement.setInt(2, resultSet.getInt("total_price"));

					userInsertPreparedStatement.executeUpdate();
				}else if(userSelectResult.next() && userSelectResult.getInt("buy_total_price") != 0) {
						PreparedStatement userUpdatePreapreStatement = connection.prepareStatement(userUpdateSql);
						userUpdatePreapreStatement.setInt(1, userSelectPreparedStatement.getInt("buy_total_price") + );
						userUpdatePreapreStatement.setString(2, userId);


						userUpdatePreapreStatement.executeUpdate();
					}
				}
				this.setCartResult("商品をカートに追加しました。");

			}else {
				this.setCartResult("在庫数を超えていたため追加できませんでした。");
			}

		} catch(SQLException e){
			e.printStackTrace();

		}
		try {
			connection.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}

	}

	public int getUser_total_price(int id, String userId) {

		int total_price = 0;
		try {
		PreparedStatement selectPreparedStatement = connection.prepareStatement(userSelectSql);
		selectPreparedStatement.setString(1, userId);
		ResultSet resultSet = selectPreparedStatement.executeQuery();

			if(resultSet.next()) {
				total_price = resultSet.getInt("buy_total_price");
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		try {
			connection.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return total_price;

	}
	public String getCartResult() {
		return cartResult;
	}

	public void setCartResult(String cartResult) {
		this.cartResult = cartResult;
	}


}

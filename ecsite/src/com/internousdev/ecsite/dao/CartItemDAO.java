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

	private int total_price = 0;

	public void CartPlus(int id,int total_price, int count, String userId) {

		this.setCartResult("商品を追加できませんでした。");

		String itemStockSql = "SELECT item_stock FROM item_info_transaction WHERE id=?"; //アイテムインフォからアイテムストックを検索

		String selectSql = "SELECT * FROM user_buy_item_transaction WHERE item_transaction_id=? AND user_master_id=?";				//カート情報を検索
		String insertSql = "INSERT INTO user_buy_item_transaction(item_transaction_id,total_price,total_count,user_master_id) VALUES(?,?,?,?)";		//カート内商品情報を登録
		String updateSql = "UPDATE user_buy_item_transaction SET total_price=?, total_count=? WHERE item_transaction_id=? AND user_master_id=?";	//カー都内商品情報を更新

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

				String userSelectSql = "SELECT *, sum(total_price) as cart_total_price FROM user_buy_item_transaction WHERE user_master_id= ?;";		//各ユーザーのカート内合計金額を検索

				PreparedStatement userSelectPreparedStatement = connection.prepareStatement(userSelectSql);
				userSelectPreparedStatement.setString(1,userId);

				ResultSet userSelectResult = userSelectPreparedStatement.executeQuery();

				if(userSelectResult.next()) {
					this.total_price = userSelectResult.getInt("cart_total_price");

				}
				this.setCartResult("商品をカートに追加しました。");

			}else {
				this.setCartResult("在庫数を超えていたため追加できませんでした。");
			}

	}catch(SQLException e){
			e.printStackTrace();
		}
		try {
			connection.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
}
	public String getCartResult() {
		return cartResult;
	}

	public void setCartResult(String cartResult) {
		this.cartResult = cartResult;
	}
	public int getTotal_price() {
		return total_price;
	}
	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}

}


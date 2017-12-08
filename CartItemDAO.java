package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.ecsite.dto.CartItemDTO;
import com.internousdev.ecsite.util.DBConnector;

public class CartItemDAO {

	private DBConnector dbConnector = new DBConnector();

	private Connection connection = dbConnector.getConnection();

	private CartItemDTO cartItemDTO = new CartItemDTO();

	private String cartResult;

	public void CartPlus(int id,int total_price, int count, String userId) {

		this.setCartResult("商品を追加できませんでした。");

		String itemStockSql = "SELECT item_stock FROM item_info_transaction WHERE id=?";

		String selectSql = "SELECT * FROM user_buy_item_transaction WHERE item_transaction_id=? AND user_master_id=?";
		String insertSql = "INSERT INTO user_buy_item_transaction(item_transaction_id,total_price,total_count,user_master_id) VALUES(?,?,?,?)";
		String updateSql = "UPDATE user_buy_item_transaction SET total_price=?, total_count=? WHERE item_transaction_id=? AND user_master_id=?";

		String BuyItemSql = "SELECT total_price, total_count FROM user_buy_item_transaction WHERE item_transaction_id=? AND user_master_id=?";

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
				PreparedStatement buyPreparedStatement = connection.prepareStatement(BuyItemSql);
				buyPreparedStatement.setInt(1, id);
				buyPreparedStatement.setString(2, userId);

				ResultSet buyResultSet = buyPreparedStatement.executeQuery();

				cartItemDTO.setTotalPrice(buyResultSet.getInt("total_price"));
				cartItemDTO.setTotalCount(buyResultSet.getInt("total_count"));

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
	public void setCartItemDTO(int id) {

		String itemInfoSql = "SELECT id, item_name, item_price, item_category, item_img FROM item_info_transaction where id=?";

		try {
			PreparedStatement infoPreparedStatement = connection.prepareStatement(itemInfoSql);
			infoPreparedStatement.setInt(1, id);

			ResultSet infoResultSet = infoPreparedStatement.executeQuery();

			if(infoResultSet.next()) {

				cartItemDTO.setId(infoResultSet.getInt("id"));
				cartItemDTO.setItemName(infoResultSet.getString("item_name"));
				cartItemDTO.setItemPrice(infoResultSet.getInt("item_price"));
				cartItemDTO.setItemCategory(infoResultSet.getString("item_category"));
				cartItemDTO.setItemImg(infoResultSet.getString("item_img"));
			}
		} catch(SQLException e) {
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


}

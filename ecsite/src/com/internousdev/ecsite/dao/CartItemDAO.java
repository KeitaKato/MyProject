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

	private String cartResult;


	public ItemDTO getCartItemInfo(int id) {

		String sql = "SELECT id, item_name, item_price, item_category, item_img FROM item_info_transaction where id=?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);

			ResultSet resultSet = preparedStatement.executeQuery();

			if(resultSet.next()) {
				itemDTO.setId(resultSet.getInt("id"));
				itemDTO.setItemName(resultSet.getString("item_name"));
				itemDTO.setItemPrice(resultSet.getInt("item_price"));
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

		this.setCartResult("商品を追加できませんでした。");

		String itemStockSql = "SELECT item_stock FROM item_info_transaction WHERE id=?";
		String selectSql = "SELECT * FROM user_buy_item_transaction WEHRE item_transaction_id=? AND user_master_id=?";
		String insertSql = "INSERT INTO user_buy_item_transaction(item_transaction_id,toral_price,total_count,user_master_id) VALES(?,?,?,?)";
		String updateSql = "UPDATE user_buy_item_transaction SET total_count=? WHERE item_transaction_id=? AND user_master_id)";

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
					updatePrepareStatement.setInt(1, resultSet.getInt("total_count") + count);
					updatePrepareStatement.setInt(2, id);
					updatePrepareStatement.setString(3, userId);

					updatePrepareStatement.executeUpdate();

				}else {
					PreparedStatement insertPreparedStatement = connection.prepareStatement(insertSql);
					insertPreparedStatement.setInt(1, id);
					insertPreparedStatement.setInt(2,total_price );
					insertPreparedStatement.setInt(3,count);
					insertPreparedStatement.setString(4,userId);

					insertPreparedStatement.executeUpdate();

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

	public String getCartResult() {
		return cartResult;
	}

	public void setCartResult(String cartResult) {
		this.cartResult = cartResult;
	}
}

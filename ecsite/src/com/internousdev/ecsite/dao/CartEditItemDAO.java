package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.ecsite.dto.ItemDTO;
import com.internousdev.ecsite.util.DBConnector;

public class CartEditItemDAO {

	private int total_price = 0;


	public List<ItemDTO> cartitemList = new ArrayList<>();

	public List<ItemDTO> getCartEditItemDAOinfo(String userId){

		DBConnector dbconnector = new DBConnector();
		Connection connection = dbconnector.getConnection();

		String cartSql = "SELECT * FROM user_cart_item_transaction WHERE user_master_id=?";
		String infoSql = "SELECT * FROM item_info_transaction WHERE id=?";

		String totalSql = "SELECT *, sum(total_price) as cart_total_price FROM user_cart_item_transaction WHERE user_master_id= ?;";		//各ユーザーのカート内合計金額を検索

		try{
			PreparedStatement cartPreparedStatement = connection.prepareStatement(cartSql);
			cartPreparedStatement.setString(1, userId);
			ResultSet cartResult = cartPreparedStatement.executeQuery();
			while(cartResult.next()){
				ItemDTO dto = new ItemDTO();
				dto.setBuyConut(cartResult.getInt("total_count"));

				PreparedStatement infoPreparedStatement = connection.prepareStatement(infoSql);
				infoPreparedStatement.setInt(1, cartResult.getInt("item_transaction_id"));
				ResultSet infoResult = infoPreparedStatement.executeQuery();
				if(infoResult.next()){

					dto.setId(infoResult.getInt("id"));
					dto.setItemName(infoResult.getString("item_name"));
					dto.setItemPrice(infoResult.getInt("item_price"));
					dto.setItemCategory(infoResult.getString("item_category"));
					dto.setItemImg(infoResult.getString("item_img"));
				}
				cartitemList.add(dto);

				PreparedStatement userSelectPreparedStatement = connection.prepareStatement(totalSql);
				userSelectPreparedStatement.setString(1,userId);

				ResultSet userSelectResult = userSelectPreparedStatement.executeQuery();

				if(userSelectResult.next()) {
					this.setTotal_price(userSelectResult.getInt("cart_total_price"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}



		return cartitemList;
	}

	public int getTotal_price() {
		return total_price;
	}

	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}

}

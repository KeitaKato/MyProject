package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.ecsite.dto.RegiItemDTO;
import com.internousdev.ecsite.util.DBConnector;
import com.internousdev.ecsite.util.DateUtil;

public class RegiCompleteItemDAO {

	private int total_price = 0;

	private DateUtil dateUtil = new DateUtil();


	public List<RegiItemDTO> regiItemList = new ArrayList<>();

	public List<RegiItemDTO> getRegiCompleteItemDAOinfo(String userId){

		DBConnector dbconnector = new DBConnector();
		Connection connection = dbconnector.getConnection();

		String cartSql = "SELECT * FROM user_cart_item_transaction WHERE user_master_id=?";
		String infoSql = "SELECT * FROM item_info_transaction WHERE id=?";

		String regiSql = "INSERT INTO user_buy_item_transaction(item_transaction_id,total_price,total_count,user_master_id,insert_date) values(?,?,?,?,?)";
		String deleSql = "DELETE FROM user_cart_item_transaction WHERE user_master_id=?";

		String totalSql = "SELECT *, sum(total_price) as cart_total_price FROM user_cart_item_transaction WHERE user_master_id= ?;";		//各ユーザーのカート内合計金額を検索

		try{
			PreparedStatement cartPreparedStatement = connection.prepareStatement(cartSql);
			cartPreparedStatement.setString(1, userId);
			ResultSet cartResult = cartPreparedStatement.executeQuery();
			while(cartResult.next()){
				RegiItemDTO dto = new RegiItemDTO();
				dto.setBuyCount(cartResult.getInt("total_count"));
				PreparedStatement regiPreparedStatement = connection.prepareStatement(regiSql);
				regiPreparedStatement.setInt(1,cartResult.getInt("item_transaction_id"));
				regiPreparedStatement.setInt(2, cartResult.getInt("total_price"));
				regiPreparedStatement.setInt(3, cartResult.getInt("total_count"));
				regiPreparedStatement.setString(4, cartResult.getString("user_master_id"));
				regiPreparedStatement.setString(5, dateUtil.getDate());
				regiPreparedStatement.executeUpdate();

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
				regiItemList.add(dto);

				PreparedStatement userSelectPreparedStatement = connection.prepareStatement(totalSql);
				userSelectPreparedStatement.setString(1,userId);

				ResultSet userSelectResult = userSelectPreparedStatement.executeQuery();

				if(userSelectResult.next()) {
					this.setTotal_price(userSelectResult.getInt("cart_total_price"));
				}
			}

			PreparedStatement delePreparedStatement = connection.prepareStatement(deleSql);
			delePreparedStatement.setString(1, userId);

			delePreparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}



		return regiItemList;
	}

	public int getTotal_price() {
		return total_price;
	}

	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}

}


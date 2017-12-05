package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.ecsite.dto.ItemDTO;
import com.internousdev.ecsite.util.DBConnector;

public class ItemDAO {

	public List<ItemDTO> itemList = new ArrayList<>();


	public List<ItemDTO> getItemDAOInfo() {


		DBConnector dbconnector = new DBConnector();
		Connection connection = dbconnector.getConnection();

		String sql = "SELECT id, item_name, item_price, item_category, item_img FROM item_info_transaction";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();


			while(resultSet.next()) {
				ItemDTO dto = new ItemDTO();

				dto.setId(resultSet.getInt("id"));
				dto.setItemName(resultSet.getString("Item_name"));
				dto.setItemPrice(resultSet.getString("item_price"));
				dto.setItemCategory(resultSet.getString("item_category"));
				dto.setItemImg(resultSet.getString("item_img"));
				itemList.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return itemList;
	}

}

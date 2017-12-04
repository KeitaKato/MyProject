package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.ecsite.dto.ItemLineupDTO;
import com.internousdev.ecsite.util.DBConnector;

public class ItemLineupDAO {

	List<ItemLineupDTO> ItemList = new ArrayList<ItemLineupDTO>();


	public List<ItemLineupDTO> select() {


		DBConnector dbconnector = new DBConnector();
		Connection connection = dbconnector.getConnection();

		String sql = "SELECT id, item_name, item_price FROM item_info_trandaction";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();


			while(resultSet.next()) {
				ItemLineupDTO dto = new ItemLineupDTO();

				dto.setId(resultSet.getInt("id"));
				dto.setItemName(resultSet.getString("Item_name"));
				dto.setItemPrice(resultSet.getString("item_price"));
				ItemList.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ItemList;
	}

}

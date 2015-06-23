package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.dto.ProductDTO;

public class ProductDAO {

	private String className = "com.mysql.jdbc.Driver";

	private String url = "jdbc:mysql://localhost/account";
	private String user = "java";
	private String password = "java";

	private String sql = "SELECT prod_no, prod_class_name, prod_name, price"
			+" FROM t_product INNER JOIN m_product_class"
			+" ON t_product.prod_class_code = m_product_class.prod_class_code";

	public ProductDAO() {
		// TODO 自動生成されたコンストラクター・スタブ
		try {
			Class.forName(className);
		} catch (ClassNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

	public ArrayList<ProductDTO> selectProductDTO(){
		System.out.println("selectProductDTO");
		ArrayList<ProductDTO> dtos = new ArrayList<ProductDTO>();

		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {

			connection = DriverManager.getConnection(url, user, password);
			System.out.println("connection");

			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			System.out.println(sql);

			while(resultSet.next()){
				String  prod_no = resultSet.getString("prod_no");
				String  prod_class_name = resultSet.getString("prod_class_name");
				String  prod_name = resultSet.getString("prod_name");
				int  price = resultSet.getInt("price");
				ProductDTO dto = new ProductDTO(prod_no, prod_class_name, prod_name, price);
				dtos.add(dto);
			}
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} finally {
				try {
					if(resultSet != null) resultSet.close();
					if(statement != null) statement.close();
					if(connection != null) connection.close();
					System.out.println("close");
				} catch (SQLException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
		}
		return dtos;
	}
}

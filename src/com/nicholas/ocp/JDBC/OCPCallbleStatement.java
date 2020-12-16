package com.nicholas.ocp.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Properties;

public class OCPCallbleStatement {

	/*
	 * Interface usada para executar stored procedures. Como preparedStatement mas
	 * para stored procedured
	 * 
	 */

	public static void main(String[] args) {
		var url = "jdbc:mysql://localhost:3306/1z0_819_jdbc?useTimezone=true&serverTimezone=UTC";
		Properties properties = new Properties();
		properties.put("user", "root");
		properties.setProperty("password", "xxxx");
		try (var connection = DriverManager.getConnection(url, properties);) {
			inParameter(connection);
			outParameter(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private static void inOUTParameter(Connection connection) {

		var sql = "{call double_number(?)";
		try (var callable = connection.prepareCall(sql)) {
			/*
			 * IN parameter
			 */
			callable.setInt(1, 8);
			/*
			 * OUT Parameter
			 */
			callable.registerOutParameter(1, Types.INTEGER);
			callable.execute();
			System.out.println(callable.getInt("num"));

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void inParameter(Connection con) throws SQLException {
		var sql = "{call read_names_by_letter(?)}";
		try (var cs = con.prepareCall(sql)) {
			cs.setString(1, "N");
			var rs = cs.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getString(2));
			}
			rs.close();

		}
	}

	private static void outParameter(Connection con) throws SQLException {
		var sql = "{?= call magic_number(?)}";
		try (var cs = con.prepareCall(sql)) {

			cs.registerOutParameter(1, Types.INTEGER);
			cs.execute();
			System.out.println(cs.getInt(1));

		}
	}
}

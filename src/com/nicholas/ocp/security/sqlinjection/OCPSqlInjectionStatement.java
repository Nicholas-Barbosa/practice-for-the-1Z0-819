package com.nicholas.ocp.security.sqlinjection;

import java.sql.Connection;
import java.sql.SQLException;

public class OCPSqlInjectionStatement {

	public int resultsWithStatement(Connection connection, String name) throws SQLException {
		var sql = "Select * from user where name = '" + name + "'";
		int rows = 0;
		try (var st = connection.createStatement(); var rs = st.executeQuery(sql)) {
			while (rs.next()) {
				rows++;
			}
		}
		return rows;
	}
}

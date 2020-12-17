package com.nicholas.ocp.security.sqlinjection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class OCPSqlInjection {

	/*
	 * Sql injection e um ataque nao qual um input perigoso, normalmente do usuario,
	 * e executado como um comando no programa. Este ataque pode ocorrer por falta
	 * de seguranca, principalmente usando statement inves de prepared statement com
	 * bind variables.
	 */

	private static final Properties properitesData;
	private static final String jdbcUrl = "jdbc:mysql://localhost:3306/1z0_819_jdbc?useTimezone=true&serverTimezone=UTC";

	static {
		properitesData = new Properties();
		properitesData.put("user", "root");
		properitesData.setProperty("password", "Vicinitech12");
	}

	public static void main(String[] args) {
		OCPSqlInjectionStatement statement = new OCPSqlInjectionStatement();
		OCPSqlInjectionPreparedStatement preparedStatement = new OCPSqlInjectionPreparedStatement();
		
		String param = "Nicholas' or id IS NOT NULL or name ='Cestari";
		
		try (Connection connection = DriverManager.getConnection(jdbcUrl, properitesData)) {
			System.out.println("Maybe SQL Injection: " + statement.resultsWithStatement(connection,param));
			System.out.println("No SQL INJECTION!NOT EXPLOIT! " +preparedStatement.resultsWithPreparedStatement(connection, param));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

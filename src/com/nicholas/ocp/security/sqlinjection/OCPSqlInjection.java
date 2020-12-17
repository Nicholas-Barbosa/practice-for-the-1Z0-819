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
	 * 
	 * Exploit attack, e um ataque que leva vantagem de baixa seguranca
	 */

	private static final Properties PROPERTIES_DATA;
	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/1z0_819_jdbc?useTimezone=true&serverTimezone=UTC";

	static {
		PROPERTIES_DATA = new Properties();
		PROPERTIES_DATA.put("user", "root");
		PROPERTIES_DATA.setProperty("password", "xxx");
	}

	public static void main(String[] args) {
		OCPSqlInjectionStatement statement = new OCPSqlInjectionStatement();
		OCPSqlInjectionPreparedStatement preparedStatement = new OCPSqlInjectionPreparedStatement();
		
		String param = "Nicholas' or id IS NOT NULL or name ='Cestari";
		
		try (Connection connection = DriverManager.getConnection(JDBC_URL, PROPERTIES_DATA)) {
			System.out.println("Maybe SQL Injection: " + statement.resultsWithStatement(connection,param));
			System.out.println("No SQL INJECTION!NOT EXPLOIT! " +preparedStatement.resultsWithPreparedStatement(connection, param));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

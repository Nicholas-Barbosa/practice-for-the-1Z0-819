package com.nicholas.ocp.security.sqlinjection;

import java.sql.Connection;
import java.sql.SQLException;

public class OCPSqlInjectionPreparedStatement {

	/*
	 * prepared statement deve ser utilazada no lugar de statement pelos seguintes
	 * motivos.
	 * 
	 * 1-Performance, as vezes seu programa executa a mesma query varias vezes, o
	 * prepared statement descobre um plano para executar bem o sql e se lembra
	 * dele.Cache
	 * 
	 * 2-Seguranca, previni ataques SQL Injection
	 * 
	 * 3-Legibilidade, ao construir uma query com multiplos parametros, nao ha a
	 * necessidade de concatenar varias Strings. Usamos bind variables, place
	 * holders que nos permite fornecer os valores em tempo de execucao.
	 * 
	 * 4-Mesmo que sua query nao tenha parametros ou so execute uma unica vez, vc
	 * deve usar prepared statament. Futuros editores do codigo nao irao adicionar
	 * novos parametros ou terao de se lembrar de usar prepared statamet.
	 */
	public int resultsWithPreparedStatement(Connection connection, String name) throws SQLException {
		/*
		 * Prepared statement nao faz magica ne! Precisamos mudar para usar binding
		 * variables.
		 * 
		 * var sql = "Select * from user where name = '" + name + "'"; int rows = 0; try
		 * (var st = connection.prepareStatement(sql); var rs = st.executeQuery()) {
		 * while (rs.next()) { rows++; } } return rows;
		 * 
		 * Codigo refatorado com binding variables, lembre-se, nao ha uma regra
		 * especifica enquanto a ordem da especificao das binding variables, mas todas
		 * devem ser setadas!---
		 */
		var sql = "Select * from user where name = ?";
		int rows = 0;
		try (var st = connection.prepareStatement(sql);) {
			st.setString(1, name);
			try (var rs = st.executeQuery()) {
				while (rs.next()) {
					rows++;
				}
			}
		}
		return rows;
	}
}

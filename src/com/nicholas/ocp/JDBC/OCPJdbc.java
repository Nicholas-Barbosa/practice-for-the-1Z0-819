package com.nicholas.ocp.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OCPJdbc {

	/*
	 * Data e informacao. Database e uma collection organizada de dados. Relational
	 * Database e uma database que e organizada em tabelas, que possui rows(linhas)
	 * e columns(colunas).
	 * 
	 * Ha duas formas de acessar uma relational database em java
	 * 
	 * 1-Java Database Connectivy(JDBC) -> Acessa como rows e columns
	 * 
	 * 2-Java Persistence Api(JPA) -> Acessa dados por meio de objetos, usando
	 * conceito chamado object-relational-mapping(ORM)
	 * 
	 * No meio de tudo isso ha Structured Query Language. Sql e uma linguagem de
	 * programacao usada para interagir com registros no banco de dados. O jdbc
	 * trabalha enviando comandos sql pro database e processando o response.
	 * 
	 * URL JDBC, para vc acessar algo, e preciso ter o endereco. No jdb nao e
	 * diferente! Este enedereco e chamado de JDBC URL.
	 * 
	 * JDBC URL e formado por tres partes, protocolo que e sempre JDBC, sub
	 * protocolor cujo e o nome do database,provedor e subname que sao conjuntos de
	 * inforamcoes sobre o database, como locale, etc.
	 * 
	 * jdbc:mysql://localhost....
	 * 
	 * Observe que as tres partes sao separadas por common(:)
	 * 
	 * Key JDBC Interfaces
	 * 
	 * Driver -> Estabelece a conexao com o database
	 * 
	 * Connection -> Envia comandos para o database
	 * 
	 * PreparedStatement -> Executa query sql
	 * 
	 * CallableStatement -> Executa comandos armazenados no database
	 * 
	 * ResulSet -> Le o response de uma query
	 * 
	 */

	public static void main(String[] args) throws SQLException {
		/*
		 * Driver manager examina todos os drivers que encontra, para ver qual pode
		 * manipular esta url e criar uma connection. Caso contrario sera lancado uma
		 * exception
		 */
		try (Connection connection = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/nicholas_spring?useTimezone=true&serverTimezone=UTC", "root",
				"***")) {
			System.out.println("Connection " + connection);
		}

		/*
		 * A implementacao destas key interfaces, sao obtidas com o driver que depende
		 * do seu database. Neste caso e mysql. As vezes as classes de implementacoes da
		 * key interfaces, sao nem public.
		 */
	}
}

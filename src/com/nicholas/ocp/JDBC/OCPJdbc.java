package com.nicholas.ocp.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
	 * 
	 * 
	 */

	public static void main(String[] args) throws SQLException {
		/*
		 * Driver manager examina todos os drivers que encontra, para ver qual pode
		 * manipular esta url e criar uma connection. Caso contrario sera lancado uma
		 * exception
		 */
		try (Connection connection = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/1z0_819_jdbc?useTimezone=true&serverTimezone=UTC", "root",
				"Vicinitech12")) {
			System.out.println("Connection " + connection);
			getPreparedStatement(connection);
			executeQuery(connection);
			execute(connection);
		}

		/*
		 * A implementacao destas key interfaces, sao obtidas com o driver que depende
		 * do seu database. Neste caso e mysql. As vezes as classes de implementacoes da
		 * key interfaces, sao nem public.
		 */
	}

	private static void getPreparedStatement(Connection con) throws SQLException {
		/*
		 * PreparedStatement, CallableStatement sao sub interfaces de Statement.
		 * 
		 * PreparedStatement e Statement sao similares, exceto que PreparedStamenet pega
		 * um parametro e Statament nao.
		 * 
		 * Embora Statement execute SQL query, voce deve usar PreparedStatament pelas
		 * seguintes razoes.
		 * 
		 * Perforance: Muitas vezes nos executamos as mesmas consultas varias vezes. O
		 * prepared statement descobre um plano para executar bem esses sql e se lembra
		 * deles. Cacheia os comandos.
		 * 
		 * Security: Usando prepared statement, vc se protege de ataques SQLs conhecidos
		 * como sql injection.
		 * 
		 * Readable: Nao e preciso concatenar Strings ao construir uma consulta com
		 * muitos parametros.
		 * 
		 * Future use: Mesmo que sua query executa apenas uma vez ou nao tenha
		 * parametros, voce deve usar PreparedStatement. Futuros editores do codigo nao
		 * irao adicionar uma variavel e terao de se lembra de usar o prepared stament
		 * 
		 * metodos de prepared statements para executar instrucoes.
		 * 
		 * int executeUpdate(); -> Instrucoes que mudam dados na tabela, como
		 * INSERT,DELETE,UPDATE usam este metodo.
		 * 
		 * ResultSet executeQuery() -> Pelo proprio nome, executa selects.
		 * 
		 * boolean execute() -> Executa tanto selects tanto metodos que mudam dados.
		 * Retorna true se for um result set ou false se nao for.
		 * 
		 * bind variable e um place holder ou marcados, que nos permite fornecer os
		 * valores reais em tempo de execucao.Como se fosse uma lista de parametros, na
		 * qual voce deve setalos.
		 */

		try (PreparedStatement ps = con.prepareStatement("REPLACE INTO USER VALUES(?,?,?)")) {
			/*
			 * Observe, neste caso os indexs contam apartir de 1!
			 */
			ps.setInt(1, 1);
			ps.setString(2, "Nicholas");
			ps.setString(3, "Barbosa");

			int rows = ps.executeUpdate();
			System.out.println("Linhas modificadas: " + rows);

			ps.setInt(1, 2);
			ps.setString(2, "Cestari");

			rows = ps.executeUpdate();
			System.out.println("Linhas modificadas: " + rows);

			/*
			 * Primeira vantagem do PreparedStatement, neste caso o prepared statement
			 * descobriu um plano para executar o insert e se lembrou dele. Ele meio que
			 * cacheou os parametros ja passados pro bind variable.
			 */
		}
	}

	private static void executeQuery(Connection con) throws SQLException {
		var sql = "SELECT * FROM user";
		try (var ps = con.prepareStatement(sql)) {
			var response = ps.executeQuery();
			resultSet(response);
		}
	}

	private static void execute(Connection con) throws SQLException {
		var sql = "UPDATE user SET last_name=? where id=?";
		try (var ps = con.prepareStatement(sql)) {
			ps.setString(1, "Pastri");
			ps.setInt(2, 2);
			boolean isResultSet = ps.execute();
			if (isResultSet) {
				ps.getResultSet();
			} else {
				System.out.println("linhas modificadas: " + ps.getUpdateCount());
			}
		}
	}

	private static void resultSet(ResultSet rs) throws SQLException {
		/*
		 * Com o result set, obtido de uma preparedStatement com um executeQuery() por
		 * exemplo, conseguimos acessar dados de uam determinada row, buscando pelo
		 * index(comecando com 1) ou o nome da coluna.
		 * 
		 * ResultSet possui um cursor que aponta para a localizacao atual no dado.
		 * 
		 */
		while (rs.next()) {
			System.out.println("ID: " + rs.getInt(1));
			System.out.println("Name: " + rs.getString("name"));
			System.out.println("Last name: " + rs.getString("last_name"));
		}
		/*
		 * Boa pratica verificar se ha elementos disponiveis no ponteiro, se nao houver
		 * o next() ira retornar false. Caso chame um dos metodos getter num ponteiro
		 * sem elementos ou num index ou coluna inexistente, vc ira receber SQLException
		 */
	}
}

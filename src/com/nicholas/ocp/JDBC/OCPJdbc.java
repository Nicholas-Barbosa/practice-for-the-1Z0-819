package com.nicholas.ocp.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.PreparableStatement;

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
				"jdbc:mysql://localhost:3306/nicholas_spring?useTimezone=true&serverTimezone=UTC", "root", "**")) {
			System.out.println("Connection " + connection);
			getPreparedStatement(connection);
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
		 */

		try (PreparedStatement ps = con.prepareStatement("SELECT * FROM tabele")) {
			System.out.println("Ps " + ps);
			/*
			 * PreparedStament representa o SQL, entao voce deve passar um parametro sql a
			 * ele! Nao executamos a query ainda...
			 */
		}
	}
}

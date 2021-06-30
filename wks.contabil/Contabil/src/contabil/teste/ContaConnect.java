package contabil.teste;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ContaConnect {

	public static void main(String[] args) throws SQLException {
		System.out.println("Iniciando...");
		DriverManager.registerDriver(new org.hsqldb.jdbc.JDBCDriver());
		System.out.println("Registrado...");
		Connection conn = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/", "SA", ""); 
		System.out.println("Conectado...");
		Statement stmt = conn.createStatement();
		ResultSet rSet = stmt.executeQuery("SELECT ID, NOME FROM COR");
		System.out.println("EXECUTOU CONSULTA...");
		while(rSet.next()) {
			String id = rSet.getString("ID");
			String nome = rSet.getString("NOME");
			System.out.println(id + ": " + nome);
		}
		rSet.close();
		stmt.close();
		conn.close();
		
	}
	
}

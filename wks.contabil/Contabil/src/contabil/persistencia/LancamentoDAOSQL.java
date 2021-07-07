package contabil.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;

import contabil.model.entity.Lancamento;

public class LancamentoDAOSQL implements LancamentoDAOIF {

	private static final String URI = "jdbc:hsqldb:hsql://localhost/";
	private static final String USER = "SA";
	private static final String PWD = "";
	
	private static final String LANCAMENTO_INSERT = "INSERT INTO LANCAMENTO(data, descricao, valor, credito, debito) VALUES (?, ?, ?, ?, ?)";
	private static final String LANCAMENTO_SELECT_ALL = "SELECT data, descricao, valor, credito, debito FROM LANCAMENTO";

	public LancamentoDAOSQL() throws SQLException {
		DriverManager.registerDriver(new org.hsqldb.jdbc.JDBCDriver());
	}
	
	private Connection getConn() throws SQLException {
		return  DriverManager.getConnection(LancamentoDAOSQL.URI, 
											LancamentoDAOSQL.USER,
											LancamentoDAOSQL.PWD); 
	}	
	
	@Override
	public void salvar(Lancamento l) throws Exception {
		PreparedStatement pStmt = this.getConn().prepareStatement(LANCAMENTO_INSERT);
		pStmt.setDate(1, new java.sql.Date(l.getData().getTime()));
		pStmt.setString(2, l.getDescricao());
		pStmt.setDouble(3, l.getValor());
		pStmt.setString(4, l.getContaCredito().getNome());
		pStmt.setString(5, l.getContaDebito().getNome());
		pStmt.executeUpdate();
	}

	@Override
	public Collection<Lancamento> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}

package contabil.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import contabil.model.TipoConta;
import contabil.model.entity.Ativo;
import contabil.model.entity.Conta;
import contabil.model.entity.Passivo;
import contabil.model.entity.PatrLiquido;
import contabil.model.exception.ContaInexistenteException;

public class ContaDAOSQL implements ContaDAOIF{

	private static final String URI = "jdbc:hsqldb:hsql://localhost/";
	private static final String USER = "SA";
	private static final String PWD = "";
	
	private static final String CONTA_INSERT = "INSERT INTO CONTA(codigo, nome, saldo, tipo) VALUES (?, ?, ?, ?)";
	private static final String CONTA_UPDATE = "UPDATE CONTA SET nome = ?, saldo = ? WHERE codigo = ?";
	private static final String CONTA_SELECT_BYNAME = "SELECT codigo, nome, saldo, tipo FROM CONTA WHERE nome = ?";
	private static final String CONTA_SELECT_ALL = "SELECT codigo, nome, saldo, tipo FROM CONTA";

	public ContaDAOSQL() throws SQLException {
		DriverManager.registerDriver(new org.hsqldb.jdbc.JDBCDriver());
	}
	
	
	
	private Connection getConn() throws SQLException {
		return  DriverManager.getConnection(ContaDAOSQL.URI, ContaDAOSQL.USER, ContaDAOSQL.PWD); 
	}
	
	
	@Override
	public void salvar(Conta c) throws Exception {
		PreparedStatement pStmt = this.getConn().prepareStatement(CONTA_INSERT);
		pStmt.setString(1, c.getCodigo());
		pStmt.setString(2, c.getNome());
		pStmt.setDouble(3, c.getSaldo());
		pStmt.setInt(4, this.getTipoConta(c));
		pStmt.executeUpdate();
	}
	
	private int getTipoConta(Conta c) {
		if(c instanceof Ativo)
			return TipoConta.Ativo.value();
		else if (c instanceof Passivo)
			return TipoConta.Passivo.value();
		else if (c instanceof PatrLiquido)
			return TipoConta.PatrLiquido.value();
		else
			return -1;
	}

	@Override
	public void atualizar(Conta c) throws Exception {
		PreparedStatement pStmt = this.getConn().prepareStatement(CONTA_UPDATE);
		pStmt.setString(1, c.getNome());
		pStmt.setDouble(2, c.getSaldo());
		pStmt.setString(3, c.getCodigo());
		pStmt.executeUpdate();
		
	}

	@Override
	public Conta findByNome(String nome) throws Exception {
		Conta c = null;
		PreparedStatement pStmt = this.getConn().prepareStatement(CONTA_SELECT_BYNAME);
		pStmt.setString(1, nome);
		ResultSet rSet = pStmt.executeQuery();
		if(!rSet.next())
			throw new ContaInexistenteException(nome);
		String codigo = rSet.getString("codigo");
		String sNome = rSet.getString("nome");
		double saldo = rSet.getDouble("saldo");
		int tipo = rSet.getInt("tipo");
		if(tipo == TipoConta.Ativo.value())
			c = new Ativo(codigo, sNome, saldo);
		else if(tipo == TipoConta.Passivo.value())
			c = new Passivo(codigo, sNome, saldo);
		else if(tipo == TipoConta.PatrLiquido.value())
			c = new PatrLiquido(codigo, sNome, saldo);
		return c;
	}

	@Override
	public Collection<Conta> findAll() throws Exception {
		Set<Conta> contas = new HashSet<Conta>();
		PreparedStatement pStmt = this.getConn().prepareStatement(CONTA_SELECT_ALL);
		ResultSet rSet = pStmt.executeQuery();
		while(rSet.next()) {
			Conta c = null;
			String codigo = rSet.getString("codigo");
			String sNome = rSet.getString("nome");
			double saldo = rSet.getDouble("saldo");
			int tipo = rSet.getInt("tipo");
			if(tipo == TipoConta.Ativo.value())
				c = new Ativo(codigo, sNome, saldo);
			else if(tipo == TipoConta.Passivo.value())
				c = new Passivo(codigo, sNome, saldo);
			else if(tipo == TipoConta.PatrLiquido.value())
				c = new PatrLiquido(codigo, sNome, saldo);
			contas.add(c);
		}
		return contas;
	}

	public static void main(String[] args) throws Exception {
		Conta c = new Ativo("1.0", "IMOVEIS", 0);
		ContaDAOSQL dao = new ContaDAOSQL();
		dao.salvar(c);
	}
	
}

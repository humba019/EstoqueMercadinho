package br.com.estoque.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

abstract public class ConexaoBDEstoque {
		
	private static String url = "jdbc:mysql://localhost:3306/estoquecaixa?useSSL=false&useTimezone=true&serverTimezone=UTC";
	private static String usuario = "root";
	private static String senha  = "1234";
	
	public static Connection criarConexao() throws SQLException {
		Connection conexao = null;
		conexao = DriverManager.getConnection(url, usuario, senha);
		return conexao;
	}
}

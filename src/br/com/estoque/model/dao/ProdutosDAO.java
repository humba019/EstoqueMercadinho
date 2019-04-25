package br.com.estoque.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


import br.com.estoque.model.Estoque;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class ProdutosDAO {
	
	public ArrayList<Estoque> listarProdutosLimpeza(){	
		
	Connection con = null; 
	ResultSet rs = null;	
	Statement stmt = null;
	
	String sql = "";
			
	ArrayList<Estoque> listaProdutosLimpeza = new ArrayList<Estoque>();
	try {
		con = ConexaoBDEstoque.criarConexao();
		stmt = con.createStatement();
				
		sql = "select produto.idProd,"+
				"	  produto.nomeProd, " +
			  "       produto.setorProd, " +
			  "       produto.precoProd, " +
			  "       estoque.qtdEst " +				  
		      "from produto, estoque where produto.setorProd = 'Limpeza' and produto.idProd = estoque.idProd;";
		
		rs = stmt.executeQuery(sql);

		while(rs.next()){
			Estoque produto = new Estoque();
			produto.setCodProd(rs.getInt("idProd"));
			produto.setNomeProd(rs.getString("nomeProd"));
			produto.setSetorProd(rs.getString("setorProd"));
			produto.setPrecoProd(rs.getFloat("precoProd"));
			produto.setQtdEst(rs.getInt("qtdEst"));
						
			// Armazena o objeto no ArrayList
			listaProdutosLimpeza.add(produto);
		
			
			
			produto = null;
		}
		
	} catch (SQLException erro) { // Trata possiveis erros de SQL 
		erro.printStackTrace();
	} catch (Exception erro) { 
		erro.printStackTrace();
	} finally{ 			
		try{
			// Finaliza o ResultSet
			if(rs != null)  rs.close();
			// Finaliza o Statement
			if(stmt != null) stmt.close();
			// Finaliza a Connection 
			if(con != null) con.close();					
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	// Retorna o ArrayList carregado com objetos contento os dados do ResultSet
	return listaProdutosLimpeza;
	}

	
	//Frios

	public ArrayList<Estoque> listarProdutosFrios(){	
		
	Connection con = null; 
	ResultSet rs = null;	
	Statement stmt = null;
	
	String sql = "";
			
	ArrayList<Estoque> listaProdutosFrios = new ArrayList<Estoque>();
	try {
		con = ConexaoBDEstoque.criarConexao();
		stmt = con.createStatement();
				
		sql = "select produto.idProd,"+
				"	  produto.nomeProd, " +
			  "       produto.setorProd, " +
			  "       produto.precoProd, " +
			  "       estoque.qtdEst " +				  
		      "from produto, estoque where produto.setorProd = 'Frios' and produto.idProd = estoque.idProd;";
		
		rs = stmt.executeQuery(sql);

		while(rs.next()){
			Estoque produto = new Estoque();
			produto.setCodProd(rs.getInt("idProd"));
			produto.setNomeProd(rs.getString("nomeProd"));
			produto.setSetorProd(rs.getString("setorProd"));
			produto.setPrecoProd(rs.getFloat("precoProd"));
			produto.setQtdEst(rs.getInt("qtdEst"));
						
			// Armazena o objeto no ArrayList
			listaProdutosFrios.add(produto);
		
			
			
			produto = null;
		}
		
	} catch (SQLException erro) { // Trata possiveis erros de SQL 
		erro.printStackTrace();
	} catch (Exception erro) { 
		erro.printStackTrace();
	} finally{ 			
		try{
			// Finaliza o ResultSet
			if(rs != null)  rs.close();
			// Finaliza o Statement
			if(stmt != null) stmt.close();
			// Finaliza a Connection 
			if(con != null) con.close();					
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	// Retorna o ArrayList carregado com objetos contento os dados do ResultSet
	return listaProdutosFrios;
	}


	//Massas Grãos

	public ArrayList<Estoque> listarProdutosMasGra(){	
		
	Connection con = null; 
	ResultSet rs = null;	
	Statement stmt = null;
	
	String sql = "";
			
	ArrayList<Estoque> listaProdutosMasGra = new ArrayList<Estoque>();
	try {
		con = ConexaoBDEstoque.criarConexao();
		stmt = con.createStatement();
				
		sql = "select produto.idProd,"+
				"	  produto.nomeProd, " +
			  "       produto.setorProd, " +
			  "       produto.precoProd, " +
			  "       estoque.qtdEst " +				  
		      "from produto, estoque where produto.setorProd = 'Massas e Grãos' and produto.idProd = estoque.idProd;";
		
		rs = stmt.executeQuery(sql);

		while(rs.next()){
			Estoque produto = new Estoque();
			produto.setCodProd(rs.getInt("idProd"));
			produto.setNomeProd(rs.getString("nomeProd"));
			produto.setSetorProd(rs.getString("setorProd"));
			produto.setPrecoProd(rs.getFloat("precoProd"));
			produto.setQtdEst(rs.getInt("qtdEst"));
						
			// Armazena o objeto no ArrayList
			listaProdutosMasGra.add(produto);
		
			
			
			produto = null;
		}
		
	} catch (SQLException erro) { // Trata possiveis erros de SQL 
		erro.printStackTrace();
	} catch (Exception erro) { 
		erro.printStackTrace();
	} finally{ 			
		try{
			// Finaliza o ResultSet
			if(rs != null)  rs.close();
			// Finaliza o Statement
			if(stmt != null) stmt.close();
			// Finaliza a Connection 
			if(con != null) con.close();					
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	// Retorna o ArrayList carregado com objetos contento os dados do ResultSet
	return listaProdutosMasGra;
	}
	
	
	//Molhos Ervas

		public ArrayList<Estoque> listarProdutosMolErv(){	
			
		Connection con = null; 
		ResultSet rs = null;	
		Statement stmt = null;
		
		String sql = "";
				
		ArrayList<Estoque> listaProdutosMolErv = new ArrayList<Estoque>();
		try {
			con = ConexaoBDEstoque.criarConexao();
			stmt = con.createStatement();
					
			sql = "select produto.idProd,"+
					"	  produto.nomeProd, " +
				  "       produto.setorProd, " +
				  "       produto.precoProd, " +
				  "       estoque.qtdEst " +				  
			      "from produto, estoque where produto.setorProd = 'Molhos e Ervas' and produto.idProd = estoque.idProd;";
			
			rs = stmt.executeQuery(sql);

			while(rs.next()){
				Estoque produto = new Estoque();
				produto.setCodProd(rs.getInt("idProd"));
				produto.setNomeProd(rs.getString("nomeProd"));
				produto.setSetorProd(rs.getString("setorProd"));
				produto.setPrecoProd(rs.getFloat("precoProd"));
				produto.setQtdEst(rs.getInt("qtdEst"));
							
				// Armazena o objeto no ArrayList
				listaProdutosMolErv.add(produto);
			
				
				
				produto = null;
			}
			
		} catch (SQLException erro) { // Trata possiveis erros de SQL 
			erro.printStackTrace();
		} catch (Exception erro) { 
			erro.printStackTrace();
		} finally{ 			
			try{
				// Finaliza o ResultSet
				if(rs != null)  rs.close();
				// Finaliza o Statement
				if(stmt != null) stmt.close();
				// Finaliza a Connection 
				if(con != null) con.close();					
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		// Retorna o ArrayList carregado com objetos contento os dados do ResultSet
		return listaProdutosMolErv;
		}
		

		//Bebidas

		public ArrayList<Estoque> listarProdutosBebidas(){	
			
		Connection con = null; 
		ResultSet rs = null;	
		Statement stmt = null;
		
		String sql = "";
				
		ArrayList<Estoque> listaProdutosBebidas = new ArrayList<Estoque>();
		try {
			con = ConexaoBDEstoque.criarConexao();
			stmt = con.createStatement();
					
			sql = "select produto.idProd,"+
					"	  produto.nomeProd, " +
				  "       produto.setorProd, " +
				  "       produto.precoProd, " +
				  "       estoque.qtdEst " +				  
			      "from produto, estoque where produto.setorProd = 'Bebidas' and produto.idProd = estoque.idProd;";
			
			rs = stmt.executeQuery(sql);

			while(rs.next()){
				Estoque produto = new Estoque();
				produto.setCodProd(rs.getInt("idProd"));
				produto.setNomeProd(rs.getString("nomeProd"));
				produto.setSetorProd(rs.getString("setorProd"));
				produto.setPrecoProd(rs.getFloat("precoProd"));
				produto.setQtdEst(rs.getInt("qtdEst"));
							
				// Armazena o objeto no ArrayList
				listaProdutosBebidas.add(produto);
			
				
				
				produto = null;
			}
			
		} catch (SQLException erro) { // Trata possiveis erros de SQL 
			erro.printStackTrace();
		} catch (Exception erro) { 
			erro.printStackTrace();
		} finally{ 			
			try{
				// Finaliza o ResultSet
				if(rs != null)  rs.close();
				// Finaliza o Statement
				if(stmt != null) stmt.close();
				// Finaliza a Connection 
				if(con != null) con.close();					
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		// Retorna o ArrayList carregado com objetos contento os dados do ResultSet
		return listaProdutosBebidas;
		}		
		
		

		public void inserir(Estoque estoque) {
			//DateTimeFormatter formatador = DateTimeFormatter.ofPattern("yyyy/MM/dd");

			// Declaração de referências JDBC
			Connection con = null; 
			PreparedStatement pstmt = null;
			PreparedStatement pstmt2 = null;
			//PreparedStatement pstmt3 = null;
			
			// Declaração de variável
			String sql = "";			
			String sql2= "";
			
			try {			
				// Estabelece a conexão
				con = ConexaoBDEstoque.criarConexao();
				
				// A classe PreparedStatement permite a inserção 
				// de parâmetros (?) na construção da string de SQL			
				sql = "insert into .produto(nomeProd, " +   			                        
				      "		                   precoProd, " +
				      "		                   setorProd)"+
				      "		           values (?, " + 
				      "		                   ?, " +
				      "		                   ?);";

				pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);	
				pstmt.setString(1, estoque.getNomeProd());				
				pstmt.setDouble(2, estoque.getPrecoProd());			
				pstmt.setString(3, estoque.getSetorProd());

				pstmt.executeUpdate();
				int idprod = 0;
				ResultSet rs = pstmt.getGeneratedKeys();
				while (rs.next()) {
					idprod = rs.getInt(1);
				}

				sql2 = "insert into .estoque(qtdEst,"
									+ "      entradaEst,"								      
									+ "      idProd)"
									+ " values (?,"
									+ "			?,"
									+ "		    ?);";
				
				pstmt2 = con.prepareStatement(sql2);				
				pstmt2.setInt(1, estoque.verificaTotalEst());			
				pstmt2.setInt(2, estoque.getQtdEst());
				pstmt2.setInt(3, idprod);

				pstmt2.executeUpdate();
				pstmt.close();
				pstmt2.close();
				
			} catch (SQLException e) {
				
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Erro!");
				alert.setHeaderText("Operação não pode ser realizada");
				alert.setContentText("A inserção não pôde ser concluida.");
				alert.showAndWait();				
				
				e.printStackTrace();

			} catch (Exception erro) { 
				erro.printStackTrace();
			} finally{ 			
				try{
					if(pstmt != null) pstmt.close();
					if(pstmt2 != null) pstmt2.close();
					if(con != null) con.close();					
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		
		
		
		public void alterar(Estoque estoque) {
			
			Connection con = null; 
			PreparedStatement pstmt = null;
			String sql = "";
			//ResultSet rs= null;
			int  prodAlterado = 0, estAlterado = 0; 

			try {
				con = ConexaoBDEstoque.criarConexao();	
				con.setAutoCommit(false);
					/*
				sql = "select idProd from produto where nomeProd =?;";

				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, estoque.getNomeProd());
				
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					idProd = rs.getInt("idProd");
				}				
					*/

				sql = "update estoquecaixa.estoque set estoque.qtdEst = ?"
						+ " where estoque.idProd = ?;";

				pstmt = con.prepareStatement(sql);
				
				pstmt.setInt(1, estoque.getQtdEst());
				pstmt.setInt(2, estoque.getCodProd());
				
				prodAlterado = pstmt.executeUpdate();
				
				sql = "update estoquecaixa.produto set produto.nomeProd = ?, " +                           
				      "                           produto.setorProd = ?, " +
				      "                           produto.precoProd = ? " +
				      " where produto.idProd = ?;";
				
				pstmt = con.prepareStatement(sql);	
				
				pstmt.setString(1, estoque.getNomeProd());
				pstmt.setString(2,  estoque.getSetorProd());
				pstmt.setDouble(3, estoque.getPrecoProd());
				pstmt.setInt(4,  estoque.getCodProd());

				estAlterado = pstmt.executeUpdate();
				
				pstmt.close();
				
				if(prodAlterado == 1 && estAlterado == 1) {
					con.commit();
				}else {
					con.rollback();
					
					throw new Exception();
				}
				
			} catch (SQLException e) {
				
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Atenção");
				alert.setHeaderText("Erro durante operação.");
				alert.setContentText("A alteração não pôde ser concluida.");
				alert.showAndWait();				
				
				e.printStackTrace();
				
			} catch (Exception erro) { 
				erro.printStackTrace();
				
			} finally{ 			
				try{
					if(pstmt != null) pstmt.close();
					if(con != null) con.close();					
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		
		public void excluir(Estoque estoque) {
			
			Connection con = null;
			PreparedStatement ps = null;
			
			
			String sql = "";
			int estoqueExcluido = 0, produtoExcluido = 0;
			try {
				
				con =  ConexaoBDEstoque.criarConexao();
				con.setAutoCommit(false);
				
				sql = "delete from estoquecaixa.estoque where estoque.idProd = ?;";
				ps = con.prepareStatement(sql);
				ps.setInt(1, estoque.getCodProd());
				
				estoqueExcluido = ps.executeUpdate();
								
				sql = "delete from estoquecaixa.produto where produto.idProd = ?;";
				ps = con.prepareStatement(sql);
				ps.setInt(1, estoque.getCodProd());
				
				produtoExcluido = ps.executeUpdate();
				
							
				if(estoqueExcluido == 1 && produtoExcluido == 1) {
					con.commit();

					ps.close();	
				}else {
					con.rollback();

					ps.close();	
					throw new Exception();
				}

			}catch (SQLException e) {
				
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Erro!");
				alert.setHeaderText("Operação não pode ser realizada");
				alert.setContentText("A exclusão não pôde ser concluida.");
				alert.showAndWait();				
				
				e.printStackTrace();
				
			} catch (Exception erro) { 
				erro.printStackTrace();
				
			} finally{ 			
				try{
					if(ps != null) ps.close();
					if(con != null) con.close();					
				}catch(Exception e){
					e.printStackTrace();
				}
			}
			
		}
	
	
}

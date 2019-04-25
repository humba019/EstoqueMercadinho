package br.com.estoque.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.com.estoque.model.Caixa;
import br.com.estoque.model.Estoque;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class CaixaDAO {
	
	//Metodo que armazena a data e hora atual da maquina
	private String getDateTime() {	
		Date dataHoraAtual = new Date();
		String data = new SimpleDateFormat("dd/MM/yyyy").format(dataHoraAtual);
		String hora = new SimpleDateFormat("HH:mm:ss").format(dataHoraAtual);
		return data +" " + hora; 
	}
	
	public void inserir(Caixa caixa) {

		// Declaração de referências JDBC
		Connection con = null; 
		PreparedStatement pstmt = null;
		
		//Declaração de variável
		String sql = "";
		int vendaInserida = 0;
		
		try {			
			
			con = ConexaoBDEstoque.criarConexao();
			con.setAutoCommit(false);
			
			//Codigo do Funcionario
			/*
			sql = "select idFun from funcionario where nomeFun = ?;";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, caixa.getNomeFun());
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				codigoFun = rs.getInt("idFun");
			}
			*/
			//Codigo do Produto
			
			//Insere o valor confirmado no caixa juntamente com a data e hora da operação
			sql = "insert into .venda(totalVen, dataVen) values (?,?);";
			
			//Prepara a string sql para receber atributos externos
			pstmt = con.prepareStatement(sql);
			pstmt.setDouble(1, caixa.getTotalCai());
			pstmt.setString(2, this.getDateTime());
			
			//Armazena resultado do insert na variavel vendaInserida do tipo INT sendo 1 ou 0
			vendaInserida = pstmt.executeUpdate();		
		
			//Fehca a preparação
			pstmt.close();
			
			//Verifica se o update foi completo(1) ou incompleto(0) com base na variavel vendaInserida 
			if(vendaInserida == 1) {
				
				con.commit();
				
			}else {
				
				con.rollback();
				
				throw new  Exception();
			}
			
			//Erro de operação SQL, dados incorretos				
			} catch (SQLException e) {
				
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Erro!");
				alert.setHeaderText("Operação não pode ser realizada");
				alert.setContentText("A inserção não pôde ser concluida.");
				alert.showAndWait();				
				
				e.printStackTrace();
			
			try {
				con.rollback();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
			//Descrição do erro de update
			} catch (Exception erro) { 
				
				erro.printStackTrace();
			
			//Finaliza atributos que ainda estejam abertos
			} finally{ 			
				try{
					if(pstmt != null) pstmt.close();
					if(con != null) con.close();					
				}catch(Exception e){
					e.printStackTrace();
				}
			}
	}
	
	public void alterar(Estoque estoque) {

		// Declaração de referências JDBC
		Connection con = null; 
		PreparedStatement pstmt = null;
		//ResultSet rs = null;
		//Declaração de variável
		String sql = "";
		int estoqueAlterado = 0;
		
		try {			
			
			con = ConexaoBDEstoque.criarConexao();
			con.setAutoCommit(false);
			
			//Codigo do Produto
			//Seleciona o id do produto com base no nome.
			/*
			sql = "select idProd from produto where nomeProd = ?;";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, estoque.getNomeProd());
			
			rs = pstmt.executeQuery();
			
			//Armazena resultado do select na variavel codigoProd do tipo INT
			if(rs.next()) {
				codigoProd = rs.getInt("idProd");
			}
			*/
			/*
			sql = "select qtdEst, saidaEst from estoque where idProd = ?;";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, codigoProd);
			
			if(rs.next()) {
				qtdProd = rs.getInt("qtdEst");
				saidaProd = rs.getInt("saidaEst");
			}
			*/
			
			//Update que irá atualizar o atributo saida de estoque e verificar condição para inserir.
			sql = "update estoquecaixa.estoque set estoque.entradaEst = ?,"
					+ "								estoque.saidaEst = estoque.saidaEst+?"
					+ " where idProd = ?;";
			
			//Prepara a string sql para receber atributos externos
			pstmt = con.prepareStatement(sql);
			
			//Insere os atributos na String SQL.
			pstmt.setInt(1, estoque.getEntradaEst());
			pstmt.setInt(2, estoque.getSaidaEst());
			pstmt.setInt(3, estoque.getCodProd());
			
			//Armazena na variavel estoqueAlterado do tipo INT o resultado do update 1 ou 0 
			estoqueAlterado = pstmt.executeUpdate();
			
			//Fecha a preparação de atributos
			pstmt.close();
			
			//Se o resultado do update for igual a Um commit sera instanciado com a conexão
			if(estoqueAlterado == 1) {
				
				con.commit();
				
			}
			//Se não a conexão será reestabelecida e apresentará um alert indicativo
			else {
				
				con.rollback();
								
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Limite de dados!"+ estoque.getCodProd());
				alert.setHeaderText("O produto não pôde ser inserido");
				alert.setContentText("Limite maximo atingido\nInsira mais produtos no estoque.");
				alert.showAndWait();				
				
				throw new Exception();
			}
		//Erro de operação SQL, dados incorretos				
		} catch (SQLException e) {
			
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Erro!");
			alert.setHeaderText("Operação não pode ser realizada");
			alert.setContentText("A atualização não pôde ser concluida.");
			alert.showAndWait();				
			
			e.printStackTrace();
			
			try {
				
				con.rollback();
				
			} catch (Exception e1) {
				
				e1.printStackTrace();
				
			}
		//Descrição do erro de update
		} catch (Exception erro) {
			
			erro.printStackTrace();
			
		//Finaliza atributos que ainda estejam abertos
		}finally{ 			
			try{
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();					
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	public void alterar2(Estoque estoque) {

		// Declaração de referências JDBC
		Connection con = null; 
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		//Declaração de variável
		String sql = "";
		int codigoProd = 0, estoqueAlterado = 0;
		
		try {			
			
			con = ConexaoBDEstoque.criarConexao();
			con.setAutoCommit(false);
			
			//Codigo do Produto
			//Seleciona o id do produto com base no nome.
			sql = "select idProd from produto where nomeProd = ?;";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, estoque.getNomeProd());
			
			rs = pstmt.executeQuery();
			
			//Armazena resultado do select na variavel codigoProd do tipo INT
			if(rs.next()) {
				codigoProd = rs.getInt("idProd");
			}
			/*
			sql = "select qtdEst, saidaEst from estoque where idProd = ?;";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, codigoProd);
			
			if(rs.next()) {
				qtdProd = rs.getInt("qtdEst");
				saidaProd = rs.getInt("saidaEst");
			}
			*/
			
			//Update que irá atualizar o atributo saida de estoque e verificar condição para inserir.
			sql = "update estoquecaixa.estoque set estoque.entradaEst = ?,"
					+ "								estoque.saidaEst = estoque.saidaEst-? "
					+ " where idProd = ? and estoque.saidaEst <= estoque.qtdEst;";
			
			//Prepara a string sql para receber atributos externos
			pstmt = con.prepareStatement(sql);
			
			//Insere os atributos na String SQL.
			pstmt.setInt(1, estoque.getEntradaEst());
			pstmt.setInt(2, estoque.getSaidaEst());
			pstmt.setInt(3, codigoProd);
			
			//Armazena na variavel estoqueAlterado do tipo INT o resultado do update 1 ou 0 
			estoqueAlterado = pstmt.executeUpdate();
			
			//Fecha a preparação de atributos
			pstmt.close();
			
			//Se o resultado do update for igual a Um commit sera instanciado com a conexão
			if(estoqueAlterado == 1) {
				
				con.commit();
				
			}
			//Se não a conexão será reestabelecida e apresentará um alert indicativo
			else {
				
				con.rollback();
								
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Limite de dados!");
				alert.setHeaderText("O produto não pôde ser inserido");
				alert.setContentText("Limite maximo atingido\nInsira mais produtos no estoque.");
				alert.showAndWait();				
				
				throw new Exception();
			}
		//Erro de operação SQL, dados incorretos				
		} catch (SQLException e) {
			
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Erro!");
			alert.setHeaderText("Operação não pode ser realizada");
			alert.setContentText("A atualização não pôde ser concluida.");
			alert.showAndWait();				
			
			e.printStackTrace();
			
			try {
				
				con.rollback();
				
			} catch (Exception e1) {
				
				e1.printStackTrace();
				
			}
		//Descrição do erro de update
		} catch (Exception erro) {
			
			erro.printStackTrace();
			
		//Finaliza atributos que ainda estejam abertos
		}finally{ 			
			try{
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();					
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}	
	
	public void verifica(Estoque estoque) {

		// Declaração de referências JDBC
		Connection con = null; 
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		//Declaração de variável
		String sql = "";
		int qtdProd = 0, saidaProd = 0;
		
		try {			
			
			con = ConexaoBDEstoque.criarConexao();
			
			//Codigo do Produto
			//Seleciona o id do produto com base no nome.
			/*
			sql = "select idProd from produto where nomeProd = ?;";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, estoque.getNomeProd());
			
			rs = pstmt.executeQuery();
			//Armazena resultado do select na variavel codigoProd do tipo INT
			if(rs.next()) {
				codigoProd = rs.getInt("idProd");
			}			
			*/
			
			sql = "select qtdEst, saidaEst from estoque where idProd = ?;";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, estoque.getCodProd());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				qtdProd = rs.getInt("qtdEst");
				saidaProd = rs.getInt("saidaEst");
			}
			
			int total = 0;
			for(int i =  estoque.getSaidaEst(); i <= qtdProd; i++) {
				
				 total = i+saidaProd;

					if(total <= qtdProd) {
						/*
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("Limite de dados! Total: "+total+" Estoque:"+qtdProd);
						alert.setHeaderText("O produto não pôde ser inserido");
						alert.setContentText("Limite maximo atingido\nInsira mais produtos no estoque.");
						alert.showAndWait();*/
						throw new Exception();
						
					}else {
						Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("Limite de dados!");
					alert.setHeaderText("O produto não pôde ser inserido");
					alert.setContentText("Limite maximo atingido, quantidade inserida: "+total+" e quantidade total: "+qtdProd+".\nInsira mais produtos no estoque.");
					alert.showAndWait();
					throw new Exception();
					}	
			}

			pstmt.close();
			
		//Erro de operação SQL, dados incorretos				
		} catch (SQLException e) {
			
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Erro!");
			alert.setHeaderText("Operação não pode ser realizada");
			alert.setContentText("A atualização não pôde ser concluida.");
			alert.showAndWait();				
			
			e.printStackTrace();
			
			try {
				
				con.rollback();
				
			} catch (Exception e1) {
				
				e1.printStackTrace();
				
			}
		//Descrição do erro de update
		} catch (Exception erro) {
			
			erro.printStackTrace();
			
		//Finaliza atributos que ainda estejam abertos
		}finally{ 			
			try{
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();					
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}		
			
}
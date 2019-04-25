package br.com.estoque.controller;


import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.estoque.model.dao.ConexaoBDEstoque;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Inicial extends Application {
	
	@Override
	public void start(Stage primaryStage) throws Exception{
		
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/br/com/estoque/view/index.fxml"));
		BorderPane nodeRoot = loader.load();
		Scene scene = new Scene(nodeRoot);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		
		try {
			ConexaoBDEstoque.criarConexao();
			
			launch(args);
			
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Falha na Conexão.");
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}

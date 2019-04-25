package br.com.estoque.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import br.com.estoque.model.Caixa;
import br.com.estoque.model.Estoque;
import br.com.estoque.model.dao.CaixaDAO;
import br.com.estoque.model.dao.ProdutosDAO;
import br.com.estoque.model.tableview.CaixaTableViewModel;
import br.com.estoque.model.tableview.ProdutosTableViewModel;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TabPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.scene.control.TableColumn;
import javafx.scene.layout.Pane;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class indexController implements Initializable{
	private Stage palcoIndex;
	private ArrayList<ProdutosTableViewModel> listaProdutostvModel = new ArrayList<ProdutosTableViewModel>();
	private ArrayList<CaixaTableViewModel> listaCaixatvModel = new ArrayList<CaixaTableViewModel>();
	private Stage palcoProdutos;
	private String operacao;
	
	@FXML MenuBar menuPrincipal;
	@FXML MenuItem menuSair;
	@FXML TabPane tabPaneProdutos;
	@FXML Tab tabLimpeza;
	@FXML TableView<ProdutosTableViewModel> tvLimpeza;
	@FXML TableColumn<ProdutosTableViewModel, Integer> idLim;
	@FXML TableColumn<ProdutosTableViewModel, Integer> qtdLim;
	@FXML TableColumn<ProdutosTableViewModel, String> nomeLim;
	@FXML TableColumn<ProdutosTableViewModel, Double> precoLim;
	@FXML Tab tabFrios;
	@FXML TableView<ProdutosTableViewModel> tvFrios;
	@FXML TableColumn<ProdutosTableViewModel, Integer> idFri;
	@FXML TableColumn<ProdutosTableViewModel, Integer> qtdFri;
	@FXML TableColumn<ProdutosTableViewModel, String> nomeFri;
	@FXML TableColumn<ProdutosTableViewModel, Double> precoFri;
	@FXML Tab tabMasGra;
	@FXML TableView<ProdutosTableViewModel> tvMasGra;
	@FXML TableColumn<ProdutosTableViewModel, Integer> idMG;
	@FXML TableColumn<ProdutosTableViewModel, Integer> qtdMG;
	@FXML TableColumn<ProdutosTableViewModel, String> nomeMG;
	@FXML TableColumn<ProdutosTableViewModel, Double> precoMG;
	@FXML Tab tabMolErv;
	@FXML TableView<ProdutosTableViewModel> tvMolErv;
	@FXML TableColumn<ProdutosTableViewModel, Integer> idME;
	@FXML TableColumn<ProdutosTableViewModel, Integer> qtdME;
	@FXML TableColumn<ProdutosTableViewModel, String> nomeME;
	@FXML TableColumn<ProdutosTableViewModel, Double> precoME;
	@FXML Tab tabBebidas;
	@FXML TableView<ProdutosTableViewModel> tvBebidas;
	@FXML TableColumn<ProdutosTableViewModel, Integer> idBe;
	@FXML TableColumn<ProdutosTableViewModel, Integer> qtdBe;
	@FXML TableColumn<ProdutosTableViewModel, String> nomeBe;
	@FXML TableColumn<ProdutosTableViewModel, Double> precoBe;
	//Formulario CRUD

	@FXML TextField tfNome;
	@FXML TextField tfPreco;
	@FXML TextField tfQtd;
	@FXML ComboBox<String> cbSetor;
	@FXML Button btInsert;
	@FXML Button btCancel;
	@FXML Button btUpdate;
	@FXML Button btConfirm;
	@FXML Button btClose;
	@FXML Button btDelete;
	@FXML Button btEstoque;
	@FXML Button btCaixa;	
	@FXML Pane formCrud;
	@FXML MenuItem menuRefresh;
	
	//Caixa

	@FXML Label tfTotal;
	@FXML Button bConfirmaProd;
	@FXML Spinner<Integer> spQtdProd;
	@FXML Label lNomeProd;
	@FXML Label lCodProd;
	@FXML Label lPrecoProd;
	@FXML Pane formCaixa;
	
	//Tabela Caixa 
	@FXML ListView<String> lvCarrinho;
	@FXML Button addCart;
	@FXML Button removeCart;
	@FXML Label lTotalCarrinho;

	Estoque estoque =  new Estoque();
	Caixa caixa = new Caixa();
	
	//Metodos 
	public Stage getPalcoIndex() {
		return palcoIndex;
	}
	public ArrayList<CaixaTableViewModel> getListaCaixatvModel() {
		return listaCaixatvModel;
	}
	public void setListaCaixatvModel(ArrayList<CaixaTableViewModel> listaCaixatvModel) {
		this.listaCaixatvModel.addAll(listaCaixatvModel);
	}
	public void setListaCaixatvModel(CaixaTableViewModel caixaTableViewModel) {
		this.listaCaixatvModel.add(caixaTableViewModel);
	}
	public void setPalcoIndex(Stage palcoIndex) {
		this.palcoIndex = palcoIndex;
	}
	public ArrayList<ProdutosTableViewModel> getListaProdutostvModel() {
		return listaProdutostvModel;
	}
	public void setListaProdutostvModel(ArrayList<ProdutosTableViewModel> listaProdutostvModel) {
		this.listaProdutostvModel.addAll(listaProdutostvModel);
	}
	public void setListaProdutostvModel(ProdutosTableViewModel produtosTbaleViewModel) {
		this.listaProdutostvModel.add(produtosTbaleViewModel);
	}
	
	public Stage getPalcoProdutos() {
		return palcoProdutos;
	}


	public void setPalcoProdutos(Stage palcoProdutos) {
		this.palcoProdutos = palcoProdutos;
	}


	public String getOperacao() {
		return operacao;
	}


	public void setOperacao(String operacao) {
		this.operacao = operacao;
	}
	
	//Objeto DAO
	ProdutosDAO produtosDAO = new ProdutosDAO();
	
	//Arrays de Esquematização das abas de produtos
	//Primeiro ARRAY
	public ArrayList<ProdutosTableViewModel> carregaProdutosTableViewModel1(){
		
		this.getListaProdutostvModel().clear();
		
		for(Estoque produto : produtosDAO.listarProdutosLimpeza()) {
			ProdutosTableViewModel  prodTVModel = new ProdutosTableViewModel();
			
			prodTVModel.setpCodigo(produto.getCodProd());
			prodTVModel.setpNome(produto.getNomeProd());
			prodTVModel.setpPreco(produto.getPrecoProd());
			prodTVModel.setpQtd(produto.getQtdEst());
			
			this.setListaProdutostvModel(prodTVModel);
		}
		return this.getListaProdutostvModel();
	}
	//Segundoo ARRAY
	public ArrayList<ProdutosTableViewModel> carregaProdutosTableViewModel2(){
		
		this.getListaProdutostvModel().clear();
		
		for(Estoque produto : produtosDAO.listarProdutosFrios()) {
			ProdutosTableViewModel  prodTVModel = new ProdutosTableViewModel();

			prodTVModel.setpCodigo(produto.getCodProd());
			prodTVModel.setpNome(produto.getNomeProd());
			prodTVModel.setpPreco(produto.getPrecoProd());
			prodTVModel.setpQtd(produto.getQtdEst());
			
			this.setListaProdutostvModel(prodTVModel);
		}
		return this.getListaProdutostvModel();
	}
	//Terceiro ARRAY
	public ArrayList<ProdutosTableViewModel> carregaProdutosTableViewModel3(){
		
		this.getListaProdutostvModel().clear();
		
		for(Estoque produto : produtosDAO.listarProdutosMasGra()) {
			ProdutosTableViewModel  prodTVModel = new ProdutosTableViewModel();

			prodTVModel.setpCodigo(produto.getCodProd());
			prodTVModel.setpNome(produto.getNomeProd());
			prodTVModel.setpPreco(produto.getPrecoProd());
			prodTVModel.setpQtd(produto.getQtdEst());
			
			this.setListaProdutostvModel(prodTVModel);
		}
		return this.getListaProdutostvModel();
	}
	//Quarto ARRAY
	public ArrayList<ProdutosTableViewModel> carregaProdutosTableViewModel4(){
		
		this.getListaProdutostvModel().clear();
		
		for(Estoque produto : produtosDAO.listarProdutosMolErv()) {
			ProdutosTableViewModel  prodTVModel = new ProdutosTableViewModel();

			prodTVModel.setpCodigo(produto.getCodProd());
			prodTVModel.setpNome(produto.getNomeProd());
			prodTVModel.setpPreco(produto.getPrecoProd());
			prodTVModel.setpQtd(produto.getQtdEst());
			
			this.setListaProdutostvModel(prodTVModel);
		}
		return this.getListaProdutostvModel();
	}
	//Quinto ARRAY
	public ArrayList<ProdutosTableViewModel> carregaProdutosTableViewModel5(){
		
		this.getListaProdutostvModel().clear();
		
		for(Estoque produto : produtosDAO.listarProdutosBebidas()) {
			ProdutosTableViewModel  prodTVModel = new ProdutosTableViewModel();

			prodTVModel.setpCodigo(produto.getCodProd());
			prodTVModel.setpNome(produto.getNomeProd());
			prodTVModel.setpPreco(produto.getPrecoProd());
			prodTVModel.setpQtd(produto.getQtdEst());
			
			this.setListaProdutostvModel(prodTVModel);
		}
		return this.getListaProdutostvModel();
	}
	
	//Atualizações TableView
	//Limpeza
	public void atualizarTableView1() {
		
		this.carregaProdutosTableViewModel1();
		tvLimpeza.setItems(FXCollections.observableArrayList(this.getListaProdutostvModel()));
		
		tvLimpeza.refresh();
		
	}
	//Frios
	public void atualizarTableView2() {
		
		this.carregaProdutosTableViewModel2();
		
		tvFrios.setItems(FXCollections.observableArrayList(this.getListaProdutostvModel()));
		
		tvFrios.refresh();
		
	}
	//Massas e Ervas
	public void atualizarTableView3() {
		
		this.carregaProdutosTableViewModel3();
		
		tvMasGra.setItems(FXCollections.observableArrayList(this.getListaProdutostvModel()));
		
		tvMasGra.refresh();
		
	}
	//Molhos e Ervas
	public void atualizarTableView4() {
		
		this.carregaProdutosTableViewModel4();
		
		tvMolErv.setItems(FXCollections.observableArrayList(this.getListaProdutostvModel()));
		
		tvMolErv.refresh();
		
	}
	//Bebidas
	public void atualizarTableView5() {
		
		this.carregaProdutosTableViewModel5();
		
		tvBebidas.setItems(FXCollections.observableArrayList(this.getListaProdutostvModel()));
		
		tvBebidas.refresh();
		
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		//Inicializa campos essenciais
		
		SpinnerValueFactory<Integer> spqtdProd = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 40);
		spQtdProd.setValueFactory(spqtdProd);
		
		cbSetor.setItems(FXCollections.observableArrayList("","Limpeza","Frios","Massas e Grãos","Molhos e Ervas","Bebidas"));
		
		idLim.setCellValueFactory(new PropertyValueFactory<>("pCodigo"));
		nomeLim.setCellValueFactory( new PropertyValueFactory<>("pNome"));
		qtdLim.setCellValueFactory( new PropertyValueFactory<>("pQtd"));
		precoLim.setCellValueFactory( new PropertyValueFactory<>("pPreco"));
		
		idFri.setCellValueFactory(new PropertyValueFactory<>("pCodigo"));
		nomeFri.setCellValueFactory( new PropertyValueFactory<>("pNome"));
		qtdFri.setCellValueFactory( new PropertyValueFactory<>("pQtd"));
		precoFri.setCellValueFactory( new PropertyValueFactory<>("pPreco"));		
		
		idMG.setCellValueFactory(new PropertyValueFactory<>("pCodigo"));
		nomeMG.setCellValueFactory(new PropertyValueFactory<>("pNome"));
		qtdMG.setCellValueFactory(new PropertyValueFactory<>("pQtd"));
		precoMG.setCellValueFactory(new PropertyValueFactory<>("pPreco"));
		
		idME.setCellValueFactory(new PropertyValueFactory<>("pCodigo"));
		nomeME.setCellValueFactory(new PropertyValueFactory<>("pNome"));
		qtdME.setCellValueFactory(new PropertyValueFactory<>("pQtd"));
		precoME.setCellValueFactory(new PropertyValueFactory<>("pPreco"));
		
		idBe.setCellValueFactory(new PropertyValueFactory<>("pCodigo"));
		nomeBe.setCellValueFactory(new PropertyValueFactory<>("pNome"));
		qtdBe.setCellValueFactory(new PropertyValueFactory<>("pQtd"));
		precoBe.setCellValueFactory(new PropertyValueFactory<>("pPreco"));
		
		
		this.atualizarTableView1();
		this.atualizarTableView2();
		this.atualizarTableView3();
		this.atualizarTableView4();
		this.atualizarTableView5();
		
	}
	public void preencherLvCarrinho() {
		//Preenche a lista com os valores do produtos
		lvCarrinho.setItems(FXCollections.observableArrayList(estoque.getCaixa()));
		
	}
	
	int qtdProd = 0, codProd = 0;
	String nomeProd = "";
	
	@FXML public void addItem() {
		
		//Verifica o preencimento dos campos
		if(lNomeProd.getText().isEmpty() && lPrecoProd.getText().isEmpty()) {
			
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Ops...");
			alert.setHeaderText("Operação inválida");
			alert.setContentText("Nenhum item do estoque selecionado.");
			alert.showAndWait();
			
		}else {
		//Cria objeto e seta valores
			estoque.setCaixa(tfTotal.getText());
			Estoque updateEstoque = new Estoque();
			
			updateEstoque.setCodProd(Integer.valueOf(lCodProd.getText()));
			updateEstoque.setEntradaEst(Integer.valueOf(tfQtd.getText()));
			updateEstoque.setSaidaEst(Integer.valueOf(spQtdProd.getValue()));
			updateEstoque.setQtdEst(Integer.valueOf(tfQtd.getText()));
			
			//Aletração no banco de dados
			caixaDAO.alterar(updateEstoque);
			
			//Acrescenta valores nas variaveis que serão utilizadas em "removeItem()"
			codProd = Integer.valueOf(lCodProd.getText());
			nomeProd = lNomeProd.getText();
			qtdProd = spQtdProd.getValue();
			
			//Limpa os campos
			lCodProd.setText("");
			lNomeProd.setText("");
			lPrecoProd.setText("");
			SpinnerValueFactory<Integer> spqtdProd = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 0);
			spQtdProd.setValueFactory(spqtdProd);
			tfTotal.setText("");
			lTotalCarrinho.setText(String.valueOf(estoque.identificar()));
			estoque.setSaidaEst(null);
			estoque.setEntradaEst(null);

			preencherLvCarrinho();			
			
		}
		
	}
	//Ações no ListView -- REmove item
	@FXML public void removeItem() {
		
		//Remove os item acrescentados no banco de dados
		if(lvCarrinho.getSelectionModel().getSelectedIndex() >= 0) {
			
			//Cria objeto e seta valores
			Estoque updateEstoque = new Estoque();
			
			updateEstoque.setCodProd(codProd);
			updateEstoque.setEntradaEst(Integer.valueOf(tfQtd.getText()));
			updateEstoque.setSaidaEst(qtdProd);
			updateEstoque.setQtdEst(Integer.valueOf(tfQtd.getText()));
			
			//Aletra2 é um metodo reverso de "Altera" da mesma classe
			caixaDAO.alterar2(updateEstoque);
			
			//Remove indice selecionado na lista
			int indice = lvCarrinho.getSelectionModel().getSelectedIndex();
						
			estoque.getCaixa().remove(indice);
			
			lTotalCarrinho.setText(String.valueOf(estoque.identificar()));
			preencherLvCarrinho();
			

			
		}else {
			
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Ops...");
			alert.setHeaderText("Operação inválida");
			alert.setContentText("Nenhum item do carrinho selecionado.");
			alert.showAndWait();
		}
	}
	
	//public ArrayList<CaixaTableViewModel> carregaCarrinho(){}
	
	//Ações no index
	@FXML public void fechaAba() {
		//Fecha o programa
		System.exit(0);
	}
	
	//Açoes no FormCRUD
	@FXML public void inserir() {
		//Prepara o formulário para inserção
		this.habilitarCampos();
		this.ajustarBotoesInserir();
		tfNome.requestFocus();
		
		// Identifica a opração e ajusta os botões
		this.setOperacao("inserir");
		this.ajustarBotoesInserir();
	}
	@FXML public void alterar() {
		//Verifica a seleção de item nas tableviews  e executa a organização para alteração
		try {
			
			if(tvLimpeza.getSelectionModel().getSelectedIndex() < 0) {
				
				throw new IOException();
				
			}else {
				
				this.habilitarCampos();
				this.ajustarBotoesAlterar();
				tfNome.requestFocus();
				
				this.setOperacao("alterar");
				this.ajustarBotoesAlterar();
				
			}
			
			if(tvFrios.getSelectionModel().getSelectedIndex() < 0) {
				
				//throw new IOException();
				
			}else {
				
				this.habilitarCampos();
				this.ajustarBotoesAlterar();
				tfNome.requestFocus();
				
				this.setOperacao("alterar");
				this.ajustarBotoesAlterar();
				
			}

			if(tvMasGra.getSelectionModel().getSelectedIndex() < 0) {
				
				//throw new IOException();
				
			}else {
				
				this.habilitarCampos();
				this.ajustarBotoesAlterar();
				tfNome.requestFocus();
				
				this.setOperacao("alterar");
				this.ajustarBotoesAlterar();
				
			}
			
			if(tvMolErv.getSelectionModel().getSelectedIndex() < 0) {
				
				//throw new IOException();
				
			}else {
				
				this.habilitarCampos();
				this.ajustarBotoesAlterar();
				tfNome.requestFocus();
				
				this.setOperacao("alterar");
				this.ajustarBotoesAlterar();
				
			}

			if(tvBebidas.getSelectionModel().getSelectedIndex() < 0) {
				
				//throw new IOException();
				
			}else {
				
				this.habilitarCampos();
				this.ajustarBotoesAlterar();
				tfNome.requestFocus();
				
				this.setOperacao("alterar");
				this.ajustarBotoesAlterar();
				
			}
		} catch (IOException e) {
			
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Ops!");
			alert.setHeaderText("Operação não pode ser realizada");
			alert.setContentText("Selecione um produto para alteração");
			alert.showAndWait();	
			
		} catch (Exception e) {
			
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Operação não realizada");
			alert.setHeaderText("Ocorreu um problema no processo de entrada");
			alert.setContentText("Favor entrar em contato com os desenvolvedores!");
			alert.showAndWait();
			
			e.printStackTrace();
		}				
	}
	@FXML public void excluir() {
		
		//Verifica cada tableview para setar as funcionalidades de DELETE/UPDATE/INSERT 
		if( tvLimpeza.getSelectionModel().getSelectedIndex() >= 0 ) {
			
		this.setOperacao("excluir");
		this.ajustarBotoesExcluir();

		}else {

			//throw new IOException();
		
		}
		
		if( tvFrios.getSelectionModel().getSelectedIndex() >= 0 ) {
			
		this.setOperacao("excluir");
		this.ajustarBotoesExcluir();

		}else {

			//throw new IOException();
		
		}
		
		if( tvMasGra.getSelectionModel().getSelectedIndex() >= 0 ) {
			
		this.setOperacao("excluir");
		this.ajustarBotoesExcluir();

		}else {

			//throw new IOException();
		
		}

		if( tvMolErv.getSelectionModel().getSelectedIndex() >= 0 ) {
			
		this.setOperacao("excluir");
		this.ajustarBotoesExcluir();

		}else {

			//throw new IOException();
			
		}

		if( tvBebidas.getSelectionModel().getSelectedIndex() >= 0 ) {
			
		this.setOperacao("excluir");
		this.ajustarBotoesExcluir();

		}else {

			//throw new IOException();
			
		}
	}	

	@FXML public void confirma() {
		
		try {
			//Verifica o preenchimento dos campos no formulário
			if( 	tfNome.getText().isEmpty() || 					
					tfQtd.getText().isEmpty() ||
					tfPreco.getText().isEmpty() ||
					cbSetor.getValue().equals("")) {
				
				throw new IOException();
			}
			
			if(this.getOperacao().equals("inserir")) {
				//Prepara para inserir no banco de dados
				
				Estoque novoProduto = new Estoque();
				
				novoProduto.setNomeProd(tfNome.getText());
				novoProduto.setQtdEst(Integer.parseInt(tfQtd.getText()));
				novoProduto.setSetorProd(cbSetor.getValue());
				novoProduto.setPrecoProd(Double.parseDouble(tfPreco.getText()));
				
				produtosDAO.inserir(novoProduto);
				
					this.atualizarTableView1();	
						this.atualizarTableView2();					
							this.atualizarTableView3();
								this.atualizarTableView4();								
									this.atualizarTableView5();
				
			}
			if(this.getOperacao().equals("alterar")) {
				//Prepara a alteração da tabela view com base no combobox setado apartir d item selecionad em tabela
				
				Estoque alteraProduto = new Estoque();
				
				if(cbSetor.getValue() == "Limpeza") {
					
				alteraProduto.setCodProd(Integer.parseInt(lCodProd.getText()));
				alteraProduto.setNomeProd(tfNome.getText());
				alteraProduto.setQtdEst(Integer.parseInt(tfQtd.getText()));
				alteraProduto.setSetorProd(cbSetor.getValue());
				alteraProduto.setPrecoProd(Double.parseDouble(tfPreco.getText()));
				
				produtosDAO.alterar(alteraProduto);

				}
				if(cbSetor.getValue() == "Frios") {
				
				alteraProduto.setCodProd(Integer.parseInt(lCodProd.getText()));
				alteraProduto.setNomeProd(tfNome.getText());
				alteraProduto.setQtdEst(Integer.parseInt(tfQtd.getText()));
				alteraProduto.setSetorProd(cbSetor.getValue());
				alteraProduto.setPrecoProd(Double.parseDouble(tfPreco.getText()));
				
				produtosDAO.alterar(alteraProduto);


				}
				if(cbSetor.getValue() == "Massas e Grãos") {
					
				alteraProduto.setCodProd(Integer.parseInt(lCodProd.getText()));
				alteraProduto.setNomeProd(tfNome.getText());
				alteraProduto.setQtdEst(Integer.parseInt(tfQtd.getText()));
				alteraProduto.setSetorProd(cbSetor.getValue());
				alteraProduto.setPrecoProd(Double.parseDouble(tfPreco.getText()));
				
				produtosDAO.alterar(alteraProduto);


				}
				
				if(cbSetor.getValue() == "Molhos e Ervas") {
					
				alteraProduto.setCodProd(Integer.parseInt(lCodProd.getText()));
				alteraProduto.setNomeProd(tfNome.getText());
				alteraProduto.setQtdEst(Integer.parseInt(tfQtd.getText()));
				alteraProduto.setSetorProd(cbSetor.getValue());
				alteraProduto.setPrecoProd(Double.parseDouble(tfPreco.getText()));
				
				produtosDAO.alterar(alteraProduto);


				}
				
				if(cbSetor.getValue() == "Bebidas") {
					
				alteraProduto.setCodProd(Integer.parseInt(lCodProd.getText()));
				alteraProduto.setNomeProd(tfNome.getText());
				alteraProduto.setQtdEst(Integer.parseInt(tfQtd.getText()));
				alteraProduto.setSetorProd(cbSetor.getValue());
				alteraProduto.setPrecoProd(Double.parseDouble(tfPreco.getText()));
				
				produtosDAO.alterar(alteraProduto);


				}
				
				
				this.atualizarTableView1();
				this.atualizarTableView2();
				this.atualizarTableView3();
				this.atualizarTableView4();
				this.atualizarTableView5();
			}
			if(this.getOperacao().equals("excluir")) {
				//Prepara a exclusão da tabela view com base no combobox setado apartir d item selecionad em tabela
				
				Estoque exclusaoProduto = new Estoque();
				
				if(cbSetor.getValue() == "Limpeza") {
				//Limpeza
				tvFrios.setSelectionModel(null);
				tvMasGra.setSelectionModel(null);
				tvMolErv.setSelectionModel(null);
				tvBebidas.setSelectionModel(null);
				
				exclusaoProduto.setCodProd(Integer.parseInt(lCodProd.getText()));

				produtosDAO.excluir(exclusaoProduto);
				}
				if(cbSetor.getValue() == "Frios") {
				//Frios
				tvLimpeza.setSelectionModel(null);
				tvMasGra.setSelectionModel(null);
				tvMolErv.setSelectionModel(null);
				tvBebidas.setSelectionModel(null);
				exclusaoProduto.setCodProd(Integer.parseInt(lCodProd.getText()));

				produtosDAO.excluir(exclusaoProduto);
				}
				if(cbSetor.getValue() == "Massas e Grãos") {				
				//MasGra
				tvFrios.setSelectionModel(null);
				tvLimpeza.setSelectionModel(null);
				tvMolErv.setSelectionModel(null);
				tvBebidas.setSelectionModel(null);
				exclusaoProduto.setCodProd(Integer.parseInt(lCodProd.getText()));

				produtosDAO.excluir(exclusaoProduto);
				}
				if(cbSetor.getValue() == "Molhos e Ervas") {
				//MolErv
				tvFrios.setSelectionModel(null);
				tvLimpeza.setSelectionModel(null);
				tvMasGra.setSelectionModel(null);
				tvBebidas.setSelectionModel(null);
				exclusaoProduto.setCodProd(Integer.parseInt(lCodProd.getText()));

				produtosDAO.excluir(exclusaoProduto);
				}
				if(cbSetor.getValue() == "Bebidas") {
				//Bebidas
				tvFrios.setSelectionModel(null);
				tvLimpeza.setSelectionModel(null);
				tvMolErv.setSelectionModel(null);
				tvMasGra.setSelectionModel(null);
				exclusaoProduto.setCodProd(Integer.parseInt(lCodProd.getText()));

				produtosDAO.excluir(exclusaoProduto);
				}
				this.atualizarTableView1();
				this.atualizarTableView2();
				this.atualizarTableView3();
				this.atualizarTableView4();
				this.atualizarTableView5();
								
			}
			
			this.limparCampos();
			this.ajustarBotoesInicial();
			this.desabilitarCampos();
			
		}catch(IOException e) {
			
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Atenção");
			alert.setHeaderText("Operação não pode ser realizada");
			alert.setContentText("Todos os campos são obrigatórios.");
			alert.showAndWait();		
			
		}catch(Exception e) {
			
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Operação não realizada");
			alert.setHeaderText("Ocorreu um problema no processo de entrada");
			alert.setContentText("Favor entrar em contato com os desenvolvedores!");
			alert.showAndWait();
			// Detalhes do erro imprevisto
			e.printStackTrace();	
						
		}
			
	}
	
	//Carrega os dados ao clicar na TableView
	@FXML public void carregaDados() {
		//Acrescentar dados para as outras tabelas
		if(tvLimpeza.getSelectionModel().getSelectedIndex() < 0) {
			/*
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Ops!");
			alert.setHeaderText("Operação inválida em Limpeza!");
			alert.setContentText( "Nenhum produto inserido" );
			alert.showAndWait();
			*/
		}else {
			//Limpeza
			ProdutosTableViewModel produtoTVMselecionado1 = new ProdutosTableViewModel();

			produtoTVMselecionado1 = tvLimpeza.getSelectionModel().getSelectedItem();
			

			tfNome.setText(produtoTVMselecionado1.getpNome());
			tfPreco.setText(produtoTVMselecionado1.getpPreco().toString());		
			tfQtd.setText(produtoTVMselecionado1.getpQtd().toString());
			cbSetor.setValue("Limpeza");

			lNomeProd.setText(produtoTVMselecionado1.getpNome());
			lCodProd.setText(produtoTVMselecionado1.getpCodigo().toString());
			lPrecoProd.setText(produtoTVMselecionado1.getpPreco().toString());
			SpinnerValueFactory<Integer> spqtdProd = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, produtoTVMselecionado1.getpQtd());
			spQtdProd.setValueFactory(spqtdProd);
		}		
		if(tvFrios.getSelectionModel().getSelectedIndex() < 0) {
				/*
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Ops!");
				alert.setHeaderText("Operação inválida em Frios!");
				alert.setContentText( "Nenhum produto inserido" );
				alert.showAndWait();
				*/
		}else {
			//Frios
			ProdutosTableViewModel produtoTVMselecionado2 = new ProdutosTableViewModel();

			produtoTVMselecionado2 = tvFrios.getSelectionModel().getSelectedItem();
			

			tfNome.setText(produtoTVMselecionado2.getpNome());
			tfPreco.setText(produtoTVMselecionado2.getpPreco().toString());		
			tfQtd.setText(produtoTVMselecionado2.getpQtd().toString());
			cbSetor.setValue("Frios");

			lNomeProd.setText(produtoTVMselecionado2.getpNome());
			lCodProd.setText(produtoTVMselecionado2.getpCodigo().toString());
			lPrecoProd.setText(produtoTVMselecionado2.getpPreco().toString());
			SpinnerValueFactory<Integer> spqtdProd2 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, produtoTVMselecionado2.getpQtd());
			spQtdProd.setValueFactory(spqtdProd2);
		}	
		if(tvMasGra.getSelectionModel().getSelectedIndex() < 0) {
				/*
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Ops!");
				alert.setHeaderText("Operação inválida em Massas e Grãos!");
				alert.setContentText( "Nenhum produto inserido" );
				alert.showAndWait();
				*/
		}else {
			//Massas e Grãos
			ProdutosTableViewModel produtoTVMselecionado3 = new ProdutosTableViewModel();

			produtoTVMselecionado3 = tvMasGra.getSelectionModel().getSelectedItem();
			

			tfNome.setText(produtoTVMselecionado3.getpNome());
			tfPreco.setText(produtoTVMselecionado3.getpPreco().toString());		
			tfQtd.setText(produtoTVMselecionado3.getpQtd().toString());
			cbSetor.setValue("Massas e Grãos");

			lNomeProd.setText(produtoTVMselecionado3.getpNome());
			lCodProd.setText(produtoTVMselecionado3.getpCodigo().toString());
			lPrecoProd.setText(produtoTVMselecionado3.getpPreco().toString());
			SpinnerValueFactory<Integer> spqtdProd3 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, produtoTVMselecionado3.getpQtd());
			spQtdProd.setValueFactory(spqtdProd3);
		}	
		if(tvMolErv.getSelectionModel().getSelectedIndex() < 0) {
				/*
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Ops!");
				alert.setHeaderText("Operação inválida em Molhos e Ervas!");
				alert.setContentText( "Nenhum produto inserido" );
				alert.showAndWait();
				*/
		}else {
			//Molhos e ervas
			ProdutosTableViewModel produtoTVMselecionado4 = new ProdutosTableViewModel();

			produtoTVMselecionado4 = tvMolErv.getSelectionModel().getSelectedItem();
			

			tfNome.setText(produtoTVMselecionado4.getpNome());
			tfPreco.setText(produtoTVMselecionado4.getpPreco().toString());		
			tfQtd.setText(produtoTVMselecionado4.getpQtd().toString());
			cbSetor.setValue("Molhos e Ervas");
			lNomeProd.setText(produtoTVMselecionado4.getpNome());
			lCodProd.setText(produtoTVMselecionado4.getpCodigo().toString());
			lPrecoProd.setText(produtoTVMselecionado4.getpPreco().toString());
			SpinnerValueFactory<Integer> spqtdProd4 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, produtoTVMselecionado4.getpQtd());
			spQtdProd.setValueFactory(spqtdProd4);
		}	
		if(tvBebidas.getSelectionModel().getSelectedIndex() < 0) {
			/*
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Ops!");
				alert.setHeaderText("Operação inválida em Bebidas!");
				alert.setContentText( "Nenhum produto inserido" );
				alert.showAndWait();
			*/	
		}else {
			//Bebidas
			ProdutosTableViewModel produtoTVMselecionado5 = new ProdutosTableViewModel();

			produtoTVMselecionado5 = tvBebidas.getSelectionModel().getSelectedItem();
			

			tfNome.setText(produtoTVMselecionado5.getpNome());
			tfPreco.setText(produtoTVMselecionado5.getpPreco().toString());		
			tfQtd.setText(produtoTVMselecionado5.getpQtd().toString());
			cbSetor.setValue("Bebidas");
			lNomeProd.setText(produtoTVMselecionado5.getpNome());
			lCodProd.setText(produtoTVMselecionado5.getpCodigo().toString());
			lPrecoProd.setText(produtoTVMselecionado5.getpPreco().toString());
			SpinnerValueFactory<Integer> spqtdProd5 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, produtoTVMselecionado5.getpQtd());
			spQtdProd.setValueFactory(spqtdProd5);
			
		}
		
		preencherLvCarrinho();
	}
	
	@FXML public void cancela() {
		this.limparCampos();
		this.ajustarBotoesInicial();

	}
	//Abre formulário de Estoque
	@FXML public void abreForm() {
		formCaixa.setVisible(false);
		formCrud.setVisible(false);
	}
	//Volta para a pagina Inicial 
	@FXML public void fecharAba() {
		lNomeProd.setLabelFor(null);
		lPrecoProd.setLabelFor(null);
		tfNome.clear();
		tfQtd.clear();
		tfPreco.clear();
		cbSetor.setValue(null);
		formCaixa.setVisible(true);
		formCrud.setVisible(true);
	}
	//Abre formulário de Caixa
	@FXML public void abreCaixa() {
		formCrud.setVisible(false);
		formCaixa.setVisible(true);
	}
	
	// Ajustes de botões e campos

		public void ajustarBotoesInicial() {	
			btInsert.setVisible(true);
			btUpdate.setVisible(true);
			btDelete.setVisible(true);
			btConfirm.setVisible(false);
			btCancel.setVisible(false);
			btClose.setVisible(true);
			btInsert.setDisable(false);
			btUpdate.setDisable(false);
			btDelete.setDisable(false);
		}

		public void ajustarBotoesInserir() {
			btInsert.setVisible(true);
			btInsert.setDisable(true);
			btUpdate.setVisible(false);
			btDelete.setVisible(false);
			btConfirm.setVisible(true);
			btCancel.setVisible(true);
			btClose.setVisible(false);
			
		}

		public void ajustarBotoesAlterar() {
			btInsert.setVisible(false);
			btUpdate.setVisible(true);
			btUpdate.setDisable(true);
			btDelete.setVisible(false);
			btConfirm.setVisible(true);
			btCancel.setVisible(true);
			btClose.setVisible(false);
		}

		public void ajustarBotoesExcluir() {
			btInsert.setVisible(false);
			btUpdate.setVisible(false);
			btDelete.setVisible(true);
			btDelete.setDisable(true);
			btConfirm.setVisible(true);
			btCancel.setVisible(true);
			btClose.setVisible(false);
		}

		public void habilitarCampos() {
			tfNome.setDisable(false);
			tfQtd.setDisable(false);
			tfPreco.setDisable(false);
			cbSetor.setDisable(false);
			
			tfNome.setOpacity(1);
			tfQtd.setOpacity(1);
			tfPreco.setOpacity(1);
			cbSetor.setOpacity(1);
			
			tfNome.requestFocus();
		}
		
		public void desabilitarCampos() {
			tfNome.setDisable(true);
			tfQtd.setDisable(true);
			tfPreco.setDisable(true);
			cbSetor.setDisable(true);
			
			tfNome.setOpacity(0.8);
			tfQtd.setOpacity(0.8);
			tfPreco.setOpacity(0.8);
			cbSetor.setOpacity(0.8);
		}
		
		public void limparCampos() {
			tfNome.clear();
			tfQtd.clear();
			tfPreco.clear();
			cbSetor.setValue(null);
			
			tfNome.requestFocus();
		}

		CaixaDAO caixaDAO = new CaixaDAO();
	
		@FXML public void geraTotal() {
			//Confirmao total do carrinho e insere a venda no banco de dados
			double total = estoque.identificar();

			Caixa novaVenda = new Caixa();
			//novaVenda.setCodFun(caixa.getCodFun());
			novaVenda.setTotalCai(total);
			
			caixaDAO.inserir(novaVenda);			
						
			lCodProd.setText("");
			lNomeProd.setText("");
			lPrecoProd.setText("");
			SpinnerValueFactory<Integer> spqtdProd = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 0);
			spQtdProd.setValueFactory(spqtdProd);
			tfTotal.setText("");
			lvCarrinho.setItems(null);
			lTotalCarrinho.setText("");
			estoque.getCaixa().clear();
			estoque.setSaidaEst(null);
			
		}
		//Executado no spinner de caixa
		@FXML public void caixaConfirma() {
			//Evento que gerá total a pagar e verifica a quantidade inserida com o quantidade total
			int qtd = Integer.valueOf(spQtdProd.getValue().toString());
			double result = 0;
			
			Estoque estoqueSai = new Estoque();
			
			estoqueSai.setCodProd(Integer.valueOf(lCodProd.getText()));
			estoqueSai.setSaidaEst(qtd);
			
			caixaDAO.verifica(estoqueSai);
			
			result =  (Double.valueOf(lPrecoProd.getText())*qtd);
			
			tfTotal.setText(String.valueOf(result));
			
		}

}

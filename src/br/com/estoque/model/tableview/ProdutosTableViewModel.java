package br.com.estoque.model.tableview;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class ProdutosTableViewModel {
	
	//Atributos SimpleProperty
	private final SimpleIntegerProperty pCodigo;
	private final SimpleIntegerProperty pQtd;
	private final SimpleStringProperty pNome;
	private final SimpleDoubleProperty pPreco;
	
	//Construtores SimpleProperty
	
	public ProdutosTableViewModel() {
		this.pCodigo = new SimpleIntegerProperty(0);
		this.pQtd = new SimpleIntegerProperty(0);
		this.pNome = new SimpleStringProperty("");
		this.pPreco = new SimpleDoubleProperty(0);
	}
	
	public ProdutosTableViewModel(SimpleIntegerProperty pCodigo,
								  SimpleIntegerProperty pQtd, 
								  SimpleStringProperty pNome, 
								  SimpleDoubleProperty pPreco) {
		this.pCodigo = pCodigo;
		this.pQtd = pQtd;
		this.pNome = pNome;
		this.pPreco = pPreco;
	}
	
	public Integer getpCodigo() {
		return pCodigo.get();
	}	
	
	public SimpleIntegerProperty pCodigoProperty() {
		return pCodigo;
	}
	
	public void setpCodigo(Integer pCodigo) {
		this.pCodigo.set(pCodigo);
	}
	
	public Integer getpQtd() {
		return pQtd.get();
	}
	
	public SimpleIntegerProperty pQtdProperty() {
		return pQtd;
	}
	
	public void setpQtd(Integer pQtd) {
		this.pQtd.set(pQtd);
	}
	
	public String getpNome() {
		return pNome.get();
	}
	
	public SimpleStringProperty pNomeProperty() {
		return pNome;
	}
	
	public void setpNome(String pNome) {
		this.pNome.set(pNome);
	}
	
	public Double getpPreco() {
		return pPreco.get();
	}

	public SimpleDoubleProperty pPrecoProperty() {
		return pPreco;
	}
	
	public void setpPreco(Double pPreco) {
		this.pPreco.set(pPreco);
	}
	
	
	
}

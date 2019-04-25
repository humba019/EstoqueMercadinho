package br.com.estoque.model.tableview;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class CaixaTableViewModel {
	
	private final SimpleIntegerProperty cCodigo;
	private final SimpleIntegerProperty cQtd;
	private final SimpleStringProperty cNome;
	private final SimpleDoubleProperty cPreco;
	
	public CaixaTableViewModel() {
		this.cCodigo = new SimpleIntegerProperty(0);
		this.cQtd = new SimpleIntegerProperty(0);
		this.cNome = new SimpleStringProperty("");
		this.cPreco = new SimpleDoubleProperty(0);
	}
	
	public CaixaTableViewModel(SimpleIntegerProperty cCodigo, SimpleIntegerProperty cQtd, SimpleStringProperty cNome,
			SimpleDoubleProperty cPreco) {
		this.cCodigo = cCodigo;
		this.cQtd = cQtd;
		this.cNome = cNome;
		this.cPreco = cPreco;
	}

	public Integer getcCodigo() {
		return cCodigo.get();
	}
	
	public SimpleIntegerProperty cCodigoProperty() {
		return cCodigo;
	}
	
	public void setcCodigo(Integer cCodigo) {
		this.cCodigo.set(cCodigo);
	}
	
	public Integer getcQtd() {
		return cQtd.get();
	}
	
	public SimpleIntegerProperty cQtdProperty() {
		return cQtd;
	}
	
	public void setcQtd(Integer cQtd) {
		this.cQtd.set(cQtd);
	}

	public String getcNome() {
		return cNome.get();
	}
	
	public SimpleStringProperty cNomeProperty() {
		return cNome;
	}
	
	public void setcNome(String cNome) {
		this.cNome.set(cNome);
	}

	public Double getcPreco() {
		return cPreco.get();
	}
	
	public SimpleDoubleProperty cPrecoProperty() {
		return cPreco;
	}

	public void setcPreco(Double cPreco) {
		this.cPreco.set(cPreco);
	}
	
	
	
	
}

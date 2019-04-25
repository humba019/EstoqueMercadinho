package br.com.estoque.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Estoque extends Produto{
	
	private Integer codEst;
	private Integer qtdEst;
	private Integer entradaEst;
	private Integer saidaEst;
	private Integer totalEst;
	
	public Estoque() {
		this.codEst = 0;
		this.qtdEst = 0;
		this.entradaEst = 0;
		this.saidaEst = 0;
	}

	public Estoque(ArrayList<String> caixa, Integer codProd, String nomeProd, String setorPro, LocalDate validadeProd, String marcaProd, Double precoProd ,Integer codEst, Integer qtdEst, Integer entradaEst, Integer saidaEst) {
		super(caixa, codProd, nomeProd, setorPro, marcaProd, precoProd);
		this.codEst = codEst;
		this.qtdEst = qtdEst;
		this.entradaEst = entradaEst;
		this.saidaEst = saidaEst;
	}

	public Integer getCodEst() {
		return codEst;
	}

	public void setCodEst(Integer codEst) {
		this.codEst = codEst;
	}

	public Integer getQtdEst() {
		return qtdEst;
	}

	public void setQtdEst(Integer qtdEst) {
		this.qtdEst = qtdEst;
	}

	public Integer getEntradaEst() {
		return entradaEst;
	}

	public void setEntradaEst(Integer entradaEst) {
		this.entradaEst = entradaEst;
	}

	public Integer getSaidaEst() {
		return saidaEst;
	}

	public void setSaidaEst(Integer saidaEst) {
		this.saidaEst = saidaEst;
	}

	public Integer getTotalEst() {
		return totalEst;
	}

	public void setTotalEst(Integer totalEst) {
		this.totalEst = totalEst;
	}
	
	public Integer verificaTotalEst() {
		int total = (this.getQtdEst());	
		return total;
	}
	
}

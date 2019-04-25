package br.com.estoque.model;

public class Caixa extends Funcionario{
	
	private Integer codCai;
	private Integer entradaCai;
	private Integer saidaCai;
	private Double totalCai;
	
	public Caixa() {
		this.codCai = 0;
		this.entradaCai = 0;
		this.saidaCai = 0;
	}
	
	public Caixa(Double totalCai, Integer codCai, Integer entradaCai, Integer saidaCai, Integer codUsu, String loginUsu, String senhaUsu, Integer codFun, Integer cargaHora,
			String funcaoFun, String nomeFun) {
		super(codUsu, loginUsu, senhaUsu, codFun, cargaHora, funcaoFun, nomeFun);
		
		this.codCai = codCai;
		this.entradaCai = entradaCai;
		this.saidaCai = saidaCai;
		this.totalCai = totalCai;
		
	}

	public Integer getCodCai() {
		return codCai;
	}

	public void setCodCai(Integer codCai) {
		this.codCai = codCai;
	}

	public Integer getEntradaCai() {
		return entradaCai;
	}

	public void setEntradaCai(Integer entradaCai) {
		this.entradaCai = entradaCai;
	}

	public Integer getSaidaCai() {
		return saidaCai;
	}

	public void setSaidaCai(Integer saidaCai) {
		this.saidaCai = saidaCai;
	}
	
	public Double getTotalCai() {
		return totalCai;
	}

	public void setTotalCai(Double totalCai) {
		this.totalCai = totalCai;
	}

	
}

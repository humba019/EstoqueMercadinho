package br.com.estoque.model;

public class Funcionario extends Usuario{
	
	//Atributos
	
	private Integer codFun;
	private Integer cargaHora;
	private String funcaoFun;
	private String nomeFun;
	
	//Construtores
	
	public Funcionario() {
		this.codFun = 0;
		this.cargaHora = 0;
		this.funcaoFun = "";
		this.nomeFun = "";
	}

	public Funcionario(Integer codUsu, String loginUsu, String senhaUsu, Integer codFun, Integer cargaHora, String funcaoFun, String nomeFun) {
		super(codUsu, loginUsu, senhaUsu);
		
		this.codFun = codFun;
		this.cargaHora = cargaHora;
		this.funcaoFun = funcaoFun;
		this.nomeFun = nomeFun;
	}
	
	//Metodos
	
	public Integer getCodFun() {
		return codFun;
	}

	public void setCodFun(Integer codFun) {
		this.codFun = codFun;
	}

	public Integer getCargaHora() {
		return cargaHora;
	}

	public void setCargaHora(Integer cargaHora) {
		this.cargaHora = cargaHora;
	}

	public String getFuncaoFun() {
		return funcaoFun;
	}

	public void setFuncaoFun(String funcaoFun) {
		this.funcaoFun = funcaoFun;
	}
	
	public String getNomeFun() {
		return nomeFun;
	}
	
	public void setNomeFun(String nomeFun) {
		this.nomeFun = nomeFun;
	}
	
	public void verificaFuncionario(Integer codFun) {
		//BD		
	}
	
	
	
}

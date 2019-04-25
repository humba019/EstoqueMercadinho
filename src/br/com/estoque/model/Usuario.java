package br.com.estoque.model;

public class Usuario {
	
	//Atributos 
	
	private Integer codUsu;
	private String loginUsu;
	private String senhaUsu;
	
	//Construtores
	
	public Usuario() {
		this.codUsu = 0;
		this.loginUsu = "";
		this.senhaUsu = "";
	}
	
	public Usuario(Integer codUsu, String loginUsu, String senhaUsu) {
		this.codUsu = codUsu;
		this.loginUsu = loginUsu;
		this.senhaUsu = senhaUsu;
	}
	
	//Metodos

	public Integer getCodUsu() {
		return codUsu;
	}

	public void setCodUsu(Integer codUsu) {
		this.codUsu = codUsu;
	}

	public String getLoginUsu() {
		return loginUsu;
	}

	public void setLoginUsu(String loginUsu) {
		this.loginUsu = loginUsu;
	}

	public String getSenhaUsu() {
		return senhaUsu;
	}

	public void setSenhaUsu(String senhaUsu) {
		this.senhaUsu = senhaUsu;
	}
	
	public void mudarLogin(String loginUsu) {
		//BD
	}
	
	public void mudarSenha(String senhaUsu) {
		//BD
	}
}

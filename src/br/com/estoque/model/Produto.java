package br.com.estoque.model;


import java.util.ArrayList;

public class Produto {
	
	//Atributos
	private ArrayList<String> caixa = new ArrayList<String>();
	private Integer codProd;
	private String nomeProd;
	private String setorProd;//Frios, Bebidas etc...
	private double precoProd;
	private String marcaProd;
	
	//Construtores
	
	public Produto() {
		this.caixa = new ArrayList<String>();
		this.codProd = 0;
		this.nomeProd = "";
		this.setorProd = "";
		this.marcaProd = "";
		this.precoProd = 0;		
	}
	
	public Produto(ArrayList<String> caixa, Integer codProd, String nomeProd, String setorPro, String marcaProd, double precoProd) {
		this.caixa.addAll(caixa);
		this.codProd = codProd;
		this.nomeProd = nomeProd;
		this.setorProd = setorPro;
		this.marcaProd = marcaProd;
		this.precoProd = precoProd;
	}
	
	//Sobreposição
	public Produto(String caixa, Integer codProd, String nomeProd, String setorPro, String marcaProd, double precoProd) {
		this.caixa.add(caixa);
		this.codProd = codProd;
		this.nomeProd = nomeProd;
		this.setorProd = setorPro;
		this.marcaProd = marcaProd;
		this.precoProd = precoProd;
	}
	
	//Metodos
	public Integer getCodProd(){
		return codProd;
	}
	

	public void setCodProd(Integer codProd) {
		this.codProd = codProd;
	}

	public String getNomeProd() {
		return nomeProd;
	}

	public void setNomeProd(String nomeProd) {
		this.nomeProd = nomeProd;
	}

	public String getSetorProd() {
		return setorProd;
	}

	public void setSetorProd(String setorProd) {
		this.setorProd = setorProd;
	}

	public String getMarcaProd() {
		return marcaProd;
	}

	public void setMarcaProd(String marcaProd) {
		this.marcaProd = marcaProd;
	}
	
	public double getPrecoProd() {
		return precoProd;
	}

	public void setPrecoProd(double precoProd) {
		this.precoProd = precoProd;
	}

	public ArrayList<String> getCaixa(){
		return caixa;
	}
	
	public void setCaixa(String caixa) {
		this.caixa.add(caixa);		
	}
	
	public void setCaixa(ArrayList<String> caixa) {
		this.caixa.addAll(caixa);		
	}
	
	public double identificar() {
		
		double somaTotal = 0;
		
		for(String soma : this.getCaixa()) {
			
			somaTotal = somaTotal + Double.parseDouble(soma);
			
		}
		
		return somaTotal;
		
	}
	
	
	
	
	
}

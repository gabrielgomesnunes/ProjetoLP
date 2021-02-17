package br.com.novaroma.nomeprojeto.entidades;

import java.io.Serializable;

public class Produto implements Serializable {

	private  String id;
	private  String tipo;
	private  double preco;

	public Produto(String id, String tipo, double preco) {
		this.tipo = tipo;
		this.id = id;
		this.preco = preco;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public  double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

}
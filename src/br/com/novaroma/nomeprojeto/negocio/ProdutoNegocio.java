package br.com.novaroma.nomeprojeto.negocio;

import java.io.IOException;

import java.util.ArrayList;
import java.util.Scanner;

import br.com.novaroma.nomeprojeto.apresentacao.ProdutoApresentacao;
import br.com.novaroma.nomeprojeto.dados.ProdutoDados;
import br.com.novaroma.nomeprojeto.entidades.Produto;

public class ProdutoNegocio {
	Scanner scan = new Scanner(System.in);
	ProdutoDados produtoDados = new ProdutoDados();
	
	public String criticarProduto(Produto produto) throws ClassNotFoundException, IOException {

		if (this.produtoDados.consultaProduto(produto.getId()) != null) {
			return "\n-> Erro: O produto já foi cadastrado!";
		}
		if (produto.getId().length() != 6) {
			return "\n-> Erro: O id deve ter exatamente 6 dígitos.";
		}

		if (produtoDados.cadastrarProduto(produto)) {
			return "\n-> O produto foi cadastrado com sucesso.";
		}

		return "\n-> Erro: O produto não foi cadastrado.";
	}

	public ArrayList<Produto> listaProdutos() throws ClassNotFoundException, IOException {
		ProdutoDados produtoDados = new ProdutoDados();
		return produtoDados.listaProdutos();
	}

	public ArrayList<Produto> filtrarProduto(double valorMinimo, double valorMaximo, String tipo)
			throws ClassNotFoundException, IOException {
		return produtoDados.filtro(valorMinimo, valorMaximo, tipo);
	}

	public void remover(String id) throws ClassNotFoundException, IOException {
		ProdutoDados produtoDados = new ProdutoDados();
		produtoDados.removerProduto(id);

	}

	public boolean atualizarProduto(String id, double preco) throws ClassNotFoundException, IOException {

		ProdutoDados produtoDados = new ProdutoDados();
		produtoDados.atualizarProduto(id, preco);
		return true;
	}

	public Produto consultarProduto(String id) throws ClassNotFoundException, IOException {
		Produto produtoconsultado = produtoDados.consultaProduto(id);
		return produtoconsultado;
	}

}

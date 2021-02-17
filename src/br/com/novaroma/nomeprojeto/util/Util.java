package br.com.novaroma.nomeprojeto.util;

import br.com.novaroma.nomeprojeto.dados.ProdutoDados;
import br.com.novaroma.nomeprojeto.entidades.Produto;

public class Util {

	static ProdutoDados produtoDados;

	public static Produto consultaProduto(String id) {
		Produto[] produtos = produtoDados.lerProduto();

		for (int i = 1; i < produtos.length - 1; i++) {
			if (produtos[i].getId().equals(id)) {
				Produto produtoconsultado = produtos[i];
				return produtoconsultado;
			}
		}

		return null;
	}
	/*
	 * public static boolean verificarEmail(Usuario usuario) { if(usuario.getEmail()
	 * != null && usuario.getEmail().lenght > 0) { return true; } return false; }
	 */
}
package br.com.novaroma.nomeprojeto.apresentacao;

import java.io.IOException;


import br.com.novaroma.nomeprojeto.util.*;
import br.com.novaroma.nomeprojeto.dados.ProdutoDados;
import br.com.novaroma.nomeprojeto.entidades.Cliente;
import br.com.novaroma.nomeprojeto.entidades.Produto;
import br.com.novaroma.nomeprojeto.negocio.ProdutoNegocio;

public class Principal {

	public static void main(String[] args) throws ClassNotFoundException, IOException {
		
		TelaLogin telaLogin = new TelaLogin();
		telaLogin.telaLogin();
		
	}

}

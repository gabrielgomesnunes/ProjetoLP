package br.com.novaroma.nomeprojeto.apresentacao;

import java.io.IOException;

import java.util.Scanner;
import br.com.novaroma.nomeprojeto.dados.ProdutoDados;
import br.com.novaroma.nomeprojeto.entidades.Produto;
import br.com.novaroma.nomeprojeto.negocio.ProdutoNegocio;

public class TelaLogin {
	TelaAdministrador telaAdministrador = new TelaAdministrador();
	static Scanner scan = new Scanner(System.in);
	String senhaAdministrador;
	String senhaNovamente;

	public void telaLogin() throws ClassNotFoundException, IOException {
		String opcaoLogin;

		System.out.println("Você é um administrador ou um funcionário?");
		System.out.println("\nSe você for administrador digite A, se for um funcionário digite F:");
		System.out.print("\n");
		opcaoLogin = scan.next();

		if (opcaoLogin.equalsIgnoreCase("a")) {
			System.out.println("\nDigite a senha: ");
			senhaAdministrador = scan.next();
			if (senhaAdministrador.equals("123adm")) {
				telaAdministrador.telaAdministrador();
			} 
			else {
				
				do {
					System.out.println("\nVocê errou a senha, deseja tentar novamente? sim/não");
					senhaNovamente = scan.next();
					if (senhaNovamente.equalsIgnoreCase("SIM")) {

						System.out.println("\nDigite a senha: ");
						senhaAdministrador = scan.next();
						if (senhaAdministrador.equals("123adm")) {
							telaAdministrador.telaAdministrador();
						}
					} else if (senhaNovamente.equalsIgnoreCase("NÃO")) {
						System.out.println("Você saiu.");
						System.exit(0);
					}
				} while (senhaNovamente != "não");
			}
		}
		else if (opcaoLogin.equalsIgnoreCase("f")) {

		}

	}
}

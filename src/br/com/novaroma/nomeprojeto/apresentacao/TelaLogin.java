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

		System.out.println("Voc� � um administrador ou um funcion�rio?");
		System.out.println("\nSe voc� for administrador digite A, se for um funcion�rio digite F:");
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
					System.out.println("\nVoc� errou a senha, deseja tentar novamente? sim/n�o");
					senhaNovamente = scan.next();
					if (senhaNovamente.equalsIgnoreCase("SIM")) {

						System.out.println("\nDigite a senha: ");
						senhaAdministrador = scan.next();
						if (senhaAdministrador.equals("123adm")) {
							telaAdministrador.telaAdministrador();
						}
					} else if (senhaNovamente.equalsIgnoreCase("N�O")) {
						System.out.println("Voc� saiu.");
						System.exit(0);
					}
				} while (senhaNovamente != "n�o");
			}
		}
		else if (opcaoLogin.equalsIgnoreCase("f")) {

		}

	}
}

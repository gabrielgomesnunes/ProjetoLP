package br.com.novaroma.nomeprojeto.apresentacao;
import java.io.IOException;


import java.util.Scanner;
import br.com.novaroma.nomeprojeto.dados.ProdutoDados;
import br.com.novaroma.nomeprojeto.entidades.Produto;
import br.com.novaroma.nomeprojeto.negocio.ProdutoNegocio;
import br.com.novaroma.nomeprojeto.dados.Dados;
import br.com.novaroma.nomeprojeto.entidades.Cliente;
import br.com.novaroma.nomeprojeto.negocio.ClienteNegocio;
import br.com.novaroma.nomeprojeto.entidades.Funcionario;
import br.com.novaroma.nomeprojeto.negocio.FuncionarioNegocio;

public class TelaAdministrador {
	ProdutoApresentacao produtoApresentacao = new ProdutoApresentacao();
	ClienteApresentacao clienteApresentacao = new ClienteApresentacao();
	FuncionarioApresentacao funcionarioApresentacao = new FuncionarioApresentacao();
	static Scanner scan = new Scanner(System.in);

	public void telaAdministrador() throws ClassNotFoundException, IOException {
		int opcaoMenu;

		do {
			System.out.println("\nTela Administrador!");
			System.out.println("======================");
			System.out.println("|    1 - Produto     |");
			System.out.println("|    2 - Cliente     |");
			System.out.println("|    3 - Vendas      |");
			System.out.println("|    4 - Funcionário |");
			System.out.println("|    0 - Sair        |");
			System.out.println("======================");

			System.out.print("\n");
			opcaoMenu = scan.nextInt();

			switch (opcaoMenu) {

			case 1:
				produtoApresentacao.telaProduto();
				break;

			case 2:
				clienteApresentacao.telaCliente();
				break;

			case 3:
				
				break;

			case 4:
				funcionarioApresentacao.telaFuncionario();
				break;
			case 0:
				System.out.println("\n-> Você saiu.");
				System.exit(0);
				break;
			default:
				System.out.println("-> Opção Inválida.");
				break;

			}

		} while (opcaoMenu != 0);
	}

}

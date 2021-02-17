package br.com.novaroma.nomeprojeto.apresentacao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.novaroma.nomeprojeto.dados.ProdutoDados;
import br.com.novaroma.nomeprojeto.entidades.Produto;
import br.com.novaroma.nomeprojeto.negocio.ProdutoNegocio;

public class ProdutoApresentacao {
	static Scanner scan = new Scanner(System.in);
	private Produto produto;
	static ProdutoNegocio produtoNegocio = new ProdutoNegocio();

	public void telaProduto() throws ClassNotFoundException, IOException {
		int opcaoMenu;

		do {
			System.out.println("\n      Tela do Produto!");
			System.out.println("=============================");
			System.out.println("|    1 - Cadastrar Produto  |");
			System.out.println("|    2 - Remover Produto    |");
			System.out.println("|    3 - Listar Produto     |");
			System.out.println("|    4 - Consultar Produto  |");
			System.out.println("|    5 - Filtrar Produto    |");
			System.out.println("|    6 - Atualizar Produto  |");
			System.out.println("|    0 - Sair               |");
			System.out.println("=============================");

			System.out.print("\n");
			opcaoMenu = scan.nextInt();

			switch (opcaoMenu) {

			case 1:
				Produto produto = preencherProduto();
				String mensagem = produtoNegocio.criticarProduto(produto);
				System.out.println(mensagem);
				break;

			case 2:
				removerProduto("1");
				break;

			case 3:
				listarProdutos();
				break;

			case 4:
				consultarProduto();
				break;
			case 5:
				filtrarProduto();
				break;
			case 6:
				atualizarProduto();
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

	public Produto preencherProduto() {

		System.out.println("\n---------- Tela de cadastro do produto ----------" + "\n");
		System.out.println("-> Digite o Id do produto: ");
		String id = scan.next();

		System.out.println("\n-> Digite o tipo do produto: ");
		String tipo = scan.next();

		System.out.println("\n-> Digite o preço do produto: ");
		double preco = scan.nextDouble();

		return new Produto(id, tipo, preco);
	}

	public static void removerProduto(String id) throws ClassNotFoundException, IOException {

		System.out.println("-> Informe o id que deseja retirar: ");
		id = scan.next();
		produtoNegocio.remover(id);
		System.out.println("\n-> Produto removido com sucesso.");
	}

	public void consultarProduto() throws ClassNotFoundException, IOException {

		System.out.println("Digite o id do produto: ");
		String id = scan.next();
		Produto produtoConsultado = produtoNegocio.consultarProduto(id);
		System.out.println("\n-> Tipo: " + produtoConsultado.getTipo() + ", Preço: R$" + produtoConsultado.getPreco()
				+ ", Id:" + produtoConsultado.getId());
	}

	public void filtrarProduto() throws ClassNotFoundException, IOException {

		List<Produto> filtrado = new ArrayList<Produto>();
		System.out.println("-> Digite o preço mínimo: ");
		double min = scan.nextDouble();
		System.out.println("\n-> Digite o preço máximo: ");
		double max = scan.nextDouble();
		System.out.println("\n-> Digite o tipo do produto: ");
		String tipo = scan.next();

		filtrado.addAll(produtoNegocio.filtrarProduto(min, max, tipo));

		for (int i = 0; i < filtrado.size(); i++) {
			System.out.println("\n-> Tipo: " + ((Produto) filtrado.get(i)).getTipo() + ", Preço: R$"
					+ ((Produto) filtrado.get(i)).getPreco() + ", Id: " + ((Produto) filtrado.get(i)).getId());
		}
	}

	public void listarProdutos() throws ClassNotFoundException, IOException {

		List listaProdutos = produtoNegocio.listaProdutos();

		for (int i = 0; i < listaProdutos.size(); i++) {
			System.out.println("\n-> Tipo: " + ((Produto) listaProdutos.get(i)).getTipo() + ", Preço: R$"
					+ ((Produto) listaProdutos.get(i)).getPreco() + ", Id: "
					+ ((Produto) listaProdutos.get(i)).getId());
		}
	}

	public void atualizarProduto() throws ClassNotFoundException, IOException {

		System.out.println("\n-> Digite o Id do produto que deseja atualizar: ");
		String id = scan.next();

		System.out.println("\n-> Você deseja modificar o preço do produto?");
		System.out.println("\n-> Se deseja digite 'SIM', caso contrário digite 'NÃO'.");
		String cond = scan.next();

		if (cond.equalsIgnoreCase("sim")) {
			System.out.println("\n-> Informe o novo preço do produto: ");
			double preco = scan.nextDouble();
			produtoNegocio.atualizarProduto(id, preco);
			System.out.println("\n-> O Produto modificado.");

		} else {
			System.out.println("\n-> O Produto não foi modificado.");
		}

	}

}
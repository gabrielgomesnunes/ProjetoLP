package br.com.novaroma.nomeprojeto.apresentacao;

import java.io.IOException;


import java.util.List;
import java.util.Scanner;

import br.com.novaroma.nomeprojeto.dados.Dados;
import br.com.novaroma.nomeprojeto.entidades.Cliente;
import br.com.novaroma.nomeprojeto.negocio.ClienteNegocio;

public class ClienteApresentacao {
	static Scanner scan = new Scanner(System.in);
	private Cliente cliente;
	static ClienteNegocio clienteNegocio = new ClienteNegocio();

	public void telaCliente() throws ClassNotFoundException, IOException {
		int opcaoMenu;

		do {
			System.out.println("\n      Tela do Cliente!");
			System.out.println("=============================");
			System.out.println("|    1 - Cadastrar Cliente  |");
			System.out.println("|    2 - Remover Cliente    |");
			System.out.println("|    3 - Listar Cliente     |");
			System.out.println("|    4 - Consultar Cliente  |");
			System.out.println("|    5 - Atualizar Cliente  |");
			System.out.println("|    0 - Sair               |");
			System.out.println("=============================");

			System.out.print("\n");
			opcaoMenu = scan.nextInt();

			switch (opcaoMenu) {

			case 1:
				cliente = preencherCliente();
				String mensagem = clienteNegocio.criticarCliente(cliente);
				System.out.println(mensagem);
				break;
			case 2:
				removerCliente("1");
				break;
			case 3:
				listaCliente();
				break;
			case 4:
				consultarCliente();
				break;
			case 5:
				atualizarCliente();
				break;
			case 0:
				System.out.println("\n-> Você saiu.");
				System.exit(0);
				break;
			default:
				System.out.println("\n-> Opção Inválida.");
				break;

			}

		} while (opcaoMenu != 0);
	}

	public Cliente preencherCliente() {

		System.out.println("\n---------- Tela de cadastro do Cliente ----------" + "\n");
		System.out.println("-> Digite o CPF do Cliente: ");
		String cpf = scan.next();

		System.out.println("\n-> Digite o nome do Cliente: ");
		String nome = scan.next();

		System.out.println("\n-> Digite o telefone do Cliente: ");
		String telefone = scan.next();

		System.out.println("\n-> Digite o e-mail do Cliente: ");
		String email = scan.next();

		return new Cliente(cpf, nome, telefone, email);
	}

	public void listaCliente() throws ClassNotFoundException, IOException {
		List lista = clienteNegocio.listaClientes();

		for (int i = 0; i < lista.size(); i++) {
			System.out.println("CPF: " + ((Cliente) lista.get(i)).getCpf() + ", nome: "
					+ ((Cliente) lista.get(i)).getNome() + ", telefone: " + ((Cliente) lista.get(i)).getTelefone()
					+ ", e-mail: " + ((Cliente) lista.get(i)).getEmail());
		}
	}

	public static void removerCliente(String cpf) throws ClassNotFoundException, IOException {

		System.out.println("\n-> Informe o cpf que deseja retirar: ");
		cpf = scan.next();
		clienteNegocio.remover(cpf);
		System.out.println("\n-> Cliente removido com sucesso.");
	}

	public void consultarCliente() throws ClassNotFoundException, IOException {

		System.out.println("Digite o cpf do cliente: ");
		String cpf = scan.next();
		Cliente clienteConsultado = clienteNegocio.consultarCliente(cpf);
		System.out.println("\n-> CPF: " + clienteConsultado.getCpf() + ", Nome: " + clienteConsultado.getNome()
				+ ", e-mail:" + clienteConsultado.getEmail() + ", Telefone: " + clienteConsultado.getTelefone());
	}

	public void atualizarCliente() throws ClassNotFoundException, IOException {

		System.out.println("\n-> Digite o CPF do cliente que deseja atualizar: ");
		String cpf = scan.next();

		System.out.println("\n-> Você deseja modificar o cliente?");
		System.out.println("\n-> Se deseja digite 'SIM', caso contrário digite 'NÃO'.");
		String cond = scan.next();

		if (cond.equalsIgnoreCase("sim")) {
			System.out.println("\n-> Informe o novo nome do cliente: (Ex: Neto)");
			String nome = scan.next();
			System.out.println("\n-> Informe o novo e-mail do cliente: (Ex: novoemail@gmail.com)");
			String email = scan.next();
			System.out.println("\n-> Informe o novo telefone do cliente: (Ex: (81)9956-3711)");
			String telefone = scan.next();
			clienteNegocio.atualizarCliente(cpf, nome, email, telefone);
			System.out.println("\n-> Cliente atualizado.");

		} else {
			System.out.println("\n-> O Cliente não foi atualizado.");
		}

	}
}

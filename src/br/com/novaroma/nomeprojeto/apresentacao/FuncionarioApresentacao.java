package br.com.novaroma.nomeprojeto.apresentacao;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import br.com.novaroma.nomeprojeto.dados.Dados;
import br.com.novaroma.nomeprojeto.entidades.Cliente;
import br.com.novaroma.nomeprojeto.entidades.Funcionario;
import br.com.novaroma.nomeprojeto.negocio.ClienteNegocio;
import br.com.novaroma.nomeprojeto.negocio.FuncionarioNegocio;

public class FuncionarioApresentacao {
	static Scanner scan = new Scanner(System.in);
	private Funcionario funcionario;
	static FuncionarioNegocio funcionarioNegocio = new FuncionarioNegocio();

	public void telaFuncionario() throws ClassNotFoundException, IOException {
		int opcaoMenu;

		do {
			System.out.println("\n      Tela do Funcion�rio!");
			System.out.println("=================================");
			System.out.println("|    1 - Cadastrar Funcion�rio  |");
			System.out.println("|    2 - Remover Funcion�rio    |");
			System.out.println("|    3 - Listar Funcion�rio     |");
			System.out.println("|    4 - Consultar Funcion�rio  |");
			System.out.println("|    5 - Atualizar Funcion�rio  |");
			System.out.println("|    0 - Sair                   |");
			System.out.println("=================================");

			System.out.print("\n");
			opcaoMenu = scan.nextInt();

			switch (opcaoMenu) {

			case 1:
				Funcionario funcionario = preencherFuncionario();
				String mensagem = funcionarioNegocio.criticarFuncionario(funcionario);
				System.out.println(mensagem);
				break;
			case 2:
				removerFuncionario("1");
				break;
			case 3:
				listaFuncionario();
				break;
			case 4:
				consultarFuncionario();
				break;
			case 5:
				atualizarFuncionario();
				break;
			case 0:
				System.out.println("\n-> Voc� saiu.");
				System.exit(0);
				break;
			default:
				System.out.println("\n-> Op��o Inv�lida.");
				break;

			}

		} while (opcaoMenu != 0);
	}

	public Funcionario preencherFuncionario() {

		System.out.println("\n---------- Tela de cadastro do Funcion�rio ----------" + "\n");

		System.out.println("\n-> Digite o nome do Funcion�rio: ");
		String nome = scan.next();

		System.out.println("\n-> Digite o e-mail do Funcion�rio: ");
		String email = scan.next();

		System.out.println("\n-> Digite o telefone do Funcion�rio: ");
		String telefone = scan.next();

		System.out.println("-> Digite o CPF do Funcion�rio: ");
		String cpf = scan.next();

		System.out.println("\n-> Digite a senha do Funcion�rio: ");
		String senha = scan.next();

		return new Funcionario(nome, email, telefone, cpf, senha);
	}

	public void listaFuncionario() throws ClassNotFoundException, IOException {
		List lista = funcionarioNegocio.listaFuncionarios();

		for (int i = 0; i < lista.size(); i++) {
			System.out.println("CPF: " + ((Funcionario) lista.get(i)).getCpf() + ", nome: "
					+ ((Funcionario) lista.get(i)).getNome() + ", telefone: "
					+ ((Funcionario) lista.get(i)).getTelefone() + ", e-mail: "
					+ ((Funcionario) lista.get(i)).getEmail() + ", senha: " + ((Funcionario) lista.get(i)).getSenha());
		}
	}

	public static void removerFuncionario(String cpf) throws ClassNotFoundException, IOException {

		System.out.println("\n-> Informe o cpf que deseja retirar: ");
		cpf = scan.next();
		funcionarioNegocio.remover(cpf);
		System.out.println("\n-> Funcion�rio removido com sucesso.");
	}

	public void consultarFuncionario() throws ClassNotFoundException, IOException {

		System.out.println("Digite o cpf do cliente: ");
		String cpf = scan.next();
		Funcionario funcionarioConsultado = funcionarioNegocio.consultarFuncionarios(cpf);
		System.out.println("\n-> CPF: " + funcionarioConsultado.getCpf() + ", Nome: " + funcionarioConsultado.getNome()
				+ ", e-mail:" + funcionarioConsultado.getEmail() + ", Telefone: "
				+ funcionarioConsultado.getTelefone());
	}

	public void atualizarFuncionario() throws ClassNotFoundException, IOException {

		System.out.println("\n-> Digite o CPF do funcion�rio que deseja atualizar: ");
		String cpf = scan.next();

		System.out.println("\n-> Voc� deseja modificar o funcion�rio?");
		System.out.println("\n-> Se deseja digite 'SIM', caso contr�rio digite 'N�O'.");
		String cond = scan.next();

		if (cond.equalsIgnoreCase("sim")) {
			System.out.println("\n-> Informe o novo nome do funcion�rio: (Ex: Neto)");
			String nome = scan.next();

			System.out.println("\n-> Informe o novo e-mail do funcion�rio: (Ex: novoemail@gmail.com)");
			String email = scan.next();

			System.out.println("\n-> Informe o novo telefone do funcion�rio: (Ex: (81)9956-3711)");
			String telefone = scan.next();

			/*
			 * System.out.
			 * println("\n-> Informe a nova senha do funcion�rio: (Ex: eduardo123"); String
			 * senha = scan.next();
			 */
			funcionarioNegocio.atualizarFuncionarios(cpf, nome, email, telefone);
			System.out.println("\n-> Funcion�rio atualizado.");

		} else {
			System.out.println("\n-> O Funcion�rio n�o foi atualizado.");
		}

	}

}

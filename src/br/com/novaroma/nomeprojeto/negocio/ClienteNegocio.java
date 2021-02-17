package br.com.novaroma.nomeprojeto.negocio;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import br.com.novaroma.nomeprojeto.apresentacao.ClienteApresentacao;
import br.com.novaroma.nomeprojeto.dados.Dados;
import br.com.novaroma.nomeprojeto.entidades.Cliente;

public class ClienteNegocio {
	Scanner scan = new Scanner(System.in);
	Dados<Cliente> dadosCliente = new Dados<Cliente>();

	public String criticarCliente(Cliente cliente) throws ClassNotFoundException, IOException {
		
		if (this.dadosCliente.consultar(cliente.getCpf()) != null) {
			return "\n-> Erro: O cliente já foi cadastrado!";
		}
		if (cliente.getCpf().length() != 11) {
			return "\n-> Erro: O cpf deve ter exatamente 11 digitos!";
		}

		if (dadosCliente.cadastrar(cliente)) {
			return "\n-> O cliente foi cadastrado com sucesso!";
		}

		return "\n-> Erro: O cliente não foi cadastrado.";
	}

	public ArrayList<Cliente> listaClientes() throws ClassNotFoundException, IOException {
		return dadosCliente.listar();
	}

	public void remover(String cpf) throws ClassNotFoundException, IOException {
		dadosCliente.remover(cpf);
	}

	public boolean atualizarCliente(String cpf, String nome, String telefone, String email)
			throws ClassNotFoundException, IOException {
		dadosCliente.atualizar(cpf, nome, telefone, email);

		return true;
	}

	public Cliente consultarCliente(String cpf) throws ClassNotFoundException, IOException {
		return dadosCliente.consultar(cpf);
	}
}

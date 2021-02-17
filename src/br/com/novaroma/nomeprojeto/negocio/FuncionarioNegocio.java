package br.com.novaroma.nomeprojeto.negocio;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import br.com.novaroma.nomeprojeto.apresentacao.FuncionarioApresentacao;
import br.com.novaroma.nomeprojeto.dados.Dados;
import br.com.novaroma.nomeprojeto.dados.ProdutoDados;
import br.com.novaroma.nomeprojeto.entidades.Cliente;
import br.com.novaroma.nomeprojeto.entidades.Funcionario;
import br.com.novaroma.nomeprojeto.entidades.Produto;

public class FuncionarioNegocio {
	Scanner scan = new Scanner(System.in);
	Dados<Funcionario> dadosFuncionario = new Dados<Funcionario>();

	public String criticarFuncionario(Funcionario funcionario) throws ClassNotFoundException, IOException {
		if (this.dadosFuncionario.consultar(funcionario.getCpf()) != null) {
			return "\n-> Erro: O funcionário já foi cadastrado!";
		}
		if (funcionario.getCpf().length() != 11) {
			return "\n-> Erro: O cpf deve ter exatamente 11 digitos.";
		}

		if (dadosFuncionario.cadastrar(funcionario)) {
			return "\n-> O funcionário foi cadastrado com sucesso.";
		}

		return "\n-> Erro: O funcionário não foi cadastrado.";
	}

	public ArrayList<Funcionario> listaFuncionarios() throws ClassNotFoundException, IOException {
		return dadosFuncionario.listar();
	}

	public void remover(String cpf) throws ClassNotFoundException, IOException {
		dadosFuncionario.remover(cpf);
	}

	public boolean atualizarFuncionarios(String cpf, String nome, String telefone, String email)
			throws ClassNotFoundException, IOException {
		dadosFuncionario.atualizar(cpf, nome, telefone, email);

		return true;
	}

	public Funcionario consultarFuncionarios(String cpf) throws ClassNotFoundException, IOException {
		return dadosFuncionario.consultar(cpf);
	}

}

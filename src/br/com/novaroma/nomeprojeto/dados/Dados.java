package br.com.novaroma.nomeprojeto.dados;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import br.com.novaroma.nomeprojeto.entidades.Cliente;
import br.com.novaroma.nomeprojeto.entidades.Funcionario;

public class Dados<T> {
	File arquivo;
	ArrayList<T> colecao = new ArrayList<T>();
	T objeto;

	public boolean criarArquivo(T objeto) throws IOException, ClassNotFoundException {
		/*
		 * if (objeto instanceof Cliente) { arquivo = new File("arquivos/Cliente.txt");
		 * }
		 * 
		 * if (objeto instanceof Funcionario) { arquivo = new
		 * File("arquivos/Funcionario.txt"); }
		 */

		arquivo = new File(objeto.getClass().getCanonicalName() + ".txt.");

		colecao = ler();
		FileOutputStream fos = new FileOutputStream(arquivo);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(colecao);
		oos.close();
		oos.flush();
		return true;

	}

	public boolean cadastrar(T objeto) throws ClassNotFoundException, IOException {
		criarArquivo(objeto);
		colecao = ler();

		colecao.add(objeto);

		FileOutputStream fos = new FileOutputStream(arquivo);

		ObjectOutputStream oos = new ObjectOutputStream(fos);

		oos.writeObject(colecao);

		oos.close();

		return true;
	}

	public T consultar(String cpf) throws ClassNotFoundException, IOException {

		colecao = ler();

		for (int i = 1; i < colecao.size(); i++) {
			if (colecao.get(i).equals(cpf)) {
				T consultado = colecao.get(i);
				return consultado;
			}
		}

		return null;

	}

	public ArrayList<T> listar() throws ClassNotFoundException, IOException {

		colecao = ler();
		for (int i = 1; i < colecao.size(); i++) {
			return (ArrayList<T>) colecao;
		}
		return null;
	}

	public ArrayList<T> ler() {

		if (this.arquivo.exists()) {
			 FileInputStream fis;
			try {
				System.out.println(arquivo);
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivo));
				this.colecao = (ArrayList<T>) ois.readObject();
				ois.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else {
			try {
				this.arquivo.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		return colecao;
	}

	public void remover(String cpf) throws ClassNotFoundException, IOException {

		if (arquivo.exists()) {

			FileInputStream fis = new FileInputStream(arquivo);
			ObjectInputStream ois = new ObjectInputStream(fis);
			colecao = (ArrayList<T>) ois.readObject();
			ois.close();

			int aux = 0;

			List<T> listAux = new ArrayList<T>();

			for (int i = 0; i < colecao.size(); i++) {

				if (colecao.get(i) != null && !(cpf.equals(colecao.get(i).getClass().getCanonicalName()))) {
					listAux.add(colecao.get(i));

				}

			}
			colecao = (ArrayList<T>) listAux;
			FileOutputStream fos = new FileOutputStream(arquivo);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(colecao);
			oos.flush();
			oos.close();
		}
	}

	public void atualizar(String cpf, String nome, String telefone, String email)
			throws ClassNotFoundException, IOException {

		if (arquivo.exists()) {

			FileInputStream fis = new FileInputStream(arquivo);
			ObjectInputStream ois = new ObjectInputStream(fis);
			colecao = (ArrayList<T>) ois.readObject();
			ois.close();

			for (int i = 0; i < colecao.size(); i++) {

				if (colecao.get(i) != null && cpf.equals(colecao.get(i).getClass().getCanonicalName())) {
					colecao.get(i).getClass(nome);
					colecao.get(i).setTelefone(telefone);
					colecao.get(i).setEmail(email);

				}

			}

			FileOutputStream fos = new FileOutputStream(arquivo);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(colecao);
			oos.flush();
			oos.close();
		}

	}
}

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

import br.com.novaroma.nomeprojeto.entidades.Produto;

public class ProdutoDados {
	File arquivo = new File("produto.txt");
	ArrayList<Produto> colecaoProdutos = new ArrayList<Produto>();
	private Produto produto;

	public boolean cadastrarProduto(Produto produto) throws ClassNotFoundException, IOException {
		colecaoProdutos = lerProduto();

		colecaoProdutos.add(produto);

		FileOutputStream fos = new FileOutputStream(arquivo);

		ObjectOutputStream oos = new ObjectOutputStream(fos);

		oos.writeObject(colecaoProdutos);

		oos.close();

		oos.flush();

		return true;
	}

	public void atualizarProduto(String id, double preco) throws ClassNotFoundException, IOException {
		File arquivo = new File("produto.txt");

		if (arquivo.exists()) {

			FileInputStream fis = new FileInputStream(arquivo);
			ObjectInputStream ois = new ObjectInputStream(fis);
			colecaoProdutos = (ArrayList<Produto>) ois.readObject();
			ois.close();

			for (int i = 0; i < colecaoProdutos.size(); i++) {

				if (colecaoProdutos.get(i) != null && id.equals(colecaoProdutos.get(i).getId())) {
					colecaoProdutos.get(i).setPreco(preco);

				}

			}

			FileOutputStream fos = new FileOutputStream(arquivo);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(colecaoProdutos);
			oos.flush();
			oos.close();
		}

	}

	public void removerProduto(String id) throws ClassNotFoundException, IOException {
		File arquivo = new File("produto.txt");

		if (arquivo.exists()) {

			FileInputStream fis = new FileInputStream(arquivo);
			ObjectInputStream ois = new ObjectInputStream(fis);
			colecaoProdutos = (ArrayList<Produto>) ois.readObject();
			ois.close();

			List<Produto> listAux = new ArrayList<Produto>();

			for (int i = 0; i < colecaoProdutos.size(); i++) {

				if (colecaoProdutos.get(i) != null && !(id.equals(colecaoProdutos.get(i).getId()))) {
					listAux.add(colecaoProdutos.get(i));

				}

			}
			colecaoProdutos = (ArrayList<Produto>) listAux;
			FileOutputStream fos = new FileOutputStream(arquivo);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(colecaoProdutos);
			oos.flush();
			oos.close();
		}
	}

	public boolean criarArquivo(Produto produto) throws IOException, ClassNotFoundException {

		colecaoProdutos = lerProduto();
		FileOutputStream fos = new FileOutputStream(arquivo);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(colecaoProdutos);
		oos.close();
		oos.flush();
		return true;
	}

	public ArrayList<Produto> lerProduto() {

		if (this.arquivo.exists()) {
			FileInputStream fis;
			try {
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivo));

				colecaoProdutos = (ArrayList<Produto>) ois.readObject();

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
			// colecaoProdutos = new ArrayList<Produto>();
		}
		return colecaoProdutos;

	}

	public Produto consultaProduto(String id) throws ClassNotFoundException, IOException {
		colecaoProdutos = lerProduto();

		for (int i = 1; i < colecaoProdutos.size(); i++) {
			if (colecaoProdutos.get(i).getId().equals(id)) {
				Produto produtoconsultado = colecaoProdutos.get(i);
				return produtoconsultado;
			}
		}

		return null;
	}

	public ArrayList<Produto> listaProdutos() throws ClassNotFoundException, IOException {

		colecaoProdutos = lerProduto();
		for (int i = 1; i < colecaoProdutos.size(); i++) {
			return colecaoProdutos;
		}
		return null;
	}

	public ArrayList<Produto> filtro(double valorMinimo, double valorMaximo, String tipo)

			throws ClassNotFoundException, IOException {
		colecaoProdutos = lerProduto();

		List<Produto> filtrado = new ArrayList<Produto>();

		for (int i = 0; i < colecaoProdutos.size(); i++) {
			if ((colecaoProdutos.get(i).getPreco() >= valorMinimo && colecaoProdutos.get(i).getPreco() <= valorMaximo)
					&& colecaoProdutos.get(i).getTipo().equals(tipo)) {
				filtrado.add(colecaoProdutos.get(i));
			}
		}
		return (ArrayList<Produto>) filtrado;
	}

}
package Armazem;

import java.util.TreeMap;

import ingredientes.Fruta;
import ingredientes.Ingrediente;;

public class Armazem {

	private TreeMap<Ingrediente, Integer> estoque;

	public Armazem() {
		this.estoque = new TreeMap();
	}

	public void cadastrarIngredienteEmEstoque(Ingrediente ingrediente) throws Exception {

		if (estoque.get(ingrediente) != null)
			throw new IllegalArgumentException("_ingrediente já cadastrado_");

		this.estoque.put(ingrediente, 0);
	}

	public void descadastrarIngredientesEmEstoque(Ingrediente ingrediente) {

		if (estoque.get(ingrediente) == null)
			throw new IllegalArgumentException("_ingrediente não encontrado_");

		this.estoque.remove(ingrediente);
	}

	public void adicionarQuantidadeDoIngredienteEmEstoque(Ingrediente ingrediente, Integer quantidade) {

		if (estoque.get(ingrediente) == null)
			throw new IllegalArgumentException("_ingrediente não encontrado_");

		if (quantidade <= 0)
			throw new IllegalArgumentException("quantidade inválida_");

		this.estoque.put(ingrediente, estoque.get(ingrediente) + quantidade);

	}

	public void reduzirQuantidadeDoIngredienteEmEstoque(Ingrediente ingrediente, Integer quantidade) {

		if (estoque.get(ingrediente) == null)
			throw new IllegalArgumentException("_ingrediente não encontrado_");

		if (quantidade <= 0)
			throw new IllegalArgumentException("quantidade inválida_");

		if (estoque.get(ingrediente) <= quantidade)
			throw new IllegalArgumentException("quantidade inválida_");

		this.estoque.replace(ingrediente, estoque.get(ingrediente) - quantidade);

	}

	public void consultarQuantidadeDoIngredienteEmEstoque(Ingrediente ingrediente) {
		// TODO Auto-generated method stub
		if (estoque.get(ingrediente) == null)
			throw new IllegalArgumentException("_ingrediente não encontrado_");
		
		
	}

}

package com.example.TDD;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import Armazem.Armazem;
import ingredientes.Fruta;
import ingredientes.TipoFruta;

@SpringBootTest
class TddApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void cadastrarIngredienteEmEstoque() {
		Throwable erro = Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Armazem armazem = new Armazem();
			Fruta fruta = new Fruta(TipoFruta.Abacate);
			armazem.cadastrarIngredienteEmEstoque(fruta);
			armazem.cadastrarIngredienteEmEstoque(fruta);
		});

		Assertions.assertEquals(erro.getMessage(), "_ingrediente já cadastrado_");
	}

	@Test
	void descadastrarIngredientesEmEstoque() {

		Throwable erro = Assertions.assertThrows(IllegalArgumentException.class, () -> {

			Armazem armazem = new Armazem();
			Fruta fruta = new Fruta(TipoFruta.Abacate);
			armazem.descadastrarIngredientesEmEstoque(fruta);

		});

		Assertions.assertEquals(erro.getMessage(), "_ingrediente não encontrado_");

	}

	@Test
	void adicionarQuantidadeDoIngredienteEmEstoque() {

		Throwable wrongIngredient = Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Armazem armazem = new Armazem();
			Fruta fruta = new Fruta(TipoFruta.Banana);
			armazem.adicionarQuantidadeDoIngredienteEmEstoque(fruta, Integer.valueOf(5));
		});

		Throwable wrongQtd = Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Armazem armazem = new Armazem();
			Fruta fruta = new Fruta(TipoFruta.Banana);
			armazem.cadastrarIngredienteEmEstoque(fruta);
			armazem.adicionarQuantidadeDoIngredienteEmEstoque(fruta, Integer.valueOf(-5));
		});

		Assertions.assertEquals(wrongIngredient.getMessage(), "_ingrediente não encontrado_");
		Assertions.assertEquals(wrongQtd.getMessage(), "quantidade inválida_");

	}

	@Test
	void reduzirQuantidadeDoIngredienteEmEstoque() {

		Throwable wrongIngredient = Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Armazem armazem = new Armazem();
			Fruta fruta = new Fruta(TipoFruta.Banana);
			armazem.reduzirQuantidadeDoIngredienteEmEstoque(fruta, Integer.valueOf(5));
		});

		Throwable negativeQtd = Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Armazem armazem = new Armazem();
			Fruta fruta = new Fruta(TipoFruta.Banana);
			armazem.cadastrarIngredienteEmEstoque(fruta);
			armazem.reduzirQuantidadeDoIngredienteEmEstoque(fruta, Integer.valueOf(-5));
		});

		Throwable lessThanCurrent = Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Armazem armazem = new Armazem();
			Fruta fruta = new Fruta(TipoFruta.Banana);
			armazem.cadastrarIngredienteEmEstoque(fruta);
			armazem.adicionarQuantidadeDoIngredienteEmEstoque(fruta, 2);
			armazem.reduzirQuantidadeDoIngredienteEmEstoque(fruta, Integer.valueOf(5));
		});

		Assertions.assertEquals(wrongIngredient.getMessage(), "_ingrediente não encontrado_");
		Assertions.assertEquals(negativeQtd.getMessage(), "quantidade inválida_");
		Assertions.assertEquals(lessThanCurrent.getMessage(), "quantidade inválida_");
	}

	@Test
	void consultarQuantidadeDoIngredienteEmEstoque() {
		
		Throwable wrongIngredient = Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Armazem armazem = new Armazem();
			Fruta fruta = new Fruta(TipoFruta.Banana);
			armazem.consultarQuantidadeDoIngredienteEmEstoque(fruta);
		});

		Assertions.assertEquals(wrongIngredient.getMessage(), "_ingrediente não encontrado_");
	}

}

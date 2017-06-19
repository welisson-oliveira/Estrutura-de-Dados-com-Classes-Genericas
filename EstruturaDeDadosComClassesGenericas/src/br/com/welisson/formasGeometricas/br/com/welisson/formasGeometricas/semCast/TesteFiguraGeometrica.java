package br.com.welisson.formasGeometricas.br.com.welisson.formasGeometricas.semCast;

import br.com.welisson.formasGeometricas.br.com.welisson.formasGeometricas.FormaGeometrica;
import br.com.welisson.formasGeometricas.br.com.welisson.formasGeometricas.Quadrado;
import br.com.welisson.formasGeometricas.br.com.welisson.formasGeometricas.Retangulo;
import br.com.welisson.listaDuplamenteEncadeada.certo.ListDupEncadeada;
import br.com.welisson.listaDuplamenteEncadeada.certo.IteratorExample;

/**
 * {@link TesteFiguraGeometrica}
 *
 * @author Welisson Oliveira
 * @version 1.0 19/06/2017
 */
public class TesteFiguraGeometrica {

	public static void main(String[] args) {
		// Lista encadeada genérica para armazenar FormaGeometrica
		ListDupEncadeada<FormaGeometrica> lista = new ListDupEncadeada<FormaGeometrica>();
		int val;

		// Mostra o tamanho atual da lista
		System.out.println("Tamanho: " + lista.getTamanho());

		// Laço de inserção
		for(int i = 1; i <= 3; i++) {
			// Instancia e insere um Quadrado no início da lista
			val = lista.insereInicio(new Quadrado(2.25f * i));
			// Mostra o conteúdo da primeira posição da lista
			System.out.println("Inserindo: \""+lista.consulta(1)+"\" -> Tamanho: "+val);
			// Instancia e insere um Retangulo no início da lista
			val = lista.insereInicio(new Retangulo(3.567f * i, 5.951f + i));
			// Mostra o conteúdo da primeira posição da lista
			System.out.println("Inserindo: \""+lista.consulta(1)+"\" -> Tamanho: "+val);
		}

		// Mostra o tamanho atual da lista
		System.out.println("\nTamanho: " + lista.getTamanho());

		System.out.println("\nIterando sobre a lista:\n");
		System.out.println("Perímetros:");

		// Iterador utilizado para percorrer a lista encadeada
		IteratorExample<FormaGeometrica> iterador = lista.iteradorInicio();

		// Contador de posições
		int c = 1;
		// Laço para percorrer a lista utilizando o iterador
		while (iterador.eValido()) {
			// Mostra o perímetro de cada FiguraGeometrica armazenada na lista
			// É necessário realizar um cast porque a interface Iterator não conhece
			// o tipo que está armazenado na lista
			System.out.println("Posição " + c++ + ": -> \t" + (iterador.dado()).perimetro());
			iterador.proximo();
		}

		System.out.println("Áreas:");
		// Iterador utilizado para percorrer a lista encadeada
		iterador = lista.iteradorInicio();

		// Contador de posições
		c = 1;
		// Laço para percorrer a lista utilizando o iterador
		while (iterador.eValido()) {
			// Mostra a área de cada FiguraGeometrica armazenada na lista
			System.out.println("Posição " + c++ + ": -> \t" + (iterador.dado()).area());
			iterador.proximo();
		}

		System.out.println("");
		// Laço para remover todos os elementos da lista
		while(lista.getTamanho() > 0) {
			System.out.println("Removido do início: \"" + lista.removeInicio() + "\" -> Tamanho: " + lista.getTamanho());
		}
	}
}

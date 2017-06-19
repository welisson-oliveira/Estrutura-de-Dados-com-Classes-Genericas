package br.com.welisson.formasGeometricas.br.com.welisson.formasGeometricas.castNecessario;

import br.com.welisson.formasGeometricas.br.com.welisson.formasGeometricas.FormaGeometrica;
import br.com.welisson.formasGeometricas.br.com.welisson.formasGeometricas.Quadrado;
import br.com.welisson.formasGeometricas.br.com.welisson.formasGeometricas.Retangulo;

/**
 * {@link TesteFiguraGeometrica}
 *
 * @author Welisson Oliveira
 * @version 1.0 19/06/2017
 */
public class TesteFiguraGeometrica {

	public static void main(String[] args) {
		// Lista encadeada gen�rica para armazenar FormaGeometrica
		ListDupEncadeada lista = new ListDupEncadeada();
		int val;

		// Mostra o tamanho atual da lista
		System.out.println("Tamanho: " + lista.getTamanho());

		// La�o de inser��o
		for(int i = 1; i <= 3; i++) {
			// Instancia e insere um Quadrado no in�cio da lista
			val = lista.insereInicio(new Quadrado(2.25f * i));
			// Mostra o conte�do da primeira posi��o da lista
			System.out.println("Inserindo: \""+lista.consulta(1)+"\" -> Tamanho: "+val);
			// Instancia e insere um Retangulo no in�cio da lista
			val = lista.insereInicio(new Retangulo(3.567f * i, 5.951f + i));
			// Mostra o conte�do da primeira posi��o da lista
			System.out.println("Inserindo: \""+lista.consulta(1)+"\" -> Tamanho: "+val);
		}

		// Mostra o tamanho atual da lista
		System.out.println("\nTamanho: " + lista.getTamanho());

		System.out.println("\nIterando sobre a lista:\n");
		System.out.println("Per�metros:");

		// Iterador utilizado para percorrer a lista encadeada
		Iterator iterador = lista.iteradorInicio();

		// Contador de posi��es
		int c = 1;
		// La�o para percorrer a lista utilizando o iterador
		while (iterador.eValido()) {
			// Mostra o per�metro de cada FiguraGeometrica armazenada na lista
			// � necess�rio realizar um cast porque a interface Iterator n�o conhece
			// o tipo que est� armazenado na lista
			System.out.println("Posi��o " + c++ + ": -> \t" + ((FormaGeometrica)iterador.dado()).perimetro());
			iterador.proximo();
		}

		System.out.println("�reas:");
		// Iterador utilizado para percorrer a lista encadeada
		iterador = lista.iteradorInicio();

		// Contador de posi��es
		c = 1;
		// La�o para percorrer a lista utilizando o iterador
		while (iterador.eValido()) {
			// Mostra a �rea de cada FiguraGeometrica armazenada na lista
			System.out.println("Posi��o " + c++ + ": -> \t" + ((FormaGeometrica)iterador.dado()).area());
			iterador.proximo();
		}

		System.out.println("");
		// La�o para remover todos os elementos da lista
		while(lista.getTamanho() > 0) {
			System.out.println("Removido do in�cio: \"" + lista.removeInicio() + "\" -> Tamanho: " + lista.getTamanho());
		}
	}
}

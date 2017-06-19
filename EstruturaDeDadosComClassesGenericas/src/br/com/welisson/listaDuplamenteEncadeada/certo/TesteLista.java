package br.com.welisson.listaDuplamenteEncadeada.certo;

/**
 * {@link TesteLista}
 *
 * @author Welisson Oliveira
 * @version 1.0 19/06/2017
 */
public class TesteLista {

	public static void main(String[] args) {
		ListDupEncadeada<String> lista = new ListDupEncadeada<String>();

		System.out.println("Tamanho: " + lista.getTamanho());
		for (int i = 1; i <= 5; i++) {
			int val = lista.insereInicio(String.format("str teste %d", i));
			System.out.println("Inserindo: \"" + lista.consulta(1) + "\" -> Tamanho: " + val);
			// Erro de compila��o ao tentar inserir um objeto que n�o seja do tipo String
			// lista.insereInicio(i);
		}

		System.out.println("\nTamanho: " + lista.getTamanho());

		System.out.println("\nIterando sobre a lista:\n");
		// Iterador utilizado para percorrer a lista encadeada
		IteratorExample iterador = lista.iteradorInicio();

		// Contador de posi��es
		int c = 1;
		// La�o para percorrer a lista utilizando o iterador
		while (iterador.eValido()) {
			// Mostrar o valor armazenado em cada posi��o da lista
			System.out.println("Posi��o " + c++ + ": -> " + iterador.dado());
			iterador.proximo();
		}

		System.out.println("");
		for (int i = 1; i <= 5; i++) {
			System.out
					.println("Removido do in�cio: \"" + lista.removeInicio() + "\" -> Tamanho: " + lista.getTamanho());
		}
	}
}

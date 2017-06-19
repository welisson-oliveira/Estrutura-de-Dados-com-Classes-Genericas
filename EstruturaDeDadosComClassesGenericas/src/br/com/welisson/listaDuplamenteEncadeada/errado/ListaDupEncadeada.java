package br.com.welisson.listaDuplamenteEncadeada.errado;

import java.util.Iterator;

/**
 * {@link ListaDupEncadeada}
 *
 * @author Welisson Oliveira
 * @version 1.0 14/06/2017
 */
public class ListaDupEncadeada {
	// A classe que representa os nós da lista utiliza a classe Object para definir a referência ao dado associado à posição da lista que este nó representa.
	private class No {
		// Referência ao próximo elemento da lista
		No proximo;
		// Referência ao elemento anterior na lista
		No anterior;
		// Referência ao dado armazenado no nó atual da lista
		Object dado;

		// Constrói um nó para armazenar um objeto na lista
		No(Object obj) {
			dado = obj;
		}

		// Constrói um nó para armazenar um objeto na lista, indicando quais os
		// nós anterior e próximo
		No(Object obj, No prox, No ant) {
			this.proximo = prox;
			this.anterior = anterior;
			this.dado = obj;
		}
	}

	// Implementação da interface Iterator, que define os métodos de navegação na lista
	private class IteratorLista implements Iterator {
		// Referência ao nó apontado pelo iterador da lista durante a navegação
		No noAtual;

		// Retorna o dado associado ao nó atual. Caso o iterador não seja válido (noAtual é nulo), retorna um objeto nulo
		public Object dado() {
			if (this.noAtual != null) {
				return noAtual.dado;
			}
			return null;
		}

		// Coloca o iterador no próximo elemento da lista e retorna o dado associado ao nó atual. Caso o iterador não seja válido (noAtual é nulo), retorna um objeto nulo
		public Object proximo() {
			if (noAtual == null)
				return null;
			Object obj = noAtual.dado;
			noAtual = noAtual.proximo;
			return obj;
		}

		// Coloca o iterador no elemento anterior da lista e retorna o dado associado ao nó atual. Caso o iterador não seja válido (noAtual é nulo), retorna um objeto nulo
		public Object anterior() {
			if (noAtual == null)
				return null;
			Object obj = noAtual.dado;
			noAtual = noAtual.anterior;
			return obj;
		}

		// Verifica se existe um nó após o nó atual
		public boolean temProximo() {
			if (noAtual == null)
				return false;
			return noAtual.proximo != null;
		}

		// Verifica se existe um nó antes do nó atual
		public boolean temAnterior() {
			if (noAtual == null)
				return false;
			return noAtual.anterior != null;
		}

		// Verifica se o nó atual existe e é válido
		public boolean eValido() {
			return this.noAtual != null;
		}

		@Override
		public boolean hasNext() {
			return false;
		}

		@Override
		public Object next() {
			return null;
		}

		@Override
		public void remove() {

		}

	}

	// Nó inicial (primeiro) da lista encadeada
	No inicio;
	// Nó final (último) da lista encadeada
	No fim;
	// Tamanho da lista encadeada (número de nós na lista)
	int tamanho;

	// Construtor
	public ListaDupEncadeada() {
		inicio = null;
		fim = null;
		tamanho = 0;
	}

	// Retorna uma instância de Iterator para o primeiro nó da lista
	public IteratorLista iteradorInicio() {
		// Instanciar o novo iterador
		IteratorLista iterador = new IteratorLista();
		// Inicializar o atributo noAtual com o primeiro elemento da lista
		// Caso a lista esteja vazia, o nó atual será nulo e nenhuma iteração será possível
		iterador.noAtual = inicio;
		return iterador;
	}

	// Retorna uma instância de Iterator para o último nó da lista
	public Iterator iteradorFim() {
		// Instanciar o novo iterador
		IteratorLista iterador = new IteratorLista();
		// Inicializar o atributo noAtual com o último elemento da lista
		// Caso a lista esteja vazia, o nó atual será nulo e nenhuma iteração será possível
		iterador.noAtual = fim;
		return iterador;
	}

	// Retorna o tamanho da lista
	public int getTamanho() {
		return this.tamanho;
	}

	// Insere um novo nó no início da lista
	public int insereInicio(Object obj) {
		return insere(obj, 1);
	}

	// Insere um novo nó no final da lista
	public int insereFim(Object obj) {
		return insere(obj, tamanho + 1);

	}

	// Insere um novo nó na posição indicada
	public int insere(Object obj, int pos) {
		No no;

		if(obj == null)
			return tamanho;

		if(pos < 1 || pos > tamanho + 1) // posição solicitada fora do intervalo
			return tamanho;

		if(inicio == null)//primeiro elemento - lista vazia - ou (tamanho == 0)
		{
			no = new No(obj);
			inicio = fim = no;
		}
		else // já existem elementos na lista
		{
			if(pos == 1)//inserir no inicio da lista
			{
				no = new No(obj, inicio, null);
				inicio.anterior = no;
				inicio = no;
			}
			else if(pos == tamanho + 1)//inserir no final da lista
			{
				no = new No(obj, null, fim);
				fim.proximo = no;
				fim = no;
			}
			else// inserir no meio da lista
			{
				No aux = inicio;
				while(pos > 1)
				{
					aux = aux.proximo;
					pos--;
				}
				// inserir na posição de aux
				no = new No(obj, aux, aux.anterior);
				aux.anterior.proximo = no;
				aux.anterior = no;
			}
		}
		tamanho++;
		return tamanho;
	}

	// Remove o nó do início da lista - retira o primeiro elemento
	// Retorna o objeto armazenado no primeiro nó da lista - que foi removido.
	public Object removeInicio() {
		return remove(1);
	}

	// Remove o nó do final da lista - retira o último elemento
	// Retorna o objeto do último nó da lista - que foi removido.
	public Object removeFim() {
		return remove(tamanho);
	}

	// Remove um nó do meio da lista - retira o elemento da posição indicada
	// Retorna o objeto armazenado na posição indicada - que foi removida.
	public Object remove(int pos) {
		Object obj;
		if(inicio == null)//se a lista está vazia
			return null;
		if(pos < 1 || pos > tamanho) // posição solicitada fora do intervalo
			return null;
		if(inicio == fim)//se existe apenas um elemento na lista - ou (tamanho == 1)
		{
			obj = inicio.dado;
			inicio = fim = null;
			tamanho--;
			return obj;
		}
		if(pos == 1)//remover o primeiro elemento da lista
		{
			obj = inicio.dado;
			inicio = inicio.proximo;
		}
		else if(pos == tamanho)//remover o último elemento da lista
		{
			obj = fim.dado;
			fim = fim.anterior;
		}
		else //remover um elemento no meio da lista
		{
			No aux = inicio;
			while(pos > 1){
				aux = aux.proximo;
				pos--;
			}
			// remover o elemento aux
			obj = aux.dado;
			aux.anterior.proximo = aux.proximo;
			aux.proximo.anterior = aux.anterior;
		}
		tamanho--;
		return obj;
	}

	// Retorna o objeto armazenado na posição indicada, sem remover o mesmo da lista
	public Object consulta(int pos) {
		if(inicio == null)//se a lista está vazia
			return null;
		if(pos < 1 || pos > tamanho) // posição solicitada fora do intervalo
			return null;
		if(pos==1)//consulta o primeiro elemento da lista
			return inicio.dado;
		else if(pos == tamanho)//consulta o último elemento da lista
			return fim.dado;
		else //consulta um elemento no meio da lista
		{
			No aux = inicio;
			while(pos > 1){
				aux = aux.proximo;
				pos--;
			}
			// consulta o elemento aux
			return aux.dado;
		}
	}

	public static void main(String[] args0) {
		// Lista encadeada
		ListaDupEncadeada lista = new ListaDupEncadeada();
		int val;

		// Strings a serem inseridas na lista
		String a = "str teste 01";
		String c = "str teste 03";
		String e = "str teste 05";

		// Inteiros a serem inseridos na lista
		int b = 2;
		int d = 4;
		int f = 6;

		// Mostra o tamanho atual da lista
		System.out.println("Tamanho: " + lista.getTamanho());

		// Insere uma String no início da lista
		val = lista.insereInicio(a);
		// Mostra o conteúdo da primeira posição da lista
		System.out.println("Inserindo: \"" + lista.consulta(1) + "\" -> Tamanho: " + val);
		// Insere um inteiro no início da lista
		val = lista.insereInicio(b);
		System.out.println("Inserindo: \"" + lista.consulta(1) + "\" -> Tamanho: " + val);
		// Insere uma String no início da lista
		val = lista.insereInicio(c);
		System.out.println("Inserindo: \"" + lista.consulta(1) + "\" -> Tamanho: " + val);
		// Insere um inteiro no início da lista
		val = lista.insereInicio(d);
		System.out.println("Inserindo: \"" + lista.consulta(1) + "\" -> Tamanho: " + val);
		// Insere uma String no início da lista
		val = lista.insereInicio(e);
		System.out.println("Inserindo: \"" + lista.consulta(1) + "\" -> Tamanho: " + val);
		// Insere um inteiro no início da lista
		val = lista.insereInicio(f);
		System.out.println("Inserindo: \"" + lista.consulta(1) + "\" -> Tamanho: " + val);

		// Mostra o tamanho atual da lista
		System.out.println("\nTamanho: " + lista.getTamanho());

		System.out.println("");

		// Iterador utilizado para percorrer a lista encadeada
		IteratorLista iterador = lista.iteradorInicio();

		// Contador de posições
		int i = 1;
		// Laço para percorrer a lista utilizando o iterador
		while (iterador.eValido()) {
			// Mostra o valor armazenado em cada posição da lista
			System.out.println("Posição " + i++ + ": -> \t" + iterador.dado());
			iterador.proximo();
		}

		System.out.println("");
		// Laço para remover todos os elementos da lista
		while (lista.getTamanho() > 0) {
			System.out
					.println("Removido do início: \"" + lista.removeInicio() + "\" -> Tamanho: " + lista.getTamanho());
		}
	}
}



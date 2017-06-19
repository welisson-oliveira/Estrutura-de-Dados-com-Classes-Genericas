package br.com.welisson.listaDuplamenteEncadeada.certo;



/**
 * {@link No}
 *
 * @author Welisson Oliveira
 * @version 1.0 14/06/2017
 */
public class No<E> {
	// Referência ao próximo elemento da lista
	private No proximo;
	// Referência ao elemento anterior na lista
	private No anterior;
	// Referência ao dado armazenado no nó atual da lista
	private E dado;

	// Constrói um nó para armazenar um objeto na lista
	public No(E obj) {
		dado = obj;
	}

	// Constrói um nó para armazenar um objeto na lista, indicando quais os
	// nós anterior e próximo
	public No(E obj, No prox, No ant) {
		this.proximo = prox;
		this.anterior = anterior;
		this.dado = obj;
	}

	public No getProximo() {
		return proximo;
	}

	public void setProximo(No proximo) {
		this.proximo = proximo;
	}

	public No getAnterior() {
		return anterior;
	}

	public void setAnterior(No anterior) {
		this.anterior = anterior;
	}

	public E getDado() {
		return dado;
	}

	public void setDado(E dado) {
		this.dado = dado;
	}
}

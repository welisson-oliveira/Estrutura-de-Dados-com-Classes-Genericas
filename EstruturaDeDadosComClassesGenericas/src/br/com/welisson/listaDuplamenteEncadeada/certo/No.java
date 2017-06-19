package br.com.welisson.listaDuplamenteEncadeada.certo;



/**
 * {@link No}
 *
 * @author Welisson Oliveira
 * @version 1.0 14/06/2017
 */
public class No<E> {
	// Refer�ncia ao pr�ximo elemento da lista
	private No proximo;
	// Refer�ncia ao elemento anterior na lista
	private No anterior;
	// Refer�ncia ao dado armazenado no n� atual da lista
	private E dado;

	// Constr�i um n� para armazenar um objeto na lista
	public No(E obj) {
		dado = obj;
	}

	// Constr�i um n� para armazenar um objeto na lista, indicando quais os
	// n�s anterior e pr�ximo
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

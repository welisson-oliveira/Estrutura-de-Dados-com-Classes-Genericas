package br.com.welisson.listaDuplamenteEncadeada.certo;



/**
 * {@link IteratorLista}
 *
 * @author Welisson Oliveira
 * @version 1.0 14/06/2017
 */
public class IteratorLista<E> implements IteratorExample {
	// Refer�ncia ao n� apontado pelo iterador da lista durante a navega��o
	public No<E> noAtual;

	// Retorna o dado associado ao n� atual. Caso o iterador n�o seja v�lido (noAtual � nulo), retorna um objeto nulo
	public E dado() {
		if (this.noAtual != null) {
			return noAtual.getDado();
		}
		return null;
	}

	// Coloca o iterador no pr�ximo elemento da lista e retorna o dado associado ao n� atual. Caso o iterador n�o seja v�lido (noAtual � nulo), retorna um objeto nulo
	public E proximo() {
		if (noAtual == null)
			return null;
		E obj = noAtual.getDado();
		noAtual = noAtual.getProximo();
		return obj;
	}

	// Coloca o iterador no elemento anterior da lista e retorna o dado associado ao n� atual. Caso o iterador n�o seja v�lido (noAtual � nulo), retorna um objeto nulo
	public E anterior() {
		if (noAtual == null)
			return null;
		E obj = noAtual.getDado();
		noAtual = noAtual.getAnterior();
		return obj;
	}

	// Verifica se existe um n� ap�s o n� atual
	public boolean temProximo() {
		if (noAtual == null)
			return false;
		return noAtual.getProximo() != null;
	}

	// Verifica se existe um n� antes do n� atual
	public boolean temAnterior() {
		if (noAtual == null)
			return false;
		return noAtual.getAnterior() != null;
	}

	// Verifica se o n� atual existe e � v�lido
	public boolean eValido() {
		return this.noAtual != null;
	}


}

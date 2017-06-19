package br.com.welisson.formasGeometricas.br.com.welisson.formasGeometricas.semCast;

import br.com.welisson.formasGeometricas.br.com.welisson.formasGeometricas.Clonavel;
import br.com.welisson.listaDuplamenteEncadeada.certo.No;

/**
 * {@link ListDupEncadeada <E>}
 *
 * @author Welisson Oliveira
 * @version 1.0 14/06/2017
 *          Classe que implementa a estrutura de dados Lista Duplamente Encadeada.
 *          A classe ListaDupEcadeada recebe um par�metro informando qual � o tipo de dado que ser� armazenado em seus n�s.
 */
public class ListDupEncadeada<E extends Clonavel>{
	// N� inicial (primeiro) da lista encadeada
	private No<E> inicio;
	// N� final (�ltimo) da lista encadeada
	private No<E> fim;
	// Tamanho da lista encadeada (n�mero de n�s na lista)
	private int tamanho;

	public ListDupEncadeada(No<E> inicio, No<E> fim, int tamanho) {
		this.inicio = inicio;
		this.fim = fim;
		this.tamanho = tamanho;
	}

	public ListDupEncadeada() { }

	// Retorna uma inst�ncia de Iterator para o primeiro n� da lista
	public Iterator iteradorInicio() {
		// Instanciar o novo iterador
		IteratorLista iterador = new IteratorLista();
		// Inicializar o atributo noAtual com o primeiro elemento da lista
		// Caso a lista esteja vazia, o n� atual ser� nulo e nenhuma itera��o ser� poss�vel
		iterador.noAtual = inicio;
		return iterador;
	}

	// Retorna uma inst�ncia de Iterator para o �ltimo n� da lista
	public Iterator iteradorFim() {
		// Instanciar o novo iterador
		IteratorLista iterador = new IteratorLista();
		// Inicializar o atributo noAtual com o �ltimo elemento da lista
		// Caso a lista esteja vazia, o n� atual ser� nulo e nenhuma itera��o ser� poss�vel
		iterador.noAtual = fim;
		return iterador;
	}

	// Retorna o tamanho da lista
	public int getTamanho() {
		return this.tamanho;
	}

	// Insere um novo n� no in�cio da lista
	public int insereInicio(E obj) {
		return insere(obj, 1);
	}

	// Insere um novo n� no final da lista
	public int insereFim(E obj) {
		return insere(obj, tamanho + 1);

	}

	// Insere um novo n� na posi��o indicada
	public int insere(E obj, int pos) {
		No no;

		if (obj == null)
			return tamanho;

		if (pos < 1 || pos > tamanho + 1) // posi��o solicitada fora do intervalo
			return tamanho;

		if (inicio == null)//primeiro elemento - lista vazia - ou (tamanho == 0)
		{
			no = new No(obj);
			inicio = fim = no;
		} else // j� existem elementos na lista
		{
			if (pos == 1)//inserir no inicio da lista
			{
				no = new No(obj.clone(), inicio, null);
				inicio.setAnterior(no);
				inicio = no;
			} else if (pos == tamanho + 1)//inserir no final da lista
			{
				no = new No(obj, null, fim);
				fim.setProximo(no);
				fim = no;
			} else// inserir no meio da lista
			{
				No aux = inicio;
				while (pos > 1) {
					aux = aux.getProximo();
					pos--;
				}
				// inserir na posi��o de aux
				no = new No(obj.clone(), aux, aux.getAnterior());
				aux.getAnterior().setProximo(no);
				aux.setAnterior(no);
			}
		}
		tamanho++;
		return tamanho;
	}

	// Remove o n� do in�cio da lista - retira o primeiro elemento
	// Retorna o objeto armazenado no primeiro n� da lista - que foi removido.
	public E removeInicio() {
		return remove(1);
	}

	// Remove o n� do final da lista - retira o �ltimo elemento
	// Retorna o objeto do �ltimo n� da lista - que foi removido.
	public E removeFim() {
		return remove(tamanho);
	}

	// Remove um n� do meio da lista - retira o elemento da posi��o indicada
	// Retorna o objeto armazenado na posi��o indicada - que foi removida.
	public E remove(int pos) {
		E obj;
		if (inicio == null)//se a lista est� vazia
			return null;
		if (pos < 1 || pos > tamanho) // posi��o solicitada fora do intervalo
			return null;
		if (inicio == fim)//se existe apenas um elemento na lista - ou (tamanho == 1)
		{
			obj = inicio.getDado();
			inicio = fim = null;
			tamanho--;
			return obj;
		}
		if (pos == 1)//remover o primeiro elemento da lista
		{
			obj = inicio.getDado();
			inicio = inicio.getProximo();
		} else if (pos == tamanho)//remover o �ltimo elemento da lista
		{
			obj = fim.getDado();
			fim = fim.getAnterior();
		} else //remover um elemento no meio da lista
		{
			No<E> aux = inicio;
			while (pos > 1) {
				aux = aux.getProximo();
				pos--;
			}
			// remover o elemento aux
			obj = aux.getDado();
			aux.getAnterior().setProximo(aux.getProximo());
			aux.getProximo().setAnterior(aux.getAnterior());
		}
		tamanho--;
		return obj;
	}

	// Retorna o objeto armazenado na posi��o indicada, sem remover o mesmo da lista
	public E consulta(int pos) {
		if (inicio == null)//se a lista est� vazia
			return null;
		if (pos < 1 || pos > tamanho) // posi��o solicitada fora do intervalo
			return null;
		if (pos == 1)//consulta o primeiro elemento da lista
			return inicio.getDado();
		else if (pos == tamanho)//consulta o �ltimo elemento da lista
			return fim.getDado();
		else //consulta um elemento no meio da lista
		{
			No<E> aux = inicio;
			while (pos > 1) {
				aux = aux.getProximo();
				pos--;
			}
			// consulta o elemento aux
			return aux.getDado();
		}
	}
}

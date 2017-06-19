package br.com.welisson.formasGeometricas.br.com.welisson.formasGeometricas.semCast;

/**
 * {@link Iterator}
 *
 * @author Welisson Oliveira
 * @version 1.0 19/06/2017
 */
public interface Iterator<D> {

	/**
	 * @return Retorna o dado associado ao n� atual
	 */
	public D dado();

	/**
	 * @return Coloca o iterador no pr�ximo elemento da lista e retorna o dado associado ao n� atual
	 */
	public D proximo();

	/**
	 * @return Coloca o iterador no elemento anterior da lista e retorna o dado associado ao n� atual
	 */
	public D anterior();

	/**
	 * @return Verifica se existe um n� ap�s o n� atual
	 */
	public boolean temProximo();

	/**
	 * @return Verifica se existe um n� antes do n� atual
	 */
	public boolean temAnterior();

	/**
	 * @return Verifica se o iterador � v�lido
	 */
	public boolean eValido();
}

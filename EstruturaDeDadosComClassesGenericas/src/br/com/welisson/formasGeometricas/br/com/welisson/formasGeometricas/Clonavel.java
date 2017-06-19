package br.com.welisson.formasGeometricas.br.com.welisson.formasGeometricas;

/**
 * {@link Clonavel} Interface que define um m�todo a ser utilizado pelos objetos para criar clones (c�pias) de si mesmos
 *
 * @author Welisson Oliveira
 * @version 1.0 19/06/2017
 */
public interface Clonavel extends Cloneable {
	/**
	 * M�todo para criar uma c�pia do objeto
	 */
	Clonavel clone();
}


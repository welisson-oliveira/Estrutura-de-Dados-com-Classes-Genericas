package br.com.welisson.formasGeometricas.br.com.welisson.formasGeometricas;

/**
 * {@link Clonavel} Interface que define um método a ser utilizado pelos objetos para criar clones (cópias) de si mesmos
 *
 * @author Welisson Oliveira
 * @version 1.0 19/06/2017
 */
public interface Clonavel extends Cloneable {
	/**
	 * Método para criar uma cópia do objeto
	 */
	Clonavel clone();
}


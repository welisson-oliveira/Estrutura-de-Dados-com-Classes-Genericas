package br.com.welisson.formasGeometricas.br.com.welisson.formasGeometricas;

/**
 * Uma interface simples para objetos que representam formas geométricas e que também implementa a
 * interface Clonavel, de modo que as classes que implementem esta interface devam implementar também o
 * método para criar uma cópia de si mesmo.
 * A interface {@link FormaGeometrica} representa formas geometricas \n os metodos que retornam os
 * valores de seus perimetros e de suas areas devem ser implementados.
 *
 * @author Welisson Oliveira
 * @version 1.0 19/06/2017
 */
public interface FormaGeometrica extends Clonavel{
	/**
	 *
	 * @return Retorna o valor do perímetro da forma geométrica
	 */
	public float perimetro();
	/**
	 *
	 * @return Retorna o valor da área da forma geométrica
	 */
	public float area();

}

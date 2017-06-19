package br.com.welisson.formasGeometricas.br.com.welisson.formasGeometricas;

/**
 * {@link Quadrado} Implementação da interface FormaGeometrica que representa um Quadrado utilizando um atributo com o valor do comprimento do lado.
 *
 * @author Welisson Oliveira
 * @version 1.0 19/06/2017
 */
public class Quadrado implements FormaGeometrica {
	/**
	 * Comprimento do lado do quadrado
	 */
	private Float lado;

	/**
	 * @return Retorna o valor do lado do quadrado
	 */
	public float getLado() {
		return lado;
	}

	/**
	 * Altera o valor do lado do quadrado
	 */
	public void setLado(Float lado) {
		this.lado = lado;
	}

	/**
	 * Construtor
	 *
	 * @param lado
	 */
	public Quadrado(Float lado) {
		this.lado = lado;
	}

	/**
	 * @return Retorna o valor do perímetro da forma geométrica
	 */
	@Override
	public float perimetro() {
		return lado * 4.0f;
	}

	/**
	 * @return Retorna o valor da área da forma geométrica
	 */
	@Override
	public float area() {
		return lado * lado;
	}

	/**
	 * @return Retorna a representação textual do Quadrado
	 */
	@Override
	public String toString() {
		return String.format("Quadrado com lado de %.2f.", lado);
	}

	@Override
	public Quadrado clone()  {

		return new Quadrado(this.lado);
	}
}

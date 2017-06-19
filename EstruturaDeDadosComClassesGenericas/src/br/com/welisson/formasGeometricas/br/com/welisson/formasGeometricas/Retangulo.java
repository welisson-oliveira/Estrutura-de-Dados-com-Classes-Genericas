package br.com.welisson.formasGeometricas.br.com.welisson.formasGeometricas;

/**
 * {@link Retangulo} Implementação da interface FormaGeometrica que representa um Retangulo utilizando dois atributos com os valores dos comprimentos de altura e largura.
 *
 * @author Welisson Oliveira
 * @version 1.0 19/06/2017
 */
public class Retangulo implements FormaGeometrica {
	/**
	 * Comprimento da largura do retângulo
	 */
	private float largura;
	/**
	 * Comprimento da altura do retângulo
	 */
	private float altura;

	/**
	 * @return Retorna o valor da largura do retângulo
	 */
	public float getLargura() {
		return largura;
	}

	/**
	 * @return Altera o valor da largura do retângulo
	 */
	public void setLargura(float largura) {
		this.largura = largura;
	}

	/**
	 * @return Retorna o valor da altura do retângulo
	 */
	public float getAltura() {
		return altura;
	}

	/**
	 * @return Altera o valor da altura do retângulo
	 */
	public void setAltura(float altura) {
		this.altura = altura;
	}

	/**
	 * @param largura
	 * @param altura
	 */
	public Retangulo(float largura, float altura) {
		this.largura = largura;
		this.altura = altura;
	}

	/**
	 * @return Retorna o valor do perímetro da forma geométrica
	 */
	@Override
	public float perimetro() {
		return 2.0f * largura + 2.0f * altura;
	}

	/**
	 * @return Retorna o valor da área da forma geométrica
	 */
	@Override
	public float area() {
		return largura * altura;
	}

	/**
	 * @return Retorna a representação textual do Retangulo
	 */
	@Override
	public String toString() {
		return String.format("Retângulo com largura de %.2f e altura de %.2f.", largura, altura);
	}

	/**
	 * Método para criar uma cópia do objeto
	 * @return Retorna uma cópia do objeto
	 */
	@Override
	public Retangulo clone() {
		return new Retangulo(this.largura, this.altura);
	}
}

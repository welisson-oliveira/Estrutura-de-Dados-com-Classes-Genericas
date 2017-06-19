package br.com.welisson.formasGeometricas.br.com.welisson.formasGeometricas;

/**
 * {@link Teste}
 *
 * @author Welisson Oliveira
 * @version 1.0 19/06/2017
 */
public class Teste {

	public static void main(String... args) throws CloneNotSupportedException {
		Quadrado q = new Quadrado(1f);

		Quadrado q1 = q.clone();

		System.out.println("Q: "+q);
		System.out.println("Q1: "+q1);

		q1.setLado(2f);

		System.out.println("Q: "+q);
		System.out.println("Q1: "+q1);


	}
}

package dominio;
/**
 * Clase que se utiliza para generar números aleatorios.
 */
public  class RandomGenerator {
	/**
	 * Retorna 0.
	 * Será sobreescrito por las clases que heredan.
	 * @param val No se usa.
	 * @return Retorna 0.
	 */
	public int nextInt(final int val) {
		return 0;
	}
	/**
	 * Retorna 0.
	 * Será sobreescrito por las clases que heredan.
	 * @return Retorna 0.
	 */
	public double nextDouble() {
		return 0;
	}
	/**
	 * Constructor de la clase.
	 */
	public RandomGenerator() {

	}
}

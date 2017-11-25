package dominio;

import java.util.Random;

/**
 *
 * Clase que se utiliza para obtener números aleatorios.
 */
public class MyRandom extends RandomGenerator {

	/**Devuelve un número double que varía entre 0.0 y 1.0.
	 * @return retorna un número double que varía entre 0.0 y 1.0
	 */
	@Override
	public final double nextDouble() {
		return new Random().nextDouble();
	}
	/** Decrementa en 1 el valor recibido por parámetro.
	 * @param val número entero a decrementar.
	 * @return Retorna un número menor al parámetro.
	 */
	@Override
	public final int nextInt(final int val) {
		return new Random().nextInt(val);
	}

}

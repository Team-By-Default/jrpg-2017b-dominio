package dominio;
/**
 * Clase con proposito de testing ya que se fijan sus valores.
 */
public class MyRandomStub extends RandomGenerator {
	/**
	 * Valor que devolverá nextDouble().
	 */
	private final double valDouble;
	/**
	 * Valor que devolverá nextInt();
	 */
	private final int valInt;
	/**
	 * Constructor de MyRandomStub.
	 * @param valDouble Double que se fijará en el objeto.
	 * @param valInt Entero que se fijará en el objeto.
	 */
	public MyRandomStub(final double valDouble, final int valInt) {
		this.valDouble = valDouble;
		this.valInt = valInt;
	}
	/**
	 * Devuelve el valor entero que se pasa en el constructor.
	 * @param val No se usa.
	 * @return Entero que se pasa por parametro en el constructor.
	 */
	@Override
	public final int nextInt(final int val) {
		return valInt;
	}
	/**
	 * Retorna el valor entero que se pasa en el constructor.
	 */
	@Override
	public final double nextDouble() {
		return valDouble;
	}

}

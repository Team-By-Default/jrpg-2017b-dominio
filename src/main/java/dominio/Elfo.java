
package dominio;

/** La clase Elfo hereda de la clase Personaje.
 * Completa ciertos atributos que estaban declarados en
 * la clase Personaje, como por ejemplo habilidadesRaza[].
*/
public class Elfo extends Personaje {
	/**
	 * Energía mínima que se necesita para realizar una habilidad.
	 */
	private static final int ENERGIAMINIMA = 10;
	/**
	 * Número con el que se multiplica el nivel.
	 */
	private static final int MULTIPLICADORNIVEL = 10;
	/**
	 * Bonus de energía por ser de raza Elfo.
	 */
	private static final int BONUSENERGIA = 10;

	/** Llama al constructor del padre (Personaje)
	 * pasándole los argumentos recibidos.
	 * @param nombre Indica el nombre el personaje.
	 * @param casta Indica la casta(Raza) del personaje.
	 * @param id Identificador del personaje.
	 */
	public Elfo(final String nombre, final Casta casta, final int id) {
		super(nombre, casta, id);
	}
	/** Llama al constructor del padre (Personaje)
	 * pasándole los argumentos recibidos.
	 * Recibe la mayoría de los atributos.
	 * @param nombre Nombre del personaje
	 * @param salud Salud del personaje
	 * @param energia Energía del personaje
	 * @param fuerza Fuerza del Personaje
	 * @param destreza Destreza del personaje
	 * @param inteligencia Inteligencia del personaje
	 * @param casta Casta(Raza) del personaje
	 * @param experiencia Experiencia del personaje
	 * @param nivel Nivel del personaje
	 * @param idPersonaje Id del personaje
	 */
	public Elfo(final String nombre, final int salud, final int energia,
			final int fuerza, final int destreza, final int inteligencia, final Casta casta,
			final int experiencia, final int nivel, final int idPersonaje) {
		super(nombre, salud, energia, fuerza, destreza, inteligencia, casta,
				experiencia, nivel, idPersonaje);
	}


	/**Efectua de ser posible la habilidad 1 de la Raza.
	 * Para que la habilidad pueda realizarse, el atacante(caster)
	 * debe tener puntos de energía suficiente, ya que estos se
	 * descuentan seguido de comprobar que los posee,
	 * de lo contrario la habilidad no podra efectuarse.
	 * La habilidad consiste en que al atacar al oponente recibido
	 * por parametro, como daño se suma la fuerza del atacante y
	 * el nivel del mismo multiplicado por 10.
	 * @param atacado Instancia de Personaje o de
	 * NPC, dependiendo de cual sea, será como responda el
	 * método serAtacado().
	 * @return retorna si se ejecutó correctamente
	 * la habilidad o no.
	 */
	@Override
	public final boolean habilidadRaza1(final Peleable atacado) {
		if (this.getEnergia() >= ENERGIAMINIMA) {
			this.reducirEnergia(ENERGIAMINIMA);
			return atacado.serAtacado(this.getFuerza() + this.getNivel() * MULTIPLICADORNIVEL, this) > 0;
		}
		return false;
	}



	/** Efectua de ser posible la habilidad 2 de la Raza.
	 * Para que la habilidad pueda realizarse, el atacante(caster)
	 * debe tener puntos de energía suficiente, ya que estos se
	 * descuentan seguido de comprobar que los posee,
	 * de lo contrario la habilidad no podra efectuarse.
	 * La habilidad consiste en atacar al oponente con magia,
	 * si el atributo magia del llamador es mayor a 0.
	 * @param atacado Instancia de Personaje o de
	 * NPC, dependiendo de cual sea, será como responda el
	 * método serAtacado().
	 * @return retorna si se ejecutó correctamente
	 * la habilidad o no.
	 */
	@Override
	public final boolean habilidadRaza2(final Peleable atacado) {
		if (this.getEnergia() >= ENERGIAMINIMA) {
			this.reducirEnergia(ENERGIAMINIMA);
			return atacado.serAtacado((this.getMagia()), this) > 0;
		}
		return false;
	}
	/**Retorna un vector de string con los nombres
	 * de las habilidades de la raza.
	 * @return Retorna nombres de las habilidades
	 * propias de la raza.
	 */
	@Override
	public final String[] getHabilidadesRaza() {
		return new String[] {"Golpe Level", "Ataque Bosque"};
	}
	/**Retorna un entero con el bonificador de salud de la raza.
	 * @return Retorna 0 para esta raza.
	 */
	@Override
	public final int getSaludBonus() {
		return 0;
	}
	/**Retorna un entero con el bonificador de energía de la raza.
	 * @return Retorna la energiía extra para esta raza.
	 */
	@Override
	public final int getEnergiaBonus() {
		return BONUSENERGIA;
	}
	/**Retorna una string con el nombre de la raza.
	 * @return Retorna el nombre de la raza.
	 */
	@Override
	public final String getNombreRaza() {
		return "Elfo";
	}



}

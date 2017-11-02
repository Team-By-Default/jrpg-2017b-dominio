
package dominio;
/**La clase Orco hereda de la clase Personaje.
 * Completa ciertos atributos que estaban declarados en
 * la clase Personaje, como por ejemplo habilidadesRaza[]
*/
public class Orco extends Personaje {
	/**
	 * Energía mínima que se necesita para realizar una habilidad.
	 */
	private static final int ENERGIAMINIMA = 10;
	/**
	 * Bonus salud por ser de raza Orco.
	 */
	private static final int BONUSSALUD = 10;
	/**
	 * Número por el cual se multiplicara la defensa.
	 */
	private static final int MULTIPLICADORDEFENSA = 2;

	/**Llama al constructor del padre (Personaje)
	 * pasándole los argumentos recibidos.
	 * @param nombre Indica el nombre del Personaje.
	 * @param casta Indica la casta(Raza) del Personaje.
	 * @param id Identificador del Personaje.
	 */
	public Orco(final String nombre, final Casta casta, final int id) {
		super(nombre, casta, id);
	}
	/**Recibe la mayoría de los atributos.
	 * Llama al constructor del padre (Personaje)
	 * pasándole los argumentos recibidos.
	 * @param nombre Nombre del personaje.
	 * @param salud Salud del personaje.
	 * @param energia Energía del personaje.
	 * @param fuerza Fuerza del Personaje.
	 * @param destreza Destreza del personaje.
	 * @param inteligencia Inteligencia del personaje.
	 * @param casta Casta(Raza) del personaje.
	 * @param experiencia Experiencia del personaje.
	 * @param nivel Nivel del personaje.
	 * @param idPersonaje Identificador del personaje.
	 */
	public Orco(final String nombre, final int salud, final int energia, final int fuerza,
			final int destreza, final int inteligencia, final Casta casta,
			final int experiencia, final int nivel, final int idPersonaje) {
		super(nombre, salud, energia, fuerza, destreza, inteligencia, casta, experiencia, nivel, idPersonaje);
	}


	/**Efectua de ser posible la habilidad 1 de la Raza.
	 * Para que la habilidad pueda realizarse, el atacante(caster)
	 * debe tener puntos de energía suficiente, ya que estos se
	 * descuentan seguido de comprobar que los posee,
	 * de lo contrario la habilidad no podra efectuarse.
	 * La habilidad consiste en que al ser atacado recibe el ataque con
	 * el doble del valor del atributo defensa del llamador.
	 * @param atacado Instancia de Personaje o de NPC,
	 * dependiendo de cual sea, será como responda el
	 * método serAtacado().
	 * @return Retorna si el ataque fue exitoso o no.
	 */
	@Override
	public final boolean habilidadRaza1(final Peleable atacado) {
		if (this.getEnergia() >= ENERGIAMINIMA) {
			this.reducirEnergia(ENERGIAMINIMA);
			return atacado.serAtacado(this.getDefensa() * MULTIPLICADORDEFENSA) > 0;
			/*
			if (atacado.serAtacado(this.getDefensa() * MULTIPLICADORDEFENSA) > 0) {
				return true;
			}
			*/
		}
		return false;
	}


	/**Efectua de ser posible la habilidad 2 de la Raza.
	 * Para que la habilidad pueda realizarse, el atacante(caster)
	 * debe tener puntos de energía suficiente, ya que estos se
	 * descuentan seguido de comprobar que los posee,
	 * de lo contrario la habilidad no podra efectuarse.
	 * La habilidad consiste en que luego de atacar 
	 * el llamador se cura con el daño causado al atacado.
	 * @param atacado Instancia de Personaje o de NPC,
	 * dependiendo de cual sea, será como responda el
	 * método serAtacado().
	 * @return Retorna si el ataque fue exitoso o no.
	 */
	@Override
	public final boolean habilidadRaza2(final Peleable atacado) {
		if (this.getEnergia() >= ENERGIAMINIMA) {
			this.reducirEnergia(ENERGIAMINIMA);
			int danioCausado = atacado.serAtacado(this.getFuerza());
			if (danioCausado > 0) {
				this.serCurado(danioCausado);
				return true;
			}
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
		return new String[] {"Golpe Defensa", "Mordisco de Vida"};
	}
	/**Retorna un entero con el bonificador de
	 * salud de la raza.
	 * @return Retorna la salud extra de la raza.
	 */
	@Override
	public final int getSaludBonus() {
		return BONUSSALUD;
	}
	/**Retorna un entero con el bonificador de
	 * energía de la raza.
	 * @return Retorna 0 para esta raza.
	 */
	@Override
	public final int getEnergiaBonus() {
		return 0;
	}
	/**Retorna una string con el nombre de la raza.
	 * @return Retorna el nombre de la raza.
	 */
	@Override
	public final String getNombreRaza() {
		return "Orco";
	}



}

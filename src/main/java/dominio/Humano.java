
package dominio;

/**La clase Humano hereda de la clase Personaje.
 * Completa ciertos atributos que estaban
 * declarados en la clase Personaje,
 * como por ejemplo habilidadesRaza[].
 */
public class Humano extends Personaje {
	/**
	 * Energía miníma que se necesita para realizar una habilidad.
	 */
	private static final int ENERGIAMINIMA = 10;
	/**
	 * Número por el cual se divide la salud.
	 */
	private static final int DIVISORSALUD = 2;
	/**
	 * Número por el cual se divide la energía.
	 */
	private static final int DIVISORENERGIA = 2;
	/**
	 * Bonus de energía obtenido por ser de casta Humano.
	 */
	private static final int BONUSENERGIA = 5;
	/**
	 * Bonus de salud obtenido por ser de raza Humano.
	 */
	private static final int BONUSSALUD = 5;

	/**Llama al constructor del padre (Personaje)
	 * pasándole los argumentos recibidos.
	 * @param nombre Indica el nombre el personaje
	 * @param casta Indica la casta(Raza) del personaje
	 * @param id Identificador del personaje
	 */
	public Humano(final String nombre, final Casta casta, final int id) {
		super(nombre, casta, id);
	}
	/**Llama al constructor del padre (Personaje)
	 * pasándole los argumentos recibidos.
	 * Recibe la mayoría de los atributos.
	 * @param nombre Nombre del personaje.
	 * @param salud Salud del personaje.
	 * @param energia Energía del personaje.
	 * @param fuerza Fuerza del Personaje.
	 * @param destreza Destreza del personaje.
	 * @param inteligencia Inteligencia del personaje.
	 * @param casta Casta(Raza) del personaje.
	 * @param experiencia Experiencia del personaje.
	 * @param nivel Nivel del personaje.
	 * @param idPersonaje Id del personaje.
	 */
	public Humano(final String nombre, final int salud, final int energia, final int fuerza,
			final int destreza, final int inteligencia, final Casta casta,
			final int experiencia, final int nivel, final int idPersonaje) {
		super(nombre, salud, energia, fuerza, destreza, inteligencia, casta, experiencia, nivel, idPersonaje);
	}


	/** Efectua de ser posible la habilidad 1 de la Raza.
	 * Para que la habilidad pueda realizarse, el atacante(caster)
	 * debe tener puntos de energía suficiente, ya que estos se
	 * descuentan seguido de comprobar que los posee,
	 * de lo contrario la habilidad no podra efectuarse.
	 * La habilidad consiste en incrementar el ataque del llamador
	 * sumandole el valor de su magia.
	 * @param atacado Instancia de Personaje o de NPC,
	 * dependiendo de cual sea, será como responda el
	 * método serAtacado()-
	 * @return booleano que determina si la habilidad se ejecuto con éxito o no.
	 */
	@Override
	public final boolean habilidadRaza1(final Peleable atacado) {
		if (this.getEnergia() >= ENERGIAMINIMA) {
			this.reducirEnergia(ENERGIAMINIMA);
			atacado.setAtaque(atacado.getAtaque() + this.getMagia());
			return true;
		}
		return false;
	}


	/** Efectua de ser posible la habilidad 1 de la Raza.
	 * Para que la habilidad pueda realizarse, el atacante(caster)
	 * debe tener puntos de energía suficiente, ya que estos se
	 * descuentan seguido de comprobar que los posee,
	 * de lo contrario la habilidad no podra efectuarse.
	 * La habilidad consiste en efectuar el ataque con la 
	 * mitad del valor de la salud del atacado.
	 * Pero si este ataquen no efectua daño al oponente, el valor
	 * del atributo energia del llamador será
	 * reducido a la mitad.
	 * @param atacado Instancia de Personaje o de NPC,
	 * dependiendo de cual sea, será como responda el
	 * método serAtacado().
	 * @return booleano que determina si el ataque fue exitoso o no.
	 */
	@Override
	public final boolean habilidadRaza2(final Peleable atacado) {
		if (this.getEnergia() >= ENERGIAMINIMA) {
			if (atacado.serAtacado(atacado.getSalud() / DIVISORSALUD) > 0) {
				this.reducirEnergia(this.getEnergia() / DIVISORENERGIA);
				return true;
			}
		}
		this.reducirEnergia(ENERGIAMINIMA);
		return false;
	}
	/**Retorna un vector de string con los nombres
	 * de las habilidades de la raza.
	 * @return Retorna nombres de las habilidades
	 * propias de la raza.
	 */
	@Override
	public final String[] getHabilidadesRaza() {
		return new String[] {"Incentivar", "Golpe Fatal"};
	}
	/**Retorna un entero con el bonificador de salud
	 * de la raza.
	 * @return Retorna la salud extra de la raza.
	 */
	@Override
	public final int getSaludBonus() {
		return BONUSSALUD;
	}
	/**Retorna un entero con el bonificador de energía
	 * de la raza.
	 * @return Retorna la energía extra para esta raza.
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
		return "Humano";
	}




}

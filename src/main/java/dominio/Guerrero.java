
package dominio;
	/** La clase Guerrero es una casta de Personaje.
	 * Hereda de la clase Casta.
	 */
public class Guerrero extends Casta {
	/**
	 * Energia minima requerida para realizar una habilidad.
	 */
	private static final int ENERGIAMINIMA = 10;
	/**
	 * Numero por el cual sera multiplicado el ataque del guerrero.
	 */
	private static final int MULTIPLICADORFUERZA = 2;
	/**
	 * Bonus de fuerza por ser de la casta Guerrero.
	 */
	private static final int BONUSFUERZA = 5;

	/** Llama al constructor de la
	 * clase padre (Casta),
	 * pasándole los argumentos recibidos.
	 * @param probCrit Probabilidad de que el
	 * personaje realice un golpe crítico
	 * @param evasion Probabilidad de que el
	 * personaje evite un golpe crítico
	 * @param danioCrit Valor por el cual será
	 * multiplicado el golpe básico.
	 */
	public Guerrero(final double probCrit, final double evasion, final double danioCrit) {
		super(probCrit, evasion, danioCrit);
	}
	/** El constructor por defecto, llama al constructor por defecto.
	 * padre (Casta), inicializando probabilidadGolpeCritico,
	 *  probabilidadEvitarDaño, dañoCritico,
	 * con valores predeterminados.
	 */
	public Guerrero() {
		super();
	}

	/** 
	 * Efectua de ser posible la habilidad 1 de la Casta.
	 * Para que la habilidad pueda realizarse, el atacante(caster)
	 * debe tener puntos de energía suficiente, ya que estos se
	 * descuentan seguido de comprobar que los posee,
	 * de lo contrario la habilidad no podra efectuarse.
	 * La habilidad consiste en atacar al Peleable recibido por
	 * parámetro.
	 * @param caster Personaje que realiza el ataque.
	 * @param atacado puede ser una instancia de
	 * Persona o NPC.
	 * @return retorna si se ejecutó correctamente
	 *  la habilidad.
	 */
	@Override
	public final boolean habilidad1(final Personaje caster, final Peleable atacado) {
		if (caster.getEnergia() >= ENERGIAMINIMA) {
			caster.reducirEnergia(ENERGIAMINIMA);
			return atacado.serAtacado(caster.getAtaque() * MULTIPLICADORFUERZA) > 0;
			/*
			if (atacado.serAtacado(caster.getAtaque() * MULTIPLICADORFUERZA) > 0) {
				return true;
			}
			*/
		}
		return false;
	}


	/** Efectua de ser posible la habilidad 2 de la Casta.
	 * Para que la habilidad pueda realizarse, el atacante(caster)
	 * debe tener puntos de energía suficiente, ya que estos se
	 * descuentan seguido de comprobar que los posee,
	 * de lo contrario la habilidad no podra efectuarse.
	 * La habilidad consiste en un aumento en
	 * las caracteristicas del caster en este caso la
	 * defensa (se agrega a la defensa actual el atributo
	 * magia)
	 * @param caster Personaje que invoca la habilidad.
	 * @param atacado no cumple función alguna dentro
	 * de este método.
	 * @return retorna si se ejecutó correctamente la
	 * habilidad o no.
	 */
	@Override
	public final boolean habilidad2(final Personaje caster, final Peleable atacado) {
		if (caster.getEnergia() >= ENERGIAMINIMA) {
			caster.reducirEnergia(ENERGIAMINIMA);
			caster.aumentarDefensa(caster.getMagia());
			return true;
		}
		return false;
	}


	/** Efectua de ser posible la habilidad 3 de la Casta.
	 * Para que la habilidad pueda realizarse, el atacante(caster)
	 * debe tener puntos de energía suficiente, ya que estos se
	 * descuentan seguido de comprobar que los posee,
	 * de lo contrario la habilidad no podra efectuarse.
	 * La habilidad consiste en reducir la defensa del atacado
	 * al momento del ataque para luego restituirla a su valor previo.
	 * Para poder efectuar la habilidad el argumento atacado,
	 * debe ser una instancia de Personaje.
	 * @param caster Personaje atacante
	 * @param atacado Peleable sobre el que se aplica la habilidad.
	 * @return retorna si se ejecutó correctamente
	 * la habilidad o no.
	 */
	@Override
	public final boolean habilidad3(final Personaje caster, final Peleable atacado) {
		if (caster.getEnergia() >= ENERGIAMINIMA) {
			caster.reducirEnergia(ENERGIAMINIMA);
			if (atacado instanceof Personaje) {
				int defensaOriginal = ((Personaje) atacado).getDefensa();
				((Personaje) atacado).reducirDefensa(((Personaje) atacado).getDefensa());
				if (atacado.serAtacado(caster.getAtaque()) > 0) {
					((Personaje) atacado).aumentarDefensa(defensaOriginal);
					return true;
				}
			}

		}
		return false;
	}
	/** Devuelve el bonus de fuerza perteneciente a esta casta.
	 * @return Retorna la fuerza extra de la casta.
	 */
	@Override
	public final int recibirFuerzaBonus() {
		return BONUSFUERZA;

	}
	/** Devuelve el bonus de destreza perteneciente a esta casta.
	 * @return Retorna 0 para esta casta.
	 */
	@Override
	public final int recibirDestrezaBonus() {

		return 0;
	}
	/** Devuelve el bonus de inteligencia perteneciente a esta casta.
	 * @return Retorna 0 para esta casta.
	 */
	@Override
	public final int recibirInteligenciaBonus() {
		return 0;
	}
	/**Retorna una string con el nombre de la casta.
	 * @return Retorna el nombre de la casta.
	 */
	@Override
	public final String getNombreCasta() {
		return "Guerrero";
	}
	/**Retorna un vector de string con los nombres
	 * de las habilidades de la casta.
	 * @return Retorna nombres de las habilidades
	 * propias de la casta.
	 */
	@Override
	public final String[] getHabilidadesCasta() {
		return new String[] {"Ataque Doble", "Aumentar Defensa", "Ignorar Defensa"};
	}
}



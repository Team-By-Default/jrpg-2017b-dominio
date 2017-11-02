
package dominio;
/** La clase Hechicero es una casta de Personaje.
 * Hereda de la clase Casta.
 * 
 * */
public class Hechicero extends Casta {
	/**
	 * Energía mínima para realizar una habilidad.
	 */
	private static final int ENERGIAMINIMA = 10;
	/**
	 * Número por el cual seran multiplicados los puntos de magia.
	 */
	private static final double MULTIPLICADORMAGIA = 1.5;
	/**
	 * Número por el cual se dividiran los puntos de magia.
	 */
	private static final int DIVISORDEMAGIA = 2;
	/**
	 * Bonus de inteligencia por ser de casta Hechicero.
	 */
	private static final int BONUSINTELIGENCIA = 5;

	/** Llama al constructor de la clase padre (Casta),
	 * pasándole los argumentos recibidos
	 * por el constructor hijo.
	 * @param probCrit Probabilidad de que el
	 * personaje realice un golpe crítico.
	 * @param evasion Probabilidad de que el personaje
	 * evite un golpe crítico.
	 * @param danioCrit Valor por el cual será
	 * multiplicado el golpe básico.
	 */

	public Hechicero(final double probCrit, final double evasion, final double danioCrit) {
		super(probCrit, evasion, danioCrit);

	}
	/** El constructor por defecto, llama al constructor
	 * por defecto de la clase padre (Casta), 
	 * inicializando probabilidadGolpeCritico,
	 * probabilidadEvitarDaño, dañoCritico,
	 * con valores predeterminados.
	 */
	public Hechicero() {
		super();
	}


	/** Efectua de ser posible la habilidad 1 de la casta.
	 * Para que la habilidad pueda realizarse, el atacante(caster)
	 * debe tener puntos de energía suficiente, ya que estos se
	 * descuentan seguido de comprobar que los posee,
	 * de lo contrario la habilidad no podra efectuarse.
	 * La habilidad consiste en un ataque potenciado por
	 * los puntos de magia del Hechicero.
	 * @param caster Personaje que realiza la habilidad.
	 * @param atacado puede ser una instancia de Persona
	 *  o NPC dependiendo de la misma,
	 * variará lo que retornará serAtacado()
	 * @return booleano que determina si el ataque 
	 * pudo realizarse con exito o no.
	 */
	@Override
	public final boolean habilidad1(final Personaje caster, final Peleable atacado) {
		if (caster.getEnergia() >= ENERGIAMINIMA) {
			caster.reducirEnergia(ENERGIAMINIMA);
			
			return atacado.serAtacado((int) (caster.calcularPuntosDeMagia() * MULTIPLICADORMAGIA)) > 0;
			
			/*if (atacado.serAtacado((int) (caster.calcularPuntosDeMagia() * MULTIPLICADORMAGIA)) > 0) {
				return true;
			}*/
		}
		return false;
	}


	/** Efectua de ser posible la habilidad 2 de la casta.
	 * Para que la habilidad pueda realizarse, el atacante(caster)
	 * debe tener puntos de energía suficiente, ya que estos se
	 * descuentan seguido de comprobar que los posee,
	 * de lo contrario la habilidad no podra efectuarse.
	 * La habilidad consiste en curar al aliado con magia,
	 * es decir, incrementar su atributo salud según los puntos
	 * de magia del Personaje llamador.
	 * Para poder realizar la habilidad, el Peleable aliado 
	 * debe ser una instancia de la clase Personaje.
	 * @param caster Personaje que realiza la habilidad.
	 * @param aliado atacado puede ser una instancia de
	 * Persona o NPC dependiendo de la misma podrá realizarse
	 * o no la habilidad.
	 * @return booleano que determina si la habilidad se 
	 * efectuo con éxito o no.
	 */
	@Override
	public final boolean habilidad2(final Personaje caster, final Peleable aliado) {
		if (caster.getEnergia() >= ENERGIAMINIMA) {
			caster.reducirEnergia(ENERGIAMINIMA);
			if (aliado instanceof Personaje) {
				((Personaje) aliado).serCurado(caster.calcularPuntosDeMagia());
				return true;
			}
		}
		return false;
	}

	/** Efectua de ser posible la habilidad 3 de la casta.
	 * Para que la habilidad pueda realizarse, el atacante(caster)
	 * debe tener puntos de energía suficiente, ya que estos se
	 * descuentan seguido de comprobar que los posee,
	 * de lo contrario la habilidad no podra efectuarse.
	 * La habilidad consiste en decrementar el atributo salud
	 * del oponente dependiendo de los puntos de magia propios
	 * del llamador.
	 * Para poder efectuar la habilidad, el Atacado debe 
	 * ser una instancia de la clase Personaje.
	 * @param caster Personaje que realiza la habilidad.
	 * @param atacado El atacado puede ser una instancia
	 * de Persona o NPC dependiendo de la misma podrá o no
	 * efectuarse la habilidad.
	 * @return retorna si se ejecutó correctamente la habilidad.
	 */
	@Override
	public final boolean habilidad3(final Personaje caster, final Peleable atacado) {
		if (caster.getEnergia() >= ENERGIAMINIMA) {
			caster.reducirEnergia(ENERGIAMINIMA);
			if (atacado instanceof Personaje) {
				int energiaRobada = ((Personaje) atacado).
						serDesernegizado(caster.calcularPuntosDeMagia());
				int saludRobada = ((Personaje) atacado).
						serRobadoSalud(caster.calcularPuntosDeMagia() / DIVISORDEMAGIA);
				caster.serEnergizado(energiaRobada);
				caster.serCurado(saludRobada);
				return true;
			}

		}
		return false;
	}
	/** Otorga el bonus de inteligencia 
	 * perteneciente a esta casta.
	 * @return Retorna la inteligencia extra de la casta.
	 */
	@Override
	public final int recibirInteligenciaBonus() {
		return BONUSINTELIGENCIA;
	}
	/** Retorna un entero que otorga el bonus de
	 * destreza perteneciente a esta casta.
	 * @return Retorna 0 para esta casta.
	 */
	@Override
	public final int recibirDestrezaBonus() {
		return 0;
	}
	/** Retorna un entero que otorga el bonus de
	 * fuerza perteneciente a esta casta.
	 * @return Retorna 0 para esta casta.
	 */
	@Override
	public final int recibirFuerzaBonus() {
		return 0;
	}
	/**Retorna una string con el nombre de la casta.
	 * @return Retorna el nombre de la casta.
	 */
	@Override
	public final String getNombreCasta() {
		return "Hechiero";
	}
	/**Retorna un vector de string con los nombres
	 * de las habilidades de la casta.
	 * @return Retorna nombres de las habilidades
	 * propias de la casta.
	 */
	@Override
	public final String[] getHabilidadesCasta() {
		return new String[] {"Bola de Fuego", "Curar Aliado", "Robar Energia y Salud"};
	}



}

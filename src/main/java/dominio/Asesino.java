
package dominio;

/** La clase Asesino es una casta de Personaje.
 * Hereda de la clase Casta.
 */

public class Asesino extends Casta {
	/**
	 * Energía mínima necesaria para realizar una habilidad.
	 */
	private static final int ENERGIAMINIMA = 10;
	/**
	 * Bonus de destreza por ser Asesino.
	 */
	private static final int BONUSDESTREZA = 5;
	/**
	 * Bonus al realizar correctamente la habilidad2.
	 */
	private static final double AUMENTARPROBEVITAR = 0.15;
	/**
	 * Probabilidad de evitar daño por defecto.
	 */
	private static final double PROBEVITARDANIO = 0.5;


	/** Llama al constructor de
	 * la clase padre (Casta)
	 * pasándole los argumentos recibidos
	 * por el constructor hijo y luego inicializa la
	 * variable nombreCasta.
	 * @param probCrit Probabilidad de que el
	 * personaje realice un golpe crítico.
	 * @param evasion Probabilidad de que el
	 * personaje evite un golpe crítico.
	 * @param danioCrit Valor por el cual será
	 * multiplicado el golpe básico.
	 */

public Asesino(final double probCrit, final double evasion, final double danioCrit) {
	super(probCrit, evasion, danioCrit);
}
	/** El constructor por defecto, llama al constructor por defecto
	 * 	padre (Casta), inicializando probabilidadGolpeCritico,
	 *  probabilidadEvitarDaño, dañoCritico,
	 * 	con valores predeterminados.
	 */
	public Asesino() {
		super();
	}


	/**Intenta realizar un ataque aplicando la habilidad 1 de la casta
	 * Para que el ataque pueda realizarse, el atacante(caster)
	 * debe tener puntos de energía suficiente, ya que estos se
	 * descuentan seguido de comprobar que los posee,
	 * de lo contrario el ataque no será posible.
	 * De ser posible el ataque, se llama al método
	 * serAtacado() del argumento atacado el cual actuará de
	 * cierta manera dependiendo de que clase
	 * sea el argumento atacado.
	 * @param caster Personaje atacante.
	 * @param atacado puede recibir como argumento
	 * una instancia de Personaje o de NPC
	 * (NonPlayableCharacter)
	 * ya que ambas implementan la interface Peleable.
	 * @return retorna si el ataque fue realizado
	 * con éxito o no.
	 */
	@Override
	public final boolean habilidad1(final Personaje caster, final Peleable atacado) {
		if (caster.getEnergia() >= ENERGIAMINIMA) {
			caster.reducirEnergia(ENERGIAMINIMA);
			return atacado.serAtacado((int) (caster.getAtaque() * caster.getCasta().getDañoCritico()), caster) > 0;
			/*
			if (atacado.serAtacado((int) (caster.getAtaque() * caster.getCasta().getDañoCritico())) > 0) {
				return true;
			}
			*/
		}
		return false;
	}


	/** Efectua de ser posible la habilidad 2 de la casta.
	 * Para que la habilidad pueda realizarse, el atacante(caster)
	 * debe tener puntos de energía suficiente, ya que estos se
	 * descuentan seguido de comprobar que los posee,
	 * de lo contrario la habilidad no podra efectuarse.
	 * La habilidad es realizar un aumento 
	 * en el atributo probabilidadEvitarDaño.
	 * @param caster Personaje que efectua la habilidad.
	 * @param atacado no cumple función alguna
	 * dentro de este método.
	 * @return retorna si la habilidad fue realizada
	 * con éxito o no.
	 */
	@Override
	public final boolean habilidad2(final Personaje caster, final Peleable atacado) {
		if (caster.getEnergia() >= ENERGIAMINIMA) {
			caster.reducirEnergia(ENERGIAMINIMA);
			if (this.getProbabilidadEvitarDaño() + AUMENTARPROBEVITAR < 0.5) {
				this.aumentarEvitarDaño(AUMENTARPROBEVITAR);
			} else {
				this.setProbabilidadEvitarDaño(PROBEVITARDANIO);
			}
			return true;
		}
		return false;
	}

	/** No implementado hasta el momento.
	 * @param caster Personaje que realiza el ataque.
	 * @param atacado.
	 * @return Retorna falso.
	 */
	@Override
	public final boolean habilidad3(final Personaje caster, final Peleable atacado) {
		return false;
	}
	/** Otorga el bonus de  destreza perteneciente a esta casta.
	 * @return Retorna la destreza extra de la casta.
	 */
	@Override
	public final int recibirDestrezaBonus() {
		return BONUSDESTREZA;
	}
	/** Devuelve el bonus de fuerza perteneciente a esta casta.
	 * @return Retorna 0 para esta casta.
	 */
	@Override
	public final int recibirFuerzaBonus() {
		return 0;
	}
	/** Otorga el bonus de
	 * inteligencia perteneciente a esta casta.
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
		return "Asesino";
	}
	/**Retorna un vector de string.
	 * Con los nombres de las habilidades de la casta.
	 * @return Retorna nombres de las habilidades
	 *  propias de la casta.
	 */
	@Override
	public final String[] getHabilidadesCasta() {
		return new String[] {"Golpe Critico", "Aumentar Evasion", "Robar"};
	}

}


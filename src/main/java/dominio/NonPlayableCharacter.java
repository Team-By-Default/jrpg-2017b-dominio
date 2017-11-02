package dominio;

/**
 * La clase NonPlayableCharacter (NPC).
 * Representa a los personajes del juego que no son
 * controlados por humanos.
 * Implementa la Interfaz Peleable.
 */

public class NonPlayableCharacter extends MadreDeTodo implements Peleable {
	/**
	 * Número que sirve de argumento para obtener la dificultad.
	 */
	private static final int ELEGIRDIF = 3;
	/**
	 * Salud del NPC.
	 */
	private int salud;
	/**
	 * Dificultad aleatoria NPC.
	 */
	private static final int DIFICULTADALEATORIA = -1;
	/**
	 * Multiplicador de experiencia otorgada por el NPC.
	 */
	private static final int MULTIPLICADOREXPNPC = 30;
	/**
	 * Multiplicador de fuerza para el golpe crítico del NPC.
	 */
	private static final double MULTIPLICADORFUERZA = 1.5;
	/**
	 * Número a superar para poder ser atacado.
	 */
	private static final double NUMEROPARASERATACADO = 0.15;
	/**
	 * Número a superar para poder atacar.
	 */
	private static final double NUMEROPARAATACAR = 0.15;
	/**
	 * Número por el cual se divide la defensa cuando el NPC es atacado.
	 */
	private static final int DIVISORDEDEFENSA = 2;
	/**
	 * Fuerza base del NPC.
	 */
	private static final int MODIFICADORBASEF = 10;
	/**
	 * Salud base del NPC.
	 */
	private static final int MODIFICADORBASES = 30;
	/**
	 * Defensa base del NPC.
	 */
	private static final int MODIFICADORBASED = 2;
	/**
	 * Multiplicador fuerza del NPC.
	 */
	private static final int MULTIPLICADORF = 3;
	/**
	 * Multiplicador salud del NPC.
	 */
	private static final int MULTIPLICADORS = 15;
	/**
	 * Multiplicador defensa del NPC.
	 */
	private static final int MULTIPLICADORD = 1;
	/**
	 * Salud tope con que se inicializa el NPC
	 */
	private static final int SALUDTOPEINICIAL = 100;
	/**
	 * Salud tope del NPC
	 */
	private int saludTope;

	
	
	
	/**
	 * Constructor de la Clase.
	 * Dependiendo de la dificultad que se pasa por parámetro al
	 * constructor, aumentará o disminuirá el valor de los
	 * atributos fuerza salud y defensa.
	 * @param nombre Nombre que se le otorga al NPC
	 * @param nivel Nivel que se le otorga al NPC
	 * @param dificultadNPC valor Entero que produce una variación en los atributos.
	 */
	public NonPlayableCharacter(final String nombre, final int nivel, final int dificultadNPC) {
		super(0, 0, nivel, nombre,0,0);

		
		this.saludTope = SALUDTOPEINICIAL;
		int dificultad;
		if (dificultadNPC == DIFICULTADALEATORIA) {
			dificultad = this.getRandom().nextInt(ELEGIRDIF);
		} else {
			dificultad = dificultadNPC;
		}

		this.aumentarFuerza(MODIFICADORBASEF * (dificultad + 1) +
				(nivel - 1) * MULTIPLICADORF * (dificultad + 1));
		this.salud = MODIFICADORBASES * (dificultad + 1) + (nivel - 1) * MULTIPLICADORS * (dificultad + 1);
		this.aumentarDefensa(MODIFICADORBASED * (dificultad + 1) +
				(nivel - 1) * MULTIPLICADORD * (dificultad + 1));
		
	}
	/**
	 * Le asigna al NPC una nueva posición en el mapa.
	 * @param x posición en X
	 * @param y posición en Y
	 */
	public void setPosicion(int x,int y){
		this.setPosicionX(x);
		this.setPosicionY(y);
	}
	/**Devuelve la posición en X del NPC
	 * @return posición actual del NPC en X. 
	 */
	public int getPosicionX(){
		return this.getPosicionX();
	}
	/**Devuelve la posición en Y del NPC
	 * @return posición actual del NPC en Y. 
	 */
	public int getPosicionY(){
		return this.getPosicionY();
	}
	/**
	 * Retorna un entero.
	 * Que representa los puntos de experiencia 
	 * que deben sumarse al Personaje que
	 * derrotó al NPC (disminución de la salud del
	 * NPC a 0). La misma sera MULTIPLCADOREXPNPC veces
	 * el nivel del NPC derrotado.
	 * @return Puntos de experiencia a otorgar.
	 */
	@Override
	public final int otorgarExp() {
		return this.getNivel() * MULTIPLICADOREXPNPC;
	}


	/**
	 * Retorna un booleano, que indica si el NPC esta vivo, 
	 * evaluando si el mismo tiene salud mayor a 0.
	 * @return true si el NPC está vivo, false para lo contrario.
	 */
	@Override
	public final boolean estaVivo() {
		return salud > 0;
	}


	/**
	 * Retorna un entero que representa los puntos de salud del NPC.
	 * @return Devuelve la cantidad de vida actual del NPC.
	 */
	@Override
	public final int getSalud() {
		return salud;
	}

	/**
	 * Asigna un valor entero que representará la salud del NPC.
	 * @param salud Entero que indica la nueva salud del NPC.
	 */
	public final void setSalud(final int salud) {
		this.salud = salud;
	}
	
	/**
	 * Devuelve un entero con la saludTope del NPC.
	 * @return salud tope.
	 */
	public int getSaludTope() {
		return this.saludTope;
	}

	/**
	 * Dependiendo de MyRandom.nextDouble() y NUMEROPARAATACAR, 
	 * permite ejecutar un ataque mejorado 
	 * por el atributo MULTIPLICADORFUERZA.
	 * @param atacado Peleable que recibe el ataque.
	 * @return Retorna un entero que representa
	 * los puntos de daño realizados.
	 */
	@Override
	public final int atacar(final Peleable atacado) {
		if (this.getRandom().nextDouble() <= NUMEROPARAATACAR) {
			return atacado.serAtacado((int) (this.getAtaque() * MULTIPLICADORFUERZA));
		} else {
			return atacado.serAtacado(this.getAtaque());
		}
	}

	/**
	 * Dependiendo de MyRandom.nextdouble() y NUMEROPARASERATACADO.
	 * Puede disminuir el daño dependiendo del atributo DIVISORDEDEFENSA.
	 * @param danio valor a ser descontado del atributo salud.
	 * @return Retorna 0 si el ataque no fue realizado con exito.
	 */
	@Override
	public final int serAtacado(int danio) {
		if (this.getRandom().nextDouble() >= NUMEROPARASERATACADO) {
			danio -= this.getDefensa() / DIVISORDEDEFENSA;
			if (danio > 0) {
				salud -= danio;
				return danio;
			}
			return 0;
		}
		return 0;
	}

	/**
	 * Método no implementado.
	 */
	@Override
	public void despuesDeTurno() { }
	/**
	 * Método no implementado.
	 * @param exp Experiencia que se debe aumentar al NPC.
	 */
	public void ganarExperiencia(final int exp) {

	}

	/**
	 * Retorna la Fuerza del NPC, que se usara como su fuerza de ataque.
	 * @return retorna el ataque del NPC.
	 */
	@Override
	public final int getAtaque() {
		return this.getFuerza();
	}

	/**
	 * Asigna un valor entero que representará el ataque del NPC al atributo fuerza.
	 * @param ataque Entero que se le asigna a la fuerza  del NPC.
	 */
	@Override
	public final void setAtaque(final int ataque) {
		this.setFuerza(ataque);
	}

	/**
	 * Retorna siempre un entero de valor 0.
	 * @return retorna 0 porque NPC no tiene magia.
	 */
	@Override
	public final int getMagia() {
		return 0;
	}
}

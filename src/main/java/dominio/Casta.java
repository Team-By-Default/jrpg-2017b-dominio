
package dominio;

import java.io.Serializable;
	/** Clase abstracta de la cual heredarán las
	 * clases Asesino, Guerrero y Hechicero.
	 * Posee dos contructores, el contructor
	 * por defecto (no recibe argumentos),
	 * pondrá los atributos con sus
	 * respectivos valores por defecto.
	 */
public abstract class Casta implements Serializable {
	/**
	 * Número que indica la probabilidad 
	 * del personaje de realizar un golpe crítico.
	 */
	private double probabilidadGolpeCritico;
	/**
	 * Número que indica la probabilidad 
	 * del personaje de evitar un ataque.
	 */
	private double probabilidadEvitarDaño;
	/**
	 * Número por el cual sera multiplicado el ataque
	 * al realizarse un golpe crítico.
	 */
	private double dañoCritico;
	/**
	 * Número que indica la probabilidad 
	 * del personaje de evitar un golpe crítico.
	 */
	private static final double PROBEVITARGOLPC = 0.2;
	/**
	 * Número que indica la probabilidad 
	 * del personaje de evitar recibir daño.
	 */
	private static final double PROBEVITARDANIO = 0.2;
	/**
	 *  Número por el cual sera multiplicado el ataque por defecto
	 *  si se efectua un golpe crítico.
	 */
	private static final double DANIOCRITICO = 1.5;


	/** Contructor por defecto,
	 * pondrá los atributos con sus
	 * respectivos valores por defecto.
	 */
	public Casta() {
		this.probabilidadGolpeCritico = PROBEVITARGOLPC;
		this.probabilidadEvitarDaño = PROBEVITARDANIO;
		this.dañoCritico = DANIOCRITICO;
	}
	 /** El constructor asignará a cada atributo,
	 * el valor correspondiente
	 * que se reciba por argumento.
	 * @param probCrit Probabilidad
	 * de que el personaje realice un golpe crítico
	 * @param evasion Probabilidad
	 * de que el personaje evite un golpe crítico
	 * @param danioCrit Valor por el cual será
	 * multiplicado el golpe básico
	 */
	public Casta(final double probCrit, final double evasion, final double danioCrit) {
		this.probabilidadGolpeCritico = probCrit;
		this.probabilidadEvitarDaño = evasion;
		this.dañoCritico = danioCrit;
	}
	/**
	 * Método abstracto que será implementado
	 * en Asesino, Guerrero y Hechicero.
	 * @param caster Personaje atacante.
	 * @param atacado Personaje que recibirá el ataque.
	 * @return Retornará true si el ataque fue realizado
	 * exitosamente, false de lo contrario.
	 */
	public abstract boolean habilidad1(Personaje caster, Peleable atacado);
	/**Método abstracto que será implementado
	 * en Asesino, Guerrero y Hechicero.
	 * @return Retorna la fuerza extra de la casta.
	 */
	public abstract int recibirFuerzaBonus();
	/**Método abstracto que será implementado
	 * en Asesino, Guerrero y Hechicero.
	 * @return Retorna la destreza extra de la casta.
	 */
	public abstract int recibirDestrezaBonus();
	/**Método abstracto que será implementado
	 * en Asesino, Guerrero y Hechicero.
	 * @return Retorna la inteligencia extra de la casta.
	 */
	public abstract int recibirInteligenciaBonus();
	/**
	 * Método abstracto que será implementado
	 * en Asesino, Guerrero y Hechicero.
	 * @param caster Personaje atacante.
	 * @param atacado Personaje que recibirá el ataque.
	 * @return Retornará true si el ataque fue realizado
	 * exitosamente, false de lo contrario.
	 */
	public abstract boolean habilidad2(Personaje caster, Peleable atacado);
	/**
	 * Método abstracto que será implementado
	 * en Asesino, Guerrero y Hechicero.
	 * @param caster Personaje atacante.
	 * @param atacado Personaje que recibirá el ataque.
	 * @return Retornará true si el ataque fue realizado
	 * exitosamente, false de lo contrario.
	 */
	public abstract boolean habilidad3(Personaje caster, Peleable atacado);
	/**Método abstracto que será implementado
	 * en Asesino, Guerrero y Hechicero.
	 * @return Retorna el nombre de la casta.
	 */
	public abstract String getNombreCasta();
	/**Método abstracto que será implementado
	 * en Asesino, Guerrero y Hechicero.
	 * @return Retorna nombres de las
	 * habilidades propias de la casta.
	 */
	public abstract String[] getHabilidadesCasta();
	/**Método abstracto que será implementado
	 * en Asesino, Guerrero y Hechicero.
	 * @return Retorna la probabilidad de un golpe 
	 * crítico propia de la casta.
	 */
	public final double getProbabilidadGolpeCritico() {
		return probabilidadGolpeCritico;
	}
	/** Sobreescribe el atributo
	 * probabilidadGolpeCritico.
	 * con el valor que se ingresa por parámetro.
	 * @param probabilidadGolpeCritico Valor
	 * que tendra probabilidadGolpeCritico
	 */
	public final void setProbabilidadGolpeCritico(final double probabilidadGolpeCritico) {
		this.probabilidadGolpeCritico = probabilidadGolpeCritico;
	}
	/** Devuelve la probabilidadEvitarDaño.
	 * @return probabilidadEvitarDaño
	 */
	public final double getProbabilidadEvitarDaño() {
		return probabilidadEvitarDaño;
	}
	/** Sobreescribe el atributo probabilidadEvitarDaño.
	 * con el valor que se ingresa por parámetro.
	 * @param probabilidadEvitarDanio Valor que
	 * tendra probabilidadEvitarDaño.
	 */
	public final void setProbabilidadEvitarDaño(final double probabilidadEvitarDanio) {
		this.probabilidadEvitarDaño = probabilidadEvitarDanio;
	}
	/** Devuelve el dañoCritico.
	 * @return dañoCritico
	 */
	public final double getDañoCritico() {
		return dañoCritico;
	}
	/** Sobreescribe el atributo dañoCritico.
	 * con el valor que se ingresa por parámetro.
	 * @param danioCritico Valor que tendra dañoCritico
	 */
	public final void setDañoCritico(final double danioCritico) {
		this.dañoCritico = danioCritico;
	}
	/** Aumenta el atributo probabilidadEvitarDaño.
	 * con el valor que se ingresa por parámetro.
	 * @param bonus bonficador de evitar daño.
	 */
	public final void aumentarEvitarDaño(final double bonus) {
		this.probabilidadEvitarDaño += bonus;
	}

}



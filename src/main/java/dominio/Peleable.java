
package dominio;

/** Interfaz implementada en las clases Personaje
 * y NonPlayableCharacter.
 * Contiene los métodos utilizados durante un combate.
 * Cada método se implementa de forma diferente en cada clase.
 */
public interface Peleable {
	/**
	 * Método implementado en Personaje
	 * y en NonPlayableCharacter.
	 * 
	 * el método determinara a traves de la defensa del llamador y el daño que ejerce 
	 * el oponente, cual sera el daño real ejercido sobre el llamador, 
	 * el cual se resta a la salud del mismo.
	 *
	 * @param daño Valor que representa el daño que ejerce el atacante.
	 * @return Retorna un entero con el daño causado al llamador.
	 */
	int serAtacado(int daño);

	/**
	 * Método implementado en Personaje
	 * y NonPlayableCharacter.
	 *
	 *Retorna un entero que representa los puntos de salud del Peleable llamador.
	 * @return Devuelve la cantidad de vida actual del llamador.
	 */
	int getSalud();
	/**
	 * Método implementado en Personaje
	 * y NonPlayableCharacter.
	 *
	 * @return Retornara un entero con la magia del llamador.
	 */
	int getMagia();
	/*/**
	 * Método implementado en Personaje.
	 *
	 * @return Retornara un entero con la energia del llamador.
	 */
	//int getEnergia();

	/**
	 * Método void implementado en Personaje
	 * y NonPlayableCharacter.
	 * Hasta el momento no se usa.
	 */
	void despuesDeTurno();
	/**
	 * Método implementado en Personaje
	 * y NonPlayableCharacter.
	 * @param atacado Peleable al cual el llamador atacara.
	 * @return Retorna el daño efectivo causado por el atacante al atacado.
	 */
	int atacar(Peleable atacado);
	/**
	 * Método implementado en Personaje
	 * y NonPlayableCharacter.
	 * @return Retorna el nivel del llamador multiplicado por la
	 * constante MULTIPLICADOREXP.
	 */
	int otorgarExp();
	/**
	 * Método implementado en Personaje
	 * y NonPlayableCharacter.
	 * @return Retorna un entero con el ataque del llamador.
	 */
	int getAtaque();
	/**
	 * Método implementado en Personaje
	 * y NonPlayableCharacter.
	 * @param ataque Entero que será el nuevo ataque del llamador.
	 */
	void setAtaque(int ataque);
	/**
	 * Método implementado en Personaje
	 * y NonPlayableCharacter.
	 *
	 * Retorna un booleano.
	 * Que indica si el Peleable esta vivo o no.
	 * @return true si el NPC está vivo, false para lo contrario.
	 */
	boolean estaVivo();
}


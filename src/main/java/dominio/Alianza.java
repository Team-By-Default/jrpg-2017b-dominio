
package dominio;

import java.util.LinkedList;
/**La clase Alianza tiene como función agrupar a los jugadores,
 * mediante una LinkedList de Personajes.
 */
public class Alianza {
	/**
	 * Nombre que tendra la alianza.
	 */
	private final String nombre;
	/**
	 * Lista que contendra todos los integrantes de la alianza.
	 */
	private LinkedList<Personaje> aliados;

	/**La clase Alianza tiene como función agrupar a los jugadores,
	 * mediante una LinkedList de Personajes.
	 * @param nombre Nombre que se le dará a la alianza.
	 */
	public Alianza(final String nombre) {
		this.nombre = nombre;
		this.aliados = new LinkedList<Personaje>();
	}
	/** Devuelve la lista
	 * que contiene los personajes
	 * pertenecientes a la alianza.
	 * @return Retorna la lista de aliados.
	 */
	public final LinkedList<Personaje> getAliados() {
		return new LinkedList<Personaje>(aliados);
	}


	/** Devuelve el nombre de la alianza.
	 * @return Retorna nombre de la alianza.
	 */
	public final String obtenerNombre() {
		return nombre;
	}
	/** Elimina al personaje recibido por 
	 * parámetro de la alianza.
	 * @param pj personaje a remover
	 * de la alianza.
	 */
	public final void eliminarPersonaje(final Personaje pj) {
		aliados.remove(pj);
	}

	/**Agrega un nuevo Personaje recibido por parámetro
	 * a la LinkedList aliados,
	 * utilizando el método add() de la LinkedList
	 * @param pj Personaje a agregarse a la lista de aliados
	 */
	public final void añadirPersonaje(final Personaje pj) {
		aliados.add(pj);
	}
}


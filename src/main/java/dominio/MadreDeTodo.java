
package dominio;

import java.util.ArrayList;

/** Clase abstracta, cuyo objetivo es contener los atributos y métodos
 *  que comparten las clases NPC y Personaje.
 */
public abstract class MadreDeTodo {

	/**
	 * Fuerza que recibira el personaje o NPC.
	 */
	private int fuerza;
	/**
	 * Defensa que recibira el personaje o NPC.
	 */
	protected int defensa;
	/**
	 * Nivel que recibira el personaje o NPC.
	 */
	private int nivel;
	/**
	 * Nombre que recibirá el personaje o NPC.
	 */
	private String nombre;
	/**
	 * Objeto para obtener valores aleatorios.
	 */
	private RandomGenerator random;

	protected ArrayList<Item> items = new ArrayList<Item>();
	/**
	 * Posicion en X del personaje o NPC.
	 */
	private int x;
	/**
	 * Posicion en Y del personaje o NPC.
	 */
	private int y;


	/** Constructor
	 * @param fuerza valor otorgado por
	 * el constructor de NPC o Personaje.
	 * @param defensa valor otorgado por
	 * el constructor de NPC o Personaje.
	 * @param nivel valor otorgado por
	 * el constructor de NPC o Personaje.
	 * @param nombre valor otorgado por
	 * el constructor de NPC o Personaje.
	 * @param x valor otorgado por
	 * el constructor de NPC o Personaje.
	 * @param y valor otorgado por
	 * el constructor de NPC o Personaje.
	 */
	public MadreDeTodo(final int fuerza, final int defensa, final int nivel, final String nombre, int x,int y) {
		this.fuerza = fuerza;
		this.defensa = defensa;
		this.nivel = nivel;
		this.nombre = nombre;
		this.random = new MyRandom();
		this.x = x;
		this.y = y;
	}
	/**Devuelve la posición en X del personaje o NPC.
	 * @return posición actual del personaje o NPC en X. 
	 */
	public int getPosicionX(){
		return this.x;
	}
	/**Asigna una nueva posición en X al personaje o NPC.
	 * @param x nueva posición del personaje o NPC en X. 
	 */
	public void setPosicionX(int x){
		this.x=x;
	}
	/**Devuelve la posición en Y del personaje o NPC.
	 * @return posición actual del personaje o NPC en Y. 
	 */
	public int getPosicionY(){
		return this.y;
	}
	/**Asigna una nueva posición en Y al personaje o NPC.
	 * @param x nueva posición del personaje o NPC en Y. 
	 */
	public void setPosicionY(int y){
		this.y=y;
	}

	/** Devuelve la fuerza del personaje o NPC.
	 * @return fuerza del personaje o NPC.
	 */
	public final int getFuerza() {
		return fuerza;
	}

	/** Devuelve la defensa del personaje o NPC.
	 * @return defensa del personaje o NPC.
	 */
	public final int getDefensa() {
		return defensa;
	}

	/** Devuelve el nivel del personaje o NPC.
	 * @return nivel del personaje o NPC.
	 */
	public final int getNivel() {
		return nivel;
	}

	/** Devuelve el nombre del personaje o NPC.
	 * @return nombre del personaje o NPC.
	 */
	public final String getNombre() {
		return nombre;
	}
	/** Remplaza el atributo nombre por 
	 *  el string ingresado por parámetro.
	 * @param nuevo nombre del personaje o NPC.
	 */
	public final void setNombre(final String nombre) {
		this.nombre = nombre;
	}
	/** Aumenta la fuerza del personaje o NPC, 
	 * con el valor que se ingresa por parámetro.
	 * @param aumento incremento que se le aplicara a la fuerza.
	 */
	public final void aumentarFuerza(final int aumento) {
		fuerza += aumento;
	}
	/**
	 * Remplaza la fuerza del personaje o NPC con el valor
	 * que se recibe por parámetro.
	 * @param fuerza valor por el que se remplazara la fuerza anterior.
	 */
	public final void setFuerza(final int fuerza){
		this.fuerza = fuerza;
	}
	/** Incrementa en uno el nivel del personaje o NPC.
	 */
	public final void aumentarNivel() {
		nivel++;
	}

	/**
	 * Devuelve el atributo random del personaje o NPC.
	 * @return Retorna el objeto generador de números aleatorios.
	 */
	public final RandomGenerator getRandom() {
		return random;
	}

	/**
	 * Sobreescribe el atributo random.
	 * @param random objeto generador de números aleatorios que reemplazará al actual.
	 */
	public final void setRandom(final RandomGenerator random) {
		this.random = random;
	}
	/**
	 * Aumenta la defensa del personaje o NPC.
	 * @param bonus valor que se le agrega a la defensa.
	 */
	public final void aumentarDefensa(final int bonus) {
		defensa += bonus;
	}
	/**
	 * Reduce la defensa del personaje o NPC.
	 * @param reduc Valor que se le reduce a la defensa.
	 */
	public final void reducirDefensa(final int reduc) {
		defensa -= reduc;
	}
	/**
	 * Añade items al ArrayList de items del personaje o NPC.
	 * @param i Item a agregar.
	 */
	public final void anadirItem(final Item i) {
		items.add(i);
	}
	/**
	 * Remueve items del ArrayList de items del personaje o NPC.
	 * @param i Item a eliminar.
	 */
	public final void removerItem(final Item i) {
		items.remove(i);
	}
	/**
	 * Devuelve la lista de items.
	 * @return Lista de items del personaje o NPC.
	 */
	public ArrayList<Item> getItems() {
		return items;
	}
}

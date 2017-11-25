package dominio;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import javax.imageio.ImageIO;
/**
 * Clase que representa los Items que posee el personaje.
 */
public class Item implements Serializable {
	private int idItem;
	private String foto;
	private String nombre;
	private int wearLocation;
	private int bonusSalud;
	private int bonusEnergia;
	private int bonusFuerza;
	private int bonusDestreza;
	private int bonusInteligencia;
	private String fotoEquipado;
	private int fuerzaRequerida;
	private int destrezaRequerida;
	private int inteligenciarequerida;
	/**
	 * Constructor del Item.
	 * @param idItem Entero que representa el id del item.
	 * @param nombre String que representa el nombre del item.
	 * @param wearLocation Entero que representa donde se usa el item.
	 * @param bonusSalud Entero que representa el bonus de salud del item.
	 * @param bonusEnergia Entero que representa el bonus de energía del item.
	 * @param bonusFuerza Entero que representa el bonus de fuerza del item.
	 * @param bonusDestreza Entero que representa el bonus de destreza del item.
	 * @param bonusInteligencia Entero que representa el bonus de inteligencia del item.
	 * @param foto String que representa el path de la foto del item.
	 * @param fotoEquipado String que representa el path de la foto 
	 * cuando el item está equipado.
	 * @throws IOException Cuando no se encuentra la foto del item.
	 */
	public Item(int idItem, String nombre, int wearLocation,
			int bonusSalud, int bonusEnergia, int bonusFuerza, int bonusDestreza,
			int bonusInteligencia, String foto, String fotoEquipado) throws IOException {
		this.foto = foto;
		this.idItem = idItem;
		this.nombre = nombre;
		this.wearLocation = wearLocation;
		this.bonusSalud = bonusSalud;
		this.bonusEnergia = bonusEnergia;
		this.bonusFuerza = bonusFuerza;
		this.bonusDestreza = bonusDestreza;
		this.bonusInteligencia = bonusInteligencia;
		this.fotoEquipado = fotoEquipado;
	}

	public Item() {
	}
	
	/**
	 * Retorna la foto del item.
	 * @return Retorna la foto del item.
	 * @throws IOException Cuando no se encuentra la foto del item.
	 */
	public BufferedImage getFotoBI() throws IOException {
		return ImageIO.read(new File("recursos//" + foto));
	}
	
	/**
	 * Retorna el nombre de la foto del item.
	 * @return String de la foto del item.
	 */
	public String getFoto(){
		return this.foto;
	}
	
	/**
	 * Retorna el nombre del item.
	 * @return Retorna el nombre del item.
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * Retorna el bonus de salud del item.
	 * @return Retorna bonus de salud.
	 */
	public int getBonusSalud() {
		return bonusSalud;
	}
	/**
	 * Retorna el bonus de energía del item.
	 * @return Retorna bonus de energía.
	 */
	public int getBonusEnergia() {
		return bonusEnergia;
	}
	/**
	 * Retorna el bonus de fuerza del item.
	 * @return Retorna bonus de fuerza.
	 */
	public int getBonusFuerza() {
		return bonusFuerza;
	}
	/**
	 * Retorna el bonus de destreza del item.
	 * @return Retorna bonus de destreza.
	 */
	public int getBonusDestreza() {
		return bonusDestreza;
	}
	/**
	 * Retorna el bonus de inteligencia del item.
	 * @return Retorna bonus de inteligencia.
	 */
	public int getBonusInteligencia() {
		return bonusInteligencia;
	}
	/**
	 * Retorna el id del item.
	 * @return Retorna el id del item.
	 */
	public int getIdItem() {
		return idItem;
	}

	/**
	 * Permite devolver el atributo wearLocation (uso meramente para la bd,plan: quitarlo)
	 * @return int
	 */
	public int getWearLocation() {
		return wearLocation;
	}

	/**
	 * Permite setear el atributo wearLocation (uso meramente para la bd,plan: quitarlo)
	 * @param wearLocation pasado
	 */
	public void setWearLocation(int wearLocation) {
		this.wearLocation = wearLocation;
	}

	/**
	 * Permite devolver este atributo que es una copia de foto
	 * @return int
	 */
	public String getFotoEquipado() {
		return fotoEquipado;
	}

	/**
	 * Permite que hibernate setee la fotoEquipado
	 * @param fotoEquipado
	 */
	public void setFotoEquipado(String fotoEquipado) {
		this.fotoEquipado = fotoEquipado;
	}

	/**
	 * Permite leer el atributo fuerzaRequerida (no usado, solo para hibernate)
	 * @return  int fuerzaRequerida
	 */
	public int getFuerzaRequerida() {
		return fuerzaRequerida;
	}

	/**
	 * Permite que hibernate setee la fuerzaRequerida
	 * @param fuerzaRequerida
	 */
	public void setFuerzaRequerida(int fuerzaRequerida) {
		this.fuerzaRequerida = fuerzaRequerida;
	}
	/**
	 * Permite leer el atributo destrezaRequerida (no usado, solo para hibernate)
	 * @return  int destrezaRequerida
	 */
	public int getDestrezaRequerida() {
		return destrezaRequerida;
	}
	/**
	 * Permite que hibernate setee la destrezaRequerida
	 * @param desrezaRequerida
	 */
	public void setDestrezaRequerida(int destrezaRequerida) {
		this.destrezaRequerida = destrezaRequerida;
	}
	/**
	 * Permite leer el atributo inteligenciarequerida (no usado, solo para hibernate)
	 * @return  int inteligenciarequerida
	 */
	public int getInteligenciarequerida() {
		return inteligenciarequerida;
	}
	/**
	 * Permite que hibernate setee la inteligenciarequerida
	 * @param inteligenciarequerida
	 */
	public void setInteligenciarequerida(int inteligenciarequerida) {
		this.inteligenciarequerida = inteligenciarequerida;
	}
	
	/**
	 * Hibernate. Setea el id del item
	 * @param idItem
	 */
	public void setIdItem(int idItem) {
		this.idItem = idItem;
	}

	/**
	 * Hibernate. Setea la string de la foto
	 * @param foto
	 */
	public void setFoto(String foto) {
		this.foto = foto;
	}

	/**
	 * Hibernate. Setea el string del nombre
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Hibernate. Setea el bonus de salud
	 * @param bonusSalud
	 */
	public void setBonusSalud(int bonusSalud) {
		this.bonusSalud = bonusSalud;
	}

	/**
	 * Hibernate. Setea el bonus de energía
	 * @param bonusEnergia
	 */
	public void setBonusEnergia(int bonusEnergia) {
		this.bonusEnergia = bonusEnergia;
	}

	/**
	 * Hibernate. Setea el bonus de fuerza
	 * @param bonusFuerza
	 */
	public void setBonusFuerza(int bonusFuerza) {
		this.bonusFuerza = bonusFuerza;
	}

	/**
	 * Hibernate. Setea el bonus de destreza
	 * @param bonusDestreza
	 */
	public void setBonusDestreza(int bonusDestreza) {
		this.bonusDestreza = bonusDestreza;
	}

	/**
	 * Hibernate. Setea el bonus de inteligencia
	 * @param bonusInteligencia
	 */
	public void setBonusInteligencia(int bonusInteligencia) {
		this.bonusInteligencia = bonusInteligencia;
	}

}

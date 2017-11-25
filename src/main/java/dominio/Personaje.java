package dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.DefaultListModel;
/** Clase Personaje.
 * La cual sirve de base para la creacion de las distintas Razas.
 * De esta clase heredan las clases de las distintas Razas (Elfo, Humano y Orco).
 */

public abstract class Personaje extends MadreDeTodo implements Peleable, Serializable {
	/**
	 * Salud del personaje.
	 */
	private int salud;
	/**
	 * Energía del personaje.
	 */
	private int energia;
	/**
	 * Cantidad de niveles.
	 */
	private static final int CANTIDADNIVELES = 101;
	/**
	 * Constante que se suma al cargar la tabla de niveles.
	 */
	private static final int CONSTANTENIVEL = 50;
	/**
	 * Fuerza inicial del personaje.
	 */
	private static final int FUERZAINICIAL = 10;
	/**
	 * Destreza inicial del personaje.
	 */
	private static final int DESTREZAINICIAL = 10;
	/**
	 * Inteligencia inicial del personaje.
	 */
	private static final int INTELIGENCIANICIAL = 10;
	/**
	 * Defensa inicial del personaje.
	 */
	private static final int DEFENSAINICIAL = 0;
	/**
	 * Experiencia inicial del personaje.
	 */
	private static final int EXPERIENCIAINICIAL = 0;
	/**
	 * Nivel inicial del personaje.
	 */
	private static final int NIVELINICIAL = 1;
	/**
	 * Salud tope inicial del personaje.
	 */
	private static final int SALUDTOPEINICIAL = 100;
	/**
	 * Energía tope inicial del personaje.
	 */
	private static final int ENERGIATOPEINICIAL = 100;
	/**
	 * Fuerza máxima del personaje.
	 */
	private static final int FUERZAMAXIMA = 200;
	/**
	 * Defensa máxima del personaje.
	 */
	private static final int DEFENSAMAXIMA = 200;
	/**
	 * Inteligencia máxima del personaje.
	 */
	private static final int INTELIGENCIAMAXIMA = 200;
	/**
	 * Nivel máximo permitido.
	 */
	private static final int NIVELMAXIMO = 100;
	/**
	 * Aumento de salud tope al subir de nivel.
	 */
	private static final int SALUDTOPESUBIRN = 25;
	/**
	 * Aumento de energía tope al subir de nivel.
	 */
	private static final int ENERGIATOPESUBIRN = 20;
	/**
	 * Cantidad a multiplicar 
	 * para obtener los puntos de ataque de personaje.
	 */
	private static final double MULTIPLICADORFZA = 1.5;
	/**
	 * Cantidad a multiplicar para obtener los puntos de magia de personaje.
	 */
	private static final double MULTIPLICADORMGA = 1.5;
	/**
	 * Cantidad a multiplicar.
	 * Para obtener la experiencia otorgada por el personaje
	 * cuando este es vencido.
	 */
	private static final int MULTIPLICADOREXP = 40;
	/**
	 * Energía mínima necesaria para poder realizar una habilidad.
	 */
	private static final int ENERGIAMINIMA = 10;
	/**
	 * Número por el cual se divide la destreza del personaje 
	 * para calcular la posibilidad de evitar el daño.
	 */
	private static final int DIVISORDEDESTREZA = 1000;
	/**
	 * Posición inicial del Personaje en X.
	 */
	private static final int POSXI = 0;
	/**
	 * Posición inicial del personaje en Y.
	 */
	private static final int POSYI = 0;
	/**
	 * Ataque del personaje.
	 */
	private int ataque;
	/**
	 * Magia del personaje.
	 */
	private int magia;
	/**
	 * Nombre de la Raza del Personaje.
	 */
	private String nombreRaza;
	/**
	 * Salud tope del Personaje.
	 */
	private int saludTope;
	/**
	 * Energía tope del Personaje.
	 */
	private int energiaTope;
	/**
	 * Destreza del Personaje.
	 */
	private int destreza;
	/**
	 * Inteligencia del Personaje.
	 */
	private int inteligencia;
	/**
	 * Casta del Personaje.
	 */
	private Casta casta;
	/**
	 * Experiencia del Personaje.
	 */
	private int experiencia;
	/**
	 * Identificador del Personaje.
	 */
	private int idPersonaje;
	/**
	 * Alianza del Personaje.
	 */
	private Alianza clan = null;
	/**
	 * Variable estática que contiene los niveles de personaje.
	 */
	private static int[] tablaDeNiveles;	
	/**
	 * Multiplicador para daddys
	 */
	private double multiDaddy = 1;
	
	/**
	 * Dice si esta en modo dios o no, activado por el
	 * truco godMode.
	 */
	private boolean god = false;
	
	
	/**
	 * Crea un personaje con valores por defecto, minimos. 
	 * La clase Personaje es la cual posee todos los atributos.
	 * Algunos serán completados por las clases hijo (Elfo,Humano,Orco)
	 * como por ejemplo el array habilidadesRaza[].
	 * Dependiendo de qué instancia es el parámetro casta,
	 * se incrementará en 5 un atributo del personaje
	 * @param nombre Indica el nombre el personaje
	 * @param casta Indica la casta(Raza) del personaje
	 * y con ella el incremento que tendrá cierto atributo
	 * @param id Identificador del personaje
	 */
	public Personaje(final String nombre, final Casta casta, final int id) {
		super(FUERZAINICIAL, DEFENSAINICIAL, NIVELINICIAL, nombre,POSXI,POSYI);


		this.casta = casta;
		this.idPersonaje = id;
		experiencia = EXPERIENCIAINICIAL;
		inteligencia = INTELIGENCIANICIAL;
		destreza = DESTREZAINICIAL;
		saludTope = SALUDTOPEINICIAL;
		energiaTope = ENERGIATOPEINICIAL;
		aumentarEnergiaTope(getEnergiaBonus());
		aumentarSaludTope(getSaludBonus());
		aumentarDestreza(casta.recibirDestrezaBonus());
		aumentarFuerza(casta.recibirFuerzaBonus());
		aumentarInteligencia(casta.recibirInteligenciaBonus());
		nombreRaza = getNombreRaza();
		salud = saludTope;
		energia = energiaTope;
		ataque = this.calcularPuntosDeAtaque();
		magia = this.calcularPuntosDeMagia();
		this.aumentarDefensa(destreza);
	}
	
	/** La clase Personaje es la cual posee todos los atributos de los personajes del juego.
	 * Setea todos los parametros.
	 * Algunos serán completados por las clases hijo (Elfo,Humano,Orco) como por ejemplo:
	 * El array habilidadesRaza[], a diferencia del constructor de sólo 3 parámetros,
	 * éste recibe la mayoría de los atributos.
	 * @param nombre Nombre del personaje
	 * @param salud Salud del personaje
	 * @param energia Energía del personaje
	 * @param fuerza Fuerza del Personaje
	 * @param destreza Destreza del personaje
	 * @param inteligencia Inteligencia del personaje
	 * @param casta Casta(Raza) del personaje
	 * @param experiencia Experiencia del personaje
	 * @param nivel Nivel del personaje
	 * @param idPersonaje Id del personaje
	 */
	public Personaje(final String nombre, final int salud, final int energia, final int fuerza,
			final int destreza, final int inteligencia, final Casta casta,
			final int experiencia, final int nivel,
			final int idPersonaje) {
		super(fuerza, 0, nivel, nombre,POSXI,POSYI);

		this.salud = salud;
		this.energia = energia;

		this.destreza = destreza;
		this.aumentarDefensa(destreza);
		this.inteligencia = inteligencia;
		this.casta = casta;

		this.experiencia = experiencia;

		this.saludTope = this.salud;
		this.energiaTope = this.energia;

		this.idPersonaje = idPersonaje;

		this.ataque = this.calcularPuntosDeAtaque();
		this.magia = this.calcularPuntosDeMagia();
		
	}

	/**
	 * Retorna las habilidades que posee el personaje 
	 * segun la casta del mismo.
	 * @return String[] de habilidades de la casta.
	 */

	public final String[] getHabilidadesCasta() {
		return casta.getHabilidadesCasta();
	}
	/**
	 * Carga la tabla de niveles de personaje.
	 */
	public static void cargarTablaNivel() {
		Personaje.setTablaDeNiveles(new int[CANTIDADNIVELES]);
		Personaje.getTablaDeNiveles()[0] = 0;
		Personaje.getTablaDeNiveles()[1] = 0;
		for (int i = 2; i < CANTIDADNIVELES; i++) {
			Personaje.getTablaDeNiveles()[i] = Personaje.getTablaDeNiveles()[i - 1] + CONSTANTENIVEL;
		}
	}

	/**Retorna un entero con el ataque del personaje.
	 * @return ataque del personaje.
	 */

	@Override
	public final int getAtaque() {
		return ataque;
	}
	
	/**Obsoleto?
	 * Sobreescribe el atributo de ataque
	 * con el parámetro enviado.
	 * @param ataque nuevo valor del ataque del personaje.
	 */
	@Override
	public final void setAtaque(final int ataque) {
		this.ataque = ataque;
	}

	/**Retorna la magia del personaje.
	 * @return Magia del personaje.
	 */

	@Override
	public final int getMagia() {
		return magia;
	}

	/**Sobreescribe el atributo magia.
	 * con el valor recibido por parámetro.
	 * @param magia Nuevo valor de magia del personaje.
	 */
	public final void setMagia(final int magia) {
		this.magia = magia;
	}
	/**Retorna un String con la alianza del personaje.
	 * @return Alianza del personaje.
	 */
	public final Alianza getClan() {
		return clan;
	}
	/**Sobreescribe el atributo clan.
	 * Añade al personaje llamador al clan enviado
	 * como parámetro.
	 * @param clan nuevo clan al que pertenecera el personaje.
	 */
	public final void setClan(final Alianza clan) {
		this.clan = clan;
		clan.añadirPersonaje(this);
	}
	/**Retorna entero con la salud del personaje.
	 * @return Salud del personaje
	 */
	@Override
	public final int getSalud() {
		return salud;
	}

	/**Retorna entero con la energia del personaje.
	 * @return Energía del personaje
	 */
	public final int getEnergia() {
		return energia;
	}

	/**Retorna un entero con la destreza del personaje.
	 * @return Destreza del personaje
	 */
	public final int getDestreza() {
		return destreza;
	}


	/** Retorna un entero con la inteligencia del personaje.
	 * @return Inteligencia del personaje.
	 */
	public final int getInteligencia() {
		return inteligencia;
	}

	/**Retorna una Casta con la casta del personaje.
	 * @return Casta del personaje.
	 */
	public final Casta getCasta() {
		return casta;
	}

	/**Retorna un entero con la experiencia del personaje.
	 * @return Experiencia del personaje.
	 */
	public final int getExperiencia() {
		return experiencia;
	}

	/** Retorna un entero con el Id del personaje.
	 * @return Identificación del personaje.
	 */
	public final int getIdPersonaje() {
		return idPersonaje;
	}

	/**Retorna un entero con el valor máximo de 
	 * salud que puede tener el personaje.
	 * @return saludTope del personaje.
	 */
	public final int getSaludTope() {
		return saludTope;
	}

	/**Retorna un entero con la energía máxima que puede
	 * tener el personaje.
	 * @return Energía máxima del personaje.
	 * */
	public final int getEnergiaTope() {
		return energiaTope;
	}
	/**
	 * Efectua un ataque sobre el Personaje o NPC recibido por parámetro,
	 * la potencia del mismo depende del resultado de las comparaciones entre
	 * el Personaje llamador y el Peleable atacado (Personaje o NPC)
	 * La probabilidad de golpe crítico depende de la casta del Personaje
	 * y de la destreza del mismo. Si la probabilidad junto con la
	 * destreza es mayor o igual al número generado de manera aleatoria
	 * entonces se atacará con golpe crítico, de lo contrario
	 * sera atacado con el valor del atributo ataque.
	 * @param atacado Instancia de Persona o NPC la cual será atacada.
	 * @return Retorna el daño efectivo que se le aplico a la salud del atacado
	 * en caso de no efectuarse daño retorna 0, implicitamente devuelve
	 * si el ataque fue realizado con éxito o no.
	 */
	@Override
	public final int atacar(final Peleable atacado) {
		if (salud == 0) {
			return 0;
		}
		if (atacado.getSalud() > 0 && (this.god || !atacado.isDios())) {

			if (this.getRandom().nextDouble() <= this.casta.getProbabilidadGolpeCritico()
					+ this.destreza / DIVISORDEDESTREZA) {
				return atacado.serAtacado(this.golpe_critico(), this);
			} else {
				return atacado.serAtacado(this.ataque, this);
			}
		}
		return 0;
	}

	/** Retorna un entero que representa el golpe crítico 
	 * que puede realizar el personaje.
	 * Este depende de a que casta pertenece el
	 * personaje y que ataque posee. El daño crítico se
	 * obtiene de la clase casta.
	 * Se obtiene de la multiplicación del ataque del personaje y
	 * el daño crítico de la casta a la que pertenece.
	 * @return golpe critico que puede realizar el personaje.
	 */
	public final int golpe_critico() {
		return (int) (this.ataque * this.getCasta().getDañoCritico());
	}
	/**
	 * Metodo no implementado.
	 */
	@Override
	public void despuesDeTurno() {

	}
	/** Devuelve si el personaje puede atacar segun su energía actual:
	 * 	true si el personaje puede atacar, 
	 * 	y falso en caso que no pueda.
	 * @return Si el personaje puede o no atacar.
	 */
	public final boolean puedeAtacar() {
		return energia > ENERGIAMINIMA;
	}

	/** Retorna un entero que representa los puntos de ataque efectivos del personaje para un combate. 
	 * Estos puntos dependen de la fuerza del personaje, MULTIPLICADORFZA y el multiplicador afectado
	 * por bigdaddy y tinydaddy.
	 * @return Los puntos de ataque del personaje.
	 */
	public final int calcularPuntosDeAtaque() {
		return (int) (this.getFuerza() * this.multiDaddy * MULTIPLICADORFZA);
	}
	
	/**Retorna un entero con los puntos de defensa.
	 * Estos puntos son iguales a los puntos de destreza
	 * del personaje.
	 * @return Los puntos de destreza del personaje.
	 */
	public final int calcularPuntosDeDefensa() {
		return (this.getDestreza());
	}

	/**Retorna un entero con los puntos de magia
	 * del personaje. Estos puntos dependen de la multiplicación
	 * de la inteligencia del personaje y MULTIPLICADORMGA.
	 * @return Puntos de magia del personaje.
	 */
	public final int calcularPuntosDeMagia() {
		return (int) (this.getInteligencia() * MULTIPLICADORMGA);
	}

	/** Restablece la salud actual del personaje
	 *  a la máxima posible que puede tener.
	 */
	public final void restablecerSalud() {
		this.salud = this.saludTope;
	}
	/** Restablece la energía del personaje
	 *  a la máxima posible que puede tener.
	 */
	public final void restablecerEnergia() {
		this.energia = this.energiaTope;
	}
	/** Modifica los atributos de ataque,
	 * defensa y magia del personaje.
	 * Ataque depende de la fuerza del personaje y
	 * de MULTIPLICADORFZA(constante).
	 * Defensa depende de la destreza.
	 * Magia depende de la inteligencia y de MULTIPLICADORMGA (constante).
	 */
	public final void modificarAtributos() {
		this.ataque = this.calcularPuntosDeAtaque();
		this.aumentarDefensa(destreza);
		this.magia = this.calcularPuntosDeMagia();
	}

	/** Devuelve si el personaje esta vivo o no.
	 * Si la salud del personaje es mayor a 0 este está vivo.
	 * @return Retorna true si el personaje esta vivo 
	 * o false en caso contrario.
	 */
	@Override
	public final boolean estaVivo() {
		return salud > 0;
	}
	/** Aplica sobre el personaje el efecto de un ataque,
	 * resta de la salud el daño efectivo que se realiza sobre el llamador,
	 * dependiendo de que tan efectiva sea su defensa.
	 * Dependiendo del resultado de las comparaciones, 
	 * si el número generado con la clase MyRandom es mayor
	 * a la probabilidad de evitar daño,
     * La cual depende de la casta del Personaje, entonces no podrá
	 * evitarse el ataque, se descontará el valor del argumento
	 * daño al atributo salud.
	 * Si el valor del atributo salud es menor al valor
	 * del argumento daño, se procederá a igualar el
	 * atributo salud a 0 y retornar el daño realizado
	 * (que será igual a la salud antes de que esté en 0).
	 * @param danio valor a descontarse del atributo salud
	 * @return Retorna el daño efectivo que se le aplico a la salud del personaje
	 * en caso de no efectuarse daño retorna 0, implicitamente devuelve
	 * si el ataque fue realizado con éxito o no.
	 */
	@Override
	public final int serAtacado(int danio, Peleable atacante) {
		System.out.println("Yo soy dios " + this.god + " y el otro es dios " + atacante.isDios());
		if(!this.god || atacante.isDios()) {
			System.out.println("Me quiere atacar");
			if (this.getRandom().nextDouble() >= this.getCasta().getProbabilidadEvitarDaño()) {
				danio -= this.getDefensa();
				if (danio > 0) {
					if (salud <= danio) {
						danio = salud;
						salud = 0;
					} else {
						salud -= danio;
					}
					return danio;
				}
				return 0;
			}
		}
		else System.out.println("Soy un " + this.nombreRaza + " y un dios " + atacante.isDios() + " y safe");
		return 0;
	}

	/**Efectua un cierto daño sobre los puntos de salud
	 * del personaje teniendo en cuenta la defensa del mismo.
	 * @param danio Daño aplicado sobre al personaje.
	 * @return Retorna los puntos de vida quitados al personaje.
	 */
	public final int serRobadoSalud(int danio) {
		danio -= this.getDefensa();
		if (danio <= 0) {
			return 0;
		}
		if ((salud - danio) >= 0) {
			salud -= danio;
		} else {
			danio = salud;
			salud = 0;
		}
		return danio;
	}
	/**Al ejercer un cierto daño sobre el personaje llamador,
	 * teniendo en cuenta la defensa del mismo, se realiza un decremento
	 * sobre la energia del mismo.
	 * @param danio Daño causado al personaje
	 * @return Retorna los puntos de energía quitados al personaje.
	 */
	public final int serDesernegizado(int danio) {
		danio -= this.getDefensa();
		if (danio <= 0) {
			return 0;
		}
		if ((energia - danio) >= 0) {
			energia -= danio;
		} else {
			danio = energia;
			energia = 0;
		}
		return danio;
	}
	/** Aumenta la salud actual del personaje.
	 * Si este aumento es mayor al tope, establece como salud
	 * actual la máxima que puede tener el personaje.
	 * @param salud Puntos de salud a sumar al personaje.
	 */
	public final void serCurado(final int salud) {
		if ((this.salud + salud) <= this.saludTope) {
			this.salud += salud;
		} else {
			this.salud = this.saludTope;
		}
	}
	/**Aumenta la energía actual del personaje.
	 * Si este aumento es mayor al tope entonces establece como 
	 * energía actual la maxima que puede tener el personaje.
	 * @param energia Puntos de energia a sumar al Personaje.
	 */
	public final void serEnergizado(final int energia) {
		if ((this.energia + energia) <= this.energiaTope) {
			this.energia += energia;
		} else {
			this.energia = this.energiaTope;
		}
	}
	/**Crea una nueva alianza. Asigna a ésta
	 * al clan actual del personaje y lo añade a la lista de
	 * Personajes que integran la alianza.
	 * @param nombreAlianza Nombre de la alianza
	 */
	public final void crearAlianza(final String nombreAlianza) {
		this.clan = new Alianza(nombreAlianza);
		this.clan.añadirPersonaje(this);
	}
	/**Desvincula al personaje llamador de la alianza
	 * y establece que el personaje no pertenece a ninguna.
	 */
	public final void salirDeAlianza() {
		if (this.clan != null) {
			this.clan.eliminarPersonaje(this);
			this.clan = null;
		}
	}
	/** Añade al personaje recibido por parámetro a la alianza del llamador
	 * Retorna un booleano si pudo añadir un nuevo
	 * aliado a la alianza en la que se encuentra el personaje.
	 * Si el personaje llamador no pertenece a ninguna alianza
	 * se crea una con el nombre "Alianza 1" por defecto.
	 * Luego se agrega al nuevo aliado enviado como parametro
	 * a la alianza del personaje llamador.
	 * @param nuevoAliado Personaje que se añadira al clan del llamador
	 * @return	true si pudo agregar al nuevo aliado, y false en caso contrario.
	 */
	public final boolean aliar(final Personaje nuevoAliado) {
		if (this.clan == null) {
			Alianza a = new Alianza("Alianza 1");
			this.clan = a;
			a.añadirPersonaje(this);
		}

		if (nuevoAliado.clan == null) {
			nuevoAliado.clan = this.clan;
			this.clan.añadirPersonaje(nuevoAliado);
			return true;
		} else {
			return false;
		}
	}
	/**Aumenta los puntos de fuerza, destreza e inteligencia del personaje
	 * con los valores recibidos por parámetro.
	 * Nunca estos atributos superan los máximos.
	 * Una vez modificados los atributos mencionados actualiza
	 * los nuevos puntos de ataque, defensa y magia del personaje.
	 * @param fuerza incremento a aplicar sobre la fuerza del personaje
	 * @param destreza incremento a aplicar sobre la destreza del personaje
	 * @param inteligencia incremento a aplicar sobre la inteligencia del personaje
	 */
	public final void AsignarPuntosSkills(final int fuerza, final int destreza, final int inteligencia) {
		if (this.getFuerza() + fuerza <= FUERZAMAXIMA) {
			this.aumentarFuerza(fuerza);
		}
		if (this.destreza + destreza <= DEFENSAMAXIMA) {
			this.destreza += destreza;
		}
		if (this.inteligencia + inteligencia <= INTELIGENCIAMAXIMA) {
			this.inteligencia += inteligencia;
		}
		this.modificarAtributos();
	}

	/** Aumenta el nivel del personaje
	 * Si ya se encuentra en el nivel máximo no realiza cambios.
	 * En caso contrario se actualizara la salud tope,
	 * la energía tope y el nivel del personaje hasta que su experiencia
	 * sea menor a la de un nivel preestablecido. Luego se le descuenta
	 * al atributo experiencia la experiencia que se utilizo para aumentar
	 * el nivel del personaje.
	 */
	public final void subirNivel() {

		int acumuladorExperiencia = 0;
		if (this.getNivel() == NIVELMAXIMO) {
			return;
		}
		while (this.getNivel() != NIVELMAXIMO
				&& (this.experiencia >= Personaje.
				getTablaDeNiveles()[this.getNivel() + 1] + acumuladorExperiencia)) {
			acumuladorExperiencia += Personaje.getTablaDeNiveles()[this.getNivel() + 1];
			this.aumentarNivel();
			this.modificarAtributos();
			this.saludTope += SALUDTOPESUBIRN;
			this.energiaTope += ENERGIATOPESUBIRN;
		}
		this.experiencia -= acumuladorExperiencia;
	}
	/**Incrementa la experiencia del personaje llamador
	 *,y si tiene experiencia suficiente incrementa el nivel del personaje.
	 * @param exp Incremento que se aplicara sobre 
	 * la experiencia del personaje.
	 * @return retorna true si el personaje aumento de nivel 
	 * y false en caso contrario.
	 */
	public final boolean ganarExperiencia(final int exp) {
		this.experiencia += exp;

		if (experiencia >= Personaje.getTablaDeNiveles()[this.getNivel() + 1]) {
			subirNivel();
			return true;
		}
		return false;
	}
	/** Retorna un entero con la experiencia
	 * equivalente del personaje que depende del nivel
	 * del mismo y de MULTIPLICADOREXP.
	 * MULTIPLICADOREXP atributo estático de la clase
	 * personaje.
	 * @return retorna la experiencia brindada por el Personaje.
	 */
	@Override
	public final int otorgarExp() {
		return this.getNivel() * MULTIPLICADOREXP;
	}

	/**Retorna un Objeto utilizado para clonar a un personaje.
	 * @throws CloneNotSupportedException Excepción de 
	 * clonación cuando no está implementada.
	 * @return Retorna un Objeto con los atributos del
	 * personaje llamador.
	 */
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	/**Retorna un double con la distancia radial
	 * entre el personaje llamador y el personaje 
	 * recibido por parametro.
	 * @param p Personaje al cual se calcular la distancia.
	 * @return La distancia entre los dos Personajes.
	 */
	public final double distanciaCon(final Personaje p) {
		return Math.sqrt(Math.pow(this.getPosicionX() - p.getPosicionX(), 2) + Math.pow(this.getPosicionY() - p.getPosicionY(), 2));
	}
	/**Intenta aplicar la habilidad 1 del personaje llamador
	 * sobre el personaje recibido por parámetro. 
	 * Esta habilidad depende de la casta a la que pertenece
	 * el personaje (Asesino, Guerrero o Hechicero).
	 * La energía del personaje debe
	 * ser mayor a la mínima para lograr la habilidad.
	 * @param atacado Es el personaje sobre el cual aplicará
	 * la habilidad el personaje llamador.
	 * @return Boolean si pudo o no realizar la habilidad 1 de la casta.
	 */
	public final boolean habilidadCasta1(final Peleable atacado) {
		return this.getCasta().habilidad1(this, atacado);
	}

	/**Intenta aplicar la habilidad 2 del personaje llamador
	 * sobre el personaje recibido por parámetro. 
	 * Esta habilidad depende de la casta a la que pertenece
	 * el personaje (Asesino, Guerrero o Hechicero).
	 * La energía del personaje debe
	 * ser mayor a la mínima para lograr la habilidad.
	 * @param atacado Es el personaje sobre el cual aplicará
	 * la habilidad el personaje llamador.
	 * @return Boolean si pudo o no realizar la habilidad 2 de la casta.
	 */
	public final boolean habilidadCasta2(final Peleable atacado) {
		return this.getCasta().habilidad2(this, atacado);
	}
	/**Intenta aplicar la habilidad 3 del personaje llamador
	 * sobre el personaje recibido por parámetro. 
	 * Esta habilidad depende de la casta a la que pertenece
	 * el personaje (Asesino, Guerrero o Hechicero).
	 * La energía del personaje debe
	 * ser mayor a la mínima para lograr la habilidad.
	 * @param atacado Es el personaje sobre el cual aplicará
	 * la habilidad el personaje llamador.
	 * @return Boolean si pudo o no realizar la habilidad 3 de la casta.
	 */
	public final boolean habilidadCasta3(final Peleable atacado) {
		return this.getCasta().habilidad3(this, atacado);
	}

	/**Intenta aplicar la habilidad 1 de la raza a la que 
	 * pertenece el personaje llamador (Humano, Orco o Elfo) 
	 * sobre el personaje recibido por parámetro.
	 * La energia del personaje debe ser mayor a la minima para
	 * lograr la habilidad, independientemente de la raza que sea.
	 * @param atacado Es el personaje sobre el cual se aplicara
	 * la habilidad del personaje llamador.
	 * @return Boolean si pudo o no realizar la habilidad 1 de la Raza.
	 */
	public abstract boolean habilidadRaza1(Peleable atacado);
	/**Intenta aplicar la habilidad 2 de la raza a la que 
	 * pertenece el personaje llamador (Humano, Orco o Elfo) 
	 * sobre el personaje recibido por parámetro.
	 * La energía del personaje debe ser mayor a la mínima para
	 * lograr la habilidad, independientemente de la raza que sea.
	 * @param atacado Es el personaje sobre el cual se aplicara
	 * la habilidad del personaje llamador.
	 * @return Boolean si pudo o no realizar la habilidad 2 de la Raza.
	 */
	public abstract boolean habilidadRaza2(Peleable atacado);
	/** Retorna un vector String con los nombres
	 * de las habilidades de la raza.
	 * Depende de la raza que sea el personaje
	 * llamador, Humano, Orco o Elfo.
	 * @return Un array de Strings con los nombres de las habilidades.
	 */
	public abstract String[] getHabilidadesRaza();
	/**Retorna un entero con el bonus de salud.
	 * Depende de la raza que sea el personaje llamador
	 * Humano, Orco o Elfo.
	 * @return Retorna el entero con el bonus de salud.
	 */
	public abstract int getSaludBonus();
	/**Retorna un entero con el bonus de enería.
	 * Depende de la raza que sea el personaje llamador,
	 * Humano, Orco o Elfo.
	 * @return Retorna el entero con el bonus de energía.
	 */
	public abstract int getEnergiaBonus();
	/**Retorna un String con el nombre de la raza a la que 
	 * pertenece el personaje llamador (Humano, Orco o Elfo).
	 * @return Retorna el String con el nombre de la Raza del personaje.
	 */
	public abstract String getNombreRaza();
	/**
	 * Aumenta la inteligencia del personaje según
	 * el bonus recibido por parámetro.
	 * @param bonus Cantidad a sumar a inteligencia.
	 */
	public final void aumentarInteligencia(final int bonus) {
		inteligencia += bonus;
	}
	/**
	 * Aumenta la destreza del personaje según
	 * el bonus recibido por parámetro.
	 * @param bonus Cantidad a sumar a Destreza.
	 */
	public final void aumentarDestreza(final int bonus) {
		destreza += bonus;
	}
	/**
	 * Aumenta la saludTope del personaje segun
	 * el bonus recibido por parámetro.
	 * @param bonus Cantidad a sumar a saludTope.
	 */
	public final void aumentarSaludTope(final int bonus) {
		saludTope += bonus;
	}
	/**
	 * Aumenta la energiaTope del personaje segun
	 * el bonus recibido por parámetro.
	 * @param bonus Cantidad a sumar a energiaTope.
	 */
	public final void aumentarEnergiaTope(final int bonus) {
		energiaTope += bonus;
	}
	/**
	 * Devuelve la tabla de niveles.
	 * @return	Devuelve la tabla de niveles
	 */
	public static final  int[] getTablaDeNiveles() {
		return tablaDeNiveles;
	}
	/**
	 * Reemplaza a la tabla de niveles por la que se recibe por parámetro.
	 * @param tablaDeNiveles tabla de niveles que reemplazará a la anterior.
	 */
	private static void setTablaDeNiveles(final int[] tablaDeNiveles) {
		Personaje.tablaDeNiveles = tablaDeNiveles;
	}
	/**
	 * Aumenta la energía del Personaje llamador.
	 * @param bonus	monto entero que será agregado a la energía
	 */
	public final void aumentarEnergia(final int bonus) {
		energia += bonus;
	}
	/**
	 * Reduce la energía del Personaje llamador.
	 * @param monto	monto entero que será reducido a la energía.
	 */
	public final void reducirEnergia(final int monto) {
		if (energia > monto) {
			energia -= monto;
		} else {
			energia = 0;
		}

	}

	/**
	 * Reduce la salud del Personaje llamador.
	 * @param reduc	monto entero que será reducido a la salud.
	 */
	public final void reducirSalud(final int reduc) {
		salud -= reduc;
	}
	/**
	 * Aumenta la salud del Personaje llamador.
	 * @param bonus	monto entero que será agregado a la salud.
	 */
	public final void aumentarSalud(final int bonus) {
		salud += bonus;
	}

	/**
	 * Actualiza la salud y la energía del personaje en batalla.
	 * @param map contenedor de los atributos a actualizar.
	 */
	public final void actualizarAtributos(final HashMap<String, Number> map) {
		salud = map.get("salud").intValue();
		energia = map.get("energia").intValue();
		defensa = map.get("defensa").intValue();
		casta.setProbabilidadEvitarDaño(map.get("probEvitarDanio").doubleValue());
	}
	/**
	 * Realiza el trueque de items.
	 * @param misItems Items que posee el personaje actualmente.
	 * @param aPoner items a recibir.
	 * @param aSacar items a eliminar.
	 */
	public void trueque(final ArrayList<Item> misItems,
			final ArrayList<Item> aPoner, final DefaultListModel<String> aSacar) {
		int j = 0;
		boolean loop = true;
		ArrayList<Item> aux = misItems;
		while (aSacar.size() > 0) {
			while (loop) {
				if (misItems.get(j).getNombre().equals(aSacar.get(0))) {
					aSacar.remove(0);
					aux.remove(misItems.get(j));
					loop = false;
				}
				j++;
			}
			j = 0;
			loop = true;
		}
		for (Item item : aPoner) {
			aux.add(item);
		}
		this.items = aux;
	}
	
	/**
	 * @return the multiDaddy
	 */
	public double getMultiDaddy() {
		return this.multiDaddy;
	}
	
	/**
	 * @param multiDaddy the multiDaddy to set
	 */
	public void setMultiDaddy(double multiDaddy) {
		this.multiDaddy = multiDaddy;
	}
	
	/**
	 * @return God or Not
	 */
	public boolean isDios() {
		return this.god;
	}
	
	/**
	 * @param god the god to set
	 */
	public void setGod(boolean god) {
		this.god = god;
	}
}

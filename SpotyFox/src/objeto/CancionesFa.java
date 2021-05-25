package objeto;

public class CancionesFa {

	//Se crean los atributos del objeto CancionesFa de tipo String
	//Estos atributos van dirijidos a la lista simple
	private String caratula, nombre, artista, cancion;
	private String tiempo;

	//Constructor que inicializamos el valor de las variables
	public CancionesFa(String caratula, String nombre, String artista, String cancion, String tiempo) {
			super();
			this.caratula = caratula;
			this.nombre = nombre;
			this.artista = artista;
			this.cancion = cancion;
			this.tiempo = tiempo;
		}

	//Métodos get y set para los atributos
	public String getCaratula() {
		return caratula;
	}

	public void setCaratula(String caratula) {
		this.caratula = caratula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getArtista() {
		return artista;
	}

	public void setArtista(String artista) {
		this.artista = artista;
	}

	public String getCancion() {
		return cancion;
	}

	public void setCancion(String cancion) {
		this.cancion = cancion;
	}

	public String getTiempo() {
		return tiempo;
	}

	public void setTiempo(String tiempo) {
		this.tiempo = tiempo;
	}

	
	
}


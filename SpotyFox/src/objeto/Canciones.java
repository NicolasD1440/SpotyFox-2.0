package objeto;

public class Canciones {
	
		
	private String caratula, nombre, artista;

	public Canciones(String caratula, String nombre, String artista) {
			super();
			this.caratula = caratula;
			this.nombre = nombre;
			this.artista = artista;
		}

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

}

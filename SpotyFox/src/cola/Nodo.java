package cola;


import objeto.CancionesFa;

public class Nodo {

	private CancionesFa informacion;//Aqui se cambia por el objeto
	private Nodo referencia;// Variable para enlazar los nodos.

	//Respectivos get y set de los atributos
	public CancionesFa getInformacion() {
		return informacion;
	}
	public void setInformacion(CancionesFa informacion) {
		this.informacion = informacion;
	}
	public Nodo getReferencia() {
		return referencia;
	}
	public void setReferencia(Nodo referencia) {
		this.referencia = referencia;
	}
}

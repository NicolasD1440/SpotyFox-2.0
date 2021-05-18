package cola;


import objeto.CancionesFa;

public class Nodo1 {

	private CancionesFa informacion;//Aqui se cambia por el objeto
	private Nodo1 referencia;// Variable para enlazar los nodos.

	//Respectivos get y set de los atributos
	public CancionesFa getInformacion() {
		return informacion;
	}
	public void setInformacion(CancionesFa informacion) {
		this.informacion = informacion;
	}
	public Nodo1 getReferencia() {
		return referencia;
	}
	public void setReferencia(Nodo1 referencia) {
		this.referencia = referencia;
	}
}

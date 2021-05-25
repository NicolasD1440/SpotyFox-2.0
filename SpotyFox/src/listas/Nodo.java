package listas;

import objeto.Canciones;

public class Nodo {

	private Canciones informacion;//Aqui se cambia por el objeto
	// Variables para enlazar los nodos hacia delante y hacia atras.
	private Nodo anterior;
	private Nodo siguiente;
	
	//Respectivos get y set de los atributos
	public Canciones getInformacion() {
		return informacion;
	}
	public void setInformacion(Canciones informacion) {
		this.informacion = informacion;
	}
	public Nodo getAnterior() {
		return anterior;
	}
	public void setAnterior(Nodo anterior) {
		this.anterior = anterior;
	}
	public Nodo getSiguiente() {
		return siguiente;
	}
	public void setSiguiente(Nodo siguiente) {
		this.siguiente = siguiente;
	}


	
}

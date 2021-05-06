package listas;

import objeto.Canciones;

public class Nodo {

	private Canciones informacion;
	private Nodo anterior;
	private Nodo siguiente;
	
	
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

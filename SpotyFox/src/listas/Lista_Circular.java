package listas;

import objeto.Canciones;

public class Lista_Circular {

	private Nodo last;
	private Nodo first;
	private int size;
	
	//Constructor
	public Lista_Circular() {
		last = null;
		first = null;
	}
		
	//Metodos 
	public int getSize() {
		return this.size;
	}
	
	public boolean isEmty() {
		return this.last == null && this.first == null;
	}
	
	//Agregar elementos
	public void addElement (Canciones valor) {
		Nodo nodo = new Nodo();
		nodo.setInformacion(valor);
		if (first == null) {
			first = nodo;
			last = first;
		}else {
			Nodo temp = last;
			last = nodo;
			last.setAnterior(temp);
			temp.setSiguiente(nodo);
			last.setSiguiente(first);
			first.setAnterior(last);
		}
		
	}

	public Nodo first () {
		return first;
	}
}

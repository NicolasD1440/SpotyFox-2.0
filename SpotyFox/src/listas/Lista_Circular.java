package listas;

import objeto.Canciones;

public class Lista_Circular {

	//Elementos de la lista
	private Nodo first;//Nodo de acceso
	private Nodo last;
	private int size;//Tamaño de la lista
	
	//Constructor
	public Lista_Circular() {
		last = null;
		first = null;
	}
		
	//Obtener tamaño
	public int getSize() {
		return this.size;
	}
	
	//Este metodo se encarga de verificar si la Lista Circular esta Vacia
	public boolean isEmty() {
		return this.last == null && this.first == null;
	}
	
	//Agregar elementos
	public void addElement (Canciones valor) {
		Nodo nodo = new Nodo();
		//Se instancia la clase nodo para permitir la interación entre las dos clases
		nodo.setInformacion(valor);
		//Seteamos los valores que seran asignados a las variables de instancia
		if (first == null) {
			first = nodo;
			last = first;
		//Este condicional if es para que consulte si el nodo de acceso es igual a nulo, 
		//si es así entonces inicializa la lista agregando como inicio al nuevo nodo y el puntero ultimo apuntara al primer elemento	
		}else {
		//Si no se cumple la anterior condición se crea un nodo temporal para que el puntero del ultimo sea el nuevo nodo 
			Nodo temp = last;
			last = nodo;
		//Se apunta con el ultimo nodo a la lista temporal y este temporal lo apunta al ultimo nodo de la lista. 		
			last.setAnterior(temp);
			temp.setSiguiente(nodo);
			last.setSiguiente(first);
			first.setAnterior(last);
	    //Se setea en la clase nodo SetSiguiente para el nodo ultimo de esta manera apunta del primero al último y SetAnterior para que apunte del ultimo al primero.		
		}
		
	}
	
	//Metodo encargado de dar acceso al nodo para ser utilizado
	//dentro de la interfaz
	public Nodo first () {
		return first;
	}
}

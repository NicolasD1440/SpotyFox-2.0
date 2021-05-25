package listasimple;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;


import objeto.CancionesFa;

public class Lista_Simple {
	
	private Nodo1 primero; //Acceder al primer nodo de la lista
	private int size;//Tamaño de la lista
	
	//Constructor
	public Lista_Simple() {
		this.primero = null;
		this.size = 0;
	}
	
	//Obtener tamaño
	public int getTamaño() {
		return size;
	}


	//Este metodo se encarga de verificar si la Lista Simple esta vacia
	public boolean isEmpty() {
		return this.primero == null;
	}
	
	//Metodo para agregar abajo
	public void addAbajo(CancionesFa v) {
		
		//Este condicional tiene como función verificar si la canción ya fue agregada si lo esta envia un mensaje por medio de un JOptionPane
		if(verificar(v)) {
			JOptionPane.showMessageDialog(null, "La cancion: " + v.getNombre() + " ya se encuentra en la lista");
		}
		else {
		//Si no ha sido agregada entonces se instancia la clase nodo para permitir la interación entre las dos clases
		Nodo1 nodo = new Nodo1();
		nodo.setInformacion(v);
		//Seteamos los valores que seran asignados a las variables de instancia
		nodo.setRef(null);
		if(isEmpty()) {
			//Aca se implementa otro condicional que se encarga de verificar si la lista esta vacia
			this.primero = nodo; 
			//Si lo esta entonces se agrega el primer elemento
		}else {
			//Si no lo esta entonces se implementa un condicional While
			Nodo1 aux = this.primero;
			//el cual recorre la lista hasta llegar al último nodo, agrega el nuevo elemento al final
			while(aux.getRef() != null) {
				aux = aux.getRef();
			}
			aux.setRef(nodo);
		}
		
		//Se incrementa el contador de la lista
		this.size++;
		//Y al agregar el elemento muestra un mensaje de que ya se agrego a la lista
		JOptionPane.showMessageDialog(null, "Agregada a favoritos");
	}
	}
	
	//Eliminar por valor
		public void eliminarValor(String v) {//se pide un valor de tipo String
			
			
			Nodo1 var = primero; //tenemos 2 variables de tipo nodo 
			Nodo1 ant = null;
						
			for(int i = 0; i < size; i++) { // este ciclo recorre la lista simple
				
				if(v.equals(var.getInformacion().getNombre())) { //si el valor que se pasa se encuentra en la lista
					
					ant.setRef(var.getRef());					// se reemplaza la referencia anterior por la siguiente
																//eliminando el nodo que coincide
															
				}
				else {
					
					ant = var;
					var = var.getRef();					//si no equivale sigue aumentando la posicion del nodo
				}
			}
			this.size--;

		}
		
		//Metodo para agregar elementos al Jlist
		public DefaultListModel<String> mostrarDatos() {
			
			Nodo1 auxi = primero;
			//Se intancia la conexión con el nodo
			DefaultListModel<String> listModel = new DefaultListModel<String>();
			//Se instancia la Lista para agregar los elementos ahi
			if(!isEmpty()) {
			//Se implementa un condicional que analiza si la lista no esta vacía
				for(int i = 0; i < size; i++) {
					//Si no lo esta entonces agrega el elemento con sus respetivos atributos a la lista
					listModel.addElement(auxi.getInformacion().getNombre());
					auxi = auxi.getRef();
				}
				//Retorna la lista con los elementos agregados
				return listModel;	
			}
			else {
				//Si esta vacia entonces retorna un mensaje diciendo que no hay elementos
				listModel.addElement("No hay canciones en favoritas");
				return listModel;
			}
			
		}
		
		//Metodo para eliminar el elemento seleccionado del Jlist 
		public DefaultListModel<String> eliminardato(JList<String> list) {
	    	DefaultListModel<String> modelo = (DefaultListModel<String>) list.getModel();
	    	//Se instancia la lista desde la cual se realizara el cambio requerido
	    	modelo.remove(list.getSelectedIndex());
	    	//En este caso se implementa el metodo remove para eliminar el elemento seleccionado en en Jlist
	    	return modelo;
	    	//Aqui se retorna el nuevo valor de la lista 
	    }
	
	  
	
	public String Buscar (String a) { // se pide un valor de tipo String (el nombre de la cancion)
		Nodo1 var = primero;

		for(int i = 0; i < size; i++) { // este ciclo es para recorrer la lista simple
			if(a.equals(var.getInformacion().getNombre())) { //si existe el nodo 
				return var.getInformacion().getCancion();	// nos retorna la direccion de la cancion
			}else {
				
				var = var.getRef(); //si no aumenta la posicion
			}
		}

		return "NO HAY CANCIONES";
	}
	
	public boolean verificar(CancionesFa v) { // se pide un valos tipo String
		  
		  Nodo1 var = primero;
		  boolean verif = false; //esta es la variable de retorno empieza en falso
			
			for (int i = 0; i < size; i++) { //este ciclo recorre la lista simple
		
				if(v.getNombre().equals(var.getInformacion().getNombre())) { // si el valor existe cambia el estado de
					verif = true;											// la variable de retorno a verdadero
				}else {
					var = var.getRef(); // si no aumenta la posicion
				}
			}
			return verif;
		  
	  }
	
	//Metodo encargado de dar acceso al nodo para ser utilizado
	//dentro de la interfaz
	public Nodo1 getPrimero() {
		return primero;
	}

}

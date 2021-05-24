package listasimple;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;


import objeto.CancionesFa;

public class Lista_Simple {
	
	
	private Nodo1 primero; //Acceder al primer nodo de la lista
	private int size;
	
	//Constructor
	public Lista_Simple() {
		this.primero = null;
		this.size = 0;
	}
	
	public Nodo1 getPrimero() {
		return primero;
	}

	public int getTamaño() {
		return size;
	}


	public void setTamaño(int tamaño) {
		size = tamaño;
	}


	public boolean isEmpty() {
		return this.primero == null;
	}
		
	public void addAbajo(CancionesFa v) {
		
		if(verificar(v)) {
			JOptionPane.showMessageDialog(null, "La cancion: " + v.getNombre() + " ya se encuentra en la lista");
		}
		else {
		
		Nodo1 nodo = new Nodo1();
		nodo.setInformacion(v);
		nodo.setRef(null);
		if(isEmpty()) {
			this.primero = nodo; 
		}else {
			Nodo1 aux = this.primero;
			while(aux.getRef() != null) {
				aux = aux.getRef();
			}
			aux.setRef(nodo);
		}
		this.size++;
		JOptionPane.showMessageDialog(null, "Agregada a favoritos");
	}
	}
	
	//Eliminar por valor
		public void eliminarValor(String v) {
			
			
			Nodo1 var = primero;
			Nodo1 ant = null;
						
			for(int i = 0; i < size; i++) {
				
				if(v.equals(var.getInformacion().getNombre())) {
					
					ant.setRef(var.getRef());
					
															
				}
				else {
					
					ant = var;
					var = var.getRef();
				}
			}
			this.size--;

		}
		
		public DefaultListModel<String> eliminardato(JList<String> list) {
	    	DefaultListModel<String> modelo = (DefaultListModel<String>) list.getModel();
	    	modelo.remove(list.getSelectedIndex());
	    	return modelo;
	    }
	
	public DefaultListModel<String> mostrarDatos() {
		
		Nodo1 auxi = primero;
		DefaultListModel<String> listModel = new DefaultListModel<String>();
		if(!isEmpty()) {
			for(int i = 0; i < size; i++) {
				listModel.addElement(auxi.getInformacion().getNombre());
				auxi = auxi.getRef();
			}
			return listModel;	
		}
		else {
			listModel.addElement("No hay canciones en favoritas");
			return listModel;
		}
		
	}
	
	public String Buscar (String a) {
		Nodo1 var = primero;

		for(int i = 0; i < size; i++) {
			if(a.equals(var.getInformacion().getNombre())) {
				return var.getInformacion().getCancion();
			}else {
				
				var = var.getRef();
			}
		}

		return "NO HAY CANCIONES";
	}
	
	public boolean verificar(CancionesFa v) {
		  
		  Nodo1 var = primero;
		  boolean verif = false;
			
			for (int i = 0; i < size; i++) {
		
				if(v.getNombre().equals(var.getInformacion().getNombre())) {
					verif = true;
				}else {
					var = var.getRef();
				}
			}
			return verif;
		  
	  }
	

}

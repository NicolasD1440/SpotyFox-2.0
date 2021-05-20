package cola;

import java.awt.List;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import objeto.CancionesFa;

public class ColaSimple {

	 //Elementos de la cola
	private Nodo1 primero; //El acceso al nodo
	private Nodo1 ultimo; 
	private int tam;//Tamaño de la lista
	
	//constructor
	public ColaSimple() {
		this.primero = null;//Se inicializan los dos punteros en null
		this.ultimo = null;
		this.tam = 0;//Se inicializa el tamaño en cero
		
	}
	
	//Este metodo se encarga de verificar si la cola esta Vacia
	public boolean ColaVacia() {
		return this.primero == null && this.ultimo == null;
		 
	}
	
	//Metodo para encolar al inicio o al final
	public void encolar(CancionesFa v) {
		
		if(verificar(v)) {
			JOptionPane.showMessageDialog(null, "La cancion: " + v.getNombre() + " ya se encuentra en la lista");
		}
		else {
		
		Nodo1 nodo = new Nodo1();
		//Se instancia la clase nodo para permitir la interación entre las dos clases
		nodo.setInformacion(v);
		//Seteamos los valores que seran asignados a las variables de instancia
		if(ColaVacia()){ //Verifica que la cola este vacia
			this.primero = nodo;
			//Si la cola esta vacia se agrega el elemento al Inicio
		}else {
					
			this.ultimo.setReferencia(nodo);
			//Si la cola cuenta con un elemento entonces se agrega al final
		}
		this.ultimo = nodo;
		//Se usa el this para asignar el nuevo valor al nodo
		this.tam++;
		//Aqui se usa el this para asignar el nuevo tamaño
		JOptionPane.showMessageDialog(null, "Agregada a favoritos");
		}
	}
	
	//Metodo para que se encarga de obtener el tamaño
	public int getTam() {
		return this.tam;
	}
	//Este método es el encargado de guardar los datos ingresados desde la interfaz y mostrarlos en la lista;
	public DefaultListModel<String> mostrarDatos(){
		
		Nodo1 aux = primero;
		DefaultListModel<String> listModel = new DefaultListModel<String>();
		if(!ColaVacia()) {
			for(int i = 0; i < tam; i++) {
				listModel.addElement(aux.getInformacion().getNombre());
				aux = aux.getReferencia();
			}
			return listModel;	
		}
		else {
			listModel.addElement("No hay canciones en favoritas");
			return listModel;
		}
	}
	//Metodo encargado de dar acceso al nodo para ser utilizado
	//dentro de la interfaz
	public Nodo1 primero() {
		return primero;
		
	}
	  public DefaultListModel<String> eliminardato(JList<String> list) {
	    	DefaultListModel<String> modelo = (DefaultListModel<String>) list.getModel();
	    	modelo.remove(list.getSelectedIndex());
	    	return modelo;
	    }
	  public String Buscar (String a) {
			Nodo1 var = primero;

			for(int i = 0; i < tam; i++) {
				if(a.equals(var.getInformacion().getNombre())) {
					return var.getInformacion().getCancion();
				}else {
					
					var = var.getReferencia();
				}
			}
			
			
			return "NOSE XD";
		}
	  
	  public boolean verificar(CancionesFa v) {
		  
		  Nodo1 var = primero;
		  boolean verif = false;
			
			for (int i = 0; i < tam; i++) {
		
				if(v.getNombre().equals(var.getInformacion().getNombre())) {
					verif = true;
				}else {
					var = var.getReferencia();
				}
			}
			return verif;
		  
	  }
		
		
}

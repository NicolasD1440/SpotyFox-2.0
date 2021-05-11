package cola;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import objeto.CancionesFa;

public class ColaSimple {

	 //Elementos de la cola
	private Nodo primero; //El acceso al nodo
	private Nodo ultimo; 
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
		Nodo nodo = new Nodo();
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
	}
	
	//Metodo para que se encarga de obtener el tamaño
	public int getTam() {
		return this.tam;
	}
	//Este método es el encargado de guardar los datos ingresados desde la interfaz y mostrarlos en la lista;
	public DefaultListModel<String> mostrarDatos(){
		
		Nodo aux = primero;
		DefaultListModel<String> listModel = new DefaultListModel<String>();
		if(!ColaVacia()) {
			for(int i = 0; i < tam; i++) {
				listModel.addElement((i+1) + ". " + aux.getInformacion().getNombre());
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
	public Nodo primero() {
		return primero;
		
	}
}

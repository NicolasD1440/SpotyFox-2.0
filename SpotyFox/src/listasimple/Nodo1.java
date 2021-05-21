package listasimple;


import objeto.CancionesFa;

public class Nodo1 {

	private CancionesFa informacion;//Aqui se cambia por el objeto
	private Nodo1 Ref;// Variable para enlazar los nodos.

	//Respectivos get y set de los atributos
	public CancionesFa getInformacion() {
		return informacion;
	}
	public void setInformacion(CancionesFa informacion) {
		this.informacion = informacion;
	}
	
	public Nodo1 getRef() {
		return Ref;
	}
	public void setRef(Nodo1 ref) {
		Ref = ref;
	}
	
}

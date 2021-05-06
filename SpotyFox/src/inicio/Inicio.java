package inicio;

import java.io.File;

import javax.swing.JOptionPane;

import javazoom.jlgui.basicplayer.BasicPlayer;
import listas.Lista_Circular;
import objeto.Canciones;
import vistas.Portada;


public class Inicio {
	
	public static Lista_Circular metod = new Lista_Circular();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		metod.addElement(new Canciones("/Caratula1.jpg","Another one bites the dust","Queen"));
		metod.addElement(new Canciones("/Caratula2.jpg","Dile","Don Omar"));
		metod.addElement(new Canciones("/Caratula3.jpg","Cuando hablan las miradas","Guayacan"));
		metod.addElement(new Canciones("/Caratula4.jpg","Hotaru No Hikari","Ikimono-Gakari"));
		
		

		//reproducir("recursos/Lindsey.mp3");
		Portada ventana = new Portada();
		ventana.setVisible(true);
	}
	

}

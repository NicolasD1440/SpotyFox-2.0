package inicio;

import java.io.File;

import javax.swing.JOptionPane;

import javazoom.jlgui.basicplayer.BasicPlayer;
import listas.Lista_Circular;
import listasimple.Lista_Simple;
import objeto.Canciones;
import vistas.Portada;


public class Inicio {
	
	public static Lista_Circular metod = new Lista_Circular();
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		metod.addElement(new Canciones("/Caratula1.jpg","Another one bites the dust","Queen","recursos/Queen-Another.mp3", "3:42"));
		metod.addElement(new Canciones("/Caratula2.jpg","Dile","Don Omar","recursos/Dile.mp3", "3:26"));
		metod.addElement(new Canciones("/Caratula3.jpg","Cuando hablan las miradas","Guayacan","recursos/Cuando.mp3", "4:21"));
		metod.addElement(new Canciones("/Caratula4.jpg","Hotaru No Hikari","Ikimono-Gakari","recursos/naruto.mp3", "4:01"));
		metod.addElement(new Canciones("/Caratula5.jpg","A Kind of Magic","Queen","recursos/kind.mp3", "4:43"));
		metod.addElement(new Canciones("/Caratula6.jpg","The Final Countdown","Europe","recursos/Final.mp3", "4:56"));
		metod.addElement(new Canciones("/Caratula7.jpg","Inferno","Mrs. GREEN APPLE ","recursos/Fire.mp3", "3:31"));
		Portada ventana = new Portada();
		ventana.setVisible(true);
	}
	

}

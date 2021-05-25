package objeto;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;

import org.tritonus.share.sampled.file.TAudioFileFormat;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import javazoom.jlgui.basicplayer.BasicController;
import javazoom.jlgui.basicplayer.BasicPlayer;
import javazoom.jlgui.basicplayer.BasicPlayerEvent;
import javazoom.jlgui.basicplayer.BasicPlayerException;
import javazoom.jlgui.basicplayer.BasicPlayerListener;

public class Sound {
	  
	  
		
	  // FileInputStream FIS;
	  // public long songtotalLength;
	
	   public BasicPlayer player;
	    public double Volumen;
	 //por defecto se puso que el volumen inicie en 0.25 decibeles de los 1.0 que nos permite usar la libreria
	 
	    public Sound(){
	        this.Volumen = 0.5;
	        player=new BasicPlayer();
	    }
	    
	
	    //pedimos una ruta en String donde se aloja el archivo de audio
	    public boolean Reproducir(String ruta) throws BasicPlayerException{
	    	ObternerDatos(ruta);
	        try {
	        	//si su estadi es 1 signfica que esta sonado, por lo cual no se hace nada
	            if(player.getStatus()==1){
	                
	            }else{
	            	// si no entonces significa que no hay ningun audio reproduciendo por lo cual reproduciremos el audio que se 
	            	//halla pasado por parametro
	                player.play();
	            }
	            
	            return true;
	        } catch (BasicPlayerException ex) {
	            return false;
	        }
	    }

	    //La funcion stop se activara si el audio se encuentra reproduciendose o no, esta funcion elimina de menoria el bit en donde
	    //se detuvo. 
	    public boolean Parar(){
	        try {
	            if(player.getStatus()==1 || player.getStatus()==0){
	                player.stop();   
	            }
	            return true;
	        } catch (BasicPlayerException ex) {
	                return false;
	        }
	    }
	    //la funcion pause, solo se activa cuando la musica este activa este solo detinen el audio y guarda en memoria el bit en donde
	    //se detuvo el audio.
	    public boolean Pausar(){
	        try {
	            if(player.getStatus()==0){
	                player.pause();
	            }
	            return true;
	        } catch (BasicPlayerException ex) {
	            return false;
	        }
	    }
	    
	   
	    // retorna 0 si el audio esta sonando o 1 si no esta sonando
	    public int Estado(){
	        return player.getStatus();
	    }
	    
	    //pediremos un double entre 0.0 y 1.0 para ajustar los decibeles del audio
	    public boolean CambiarVolumen(double volumen){
	        try {
	        	//por defecto tomara el valor del contructor
	            Volumen=volumen;
	            player.setGain(volumen);
	        } catch (BasicPlayerException ex) {
	            return false;
	        }
	        return true;
	    }
	    
	
	    
	 //le pasamos una ruta para que encunetra el archivo a reproducirce
	    public void ObternerDatos(String ruta) throws BasicPlayerException{
	    	player.open(new File(ruta));
	    }
	    
	   
	  


}

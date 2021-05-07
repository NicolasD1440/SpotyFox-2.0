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
	  public BasicPlayer player;
	    public static float[] Eq = new float[32];
	    public static int[] EqP = new int[10];
	    public static float Balance;
	    public static int itemEc;
	    public static long Duracion;
	    public double Volumen;
	    public String RutaAbsoluta,Titulo,Artista,Album,Ano,Comentario,Copyright;

		Timer timer = new Timer();
	   // public long Duracion;
	    FileInputStream FIS;
	   public long songtotalLength;
	    public Sound(){
	        this.Volumen = 1;
	        player=new BasicPlayer();
	    }
	    
	
	    
	    public boolean Reproducir(String ruta) throws BasicPlayerException{
	    	ObternerDatos(ruta);
	        try {
	            if(player.getStatus()==1){
	                player.resume();
	            }else{
	                player.play();
	            }
	            CambiarVolumen(Volumen);
	            return true;
	        } catch (BasicPlayerException ex) {
	            return false;
	        }
	    }
	    
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
	    
	   
	    
	    public int Estado(){
	        return player.getStatus();
	    }
	    
	    public boolean CambiarVolumen(double volumen){
	        try {
	            Volumen=volumen;
	            player.setGain(volumen);
	        } catch (BasicPlayerException ex) {
	            return false;
	        }
	        return true;
	    }
	    
	    public boolean Balance(float bal){
	        try {
	            player.setPan(bal);
	         
	        } catch (BasicPlayerException ex) {
	            return false;
	        }
	        return true; 
	       
	    }
	    
	 
	    public void ObternerDatos(String ruta) throws BasicPlayerException{
	    	player.open(new File(ruta));
	    }
	    public void tamaño( String path) throws IOException { 
	    	FIS = new FileInputStream(path);
	        songtotalLength = FIS.available();	
	      
	    }
	    public void ObternerDatos(){
	        File mp3Archivo = new File(RutaAbsoluta);
	        AudioFileFormat baseFileFormat = null;
	        try {
	            baseFileFormat = AudioSystem.getAudioFileFormat(mp3Archivo);
	        } catch (UnsupportedAudioFileException | IOException ex) {
	            Logger.getLogger(Sound.class.getName()).log(Level.SEVERE, null, ex);
	        }
	        if(baseFileFormat instanceof TAudioFileFormat){
	            Map properties = ((TAudioFileFormat)baseFileFormat).properties();
	            Titulo=(String)properties.get("title");
	            Artista=(String)properties.get("author");
	            Album=(String)properties.get("album");
	            Ano=(String)properties.get("date");
	            Comentario=(String)properties.get("comment");
	            Copyright=(String)properties.get("copyright");
	            Duracion=(long)properties.get("duration")/1000000;
	        }
	    }
	  


}

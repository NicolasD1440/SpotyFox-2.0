package objeto;

import java.io.File;

import javazoom.jlgui.basicplayer.BasicPlayer;
import javazoom.jlgui.basicplayer.BasicPlayerException;

public class Sound {
	private BasicPlayer basicPlayer;
	//Constructor
	public Sound() {
	basicPlayer = new BasicPlayer();
	}
	//reproduce la musica
	 public void play() {
		 try {
			 basicPlayer.play();
		  
		
		 } catch (BasicPlayerException e) {
		  // TODO Auto-generated catch block  e.printStackTrace();
		 }
		}
	 //pide la ubicacion del archivo que sera reproducido
	 public void loadFile(String ruta) throws BasicPlayerException {
		 basicPlayer.open(new File(ruta));
		
		 }
	 //verificamos si la cacion se esta reproduciendo
	 public boolean estado() {
		 if(basicPlayer.getStatus() == 0) {
			 return true;
		 }else {
			 return false;
		 }
		 
	 }
	 //pausamos la cancion
	 public void pausa() throws BasicPlayerException {
		 basicPlayer.pause();
		 
		
	 }
	 public void seguir() throws BasicPlayerException {
		 basicPlayer.resume();
	 }
	 public void volumen(double a) throws BasicPlayerException {
		  basicPlayer.setGain(a);
	 }
}

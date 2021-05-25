package vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import inicio.Inicio;
import listas.Lista_Circular;
import listas.Nodo;

import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JProgressBar;
import java.awt.Window.Type;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.border.BevelBorder;

public class Portada extends JFrame {


	//Se instancia la clase de la lista Circular
	Lista_Circular metod = new Lista_Circular();
	//Se instancia la clase Inicio
	Inicio principal = new Inicio();
	//Se colocan las variables de los label contentpane, JprogressBar 
	//en la parte superior ya que serán utilizadas en los métodos dentro de la interfaz
	private JPanel contentPane;
	JLabel lblNombreL = new JLabel("New label");
	JLabel lblBarras = new JLabel("New label");
	JProgressBar progressBar = new JProgressBar();
	Timer timer = new Timer();// Aquí se pone en marcha el timer cada segundo.

	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Portada frame = new Portada();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Menu ventana = new Menu(Inicio.metod.first());
	
	public Portada() {
		setUndecorated(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 350);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNombreL.setBounds(46, 11, 458, 109);
		contentPane.add(lblNombreL);
		
		lblBarras.setBounds(0, 115, 534, 109);
		contentPane.add(lblBarras);
		progressBar.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 153, 255), new Color(0, 153, 255), new Color(0, 153, 255), new Color(0, 153, 255)));
		
		progressBar.setStringPainted(true);
		progressBar.setForeground(new Color(51, 0, 204));
		progressBar.setBounds(30, 253, 474, 25);
		contentPane.add(progressBar);
		setLocationRelativeTo(null);//Se implementa este codigo para que la ventana de la interfaz se muestre en el centro
		Carga();//Se implementa el metodo para la barra de carga
		Logo();//Se implementa el metodo para mostrar la imagen de fondo
	}
	
	//Metodo de carga
	private void Carga() {
		// Clase en la que está el código a ejecutar, esta instancia nos permite utilizar la clase java.util.Timer
		TimerTask tarea = new TimerTask() {
			 int x =0;//Se utiliza una varibale de tipo entero como un contador que sea igual a cero

			@Override
			public void run() {
				// Aquí el código que queremos ejecutar
				
				progressBar.setValue(x++);
				//Utilizamos una barra de progreso para que se vaya llenando
				if(x ==100) {
					//Se utiliza este condicional para que la variable x vaya aumentado desde cero a 100
					//y que apenas llegue a 100 muestre la siguiente interfaz
					ventana.setVisible(true);
					dispose();
				}
			}
			 
		};
		//Empieza en 0 ms y luego que se llena la barra cada 30 milisegundos
		 timer.schedule(tarea, 0,30);
	}
	
	//Metodo para agregar una imagen de fondo
	private void Logo() {
		//La imagen está dentro del programa en una carpeta llamada recursos desde allí se trae esta imagen 
		Image imagen = new ImageIcon(this.getClass().getResource("/Nombre.png"))
				.getImage().getScaledInstance(lblNombreL.getWidth(), lblNombreL.getHeight(),Image.SCALE_DEFAULT);
			lblNombreL.setIcon(new ImageIcon(imagen));//Se setea para hacer visible la imagen seleccionada
		//Con getScaledInstance(lblFondo.getWidth(),lblFondo.getHeight(),Image.SCALE_DEFAULT, se adapta al tamaño delLabel la imagen
			
		//La imagen está dentro del programa en una carpeta llamada recursos desde allí se trae esta imagen 	
		Image imagen1 = new ImageIcon(this.getClass().getResource("/sonido.gif"))
				.getImage().getScaledInstance(lblBarras.getWidth(), lblBarras.getHeight(),Image.SCALE_DEFAULT);
			lblBarras.setIcon(new ImageIcon(imagen1));//Se setea para hacer visible la imagen seleccionada
		//Con getScaledInstance(lblFondo.getWidth(),lblFondo.getHeight(),Image.SCALE_DEFAULT, se adapta al tamaño delLabel la imagen
	}
}

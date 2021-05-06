package vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import inicio.Inicio;
import javazoom.jlgui.basicplayer.BasicController;
import javazoom.jlgui.basicplayer.BasicPlayerEvent;
import javazoom.jlgui.basicplayer.BasicPlayerException;
import javazoom.jlgui.basicplayer.BasicPlayerListener;
import listas.Nodo;
import objeto.Sound;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Map;
import javax.swing.JSlider;

public class Menu extends JFrame {

	private JPanel contentPane;
	
	//botones de panel Menu
	JLabel lblHome = new JLabel("New label");
	JLabel lblLista = new JLabel("New label");
	
	//botones de panle Reproductor
	JLabel lblAnterior = new JLabel("<<     ");
	JLabel lblPlay = new JLabel("<P>");
	JLabel lblSiguiente = new JLabel("    >>");
	private JPanel Musica;
	private JPanel Reproductor;
	private final JLabel lblCaratula = new JLabel("");
	private final JLabel lblNombre = new JLabel("Nombre de la cancion");
	private final JLabel lblAutor = new JLabel("AUTOR");
	private final JLabel lblAnteriorC = new JLabel("New label");
	private final JLabel lblSiguienteC = new JLabel("New label");
	private final JPanel Lista = new JPanel();
	private final JLabel lblNewLabel = new JLabel("Favoritas");
	Sound sd = new Sound();
	JSlider slider = new JSlider();

	private static Nodo nodo;
	private final JLabel lblPausa = new JLabel("New label");
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu(Inicio.metod.first());
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Menu(Nodo first) {
		this.nodo = first;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 420);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Musica = new JPanel();
		Musica.setBackground(new Color(51, 51, 51));
		Musica.setBounds(149, 11, 475, 298);
		contentPane.add(Musica);
		Musica.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Nuestra musica");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_3.setBounds(10, 11, 455, 30);
		Musica.add(lblNewLabel_3);
	
		lblCaratula.setHorizontalAlignment(SwingConstants.CENTER);
		lblCaratula.setBounds(109, 52, 251, 156);
		
		Musica.add(lblCaratula);
		lblNombre.setForeground(new Color(255, 255, 255));
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setBounds(39, 219, 414, 30);
		
		Musica.add(lblNombre);
		lblAnteriorC.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (nodo.getAnterior() != null) {
					nodo = nodo.getAnterior();
					Caratula();
					mostrarDatos();
					try {
						sd.loadFile(nodo.getInformacion().getCancion());
					} catch (BasicPlayerException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					sd.play();
				}	
			}
		});
		lblAnteriorC.setBounds(10, 123, 30, 30);
		
		Musica.add(lblAnteriorC);
		lblSiguienteC.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (nodo.getSiguiente() != null) {
					nodo = nodo.getSiguiente();
					Caratula();
					mostrarDatos();
					try {
						sd.loadFile(nodo.getInformacion().getCancion());
					} catch (BasicPlayerException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					sd.play();
				}	
			}
		});
		lblSiguienteC.setBounds(435, 123, 30, 30);
		
		Musica.add(lblSiguienteC);
		
		
		lblAutor.setHorizontalAlignment(SwingConstants.CENTER);
		lblAutor.setForeground(Color.WHITE);
		lblAutor.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAutor.setBounds(81, 260, 329, 30);
		Musica.add(lblAutor);
		Lista.setBackground(new Color(51, 51, 51));
		Lista.setBounds(149, 11, 475, 298);
		
		contentPane.add(Lista);
		Lista.setLayout(null);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(10, 11, 455, 30);
		
		Lista.add(lblNewLabel);
		
		Reproductor = new JPanel();
		Reproductor.setBackground(new Color(51, 51, 51));
		Reproductor.setBounds(10, 320, 614, 50);
		contentPane.add(Reproductor);
		Reproductor.setLayout(null);
		
		lblAnterior.setBounds(221, 11, 30, 28);
		Reproductor.add(lblAnterior);
		
		
		lblSiguiente.setBounds(338, 11, 30, 28);
		Reproductor.add(lblSiguiente);
		lblPlay.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
               
				if(sd.estado() == false ){
					try {
						sd.loadFile(nodo.getInformacion().getCancion());
						sd.play();
							
					} catch (BasicPlayerException a) {
						// TODO Auto-generated catch block
						a.printStackTrace();
					}
				}else {
					try {
						sd.loadFile(nodo.getInformacion().getCancion()); 
						sd.pausa();
						
					} catch (BasicPlayerException a) {
						// TODO Auto-generated catch block
						a.printStackTrace();
					}
				
				}
			}
		});
		
		lblPlay.setBounds(261, 11, 30, 28);
		Reproductor.add(lblPlay);
		lblPausa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(sd.estado() == false ){
					try {
						sd.seguir();
					} catch (BasicPlayerException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			}		
		});
		lblPausa.setBounds(301, 11, 30, 28);
		
		Reproductor.add(lblPausa);
		slider.setBackground(Color.GRAY);
		slider.setForeground(Color.BLACK);
		slider.setBounds(404, 1, 200, 26);
		Reproductor.add(slider);
		slider.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
			@Override
			public void mouseReleased(MouseEvent e) {	
				double a = slider.getValue() * 1.0;
						try {
							sd.volumen(a/10);
						} catch (BasicPlayerException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
			}
			
		});
		slider.setMaximum(10);
		
		slider.setMajorTickSpacing(1);
		slider.setPaintLabels(true);
		slider.setValue(5);
		
		JPanel Menu = new JPanel();
		Menu.setBackground(new Color(51, 51, 51));
		Menu.setBounds(10, 11, 129, 298);
		contentPane.add(Menu);
		Menu.setLayout(null);
		lblHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Musica.setVisible(true);
				Lista.setVisible(false);
			}
		});
		
		lblHome.setBounds(10, 11, 109, 30);
		Menu.add(lblHome);
		lblLista.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Musica.setVisible(false);
				Lista.setVisible(true);
			}
		});
		
		lblLista.setBounds(10, 52, 109, 30);
		Menu.add(lblLista);
		setLocationRelativeTo(null);
		Caratula();
		Botones();
		mostrarDatos();
	}
	
	private void Botones() {
		
		//imagenes de Menu
		Image home = new ImageIcon(this.getClass().getResource("/Home.png"))
				.getImage().getScaledInstance(lblHome.getWidth(), lblHome.getHeight(),Image.SCALE_DEFAULT);
			lblHome.setIcon(new ImageIcon(home));
				
		Image lista = new ImageIcon(this.getClass().getResource("/Lista.png"))
				.getImage().getScaledInstance(lblLista.getWidth(), lblLista.getHeight(),Image.SCALE_DEFAULT);
			lblLista.setIcon(new ImageIcon(lista));
			
		//imagenes de Reproductor
		Image anterior = new ImageIcon(this.getClass().getResource("/Anterior.png"))
				.getImage().getScaledInstance(lblAnterior.getWidth(), lblAnterior.getHeight(),Image.SCALE_DEFAULT);
			lblAnterior.setIcon(new ImageIcon(anterior));

		Image play = new ImageIcon(this.getClass().getResource("/Play.png"))
				.getImage().getScaledInstance(lblPlay.getWidth(), lblPlay.getHeight(),Image.SCALE_DEFAULT);
			lblPlay.setIcon(new ImageIcon(play));
			
		Image siguiente = new ImageIcon(this.getClass().getResource("/Siguiente.png"))
				.getImage().getScaledInstance(lblSiguiente.getWidth(), lblSiguiente.getHeight(),Image.SCALE_DEFAULT);
			lblSiguiente.setIcon(new ImageIcon(siguiente));
			
		//imagenes de Musica
		Image anteriorC = new ImageIcon(this.getClass().getResource("/Atras.png"))
				.getImage().getScaledInstance(lblAnteriorC.getWidth(), lblAnteriorC.getHeight(),Image.SCALE_DEFAULT);
			lblAnteriorC.setIcon(new ImageIcon(anteriorC));
				
		Image siguienteC = new ImageIcon(this.getClass().getResource("/Adelante.png"))
				.getImage().getScaledInstance(lblSiguienteC.getWidth(), lblSiguienteC.getHeight(),Image.SCALE_DEFAULT);
			lblSiguienteC.setIcon(new ImageIcon(siguienteC));
			
			Image pause = new ImageIcon(this.getClass().getResource("/Pause.png"))
				.getImage().getScaledInstance(lblSiguienteC.getWidth(), lblSiguienteC.getHeight(),Image.SCALE_DEFAULT);
			lblPausa.setIcon(new ImageIcon(pause));
	}
	
	public void Caratula() {
 		
		  Image imagen = new ImageIcon(this.getClass().getResource(nodo.getInformacion().getCaratula()))
		  .getImage().getScaledInstance(lblCaratula.getWidth(), lblCaratula.getHeight(),Image.SCALE_DEFAULT);
		  lblCaratula.setIcon(new ImageIcon(imagen));
	 }
  
    public void mostrarDatos() {
 	
 	      lblNombre.setText(nodo.getInformacion().getNombre());
 	      lblAutor.setText(nodo.getInformacion().getArtista());
 	     
   }
    
}

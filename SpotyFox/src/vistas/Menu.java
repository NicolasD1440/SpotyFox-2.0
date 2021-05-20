package vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cola.ColaSimple;
import cola.Nodo1;
import inicio.Inicio;
import javazoom.jlgui.basicplayer.BasicController;
import javazoom.jlgui.basicplayer.BasicPlayerEvent;
import javazoom.jlgui.basicplayer.BasicPlayerException;
import javazoom.jlgui.basicplayer.BasicPlayerListener;
import listas.Nodo;
import objeto.Canciones;
import objeto.CancionesFa;
import objeto.Sound;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JSlider;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JProgressBar;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.Window.Type;
import javax.swing.JScrollPane;

public class Menu extends JFrame  {

	private JPanel contentPane;
	JLabel lblPlay = new JLabel("<P>");
	private JPanel Musica;
	private JPanel Reproductor;
	JList<String> list = new JList<String>();
	private final JLabel lblCaratula = new JLabel("");
	private final JLabel lblNombre = new JLabel("Nombre de la cancion");
	private final JLabel lblAutor = new JLabel("AUTOR");
	private final JLabel lblAnteriorC = new JLabel("New label");
	private final JLabel lblSiguienteC = new JLabel("New label");
	private final JPanel Lista = new JPanel();
	private final JLabel lblNewLabel = new JLabel("Favoritas");
	JLabel lblFavorita = new JLabel("F");
	Sound sd = new Sound();
	
	JSlider slider = new JSlider();
	Timer timer = new Timer();
	JProgressBar progreso = new JProgressBar();
    int TamanoEnBytes;
	private static Nodo nodo;
	private static Nodo1 nodo1;
	private final JLabel lblPausa = new JLabel("New label");
	private JPanel Menu;
	private final JLabel lblTime = new JLabel("New label");
	private final JLabel lblHome = new JLabel("New label");
	private final JLabel lblLista = new JLabel("New label");
    ColaSimple cola = new ColaSimple();
    private final JLabel lblBasura = new JLabel("Borrar");
    private final JScrollPane scrollPane = new JScrollPane();
    
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
		setType(Type.UTILITY);
		this.nodo = first;
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 420);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/*list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				*/
		
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
		lblNombre.setForeground(new Color(255, 255, 255));
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setBounds(72, 231, 293, 30);
		
		Musica.add(lblNombre);
		
		
		lblAutor.setHorizontalAlignment(SwingConstants.CENTER);
		lblAutor.setForeground(Color.WHITE);
		lblAutor.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblAutor.setBounds(72, 257, 293, 30);
		Musica.add(lblAutor);
		slider.setBounds(432, 52, 10, 209);
		Musica.add(slider);
		slider.setOrientation(SwingConstants.VERTICAL);
		slider.setBackground(Color.DARK_GRAY);
		slider.setForeground(new Color(0, 102, 204));
		slider.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {	
				double a = (slider.getValue() * 1.0)/10;
			
			
					sd.CambiarVolumen(a*a);
				
			}
			
		});
		slider.setMaximum(10);
		
		slider.setMajorTickSpacing(1);
		slider.setValue(5);
		
		JLabel lblNewLabel_3_1 = new JLabel("Vol");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setForeground(Color.WHITE);
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3_1.setBounds(415, 32, 44, 30);
		Musica.add(lblNewLabel_3_1);
		progreso.setMaximum(400);
		
		
		progreso.setBounds(61, 287, 404, 8);
		Musica.add(progreso);
		lblTime.setForeground(Color.WHITE);
		lblTime.setBounds(10, 281, 46, 14);
		
		Musica.add(lblTime);
		lblFavorita.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				cola.encolar(new CancionesFa(nodo.getInformacion().getCaratula(),
											 nodo.getInformacion().getNombre(),
											 nodo.getInformacion().getArtista(),
											 nodo.getInformacion().getCancion(),
											 nodo.getInformacion().getTiempo()));
			}
		});
		
		lblFavorita.setBounds(335, 52, 30, 30);
		Musica.add(lblFavorita);
		
			lblCaratula.setHorizontalAlignment(SwingConstants.CENTER);
			lblCaratula.setBounds(72, 52, 293, 180);
			
			Musica.add(lblCaratula);
		Lista.setBackground(new Color(51, 51, 51));
		Lista.setBounds(149, 11, 475, 298);
		
		contentPane.add(Lista);
		Lista.setLayout(null);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(10, 11, 455, 30);
		
		Lista.add(lblNewLabel);
		scrollPane.setBounds(20, 52, 428, 190);
		
		Lista.add(scrollPane);
		scrollPane.setViewportView(list);
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 1) {
					try {
						sd.Reproducir(cola.Buscar(list.getSelectedValue()));
					} catch (BasicPlayerException e1) {
						
						e1.printStackTrace();
					}
				}
			}
		});
		
		
		
		list.setValueIsAdjusting(true);
		list.setBackground(new Color(51, 51, 51));
		list.setForeground(new Color(255, 255, 255));
		list.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblBasura.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				cola.eliminardato(list);
			}
		});
		lblBasura.setForeground(Color.WHITE);
		lblBasura.setHorizontalAlignment(SwingConstants.LEFT);
		lblBasura.setBounds(171, 257, 140, 30);
		
		Lista.add(lblBasura);
		
		Reproductor = new JPanel();
		Reproductor.setBackground(new Color(51, 51, 51));
		Reproductor.setBounds(10, 320, 614, 50);
		contentPane.add(Reproductor);
		Reproductor.setLayout(null);
		lblPlay.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			    timer.purge();
				progreso.setValue(0);
			 progreso.setMaximum(0);
			    
			   if (sd.Estado() == 0) {
				sd.Pausar();
			}else {
				
				
				try {
					sd.Reproducir(nodo.getInformacion().getCancion()); 
					tiempo();
				    incremento();
				} catch (BasicPlayerException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
				
          
		
			}
		});
		
		lblPlay.setBounds(261, 11, 30, 29);
		Reproductor.add(lblPlay);
		lblPausa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//sd.Stop();
				sd.Pausar();
				//timer.cancel();
				timer.purge();	
				progreso.setValue(0);
			    progreso.repaint();
			}		
		});
		lblPausa.setBounds(301, 11, 30, 29);
		
		Reproductor.add(lblPausa);
		lblAnteriorC.setBounds(221, 11, 30, 29);
		Reproductor.add(lblAnteriorC);
		lblSiguienteC.setBounds(341, 10, 30, 30);
		Reproductor.add(lblSiguienteC);
		lblSiguienteC.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (nodo.getSiguiente() != null) {
					nodo = nodo.getSiguiente();
					Caratula();
					mostrarDatos();
					sd.Pausar();
					timer.purge();	
					progreso.setValue(0);
				    progreso.repaint();
				    
				}
			}
		});
		lblAnteriorC.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (nodo.getAnterior() != null) {
					nodo = nodo.getAnterior();
					Caratula();
					mostrarDatos();
					sd.Pausar();
					timer.purge();	
					progreso.setValue(0);
				    progreso.repaint();
				    
				}
			}
		});
		
		Menu = new JPanel();
		Menu.setBackground(new Color(51, 51, 51));
		Menu.setBounds(10, 11, 129, 298);
		contentPane.add(Menu);
		Menu.setLayout(null);
		lblHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Musica.setVisible(true);
				Lista.setVisible(false);
				Reproductor.setVisible(true);
			}
		});
		lblHome.setBounds(10, 11, 109, 32);
		
		Menu.add(lblHome);
		lblLista.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Musica.setVisible(false);
				Lista.setVisible(true);
				Reproductor.setVisible(false);
				list.setModel(cola.mostrarDatos());
				
				sd.Pausar();
				timer.purge();	
				progreso.setValue(0);
			    progreso.repaint();
			    lblTime.setText(String.valueOf(nodo.getInformacion().getTiempo()));
			}
		});
		lblLista.setBounds(10, 54, 109, 32);
		
		Menu.add(lblLista);
		setLocationRelativeTo(null);
		Caratula();
		Botones();
		mostrarDatos();
		
	   // incremento();

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
		Image play = new ImageIcon(this.getClass().getResource("/Play.png"))
				.getImage().getScaledInstance(lblPlay.getWidth(), lblPlay.getHeight(),Image.SCALE_DEFAULT);
			lblPlay.setIcon(new ImageIcon(play));
			
		Image anteriorC = new ImageIcon(this.getClass().getResource("/Anterior.png"))
				.getImage().getScaledInstance(lblAnteriorC.getWidth(), lblAnteriorC.getHeight(),Image.SCALE_DEFAULT);
			lblAnteriorC.setIcon(new ImageIcon(anteriorC));
				
		Image siguienteC = new ImageIcon(this.getClass().getResource("/Siguiente.png"))
				.getImage().getScaledInstance(lblSiguienteC.getWidth(), lblSiguienteC.getHeight(),Image.SCALE_DEFAULT);
			lblSiguienteC.setIcon(new ImageIcon(siguienteC));
			
		Image pause = new ImageIcon(this.getClass().getResource("/Pause.png"))
				.getImage().getScaledInstance(lblSiguienteC.getWidth(), lblSiguienteC.getHeight(),Image.SCALE_DEFAULT);
			lblPausa.setIcon(new ImageIcon(pause));
			
		Image Favorita = new ImageIcon(this.getClass().getResource("/Favorita.png"))
				.getImage().getScaledInstance(lblFavorita.getWidth(), lblFavorita.getHeight(),Image.SCALE_DEFAULT);
			lblFavorita.setIcon(new ImageIcon(Favorita));
			
		Image Basura = new ImageIcon(this.getClass().getResource("/Eliminar.png"))
				.getImage().getScaledInstance(lblBasura.getWidth(), lblBasura.getHeight(),Image.SCALE_DEFAULT);
			lblBasura.setIcon(new ImageIcon(Basura));
	}
	
	public void Caratula() {
 		
		//imagenes de las caratula
		  Image imagen = new ImageIcon(this.getClass().getResource(nodo.getInformacion().getCaratula()))
		  .getImage().getScaledInstance(lblCaratula.getWidth(), lblCaratula.getHeight(),Image.SCALE_DEFAULT);
		  lblCaratula.setIcon(new ImageIcon(imagen));
	 }
  
    public void mostrarDatos() {
 	
    	//datos de las canciones
 	      lblNombre.setText(nodo.getInformacion().getNombre());//nombre de la cancion
 	      lblAutor.setText(nodo.getInformacion().getArtista());//Cantante
 	     lblTime.setText(String.valueOf(nodo.getInformacion().getTiempo()));//tiempo de la cancion
 	     
   }
  
    public void incremento() {
    	int con = (int) (nodo.getInformacion().getTiempo()*59);
        progreso.setMaximum(con);
        
    	TimerTask tarea = new TimerTask() {
			 int x = 0;

			@Override
			public void run() {
				if(x<=con && sd.Estado() == 0){
			    x++;
				progreso.setValue(x);
				}else if(sd.Estado()==1) {
					cancel();
				}
				
				
				
			}
			 
		};
		 timer.schedule(tarea, 0,1000);
    
    }
    public void tiempo() {
    	TimerTask tarea1 = new TimerTask() {
			 double n = nodo.getInformacion().getTiempo();
             double x = 0;
			@Override
			public void run() {
				if(x<=n && sd.Estado() ==0){
			    x += 0.01;
			    lblTime.setText(String.valueOf(Math.round(x*100.0)/100.0));
				
				}else if(sd.Estado()==1) {
					cancel();
				}
				
				
				
			}
			 
		};
		 timer.schedule(tarea1, 0,592);
    	
    }
}

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
import listasimple.Lista_Simple;
import listasimple.Nodo1;
import objeto.Canciones;
import objeto.CancionesFa;
import objeto.Sound;

import javax.swing.DefaultListCellRenderer;
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
import java.awt.SystemColor;
import javax.swing.border.EtchedBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.event.KeyEvent;

public class Menu extends JFrame  {

	//Se colocan las variables de los label contentpane, Texfield, JButton, Jslider, JProgressBar, Jlist, JScrollPane
    //en la parte superior ya que serán utilizadas en los métodos dentro de la interfaz.
	private JPanel contentPane;
	JLabel lblPlay = new JLabel("<P>");
	JLabel lblF1 = new JLabel("f");
	JLabel lblF2 = new JLabel("f");
	private JPanel Musica;
	private JPanel Reproductor;
	JList<String> list = new JList<String>();
	private final JLabel lblCaratula = new JLabel("");
	private final JLabel lblNombre = new JLabel("Nombre de la cancion");
	private final JLabel lblAutor = new JLabel("AUTOR");
	private final JLabel lblAnteriorC = new JLabel("New label");
	private final JLabel lblSiguienteC = new JLabel("New label");
	private final JPanel Lista = new JPanel();
	private final JLabel lblTitulo = new JLabel("");
	JLabel lblFavorita = new JLabel("F");
	Sound sd = new Sound();
	
	JSlider slider = new JSlider();
	Timer timer = new Timer();
	JProgressBar progreso = new JProgressBar();
    int TamanoEnBytes;
	private static Nodo nodo;
	private static Nodo1 nodo1;
	private final JLabel lblPausa = new JLabel("New label");
	private final JLabel lblTime = new JLabel("New label");
	private final JLabel lblHome = new JLabel("New label");
	private final JLabel lblLista = new JLabel("New label");
	Lista_Simple mostrar = new Lista_Simple();//Se instancia la clase lista simple
    private final JLabel lblBasura = new JLabel("Borrar");
    private final JScrollPane scrollPane = new JScrollPane();
    private final JLabel lblF3 = new JLabel("f");
    private final JLabel lblF4 = new JLabel("f");
    
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
		setBounds(100, 100, 650, 490);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/*list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				*/
		
		Reproductor = new JPanel();
		Reproductor.setBackground(new Color(51, 51, 51));
		Reproductor.setBounds(0, 379, 634, 72);
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
				lblTime.setText("0:00");
			}else {
				
				
				try {
					sd.Reproducir(nodo.getInformacion().getCancion()); 
					temporizador(nodo.getInformacion().getTiempo());
				    incremento(nodo.getInformacion().getTiempo());
				} catch (BasicPlayerException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
				
          
		
			}

			
		});
		
		lblPlay.setBounds(274, 26, 46, 34);
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
		lblPausa.setBounds(322, 26, 46, 36);
		
		Reproductor.add(lblPausa);
		lblAnteriorC.setBounds(221, 25, 46, 35);
		Reproductor.add(lblAnteriorC);
		lblSiguienteC.setBounds(378, 26, 46, 35);
		Reproductor.add(lblSiguienteC);
		progreso.setBounds(37, 11, 567, 8);
		Reproductor.add(progreso);
		progreso.setMaximum(400);
		lblTime.setBounds(10, 5, 46, 14);
		Reproductor.add(lblTime);
		lblTime.setForeground(Color.WHITE);
		lblF4.setBounds(0, 0, 634, 72);
		
		Reproductor.add(lblF4);
		lblSiguienteC.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
		//Se coloca un condicional el cual dice que si el nodo siguiente es diferente de nullo, entonces que muestre los datos que están en la siguiente posición
				if (nodo.getSiguiente() != null) {
				//por medio del método implementado en lista circular de añadir elemento se implementa por medio de nodo para 
				//que cumpla la función de una lista circular que el primero esté conectado con el ultimo	
					nodo = nodo.getSiguiente();
					
					Caratula();//Muestra las imagenes de la cartula
					mostrarDatos();//Mustra los datos de las canciones
					sd.Pausar();//Pausa las canciones
					timer.purge();	
					progreso.setValue(0);
				    progreso.repaint();
				    
				}
			}
		});
		lblAnteriorC.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			//Se coloca un condicional el cual dice que si el nodo anterior es diferente de nullo, entonces que muestre los datos que están en la anterior posición 
				if (nodo.getAnterior() != null) {
				//por medio del método implementado en lista circular de añadir elemento se implementa por medio de nodo para 
				//que cumpla la función de una lista circular que el ultimo este conectado con el primero		
					nodo = nodo.getAnterior();
				
					Caratula();//Muestra las imagenes de la cartula
					mostrarDatos();//Mustra los datos de las canciones
					sd.Pausar();//Pausa las canciones
					timer.purge();	
					progreso.setValue(0);
				    progreso.repaint();
				    
				}
			}
		});
		
		Musica = new JPanel();
		Musica.setBackground(new Color(51, 51, 51));
		Musica.setBounds(0, 67, 634, 312);
		contentPane.add(Musica);
		Musica.setLayout(null);
		lblNombre.setForeground(new Color(255, 255, 255));
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setBounds(10, 11, 614, 30);
		
		Musica.add(lblNombre);
		
		
		lblAutor.setHorizontalAlignment(SwingConstants.CENTER);
		lblAutor.setForeground(Color.WHITE);
		lblAutor.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblAutor.setBounds(10, 275, 614, 37);
		Musica.add(lblAutor);
		slider.setBounds(586, 71, 10, 209);
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
		lblNewLabel_3_1.setBounds(558, 30, 66, 30);
		Musica.add(lblNewLabel_3_1);
		lblFavorita.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//Este boton agrega los elementos a la lista de favoritos 
				mostrar.addAbajo(new CancionesFa(nodo.getInformacion().getCaratula(),
											 nodo.getInformacion().getNombre(),
											 nodo.getInformacion().getArtista(),
											 nodo.getInformacion().getCancion(),
											 nodo.getInformacion().getTiempo()));
			}
		});
		
		lblFavorita.setBounds(470, 47, 32, 32);
		Musica.add(lblFavorita);
		lblCaratula.setDisplayedMnemonic(KeyEvent.VK_JAPANESE_ROMAN);
		lblCaratula.setBorder(UIManager.getBorder("CheckBox.border"));
		
		lblCaratula.setHorizontalAlignment(SwingConstants.CENTER);
		lblCaratula.setBounds(130, 40, 380, 240);
			
		Musica.add(lblCaratula);
			
		lblF1.setBounds(0, 0, 634, 312);
		Musica.add(lblF1);
		Lista.setBackground(new Color(51, 51, 51));
		Lista.setBounds(0, 67, 634, 384);
		
		contentPane.add(Lista);
		Lista.setLayout(null);
		scrollPane.setBounds(20, 24, 592, 290);
		
		Lista.add(scrollPane);
		scrollPane.setViewportView(list);
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 1) {
					try {
						sd.Reproducir(mostrar.Buscar(list.getSelectedValue()));
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
		
		DefaultListCellRenderer cellRenderer = (DefaultListCellRenderer)list.getCellRenderer();
		
		lblBasura.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				//Este boton al presionarlo se elimina la canción seleccionada tanto del Jlist como de la lista Simple
				mostrar.eliminarValor(list.getSelectedValue());	
				mostrar.eliminardato(list);
				
				sd.Pausar();//Se pausa la canción
			}
		});
		lblBasura.setForeground(Color.WHITE);
		lblBasura.setHorizontalAlignment(SwingConstants.LEFT);
		lblBasura.setBounds(290, 318, 68, 55);
		
		Lista.add(lblBasura);
		
		lblF2.setBounds(0, -11, 634, 395);
		Lista.add(lblF2);
		cellRenderer.setHorizontalAlignment(SwingConstants .CENTER);
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.desktop);
		panel.setBounds(0, 0, 634, 64);
		contentPane.add(panel);
		panel.setLayout(null);
		lblLista.setBounds(532, 0, 64, 64);
		panel.add(lblLista);
		lblLista.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//Al presionar este boton lo dirige a la sesion de favoritos
				lblTitulo.setText("Favoritas");
				Musica.setVisible(false);//Se oculate este elemento
				Lista.setVisible(true);//Se pone visible este elemento
				Reproductor.setVisible(false);//Se oculate este elemento
				list.setModel(mostrar.mostrarDatos());//Se muestran los elementos de la Lista
				
				sd.Parar();//Se para la canción si esta sonando al presionar este boton
				timer.purge();//	
				progreso.setValue(0);
			    progreso.repaint();
			    lblTime.setText(String.valueOf(nodo.getInformacion().getTiempo()));
			    
			}
		});
		lblHome.setBounds(46, 0, 64, 64);
		panel.add(lblHome);
		lblHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//Al presionar este boton se dirige a la sesion Home
				lblTitulo.setText("Nuestra musica");
				Musica.setVisible(true);//Se pone visible este elemento
				Lista.setVisible(false);//Se oculate este elemento
				Reproductor.setVisible(true);//Se pone visible este elemento
			}
		});
		lblTitulo.setBounds(102, 0, 433, 64);
		panel.add(lblTitulo);
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setForeground(new Color(255, 255, 255));
		lblTitulo.setFont(new Font("Script MT Bold", Font.PLAIN, 60));
		lblTitulo.setText("Nuestra musica");
		lblF3.setBounds(0, 0, 634, 85);
		
		panel.add(lblF3);
		Caratula();//Se implementa el metodo para mostrar las imagenes de las caratulas
		Fondos();//Se implementa el metodo para mostrar las imagenes de fondo y de los botones
		mostrarDatos();//Se implementa el metodo para mostrar los datos del objeto
		
	   

	}
	
	//Metodo para las imagenes del programa
	private void Fondos() {
		
		//imagenes de Menu
		Image home = new ImageIcon(this.getClass().getResource("/homen.png"))
				.getImage().getScaledInstance(lblHome.getWidth(), lblHome.getHeight(),Image.SCALE_DEFAULT);
			lblHome.setIcon(new ImageIcon(home));
				
		Image lista = new ImageIcon(this.getClass().getResource("/Favoritos.png"))
				.getImage().getScaledInstance(lblLista.getWidth(), lblLista.getHeight(),Image.SCALE_DEFAULT);
			lblLista.setIcon(new ImageIcon(lista));
			
		//Fondos 
		Image f1 = new ImageIcon(this.getClass().getResource("/f1.jpg"))
				.getImage().getScaledInstance(lblF1.getWidth(), lblF1.getHeight(),Image.SCALE_DEFAULT);
			lblF1.setIcon(new ImageIcon(f1));			
			
		Image f2 = new ImageIcon(this.getClass().getResource("/f1.jpg"))
				.getImage().getScaledInstance(lblF2.getWidth(), lblF2.getHeight(),Image.SCALE_DEFAULT);
			lblF2.setIcon(new ImageIcon(f2));
			
		Image f3 = new ImageIcon(this.getClass().getResource("/f3.jpg"))
				.getImage().getScaledInstance(lblF3.getWidth(), lblF3.getHeight(),Image.SCALE_DEFAULT);
			lblF3.setIcon(new ImageIcon(f3));
			
		Image f4 = new ImageIcon(this.getClass().getResource("/f3.jpg"))
				.getImage().getScaledInstance(lblF4.getWidth(), lblF4.getHeight(),Image.SCALE_DEFAULT);
			lblF4.setIcon(new ImageIcon(f4));
			
		//imagenes de Reproductor
		Image play = new ImageIcon(this.getClass().getResource("/Play.png"))
				.getImage().getScaledInstance(lblPlay.getWidth(), lblPlay.getHeight(),Image.SCALE_DEFAULT);
			lblPlay.setIcon(new ImageIcon(play));
			
		Image anteriorC = new ImageIcon(this.getClass().getResource("/Atras.png"))
				.getImage().getScaledInstance(lblAnteriorC.getWidth(), lblAnteriorC.getHeight(),Image.SCALE_DEFAULT);
			lblAnteriorC.setIcon(new ImageIcon(anteriorC));
				
		Image siguienteC = new ImageIcon(this.getClass().getResource("/Adelante.png"))
				.getImage().getScaledInstance(lblSiguienteC.getWidth(), lblSiguienteC.getHeight(),Image.SCALE_DEFAULT);
			lblSiguienteC.setIcon(new ImageIcon(siguienteC));
			
		Image pause = new ImageIcon(this.getClass().getResource("/Pausa.png"))
				.getImage().getScaledInstance(lblSiguienteC.getWidth(), lblSiguienteC.getHeight(),Image.SCALE_DEFAULT);
			lblPausa.setIcon(new ImageIcon(pause));
			
		Image Favorita = new ImageIcon(this.getClass().getResource("/Favoritas1.png"))
				.getImage().getScaledInstance(lblFavorita.getWidth(), lblFavorita.getHeight(),Image.SCALE_DEFAULT);
			lblFavorita.setIcon(new ImageIcon(Favorita));
			
		Image Basura = new ImageIcon(this.getClass().getResource("/Eliminar.png"))
				.getImage().getScaledInstance(lblBasura.getWidth(), lblBasura.getHeight(),Image.SCALE_DEFAULT);
			lblBasura.setIcon(new ImageIcon(Basura));
	}
	
	//Metodo para mostrar las imagenes de la caratula de las canciones
	public void Caratula() {
 	
		  Image imagen = new ImageIcon(this.getClass().getResource(nodo.getInformacion().getCaratula()))//Imagen de la caratula
		  .getImage().getScaledInstance(lblCaratula.getWidth(), lblCaratula.getHeight(),Image.SCALE_DEFAULT);
		  lblCaratula.setIcon(new ImageIcon(imagen));
	   //Con getScaledInstance(lblFondo.getWidth(),lblFondo.getHeight(),Image.SCALE_DEFAULT, se adapta al tamaño delLabel la imagen	  
	 }
  
	//Metodo para mostrar los datos de las canciones
    public void mostrarDatos() {
 	
 	      lblNombre.setText(nodo.getInformacion().getNombre());//nombre de la cancion
 	      lblAutor.setText(nodo.getInformacion().getArtista());//Cantante
 	      lblTime.setText(String.valueOf(nodo.getInformacion().getTiempo()));//tiempo de la cancion
 	     
   }
  
    public void incremento(String a) {
    	String[] parts = a.split(":");
		
		int fr = Integer.parseInt(parts[0]);
		int ft = Integer.parseInt(parts[1]);
		
    	int con = (int) ((fr*60) + ft);
    	System.out.println(con);
        progreso.setMaximum(con);
        
    	TimerTask tarea = new TimerTask() {
			 int x = 0;

			@Override
			public void run() {
				if(x < con && sd.Estado() == 0){
			    x++;
				progreso.setValue(x);
				System.out.println(x);
				}else if(sd.Estado()==1) {
					
					cancel();
				}
			} 
		};
		 timer.schedule(tarea, 0,1000);
    }
  
    public  void  temporizador(String a){
		String[] parts = a.split(":");
		int[] b = new int[2];
		
		 
		for (int i = 0; i < parts.length; i++) {
			 b[i] = Integer.parseInt(parts[i]);
			
		}
	
	
		 TimerTask tarea = new TimerTask() {
			int segundos;
            int minutos;
			@Override
			public void run() {
				 
				if(minutos < b[0]  && sd.Estado()==0|| segundos< b[1] && sd.Estado()==0 ) {
					segundos++;
					if(segundos > 59) {
						segundos =0;
						minutos++;
					}
					lblTime.setText(String.valueOf(minutos + ":" + segundos));
					
					
				}else {
					cancel();
				}
		}
		
		};
		 timer.schedule(tarea, 0,1000);
		}
}

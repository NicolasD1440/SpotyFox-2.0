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

	Lista_Circular metod = new Lista_Circular();
	Inicio principal = new Inicio();
	private JPanel contentPane;
	JLabel lblNombreL = new JLabel("New label");
	JLabel lblBarras = new JLabel("New label");
	JProgressBar progressBar = new JProgressBar();
	Timer timer = new Timer();

	
	
	
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
		progressBar.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(255, 204, 0), new Color(255, 153, 0), new Color(255, 102, 0), new Color(255, 51, 0)));
		
		progressBar.setStringPainted(true);
		progressBar.setForeground(new Color(255, 165, 0));
		progressBar.setBounds(30, 253, 474, 25);
		contentPane.add(progressBar);
		setLocationRelativeTo(null);
		Carga();
		Logo();
	}
	
	private void Carga() {
		TimerTask tarea = new TimerTask() {
			 int x =0;

			@Override
			public void run() {
				
				progressBar.setValue(x++);
				
				if(x ==100) {
					ventana.setVisible(true);
					dispose();
				}
			}
			 
		};
		 timer.schedule(tarea, 0,30);
	}
	private void Logo() {
		
		Image imagen = new ImageIcon(this.getClass().getResource("/Nombre.png"))
				.getImage().getScaledInstance(lblNombreL.getWidth(), lblNombreL.getHeight(),Image.SCALE_DEFAULT);
			lblNombreL.setIcon(new ImageIcon(imagen));
			
		Image imagen1 = new ImageIcon(this.getClass().getResource("/sonido.gif"))
				.getImage().getScaledInstance(lblBarras.getWidth(), lblBarras.getHeight(),Image.SCALE_DEFAULT);
			lblBarras.setIcon(new ImageIcon(imagen1));
	}
}

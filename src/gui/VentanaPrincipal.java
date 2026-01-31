package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class VentanaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	//Declarar los paneles como atributos
	private Panel_inicio panel_inicio;
	private Login_administrador login_administrador;
	private Login_usuario login_usuario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
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
	public VentanaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel_inicio = new Panel_inicio(this);
		login_administrador = new Login_administrador(this);
		login_usuario = new Login_usuario(this);
		panel_inicio.setPreferredSize(new java.awt.Dimension(1000, 620));
		setContentPane(panel_inicio);
		pack();
		setLocationRelativeTo(null);
		Panel_inicio();
	}
	
	public void Panel_inicio() {
		cambiar_panel(panel_inicio);
	}
	
	public void Login_administrador() {
		cambiar_panel(login_administrador);
	}
	
	public void Login_usuario() {
		cambiar_panel(login_usuario);
	}
	
	public void cambiar_panel(JPanel panel) {
		setContentPane(panel);
		revalidate();
		repaint();
	}
	

}


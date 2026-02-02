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
	//private Menu_usuario menu_usuario;
	private Ventana_reporte ventana_reporte;
	private MenuMantenimiento menu_mantenimiento;

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
		//menu_usuario = new Menu_usuario(this);
		ventana_reporte = new Ventana_reporte(this);
		menu_mantenimiento = new MenuMantenimiento(this);
		panel_inicio.setPreferredSize(new java.awt.Dimension(1000, 620));
		setContentPane(panel_inicio);
		pack();
		setLocationRelativeTo(null);
		Panel_inicio();
	}
	
	public void Panel_inicio() {
		cambiar_panel(panel_inicio);
	}
	
	public void Login_administrador(String tipo) {
		login_administrador.setModo(tipo);
		cambiar_panel(login_administrador);
	}
	
	public void Login_usuario() {
		cambiar_panel(login_usuario);
	}
	
	//public void menu_usuario() {
	//	cambiar_panel(menu_usuario);
	//}
	
	public void Menu_mantenimiento() {
		cambiar_panel(menu_mantenimiento);
	}
	
	public void Menu_reportes() {
		cambiar_panel(ventana_reporte);
	}
	
	public void cambiar_panel(JPanel panel) {
		setContentPane(panel);
		revalidate();
		repaint();
	}
}


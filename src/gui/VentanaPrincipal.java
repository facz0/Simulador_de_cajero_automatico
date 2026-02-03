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
	private Menu_usuario menu_usuario;
	private Ventana_reportee ventana_reporte;
	private MenuMantenimiento menu_mantenimiento;
	private DepositoDinero depositar_dinero;
	private CambioMoneda cambio_moneda;
	private ConsultaDeSaldo consulta_saldo;
	private Consultas_Rango consultas_rango;
	private Retiro_dinero retiro_dinero;
	private Cambio_clave cambio_clave;
	private Ultimos_movimientos ultimos_movimientos;
	private Mantenimiento_cuentaBancaria mantenimiento_cuenta;
	private Mantenimiento_cliente mantenimiento_cliente;
	private Mantenimiento_transaccion mantenimiento_transaccion;
	private Mantenimiento_moneda mantenimiento_moneda;
	private Mantenimiento_tipoCambio mantenimiento_tipoCambio;

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
		menu_usuario = new Menu_usuario(this);
		ventana_reporte = new Ventana_reportee(this);
		menu_mantenimiento = new MenuMantenimiento(this);
		depositar_dinero = new DepositoDinero(this);
		cambio_moneda = new CambioMoneda(this);
		consulta_saldo = new ConsultaDeSaldo(this);
		consultas_rango = new Consultas_Rango(this);
		retiro_dinero = new Retiro_dinero(this);
		cambio_clave = new Cambio_clave(this);
		ultimos_movimientos = new Ultimos_movimientos(this);
		mantenimiento_cuenta = new Mantenimiento_cuentaBancaria(this);
		mantenimiento_cliente = new Mantenimiento_cliente(this);
		mantenimiento_transaccion = new Mantenimiento_transaccion(this);
		mantenimiento_moneda = new Mantenimiento_moneda(this);
		mantenimiento_tipoCambio = new Mantenimiento_tipoCambio(this);
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
	
	public void menu_usuario() {
		cambiar_panel(menu_usuario);
	}
	
	public void Menu_mantenimiento() {
		cambiar_panel(menu_mantenimiento);
	}
	
	public void Menu_reportes() {
		cambiar_panel(ventana_reporte);
	}
	
	public void Depositar_dinero() {
		cambiar_panel(depositar_dinero);
	}
	
	public void Cambio_moneda() {
		cambiar_panel(cambio_moneda);
	}
	
	public void Consultar_saldo() {
		cambiar_panel(consulta_saldo);
	}
	
	public void Consultar_por_ranfo() {
		cambiar_panel(consultas_rango);
	}
	
	public void Retirar_dinero() {
		cambiar_panel(retiro_dinero);
	}
	
	public void Cambiar_clave() {
		cambiar_panel(cambio_clave);
	}
	
	public void Ultimos_movimientos() {
		cambiar_panel(ultimos_movimientos);
	}
	
	public void Mantenimiento_cuenta_bancaria() {
		cambiar_panel(mantenimiento_cuenta);
	}
	
	public void Mantenimiento_cliente() {
		cambiar_panel(mantenimiento_cliente);
	}
	
	public void Mantenimiento_tipo_transaccion() {
		cambiar_panel(mantenimiento_transaccion);
	}
	
	public void Mantenimiento_Moneda() {
		cambiar_panel(mantenimiento_moneda);
	}
	
	public void Mantenimiento_Tipo_de_cambio() {
		cambiar_panel(mantenimiento_tipoCambio);
	}

	
	public void cambiar_panel(JPanel panel) {
		setContentPane(panel);
		revalidate();
		repaint();
	}
}


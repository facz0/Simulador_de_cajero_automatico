package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;

import operaciones.DepositoDinero;
import operaciones.Retiro_dinero;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class Menu_usuario extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private VentanaPrincipal ventanaPrincipal;
	private JSeparator separator;
	private JLabel lblTitulo;
	private JLabel lblSelecciona;
	private JButton btnCambiarClave;
	private JButton btnRetiroDeDinero;
	private JButton btnDepositoDeDinero;
	private JButton btnCambiarMoneda;
	private JButton btnConsultas;
	private JButton btnCancelar;
	private DepositoDinero depositarDinero;
	private Retiro_dinero retiro_dinero;
	
	
	/**
	 * Create the panel.
	 */
	public Menu_usuario(VentanaPrincipal principal) {
		setBackground(new Color(2, 64, 89));
		setPreferredSize(new java.awt.Dimension(1000, 620));
		this.ventanaPrincipal = principal;
		setLayout(null);
		
		
		ImageIcon clave = new ImageIcon(getClass().getResource("/iconos/CambioClave.png"));//llama la img
		Image imgescalada = clave.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		ImageIcon retiro = new ImageIcon(getClass().getResource("/iconos/RetiroDinero.png"));
		ImageIcon deposito = new ImageIcon(getClass().getResource("/iconos/DepositoDinero.png"));
		ImageIcon cambioMoneda = new ImageIcon(getClass().getResource("/iconos/IntercambioMoneda.png"));
		ImageIcon consultaSaldo = new ImageIcon(getClass().getResource("/iconos/ConsultarSaldo.png"));
		ImageIcon consultaUltimo = new ImageIcon(getClass().getResource("/iconos/ConsultaUltimo.png"));
		ImageIcon consultaMovi = new ImageIcon(getClass().getResource("/iconos/UltimoMovimiento.png"));
		ImageIcon cancelar = new ImageIcon(getClass().getResource("/iconos/salirReporte.png"));
				
		
		separator = new JSeparator();
		separator.setForeground(new Color(255, 255, 255));
		separator.setBounds(164, 157, 694, 2);
		add(separator);
		
		lblTitulo = new JLabel("MENÚ PRINCIPAL");
		lblTitulo.setForeground(new Color(255, 255, 255));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblTitulo.setBounds(226, 94, 540, 40);
		add(lblTitulo);
		
		lblSelecciona = new JLabel("SELECCIONA LA OPERACIÓN A REALIZAR");
		lblSelecciona.setBackground(new Color(255, 255, 255));
		lblSelecciona.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelecciona.setForeground(new Color(255, 255, 255));
		lblSelecciona.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblSelecciona.setBounds(327, 184, 338, 20);
		add(lblSelecciona);
		
		
		btnCambiarClave = new JButton("CAMBIO DE CLAVE");
		btnCambiarClave.addActionListener(this);
		btnCambiarClave.setOpaque(true);
		btnCambiarClave.setForeground(Color.WHITE);
		btnCambiarClave.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnCambiarClave.setFocusPainted(false);
		btnCambiarClave.setContentAreaFilled(false);
		btnCambiarClave.setBackground(new Color(128, 191, 33));
		btnCambiarClave.setBounds(164, 505, 299, 72);
		add(btnCambiarClave);
		btnCambiarClave.setContentAreaFilled(false); 
		btnCambiarClave.setOpaque(true);
		btnCambiarClave.setIcon(clave);
		
		
		
		btnRetiroDeDinero = new JButton("RETIRO DE DINERO");
		btnRetiroDeDinero.addActionListener(this);
		btnRetiroDeDinero.setOpaque(true);
		btnRetiroDeDinero.setForeground(Color.WHITE);
		btnRetiroDeDinero.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnRetiroDeDinero.setFocusPainted(false);
		btnRetiroDeDinero.setContentAreaFilled(false);
		btnRetiroDeDinero.setBackground(new Color(128, 191, 33));
		btnRetiroDeDinero.setBounds(164, 243, 299, 72);
		add(btnRetiroDeDinero);
		btnRetiroDeDinero.setContentAreaFilled(false); 
		btnRetiroDeDinero.setOpaque(true);
		btnRetiroDeDinero.setIcon(retiro);
		
		
		btnDepositoDeDinero = new JButton("DEPOSITO DE DINERO");
		btnDepositoDeDinero.addActionListener(this);
		btnDepositoDeDinero.setOpaque(true);
		btnDepositoDeDinero.setForeground(Color.WHITE);
		btnDepositoDeDinero.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnDepositoDeDinero.setFocusPainted(false);
		btnDepositoDeDinero.setContentAreaFilled(false);
		btnDepositoDeDinero.setBackground(new Color(128, 191, 33));
		btnDepositoDeDinero.setBounds(164, 375, 299, 72);
		add(btnDepositoDeDinero);
		btnDepositoDeDinero.setContentAreaFilled(false); 
		btnDepositoDeDinero.setOpaque(true);
		btnDepositoDeDinero.setIcon(deposito);
		
		
		
		btnCambiarMoneda = new JButton("CAMBIAR MONEDA");
		btnCambiarMoneda.addActionListener(this);
		btnCambiarMoneda.setOpaque(true);
		btnCambiarMoneda.setForeground(Color.WHITE);
		btnCambiarMoneda.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnCambiarMoneda.setFocusPainted(false);
		btnCambiarMoneda.setContentAreaFilled(false);
		btnCambiarMoneda.setBackground(new Color(128, 191, 33));
		btnCambiarMoneda.setBounds(559, 375, 299, 72);
		add(btnCambiarMoneda);
		btnCambiarMoneda.setContentAreaFilled(false); 
		btnCambiarMoneda.setOpaque(true);
		btnCambiarMoneda.setIcon(cambioMoneda);
		
		btnConsultas = new JButton("CONSULTAS");
		btnConsultas.addActionListener(this);
		btnConsultas.setOpaque(true);
		btnConsultas.setForeground(Color.WHITE);
		btnConsultas.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnConsultas.setFocusPainted(false);
		btnConsultas.setContentAreaFilled(false);
		btnConsultas.setBackground(new Color(128, 191, 33));
		btnConsultas.setBounds(559, 243, 299, 72);
		add(btnConsultas);
		btnConsultas.setContentAreaFilled(false); 
		btnConsultas.setOpaque(true);
		btnConsultas.setIcon(consultaUltimo);
		
		btnCancelar = new JButton("SALIR");
		btnCancelar.addActionListener(this);
		btnCancelar.setOpaque(true);
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnCancelar.setFocusPainted(false);
		btnCancelar.setContentAreaFilled(false);
		btnCancelar.setBackground(new Color(96, 125, 139));
		btnCancelar.setBounds(559, 506, 299, 72);
		add(btnCancelar);
		btnCancelar.setContentAreaFilled(false); 
		btnCancelar.setOpaque(true);
		btnCancelar.setIcon(cancelar);
		
		depositarDinero = new DepositoDinero(principal);
		retiro_dinero = new Retiro_dinero(principal);
		
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCambiarClave) {
			ventanaPrincipal.Cambiar_clave();
		}
		if(e.getSource() == btnDepositoDeDinero) {
			//depositarDinero.cargarDatos();
			ventanaPrincipal.Depositar_dinero();
		}
		if(e.getSource() == btnCambiarMoneda) {
			ventanaPrincipal.Cambio_moneda();
		}
		if(e.getSource() == btnRetiroDeDinero) {
			ventanaPrincipal.Retirar_dinero();
		}
		if(e.getSource() == btnConsultas) {
			ventanaPrincipal.Mis_Cuentas();
		}
		if(e.getSource() == btnCancelar) {
			ventanaPrincipal.Panel_inicio();
		}
	}
}

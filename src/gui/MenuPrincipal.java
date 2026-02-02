package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class MenuPrincipal extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JSeparator separator;
	private JLabel lblTitulo;
	private JLabel lblSelecciona;
	private JButton btnCambiarClave;
	private JButton btnRetiroDeDinero;
	private JButton btnDepositoDeDinero;
	private JButton btnCambiarMoneda;
	private JButton btnConsultaDeSaldo;
	private JButton btnltimosMovimientos;
	private JButton btnConsultasDeOperaciones;
	private JButton btnCancelar;

	
	
	/**
	 * Create the panel.
	 */
	public MenuPrincipal() {
		setBackground(new Color(255, 255, 255));
		setPreferredSize(new java.awt.Dimension(1000, 620));
		setLayout(null);
		
		
		ImageIcon clave = new ImageIcon(getClass().getResource("/iconos/CambioClave.png"));//llama la img
		Image imgescalada = clave.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		ImageIcon retiro = new ImageIcon(getClass().getResource("/iconos/RetiroDinero.png"));
		ImageIcon deposito = new ImageIcon(getClass().getResource("/iconos/DepositoDinero.png"));
		ImageIcon cambioMoneda = new ImageIcon(getClass().getResource("/iconos/IntercambioMoneda.png"));
		ImageIcon consultaSaldo = new ImageIcon(getClass().getResource("/iconos/ConsultarSaldo.png"));
		ImageIcon consultaUltimo = new ImageIcon(getClass().getResource("/iconos/ConsultaUltimo.png"));
		ImageIcon consultaMovi = new ImageIcon(getClass().getResource("/iconos/UltimoMovimiento.png"));
		ImageIcon cancelar = new ImageIcon(getClass().getResource("/iconos/x.png"));
				
		
		separator = new JSeparator();
		separator.setBounds(164, 114, 694, 2);
		add(separator);
		
		lblTitulo = new JLabel("MENÚ PRINCIPAL");
		lblTitulo.setForeground(new Color(2, 64, 89));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblTitulo.setBounds(224, 55, 540, 40);
		add(lblTitulo);
		
		lblSelecciona = new JLabel("Selecciona la operación a realizar");
		lblSelecciona.setBackground(new Color(255, 255, 255));
		lblSelecciona.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelecciona.setForeground(new Color(128, 128, 128));
		lblSelecciona.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblSelecciona.setBounds(164, 138, 299, 20);
		add(lblSelecciona);
		
		
		btnCambiarClave = new JButton("Cambio de clave");
		btnCambiarClave.addActionListener(this);
		btnCambiarClave.setOpaque(true);
		btnCambiarClave.setForeground(Color.WHITE);
		btnCambiarClave.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnCambiarClave.setFocusPainted(false);
		btnCambiarClave.setContentAreaFilled(false);
		btnCambiarClave.setBackground(new Color(128, 191, 33));
		btnCambiarClave.setBounds(161, 193, 256, 50);
		add(btnCambiarClave);
		btnCambiarClave.setContentAreaFilled(false); 
		btnCambiarClave.setOpaque(true);
		btnCambiarClave.setIcon(clave); // plasma icono en el boton
		
		
		
		btnRetiroDeDinero = new JButton("Retiro de dinero");
		btnRetiroDeDinero.setOpaque(true);
		btnRetiroDeDinero.setForeground(Color.WHITE);
		btnRetiroDeDinero.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnRetiroDeDinero.setFocusPainted(false);
		btnRetiroDeDinero.setContentAreaFilled(false);
		btnRetiroDeDinero.setBackground(new Color(128, 191, 33));
		btnRetiroDeDinero.setBounds(164, 276, 256, 50);
		add(btnRetiroDeDinero);
		btnRetiroDeDinero.setContentAreaFilled(false); 
		btnRetiroDeDinero.setOpaque(true);
		btnRetiroDeDinero.setIcon(retiro);
		
		
		btnDepositoDeDinero = new JButton("Deposito de dinero");
		btnDepositoDeDinero.setOpaque(true);
		btnDepositoDeDinero.setForeground(Color.WHITE);
		btnDepositoDeDinero.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnDepositoDeDinero.setFocusPainted(false);
		btnDepositoDeDinero.setContentAreaFilled(false);
		btnDepositoDeDinero.setBackground(new Color(128, 191, 33));
		btnDepositoDeDinero.setBounds(164, 354, 256, 50);
		add(btnDepositoDeDinero);
		btnDepositoDeDinero.setContentAreaFilled(false); 
		btnDepositoDeDinero.setOpaque(true);
		btnDepositoDeDinero.setIcon(deposito);
		
		
		
		btnCambiarMoneda = new JButton("Cambiar moneda");
		btnCambiarMoneda.setOpaque(true);
		btnCambiarMoneda.setForeground(Color.WHITE);
		btnCambiarMoneda.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnCambiarMoneda.setFocusPainted(false);
		btnCambiarMoneda.setContentAreaFilled(false);
		btnCambiarMoneda.setBackground(new Color(128, 191, 33));
		btnCambiarMoneda.setBounds(164, 436, 256, 50);
		add(btnCambiarMoneda);
		btnCambiarMoneda.setContentAreaFilled(false); 
		btnCambiarMoneda.setOpaque(true);
		btnCambiarMoneda.setIcon(cambioMoneda);
		
		btnConsultaDeSaldo = new JButton("Consulta de saldo");
		btnConsultaDeSaldo.setOpaque(true);
		btnConsultaDeSaldo.setForeground(Color.WHITE);
		btnConsultaDeSaldo.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnConsultaDeSaldo.setFocusPainted(false);
		btnConsultaDeSaldo.setContentAreaFilled(false);
		btnConsultaDeSaldo.setBackground(new Color(128, 191, 33));
		btnConsultaDeSaldo.setBounds(559, 193, 299, 50);
		add(btnConsultaDeSaldo);
		btnConsultaDeSaldo.setContentAreaFilled(false); 
		btnConsultaDeSaldo.setOpaque(true);
		btnConsultaDeSaldo.setIcon(consultaSaldo);
		
		btnltimosMovimientos = new JButton("Últimos movimientos");
		btnltimosMovimientos.setOpaque(true);
		btnltimosMovimientos.setForeground(Color.WHITE);
		btnltimosMovimientos.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnltimosMovimientos.setFocusPainted(false);
		btnltimosMovimientos.setContentAreaFilled(false);
		btnltimosMovimientos.setBackground(new Color(128, 191, 33));
		btnltimosMovimientos.setBounds(559, 276, 299, 50);
		add(btnltimosMovimientos);
		btnltimosMovimientos.setContentAreaFilled(false); 
		btnltimosMovimientos.setOpaque(true);
		btnltimosMovimientos.setIcon(consultaUltimo);
		
		
		
		
		btnConsultasDeOperaciones = new JButton("Consultas de operaciones");
		btnConsultasDeOperaciones.setOpaque(true);
		btnConsultasDeOperaciones.setForeground(Color.WHITE);
		btnConsultasDeOperaciones.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnConsultasDeOperaciones.setFocusPainted(false);
		btnConsultasDeOperaciones.setContentAreaFilled(false);
		btnConsultasDeOperaciones.setBackground(new Color(128, 191, 33));
		btnConsultasDeOperaciones.setBounds(559, 354, 299, 50);
		add(btnConsultasDeOperaciones);
		btnConsultasDeOperaciones.setContentAreaFilled(false); 
		btnConsultasDeOperaciones.setOpaque(true);
		btnConsultasDeOperaciones.setIcon(consultaMovi);
		
		btnCancelar = new JButton("CANCELAR");
		btnCancelar.setOpaque(true);
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnCancelar.setFocusPainted(false);
		btnCancelar.setContentAreaFilled(false);
		btnCancelar.setBackground(new Color(3, 120, 166));
		btnCancelar.setBounds(559, 436, 299, 50);
		add(btnCancelar);
		btnCancelar.setContentAreaFilled(false); 
		btnCancelar.setOpaque(true);
		btnCancelar.setIcon(cancelar);

	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCambiarClave) {
			actionPerformedBtnCambiarClave(e);
		}
	}
	protected void actionPerformedBtnCambiarClave(ActionEvent e) {
	}
}

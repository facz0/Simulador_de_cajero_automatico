package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;

public class MenuMantenimiento extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	private VentanaPrincipal ventanaPrincipal;
	private JLabel lblNewLabel;
	private JButton btnCuenta;
	private JButton btnCliente;
	private JButton btnMoneda;
	private JButton btnSalir;
	/**
	 * Create the panel.
	 */
	public MenuMantenimiento(VentanaPrincipal principal) {
		setBackground(new Color(2, 64, 89));
		this.ventanaPrincipal = principal;
		setPreferredSize(new java.awt.Dimension(1000, 620));
		setLayout(null);
		
		ImageIcon usuario = new ImageIcon(getClass().getResource("/iconos/usuarioReporte.png"));
        ImageIcon moneda = new ImageIcon(getClass().getResource("/iconos/monedas.png"));
        ImageIcon cuentaBanco = new ImageIcon(getClass().getResource("/iconos/cuentaBancaria.png"));
        ImageIcon salir = new ImageIcon(getClass().getResource("/iconos/salirReporte.png"));
        ImageIcon mantenimiento = new ImageIcon(getClass().getResource("/iconos/llave.png"));
		
		lblNewLabel = new JLabel("MANTENIMIENTO");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewLabel.setBounds(307, 35, 400, 75);
		lblNewLabel.setIcon(mantenimiento);
		add(lblNewLabel);
		
		btnCuenta = new JButton("CUENTAS BANCARIAS");
		btnCuenta.addActionListener(this);
		btnCuenta.setForeground(new Color(255, 255, 255));
		btnCuenta.setFont(new Font("Tahoma", Font.BOLD, 21));
		btnCuenta.setBackground(new Color(128, 191, 33));
		btnCuenta.setContentAreaFilled(false); 
		btnCuenta.setOpaque(true);
		btnCuenta.setBounds(307, 151, 400, 75);
		btnCuenta.setIcon(cuentaBanco);
		add(btnCuenta);
		
		btnCliente = new JButton("CLIENTE");
		btnCliente.addActionListener(this);
		btnCliente.setForeground(new Color(255, 255, 255));
		btnCliente.setFont(new Font("Tahoma", Font.BOLD, 21));
		btnCliente.setBackground(new Color(128, 191, 33));
		btnCliente.setContentAreaFilled(false); 
		btnCliente.setOpaque(true);
		btnCliente.setBounds(307, 391, 400, 75);
		btnCliente.setIcon(usuario);
		add(btnCliente);
		
		btnMoneda = new JButton("MONEDA");
		btnMoneda.addActionListener(this);
		btnMoneda.setForeground(new Color(255, 255, 255));
		btnMoneda.setFont(new Font("Tahoma", Font.BOLD, 21));
		btnMoneda.setBackground(new Color(128, 191, 33));
		btnMoneda.setContentAreaFilled(false); 
		btnMoneda.setOpaque(true);
		btnMoneda.setBounds(307, 273, 400, 75);
		btnMoneda.setIcon(moneda);
		add(btnMoneda);
		
		btnSalir = new JButton("SALIR");
		btnSalir.addActionListener(this);
		btnSalir.setForeground(new Color(255, 255, 255));
		btnSalir.setFont(new Font("Tahoma", Font.BOLD, 21));
		btnSalir.setBackground(new Color(96, 125, 139));
		btnSalir.setContentAreaFilled(false); 
		btnSalir.setOpaque(true);
		btnSalir.setBounds(307, 510, 400, 75);
		btnSalir.setIcon(salir);
		add(btnSalir);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btnCuenta) {
			ventanaPrincipal.Mantenimiento_cuenta_bancaria();
		}
		if(e.getSource()==btnCliente) {
			ventanaPrincipal.Mantenimiento_cliente();
		}
		if(e.getSource()==btnMoneda) {
			ventanaPrincipal.Mantenimiento_Moneda();
		}
		if(e.getSource()==btnSalir) {
			ventanaPrincipal.Panel_inicio();
		}
	}

}

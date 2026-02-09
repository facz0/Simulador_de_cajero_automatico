package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MenuMantenimiento extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	private VentanaPrincipal ventanaPrincipal;
	private JLabel lblNewLabel;
	private JButton btnCuenta;
	private JButton btnCliente;
	private JButton btnTipoTransaccion;
	private JButton btnMoneda;
	private JButton btnTipoCambio;
	private JButton btnSalir;
	/**
	 * Create the panel.
	 */
	public MenuMantenimiento(VentanaPrincipal principal) {
		setBackground(new Color(255, 255, 255));
		this.ventanaPrincipal = principal;
		setPreferredSize(new java.awt.Dimension(1000, 620));
		setLayout(null);
		
		lblNewLabel = new JLabel("MANTENIMIENTO");
		lblNewLabel.setForeground(new Color(2, 64, 89));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewLabel.setBounds(320, 23, 368, 75);
		add(lblNewLabel);
		
		btnCuenta = new JButton("CUENTAS BANCARIAS");
		btnCuenta.addActionListener(this);
		btnCuenta.setForeground(new Color(255, 255, 255));
		btnCuenta.setFont(new Font("Tahoma", Font.BOLD, 21));
		btnCuenta.setBackground(new Color(128, 191, 33));
		btnCuenta.setContentAreaFilled(false); 
		btnCuenta.setOpaque(true);
		btnCuenta.setBounds(35, 198, 400, 75);
		add(btnCuenta);
		
		btnCliente = new JButton("CLIENTE");
		btnCliente.addActionListener(this);
		btnCliente.setForeground(new Color(255, 255, 255));
		btnCliente.setFont(new Font("Tahoma", Font.BOLD, 21));
		btnCliente.setBackground(new Color(128, 191, 33));
		btnCliente.setContentAreaFilled(false); 
		btnCliente.setOpaque(true);
		btnCliente.setBounds(35, 304, 400, 75);
		add(btnCliente);
		
		btnTipoTransaccion = new JButton("TIPO DE TRANSACCION");
		btnTipoTransaccion.addActionListener(this);
		btnTipoTransaccion.setForeground(new Color(255, 255, 255));
		btnTipoTransaccion.setFont(new Font("Tahoma", Font.BOLD, 21));
		btnTipoTransaccion.setBackground(new Color(128, 191, 33));
		btnTipoTransaccion.setContentAreaFilled(false); 
		btnTipoTransaccion.setOpaque(true);
		btnTipoTransaccion.setBounds(35, 414, 400, 75);
		add(btnTipoTransaccion);
		
		btnMoneda = new JButton("MONEDA");
		btnMoneda.addActionListener(this);
		btnMoneda.setForeground(new Color(255, 255, 255));
		btnMoneda.setFont(new Font("Tahoma", Font.BOLD, 21));
		btnMoneda.setBackground(new Color(128, 191, 33));
		btnMoneda.setContentAreaFilled(false); 
		btnMoneda.setOpaque(true);
		btnMoneda.setBounds(563, 198, 400, 75);
		add(btnMoneda);
		
		btnTipoCambio = new JButton("TIPO DE CAMBIO ");
		btnTipoCambio.addActionListener(this);
		btnTipoCambio.setForeground(new Color(255, 255, 255));
		btnTipoCambio.setFont(new Font("Tahoma", Font.BOLD, 21));
		btnTipoCambio.setBackground(new Color(128, 191,33));
		btnTipoCambio.setContentAreaFilled(false); 
		btnTipoCambio.setOpaque(true);
		btnTipoCambio.setBounds(563, 304, 400, 75);
		add(btnTipoCambio);
		
		btnSalir = new JButton("SALIR");
		btnSalir.addActionListener(this);
		btnSalir.setForeground(new Color(255, 255, 255));
		btnSalir.setFont(new Font("Tahoma", Font.BOLD, 21));
		btnSalir.setBackground(new Color(2, 64, 89));
		btnSalir.setContentAreaFilled(false); 
		btnSalir.setOpaque(true);
		btnSalir.setBounds(563, 414, 400, 75);
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
		if(e.getSource()==btnTipoTransaccion) {
			ventanaPrincipal.Mantenimiento_tipo_transaccion();
		}
		if(e.getSource()==btnMoneda) {
			ventanaPrincipal.Mantenimiento_Moneda();
		}
		if(e.getSource()==btnTipoCambio) {
			ventanaPrincipal.Mantenimiento_Tipo_de_cambio();
		}
		if(e.getSource()==btnSalir) {
			ventanaPrincipal.Panel_inicio();
		}
	}

}

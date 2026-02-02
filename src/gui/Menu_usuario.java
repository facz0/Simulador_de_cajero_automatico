package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSplitPane;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

public class Menu_usuario extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	private VentanaPrincipal ventanaPrincipal;

	/**
	 * Create the panel.
	 */
	public Menu_usuario(VentanaPrincipal principal) {
		setBackground(new Color(3, 120, 166));
		this.ventanaPrincipal = principal;
		setPreferredSize(new java.awt.Dimension(1000, 620));
		setLayout(null);
		
		JButton btnRetiro = new JButton("");
		btnRetiro.setBounds(67, 345, 85, 85);
		add(btnRetiro);
		
		JButton btnDeposito = new JButton("");
		btnDeposito.setBounds(858, 197, 85, 85);
		add(btnDeposito);
		
		JButton btnCambio = new JButton("");
		btnCambio.addActionListener(this);
		btnCambio.setBounds(858, 345, 85, 85);
		add(btnCambio);
		
		JButton btnCambioClave = new JButton("");
		btnCambioClave.setBounds(67, 197, 85, 85);
		add(btnCambioClave);
		
		JLabel lblNewLabel = new JLabel("Cambio de clave");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblNewLabel.setBounds(177, 197, 298, 85);
		add(lblNewLabel);
		
		JLabel lblRetiroDeDinero = new JLabel("Retiro de dinero");
		lblRetiroDeDinero.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblRetiroDeDinero.setBounds(177, 345, 248, 85);
		add(lblRetiroDeDinero);
		
		JLabel lblDepsitoDeDinero = new JLabel("Depósito de dinero");
		lblDepsitoDeDinero.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblDepsitoDeDinero.setBounds(550, 197, 298, 85);
		add(lblDepsitoDeDinero);
		
		JLabel lblCambioDeMoneda = new JLabel("Cambio de moneda");
		lblCambioDeMoneda.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblCambioDeMoneda.setBounds(550, 345, 311, 85);
		add(lblCambioDeMoneda);
		
		JLabel lblNewLabel_1 = new JLabel("ELIJA UNA OPERACIÓN ->");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_1.setBounds(53, 58, 591, 85);
		add(lblNewLabel_1);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(507, 187, 21, 243);
		add(separator);
		
		JButton btnNewButton = new JButton("<- SALIR ");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(67, 517, 126, 46);
		add(btnNewButton);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	
	}
}

package gui;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class buscarCliente extends JPanel {

	private static final long serialVersionUID = 1L;
	private VentanaPrincipal ventanaPrincipal;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField textField;
	private JLabel lblNewLabel_2;
	private JButton btnBuscar;
	private JPanel panel;
	private JButton btnNewButton;
	private JButton btnAtras;
	

	/**
	 * Create the panel.
	 */
	public buscarCliente(VentanaPrincipal principal) {
		this.ventanaPrincipal = principal;
		setPreferredSize(new java.awt.Dimension(1000, 620));
		setLayout(null);
		
		lblNewLabel = new JLabel("CONSULTAS Y BUSQUEDAS ");
		lblNewLabel.setBounds(393, 28, 183, 14);
		add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("BUSCAR CLIENTE");
		lblNewLabel_1.setBounds(345, 64, 118, 25);
		add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(480, 104, 118, 20);
		add(textField);
		textField.setColumns(10);
		
		lblNewLabel_2 = new JLabel("DNI O C.E.");
		lblNewLabel_2.setBounds(345, 107, 76, 14);
		add(lblNewLabel_2);
		
		btnBuscar = new JButton("BUSCAR");
		btnBuscar.setBounds(509, 65, 89, 23);
		add(btnBuscar);
		
		panel = new JPanel();
		panel.setBounds(10, 147, 969, 392);
		add(panel);
		setLayout(null);
		
		btnAtras = new JButton("REGRESAR");
		btnAtras.setBounds(890, 557, 89, 23);
		add(btnAtras);

	}

}

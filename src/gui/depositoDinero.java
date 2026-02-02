package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;


public class depositoDinero extends JPanel {
	private VentanaPrincipal ventanaPrincipal;	
	
	

	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JTextField textField;
	private JTextField textField_1;
	private JButton btnDespositar;

	/**
	 * Create the panel.
	 */
	public depositoDinero(VentanaPrincipal principal) {
		setLayout(null);
		this.ventanaPrincipal = principal;
		setPreferredSize(new java.awt.Dimension(1280, 720));
		setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(44, 62, 499, 513);
		add(panel);
		panel.setLayout(null);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(287, 5, 46, 14);
		panel.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Número de cuenta:");
		lblNewLabel_1.setBounds(94, 146, 143, 28);
		panel.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(53, 264, 46, 0);
		panel.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Ingrese monto a depositar:");
		lblNewLabel_3.setBounds(94, 234, 193, 20);
		panel.add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBounds(94, 185, 193, 28);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(94, 267, 193, 28);
		textField_1.setColumns(10);
		panel.add(textField_1);
		
		btnDespositar = new JButton("Depositar");
		btnDespositar.setBounds(148, 376, 89, 23);
		panel.add(btnDespositar);

	}
}

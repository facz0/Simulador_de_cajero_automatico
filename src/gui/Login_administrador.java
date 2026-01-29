package gui;

import javax.swing.JPanel;
import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Login_administrador extends JPanel {

	private static final long serialVersionUID = 1L;
	private VentanaPrincipal ventanaPrincipal;
	private JTextField textField;
	private JTextField textField_1;
	/**
	 * Create the panel.
	 * @param ventanaPrincipal 
	 */
	public Login_administrador(VentanaPrincipal principal) {
		this.ventanaPrincipal = principal;
		setPreferredSize(new java.awt.Dimension(1280, 720));
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(488, 113, 453, 525);
		add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Ingresar");
		btnNewButton.setBounds(159, 293, 89, 23);
		panel.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(85, 239, 203, 23);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("password");
		lblNewLabel.setBounds(85, 206, 118, 23);
		panel.add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setBounds(85, 172, 203, 23);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("DNI");
		lblNewLabel_1.setBounds(85, 130, 61, 14);
		panel.add(lblNewLabel_1);

	}
}

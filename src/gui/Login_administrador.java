package gui;

import javax.swing.JPanel;
import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class Login_administrador extends JPanel implements ActionListener{
	private static final long serialVersionUID = 1L;
	private VentanaPrincipal ventanaPrincipal;
	private JTextField txtAdminDni;
	private JPasswordField passwordAdmin;
	private JButton btnVolver;
	private JButton btnIngresarLoginAdmin;
	/**
	 * Create the panel.
	 * @param ventanaPrincipal 
	 */
	public Login_administrador(VentanaPrincipal principal) {
		this.ventanaPrincipal = principal;
		setPreferredSize(new java.awt.Dimension(1000, 620));
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(2, 64, 89));
		panel.setBounds(240, 74, 556, 491);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblIngresaTusCredenciales = new JLabel("Ingresa tus credenciales para iniciar sesión");
		lblIngresaTusCredenciales.setForeground(new Color(255, 255, 255));
		lblIngresaTusCredenciales.setBounds(80, 44, 391, 29);
		panel.add(lblIngresaTusCredenciales);
		lblIngresaTusCredenciales.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblDni = new JLabel("DNI:");
		lblDni.setForeground(new Color(255, 255, 255));
		lblDni.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDni.setBounds(187, 142, 93, 13);
		panel.add(lblDni);
		
		txtAdminDni = new JTextField();
		txtAdminDni.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtAdminDni.setBounds(185, 171, 210, 29);
		panel.add(txtAdminDni);
		txtAdminDni.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Password:");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(185, 241, 116, 29);
		panel.add(lblNewLabel);
		
		passwordAdmin = new JPasswordField();
		passwordAdmin.setBounds(185, 281, 210, 29);
		panel.add(passwordAdmin);
		
		btnIngresarLoginAdmin = new JButton("Ingresar");
		btnIngresarLoginAdmin.setForeground(new Color(255, 255, 255));
		btnIngresarLoginAdmin.setBackground(new Color(128, 191, 33));
		btnIngresarLoginAdmin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnIngresarLoginAdmin.setBounds(231, 367, 116, 36);
		panel.add(btnIngresarLoginAdmin);
		btnIngresarLoginAdmin.setContentAreaFilled(false); 
		btnIngresarLoginAdmin.setOpaque(true);
		
		btnVolver = new JButton("< Volver");
		btnVolver.setForeground(new Color(255, 255, 255));
		btnVolver.setBackground(new Color(128, 191, 33));
		btnVolver.addActionListener(this);
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnVolver.setBounds(10, 11, 97, 35);
		add(btnVolver);
		btnVolver.setContentAreaFilled(false); 
		btnVolver.setOpaque(true);
		

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == btnVolver) {
	        ventanaPrincipal.Panel_inicio();
	    }
	}
}






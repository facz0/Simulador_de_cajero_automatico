package mantenimiento;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Component;
import javax.swing.Box;
import java.awt.Font;
import javax.swing.JTextField;

import servicio.UsuarioService;

import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class CrearUsuario extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JTextField txtNombre;
	private JTextField txtDNI;
	private JPasswordField txtClave;
	private JButton btnCrear;

	/**
	 * Create the panel.
	 */
	public CrearUsuario() {
		setBackground(new Color(255, 255, 255));
		setPreferredSize(new java.awt.Dimension(612, 455));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("DNI :");
		lblNewLabel.setForeground(new Color(2, 64, 89));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNewLabel.setBounds(42, 90, 78, 31);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre y apellido :");
		lblNewLabel_1.setForeground(new Color(2, 64, 89));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNewLabel_1.setBounds(42, 182, 246, 31);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Clave de 4 dígitos");
		lblNewLabel_2.setForeground(new Color(2, 64, 89));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNewLabel_2.setBounds(42, 271, 224, 31);
		add(lblNewLabel_2);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 19));
		txtNombre.setBounds(279, 184, 279, 30);
		add(txtNombre);
		txtNombre.setColumns(10);
		
		txtDNI = new JTextField();
		txtDNI.setFont(new Font("Tahoma", Font.PLAIN, 19));
		txtDNI.setBounds(279, 91, 279, 30);
		add(txtDNI);
		txtDNI.setColumns(10);
		
		txtClave = new JPasswordField();
		txtClave.setFont(new Font("Tahoma", Font.PLAIN, 19));
		txtClave.setBounds(279, 271, 279, 30);
		add(txtClave);
		
		btnCrear = new JButton("CREAR");
		btnCrear.addActionListener(this);
		btnCrear.setBackground(new Color(128, 191, 33));
		btnCrear.setForeground(new Color(255, 255, 255));
		btnCrear.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCrear.setBounds(438, 376, 120, 40);
		add(btnCrear);
		btnCrear.setContentAreaFilled(false); 
		btnCrear.setOpaque(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == btnCrear) {
			actionPerformedbtnCrear(e);
		}
	}
	
	public void actionPerformedbtnCrear(ActionEvent e) {
		
		String dni = txtDNI.getText().strip();
		String nombre = txtNombre.getText().strip();
		char[] claveChar = txtClave.getPassword();
		String clave = new String(claveChar).strip();
		java.util.Arrays.fill(claveChar, '0');
		
		if(!dni.matches("[0-9]{8}")) {
			JOptionPane.showMessageDialog(this, "El DNI debe tener 8 números.", "Error en DNI", JOptionPane.INFORMATION_MESSAGE);
			return; 
		}
		
		if(!nombre.matches("[a-zA-Z ]+")) {
			JOptionPane.showMessageDialog(this, "El nombre solo puede tener letras.", "Error en nombre", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		
		if(!clave.matches("[0-9]{4}")) {
			JOptionPane.showMessageDialog(this, "La clave solo puede tener 4 dígitos", "Error en clave", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		
		try {
			
			UsuarioService usuario = new UsuarioService();
			usuario.crearUsuario(dni, nombre, clave);
			JOptionPane.showMessageDialog(this, "Cliente registrado exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
			limpiarCampos();
			
		} catch (Exception err) {
			JOptionPane.showMessageDialog(this, err.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void limpiarCampos() {
		this.txtClave.setText("");
		this.txtDNI.setText("");
		this.txtNombre.setText("");
	}
}

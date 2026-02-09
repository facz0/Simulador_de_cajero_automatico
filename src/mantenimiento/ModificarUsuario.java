package mantenimiento;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import datos.AlmacenDatos;
import modelos.Usuario;
import servicio.UsuarioService;

import javax.swing.JButton;
import javax.swing.JComboBox;

public class ModificarUsuario extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JTextField txtNombre;
	private JPasswordField txtClave;
	private JButton btnModificar;
	private JComboBox<String> comboBox;
	
	/**
	 * Create the panel.
	 */
	public ModificarUsuario() {
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
		
		comboBox = new JComboBox();
		comboBox.setBounds(279, 91, 279, 30);
		comboBox.setMaximumRowCount(5);
		for(int i = 0; i < AlmacenDatos.listaUsuarios.size(); i++) {
			Usuario user = AlmacenDatos.listaUsuarios.get(i);
			comboBox.addItem(user.getDNI());
		}
		add(comboBox);
		comboBox.addActionListener(this);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 19));
		txtNombre.setBounds(279, 184, 279, 30);
		add(txtNombre);
		txtNombre.setColumns(10);
		
		txtClave = new JPasswordField();
		txtClave.setFont(new Font("Tahoma", Font.PLAIN, 19));
		txtClave.setBounds(279, 271, 279, 30);
		add(txtClave);
		
		btnModificar = new JButton("MODIFICAR");
		btnModificar.addActionListener(this);
		btnModificar.setBackground(new Color(128, 191, 33));
		btnModificar.setForeground(new Color(255, 255, 255));
		btnModificar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnModificar.setBounds(423, 376, 135, 40);
		add(btnModificar);
		btnModificar.setContentAreaFilled(false); 
		btnModificar.setOpaque(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == btnModificar) {
			actionPerformedbtnModificar(e);
		}
		if(e.getSource() == comboBox) {
			comboActionPerformed(e);
		}
	}
	
	private void comboActionPerformed(ActionEvent e) {
		String dniSelect = (String) comboBox.getSelectedItem();
		Usuario user = AlmacenDatos.clientePorDni(dniSelect);
		if(user != null) {
			txtNombre.setText(user.getNombre());
			txtClave.setText("");
		}
	}
	
	public void actionPerformedbtnModificar(ActionEvent e) {
		String dni = (String) comboBox.getSelectedItem();
		String nombre = txtNombre.getText().strip();
		String clave = new String(txtClave.getPassword()).strip();
		
		if(dni == null) {
			JOptionPane.showMessageDialog(this, "Debe seleccionar un usuario.");
			return;
		}
		
		if(!nombre.matches("[a-zA-Z ]+")) {
			JOptionPane.showMessageDialog(this, "El nombre solo debe contener letras.");
			return;
		}
		
		if(!clave.isEmpty() && !clave.matches("[0-9]{4}")) {
			JOptionPane.showMessageDialog(this, "La clave solo debe tener 4 dígitos.");
			return;
		}
		
		try {
			UsuarioService user = new UsuarioService();
			user.modificarUsuario(dni, nombre, clave);
			JOptionPane.showMessageDialog(this, "Datos actualizados correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception err) {
			JOptionPane.showMessageDialog(this, err.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	

}

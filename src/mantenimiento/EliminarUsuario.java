package mantenimiento;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import datos.AlmacenDatos;
import modelos.Usuario;
import servicio.UsuarioService;

public class EliminarUsuario extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JComboBox comboBox;
	private JTextField txtNombre;
	private JButton btnEliminar;

	/**
	 * Create the panel.
	 */
	public EliminarUsuario() {
		setBackground(new Color(255, 255, 255));
		setPreferredSize(new java.awt.Dimension(612, 455));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("DNI :");
		lblNewLabel.setForeground(new Color(2, 64, 89));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNewLabel.setBounds(107, 91, 78, 31);
		add(lblNewLabel);
		
		comboBox = new JComboBox();
		comboBox.setBounds(223, 92, 279, 30);
		comboBox.setMaximumRowCount(5);
		for(int i = 0; i < AlmacenDatos.listaUsuarios.size(); i++) {
			Usuario user = AlmacenDatos.listaUsuarios.get(i);
			comboBox.addItem(user.getDNI());
		}
		add(comboBox);
		comboBox.addActionListener(this);
		
		txtNombre = new JTextField();
		txtNombre.setEditable(false);
		txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 19));
		txtNombre.setBounds(80, 184, 451, 30);
		add(txtNombre);
		txtNombre.setColumns(10);
		
		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.addActionListener(this);
		btnEliminar.setBackground(new Color(128, 191, 33));
		btnEliminar.setForeground(new Color(255, 255, 255));
		btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnEliminar.setBounds(235, 273, 120, 40);
		add(btnEliminar);
		btnEliminar.setContentAreaFilled(false); 
		btnEliminar.setOpaque(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == btnEliminar) {
			actionPerformedbtnEliminar(e);
		}
	}
	
	private void comboActionPerformed(ActionEvent e) {
		String dniSelect = (String) comboBox.getSelectedItem();
		Usuario user = AlmacenDatos.clientePorDni(dniSelect);
		if(user != null) {
			txtNombre.setText(user.getNombre());
		}
	}
	
	private void actionPerformedbtnEliminar(ActionEvent e) {
		
		String dni = (String) comboBox.getSelectedItem();
		
		if(dni == null) {
			JOptionPane.showMessageDialog(this, "Selecciones un usuario para eliminar");
			return;
		}
		
		try {
			
			UsuarioService user = new UsuarioService();
			user.EliminarUsuario(dni);
			JOptionPane.showMessageDialog(this, "Usuario Eliminado correctamente");
			txtNombre.setText("");
			
			if(comboBox.getItemCount() == 0) {txtNombre.setText("");}
			
			
		} catch (Exception err){
			JOptionPane.showMessageDialog(this, err.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
		
	}

}

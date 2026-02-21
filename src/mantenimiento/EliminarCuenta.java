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
import modelos.Cuenta;
import servicio.CuentaService;

public class EliminarCuenta extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JComboBox comboBoxNcuenta;
	private JTextField txtUsuario;
	private JButton btnEliminar;

	/**
	 * Create the panel.
	 */
	public EliminarCuenta() {
		setBackground(new Color(255, 255, 255));
		setPreferredSize(new java.awt.Dimension(612, 455));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Número de cuenta :");
		lblNewLabel.setForeground(new Color(2, 64, 89));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNewLabel.setBounds(42, 91, 224, 31);
		add(lblNewLabel);
		
		comboBoxNcuenta = new JComboBox();
		comboBoxNcuenta.setBounds(276, 91, 279, 30);
		comboBoxNcuenta.setMaximumRowCount(5);
		for(int i = 0; i < AlmacenDatos.listaCuentas.size(); i++) {
			Cuenta cuenta = AlmacenDatos.listaCuentas.get(i);
			comboBoxNcuenta.addItem(cuenta.getNumeroCuenta());
		}
		add(comboBoxNcuenta);
		comboBoxNcuenta.addActionListener(this);
		
		txtUsuario = new JTextField();
		txtUsuario.setEditable(false);
		txtUsuario.setFont(new Font("Tahoma", Font.PLAIN, 19));
		txtUsuario.setBounds(96, 166, 429, 30);
		add(txtUsuario);
		txtUsuario.setColumns(10);
		
		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.addActionListener(this);
		btnEliminar.setBackground(new Color(128, 191, 33));
		btnEliminar.setForeground(new Color(255, 255, 255));
		btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnEliminar.setBounds(206, 254, 181, 40);
		add(btnEliminar);
		btnEliminar.setContentAreaFilled(false); 
		btnEliminar.setOpaque(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == comboBoxNcuenta) {
			comboBoxNcuentaActionPerformed(e);
		}
		if(e.getSource() == btnEliminar) {
			actualizar();
			actionPerformedbtnEliminar(e);
		}
		
	}
	
	private void comboBoxNcuentaActionPerformed(ActionEvent e) {
		String cuentaSelect = (String) comboBoxNcuenta.getSelectedItem();
		Cuenta cuenta = AlmacenDatos.cuentaPorNumero(cuentaSelect);
		if(cuenta != null) {
			this.txtUsuario.setText(cuenta.getUsuario().getNombre());
		}
	}
	
	private void actionPerformedbtnEliminar(ActionEvent e) {
		String numeroCuenta = (String) comboBoxNcuenta.getSelectedItem();
		
		if(numeroCuenta == null) {
			JOptionPane.showMessageDialog(this, "Por favor, seleccione una cuenta.");
			return;
		}
		
		try {
			CuentaService cuenta = new CuentaService(); 
			cuenta.EliminarCuenta(numeroCuenta);
			JOptionPane.showMessageDialog(this, "Cuenta eliminada correctamente");
			if(comboBoxNcuenta.getItemCount() == 0) {txtUsuario.setText("");}
		} catch (Exception err) {
			JOptionPane.showMessageDialog(this, err.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void actualizar() {
		comboBoxNcuenta.removeAllItems();
		for(int i = 0; i < AlmacenDatos.listaCuentas.size(); i++) {
			Cuenta cuenta = AlmacenDatos.listaCuentas.get(i);
			comboBoxNcuenta.addItem(cuenta.getNumeroCuenta());
		}
		this.txtUsuario.setText("");
	}

}

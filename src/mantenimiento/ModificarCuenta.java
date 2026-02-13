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

public class ModificarCuenta extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JComboBox comboBoxNcuenta;
	private JTextField txtUsuario;
	private JTextField txtMoneda;
	private JTextField txtSaldo;
	private JComboBox comboBoxEstado;
	private JButton btnModificar;

	/**
	 * Create the panel.
	 */
	public ModificarCuenta() {
		setBackground(new Color(255, 255, 255));
		setPreferredSize(new java.awt.Dimension(612, 455));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Número de cuenta :");
		lblNewLabel.setForeground(new Color(2, 64, 89));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNewLabel.setBounds(40, 38, 224, 31);
		add(lblNewLabel);
		
		comboBoxNcuenta = new JComboBox();
		comboBoxNcuenta.setBounds(274, 39, 279, 30);
		comboBoxNcuenta.setMaximumRowCount(5);
		for(int i = 0; i < AlmacenDatos.listaCuentas.size(); i++) {
			Cuenta cuenta = AlmacenDatos.listaCuentas.get(i);
			comboBoxNcuenta.addItem(cuenta.getNumeroCuenta());
		}
		add(comboBoxNcuenta);
		comboBoxNcuenta.addActionListener(this);
		
		JLabel lblUsuario = new JLabel("Usuario :");
		lblUsuario.setForeground(new Color(2, 64, 89));
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblUsuario.setBounds(40, 108, 209, 31);
		add(lblUsuario);
		
		txtUsuario = new JTextField();
		txtUsuario.setFont(new Font("Tahoma", Font.PLAIN, 19));
		txtUsuario.setEnabled(false);
		txtUsuario.setBounds(274, 110, 279, 30);
		add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblMonoeda = new JLabel("Moneda :");
		lblMonoeda.setForeground(new Color(2, 64, 89));
		lblMonoeda.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblMonoeda.setBounds(40, 183, 209, 31);
		add(lblMonoeda);
		
		txtMoneda = new JTextField();
		txtMoneda.setFont(new Font("Tahoma", Font.PLAIN, 19));
		txtMoneda.setEnabled(false);
		txtMoneda.setColumns(10);
		txtMoneda.setBounds(274, 185, 279, 30);
		add(txtMoneda);
		
		JLabel lblSaldo = new JLabel("Saldo :");
		lblSaldo.setForeground(new Color(2, 64, 89));
		lblSaldo.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblSaldo.setBounds(40, 258, 209, 31);
		add(lblSaldo);
		
		txtSaldo = new JTextField();
		txtSaldo.setFont(new Font("Tahoma", Font.PLAIN, 19));
		txtSaldo.setColumns(10);
		txtSaldo.setBounds(274, 259, 279, 30);
		add(txtSaldo);
		
		JLabel lblEstado = new JLabel("Estado :");
		lblEstado.setForeground(new Color(2, 64, 89));
		lblEstado.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblEstado.setBounds(40, 319, 209, 31);
		add(lblEstado);
		
		comboBoxEstado = new JComboBox();
		comboBoxEstado.setMaximumRowCount(5);
		comboBoxEstado.setBounds(274, 324, 279, 30);
		comboBoxEstado.addItem("ACTIVO");
		comboBoxEstado.addItem("INACTIVO");
		add(comboBoxEstado);
		
		btnModificar = new JButton("MODIFICAR");
		btnModificar.addActionListener(this);
		btnModificar.setBackground(new Color(128, 191, 33));
		btnModificar.setForeground(new Color(255, 255, 255));
		btnModificar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnModificar.setBounds(377, 383, 181, 40);
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
		if(e.getSource() == comboBoxNcuenta) {
			comboNcuentaActionPerformed(e);
		}
		
	}
	
	public void comboNcuentaActionPerformed(ActionEvent e) {
		String cuentaSelect = (String) comboBoxNcuenta.getSelectedItem();
		Cuenta cuenta = AlmacenDatos.cuentaPorNumero(cuentaSelect);
		if(cuenta != null) {
			this.txtUsuario.setText(cuenta.getUsuario().getNombre());
			this.txtMoneda.setText(cuenta.getMoneda().getNombre());
			this.txtSaldo.setText(String.valueOf(cuenta.getSaldo()));
			this.comboBoxEstado.setSelectedItem(cuenta.getEstado());
		}
	}
	
	public void actionPerformedbtnModificar(ActionEvent e) {
		String numeroCuenta = (String) comboBoxNcuenta.getSelectedItem();
		
		if(numeroCuenta == null) {
			JOptionPane.showMessageDialog(this, "Por favor, seleccione una cuenta.");
			return;
		}
		
		try {
			Double saldo = Double.parseDouble(txtSaldo.getText().strip());
			String estado = (String) comboBoxEstado.getSelectedItem();
			
			CuentaService service = new CuentaService();
			service.ModificarCuenta(numeroCuenta, saldo, estado);
			JOptionPane.showMessageDialog(this, "Cuenta modificada correctamente");
		} catch (NumberFormatException nfe) {
			JOptionPane.showMessageDialog(this, "Error: El saldo debe ser un número válido.");
		} catch (Exception err) {
			JOptionPane.showMessageDialog(this, err.getMessage(), "Error de validación", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void actualizar() {
		comboBoxNcuenta.removeAllItems();
		for(int i = 0; i < AlmacenDatos.listaCuentas.size(); i++) {
			Cuenta cuenta = AlmacenDatos.listaCuentas.get(i);
			comboBoxNcuenta.addItem(cuenta.getNumeroCuenta());
		}
	}
}

package mantenimiento;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import datos.AlmacenDatos;
import modelos.Moneda;
import modelos.Usuario;
import servicio.CuentaService;
import servicio.UsuarioService;
import javax.swing.JComboBox;

public class CrearCuenta extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JTextField txtNumeroCuenta;
	private JButton btnCrear;
	private JComboBox comboBoxDNI;
	private JComboBox comboBoxMoneda;

	/**
	 * Create the panel.
	 */
	public CrearCuenta() {
		setBackground(new Color(255, 255, 255));
		setPreferredSize(new java.awt.Dimension(612, 455));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Número de cuenta :");
		lblNewLabel.setForeground(new Color(2, 64, 89));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNewLabel.setBounds(42, 90, 224, 31);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("DNI :");
		lblNewLabel_1.setForeground(new Color(2, 64, 89));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNewLabel_1.setBounds(42, 182, 246, 31);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Moneda :");
		lblNewLabel_2.setForeground(new Color(2, 64, 89));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNewLabel_2.setBounds(42, 271, 224, 31);
		add(lblNewLabel_2);
		
		txtNumeroCuenta = new JTextField();
		txtNumeroCuenta.setFont(new Font("Tahoma", Font.PLAIN, 19));
		txtNumeroCuenta.setBounds(279, 91, 279, 30);
		add(txtNumeroCuenta);
		txtNumeroCuenta.setColumns(10);
		
		btnCrear = new JButton("CREAR");
		btnCrear.addActionListener(this);
		btnCrear.setBackground(new Color(128, 191, 33));
		btnCrear.setForeground(new Color(255, 255, 255));
		btnCrear.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCrear.setBounds(438, 376, 120, 40);
		add(btnCrear);
		btnCrear.setContentAreaFilled(false); 
		btnCrear.setOpaque(true);
		
		comboBoxDNI = new JComboBox();
		comboBoxDNI.setBounds(279, 182, 279, 30);
		comboBoxDNI.setMaximumRowCount(5);
		for(int i = 0; i < AlmacenDatos.listaUsuarios.size(); i++) {
			Usuario user = AlmacenDatos.listaUsuarios.get(i);
			comboBoxDNI.addItem(user.getDNI());
		}
		add(comboBoxDNI);
		comboBoxDNI.addActionListener(this);
		
		comboBoxMoneda = new JComboBox();
		comboBoxMoneda.setBounds(276, 271, 282, 30);
		comboBoxMoneda.setMaximumRowCount(5);
		for(int i = 0; i < AlmacenDatos.listaMonedas.size(); i++) {
			Moneda moneda = AlmacenDatos.listaMonedas.get(i);
			comboBoxMoneda.addItem(moneda.getNombre());
		}
		add(comboBoxMoneda);
		comboBoxMoneda.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == btnCrear) {
			actionPerformedbtnCrear(e);
		}
		if(e.getSource() == comboBoxDNI) {
			comboBoxDNIActionPerformed(e);
		}
		if(e.getSource() == comboBoxMoneda) {
			comboBoxMonedaActionPerformed(e);
		}
	}
	
	public void setNumero() {
		CuentaService service = new CuentaService();
		String proximoNumero = service.generarNextNumeroCuenta();
	    txtNumeroCuenta.setText(proximoNumero);
	    txtNumeroCuenta.setEditable(false);
	}
	
	public void comboBoxDNIActionPerformed(ActionEvent e) {
		String dniSelect = (String) comboBoxDNI.getSelectedItem();
		Usuario user = AlmacenDatos.clientePorDni(dniSelect);
	}
	
	public void comboBoxMonedaActionPerformed(ActionEvent e) {}
	
	public void actionPerformedbtnCrear(ActionEvent e) {
		try {
			String dniSelect = (String) comboBoxDNI.getSelectedItem();
			Usuario user = AlmacenDatos.clientePorDni(dniSelect);
			
			String monedaSelect = (String) comboBoxMoneda.getSelectedItem();
			Moneda moneda = AlmacenDatos.monedaPorNombre(monedaSelect);
			
			CuentaService cuentaSrv = new CuentaService();
			cuentaSrv.crearCuenta(txtNumeroCuenta.getText(), user, moneda);
			JOptionPane.showMessageDialog(this, "Cuenta creada con éxito!");
			setNumero();
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(this, ex.getMessage());
		}
	}
	
	
}

package mantenimiento;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import servicio.MonedaService;

public class CrearMoneda extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JTextField txtSimbolo;
	private JTextField txtNombre;
	private JTextField txtCambio;
	private JButton btnCrear;

	/**
	 * Create the panel.
	 */
	public CrearMoneda() {
		setBackground(new Color(255, 255, 255));
		setPreferredSize(new java.awt.Dimension(612, 455));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Símbolo :");
		lblNewLabel.setForeground(new Color(2, 64, 89));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNewLabel.setBounds(42, 90, 224, 31);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre :");
		lblNewLabel_1.setForeground(new Color(2, 64, 89));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNewLabel_1.setBounds(42, 182, 246, 31);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Cambio :");
		lblNewLabel_2.setForeground(new Color(2, 64, 89));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNewLabel_2.setBounds(42, 271, 224, 31);
		add(lblNewLabel_2);
		
		txtSimbolo = new JTextField();
		txtSimbolo.setFont(new Font("Tahoma", Font.PLAIN, 19));
		txtSimbolo.setBounds(279, 91, 279, 30);
		add(txtSimbolo);
		txtSimbolo.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 19));
		txtNombre.setColumns(10);
		txtNombre.setBounds(279, 183, 279, 30);
		add(txtNombre);
		
		txtCambio = new JTextField();
		txtCambio.setFont(new Font("Tahoma", Font.PLAIN, 19));
		txtCambio.setColumns(10);
		txtCambio.setBounds(279, 272, 279, 30);
		add(txtCambio);
		
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
		String simbolo = this.txtSimbolo.getText();
		String nombre = this.txtNombre.getText();
		double cambio = Double.parseDouble(this.txtCambio.getText());
		
		if(cambio <= 0) {
			JOptionPane.showMessageDialog(this, "El tipo de cambio debe ser mayor que 0");
			return;
		}
		try {
			MonedaService moneda = new MonedaService();
			moneda.CrearMoneda(simbolo, nombre, cambio);
			JOptionPane.showMessageDialog(this, "Moneda creado exitosamente");
			limpiarCampos();
		} catch (Exception err) {
			JOptionPane.showMessageDialog(this, err.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void limpiarCampos() {
		this.txtSimbolo.setText("");
		this.txtNombre.setText("");
		this.txtCambio.setText("");
	}
}

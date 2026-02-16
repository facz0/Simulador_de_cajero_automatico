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
import modelos.Moneda;
import servicio.MonedaService;

public class ModificarMoneda extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JComboBox comboBoxMoneda;
	private JTextField txtNombre;
	private JTextField txtSimbolo;
	private JTextField txtCambio;
	private JButton btnModificar;

	/**
	 * Create the panel.
	 */
	public ModificarMoneda() {
		setBackground(new Color(255, 255, 255));
		setPreferredSize(new java.awt.Dimension(612, 455));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Moneda :");
		lblNewLabel.setForeground(new Color(2, 64, 89));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNewLabel.setBounds(40, 38, 224, 31);
		add(lblNewLabel);
		
		comboBoxMoneda = new JComboBox();
		comboBoxMoneda.setBounds(274, 39, 279, 30);
		comboBoxMoneda.setMaximumRowCount(5);
		for(int i = 0; i < AlmacenDatos.listaMonedas.size(); i++) {
			Moneda m = AlmacenDatos.listaMonedas.get(i);
			comboBoxMoneda.addItem(m.getNombre());
		}
		add(comboBoxMoneda);
		comboBoxMoneda.addActionListener(this);
		
		JLabel lblNombre = new JLabel("Nombre :");
		lblNombre.setForeground(new Color(2, 64, 89));
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNombre.setBounds(40, 108, 209, 31);
		add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 19));
		txtNombre.setBounds(274, 110, 279, 30);
		add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblSimbolo = new JLabel("Símbolo :");
		lblSimbolo.setForeground(new Color(2, 64, 89));
		lblSimbolo.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblSimbolo.setBounds(40, 183, 209, 31);
		add(lblSimbolo);
		
		txtSimbolo = new JTextField();
		txtSimbolo.setFont(new Font("Tahoma", Font.PLAIN, 19));
		txtSimbolo.setColumns(10);
		txtSimbolo.setBounds(274, 184, 279, 30);
		add(txtSimbolo);
		
		JLabel lblTipoCambio = new JLabel("Tipo de cambio :");
		lblTipoCambio.setForeground(new Color(2, 64, 89));
		lblTipoCambio.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblTipoCambio.setBounds(40, 258, 209, 31);
		add(lblTipoCambio);
		
		txtCambio = new JTextField();
		txtCambio.setFont(new Font("Tahoma", Font.PLAIN, 19));
		txtCambio.setColumns(10);
		txtCambio.setBounds(274, 259, 279, 30);
		add(txtCambio);
		
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
		if(e.getSource() == comboBoxMoneda) {
			comboMonedaActionPerformed(e);
		}
		
	}
	
	public void comboMonedaActionPerformed(ActionEvent e) {
		if (comboBoxMoneda.getSelectedItem() == null) return;
		Object monedaSelect = comboBoxMoneda.getSelectedItem();
		if(monedaSelect==null) {
			return;
		}
		String select = monedaSelect.toString();
		Moneda moneda = AlmacenDatos.monedaPorNombre(select);
		if(moneda!=null) {
			this.txtSimbolo.setText(moneda.getIdMoneda());
			this.txtNombre.setText(moneda.getNombre());
			this.txtCambio.setText(String.valueOf(moneda.getTipoCambio()));
		}
	}
	
	public void actionPerformedbtnModificar(ActionEvent e) {
		try {
			String moneda = (String) comboBoxMoneda.getSelectedItem();
			String nombre = this.txtNombre.getText().trim();
			String simbolo = this.txtSimbolo.getText().trim();
			Double cambio = Double.parseDouble(this.txtCambio.getText().trim());
		
			if (!nombre.matches("^[a-zA-Z ]+$")) {
				JOptionPane.showMessageDialog(this, "El nombre solo debe contener letras.");
				return;
			}
			MonedaService service = new MonedaService();
			service.ModificarMoneda(simbolo, nombre, cambio);
		} catch (NumberFormatException err) {
			JOptionPane.showMessageDialog(this, "El tipo de cambio debe ser un número (ejemplo: 3.85)");
		} catch (Exception er) {
			JOptionPane.showMessageDialog(this, er.getMessage());
		}
	}
	
	public void actualizar() {
		comboBoxMoneda.removeAllItems();
		for(int i = 0; i < AlmacenDatos.listaMonedas.size(); i++) {
			Moneda moneda = AlmacenDatos.listaMonedas.get(i);
			comboBoxMoneda.addItem(moneda.getNombre());
		}
	}

}

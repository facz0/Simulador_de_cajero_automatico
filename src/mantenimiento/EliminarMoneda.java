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

import datos.AlmacenDatos;
import modelos.Moneda;
import servicio.MonedaService;

public class EliminarMoneda extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JComboBox comboBoxMoneda;
	private JButton btnEliminar;

	/**
	 * Create the panel.
	 */
	public EliminarMoneda() {
		
		setBackground(new Color(255, 255, 255));
		setPreferredSize(new java.awt.Dimension(612, 455));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Moneda :");
		lblNewLabel.setForeground(new Color(2, 64, 89));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNewLabel.setBounds(41, 95, 224, 31);
		add(lblNewLabel);
		
		comboBoxMoneda = new JComboBox();
		comboBoxMoneda.setBounds(275, 95, 279, 30);
		comboBoxMoneda.setMaximumRowCount(5);
		for(int i = 0; i < AlmacenDatos.listaMonedas.size(); i++) {
			Moneda m = AlmacenDatos.listaMonedas.get(i);
			comboBoxMoneda.addItem(m.getNombre());
		}
		add(comboBoxMoneda);
		comboBoxMoneda.addActionListener(this);
		
		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.addActionListener(this);
		btnEliminar.setBackground(new Color(128, 191, 33));
		btnEliminar.setForeground(new Color(255, 255, 255));
		btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnEliminar.setBounds(196, 210, 181, 40);
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

	public void actualizar() {
		comboBoxMoneda.removeAllItems();
		for(int i = 0; i < AlmacenDatos.listaMonedas.size(); i++) {
			Moneda moneda = AlmacenDatos.listaMonedas.get(i);
			comboBoxMoneda.addItem(moneda.getNombre());
		}
	}
	
	public void actionPerformedbtnEliminar(ActionEvent e) {
		try {
			String nombre = (String) comboBoxMoneda.getSelectedItem();
			if(nombre == null) {
				JOptionPane.showMessageDialog(this, "Por favor seleccione una moneda");
	            return;
			}
			MonedaService service = new MonedaService();
			service.EliminarMoneda(nombre);
			JOptionPane.showMessageDialog(this, "Moneda Eliminada de manera correcta");
			actualizar();
		} catch (Exception err) {
			JOptionPane.showMessageDialog(btnEliminar, err.getMessage());
		}
		
	}
}

package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;

public class Consultas extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private VentanaPrincipal ventanaPrincipal;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JButton btnBuscar;
	private JButton btnAtras;
	private JComboBox comboBox;
	private JPanel panel;
	private JTextField textNombreUsuario;

	/**
	 * Create the panel.
	 */
	public Consultas(VentanaPrincipal principal) {
		this.ventanaPrincipal = principal;
		setPreferredSize(new java.awt.Dimension(1000, 620));
		setLayout(null);
		
		lblNewLabel = new JLabel("CONSULTAS Y BUSQUEDAS ");
		lblNewLabel.setBounds(393, 28, 183, 14);
		add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("TIPO DE BUSQUEDA");
		lblNewLabel_1.setBounds(403, 53, 118, 25);
		add(lblNewLabel_1);
		
		btnBuscar = new JButton("BUSCAR");
		btnBuscar.setBounds(756, 99, 89, 23);
		add(btnBuscar);
		
		btnAtras = new JButton("REGRESAR");
		btnAtras.setBounds(890, 574, 89, 23);
		add(btnAtras);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"CONSULTA DE SALDO", "CONSULTA DE OPERACIONES POR RANGO DE FECHA Y CLIENTES", "ULTIMOS MOVIMIENTOS "}));
		comboBox.setBounds(303, 99, 381, 22);
		add(comboBox);
		
		panel = new JPanel();
		panel.setBounds(10, 135, 969, 411);
		add(panel);
		
		textNombreUsuario = new JTextField();
		textNombreUsuario.setEditable(false);
		textNombreUsuario.setBounds(10, 101, 226, 20);
		add(textNombreUsuario);
		textNombreUsuario.setColumns(10);

	}
}

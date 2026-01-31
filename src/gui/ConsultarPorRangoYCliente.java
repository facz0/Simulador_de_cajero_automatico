package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class ConsultarPorRangoYCliente extends JPanel {

	private static final long serialVersionUID = 1L;
	private VentanaPrincipal ventanaPrincipal;
	private JLabel lblNewLabel;
	private JButton btnAtras;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JTextField textField;
	private JLabel lblNewLabel_3;
	private JTextField textField_1;
	private JLabel lblNewLabel_4;
	private JTextField textField_2;
	private JButton btnProcesar;
	private JScrollPane scrollPane;
	private JTextArea textArea;

	/**
	 * Create the panel.
	 */
	public ConsultarPorRangoYCliente(VentanaPrincipal principal) {
		this.ventanaPrincipal = principal;
		setPreferredSize(new java.awt.Dimension(1000, 620));
		setLayout(null);
		
		lblNewLabel = new JLabel("CONSULTAS Y BUSQUEDAS ");
		lblNewLabel.setBounds(393, 11, 183, 14);
		add(lblNewLabel);
		
		btnAtras = new JButton("REGRESAR");
		btnAtras.setBounds(890, 540, 89, 23);
		add(btnAtras);
		
		lblNewLabel_1 = new JLabel("CONSULTA DE OPERACIONES ");
		lblNewLabel_1.setBounds(389, 36, 156, 20);
		add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("DESDE:");
		lblNewLabel_2.setBounds(170, 71, 55, 14);
		add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(214, 68, 86, 20);
		add(textField);
		textField.setColumns(10);
		
		lblNewLabel_3 = new JLabel("HASTA:");
		lblNewLabel_3.setBounds(331, 71, 46, 14);
		add(lblNewLabel_3);
		
		textField_1 = new JTextField();
		textField_1.setBounds(377, 68, 86, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		lblNewLabel_4 = new JLabel("CLIENTE:");
		lblNewLabel_4.setBounds(499, 71, 46, 14);
		add(lblNewLabel_4);
		
		textField_2 = new JTextField();
		textField_2.setBounds(555, 68, 86, 20);
		add(textField_2);
		textField_2.setColumns(10);
		
		btnProcesar = new JButton("PROCESAR");
		btnProcesar.setBounds(677, 67, 89, 23);
		add(btnProcesar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 104, 980, 425);
		add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);

		
	}
}

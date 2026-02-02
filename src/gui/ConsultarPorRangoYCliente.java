package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.Color;

public class ConsultarPorRangoYCliente extends JPanel {

	private static final long serialVersionUID = 1L;
	private VentanaPrincipal ventanaPrincipal;
	private JButton btnAtras;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JTextField txtDdmmaaaa;
	private JLabel lblNewLabel_3;
	private JTextField txtDdmmaaaa_1;
	private JLabel lblNewLabel_4;
	private JTextField txtDni;
	private JButton btnProcesar;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private JPanel panel;

	/**
	 * Create the panel.
	 */
	public ConsultarPorRangoYCliente(VentanaPrincipal principal) {
		setBackground(new Color(255, 255, 255));
		this.ventanaPrincipal = principal;
		setPreferredSize(new java.awt.Dimension(1000, 620));
		setLayout(null);
		
		btnAtras = new JButton("REGRESAR");
		btnAtras.setBounds(890, 540, 89, 23);
		add(btnAtras);
		
		lblNewLabel_1 = new JLabel("CONSULTA DE OPERACIONES ");
		lblNewLabel_1.setForeground(new Color(2, 64, 89));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblNewLabel_1.setBounds(356, 15, 332, 45);
		add(lblNewLabel_1);
		
		panel = new JPanel();
		panel.setBackground(new Color(3, 120,166));
		panel.setBounds(122, 85, 769, 426);
		add(panel);
		panel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(297, 47, 403, 333);
		panel.add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setForeground(new Color(255, 255, 255));
		textArea.setFont(new Font("Monospaced", Font.BOLD, 15));
		
		btnProcesar = new JButton("PROCESAR");
		btnProcesar.setBounds(59, 266, 125, 39);
		panel.add(btnProcesar);
		btnProcesar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnProcesar.setBackground(new Color(128, 191,33));
		btnProcesar.setContentAreaFilled(false); 
		btnProcesar.setOpaque(true);
		btnProcesar.setForeground(new Color(255, 255, 255));
		
		lblNewLabel_2 = new JLabel("DESDE:");
		lblNewLabel_2.setBounds(10, 32, 86, 35);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		txtDdmmaaaa = new JTextField();
		txtDdmmaaaa.setBounds(10, 66, 86, 20);
		panel.add(txtDdmmaaaa);
		txtDdmmaaaa.setText("DD/MM/AAAA");
		txtDdmmaaaa.setColumns(10);
		
		lblNewLabel_3 = new JLabel("HASTA:");
		lblNewLabel_3.setBounds(143, 32, 86, 35);
		panel.add(lblNewLabel_3);
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		txtDdmmaaaa_1 = new JTextField();
		txtDdmmaaaa_1.setBounds(143, 66, 86, 20);
		panel.add(txtDdmmaaaa_1);
		txtDdmmaaaa_1.setText("DD/MM/AAAA");
		txtDdmmaaaa_1.setColumns(10);
		
		lblNewLabel_4 = new JLabel("CLIENTE:");
		lblNewLabel_4.setBounds(73, 134, 86, 35);
		panel.add(lblNewLabel_4);
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		txtDni = new JTextField();
		txtDni.setBounds(73, 173, 86, 20);
		panel.add(txtDni);
		txtDni.setText("DNI");
		txtDni.setColumns(10);

		
	}
}

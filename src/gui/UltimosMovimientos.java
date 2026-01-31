package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class UltimosMovimientos extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private VentanaPrincipal ventanaPrincipal;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JButton btnAtras;
	private JTextField textNombreUsuario;
	private JButton btnConsultar;
	private JTextArea textArea;

	/**
	 * Create the panel.
	 */
	public UltimosMovimientos(VentanaPrincipal principal) {

		this.ventanaPrincipal = principal;
		setPreferredSize(new java.awt.Dimension(1000, 620));
		setLayout(null);
		
		lblNewLabel = new JLabel("CONSULTAS Y BUSQUEDAS ");
		lblNewLabel.setBounds(393, 11, 183, 14);
		add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("CONSULTAR ULTIMOS MOVIMIENTOS");
		lblNewLabel_1.setBounds(373, 36, 195, 25);
		add(lblNewLabel_1);
		
		btnAtras = new JButton("REGRESAR");
		btnAtras.setBounds(890, 557, 89, 23);
		add(btnAtras);
		
		textNombreUsuario = new JTextField();
		textNombreUsuario.setEditable(false);
		textNombreUsuario.setColumns(10);
		textNombreUsuario.setBounds(10, 84, 226, 20);
		add(textNombreUsuario);
		
		btnConsultar = new JButton("CONSULTAR");
		btnConsultar.setBounds(373, 72, 178, 23);
		add(btnConsultar);
		
		textArea = new JTextArea();
		textArea.setBounds(10, 115, 980, 429);
		add(textArea);
		
	}

}

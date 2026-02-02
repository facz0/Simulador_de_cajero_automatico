package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UltimosMovimientos extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	private VentanaPrincipal ventanaPrincipal;
	private JLabel lblNewLabel_1;
	private JButton btnAtras;
	private JButton btnConsultar;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private JPanel panel;

	/**
	 * Create the panel.
	 */
	public UltimosMovimientos(VentanaPrincipal principal) {
		setBackground(new Color(255, 255, 255));

		this.ventanaPrincipal = principal;
		setPreferredSize(new java.awt.Dimension(1000, 620));
		setLayout(null);
		
		lblNewLabel_1 = new JLabel("CONSULTAR ULTIMOS MOVIMIENTOS");
		lblNewLabel_1.setForeground(new Color(2, 64, 89));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblNewLabel_1.setBounds(300, 11, 409, 50);
		add(lblNewLabel_1);
		
		btnAtras = new JButton("REGRESAR");
		btnAtras.setBounds(890, 557, 89, 23);
		add(btnAtras);
		
		panel = new JPanel();
		panel.setBackground(new Color(3, 120, 166));
		panel.setBounds(127, 79, 753, 441);
		add(panel);
		panel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(280, 51, 412, 338);
		panel.add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		btnConsultar = new JButton("CONSULTAR");
		btnConsultar.setBounds(92, 196, 130, 38);
		panel.add(btnConsultar);
		btnConsultar.addActionListener(this);
		btnConsultar.setBackground(new Color(128, 191, 33));
		btnConsultar.setContentAreaFilled(false); 
		btnConsultar.setOpaque(true);
		btnConsultar.setForeground(new Color(255, 255, 255));
		btnConsultar.setFont(new Font("Tahoma", Font.BOLD, 15));
		
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnConsultar) {
			actionPerformedBtnConsultar(e);
		}
	}
	protected void actionPerformedBtnConsultar(ActionEvent e) {
	}
}

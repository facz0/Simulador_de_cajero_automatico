package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JScrollPane;

public class ConsultaDeSaldo extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	private VentanaPrincipal ventanaPrincipal;
	private JLabel lblNewLabel_1;
	private JButton btnVolver;
	private JButton btnConsultar;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private JPanel panel;

	/**
	 * Create the panel.
	 */
	public ConsultaDeSaldo(VentanaPrincipal principal) {
		setBackground(new Color(255, 255, 255));
		this.ventanaPrincipal = principal;
		setPreferredSize(new java.awt.Dimension(1000, 620));
		setLayout(null);
		
		lblNewLabel_1 = new JLabel("CONSULTAR SALDO");
		lblNewLabel_1.setForeground(new Color(2, 64,89));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblNewLabel_1.setBounds(386, 11, 216, 50);
		add(lblNewLabel_1);
		
		btnVolver = new JButton("< Volver");
		btnVolver.setForeground(new Color(255, 255, 255));
		btnVolver.setBackground(new Color(128, 191, 33));
		btnVolver.addActionListener(this);
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnVolver.setBounds(10, 11, 97, 35);
		add(btnVolver);
		btnVolver.setContentAreaFilled(false); 
		btnVolver.setOpaque(true);
		
		panel = new JPanel();
		panel.setBackground(new Color(2, 64, 89));
		panel.setBounds(126, 78, 766, 445);
		add(panel);
		panel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(281, 53, 418, 339);
		panel.add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		btnConsultar = new JButton("CONSULTAR");
		btnConsultar.setBounds(94, 204, 129, 38);
		panel.add(btnConsultar);
		btnConsultar.setForeground(new Color(255, 255, 255));
		btnConsultar.setBackground(new Color(128, 191, 33 ));
		btnConsultar.setContentAreaFilled(false); 
		btnConsultar.setOpaque(true);
		btnConsultar.setFont(new Font("Tahoma", Font.BOLD, 15));
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == btnVolver) {
	        ventanaPrincipal.menu_usuario();
	    }
	}

}

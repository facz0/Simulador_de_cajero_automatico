package consultas_busquedas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;

import gui.VentanaPrincipal;

public class Ultimos_movimientos extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	private VentanaPrincipal ventanaPrincipal;
	private JTextField textField;
	private JButton btnVolver;


	/**
	 * Create the panel.
	 */
	public Ultimos_movimientos(VentanaPrincipal principal) {
		setBackground(new Color(2, 64, 89));
		this.ventanaPrincipal = principal;		
		setPreferredSize(new java.awt.Dimension(1000, 620));
		setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(69, 74, 858, 14);
		add(separator);
		
		JLabel lblNewLabel = new JLabel("Últimos movimientos");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(69, 35, 380, 28);
		add(lblNewLabel);
		
		JButton btnListar = new JButton("LISTAR");
		btnListar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnListar.setBounds(387, 99, 232, 45);
		btnListar.setForeground(new Color(255, 255, 255));
		btnListar.setBackground(new Color(128, 191, 33));
		add(btnListar);
		btnListar.setContentAreaFilled(false); 
		btnListar.setOpaque(true);
		
		textField = new JTextField();
		textField.setBounds(224, 191, 555, 329);
		add(textField);
		textField.setColumns(10);
		
		btnVolver = new JButton("< Volver");
		btnVolver.setForeground(new Color(255, 255, 255));
		btnVolver.setBackground(new Color(128, 191, 33));
		btnVolver.addActionListener(this);
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnVolver.setBounds(69, 561, 97, 35);
		add(btnVolver);
		btnVolver.setContentAreaFilled(false); 
		btnVolver.setOpaque(true);


	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == btnVolver) {
			ventanaPrincipal.menu_usuario();
		}
	}
}

package consultas_busquedas;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import gui.VentanaPrincipal;

import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

public class Consultas_Rango extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	private VentanaPrincipal ventanaPrincipal;
	private JButton btnVolver;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JTextField txtDdmmaaaa;
	private JLabel lblNewLabel_3;
	private JTextField txtDdmmaaaa_1;
	private JButton btnProcesar;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private JPanel panel;
	/**
	 * Create the panel.
	 */
	public Consultas_Rango(VentanaPrincipal principal) {
		setBackground(new Color(255, 255, 255));
		this.ventanaPrincipal = principal;
		setPreferredSize(new java.awt.Dimension(1000, 620));
		setLayout(null);
		
		lblNewLabel_1 = new JLabel("CONSULTA DE OPERACIONES ");
		lblNewLabel_1.setForeground(new Color(2, 64, 89));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblNewLabel_1.setBounds(356, 15, 332, 45);
		add(lblNewLabel_1);
		
		panel = new JPanel();
		panel.setBackground(new Color(2, 64, 89));
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
		btnProcesar.setBounds(45, 249, 125, 39);
		panel.add(btnProcesar);
		btnProcesar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnProcesar.setBackground(new Color(128, 191,33));
		btnProcesar.setContentAreaFilled(false); 
		btnProcesar.setOpaque(true);
		btnProcesar.setForeground(new Color(255, 255, 255));
		
		lblNewLabel_2 = new JLabel("DESDE:");
		lblNewLabel_2.setBounds(45, 43, 86, 35);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		txtDdmmaaaa = new JTextField();
		txtDdmmaaaa.setBounds(45, 77, 86, 20);
		panel.add(txtDdmmaaaa);
		txtDdmmaaaa.setText("DD/MM/AAAA");
		txtDdmmaaaa.setColumns(10);
		
		lblNewLabel_3 = new JLabel("HASTA:");
		lblNewLabel_3.setBounds(45, 135, 86, 35);
		panel.add(lblNewLabel_3);
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		txtDdmmaaaa_1 = new JTextField();
		txtDdmmaaaa_1.setBounds(45, 174, 86, 20);
		panel.add(txtDdmmaaaa_1);
		txtDdmmaaaa_1.setText("DD/MM/AAAA");
		txtDdmmaaaa_1.setColumns(10);
		
		btnVolver = new JButton("< Volver");
		btnVolver.setForeground(new Color(255, 255, 255));
		btnVolver.setBackground(new Color(128, 191, 33));
		btnVolver.addActionListener(this);
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnVolver.setBounds(10, 11, 97, 35);
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

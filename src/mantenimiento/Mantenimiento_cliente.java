package mantenimiento;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;

import gui.VentanaPrincipal;

public class Mantenimiento_cliente extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	private VentanaPrincipal ventanaPrincipal;
	private JButton btnListar;
	private JButton btnCrear;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnVolver;
	private JTextArea txtResultado;

	/**
	 * Create the panel.
	 */
	public Mantenimiento_cliente(VentanaPrincipal principal) {
		setBackground(new Color(2, 64, 89));
		setLayout(null);
		this.ventanaPrincipal = principal;		
		setPreferredSize(new java.awt.Dimension(1000, 620));
		
		JSeparator separator = new JSeparator();
		separator.setBounds(98, 83, 792, 20);
		add(separator);
		
		JLabel lblNewLabel = new JLabel("Clientes");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(98, 38, 393, 34);
		add(lblNewLabel);
		
		btnListar = new JButton("LISTAR");
		btnListar.setBounds(108, 151, 150, 42);
		btnListar.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnListar.setForeground(new Color(255, 255, 255));
		btnListar.addActionListener(this);
		btnListar.setBackground(new Color(128, 191, 33));
		add(btnListar);
		btnListar.setContentAreaFilled(false); 
		btnListar.setOpaque(true); 
		
		btnCrear = new JButton("CREAR");
		btnCrear.setBounds(108, 238, 150, 42);
		btnCrear.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnCrear.setForeground(new Color(255, 255, 255));
		btnCrear.addActionListener(this);
		btnCrear.setBackground(new Color(128, 191, 33));
		add(btnCrear);
		btnCrear.setContentAreaFilled(false); 
		btnCrear.setOpaque(true); 
		
		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(108, 328, 150, 42);
		btnModificar.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnModificar.setForeground(new Color(255, 255, 255));
		btnModificar.addActionListener(this);
		btnModificar.setBackground(new Color(128, 191, 33));
		add(btnModificar);
		btnModificar.setContentAreaFilled(false); 
		btnModificar.setOpaque(true); 
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(108, 430, 150, 42);
		btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnEliminar.setForeground(new Color(255, 255, 255));
		btnEliminar.addActionListener(this);
		btnEliminar.setBackground(new Color(128, 191, 33));
		add(btnEliminar);
		btnEliminar.setContentAreaFilled(false); 
		btnEliminar.setOpaque(true); 
		
		txtResultado = new JTextArea();
		txtResultado.setEditable(false);
		txtResultado.setBounds(352, 151, 523, 321);
		add(txtResultado);
		
		btnVolver = new JButton("< Volver");
		btnVolver.setForeground(new Color(255, 255, 255));
		btnVolver.setBackground(new Color(128, 191, 33));
		btnVolver.addActionListener(this);
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnVolver.setBounds(793, 40, 97, 35);
		add(btnVolver);
		btnVolver.setContentAreaFilled(false); 
		btnVolver.setOpaque(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == btnVolver) {
			ventanaPrincipal.Menu_mantenimiento();
		}
	}

}

package gui;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import javax.swing.JEditorPane;

public class Panel_inicio extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	private VentanaPrincipal ventanaPrincipal;
	private JButton btnUsuario;
	private JButton btnAdministrador;
	
	/**
	 * Create the panel.
	 */
	public Panel_inicio(VentanaPrincipal principal) {
		//Llamamos al JFrame
		this.ventanaPrincipal = principal;
		setPreferredSize(new java.awt.Dimension(1000, 620));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Bienvenido al Banco x");
		lblNewLabel.setBounds(421, 98, 416, 93);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(209, 220, 862, 387);
		panel.setBackground(new Color(192, 192, 192));
		add(panel);
		panel.setLayout(null);
		
		btnAdministrador = new JButton("Administrador");
		btnAdministrador.addActionListener(this);
		btnAdministrador.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAdministrador.setBounds(225, 167, 167, 62);
		panel.add(btnAdministrador);
		
		JLabel lblNewLabel_1 = new JLabel("INGRESAR COMO:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(345, 62, 167, 51);
		panel.add(lblNewLabel_1);
		
		btnUsuario = new JButton("Usuario");
		btnUsuario.addActionListener(this);
		btnUsuario.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnUsuario.setBounds(471, 167, 167, 62);
		panel.add(btnUsuario);

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == btnAdministrador) {
			ventanaPrincipal.Login_administrador();
		}
		if(e.getSource() == btnUsuario) {
			ventanaPrincipal.Login_usuario();
		}
	}
}


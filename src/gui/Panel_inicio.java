package gui;

import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;


public class Panel_inicio extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	private VentanaPrincipal ventanaPrincipal;
	private JButton btnMantenimiento;
	private JButton btnUsuario;
	private JButton btnReportes;
	private JButton btnVolver;
	private JLabel lblLogo;
	private JLabel lblNewLabel;
	private JLabel lblBancoInstitucional;
	private JLabel lblCibertec;
	
	/**
	 * Create the panel.
	 */
	public Panel_inicio(VentanaPrincipal principal) {
		setBackground(new Color(255, 255, 255));
		//Llamamos al JFrame
		this.ventanaPrincipal = principal;
		setPreferredSize(new java.awt.Dimension(1000, 620));
		setLayout(null);
		ImageIcon userOriginal = new ImageIcon(getClass().getResource("/iconos/user.png"));
		Image imgEscalada = userOriginal.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		ImageIcon user = new ImageIcon(imgEscalada);
		ImageIcon reportes = new ImageIcon(getClass().getResource("/iconos/report.png"));
		ImageIcon mantenimiento = new ImageIcon(getClass().getResource("/iconos/mantenimiento.png"));
		ImageIcon logo = new ImageIcon(getClass().getResource("/iconos/logo.png"));
		Image logoescalado = logo.getImage().getScaledInstance(240, 254, Image.SCALE_SMOOTH);
		ImageIcon logoFinal = new ImageIcon(logoescalado);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(2, 64, 89));
		panel.setBounds(485, 0, 515, 620);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblFrffefr = new JLabel("OPCIONES");
		lblFrffefr.setForeground(new Color(255, 255, 255));
		lblFrffefr.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblFrffefr.setBounds(195, 87, 143, 37);
		panel.add(lblFrffefr);
		
		btnMantenimiento = new JButton("MANTENIMIENTO");
		btnMantenimiento.setForeground(new Color(255, 255, 255));
		btnMantenimiento.setBackground(new Color(128, 191, 33));
		btnMantenimiento.addActionListener(this);
		btnMantenimiento.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnMantenimiento.setBounds(136, 450, 259, 63);
		panel.add(btnMantenimiento);
		btnMantenimiento.setContentAreaFilled(false); 
		btnMantenimiento.setOpaque(true);
		btnMantenimiento.setIcon(mantenimiento);
		btnMantenimiento.setIconTextGap(10);
		btnMantenimiento.setFocusPainted(false);
		
		btnReportes = new JButton("REPORTES");
		btnReportes.setForeground(new Color(255, 255, 255));
		btnReportes.addActionListener(this);
		btnReportes.setBackground(new Color(128, 191, 33));
		btnReportes.setBounds(136, 308, 259, 63);
		panel.add(btnReportes);
		btnReportes.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnReportes.setContentAreaFilled(false); 
		btnReportes.setOpaque(true); 
		btnReportes.setIcon(reportes);
		btnReportes.setIconTextGap(10);
		btnReportes.setFocusPainted(false);
		
		btnUsuario = new JButton("INICIAR SESIÓN");
		btnUsuario.setForeground(new Color(255, 255, 255));
		btnUsuario.addActionListener(this);
		btnUsuario.setBackground(new Color(128, 191, 33));
		btnUsuario.setBounds(136, 176, 259, 63);
		panel.add(btnUsuario);
		btnUsuario.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnUsuario.setContentAreaFilled(false); 
		btnUsuario.setOpaque(true);
		btnUsuario.setIcon(user);
		btnUsuario.setIconTextGap(10);
		btnUsuario.setFocusPainted(false);
		
		lblLogo = new JLabel(logoFinal);
		lblLogo.setBounds(78, 165, 321, 254);
		add(lblLogo);
		
		lblNewLabel = new JLabel("BIENVENIDO");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setForeground(new Color(2, 64, 89));
		lblNewLabel.setBounds(143, 77, 210, 54);
		add(lblNewLabel);
		
		lblBancoInstitucional = new JLabel("BANCO INSTITUCIONAL");
		lblBancoInstitucional.setForeground(new Color(2, 64, 89));

		lblBancoInstitucional.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblBancoInstitucional.setBounds(58, 461, 400, 61);

		
		add(lblBancoInstitucional);
		
		lblCibertec = new JLabel("CIBERTEC");
		lblCibertec.setForeground(new Color(2, 64, 89));
		lblCibertec.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblCibertec.setBounds(165, 518, 162, 61);
		add(lblCibertec);

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnMantenimiento) {
			ventanaPrincipal.Login_administrador("MANTENIMIENTO");
		}
		if(e.getSource() == btnUsuario) {
			ventanaPrincipal.Login_usuario();
		}
		if(e.getSource() == btnReportes) {
			ventanaPrincipal.Login_administrador("REPORTES");
		}
	}
}

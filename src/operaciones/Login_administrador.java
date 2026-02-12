package operaciones;

import javax.swing.JPanel;
import javax.swing.JTextPane;

import gui.VentanaPrincipal;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JSlider;
import javax.swing.JMenuBar;

public class Login_administrador extends JPanel implements ActionListener{
	private static final long serialVersionUID = 1L;
	private VentanaPrincipal ventanaPrincipal;
	private JTextField txtAdminDni;
	private JPasswordField passwordAdmin;
	private JButton btnVolver;
	private JButton btnIngresarLoginAdmin;
	private String tipoAcceso;
    private JLabel lbltitulo;
	/**
	 * Create the panel.
	 * @param ventanaPrincipal 
	 */
	public Login_administrador(VentanaPrincipal principal) {
		setBackground(new Color(255, 255, 255));
		this.ventanaPrincipal = principal;
		this.tipoAcceso = "";
		setPreferredSize(new java.awt.Dimension(1000, 620));
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(2, 64, 89));
		panel.setBounds(240, 74, 556, 491);
		add(panel);
		panel.setLayout(null);
		
		lbltitulo = new JLabel("Ingresa tus credenciales para iniciar sesión");
		lbltitulo.setForeground(new Color(255, 255, 255));
		lbltitulo.setBounds(80, 44, 391, 29);
		panel.add(lbltitulo);
		lbltitulo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblDni = new JLabel("DNI:");
		lblDni.setForeground(new Color(255, 255, 255));
		lblDni.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDni.setBounds(187, 142, 93, 13);
		panel.add(lblDni);
		
		txtAdminDni = new JTextField();
		txtAdminDni.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtAdminDni.setBounds(185, 171, 210, 29);
		panel.add(txtAdminDni);
		txtAdminDni.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Password:");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(185, 241, 116, 29);
		panel.add(lblNewLabel);
		
		passwordAdmin = new JPasswordField();
		passwordAdmin.setBounds(185, 281, 210, 29);
		panel.add(passwordAdmin);
		
		btnIngresarLoginAdmin = new JButton("Ingresar");
		btnIngresarLoginAdmin.setForeground(new Color(255, 255, 255));
		btnIngresarLoginAdmin.setBackground(new Color(128, 191, 33));
		btnIngresarLoginAdmin.addActionListener(this);
		btnIngresarLoginAdmin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnIngresarLoginAdmin.setBounds(231, 367, 116, 36);
		panel.add(btnIngresarLoginAdmin);
		btnIngresarLoginAdmin.setContentAreaFilled(false); 
		btnIngresarLoginAdmin.setOpaque(true);
		
		btnVolver = new JButton("< VOLVER");
		btnVolver.setForeground(new Color(255, 255, 255));
		btnVolver.setBackground(new Color(220, 53, 69)); // color deseado ROJO
		btnVolver.addActionListener(this);
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnVolver.setBounds(10, 11, 127, 35);
		add(btnVolver);
		btnVolver.setContentAreaFilled(false); 
		btnVolver.setOpaque(true);
	}
	
	public void setModo(String modo) {
        this.tipoAcceso = modo;
        if (modo.equals("MANTENIMIENTO")) {
            lbltitulo.setText("LOGIN MANTENIMIENTO");
        } else {
            lbltitulo.setText("LOGIN REPORTES");
        }
    }
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == btnVolver) {
	        ventanaPrincipal.Panel_inicio();
	    }
		if (e.getSource() == btnIngresarLoginAdmin) {
	        String usuario = txtAdminDni.getText();
	        String password = new String(passwordAdmin.getPassword());
	        
	        if ("MANTENIMIENTO".equals(this.tipoAcceso)) {
	        	if (usuario.equals("admin") && password.equals("admin123")) {
	                ventanaPrincipal.Menu_mantenimiento();
	            } else {
	                System.out.println("ERROR: Credenciales de Mantenimiento incorrectas");
	            }
	        }
	        
	        else if ("REPORTES".equals(this.tipoAcceso)) {
	            if (usuario.equals("admin") && password.equals("reporte123")) {
	                ventanaPrincipal.Menu_reportes();
	            } else {
	                System.out.println("ERROR: Credenciales de Reportes incorrectas");
	            }
	        }
		}
	}
}

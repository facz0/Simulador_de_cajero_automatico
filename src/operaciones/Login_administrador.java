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
import javax.swing.ImageIcon;
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
    private ImageIcon iconoReportes;
    private ImageIcon iconoMantenimiento;
	/**
	 * Create the panel.
	 * @param ventanaPrincipal 
	 */
	public Login_administrador(VentanaPrincipal principal) {
		setBackground(new Color(2, 64, 89));
		
		//ICONOS
        ImageIcon documentoIdentidad = new ImageIcon(getClass().getResource("/iconos/dni.png"));
        ImageIcon volver = new ImageIcon(getClass().getResource("/iconos/Volver.png"));
        ImageIcon ingresarLogin = new ImageIcon(getClass().getResource("/iconos/ingresar.png"));
        ImageIcon contraseñaLogin = new ImageIcon(getClass().getResource("/iconos/contraseña.png"));
        iconoReportes = new ImageIcon(getClass().getResource("/iconos/report.png"));
        iconoMantenimiento = new ImageIcon(getClass().getResource("/iconos/mantenimiento.png"));
        		
        		
		this.ventanaPrincipal = principal;
		this.tipoAcceso = "";
		setPreferredSize(new java.awt.Dimension(1000, 620));
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(2, 64, 89));
		panel.setBounds(178, 74, 556, 491);
		add(panel);
		panel.setLayout(null);
		
		lbltitulo = new JLabel("LOGIN DE LOS REPORTES");
		lbltitulo.setForeground(new Color(255, 255, 255));
		lbltitulo.setBounds(187, 55, 391, 29);
		panel.add(lbltitulo);
		lbltitulo.setFont(new Font("Segoe UI", Font.BOLD, 20));
		
		JLabel lblDni = new JLabel("DNI:");
		lblDni.setForeground(new Color(255, 255, 255));
		lblDni.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDni.setBounds(187, 142, 93, 13);
		lblDni.setIcon(documentoIdentidad);
		panel.add(lblDni);
		
		txtAdminDni = new JTextField();
		txtAdminDni.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtAdminDni.setBounds(185, 171, 279, 29);
		panel.add(txtAdminDni);
		txtAdminDni.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Password:");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(185, 241, 116, 29);
		lblNewLabel.setIcon(contraseñaLogin);
		panel.add(lblNewLabel);
		
		passwordAdmin = new JPasswordField();
		passwordAdmin.setBounds(185, 281, 279, 29);
		panel.add(passwordAdmin);
		
		btnIngresarLoginAdmin = new JButton("INGRESAR");
		btnIngresarLoginAdmin.setForeground(new Color(255, 255, 255));
		btnIngresarLoginAdmin.setBackground(new Color(128, 191, 33));
		btnIngresarLoginAdmin.addActionListener(this);
		btnIngresarLoginAdmin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnIngresarLoginAdmin.setBounds(337, 367, 127, 36);
		panel.add(btnIngresarLoginAdmin);
		btnIngresarLoginAdmin.setContentAreaFilled(false); 
		btnIngresarLoginAdmin.setOpaque(true);
		btnIngresarLoginAdmin.setIcon(ingresarLogin);
		
		btnVolver = new JButton("VOLVER");
		btnVolver.setBounds(185, 367, 127, 36);
		panel.add(btnVolver);
		btnVolver.setForeground(new Color(255, 255, 255));
		btnVolver.setBackground(new Color(96, 125, 139)); // color deseado ROJO
		btnVolver.addActionListener(this);
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnVolver.setContentAreaFilled(false); 
		btnVolver.setOpaque(true);
		btnVolver.setIcon(volver);
	}
	
	public void setModo(String modo) {
        this.tipoAcceso = modo;
        if (modo.equals("MANTENIMIENTO")) {
            lbltitulo.setText("LOGIN  MANTENIMIENTO");
            lbltitulo.setIcon(iconoMantenimiento);
        } else {
            lbltitulo.setText("LOGIN DE LOS REPORTES");
            lbltitulo.setIcon(iconoReportes);
        }
    }
	
	@Override
	public void actionPerformed(ActionEvent e) {

	    if (e.getSource() == btnVolver) {
	        ventanaPrincipal.Panel_inicio();
	        return;
	    }

	    if (e.getSource() == btnIngresarLoginAdmin) {

	        String usuario = txtAdminDni.getText();
	        String password = new String(passwordAdmin.getPassword());

	        
	        boolean acceso = Metodo_login_administrador.validarLogin(
	                tipoAcceso, usuario, password
	        );

	        if (acceso) {
	            // Si es correcto, navegamos
	            if ("MANTENIMIENTO".equals(tipoAcceso)) {
	                ventanaPrincipal.Menu_mantenimiento();
	            } else if ("REPORTES".equals(tipoAcceso)) {
	                ventanaPrincipal.Menu_reportes();
	            }
	        } else {
	            // --- INTEGRACIÓN DE JOPTIONPANE ---
	            javax.swing.JOptionPane.showMessageDialog(
	                this, 
	                "Usuario o contraseña incorrectos para el acceso a " + tipoAcceso, 
	                "Error de Autenticación", 
	                javax.swing.JOptionPane.ERROR_MESSAGE
	            );

	            // Limpiamos los campos para mayor comodidad del usuario
	            txtAdminDni.setText("");
	            passwordAdmin.setText("");
	            txtAdminDni.requestFocus(); // Pone el cursor de nuevo en el DNI
	        }
	    }
	}
	}


package operaciones;

import servicio.AuthService;
import servicio.Sesion;
import modelos.Cuenta;
import modelos.Usuario;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import gui.VentanaPrincipal;
import javax.swing.ImageIcon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.MatteBorder;
import datos.AlmacenDatos;

public class Login_usuario extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	private VentanaPrincipal ventanaPrincipal;
	private JTextField txtUserDni;
	private JPasswordField passwordUser;
	private JButton btnVolver;
	private JButton btnIngresarLoginUser;

	/**
	 * Create the panel.
	 */
	public Login_usuario(VentanaPrincipal principal) {
		setBackground(new Color(2, 64, 89));
		
		ImageIcon documentoIdentidad = new ImageIcon(getClass().getResource("/iconos/dni.png"));
        ImageIcon volver = new ImageIcon(getClass().getResource("/iconos/Volver.png"));
        ImageIcon ingresarLogin = new ImageIcon(getClass().getResource("/iconos/ingresar.png"));
        ImageIcon contraseñaLogin = new ImageIcon(getClass().getResource("/iconos/contraseña.png"));
        ImageIcon userOriginal = new ImageIcon(getClass().getResource("/iconos/user.png"));
        
        this.ventanaPrincipal = principal;
		setPreferredSize(new java.awt.Dimension(1000, 620));
		setLayout(null);
		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(2, 64, 89));
		panel.setBounds(181, 75, 677, 491);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblIngresaTusCredenciales = new JLabel("INGRESA TUS CREDENCIALES PARA INICIAR SESION");
		lblIngresaTusCredenciales.setForeground(new Color(255, 255, 255));
		lblIngresaTusCredenciales.setBounds(35, 43, 597, 29);
		lblIngresaTusCredenciales.setIcon(userOriginal);
		lblIngresaTusCredenciales.setIconTextGap(10);
		panel.add(lblIngresaTusCredenciales);
		lblIngresaTusCredenciales.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JLabel lblDni = new JLabel("DNI:");
		lblDni.setForeground(new Color(255, 255, 255));
		lblDni.setBackground(new Color(255, 255, 255));
		lblDni.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDni.setIcon(documentoIdentidad);
		lblDni.setBounds(187, 142, 93, 13);
		lblDni.setIcon(documentoIdentidad);
		panel.add(lblDni);
		
		txtUserDni = new JTextField();
		txtUserDni.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtUserDni.setBounds(185, 171, 279, 29);
		panel.add(txtUserDni);
		txtUserDni.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Password:");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(185, 241, 116, 29);
		lblNewLabel.setIcon(contraseñaLogin);
		panel.add(lblNewLabel);
		
		passwordUser = new JPasswordField();
		passwordUser.setBounds(187, 281, 277, 29);
		panel.add(passwordUser);
		
		btnIngresarLoginUser = new JButton("INGRESAR");
		btnIngresarLoginUser.setForeground(new Color(255, 255, 255));
		btnIngresarLoginUser.setBackground(new Color(128, 191, 33));
		btnIngresarLoginUser.addActionListener(this);
		btnIngresarLoginUser.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnIngresarLoginUser.setBounds(335, 367, 127, 36);
		panel.add(btnIngresarLoginUser);
		btnIngresarLoginUser.setContentAreaFilled(false);
		btnIngresarLoginUser.setIcon(ingresarLogin);
		btnIngresarLoginUser.setOpaque(true);
		
		btnVolver = new JButton("VOLVER");
		btnVolver.setBounds(187, 367, 127, 36);
		panel.add(btnVolver);
		btnVolver.setForeground(new Color(255, 255, 255));
		btnVolver.setBackground(new Color(96, 125, 139));
		btnVolver.addActionListener(this);
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnVolver.setContentAreaFilled(false); 
		btnVolver.setIcon(volver);
		btnVolver.setOpaque(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == btnVolver) {
	        ventanaPrincipal.Panel_inicio();
	    }
		if (e.getSource() == btnIngresarLoginUser) {
		    String dni = txtUserDni.getText().trim();
		    String pass = new String(passwordUser.getPassword()).trim();

		    if (dni.isEmpty() || pass.isEmpty()) {
		        JOptionPane.showMessageDialog(this, "Ingrese DNI y clave.");
		        return;
		    }

		    Usuario u = AlmacenDatos.clientePorDni(dni);
		    if (u == null) {
		        JOptionPane.showMessageDialog(this, "El DNI no está registrado.");
		        return;
		    }

		    if (!u.getPassword().equals(pass)) {
		        JOptionPane.showMessageDialog(this, "Contraseña incorrecta.");
		        return;
		    }

		    Cuenta c = AlmacenDatos.cuentaPorDni(dni);
		    if (c == null) {
		        JOptionPane.showMessageDialog(this, "Este usuario no tiene una cuenta activa.");
		        return;
		    }
		    
		    Sesion.fijar(u);
		    ventanaPrincipal.setSesion(u, c); 

		    txtUserDni.setText("");
		    passwordUser.setText("");

		    ventanaPrincipal.menu_usuario();
		}

		
	}


}


package gui;

import javax.swing.JPanel;
import javax.swing.JTextPane;
import java.awt.Color;

public class Login_administrador extends JPanel {

	private static final long serialVersionUID = 1L;
	private VentanaPrincipal ventanaPrincipal;
	/**
	 * Create the panel.
	 * @param ventanaPrincipal 
	 */
	public Login_administrador(VentanaPrincipal principal) {
		this.ventanaPrincipal = principal;
		setPreferredSize(new java.awt.Dimension(1280, 720));
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(488, 113, 453, 525);
		add(panel);

	}
}

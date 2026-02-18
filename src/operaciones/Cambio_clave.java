package operaciones;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import gui.VentanaPrincipal;
import modelos.Usuario;

public class Cambio_clave extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;

	// DM atributo de clases
	private VentanaPrincipal ventanaPrincipal;

	private JPasswordField txtClaveActual;
	private JPasswordField txtClaveNueva;
	private JPasswordField txtConfirmarClave;

	private JButton btnVolver;
	private JButton btnCancelar;
	private JButton btnCambiar;

	private JPanel cajaAzul;

	public Cambio_clave(VentanaPrincipal principal) {

		this.ventanaPrincipal = principal;

		// CONFIGURACIÓN DEL CONTENEDOR
		setBackground(Color.WHITE);
		setBorder(new EmptyBorder(10, 10, 10, 10));
		setPreferredSize(new java.awt.Dimension(1000, 620));
		setLayout(null);

		// ESTRUCTURAS DE ETIQUETAS
		JLabel lblTitulo = new JLabel("CAMBIO DE CLAVE");
		lblTitulo.setForeground(new Color(2, 64, 89));
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(200, 54, 600, 40);
		add(lblTitulo);

		// ESTRUCTURAS DE BOTONES
		btnVolver = new JButton("< Volver");
		btnVolver.setForeground(Color.WHITE);
		btnVolver.setBackground(new Color(128, 191, 33));
		btnVolver.addActionListener(this);
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnVolver.setBounds(10, 15, 110, 35);
		btnVolver.setContentAreaFilled(false);
		btnVolver.setOpaque(true);
		add(btnVolver);

		// CONTENEDOR SECUNDARIO
		cajaAzul = new JPanel();
		cajaAzul.setBackground(new Color(2, 64, 89));
		cajaAzul.setBounds(200, 127, 600, 420);
		cajaAzul.setLayout(null);
		add(cajaAzul);

		JSeparator separator = new JSeparator();
		separator.setBounds(50, 30, 500, 2);
		cajaAzul.add(separator);

		JLabel lblClaveActual = new JLabel("Clave Actual:");
		lblClaveActual.setForeground(Color.WHITE);
		lblClaveActual.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblClaveActual.setBounds(60, 60, 200, 30);
		cajaAzul.add(lblClaveActual);

		txtClaveActual = new JPasswordField();
		txtClaveActual.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtClaveActual.setBounds(280, 60, 220, 35);
		cajaAzul.add(txtClaveActual);

		// Nueva clave
		JLabel lblClaveNueva = new JLabel("Nueva Clave:");
		lblClaveNueva.setForeground(Color.WHITE);
		lblClaveNueva.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblClaveNueva.setBounds(60, 120, 200, 30);
		cajaAzul.add(lblClaveNueva);

		txtClaveNueva = new JPasswordField();
		txtClaveNueva.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtClaveNueva.setBounds(280, 120, 220, 35);
		cajaAzul.add(txtClaveNueva);

		// Confirmar clave
		JLabel lblConfirmar = new JLabel("Confirmar Clave:");
		lblConfirmar.setForeground(Color.WHITE);
		lblConfirmar.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblConfirmar.setBounds(60, 182, 200, 30);
		cajaAzul.add(lblConfirmar);

		txtConfirmarClave = new JPasswordField();
		txtConfirmarClave.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtConfirmarClave.setBounds(280, 180, 220, 35);
		cajaAzul.add(txtConfirmarClave);

		Color verdeBoton = new Color(128, 191, 33);

		// Botón de acción principal
		btnCambiar = new JButton("CAMBIAR CLAVE");
		btnCambiar.addActionListener(this);
		btnCambiar.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnCambiar.setBackground(verdeBoton);
		btnCambiar.setForeground(Color.WHITE);
		btnCambiar.setBounds(120, 260, 200, 45);
		btnCambiar.setFocusPainted(false);
		btnCambiar.setBorderPainted(false);
		btnCambiar.setOpaque(true);
		cajaAzul.add(btnCambiar);

		// Botón cancelar
		btnCancelar = new JButton("CANCELAR");
		btnCancelar.addActionListener(this);
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnCancelar.setBackground(verdeBoton);
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.setBounds(340, 260, 160, 45);
		btnCancelar.setFocusPainted(false);
		btnCancelar.setBorderPainted(false);
		btnCancelar.setOpaque(true);
		cajaAzul.add(btnCancelar);

		JLabel lblNota = new JLabel("Nota: use solo 4 dígitos numéricos.");
		lblNota.setHorizontalAlignment(SwingConstants.CENTER);
		lblNota.setForeground(Color.LIGHT_GRAY);
		lblNota.setFont(new Font("Tahoma", Font.ITALIC, 13));
		lblNota.setBounds(50, 320, 500, 20);
		cajaAzul.add(lblNota);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btnVolver) {
			ventanaPrincipal.menu_usuario();
		}

		if (e.getSource() == btnCambiar) {
			cambiarClave();
		}

		if (e.getSource() == btnCancelar) {
			ventanaPrincipal.menu_usuario();
		}
	}

	// dm met cambio clave
	private void cambiarClave() {

		Usuario u = ventanaPrincipal.getUsuarioActual();

		if (u == null) {
			JOptionPane.showMessageDialog(this, "No hay sesión activa. Inicie sesión nuevamente.");
			ventanaPrincipal.Panel_inicio();
			return;
		}

		String actual = new String(txtClaveActual.getPassword()).trim();
		String nueva  = new String(txtClaveNueva.getPassword()).trim();
		String conf   = new String(txtConfirmarClave.getPassword()).trim();

		// VALIDA  CAMPOS VACÍOS
		if (actual.isEmpty() || nueva.isEmpty() || conf.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Complete todos los campos.");
			return;
		}

		// COMPARACIÓN DE OBJETOS:
		if (!u.getPassword().equals(actual)) {
			JOptionPane.showMessageDialog(this, "La clave actual es incorrecta.");
			return;
		}

		if (!nueva.matches("\\d{4}")) {
			JOptionPane.showMessageDialog(this, "La nueva clave debe tener 4 dígitos numéricos.");
			return;
		}

		if (!nueva.equals(conf)) {
			JOptionPane.showMessageDialog(this, "La confirmación no coincide.");
			return;
		}

		u.setPassword(nueva);

		JOptionPane.showMessageDialog(this, "✅ Clave cambiada con éxito.");

		txtClaveActual.setText("");
		txtClaveNueva.setText("");
		txtConfirmarClave.setText("");

		ventanaPrincipal.menu_usuario();
	}
}

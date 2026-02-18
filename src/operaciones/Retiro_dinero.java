package operaciones;

import java.awt.Color;
import java.awt.Font;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.plaf.basic.BasicButtonUI;

import gui.VentanaPrincipal;
import modelos.Cuenta;
import servicio.CuentaService;

public class Retiro_dinero extends JPanel {

	private static final long serialVersionUID = 1L;

	private VentanaPrincipal ventanaPrincipal;
	private CuentaService cuentaService = new CuentaService();

	private JComboBox<String> comboMoneda;
	private JTextField textField_2;
	private JTextField textField_1;

	private JButton btn20, btn50, btn100, btn200, btn500, btn1000;
	private JButton btnRetirar, btnLimpiar, btnCancelar;
	private JButton btnVolver;

	public Retiro_dinero(VentanaPrincipal principal) {

		this.ventanaPrincipal = principal;

		setLayout(null);
		setBackground(Color.WHITE);

		// BOTON VOLVER
		btnVolver = new JButton("< VOLVER");
		btnVolver.setBounds(10, 11, 138, 34);
		btnVolver.setFont(new Font("Tahoma", Font.BOLD, 16));
		aplicarEstiloPrincipal(btnVolver, new Color(0, 153, 0), Color.WHITE);
		btnVolver.addActionListener(e -> ventanaPrincipal.menu_usuario());
		add(btnVolver);

		// Panel azul central
		JPanel cajaAzul = new JPanel();
		cajaAzul.setBounds(101, 118, 746, 466);
		cajaAzul.setBackground(new Color(2, 64, 89));
		cajaAzul.setLayout(null);
		add(cajaAzul);

		// botobes
		JLabel lblMoneda = new JLabel("MONEDA");
		lblMoneda.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblMoneda.setForeground(Color.WHITE);
		lblMoneda.setBounds(183, 70, 120, 25);
		cajaAzul.add(lblMoneda);

		JLabel lblSaldo = new JLabel("SALDO ACTUAL");
		lblSaldo.setForeground(Color.WHITE);
		lblSaldo.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblSaldo.setBounds(183, 135, 200, 25);
		cajaAzul.add(lblSaldo);

		JLabel lblMonto = new JLabel("MONTO A RETIRAR");
		lblMonto.setForeground(Color.WHITE);
		lblMonto.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblMonto.setBounds(183, 192, 250, 25);
		cajaAzul.add(lblMonto);

		// COMPONENTES
		comboMoneda = new JComboBox<>(new String[] { "Soles", "Dólares" });
		comboMoneda.setFont(new Font("Tahoma", Font.BOLD, 15));
		comboMoneda.setBounds(403, 63, 180, 32);
		cajaAzul.add(comboMoneda);

		textField_2 = new JTextField();
		textField_2.setForeground(new Color(154, 205, 50));
		textField_2.setEditable(false);
		textField_2.setBounds(403, 125, 180, 35);
		textField_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		cajaAzul.add(textField_2);

		textField_1 = new JTextField();
		textField_1.setBounds(403, 185, 180, 32);
		textField_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		cajaAzul.add(textField_1);

		// ===== BOTONES RÁPIDOS =====
		configurarBotonesRapidos(cajaAzul);

		// BOTONES PRINCIPALES
		btnRetirar = new JButton("RETIRAR");
		btnRetirar.setForeground(new Color(112, 128, 144));
		btnRetirar.setBounds(49, 386, 159, 40);
		btnRetirar.setFont(new Font("Tahoma", Font.BOLD, 20));
		aplicarEstiloPrincipal(btnRetirar, new Color(128, 191, 33), Color.WHITE);
		btnRetirar.addActionListener(e -> ejecutarRetiro());
		cajaAzul.add(btnRetirar);

		btnLimpiar = new JButton("LIMPIAR");
		btnLimpiar.setForeground(new Color(255, 215, 0));
		btnLimpiar.setBounds(288, 387, 151, 39);
		btnLimpiar.setFont(new Font("Tahoma", Font.BOLD, 20));
		aplicarEstiloPrincipal(btnLimpiar, new Color(255, 193, 7), Color.BLACK);
		btnLimpiar.addActionListener(e -> limpiarCampos());
		cajaAzul.add(btnLimpiar);

		btnCancelar = new JButton("CANCELAR");
		btnCancelar.setForeground(new Color(178, 34, 34));
		btnCancelar.setBounds(501, 387, 167, 39);
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 20));
		aplicarEstiloPrincipal(btnCancelar, new Color(220, 53, 69), Color.WHITE);
		btnCancelar.addActionListener(e -> ventanaPrincipal.menu_usuario());
		cajaAzul.add(btnCancelar);

		// TITULO
		JLabel lblTitulo = new JLabel("RETIRO DE DINERO");
		lblTitulo.setBounds(174, 55, 600, 40);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setForeground(new Color(2, 64, 89));
		add(lblTitulo);

		actualizarInterfaz();
	}

	private void ejecutarRetiro() {

		try {

			Cuenta cuenta = ventanaPrincipal.getCuentaActual();
			if (cuenta == null) {
				JOptionPane.showMessageDialog(this, "Error: Sesión no encontrada.");
				return;
			}

			double monto = Double.parseDouble(textField_1.getText());

			cuentaService.retirarDinero(cuenta, monto);

			JOptionPane.showMessageDialog(this,
					"Retiro exitoso.\nSu nuevo saldo es: " + String.format(Locale.US, "%.2f", cuenta.getSaldo()));

			actualizarInterfaz();
			textField_1.setText("");

		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(this, "Por favor, ingrese un monto válido.");
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(this, ex.getMessage());
		}
	}

	// formato para 2 decimales.
	public void actualizarInterfaz() {

		if (ventanaPrincipal.getCuentaActual() != null) {
			double saldoActual = ventanaPrincipal.getCuentaActual().getSaldo();
			textField_2.setText(String.format(Locale.US, "%.2f", saldoActual));
		}
	}

	private void limpiarCampos() {
		textField_1.setText("");
		actualizarInterfaz();
	}

	private void configurarBotonesRapidos(JPanel p) {

		btn20 = new JButton("20");
		btn50 = new JButton("50");
		btn100 = new JButton("100");
		btn200 = new JButton("200");
		btn500 = new JButton("500");
		btn1000 = new JButton("1000");

		JButton[] botones = { btn20, btn50, btn100, btn200, btn500, btn1000 };
		int x = 143, y = 250;

		for (int i = 0; i < botones.length; i++) {

			botones[i].setBounds(x, y, 90, 35);
			botones[i].setFont(new Font("Tahoma", Font.BOLD, 14));

			String valor = botones[i].getText();

			botones[i].addActionListener(e -> textField_1.setText(valor));
			p.add(botones[i]);

			x += 170;

			if (i == 2) {
				x = 143;
				y = 300;
			}
		}
	}

	private void aplicarEstiloPrincipal(JButton b, Color fondo, Color texto) {

		b.setUI(new BasicButtonUI());
		b.setBackground(new Color(154, 205, 50));
		b.setForeground(texto);
		b.setOpaque(true);
		b.setBorderPainted(false);
		b.setFocusPainted(false);
	}
}



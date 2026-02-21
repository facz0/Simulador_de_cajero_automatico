package consultas_busquedas;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JScrollPane;

import gui.VentanaPrincipal;
import modelos.Cuenta;
import servicio.Consultas;

import javax.swing.border.LineBorder;

public class ConsultaDeSaldo extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private VentanaPrincipal ventanaPrincipal;

	private JButton btnVolver;
	private JButton btnConsultar;
	private JTextArea textArea;
	private JLabel lblLinea;

	public ConsultaDeSaldo(VentanaPrincipal principal) {
		setBackground(new Color(2, 64, 89));
		this.ventanaPrincipal = principal;
		setPreferredSize(new java.awt.Dimension(1000, 620));
		setLayout(null);

		// ICONOS
		ImageIcon titulo = new ImageIcon(getClass().getResource("/iconos/tituloCuenta.png"));
		ImageIcon volver = new ImageIcon(getClass().getResource("/iconos/volver.png"));
		ImageIcon consultar = new ImageIcon(getClass().getResource("/iconos/ConsultaUltimo.png"));

		JLabel lblTitulo = new JLabel("CONSULTAR SALDO");
		lblTitulo.setForeground(new Color(255, 255, 255));
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblTitulo.setBounds(349, 54, 291, 50);
		lblTitulo.setIcon(titulo);
		add(lblTitulo);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(2, 64, 89));
		panel.setBounds(124, 130, 766, 479);
		panel.setLayout(null);
		add(panel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(92, 11, 561, 339);
		panel.add(scrollPane);

		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);

		btnConsultar = new JButton("CONSULTAR");
		btnConsultar.setBounds(425, 388, 228, 49);
		btnConsultar.setForeground(Color.WHITE);
		btnConsultar.setBackground(new Color(128, 191, 33));
		btnConsultar.setContentAreaFilled(false);
		btnConsultar.setOpaque(true);
		btnConsultar.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnConsultar.addActionListener(this);
		btnConsultar.setIcon(consultar);
		panel.add(btnConsultar);

		btnVolver = new JButton("VOLVER");
		btnVolver.setBounds(92, 388, 228, 49);
		panel.add(btnVolver);
		btnVolver.setForeground(Color.WHITE);
		btnVolver.setBackground(new Color(192, 57, 43));
		btnVolver.addActionListener(this);
		btnVolver.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnVolver.setContentAreaFilled(false);
		btnVolver.setIcon(volver);
		btnVolver.setOpaque(true);

		lblLinea = new JLabel("");
		lblLinea.setForeground(new Color(255, 255, 255));
		lblLinea.setBounds(218, 105, 558, 14);
		// Línea solo abajo 
		lblLinea.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
		add(lblLinea);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btnVolver) {
			ventanaPrincipal.Mis_Cuentas();
			return;
		}

		if (e.getSource() == btnConsultar) {
			Cuenta c = ventanaPrincipal.getCuentaSeleccionada();
			textArea.setText(Consultas.consultarSaldo(c));
		}
	}
}

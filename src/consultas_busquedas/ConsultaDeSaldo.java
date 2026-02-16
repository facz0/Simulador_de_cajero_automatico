package consultas_busquedas;

import javax.swing.JPanel;
import javax.swing.JLabel;
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

	public ConsultaDeSaldo(VentanaPrincipal principal) {
		setBorder(new LineBorder(new Color(0, 0, 0), 3));
		setBackground(new Color(2, 64, 89));
		this.ventanaPrincipal = principal;
		setPreferredSize(new java.awt.Dimension(1000, 620));
		setLayout(null);

		JLabel lblTitulo = new JLabel("CONSULTAR SALDO");
		lblTitulo.setForeground(new Color(255, 255, 255));
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblTitulo.setBounds(386, 11, 216, 50);
		add(lblTitulo);

		btnVolver = new JButton("< Volver");
		btnVolver.setForeground(Color.WHITE);
		btnVolver.setBackground(new Color(128, 191, 33));
		btnVolver.addActionListener(this);
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnVolver.setBounds(10, 11, 97, 35);
		btnVolver.setContentAreaFilled(false);
		btnVolver.setOpaque(true);
		add(btnVolver);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(255, 255, 255), 3));
		panel.setBackground(new Color(2, 64, 89));
		panel.setBounds(126, 78, 766, 445);
		panel.setLayout(null);
		add(panel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(281, 53, 418, 339);
		panel.add(scrollPane);

		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);

		btnConsultar = new JButton("CONSULTAR");
		btnConsultar.setBounds(94, 204, 129, 38);
		btnConsultar.setForeground(Color.WHITE);
		btnConsultar.setBackground(new Color(128, 191, 33));
		btnConsultar.setContentAreaFilled(false);
		btnConsultar.setOpaque(true);
		btnConsultar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnConsultar.addActionListener(this);
		panel.add(btnConsultar);
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

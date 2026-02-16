package consultas_busquedas;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import gui.VentanaPrincipal;

import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

import modelos.Cuenta;
import servicio.Consultas;

import javax.swing.border.LineBorder;

public class Consultas_Rango extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private VentanaPrincipal ventanaPrincipal;

	private JButton btnVolver;
	private JTextField txtDesde;
	private JTextField txtHasta;
	private JButton btnProcesar;
	private JTextArea textArea;

	public Consultas_Rango(VentanaPrincipal principal) {
		setBackground(new Color(2, 64, 89));
		this.ventanaPrincipal = principal;
		setPreferredSize(new java.awt.Dimension(1000, 620));
		setLayout(null);

		JLabel lblTitulo = new JLabel("CONSULTA DE OPERACIONES ");
		lblTitulo.setForeground(new Color(255, 255, 255));
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblTitulo.setBounds(356, 15, 332, 45);
		add(lblTitulo);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(255, 255, 255), 3));
		panel.setBackground(new Color(2, 64, 89));
		panel.setBounds(122, 85, 769, 426);
		panel.setLayout(null);
		add(panel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(297, 47, 403, 333);
		panel.add(scrollPane);

		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);

		btnProcesar = new JButton("PROCESAR");
		btnProcesar.setBounds(45, 249, 125, 39);
		btnProcesar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnProcesar.setBackground(new Color(128, 191, 33));
		btnProcesar.setContentAreaFilled(false);
		btnProcesar.setOpaque(true);
		btnProcesar.setForeground(Color.WHITE);
		btnProcesar.addActionListener(this);
		panel.add(btnProcesar);

		JLabel lblDesde = new JLabel("DESDE:");
		lblDesde.setBounds(45, 43, 86, 35);
		lblDesde.setForeground(Color.WHITE);
		lblDesde.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel.add(lblDesde);

		txtDesde = new JTextField("DD/MM/AAAA");
		txtDesde.setBounds(45, 77, 120, 20);
		panel.add(txtDesde);

		JLabel lblHasta = new JLabel("HASTA:");
		lblHasta.setBounds(45, 135, 86, 35);
		lblHasta.setForeground(Color.WHITE);
		lblHasta.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel.add(lblHasta);

		txtHasta = new JTextField("DD/MM/AAAA");
		txtHasta.setBounds(45, 174, 120, 20);
		panel.add(txtHasta);

		btnVolver = new JButton("< Volver");
		btnVolver.setForeground(Color.WHITE);
		btnVolver.setBackground(new Color(128, 191, 33));
		btnVolver.addActionListener(this);
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnVolver.setBounds(10, 11, 97, 35);
		btnVolver.setContentAreaFilled(false);
		btnVolver.setOpaque(true);
		add(btnVolver);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btnVolver) {
			ventanaPrincipal.Mis_Cuentas();
			return;
		}

		if (e.getSource() == btnProcesar) {
			Cuenta c = ventanaPrincipal.getCuentaSeleccionada();
			textArea.setText(Consultas.movimientosPorRango(c, txtDesde.getText(), txtHasta.getText()));
		}
	}
}

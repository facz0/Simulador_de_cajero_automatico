package consultas_busquedas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import datos.AlmacenDatos;
import gui.VentanaPrincipal;
import modelos.Cuenta;
import modelos.Usuario;
import servicio.Sesion;

import javax.swing.border.LineBorder;

public class MisCuentas extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;

	private VentanaPrincipal ventanaPrincipal;
	private JButton btnVolver;
	private JPanel panel;
	private JComboBox<Cuenta> comboBox;
	private JButton btnConsultaSaldo;
	private JButton btnConsultasRango;
	private JButton btnUltimosMovimientos;

	private Cuenta cuentaSeleccionada;

	// Refrescar lista cuando entras al módulo
	public void refrescar() {
		cargarCuentas();
	}

	public MisCuentas(VentanaPrincipal principal) {
		setBackground(new Color(2, 64, 89));
		this.ventanaPrincipal = principal;
		setPreferredSize(new java.awt.Dimension(1000, 620));
		setLayout(null);

		JLabel lblTitulo = new JLabel("CONSULTAS");
		lblTitulo.setForeground(new Color(255, 255, 255));
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblTitulo.setBounds(432, 17, 158, 50);
		add(lblTitulo);

		btnVolver = new JButton("< Volver");
		btnVolver.setForeground(Color.WHITE);
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnVolver.setBackground(new Color(128, 191, 33));
		btnVolver.setBounds(10, 11, 97, 35);
		btnVolver.setContentAreaFilled(false);
		btnVolver.setOpaque(true);
		btnVolver.addActionListener(this);
		add(btnVolver);

		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(255, 255, 255), 3));
		panel.setLayout(null);
		panel.setBackground(new Color(2, 64, 89));
		panel.setBounds(126, 78, 766, 445);
		add(panel);

		JLabel lblMisCuentas = new JLabel("MIS CUENTAS");
		lblMisCuentas.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblMisCuentas.setForeground(Color.WHITE);
		lblMisCuentas.setBounds(313, 11, 153, 40);
		panel.add(lblMisCuentas);

		JLabel lblSeleccion = new JLabel("SELECCIONE UNA CUENTA");
		lblSeleccion.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSeleccion.setForeground(Color.WHITE);
		lblSeleccion.setBounds(287, 52, 215, 32);
		panel.add(lblSeleccion);

		comboBox = new JComboBox<Cuenta>();
		comboBox.setBounds(117, 95, 532, 22);
		panel.add(comboBox);

		btnConsultaSaldo = new JButton("CONSULTAR SALDO");
		btnConsultaSaldo.setForeground(Color.WHITE);
		btnConsultaSaldo.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnConsultaSaldo.setFocusPainted(false);
		btnConsultaSaldo.setBackground(new Color(128, 191, 33));
		btnConsultaSaldo.setBounds(245, 156, 299, 50);
		btnConsultaSaldo.setContentAreaFilled(false);
		btnConsultaSaldo.setOpaque(true);
		btnConsultaSaldo.addActionListener(this);
		panel.add(btnConsultaSaldo);

		btnUltimosMovimientos = new JButton("ULTIMOS MOVIMIENTOS");
		btnUltimosMovimientos.setForeground(Color.WHITE);
		btnUltimosMovimientos.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnUltimosMovimientos.setFocusPainted(false);
		btnUltimosMovimientos.setBackground(new Color(128, 191, 33));
		btnUltimosMovimientos.setBounds(245, 247, 299, 50);
		btnUltimosMovimientos.setContentAreaFilled(false);
		btnUltimosMovimientos.setOpaque(true);
		btnUltimosMovimientos.addActionListener(this);
		panel.add(btnUltimosMovimientos);

		btnConsultasRango = new JButton(" POR RANGO DE FECHA");
		btnConsultasRango.setForeground(Color.WHITE);
		btnConsultasRango.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnConsultasRango.setFocusPainted(false);
		btnConsultasRango.setBackground(new Color(128, 191, 33));
		btnConsultasRango.setBounds(245, 344, 299, 50);
		btnConsultasRango.setContentAreaFilled(false);
		btnConsultasRango.setOpaque(true);
		btnConsultasRango.addActionListener(this);
		panel.add(btnConsultasRango);
	}

	private void cargarCuentas() {
		comboBox.removeAllItems();

		// usuario logueado desde Sesion
		Usuario usuarioActual = Sesion.obtener();

		if (usuarioActual == null) {
			JOptionPane.showMessageDialog(this, "No hay usuario logueado.");
			return;
		}

		for (int i = 0; i < AlmacenDatos.listaCuentas.size(); i++) {

			Cuenta c = AlmacenDatos.listaCuentas.get(i);

			if (c != null && c.getUsuario() != null && c.getUsuario().getDNI() != null) {

				if (c.getUsuario().getDNI().equals(usuarioActual.getDNI())) {
					comboBox.addItem(c);
				}
			}
		}

		// seleccionar automáticamente la primera cuenta
		if (comboBox.getItemCount() > 0) {
			comboBox.setSelectedIndex(0);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btnVolver) {
			ventanaPrincipal.menu_usuario();
			return;
		}

		cuentaSeleccionada = (Cuenta) comboBox.getSelectedItem();

		if (cuentaSeleccionada == null) {
			JOptionPane.showMessageDialog(this, "Seleccione una cuenta primero.");
			return;
		}

		if (e.getSource() == btnConsultaSaldo) {
			ventanaPrincipal.irConsultaSaldo(cuentaSeleccionada);
			return;
		}

		if (e.getSource() == btnUltimosMovimientos) {
			ventanaPrincipal.irUltimosMovimientos(cuentaSeleccionada);
			return;
		}

		if (e.getSource() == btnConsultasRango) {
			ventanaPrincipal.irConsultaRango(cuentaSeleccionada);
			return;
		}
	}
}

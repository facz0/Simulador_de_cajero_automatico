package consultas_busquedas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelos.Usuario;
import servicio.Sesion;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import datos.AlmacenDatos;
import gui.VentanaPrincipal;
import modelos.Cuenta;
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
	private JLabel lblLinea;
	private Cuenta cuentaSeleccionada;
	
	public void refrescar() {
	    cargarCuentas();
	}


	public MisCuentas(VentanaPrincipal principal) {
		setBackground(new Color(2, 64, 89));
		this.ventanaPrincipal = principal;
		setPreferredSize(new java.awt.Dimension(1000, 620));
		setLayout(null);

		//ICONOS
        ImageIcon consulta = new ImageIcon(getClass().getResource("/iconos/tituloConsulta.png"));
        ImageIcon movimiento = new ImageIcon(getClass().getResource("/iconos/tituloMovimiento.png"));
        ImageIcon saldo = new ImageIcon(getClass().getResource("/iconos/cuentaBancaria.png"));
        ImageIcon fecha = new ImageIcon(getClass().getResource("/iconos/calendarioReporte.png"));
        ImageIcon salir = new ImageIcon(getClass().getResource("/iconos/salirReporte.png"));

		JLabel lblTitulo = new JLabel("CONSULTA MIS CUENTAS");
		lblTitulo.setForeground(new Color(255, 255, 255));
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblTitulo.setBounds(329, 58, 766, 50);
		lblTitulo.setIcon(consulta);
		add(lblTitulo);
		
		lblLinea = new JLabel("");
		lblLinea.setBounds(107, 107, 788, 14);
		add(lblLinea);
		lblLinea.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));

		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(2, 64, 89));
		panel.setBounds(129, 137, 766, 370);
		add(panel);

		JLabel lblSeleccion = new JLabel("SELECCIONE UNA CUENTA:");
		lblSeleccion.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSeleccion.setForeground(Color.WHITE);
		lblSeleccion.setBounds(272, 0, 215, 32);
		panel.add(lblSeleccion);

		comboBox = new JComboBox<>();
		comboBox.setBounds(222, 46, 306, 22);
		panel.add(comboBox);
		

		btnConsultaSaldo = new JButton("CONSULTAR SALDO");
		btnConsultaSaldo.setForeground(Color.WHITE);
		btnConsultaSaldo.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnConsultaSaldo.setFocusPainted(false);
		btnConsultaSaldo.setBackground(new Color(128, 191, 33));
		btnConsultaSaldo.setBounds(222, 116, 306, 50);
		btnConsultaSaldo.setContentAreaFilled(false);
		btnConsultaSaldo.setOpaque(true);
		btnConsultaSaldo.addActionListener(this);
		btnConsultaSaldo.setIcon(saldo);
		panel.add(btnConsultaSaldo);

		btnUltimosMovimientos = new JButton("ULTIMOS MOVIMIENTOS");
		btnUltimosMovimientos.setForeground(Color.WHITE);
		btnUltimosMovimientos.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnUltimosMovimientos.setFocusPainted(false);
		btnUltimosMovimientos.setBackground(new Color(128, 191, 33));
		btnUltimosMovimientos.setBounds(222, 199, 306, 50);
		btnUltimosMovimientos.setContentAreaFilled(false);
		btnUltimosMovimientos.setOpaque(true);
		btnUltimosMovimientos.addActionListener(this);
		btnUltimosMovimientos.setIcon(movimiento);
		panel.add(btnUltimosMovimientos);

		btnConsultasRango = new JButton(" POR RANGO DE FECHA");
		btnConsultasRango.setForeground(Color.WHITE);
		btnConsultasRango.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnConsultasRango.setFocusPainted(false);
		btnConsultasRango.setBackground(new Color(128, 191, 33));
		btnConsultasRango.setBounds(222, 286, 306, 50);
		btnConsultasRango.setContentAreaFilled(false);
		btnConsultasRango.setOpaque(true);
		btnConsultasRango.addActionListener(this);
		btnConsultasRango.setIcon(fecha);
		panel.add(btnConsultasRango);
		
		btnVolver = new JButton("SALIR");
		btnVolver.setBounds(349, 508, 309, 50);
		add(btnVolver);
		btnVolver.setForeground(Color.WHITE);
		btnVolver.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnVolver.setBackground(new Color(96, 125, 139));
		btnVolver.setContentAreaFilled(false);
		btnVolver.setOpaque(true);
		btnVolver.setIcon(salir);
		btnVolver.addActionListener(this);
	}

	private void cargarCuentas() {
	    comboBox.removeAllItems();
	    Usuario usuarioActual = Sesion.obtener();
	    if (usuarioActual == null) {
	        JOptionPane.showMessageDialog(this, "No hay usuario logueado.");
	        return;
	    }

	    for (int i = 0; i < AlmacenDatos.listaCuentas.size(); i++) {
	        Cuenta c = AlmacenDatos.listaCuentas.get(i);
	        
	        if (c.getUsuario() != null && c.getUsuario().getDNI().equals(usuarioActual.getDNI())) {
	            comboBox.addItem(c);
	        }
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

		// ✅ OPCIÓN 1: SOLO IFs
		if (e.getSource() == btnConsultaSaldo) {
			ventanaPrincipal.irConsultaSaldo(cuentaSeleccionada);
		}

		if (e.getSource() == btnUltimosMovimientos) {
			ventanaPrincipal.irUltimosMovimientos(cuentaSeleccionada);
		}

		if (e.getSource() == btnConsultasRango) {
			ventanaPrincipal.irConsultaRango(cuentaSeleccionada);
		}
	}
}

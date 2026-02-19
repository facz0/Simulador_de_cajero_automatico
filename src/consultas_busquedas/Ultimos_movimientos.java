package consultas_busquedas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;

import gui.VentanaPrincipal;
import modelos.Cuenta;
import modelos.Transaccion;
import modelos.Usuario;
import servicio.Consultas;
import servicio.Sesion;
import servicio.TransaccionService;

import javax.swing.border.LineBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import datos.AlmacenDatos;
import servicio.Consultas;

public class Ultimos_movimientos extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private VentanaPrincipal ventanaPrincipal;

	private JButton btnListar;
	private JButton btnVolver;
	private JTextArea textArea;
	private JPanel panel;
	private JTable tabla;
	private DefaultTableModel modelo;
	private JScrollPane scrollPane;

	public Ultimos_movimientos(VentanaPrincipal principal) {
		setBackground(new Color(2, 64, 89));
		this.ventanaPrincipal = principal;
		setPreferredSize(new java.awt.Dimension(1000, 620));
		setLayout(null);

		JLabel lblTitulo = new JLabel("Últimos movimientos");
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblTitulo.setBounds(399, 11, 272, 39);
		add(lblTitulo);

		btnListar = new JButton("LISTAR");
		btnListar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnListar.setBounds(387, 99, 232, 45);
		btnListar.setForeground(Color.WHITE);
		btnListar.setBackground(new Color(128, 191, 33));
		btnListar.setContentAreaFilled(false);
		btnListar.setOpaque(true);
		btnListar.addActionListener(this);
		add(btnListar);
		
		String[] columnas = {"Fecha", "Tipo", "Monto"};
		modelo = new DefaultTableModel(null, columnas) {
			@Override
			public boolean isCellEditable(int row, int column) { //hacer no editable las celdas
				return false;
			}
		};
		
		tabla = new JTable(modelo);
		scrollPane = new JScrollPane(tabla); 
		scrollPane.setBounds(224, 191, 555, 329);
		add(scrollPane);
		cargarDatos();

		btnVolver = new JButton("< Volver");
		btnVolver.setForeground(Color.WHITE);
		btnVolver.setBackground(new Color(128, 191, 33));
		btnVolver.addActionListener(this);
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnVolver.setBounds(10, 15, 97, 35);
		btnVolver.setContentAreaFilled(false);
		btnVolver.setOpaque(true);
		add(btnVolver);
		
		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(255, 255, 255), 3));
		panel.setBackground(new Color(2, 64, 89));
		panel.setBounds(130, 83, 761, 495);
		add(panel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btnVolver) {
			ventanaPrincipal.Mis_Cuentas();
			return;
		}

		if (e.getSource() == btnListar) {
			Cuenta c = ventanaPrincipal.getCuentaSeleccionada();
			modelo.setRowCount(0);

			for (Object[] fila : Consultas.ultimosMovimientosFilas(c, 5)) {
				modelo.addRow(fila);
			}
		}
	}
	
	public void cargarDatos() {
		modelo.setRowCount(0);
		
		Cuenta cuentaSeleccionada = ventanaPrincipal.getCuentaSeleccionada();
	    if (cuentaSeleccionada == null) return;

	    ArrayList<Object[]> filas = (ArrayList<Object[]>) Consultas.ultimosMovimientosFilas(cuentaSeleccionada, 5);

	    for (int i = 0; i < filas.size(); i++) {
	        modelo.addRow(filas.get(i));
	    }
	}
}

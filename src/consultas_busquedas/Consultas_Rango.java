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
import java.util.ArrayList;
import java.awt.Color;

import modelos.Cuenta;
import modelos.Transaccion;
import modelos.Usuario;
import servicio.Consultas;
import servicio.Sesion;
import servicio.TransaccionService;

import javax.swing.border.LineBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import servicio.Consultas;

public class Consultas_Rango extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private VentanaPrincipal ventanaPrincipal;

	private JButton btnVolver;
	private JTextField txtDesde;
	private JTextField txtHasta;
	private JButton btnProcesar;
	private JTextArea textArea;
	private JTable tabla;
	private DefaultTableModel modelo;
	private JScrollPane scrollPane;

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

		String[] columnas = {"Fecha", "Tipo", "Monto"};
		modelo = new DefaultTableModel(null, columnas) {
			@Override
			public boolean isCellEditable(int row, int column) { //hacer no editable las celdas
				return false;
			}
		};
		cargarDatos();

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
		
				textArea = new JTextArea();
				textArea.setBounds(217, 30, 401, 331);
				panel.add(textArea);
				
				tabla = new JTable(modelo);
				scrollPane = new JScrollPane(tabla);
				scrollPane.setBounds(217, 30, 403, 333);
				panel.add(scrollPane);

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
			modelo.setRowCount(0);
			ArrayList<Object[]> listaMovimientos = (ArrayList<Object[]>) Consultas.movimientosPorRangoFilas(c, txtDesde.getText(), txtHasta.getText());
			for (int i = 0; i < listaMovimientos.size(); i++) {
				Object[] fila = listaMovimientos.get(i);
				modelo.addRow(fila);
			}
		}
	}
	
	public void cargarDatos() {
		modelo.setRowCount(0);
		TransaccionService service = new TransaccionService();
		ArrayList<Transaccion> listaMovimientos = service.listarTransacciones();
		
		for(int i = 0; i < listaMovimientos.size(); i++) {
			Transaccion t = listaMovimientos.get(i);
			Object[] fila = {
					t.getFechaFormateada(),
					t.getTipo(),
					t.getMonto()
			};
			modelo.addRow(fila);
		}
		
	}
}

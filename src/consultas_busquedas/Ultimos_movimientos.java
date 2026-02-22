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
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
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
	private JLabel lblLinea;

	public Ultimos_movimientos(VentanaPrincipal principal) {
		setBackground(new Color(2, 64, 89));
		this.ventanaPrincipal = principal;
		setPreferredSize(new java.awt.Dimension(1000, 620));
		setLayout(null);
		
		ImageIcon titulo = new ImageIcon(getClass().getResource("/iconos/tituloGrangeMoviento.png"));
	    ImageIcon listar = new ImageIcon(getClass().getResource("/iconos/listarReporte.png"));
	    ImageIcon volver = new ImageIcon(getClass().getResource("/iconos/volver.png"));    

		JLabel lblTitulo = new JLabel("ÚLTIMOS MOVIMIENTOS");
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setFont(new Font("Tahoma",Font.BOLD, 25));
		lblTitulo.setBounds(328, 66, 359, 39);
		lblTitulo.setIcon(titulo);
		add(lblTitulo);

		btnListar = new JButton("LISTAR");
		btnListar.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnListar.setBounds(547, 513, 232, 45);
		btnListar.setForeground(Color.WHITE);
		btnListar.setBackground(new Color(128, 191, 33));
		btnListar.setContentAreaFilled(false);
		btnListar.setOpaque(true);
		btnListar.addActionListener(this);
		btnListar.setIcon(listar);
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
		scrollPane.setBounds(224, 148, 555, 328);
		add(scrollPane);
		cargarDatos();

		btnVolver = new JButton("VOLVER");
		btnVolver.setForeground(Color.WHITE);
		btnVolver.setBackground(new Color(192, 57, 43));
		btnVolver.addActionListener(this);
		btnVolver.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnVolver.setBounds(229, 513, 232, 45);
		btnVolver.setContentAreaFilled(false);
		btnVolver.setOpaque(true);
		btnVolver.setIcon(volver);
		add(btnVolver);
		
		panel = new JPanel();
		panel.setBackground(new Color(2, 64, 89));
		panel.setBounds(131, 133, 761, 360);
		add(panel);
		
		lblLinea = new JLabel("");
		lblLinea.setForeground(new Color(255, 255, 255));
		lblLinea.setBounds(224, 108, 555, 14);
		lblLinea.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
		add(lblLinea);
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
			ArrayList<Object[]> listaFilas = (ArrayList<Object[]>) Consultas.ultimosMovimientosFilas(c, 5);
			for (int i = 0; i < listaFilas.size(); i++) {
				Object[] fila = listaFilas.get(i);
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

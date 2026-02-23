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
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
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
	private JLabel lblLinea;

	public Consultas_Rango(VentanaPrincipal principal) {
		setBackground(new Color(2, 64, 89));
		this.ventanaPrincipal = principal;
		setPreferredSize(new java.awt.Dimension(1000, 620));
		setLayout(null);
		
		//ICONOS
        ImageIcon titulo = new ImageIcon(getClass().getResource("/iconos/tituloGrangeMoviento.png"));
        ImageIcon volver = new ImageIcon(getClass().getResource("/iconos/volver.png"));
        ImageIcon fecha = new ImageIcon(getClass().getResource("/iconos/calendarioReporte.png"));
        ImageIcon procesar = new ImageIcon(getClass().getResource("/iconos/generarReporte.png"));

		JLabel lblTitulo = new JLabel("CONSULTA DE OPERACIONES ");
		lblTitulo.setForeground(new Color(255, 255, 255));
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblTitulo.setBounds(311, 61, 422, 45);
		lblTitulo.setIcon(titulo);
		add(lblTitulo);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(2, 64, 89));
		panel.setBounds(126, 117, 769, 470);
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
		btnProcesar.setBounds(519, 380, 181, 39);
		btnProcesar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnProcesar.setBackground(new Color(128, 191, 33));
		btnProcesar.setContentAreaFilled(false);
		btnProcesar.setOpaque(true);
		btnProcesar.setForeground(Color.WHITE);
		btnProcesar.addActionListener(this);
		btnProcesar.setIcon(procesar);
		panel.add(btnProcesar);

		JLabel lblDesde = new JLabel("DESDE:");
		lblDesde.setBounds(45, 43, 86, 35);
		lblDesde.setForeground(Color.WHITE);
		lblDesde.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDesde.setIcon(fecha);
		panel.add(lblDesde);

		txtDesde = new JTextField("DD/MM/AAAA");
		txtDesde.setBounds(45, 83, 156, 41);
		panel.add(txtDesde);

		JLabel lblHasta = new JLabel("HASTA:");
		lblHasta.setBounds(45, 135, 86, 35);
		lblHasta.setForeground(Color.WHITE);
		lblHasta.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblHasta.setIcon(fecha);
		panel.add(lblHasta);
				
		tabla = new JTable(modelo);
		scrollPane = new JScrollPane(tabla);
		scrollPane.setBounds(297, 56, 403, 297);
		panel.add(scrollPane);
		
		lblLinea = new JLabel("");
		lblLinea.setBounds(0, 0, 769, 14);
		panel.add(lblLinea);
		lblLinea.setForeground(new Color(255, 255, 255));
		// Línea solo abajo 
		lblLinea.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));

		txtHasta = new JTextField("DD/MM/AAAA");
		txtHasta.setBounds(45, 176, 156, 40);
		panel.add(txtHasta);
		
				btnVolver = new JButton("VOLVER");
				btnVolver.setBounds(297, 380, 181, 39);
				panel.add(btnVolver);
				btnVolver.setForeground(Color.WHITE);
				btnVolver.setBackground(new Color(192, 57, 43));
				btnVolver.addActionListener(this);
				btnVolver.setFont(new Font("Tahoma", Font.BOLD, 15));
				btnVolver.setContentAreaFilled(false);
				btnVolver.setOpaque(true);
				btnVolver.setIcon(volver);
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
		Usuario usuarioActual = Sesion.obtener();
		if (usuarioActual == null) {
	        return; 
	    }
		Cuenta cuentaSeleccionada = ventanaPrincipal.getCuentaSeleccionada();
		if (cuentaSeleccionada == null) {
	        return;
	    }
		String numeroDeCuentaString = cuentaSeleccionada.getNumeroCuenta();
		TransaccionService service = new TransaccionService();
		ArrayList<Transaccion> listaMovimientos = service.listarPorCuenta(numeroDeCuentaString);
		if (listaMovimientos == null) {
	        return; 
	    }
		
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
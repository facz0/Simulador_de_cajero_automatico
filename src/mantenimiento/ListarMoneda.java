package mantenimiento;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import modelos.Moneda;
import servicio.MonedaService;

public class ListarMoneda extends JPanel {

	private static final long serialVersionUID = 1L;
	private DefaultTableModel modelo;
	private JTable tableMonedas;
	private JScrollPane scrollPane;
	/**
	 * Create the panel.
	 */
	public ListarMoneda() {
		setLayout(null);
		setBackground(new Color(255, 255, 255));
		setPreferredSize(new java.awt.Dimension(612, 455));
		setLayout(null);
		
		String[] columnas = {"Nombre", "Símbolo", "Tipo de cambio"};
		modelo = new DefaultTableModel(null, columnas) {
			@Override
			public boolean isCellEditable(int row, int column) { //hacer no editable las celdas
				return false;
			}
		};
		
		tableMonedas = new JTable(modelo);
		scrollPane = new JScrollPane(tableMonedas);
		scrollPane.setBounds(0, -1, 612, 455);
		add(scrollPane);
		cargarDatos();
	}
	
	public void cargarDatos() {
		modelo.setRowCount(0);
		
		MonedaService service = new MonedaService();
		ArrayList<Moneda> lista = service.listarMoneda();
		for(int i = 0; i < lista.size(); i++) {
			Moneda moneda = lista.get(i);
			Object[] fila = {
					moneda.getNombre(),
					moneda.getIdMoneda(),
					moneda.getTipoCambio()
			};
			modelo.addRow(fila);
		}
	}

}

package mantenimiento;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import modelos.Cuenta;
import servicio.CuentaService;

public class ListarCuenta extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	private DefaultTableModel modelo;
	private JTable tableCuentas;
	private JScrollPane scrollPane;

	/**
	 * Create the panel.
	 */
	public ListarCuenta() {
		setLayout(null);
		setBackground(new Color(255, 255, 255));
		setPreferredSize(new java.awt.Dimension(612, 455));
		setLayout(null);
		
		String[] columnas = {"Número de cuenta", "Usuario", "Moneda", "Saldo", "Estado"};
		modelo = new DefaultTableModel(null, columnas) {
			@Override
			public boolean isCellEditable(int row, int column) { //hacer no editable las celdas
				return false;
			}
		};
		
		tableCuentas = new JTable(modelo);
		scrollPane = new JScrollPane(tableCuentas);
		scrollPane.setBounds(0, 0, 612, 455);
		add(scrollPane);
		cargarDatos();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void cargarDatos() {
		modelo.setRowCount(0);
		
		CuentaService service = new CuentaService();
		ArrayList<Cuenta> lista = service.listarCuenta();
		
		for(int i = 0; i < lista.size(); i++) {
			Cuenta cuenta = lista.get(i);
			Object[] fila = {
					cuenta.getNumeroCuenta(),
					cuenta.getUsuario().getNombre(),
					cuenta.getMoneda().getNombre(),
					cuenta.getSaldo(),
					cuenta.getEstado()
			};
			modelo.addRow(fila);
		}
	}

}

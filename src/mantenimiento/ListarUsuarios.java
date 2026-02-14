package mantenimiento;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import modelos.Usuario;
import servicio.UsuarioService;

public class ListarUsuarios extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
		private JTable tablaUsuarios;
		private DefaultTableModel modelo;
		private JScrollPane scrollPane;
	
	/**
	 * Create the panel.
	 */
	public ListarUsuarios() {
		setLayout(null);
		setBackground(new Color(255, 255, 255));
		setPreferredSize(new java.awt.Dimension(612, 455));
		setLayout(null);
		
		String[] columnas = {"DNI", "Nombres y apellidos"};
		modelo = new DefaultTableModel(null, columnas) {
			@Override
			public boolean isCellEditable(int row, int column) {
            return false;
			}
        };
		
        tablaUsuarios = new JTable(modelo);
        scrollPane = new JScrollPane(tablaUsuarios);
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
		
		UsuarioService service = new UsuarioService();
		ArrayList<Usuario> lista = service.listarUsuarios();
		
		for(int i = 0; i < lista.size(); i++) {
			Usuario user = lista.get(i);
			Object[] fila = {
					user.getDNI(), 
					user.getNombre()
			};
			
			modelo.addRow(fila);
			
		}
	}
}

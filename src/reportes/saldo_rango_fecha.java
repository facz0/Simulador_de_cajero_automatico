package reportes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter; 
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import modelos.Cuenta;
import modelos.Transaccion;
import servicio.TransaccionService;
import operaciones.Metodo_reporte_admin;

public class saldo_rango_fecha extends JPanel implements ActionListener {

    private static final long serialVersionUID = 1L;

    private JFormattedTextField txtInicio, txtFin;
	private JTable tablaTransacciones;
	private DefaultTableModel modeloTabla;
	private JButton btnGenerar, btnLimpiar;

	public saldo_rango_fecha() {
		setLayout(null);
		setBackground(new Color(2, 64, 89));

		// Carga de iconos (mantén tus rutas originales)
		ImageIcon calendarioIcon = new ImageIcon(getClass().getResource("/iconos/calendarioReporte.png"));
		ImageIcon generarReporte = new ImageIcon(getClass().getResource("/iconos/generarReporte.png"));
		ImageIcon limpiarReporte = new ImageIcon(getClass().getResource("/iconos/limpiarReporte.png"));

		JLabel lblTitulo = new JLabel("Transacciones por rango de fecha");
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblTitulo.setBounds(30, 20, 350, 30);
		add(lblTitulo);

		JSeparator sep = new JSeparator();
		sep.setBounds(30, 55, 860, 2);
		add(sep);

		// CONFIGURACIÓN DE MÁSCARA
		MaskFormatter mascara = null;
		try {
			// '#' significa que solo acepta números
			mascara = new MaskFormatter("##/##/####");
			mascara.setPlaceholderCharacter('_'); // Muestra guiones donde falta escribir
		} catch (ParseException e) {
			e.printStackTrace();
		}

		// Fecha Inicio
		JLabel lblInicio = new JLabel("Fecha inicio:");
		lblInicio.setForeground(Color.WHITE);
		lblInicio.setIcon(calendarioIcon);
		lblInicio.setBounds(30, 90, 150, 25);
		add(lblInicio);

		txtInicio = new JFormattedTextField(mascara);
		txtInicio.setBounds(200, 90, 250, 28);
		txtInicio.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		add(txtInicio);

		// Fecha Fin
		JLabel lblFin = new JLabel("Fecha fin:");
		lblFin.setForeground(Color.WHITE);
		lblFin.setIcon(calendarioIcon);
		lblFin.setBounds(30, 130, 150, 25);
		add(lblFin);

		txtFin = new JFormattedTextField(mascara);
		txtFin.setBounds(200, 130, 250, 28);
		txtFin.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		add(txtFin);

		// BOTÓN GENERAR
		btnGenerar = new JButton("Generar");
		btnGenerar.setForeground(Color.WHITE);
		btnGenerar.setBackground(new Color(128, 191, 33));
		btnGenerar.setContentAreaFilled(false);
		btnGenerar.setOpaque(true);
		btnGenerar.setBounds(570, 87, 120, 30);
		btnGenerar.setIcon(generarReporte);
		btnGenerar.addActionListener(this);
		add(btnGenerar);

		// BOTÓN LIMPIAR
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setForeground(Color.WHITE);
		btnLimpiar.setBackground(new Color(128, 191, 33));
		btnLimpiar.setContentAreaFilled(false);
		btnLimpiar.setOpaque(true);
		btnLimpiar.setBounds(730, 87, 120, 30);
		btnLimpiar.setIcon(limpiarReporte);
		btnLimpiar.addActionListener(this);
		add(btnLimpiar);

		// MODELO DE TABLA
		modeloTabla = new DefaultTableModel(
				new String[] { "Operación", "Cliente", "DNI", "Cuenta", "Tipo", "Monto", "Moneda", "Fecha", "Hora" },
				0);

		tablaTransacciones = new JTable(modeloTabla);
		tablaTransacciones.setRowHeight(24);
		tablaTransacciones.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		tablaTransacciones.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
		tablaTransacciones.setEnabled(false);

		JScrollPane scroll = new JScrollPane(tablaTransacciones);
		scroll.setBounds(30, 191, 860, 251);
		scroll.setBorder(new LineBorder(Color.BLACK, 3));
		add(scroll);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnGenerar) {
			try {
				TransaccionService service = new TransaccionService();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

				// El método .getText() ahora devolverá algo como "20/02/2026"
				LocalDate fechaInicio = LocalDate.parse(txtInicio.getText().trim(), formatter);
				LocalDate fechaFin = LocalDate.parse(txtFin.getText().trim(), formatter);

				LocalDateTime inicio = fechaInicio.atStartOfDay();
				LocalDateTime fin = fechaFin.atTime(23, 59, 59);

				// Validar que la fecha inicio no sea mayor que la fecha fin
				if (inicio.isAfter(fin)) {
					JOptionPane.showMessageDialog(this, "La fecha inicio no puede ser mayor que la fecha fin", "Error",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

				// Obtener lista de transacciones en el rango
				ArrayList<Transaccion> lista = service.listarPorRangoFechas(inicio, fin);

				// Ordenar por fecha
				lista.sort((t1, t2) -> t1.getFecha().compareTo(t2.getFecha()));

				// Limpiar la tabla antes de mostrar resultados
				modeloTabla.setRowCount(0);

				// Verificar si no hay resultados
				if (lista.isEmpty()) {
					JOptionPane.showMessageDialog(this, "No se encontraron transacciones", "Información",
							JOptionPane.INFORMATION_MESSAGE);
					return;
				}

				// Recorrer la lista y llenar la tabla
				for (Transaccion t : lista) {
					Cuenta cuenta = Metodo_reporte_admin.obtenerCuentaDeTransaccion(t);
					String nombreCli = (cuenta != null) ? cuenta.getUsuario().getNombre() : "Desconocido";
					String dniCli = (cuenta != null) ? cuenta.getUsuario().getDNI() : "N/A";
					String nombreMoneda = (cuenta != null) ? cuenta.getMoneda().getNombre() : "N/A";

					modeloTabla.addRow(new Object[] { 
							t.getCodigoOperacion(),
							nombreCli, dniCli, t.getNumeroCuenta(),
							t.getTipo(),
							String.format("%.2f", t.getMonto()),
							nombreMoneda, t.getSoloFechaFormateada(),
							t.getHoraFormateada() });
				}

			} catch (Exception ex) {

				// Error si la fecha no tiene el formato correcto
				JOptionPane.showMessageDialog(this, "Error: Verifique que la fecha sea válida.", "Error de Formato",
						JOptionPane.ERROR_MESSAGE);
			}
		}

		// Limpiar campos y tabla
		if (e.getSource() == btnLimpiar) {
			limpiar();
		}
	}
	public void limpiar() {
	    txtInicio.setValue(null);
	    txtFin.setValue(null);
	    modeloTabla.setRowCount(0);
	}
}

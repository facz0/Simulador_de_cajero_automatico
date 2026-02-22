package reportes;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;

import modelos.Cuenta;
import modelos.Usuario;
import operaciones.Metodo_reporte_admin;

public class Saldo_cliente extends JPanel implements ActionListener {

    private static final long serialVersionUID = 1L;

    private JTextField txtCliente;
    private JTable tablaCuentas;
    private DefaultTableModel modeloTabla;
    private JButton btnGenerar, btnLimpiar;

    public Saldo_cliente() {


        // FONDO
        setBackground(new Color(2, 64, 89));
        setLayout(null);

        //ICONOS
        ImageIcon usuarioReporte = new ImageIcon(getClass().getResource("/iconos/usuarioReporte.png"));
        ImageIcon generarReporte = new ImageIcon(getClass().getResource("/iconos/generarReporte.png"));
        ImageIcon limpiarReporte = new ImageIcon(getClass().getResource("/iconos/limpiarReporte.png"));

        //  TÍTULO
        JLabel lblTitulo = new JLabel("Saldo de cliente");
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setBounds(30, 20, 300, 30);
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 16));
        add(lblTitulo);

        //  SEPARADOR
        JSeparator sep = new JSeparator();
        sep.setBounds(30, 55, 860, 2);
        add(sep);

        //  LABEL CLIENTE
        JLabel lblCliente = new JLabel("Nombre del cliente:");
        lblCliente.setForeground(Color.WHITE);
        lblCliente.setBounds(30, 90, 180, 25);
        lblCliente.setIcon(usuarioReporte);
        add(lblCliente);

        //  TXT CLIENTE
        txtCliente = new JTextField();
        txtCliente.setBounds(200, 90, 250, 28);
        add(txtCliente);

        //  BOTÓN GENERAR
        btnGenerar = new JButton("Generar");
        btnGenerar.setForeground(Color.WHITE);
        btnGenerar.setBackground(new Color(128, 191, 33));
        btnGenerar.setContentAreaFilled(false);
        btnGenerar.setOpaque(true);
        btnGenerar.setBounds(570, 87, 120, 30);
        btnGenerar.setIcon(generarReporte);
        btnGenerar.addActionListener(this);
        add(btnGenerar);

        //  BOTÓN LIMPIAR
        btnLimpiar = new JButton("Limpiar");
        btnLimpiar.setForeground(Color.WHITE);
        btnLimpiar.setBackground(new Color(128, 191, 33));
        btnLimpiar.setContentAreaFilled(false);
        btnLimpiar.setOpaque(true);
        btnLimpiar.setBounds(730, 87, 120, 30);
        btnLimpiar.setIcon(limpiarReporte);
        btnLimpiar.addActionListener(this);
        add(btnLimpiar);

        //  MODELO DE TABLA
        modeloTabla = new DefaultTableModel(
            new String[]{"DNI", "Nombre", "Nro Cuenta", "Moneda", "Saldo", "Estado"},
            0
        );

        //  TABLA
        tablaCuentas = new JTable(modeloTabla);
        tablaCuentas.setRowHeight(24);
        tablaCuentas.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        tablaCuentas.getTableHeader().setFont(
            new Font("Segoe UI", Font.BOLD, 12)
        );
        tablaCuentas.setEnabled(false);
        tablaCuentas.setBackground(new Color(250, 250, 250));

        //  SCROLL
        JScrollPane scroll = new JScrollPane(tablaCuentas);
        scroll.setBounds(30, 191, 860, 251);
        scroll.setBorder(new LineBorder(Color.BLACK, 3));
        add(scroll);
    }

    @Override
    public void actionPerformed(ActionEvent e) {


    	if (e.getSource() == btnGenerar) {


            String nombre = txtCliente.getText().trim();

            Usuario usuario = Metodo_reporte_admin.clientePorNombre(nombre);

            if (usuario == null) {
                JOptionPane.showMessageDialog(
                    this,
                    "No existe un cliente con ese nombre",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
                );
                return;
            }

            //  OBTENER CUENTAS
            Cuenta[] cuentas = Metodo_reporte_admin.cuentasPorNombre(nombre);

            //  ACUMULAR FILAS (NO SE LIMPIA LA TABLA)
            for (Cuenta c : cuentas) {
                modeloTabla.addRow(new Object[]{
                    usuario.getDNI(),
                    usuario.getNombre(),
                    c.getNumeroCuenta(),
                    c.getMoneda().getNombre(),
                    c.getSaldo(),
                    c.getEstado()
                });
            }

            txtCliente.setText("");
        }

        if (e.getSource() == btnLimpiar) {
        	limpiar();
        }
    }
    		public void limpiar() {
    		txtCliente.setText("");
    		modeloTabla.setRowCount(0);
    }
}
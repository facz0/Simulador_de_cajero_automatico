package reportes;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import modelos.Cuenta;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import operaciones.Metodo_reporte_admin;

public class Saldo_rango_montos extends JPanel implements ActionListener {

    private static final long serialVersionUID = 1L;
  
    private JTextField txtMin, txtMax;
    private JTable tablaCuentas;
    private DefaultTableModel modeloTabla;
    private JButton btnGenerar, btnLimpiar;

    public Saldo_rango_montos() {
    		//setBackground(new Color(4, 40, 56));  //color reporte principal
        	setBackground(new Color(2, 64, 89));  //color del fondo azul
            setLayout(null);
            
            ImageIcon billeteReporte = new ImageIcon(getClass().getResource("/iconos/billeteReporte.png"));
            ImageIcon billete2Reporte = new ImageIcon(getClass().getResource("/iconos/billete2Reporte.png"));
            ImageIcon generarReporte = new ImageIcon(getClass().getResource("/iconos/generarReporte.png"));
            ImageIcon limpiarReporte = new ImageIcon(getClass().getResource("/iconos/limpiarReporte.png"));

            JLabel lblTitulo = new JLabel("Clientes con saldo entre rangos");
            lblTitulo.setForeground(new Color(255, 255, 255));
            lblTitulo.setBounds(30, 20, 350, 30);
            lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 16));
            add(lblTitulo);

            JSeparator sep = new JSeparator();
            sep.setBounds(30, 55, 860, 2);
            add(sep);

            JLabel lblMin = new JLabel("Monto mínimo:");
            lblMin.setIcon(billeteReporte);//icono
            lblMin.setForeground(new Color(255, 255, 255));
            lblMin.setBounds(30, 90, 150, 25);
            add(lblMin);

            txtMin = new JTextField();
            txtMin.setBounds(200, 90, 250, 28);
            add(txtMin);

            JLabel lblMax = new JLabel("Monto máximo:");
            lblMax.setIcon(billete2Reporte);//icono
            lblMax.setForeground(new Color(255, 255, 255));
            lblMax.setBounds(30, 130, 150, 25);
            add(lblMax);

            txtMax = new JTextField();
            txtMax.setBounds(200, 130, 250, 28);
            add(txtMax);

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


            // MODELO DE TABLA

         // MODELO DE TABLA
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

            // SCROLL
            JScrollPane scroll = new JScrollPane(tablaCuentas);
            scroll.setBounds(30, 191, 860, 251);
            scroll.setBorder(new LineBorder(Color.BLACK, 3));
            add(scroll);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    	// Validar y obtener el rango de montos ingresado por el usuario
        if (e.getSource() == btnGenerar) {

            String minTxt = txtMin.getText().trim();
            String maxTxt = txtMax.getText().trim();
         // Validaciones de los montos ingresados
            if (minTxt.isEmpty() || maxTxt.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "Ingrese el monto mínimo y máximo",
                        "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            double min, max;

            try {
                min = Double.parseDouble(minTxt);
                max = Double.parseDouble(maxTxt);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this,
                        "Ingrese valores numéricos válidos",
                        "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            //  LIMPIAR TABLA
            modeloTabla.setRowCount(0);

            //  OBTENER CUENTAS
            Cuenta[] cuentas = Metodo_reporte_admin.cuentasPorRangoSaldo(min, max);

            if (cuentas.length == 0) {
                JOptionPane.showMessageDialog(this,
                        "No existen cuentas en este rango",
                        "Información", JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            //  LLENAR TABLA
            for (Cuenta c : cuentas) {
                modeloTabla.addRow(new Object[]{
                    c.getUsuario().getDNI(),
                    c.getUsuario().getNombre(),
                    c.getNumeroCuenta(),
                    c.getMoneda(),
                    c.getSaldo(),
                    c.getEstado()
                });
            }
        }

        if (e.getSource() == btnLimpiar) {
        	limpiar();
        }
    }
    public void limpiar() {
        txtMin.setText("");
        txtMax.setText("");
        modeloTabla.setRowCount(0);
    }
 }
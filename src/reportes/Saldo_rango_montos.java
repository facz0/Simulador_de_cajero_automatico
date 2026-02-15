package reportes;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//llamando a mis metodos o si no f :v
import CLASES_REPORTE_ADMIN.Metodo_reporte_admin;
import modelos.Cuenta;

public class Saldo_rango_montos extends JPanel implements ActionListener {

    private static final long serialVersionUID = 1L;
    private Ventana_reportee ventana_reportee;
    private JTextField txtMin, txtMax;
    private JTextArea txtResultado;
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

            btnGenerar = new JButton("Generar");
            btnGenerar.setForeground(new Color(255, 255, 255));
            btnGenerar.setBackground(new Color(128, 191, 33)); // color deseado
            btnGenerar.setContentAreaFilled(false); //fondo de color
            btnGenerar.setOpaque(true);//fondo de color
            btnGenerar.setBounds(570, 87, 120, 30);
            btnGenerar.addActionListener(this);
            btnGenerar.setIcon(generarReporte);//icono
            add(btnGenerar);

            btnLimpiar = new JButton("Limpiar");
            btnLimpiar.setForeground(new Color(255, 255, 255));
            btnLimpiar.setBackground(new Color(128, 191, 33)); // color deseado
            btnLimpiar.setContentAreaFilled(false); //fondo de color
            btnLimpiar.setOpaque(true);//fondo de color
            btnLimpiar.setBounds(730, 87, 120, 30);
            btnLimpiar.addActionListener(this);
            btnLimpiar.setIcon(limpiarReporte);//icono
            add(btnLimpiar);

            JScrollPane scroll = new JScrollPane();
            scroll.setBounds(30, 191, 860, 251);
            add(scroll);
            
            txtResultado = new JTextArea();
            scroll.setViewportView(txtResultado);
            txtResultado.setEditable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    	 if (e.getSource() == btnGenerar) {

             String minTxt = txtMin.getText().trim();
             String maxTxt = txtMax.getText().trim();

             if (minTxt.isEmpty() || maxTxt.isEmpty()) {
                 JOptionPane.showMessageDialog(
                     this,
                     "Ingrese el monto mínimo y máximo",
                     "Error",
                     JOptionPane.ERROR_MESSAGE
                 );
                 return;
             }

             double min, max;

             try {
                 min = Double.parseDouble(minTxt);
                 max = Double.parseDouble(maxTxt);
             } catch (NumberFormatException ex) {
                 JOptionPane.showMessageDialog(
                     this,
                     "Ingrese valores numéricos válidos",
                     "Error",
                     JOptionPane.ERROR_MESSAGE
                 );
                 return;
             }

             // 🔹 LLAMADA DIRECTA AL MÉTODO
             Cuenta[] resultado = Metodo_reporte_admin.cuentasPorRangoSaldo(min, max);

             txtResultado.setText(
                 "REPORTE DE CLIENTES POR RANGO DE SALDO\n\n" +
                 "Desde: " + min + "\n" +
                 "Hasta: " + max + "\n\n"
             );

             if (resultado.length == 0) {
                 txtResultado.append("No existen cuentas en este rango.");
                 return;
             }

             for (Cuenta c : resultado) {
                 txtResultado.append(
                     "Cliente: " + c.getUsuario().getNombre() + "\n" +
                     "Nro Cuenta: " + c.getNumeroCuenta() + "\n" +
                     "Moneda: " + c.getMoneda() + "\n" +
                     "Saldo: " + c.getSaldo() + "\n" +
                     "Estado: " + c.getEstado() + "\n" +
                     "-----------------------------\n"
                 );
             }
         }

         if (e.getSource() == btnLimpiar) {
             txtMin.setText("");
             txtMax.setText("");
             txtResultado.setText("");
         }
     }
 }
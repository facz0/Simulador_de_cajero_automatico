package reportes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class saldo_rango_fecha extends JPanel implements ActionListener {

    private static final long serialVersionUID = 1L;

    private JTextField txtInicio, txtFin;
    private JTextArea txtResultado;
    private JButton btnGenerar, btnLimpiar;

    public saldo_rango_fecha() {

        setLayout(null);
        setBackground(new Color(2, 64, 89));  //color del fondo azul

        JLabel lblTitulo = new JLabel("Transacciones por rango de fecha");
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblTitulo.setBounds(30, 20, 350, 30);
        add(lblTitulo);

        JSeparator sep = new JSeparator();
        sep.setBounds(30, 55, 860, 2);
        add(sep);

        JLabel lblInicio = new JLabel("Fecha inicio:");
        lblInicio.setBounds(30, 90, 150, 25);
        add(lblInicio);

        txtInicio = new JTextField("YYYY-MM-DD");
        txtInicio.setBounds(200, 90, 250, 28);
        add(txtInicio);

        JLabel lblFin = new JLabel("Fecha fin:");
        lblFin.setForeground(new Color(255, 255, 255));
        lblFin.setBounds(30, 130, 150, 25);
        add(lblFin);

        txtFin = new JTextField("YYYY-MM-DD");
        txtFin.setBounds(200, 130, 250, 28);
        add(txtFin);

        btnGenerar = new JButton("Generar");
        btnGenerar.setForeground(new Color(255, 255, 255));
        
        btnGenerar.setBackground(new Color(128, 191, 33)); // color deseado
        btnGenerar.setContentAreaFilled(false); //fondo de color
        btnGenerar.setOpaque(true);//fondo de color
        btnGenerar.setBounds(570, 87, 120, 30);
        btnGenerar.addActionListener(this);
        add(btnGenerar);

        btnLimpiar = new JButton("Limpiar");
        btnLimpiar.setForeground(new Color(255, 255, 255));
        btnLimpiar.setBackground(new Color(128, 191, 33)); // color deseado
        btnLimpiar.setContentAreaFilled(false); //fondo de color
        btnLimpiar.setOpaque(true);//fondo de color
        btnLimpiar.setBounds(730, 87, 120, 30);
        btnLimpiar.addActionListener(this);
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
            txtResultado.setText(
                "Reporte por rango de fechas\nDesde: " + txtInicio.getText()
                + "\nHasta: " + txtFin.getText()
            );
        }

        if (e.getSource() == btnLimpiar) {
            txtInicio.setText("YYYY-MM-DD");
            txtFin.setText("YYYY-MM-DD");
            txtResultado.setText("");
        }
    }
}
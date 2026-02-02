package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Saldo_rango_montos extends JPanel implements ActionListener {

    private static final long serialVersionUID = 1L;
    private Ventana_reporte ventana_reporte;
    private JTextField txtMin, txtMax;
    private JTextArea txtResultado;
    private JButton btnGenerar, btnLimpiar;

    public Saldo_rango_montos() {
        setBackground(Color.WHITE);
        setLayout(null);

        JLabel lblTitulo = new JLabel("Clientes con saldo entre rangos");
        lblTitulo.setBounds(30, 20, 350, 30);
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 16));
        add(lblTitulo);

        JSeparator sep = new JSeparator();
        sep.setBounds(30, 55, 860, 2);
        add(sep);

        JLabel lblMin = new JLabel("Monto mínimo:");
        lblMin.setBounds(30, 90, 150, 25);
        add(lblMin);

        txtMin = new JTextField();
        txtMin.setBounds(200, 90, 250, 28);
        add(txtMin);

        JLabel lblMax = new JLabel("Monto máximo:");
        lblMax.setBounds(30, 130, 150, 25);
        add(lblMax);

        txtMax = new JTextField();
        txtMax.setBounds(200, 130, 250, 28);
        add(txtMax);

        btnGenerar = new JButton("Generar");
        btnGenerar.setBounds(570, 87, 120, 30);
        btnGenerar.addActionListener(this);
        add(btnGenerar);

        btnLimpiar = new JButton("Limpiar");
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
                "Reporte por rango de montos\nDesde: " + txtMin.getText()
                + "\nHasta: " + txtMax.getText()
            );
        }

        if (e.getSource() == btnLimpiar) {
            txtMin.setText("");
            txtMax.setText("");
            txtResultado.setText("");
        }
    }
}
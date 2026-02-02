package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Saldo_cliente extends JPanel implements ActionListener {

    private static final long serialVersionUID = 1L;

    private JTextField txtCliente;
    private JTextArea txtResultado;
    private JButton btnGenerar, btnLimpiar;

    public Saldo_cliente(VentanaPrincipal principal) {
        setBackground(new Color(255, 255, 255));
        setLayout(null);

        JLabel lblTitulo = new JLabel("Saldo de cliente");
        lblTitulo.setBounds(30, 20, 300, 30);
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 16));
        add(lblTitulo);

        JSeparator sep = new JSeparator();
        sep.setBounds(30, 55, 860, 2);
        add(sep);

        JLabel lblCliente = new JLabel("Nombre del cliente:");
        lblCliente.setBounds(30, 90, 103, 25);
        lblCliente.setBackground(new Color(255, 255, 255));
        add(lblCliente);

        txtCliente = new JTextField();
        txtCliente.setBounds(200, 90, 250, 28);
        add(txtCliente);

        btnGenerar = new JButton("Generar");
        btnGenerar.setBounds(570, 87, 120, 30);
        btnGenerar.setBackground(new Color(0, 128, 0));
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
                "Reporte de saldo\nCliente: " + txtCliente.getText()
            );
        }

        if (e.getSource() == btnLimpiar) {
            txtCliente.setText("");
            txtResultado.setText("");
        }
    }
}
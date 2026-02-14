package reportes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import CLASES_REPORTE_ADMIN.Metodo_reporte_admin;
import modelos.Usuario;



public class Saldo_cliente extends JPanel implements ActionListener {

    private static final long serialVersionUID = 1L;

    private JTextField txtCliente;
    private JTextArea txtResultado;
    private JButton btnGenerar, btnLimpiar;

    public Saldo_cliente() {
    	
    	setBackground(new Color(2, 64, 89));  //color del fondo azul
        setLayout(null);

        JLabel lblTitulo = new JLabel("Saldo de cliente");
        lblTitulo.setForeground(new Color(255, 255, 255));
        lblTitulo.setBounds(30, 20, 300, 30);
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 16));
        add(lblTitulo);

        JSeparator sep = new JSeparator();
        sep.setBounds(30, 55, 860, 2);
        add(sep);

        JLabel lblCliente = new JLabel("Nombre del cliente:");
        lblCliente.setForeground(new Color(255, 255, 255));
        lblCliente.setBounds(30, 90, 136, 25);
        lblCliente.setBackground(new Color(255, 255, 255));
        add(lblCliente);

        txtCliente = new JTextField();
        txtCliente.setBounds(200, 90, 250, 28);
        add(txtCliente);

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

            String nombre = txtCliente.getText().trim();

            // Campo vacío
            if (nombre.isEmpty()) {
                JOptionPane.showMessageDialog(
                    this,
                    "Ingrese el nombre del cliente",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
                );
                return;
            }

            // Llamada al método
            Usuario resultado =
                Metodo_reporte_admin.clientePorNombre(nombre);

            // No existe
            if (resultado == null) {
                JOptionPane.showMessageDialog(
                    this,
                    "No existe un cliente con ese nombre",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
                );
                return;
            }

            // Mostrar datos si existe
            txtResultado.setText(
                "REPORTE DE USUARIO\n\n" +
                "DNI: " + resultado.getDNI() + "\n" +
                "Nombre: " + resultado.getNombre()
            );
        }
        

        if (e.getSource() == btnLimpiar) {
            txtCliente.setText("");
            txtResultado.setText("");
        }
    }
}
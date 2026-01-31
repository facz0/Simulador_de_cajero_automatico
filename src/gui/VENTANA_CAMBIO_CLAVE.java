package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.SwingConstants; 
import javax.swing.JSeparator;

public class VENTANA_CAMBIO_CLAVE extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JPasswordField txtClaveActual;
    private JPasswordField txtClaveNueva;
    private JPasswordField txtConfirmarClave;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    VENTANA_CAMBIO_CLAVE frame = new VENTANA_CAMBIO_CLAVE();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public VENTANA_CAMBIO_CLAVE() {
        setTitle("CAMBIO DE CLAVE SEGURA");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1000, 600); 
        
        contentPane = new JPanel();
        contentPane.setBackground(new Color(240, 240, 240));
        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        
        JLabel lblTitulo = new JLabel("CAMBIO DE CLAVE");
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 28));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setBounds(200, 30, 600, 40);
        contentPane.add(lblTitulo);

        
        JSeparator separator = new JSeparator();
        separator.setBounds(200, 80, 600, 2);
        contentPane.add(separator);

        
        JLabel lblClaveActual = new JLabel("Clave Actual:");
        lblClaveActual.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblClaveActual.setBounds(250, 130, 200, 30);
        contentPane.add(lblClaveActual);

        txtClaveActual = new JPasswordField();
        txtClaveActual.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txtClaveActual.setBounds(480, 130, 250, 35);
        contentPane.add(txtClaveActual);

        JLabel lblClaveNueva = new JLabel("Nueva Clave:");
        lblClaveNueva.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblClaveNueva.setBounds(250, 200, 200, 30);
        contentPane.add(lblClaveNueva);

        txtClaveNueva = new JPasswordField();
        txtClaveNueva.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txtClaveNueva.setBounds(480, 200, 250, 35);
        contentPane.add(txtClaveNueva);

        JLabel lblConfirmar = new JLabel("Confirmar Clave:");
        lblConfirmar.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblConfirmar.setBounds(250, 270, 200, 30);
        contentPane.add(lblConfirmar);

        txtConfirmarClave = new JPasswordField();
        txtConfirmarClave.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txtConfirmarClave.setBounds(480, 270, 250, 35);
        contentPane.add(txtConfirmarClave);

       
        JButton btnCambiar = new JButton("CAMBIAR CLAVE");
        btnCambiar.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnCambiar.setBackground(new Color(50, 150, 50)); 
        btnCambiar.setForeground(Color.BLACK);
        btnCambiar.setBounds(290, 420, 210, 50);
        contentPane.add(btnCambiar);
      btnCambiar.setFocusPainted(false);
        

        JButton btnCancelar = new JButton("CANCELAR");
        btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnCancelar.setBackground(new Color(200, 50, 50)); 
        btnCancelar.setForeground(Color.BLACK);
        btnCancelar.setBounds(550, 420, 200, 50);
        contentPane.add(btnCancelar);
        btnCancelar.setFocusPainted(false);
        
        
        JLabel lblNota = new JLabel("Nota:  use solo 4 dígitos numéricos.");
        lblNota.setHorizontalAlignment(SwingConstants.CENTER);
        lblNota.setForeground(Color.GRAY);
        lblNota.setFont(new Font("Tahoma", Font.ITALIC, 14));
        lblNota.setBounds(200, 330, 600, 20);
        contentPane.add(lblNota);
    }
}

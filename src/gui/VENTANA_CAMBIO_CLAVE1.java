package gui;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.UIManager; // Importación necesaria para el estilo visual
import javax.swing.border.EmptyBorder;

public class VENTANA_CAMBIO_CLAVE1 extends JPanel {

    private static final long serialVersionUID = 1L;
    private JPasswordField txtClaveActual;
    private JPasswordField txtClaveNueva;
    private JPasswordField txtConfirmarClave;

    public VENTANA_CAMBIO_CLAVE1() {
        
        // --- SOLUCIÓN VISUAL: Forzar el estilo de Windows al ejecutar ---
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    	
        // Panel Principal 
        setBackground(new Color(240, 240, 240));
        setBorder(new EmptyBorder(10, 10, 10, 10));
        setLayout(null); 
       
        setPreferredSize(new java.awt.Dimension(1000, 620));

        // Título
        JLabel lblTitulo = new JLabel("CAMBIO DE CLAVE");
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 28));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setBounds(200, 30, 600, 40);
        add(lblTitulo);

        JSeparator separator = new JSeparator();
        separator.setBounds(200, 80, 600, 2);
        add(separator);

        // Etiquetas y Campos de texto
        JLabel lblClaveActual = new JLabel("Clave Actual:");
        lblClaveActual.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblClaveActual.setBounds(250, 130, 200, 30);
        add(lblClaveActual);

        txtClaveActual = new JPasswordField();
        txtClaveActual.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txtClaveActual.setBounds(480, 130, 250, 35);
        add(txtClaveActual);

        JLabel lblClaveNueva = new JLabel("Nueva Clave:");
        lblClaveNueva.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblClaveNueva.setBounds(250, 200, 200, 30);
        add(lblClaveNueva);

        txtClaveNueva = new JPasswordField();
        txtClaveNueva.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txtClaveNueva.setBounds(480, 200, 250, 35);
        add(txtClaveNueva);

        JLabel lblConfirmar = new JLabel("Confirmar Clave:");
        lblConfirmar.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblConfirmar.setBounds(250, 270, 200, 30);
        add(lblConfirmar);

        txtConfirmarClave = new JPasswordField();
        txtConfirmarClave.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txtConfirmarClave.setBounds(480, 270, 250, 35);
        add(txtConfirmarClave);

        Color verdeBoton = new Color(128, 191, 33);

        // BOTÓN VOLVER
        JButton btnVolver = new JButton("VOLVER");
        btnVolver.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnVolver.setBounds(20, 30, 100, 30); 
        btnVolver.setBackground(verdeBoton);
        btnVolver.setForeground(Color.WHITE);
        btnVolver.setFocusPainted(false); // Limpia el foco visual
        btnVolver.setOpaque(true);
        btnVolver.setBorderPainted(false);
        btnVolver.setContentAreaFilled(true);
        add(btnVolver);

        // BOTÓN CAMBIAR CLAVE
        JButton btnCambiar = new JButton("CAMBIAR CLAVE");
        btnCambiar.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnCambiar.setBackground(verdeBoton); 
        btnCambiar.setForeground(Color.WHITE); 
        btnCambiar.setBounds(290, 420, 210, 50);
        btnCambiar.setFocusPainted(false);
        btnCambiar.setBorderPainted(false);    
        btnCambiar.setOpaque(true);            
        btnCambiar.setContentAreaFilled(true);
        add(btnCambiar);
        
        // BOTÓN CANCELAR
        JButton btnCancelar = new JButton("CANCELAR");
        btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnCancelar.setBackground(verdeBoton); 
        btnCancelar.setForeground(Color.WHITE);
        btnCancelar.setBounds(550, 420, 200, 50);
        btnCancelar.setFocusPainted(false);
        btnCancelar.setBorderPainted(false);    
        btnCancelar.setOpaque(true);            
        btnCancelar.setContentAreaFilled(true);
        add(btnCancelar);
        
        JLabel lblNota = new JLabel("Nota: use solo 4 dígitos numéricos.");
        lblNota.setHorizontalAlignment(SwingConstants.CENTER);
        lblNota.setForeground(Color.GRAY);
        lblNota.setFont(new Font("Tahoma", Font.ITALIC, 14));
        lblNota.setBounds(200, 330, 600, 20);
        add(lblNota);
    }
}
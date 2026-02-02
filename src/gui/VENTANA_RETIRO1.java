package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager; // Necesario para el estilo visual
import javax.swing.border.EmptyBorder;

public class VENTANA_RETIRO1 extends JPanel {

    private static final long serialVersionUID = 1L;
    private JTextField txtMontoRetirar;
    private JComboBox<String> comboMoneda;
    private JLabel lblSimboloMoneda;

    public VENTANA_RETIRO1() {
        
        // --- SOLUCIÓN VISUAL: Ejecutar con estilo nativo de Windows ---
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    	
        // Configuraciones del Panel Principal
        setBackground(new Color(240, 240, 240));
        setBorder(new EmptyBorder(10, 10, 10, 10));
        setLayout(null);
        setPreferredSize(new Dimension(1000, 620));

        // --- DEFINICIÓN DE COLORES ---
        Color azulMontos = new Color(2, 64, 89);
        Color verdeBoton = new Color(128, 191, 33);
        Color azulDesplegable = new Color(3, 120, 166);

        JLabel lblTitulo = new JLabel("RETIRO DE DINERO");
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 28));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setBounds(200, 30, 600, 40);
        add(lblTitulo);

        JSeparator separator = new JSeparator();
        separator.setBounds(200, 80, 600, 2);
        add(separator);

        JLabel lblSeleccionMoneda = new JLabel("Seleccionar Moneda:");
        lblSeleccionMoneda.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblSeleccionMoneda.setBounds(200, 100, 180, 30);
        add(lblSeleccionMoneda);

        comboMoneda = new JComboBox<>();
        comboMoneda.setModel(new DefaultComboBoxModel<>(new String[] {"Soles (PEN)", "Dólares (USD)"}));
        comboMoneda.setFont(new Font("Tahoma", Font.BOLD, 16));
        comboMoneda.setBounds(400, 100, 200, 30);
        comboMoneda.setBackground(Color.WHITE); // Cambiado a blanco para mejor lectura
        add(comboMoneda);

        JLabel lblSaldoDisponible = new JLabel("Saldo Disponible:");
        lblSaldoDisponible.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblSaldoDisponible.setBounds(200, 150, 200, 30);
        add(lblSaldoDisponible);

        lblSimboloMoneda = new JLabel("S/.");
        lblSimboloMoneda.setFont(new Font("Tahoma", Font.BOLD, 22));
        lblSimboloMoneda.setForeground(new Color(0, 128, 0));
        lblSimboloMoneda.setBounds(400, 150, 50, 30);
        add(lblSimboloMoneda);

        JLabel lblSaldoMonto = new JLabel("1,500.00");
        lblSaldoMonto.setFont(new Font("Tahoma", Font.BOLD, 22));
        lblSaldoMonto.setForeground(new Color(0, 128, 0));
        lblSaldoMonto.setBounds(450, 150, 200, 30);
        add(lblSaldoMonto);

        JLabel lblMontoRetirar = new JLabel("Monto a Retirar:");
        lblMontoRetirar.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblMontoRetirar.setBounds(200, 210, 180, 30);
        add(lblMontoRetirar);

        JLabel lblSimboloRetiro = new JLabel("S/.");
        lblSimboloRetiro.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblSimboloRetiro.setBounds(380, 210, 40, 30);
        add(lblSimboloRetiro);

        txtMontoRetirar = new JTextField();
        txtMontoRetirar.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txtMontoRetirar.setBounds(420, 210, 180, 35);
        add(txtMontoRetirar);

        // --- BOTONES DE MONTOS (Azules) ---
        // Se aplicó setBorderPainted(false) para evitar el borde gris en ejecución
        crearBotonMonto("S/. 20", 150, 280, azulMontos);
        crearBotonMonto("S/. 50", 400, 280, azulMontos);
        crearBotonMonto("S/. 100", 650, 280, azulMontos);
        crearBotonMonto("S/. 200", 150, 350, azulMontos);
        crearBotonMonto("S/. 500", 400, 350, azulMontos);
        crearBotonMonto("S/. 1000", 650, 350, azulMontos);

        // --- BOTONES DE ACCIÓN (Verdes) ---
        JButton btnVolver = new JButton("VOLVER");
        configurarBotonVerde(btnVolver, 20, 30, 100, 35, verdeBoton);
        add(btnVolver);

        JButton btnLimpiar = new JButton("LIMPIAR");
        configurarBotonVerde(btnLimpiar, 400, 420, 200, 50, verdeBoton);
        add(btnLimpiar);

        JButton btnRetirar = new JButton("RETIRAR");
        configurarBotonVerde(btnRetirar, 300, 500, 150, 50, verdeBoton);
        add(btnRetirar);

        JButton btnCancelar = new JButton("CANCELAR");
        configurarBotonVerde(btnCancelar, 550, 500, 150, 50, verdeBoton);
        add(btnCancelar);

        JLabel lblTipoCambio = new JLabel("Tipo de cambio: 1 USD = 3.85 PEN");
        lblTipoCambio.setFont(new Font("Tahoma", Font.ITALIC, 12));
        lblTipoCambio.setForeground(Color.GRAY);
        lblTipoCambio.setBounds(650, 105, 250, 20);
        add(lblTipoCambio);
    }

    // Métodos auxiliares para evitar repetir código y reducir errores en el Outline
    private void crearBotonMonto(String texto, int x, int y, Color color) {
        JButton btn = new JButton(texto);
        btn.setFont(new Font("Tahoma", Font.BOLD, 16));
        btn.setBounds(x, y, 200, 50);
        btn.setBackground(color);
        btn.setForeground(Color.WHITE);
        btn.setOpaque(true);
        btn.setBorderPainted(false);
        btn.setFocusPainted(false);
        btn.setContentAreaFilled(true);
        add(btn);
    }

    private void configurarBotonVerde(JButton btn, int x, int y, int w, int h, Color color) {
        btn.setFont(new Font("Tahoma", Font.BOLD, 16));
        btn.setBounds(x, y, w, h);
        btn.setBackground(color);
        btn.setForeground(Color.WHITE);
        btn.setOpaque(true);
        btn.setBorderPainted(false);
        btn.setFocusPainted(false);
        btn.setContentAreaFilled(true);
    }
}
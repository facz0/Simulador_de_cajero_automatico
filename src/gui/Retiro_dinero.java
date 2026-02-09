package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

public class Retiro_dinero extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	private VentanaPrincipal ventanaPrincipal;
	private JTextField txtMontoRetirar;
    private JComboBox<String> comboMoneda;
    private JLabel lblSimboloMoneda;
    private JButton btnVolver;

	/**
	 * Create the panel.
	 */
	public Retiro_dinero(VentanaPrincipal principal) {
		this.ventanaPrincipal = principal;
		setBackground(new Color(240, 240, 240));
        setBorder(new EmptyBorder(10, 10, 10, 10));
        setPreferredSize(new Dimension(1000, 620));

        // --- DEFINICIÓN DE COLORES ---
        Color azulMontos = new Color(2, 64, 89);
        Color verdeBoton = new Color(128, 191, 33);
        Color azulDesplegable = new Color(3, 120, 166);
        setLayout(null);

        JLabel lblTitulo = new JLabel("RETIRO DE DINERO");
        lblTitulo.setBounds(200, 30, 600, 40);
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 28));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        add(lblTitulo);

        JSeparator separator = new JSeparator();
        separator.setBounds(200, 80, 600, 2);
        add(separator);

        JLabel lblSeleccionMoneda = new JLabel("Seleccionar Moneda:");
        lblSeleccionMoneda.setBounds(200, 100, 180, 30);
        lblSeleccionMoneda.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblSeleccionMoneda);

        comboMoneda = new JComboBox<>();
        comboMoneda.setBounds(400, 100, 200, 30);
        comboMoneda.setModel(new DefaultComboBoxModel<>(new String[] {"Soles (PEN)", "Dólares (USD)"}));
        comboMoneda.setFont(new Font("Tahoma", Font.BOLD, 16));
        comboMoneda.setBackground(Color.WHITE); // Cambiado a blanco para mejor lectura
        add(comboMoneda);

        JLabel lblSaldoDisponible = new JLabel("Saldo Disponible:");
        lblSaldoDisponible.setBounds(200, 150, 200, 30);
        lblSaldoDisponible.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(lblSaldoDisponible);

        lblSimboloMoneda = new JLabel("S/.");
        lblSimboloMoneda.setBounds(400, 150, 50, 30);
        lblSimboloMoneda.setFont(new Font("Tahoma", Font.BOLD, 22));
        lblSimboloMoneda.setForeground(new Color(0, 128, 0));
        add(lblSimboloMoneda);

        JLabel lblSaldoMonto = new JLabel("1,500.00");
        lblSaldoMonto.setBounds(450, 150, 200, 30);
        lblSaldoMonto.setFont(new Font("Tahoma", Font.BOLD, 22));
        lblSaldoMonto.setForeground(new Color(0, 128, 0));
        add(lblSaldoMonto);

        JLabel lblMontoRetirar = new JLabel("Monto a Retirar:");
        lblMontoRetirar.setBounds(200, 210, 180, 30);
        lblMontoRetirar.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(lblMontoRetirar);

        JLabel lblSimboloRetiro = new JLabel("S/.");
        lblSimboloRetiro.setBounds(380, 210, 40, 30);
        lblSimboloRetiro.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(lblSimboloRetiro);

        txtMontoRetirar = new JTextField();
        txtMontoRetirar.setBounds(420, 210, 180, 35);
        txtMontoRetirar.setFont(new Font("Tahoma", Font.PLAIN, 20));
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
        btnVolver = new JButton("VOLVER");
        btnVolver.addActionListener(this);
        btnVolver.setBounds(20, 30, 100, 35);
        configurarBotonVerde(btnVolver, 20, 30, 100, 35, verdeBoton);
        add(btnVolver);

        JButton btnLimpiar = new JButton("LIMPIAR");
        btnLimpiar.setBounds(0, 0, 0, 0);
        configurarBotonVerde(btnLimpiar, 400, 420, 200, 50, verdeBoton);
        add(btnLimpiar);

        JButton btnRetirar = new JButton("RETIRAR");
        btnRetirar.setBounds(0, 0, 0, 0);
        configurarBotonVerde(btnRetirar, 300, 500, 150, 50, verdeBoton);
        add(btnRetirar);

        JButton btnCancelar = new JButton("CANCELAR");
        btnCancelar.setBounds(0, 0, 0, 0);
        configurarBotonVerde(btnCancelar, 550, 500, 150, 50, verdeBoton);
        add(btnCancelar);

        JLabel lblTipoCambio = new JLabel("Tipo de cambio: 1 USD = 3.85 PEN");
        lblTipoCambio.setBounds(650, 105, 250, 20);
        lblTipoCambio.setFont(new Font("Tahoma", Font.ITALIC, 12));
        lblTipoCambio.setForeground(Color.GRAY);
        add(lblTipoCambio);
    }

    // Métodos auxiliares para evitar repetir código y reducir errores en el Outline
    private void crearBotonMonto(String texto, int x, int y, Color color) {
        JButton btn = new JButton(texto);
        btn.setBounds(150, 280, 200, 50);
        btn.setFont(new Font("Tahoma", Font.BOLD, 16));
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
        btn.setBackground(color);
        btn.setForeground(Color.WHITE);
        btn.setOpaque(true);
        btn.setBorderPainted(false);
        btn.setFocusPainted(false);
        btn.setContentAreaFilled(true);
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnVolver) {
			ventanaPrincipal.menu_usuario();
		}
		// TODO Auto-generated method stub
		
	}
}


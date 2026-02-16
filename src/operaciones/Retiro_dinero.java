package operaciones;

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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import gui.VentanaPrincipal;

public class Retiro_dinero extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	private VentanaPrincipal ventanaPrincipal;

    private JTextField textField;      // MONEDA
    private JTextField textField_1;    // MONTO A RETIRAR
    private JTextField textField_2;    // SALDO

    private JButton btn20;
    private JButton btn50;
    private JButton btn100;
    private JButton btn200;
    private JButton btn500;
    private JButton btn1000;

    public Retiro_dinero(VentanaPrincipal principal) {

        // ✅ ESTO NO SE BORRA
        this.ventanaPrincipal = principal;
        setLayout(null);
        
     // Panel azul central
        JPanel cajaAzul = new JPanel();
        cajaAzul.setBounds(184, 75, 640, 464);
        cajaAzul.setBackground(new Color(2, 64, 89));
        cajaAzul.setLayout(null);
        add(cajaAzul);

        JLabel lblMoneda = new JLabel("MONEDA");
        lblMoneda.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblMoneda.setForeground(Color.WHITE);
        lblMoneda.setBounds(183, 70, 120, 25);
        cajaAzul.add(lblMoneda);

        JLabel lblSaldo = new JLabel("SALDO");
        lblSaldo.setForeground(Color.WHITE);
        lblSaldo.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblSaldo.setBounds(180, 135, 120, 25);
        cajaAzul.add(lblSaldo);

        JLabel lblMonto = new JLabel("MONTO A RETIRAR");
        lblMonto.setForeground(Color.WHITE);
        lblMonto.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblMonto.setBounds(180, 192, 250, 25);
        cajaAzul.add(lblMonto);

        // Campos
        textField = new JTextField();
        textField.setBounds(403, 63, 128, 32);
        cajaAzul.add(textField);

        textField_2 = new JTextField();
        textField_2.setBounds(403, 125, 128, 35);
        cajaAzul.add(textField_2);

        textField_1 = new JTextField();
        textField_1.setBounds(403, 185, 128, 32);
        cajaAzul.add(textField_1);

        // ===== BOTONES RÁPIDOS =====
        Color verde = new Color(128, 191, 33);
        Font fuenteBoton = new Font("Tahoma", Font.BOLD, 16);

        btn20 = crearBoton("20", 120, 250, verde, fuenteBoton);
        btn50 = crearBoton("50", 270, 250, verde, fuenteBoton);
        btn100 = crearBoton("100", 420, 250, verde, fuenteBoton);

        btn200 = crearBoton("200", 120, 300, verde, fuenteBoton);
        btn500 = crearBoton("500", 270, 300, verde, fuenteBoton);
        btn1000 = crearBoton("1000", 420, 300, verde, fuenteBoton);

        cajaAzul.add(btn20);
        cajaAzul.add(btn50);
        cajaAzul.add(btn100);
        cajaAzul.add(btn200);
        cajaAzul.add(btn500);
        cajaAzul.add(btn1000);

        // Botones principales
        JButton btnRetirar = new JButton("RETIRAR");
        btnRetirar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnRetirar.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnRetirar.setBounds(49, 386, 159, 40);
        cajaAzul.add(btnRetirar);

        JButton btnLimpiar = new JButton("LIMPIAR");
        btnLimpiar.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnLimpiar.setBounds(248, 387, 151, 39);
        cajaAzul.add(btnLimpiar);

        JButton btnCancelar = new JButton("CANCELAR");
        btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnCancelar.setBounds(428, 387, 167, 39);
        cajaAzul.add(btnCancelar);

        // Título

        JLabel lblTitulo = new JLabel("RETIRO DE DINERO");
        lblTitulo.setBounds(200, 20, 600, 40);
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 28));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        add(lblTitulo);
    }
        
        private JButton crearBoton(String texto, int x, int y, Color verde, Font fuente) {

        	JButton b = new JButton(texto);
            b.setEnabled(false);
            b.setBounds(229, 246, 90, 35);
            b.setForeground(Color.WHITE);
            b.setBackground(verde);
            b.setFont(fuente);
            b.setOpaque(false);
            b.addActionListener(e -> textField_1.setText(texto));
            return b;
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}

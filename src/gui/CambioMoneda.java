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
import javax.swing.DropMode;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class CambioMoneda extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	CambioMoneda frame = new CambioMoneda();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public CambioMoneda() {
        setTitle("CAMBIO DE MONEDA");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1000, 651); 
        
        contentPane = new JPanel();
        contentPane.setBackground(new Color(240, 240, 240));
        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        
        JLabel lblTitulo = new JLabel("CAMBIO DE MONEDA");
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 28));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setBounds(200, 30, 600, 40);
        contentPane.add(lblTitulo);

        
        JSeparator separator = new JSeparator();
        separator.setBounds(200, 80, 600, 2);
        contentPane.add(separator);

        
        JLabel lblClaveActual = new JLabel("CANTIDAD A CONVERTIR:");
        lblClaveActual.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblClaveActual.setBounds(200, 125, 269, 30);
        contentPane.add(lblClaveActual);

        JLabel lblClaveNueva = new JLabel("DE:");
        lblClaveNueva.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblClaveNueva.setBounds(200, 196, 200, 30);
        contentPane.add(lblClaveNueva);

        JLabel lblConfirmar = new JLabel("A:");
        lblConfirmar.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblConfirmar.setBounds(200, 266, 200, 30);
        contentPane.add(lblConfirmar);

       
        JButton btnCambiar = new JButton("CONVERTIR");
        btnCambiar.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnCambiar.setBackground(new Color(50, 150, 50)); 
        btnCambiar.setForeground(Color.BLACK);
        btnCambiar.setBounds(200, 463, 210, 50);
        contentPane.add(btnCambiar);
      btnCambiar.setFocusPainted(false);
        

        JButton btnCancelar = new JButton("CANCELAR");
        btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnCancelar.setBackground(new Color(200, 50, 50)); 
        btnCancelar.setForeground(Color.BLACK);
        btnCancelar.setBounds(600, 463, 200, 50);
        contentPane.add(btnCancelar);
        btnCancelar.setFocusPainted(false);
        
        
        JLabel lblNota = new JLabel("Tipo de cambio:             Dólar  3.30      Euro 3.99      Soles 1");
        lblNota.setHorizontalAlignment(SwingConstants.CENTER);
        lblNota.setForeground(Color.GRAY);
        lblNota.setFont(new Font("Tahoma", Font.ITALIC, 14));
        lblNota.setBounds(221, 331, 492, 20);
        contentPane.add(lblNota);
        
        textField = new JTextField();
        textField.setFont(new Font("Tahoma", Font.BOLD, 16));
        textField.setBounds(550, 127, 250, 30);
        contentPane.add(textField);
        textField.setColumns(10);
        
        JComboBox comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"    SOLES - PEN", "    DÓLARES - USD", "    EUROS - EUR"}));
        comboBox.setBounds(674, 200, 126, 30);
        contentPane.add(comboBox);
        
        JComboBox comboBox_2 = new JComboBox();
        comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"    SOLES - PEN", "    DÓLARES - USD", "    EUROS - EUR"}));
        comboBox_2.setBounds(674, 270, 126, 30);
        contentPane.add(comboBox_2);
        
        JLabel lblResultado = new JLabel("RESULTADO:");
        lblResultado.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblResultado.setBounds(250, 385, 200, 30);
        contentPane.add(lblResultado);
        
        JLabel lblEur = new JLabel(" 37.59 EUR");
        lblEur.setHorizontalAlignment(SwingConstants.CENTER);
        lblEur.setForeground(Color.GRAY);
        lblEur.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblEur.setBounds(500, 385, 250, 20);
        contentPane.add(lblEur);
        
        JButton btnVolver = new JButton("VOLVER");
        btnVolver.setForeground(Color.BLACK);
        btnVolver.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnVolver.setFocusPainted(false);
        btnVolver.setBackground(Color.BLUE);
        btnVolver.setBounds(392, 536, 200, 50);
        contentPane.add(btnVolver);
    }
}
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
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DepositoDinero extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;
    private JRadioButton rdbtnNewRadioButton;
    private JRadioButton rdbtnDlarUsd;
    private JRadioButton rdbtnEuroEur;
    private JTextField textField_1;
    private JLabel lblSaldoActal;
    private JButton btnVolver;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	DepositoDinero frame = new DepositoDinero();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public DepositoDinero() {
        setTitle("DEPÓSITO DE DINERO");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1000, 600); 
        
        contentPane = new JPanel();
        contentPane.setBackground(new Color(240, 240, 240));
        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        
        JLabel lblTitulo = new JLabel("DEPÓSITO DE DINERO");
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 28));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setBounds(200, 30, 600, 40);
        contentPane.add(lblTitulo);

        
        JSeparator separator = new JSeparator();
        separator.setBounds(200, 80, 600, 2);
        contentPane.add(separator);

        
        JLabel lblClaveActual = new JLabel("Ingrese monto a depositar");
        lblClaveActual.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblClaveActual.setBounds(347, 107, 383, 30);
        contentPane.add(lblClaveActual);

        JLabel lblConfirmar = new JLabel("Número de cuenta:");
        lblConfirmar.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblConfirmar.setBounds(200, 266, 200, 30);
        contentPane.add(lblConfirmar);

       
        JButton btnCambiar = new JButton("CONFIRMAR");
        btnCambiar.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnCambiar.setBackground(new Color(50, 150, 50)); 
        btnCambiar.setForeground(Color.BLACK);
        btnCambiar.setBounds(200, 396, 210, 50);
        contentPane.add(btnCambiar);
      btnCambiar.setFocusPainted(false);
        

        JButton btnCancelar = new JButton("CANCELAR");
        btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnCancelar.setBackground(new Color(200, 50, 50)); 
        btnCancelar.setForeground(Color.BLACK);
        btnCancelar.setBounds(609, 396, 200, 50);
        contentPane.add(btnCancelar);
        btnCancelar.setFocusPainted(false);
        
        
        JLabel lblNota = new JLabel("S/. 1200.00");
        lblNota.setHorizontalAlignment(SwingConstants.CENTER);
        lblNota.setForeground(Color.GRAY);
        lblNota.setFont(new Font("Tahoma", Font.ITALIC, 15));
        lblNota.setBounds(539, 307, 270, 30);
        contentPane.add(lblNota);
        
        textField = new JTextField();
        textField.setFont(new Font("Tahoma", Font.BOLD, 15));
        textField.setBounds(343, 148, 270, 30);
        contentPane.add(textField);
        textField.setColumns(10);
        
        rdbtnNewRadioButton = new JRadioButton("SOLES - PEN");
        rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.BOLD, 14));
        rdbtnNewRadioButton.setBounds(273, 213, 127, 23);
        contentPane.add(rdbtnNewRadioButton);
        
        rdbtnDlarUsd = new JRadioButton("DÓLAR - USD");
        rdbtnDlarUsd.setFont(new Font("Tahoma", Font.BOLD, 14));
        rdbtnDlarUsd.setBounds(446, 213, 117, 23);
        contentPane.add(rdbtnDlarUsd);
        
        rdbtnEuroEur = new JRadioButton("EURO - EUR");
        rdbtnEuroEur.setFont(new Font("Tahoma", Font.BOLD, 14));
        rdbtnEuroEur.setBounds(608, 213, 122, 23);
        contentPane.add(rdbtnEuroEur);
        
        textField_1 = new JTextField();
        textField_1.setFont(new Font("Tahoma", Font.BOLD, 15));
        textField_1.setColumns(10);
        textField_1.setBounds(539, 266, 270, 30);
        contentPane.add(textField_1);
        
        lblSaldoActal = new JLabel("Saldo actúal:");
        lblSaldoActal.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblSaldoActal.setBounds(200, 306, 200, 30);
        contentPane.add(lblSaldoActal);
        
        btnVolver = new JButton("VOLVER");
        btnVolver.addActionListener(this);
        btnVolver.setForeground(Color.BLACK);
        btnVolver.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnVolver.setFocusPainted(false);
        btnVolver.setBackground(new Color(200, 50, 50));
        btnVolver.setBounds(401, 476, 200, 50);
        contentPane.add(btnVolver);
    }
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnVolver) {
			actionPerformedBtnVolver(e);
		}
	}
	protected void actionPerformedBtnVolver(ActionEvent e) {
	}
}
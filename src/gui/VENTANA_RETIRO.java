package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class VENTANA_RETIRO extends JFrame {  //clase

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtMontoRetirar;
    private JComboBox<String> comboMoneda;
    private JLabel lblSimboloMoneda;

    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    VENTANA_RETIRO frame = new VENTANA_RETIRO();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    
    public VENTANA_RETIRO() {   //coonstructores
    	
        setTitle("RETIRO DE DINERO");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1000, 600); 
        contentPane = new JPanel();
        contentPane.setBackground(new Color(240, 240, 240));
        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
     
        
        JLabel lblTitulo = new JLabel("RETIRO DE DINERO");
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 28));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setBounds(200, 30, 600, 40);
        contentPane.add(lblTitulo);
        
      
        JSeparator separator = new JSeparator();
        separator.setBounds(200, 80, 600, 2);
        contentPane.add(separator);
        
        
        JLabel lblSeleccionMoneda = new JLabel("Seleccionar Moneda:");
        lblSeleccionMoneda.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblSeleccionMoneda.setBounds(200, 100, 180, 30);
        contentPane.add(lblSeleccionMoneda);
        
        comboMoneda = new JComboBox<>();
        comboMoneda.setModel(new DefaultComboBoxModel<>(new String[] {"Soles (PEN)", "Dólares (USD)"}));
        comboMoneda.setFont(new Font("Tahoma", Font.PLAIN, 16));
        comboMoneda.setBounds(400, 100, 200, 30);
        contentPane.add(comboMoneda);
        
       
        
        JLabel lblSaldoDisponible = new JLabel("Saldo Disponible:");
        lblSaldoDisponible.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblSaldoDisponible.setBounds(200, 150, 200, 30);
        contentPane.add(lblSaldoDisponible);
        
      
        lblSimboloMoneda = new JLabel("S/.");
        lblSimboloMoneda.setFont(new Font("Tahoma", Font.BOLD, 22));
        lblSimboloMoneda.setForeground(new Color(0, 128, 0));
        lblSimboloMoneda.setBounds(400, 150, 50, 30);
        contentPane.add(lblSimboloMoneda);
        
        JLabel lblSaldoMonto = new JLabel("1,500.00");
        lblSaldoMonto.setFont(new Font("Tahoma", Font.BOLD, 22));
        lblSaldoMonto.setForeground(new Color(0, 128, 0));
        lblSaldoMonto.setBounds(450, 150, 200, 30);
        contentPane.add(lblSaldoMonto);
        
       
        
        JLabel lblMontoRetirar = new JLabel("Monto a Retirar:");
        lblMontoRetirar.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblMontoRetirar.setBounds(200, 210, 180, 30);
        contentPane.add(lblMontoRetirar);
        
       
        JLabel lblSimboloRetiro = new JLabel("S/.");
        lblSimboloRetiro.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblSimboloRetiro.setBounds(380, 210, 40, 30);
        contentPane.add(lblSimboloRetiro);
        
        txtMontoRetirar = new JTextField();
        txtMontoRetirar.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txtMontoRetirar.setBounds(420, 210, 180, 35);
        contentPane.add(txtMontoRetirar);
        txtMontoRetirar.setColumns(10);
        
        
        JButton btn20 = new JButton("S/. 20");
        btn20.setFont(new Font("Tahoma", Font.BOLD, 16));
        btn20.setBounds(150, 280, 200, 50);
        contentPane.add(btn20);
        
        JButton btn50 = new JButton("S/. 50");
        btn50.setFont(new Font("Tahoma", Font.BOLD, 16));
        btn50.setBounds(400, 280, 200, 50);
        contentPane.add(btn50);
        
        JButton btn100 = new JButton("S/. 100");
        btn100.setFont(new Font("Tahoma", Font.BOLD, 16));
        btn100.setBounds(650, 280, 200, 50);
        contentPane.add(btn100);
        
    
        
        JButton btn200 = new JButton("S/. 200");
        btn200.setFont(new Font("Tahoma", Font.BOLD, 16));
        btn200.setBounds(150, 350, 200, 50);
        contentPane.add(btn200);
        
        JButton btn500 = new JButton("S/. 500");
        btn500.setFont(new Font("Tahoma", Font.BOLD, 16));
        btn500.setBounds(400, 350, 200, 50);
        contentPane.add(btn500);
        
        JButton btn1000 = new JButton("S/. 1000");
        btn1000.setFont(new Font("Tahoma", Font.BOLD, 16));
        btn1000.setBounds(650, 350, 200, 50);
        contentPane.add(btn1000);
        
        
        JButton btn20usd = new JButton("$ 20");
        btn20usd.setFont(new Font("Tahoma", Font.BOLD, 16));
        btn20usd.setBounds(150, 280, 200, 50);
        btn20usd.setVisible(false);
        contentPane.add(btn20usd);
        
        JButton btn50usd = new JButton("$ 50");
        btn50usd.setFont(new Font("Tahoma", Font.BOLD, 16));
        btn50usd.setBounds(400, 280, 200, 50);
        btn50usd.setVisible(false);
        contentPane.add(btn50usd);
        
        JButton btn100usd = new JButton("$ 100");
        btn100usd.setFont(new Font("Tahoma", Font.BOLD, 16));
        btn100usd.setBounds(650, 280, 200, 50);
        btn100usd.setVisible(false);
        contentPane.add(btn100usd);
        
        JButton btn200usd = new JButton("$ 200");
        btn200usd.setFont(new Font("Tahoma", Font.BOLD, 16));
        btn200usd.setBounds(150, 350, 200, 50);
        btn200usd.setVisible(false);
        contentPane.add(btn200usd);
        
  
        
        JButton btnLimpiar = new JButton("LIMPIAR");
        btnLimpiar.setFont(new Font("Tahoma", Font.BOLD, 16));
        btnLimpiar.setBackground(new Color(255, 165, 0));
        btnLimpiar.setForeground(Color.BLACK);
        btnLimpiar.setBounds(400, 420, 200, 50);
        contentPane.add(btnLimpiar);
      btnLimpiar.setFocusPainted(false);      
        
        JButton btnRetirar = new JButton("RETIRAR");
        btnRetirar.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnRetirar.setBackground(new Color(50, 150, 50));
        btnRetirar.setForeground(Color.BLACK);
        btnRetirar.setBounds(300, 500, 150, 50);
        contentPane.add(btnRetirar);
      btnRetirar.setFocusPainted(false);
        
        
        
        JButton btnCancelar = new JButton("CANCELAR");
        btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnCancelar.setBackground(new Color(200, 50, 50));
        btnCancelar.setForeground(Color.BLACK);
        btnCancelar.setBounds(550, 500, 150, 50);
        contentPane.add(btnCancelar);
      btnCancelar.setFocusPainted(false);
        
      
        JLabel lblTipoCambio = new JLabel("Tipo de cambio: 1 USD = 3.85 PEN");
        lblTipoCambio.setFont(new Font("Tahoma", Font.ITALIC, 12));
        lblTipoCambio.setForeground(Color.GRAY);
        lblTipoCambio.setBounds(650, 105, 250, 20);
        contentPane.add(lblTipoCambio);
    }
}




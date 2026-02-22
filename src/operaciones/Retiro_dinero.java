package operaciones;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Locale;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager; // Necesario para el estilo visual
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicButtonUI;

import datos.AlmacenDatos;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import gui.VentanaPrincipal;
import modelos.Cuenta;
import modelos.Moneda;
import modelos.Usuario;
import servicio.CuentaService;
import servicio.MonedaService;
import servicio.Sesion;
import servicio.TransaccionService;

public class Retiro_dinero extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	private VentanaPrincipal ventanaPrincipal;
	private CuentaService cuentaService = new CuentaService();
	private JComboBox<String> comboMoneda;
	private JTextField txtSaldo;
	private JTextField txtMontoRetiro;
	private JSeparator separator;
	private JButton btnRetirar, btnLimpiar, btnCancelar;
	private JComboBox comboCuenta;
	private JButton btn20;
	private JButton btn50;
	private JButton btn100;
	private JButton btn200;
	private JButton btn1000;
	private JButton btn500;
	
	public Retiro_dinero(VentanaPrincipal principal) {
		
		this.ventanaPrincipal = principal;

		setLayout(null);
		setBackground(new Color(2, 64, 89));
		setPreferredSize(new java.awt.Dimension(1000, 620));

		// TITULO
	    JLabel lblTitulo = new JLabel("RETIRO DE DINERO");
	    lblTitulo.setBounds(174, 29, 600, 40);
	    lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 28));
	    lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
	    lblTitulo.setForeground(new Color(255, 255, 255));
	    add(lblTitulo);
	    
	    JSeparator separator = new JSeparator();
        separator.setBounds(199, 90, 600, 2);
        add(separator);
		
	    JLabel lblNDeCuenta = new JLabel("N° DE CUENTA");
	    lblNDeCuenta.setForeground(new Color(255, 255, 255));
	    lblNDeCuenta.setFont(new Font("Tahoma", Font.BOLD, 20));
	    lblNDeCuenta.setBounds(199, 133, 200, 25);
	    add(lblNDeCuenta);
        
		JLabel lblMoneda = new JLabel("MONEDA");
		lblMoneda.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblMoneda.setForeground(new Color(255, 255, 255));
		lblMoneda.setBounds(199, 191, 120, 25);
		add(lblMoneda);

		JLabel lblSaldo = new JLabel("SALDO ACTUAL");
		lblSaldo.setForeground(new Color(255, 255, 255));
		lblSaldo.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblSaldo.setBounds(199, 253, 200, 25);
		add(lblSaldo);

		JLabel lblMonto = new JLabel("MONTO A RETIRAR");
		lblMonto.setForeground(new Color(255, 255, 255));
		lblMonto.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblMonto.setBounds(199, 310, 216, 25);
		add(lblMonto);

		// COMPONENTES
		comboMoneda = new JComboBox();
		comboMoneda.setBounds(477, 189, 308, 32);
		comboMoneda.setFont(new Font("Tahoma", Font.BOLD, 15));
		comboMoneda.setMaximumRowCount(5);
		for(int i = 0; i < AlmacenDatos.listaMonedas.size(); i++) {
			Moneda moneda = AlmacenDatos.listaMonedas.get(i);
			comboMoneda.addItem(moneda.getNombre());
		}
		add(comboMoneda);
		comboMoneda.addActionListener(this);
		
		comboCuenta = new JComboBox();
	    comboCuenta.setMaximumRowCount(5);
	    comboCuenta.setFont(new Font("Tahoma", Font.BOLD, 13));
	    comboCuenta.setBounds(477, 133, 308, 32);
	    add(comboCuenta);
	    comboCuenta.addActionListener(this);
		
		txtSaldo = new JTextField();
		txtSaldo.setBackground(new Color(230, 250, 251));
		txtSaldo.setForeground(new Color(154, 205, 50));
		txtSaldo.setEditable(false);
		txtSaldo.setBounds(477, 251, 308, 32);
		txtSaldo.setFont(new Font("Tahoma", Font.BOLD, 16));
		add(txtSaldo);

		txtMontoRetiro = new JTextField();
		txtMontoRetiro.setBounds(477, 308, 308, 32);
		txtMontoRetiro.setFont(new Font("Tahoma", Font.BOLD, 16));
		add(txtMontoRetiro);
	    
	    btnLimpiar = new JButton("LIMPIAR");
	    btnLimpiar.setBounds(421, 521, 151, 39);
	    btnLimpiar.setBackground(new Color(128, 191, 33));
	    btnLimpiar.setForeground(new Color(255, 255, 255));
	    btnLimpiar.setFont(new Font("Tahoma", Font.BOLD, 20));
	    btnLimpiar.setContentAreaFilled(false); 
	    btnLimpiar.setOpaque(true);
	    add(btnLimpiar);
	    btnLimpiar.addActionListener(this);
        
	    btnCancelar = new JButton("CANCELAR");
	    btnCancelar.setBounds(632, 521, 167, 39);	    
	    btnCancelar.setBackground(new Color(128, 191, 33));
	    btnCancelar.setForeground(new Color(255, 255, 255));
	    btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 20));
	    btnCancelar.setContentAreaFilled(false); 
	    btnCancelar.setOpaque(true);
	    add(btnCancelar);
	    btnCancelar.addActionListener(this);
	    
        
	    // BOTONES PRINCIPALES
	    btnRetirar = new JButton("RETIRAR");
	    btnRetirar.setBounds(199, 520, 159, 40);
	    add(btnRetirar);
	    btnRetirar.addActionListener(this);
	    btnRetirar.setBackground(new Color(128, 191, 33));
	    btnRetirar.setForeground(new Color(255, 255, 255));
	    btnRetirar.setFont(new Font("Tahoma", Font.BOLD, 20));
	    btnRetirar.setContentAreaFilled(false); 
	    btnRetirar.setOpaque(true);
	    
	    btn20 = new JButton("20");
	    btn20.setOpaque(true);
	    btn20.setForeground(Color.WHITE);
	    btn20.setFont(new Font("Tahoma", Font.BOLD, 20));
	    btn20.setBackground(new Color(128, 191, 33));
	    btn20.setBounds(267, 372, 91, 40);
	    btn20.setContentAreaFilled(false);
	    btn20.setOpaque(true);
	    add(btn20);
	    btn20.addActionListener(this);
	    
	    btn50 = new JButton("50");
	    btn50.setOpaque(true);
	    btn50.setForeground(Color.WHITE);
	    btn50.setFont(new Font("Tahoma", Font.BOLD, 20));
	    btn50.setBackground(new Color(128, 191, 33));
	    btn50.setBounds(447, 372, 91, 40);
	    btn50.setContentAreaFilled(false);
	    btn50.setOpaque(true);
	    add(btn50);
	    btn50.addActionListener(this);
	    
	    btn100 = new JButton("100");
	    btn100.setOpaque(true);
	    btn100.setForeground(Color.WHITE);
	    btn100.setFont(new Font("Tahoma", Font.BOLD, 20));
	    btn100.setBackground(new Color(128, 191, 33));
	    btn100.setBounds(632, 372, 91, 40);
	    btn100.setContentAreaFilled(false);
	    btn100.setOpaque(true);
	    add(btn100);
	    btn100.addActionListener(this);
	  
	    btn200 = new JButton("200");
	    btn200.setOpaque(true);
	    btn200.setForeground(Color.WHITE);
	    btn200.setFont(new Font("Tahoma", Font.BOLD, 20));
	    btn200.setBackground(new Color(128, 200, 33));
	    btn200.setBounds(267, 434, 91, 40);
	    btn200.setContentAreaFilled(false);
	    btn200.setOpaque(true);
	    add(btn200);
	    btn200.addActionListener(this);
	    
	    btn1000 = new JButton("1000");
	    btn1000.setOpaque(true);
	    btn1000.setForeground(Color.WHITE);
	    btn1000.setFont(new Font("Tahoma", Font.BOLD, 20));
	    btn1000.setBackground(new Color(128, 200, 33));
	    btn1000.setBounds(632, 434, 91, 40);
	    btn1000.setContentAreaFilled(false);
	    btn1000.setOpaque(true);
	    add(btn1000);
	    btn1000.addActionListener(this);
	    
	    btn500 = new JButton("500");
	    btn500.setOpaque(true);
	    btn500.setForeground(Color.WHITE);
	    btn500.setFont(new Font("Tahoma", Font.BOLD, 20));
	    btn500.setBackground(new Color(128, 200, 33));
	    btn500.setBounds(447, 434, 91, 40);
	    btn500.setContentAreaFilled(false);
	    btn500.setOpaque(true);
	    add(btn500);
	    btn500.addActionListener(this);
	    
	    setSaldo();
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == btnCancelar) {
			ventanaPrincipal.menu_usuario();
		}
		if(e.getSource() == comboCuenta) {
			setSaldo();
		}
		if(e.getSource() == btn20) {
	        txtMontoRetiro.setText("20");
	    } else if(e.getSource() == btn50) {
	        txtMontoRetiro.setText("50");
	    } else if(e.getSource() == btn100) {
	        txtMontoRetiro.setText("100");
	    } else if(e.getSource() == btn200) {
	        txtMontoRetiro.setText("200");
	    } else if(e.getSource() == btn500) {
	        txtMontoRetiro.setText("500");
	    } else if(e.getSource() == btn1000) {
	        txtMontoRetiro.setText("1000");
	    }
		if(e.getSource() == btnRetirar) {
			actionPerformedbtnRetirar(e);
		}
		if(e.getSource() == btnLimpiar) {
			limpiarCampos();
		}
	}
	
	public void CargarCuenta() {
		comboCuenta.removeAllItems();
		Usuario usuarioActual = Sesion.obtener();
		if (usuarioActual == null) return;
		CuentaService service = new CuentaService();
		ArrayList<Cuenta> cuentas = service.listarCuentasPorUsuario(usuarioActual);
		for(int i = 0; i < cuentas.size(); i++) {
			comboCuenta.addItem(cuentas.get(i));
		}
	}
	
	public void actualizarMoneda() {
		comboMoneda.removeAllItems();
		MonedaService service = new MonedaService();
		ArrayList<Moneda> monedas = service.listarMoneda();
		for(int i = 0; i < monedas.size(); i++) {
			Moneda moneda = monedas.get(i);
			comboMoneda.addItem(moneda.getNombre());
		}
	}
	
	public void setSaldo() {
		Usuario usuarioActual = Sesion.obtener();
		Cuenta cuenta = (Cuenta) comboCuenta.getSelectedItem();
		if(cuenta != null) {
			String saldo = String.format(Locale.US, "%.2f", cuenta.getSaldo());
			this.txtSaldo.setText(saldo);
		}
	}
	
	private void limpiarCampos() {
		txtMontoRetiro.setText("");
	}
	
	public void actionPerformedbtnRetirar(ActionEvent e) {
		try {
			Cuenta cuenta = (Cuenta) comboCuenta.getSelectedItem();
			String moneda = (String) comboMoneda.getSelectedItem();
			double monto = Double.parseDouble(txtMontoRetiro.getText());
			TransaccionService servicio = new TransaccionService();
			String respuesta = servicio.RetiroDinero(monto, cuenta, moneda);
			
			if (respuesta.startsWith("EXITO")) {
				String recibo = respuesta.replace("EXITO", "");
				JOptionPane.showMessageDialog(this, recibo, "Operación Exitosa", JOptionPane.INFORMATION_MESSAGE);
				setSaldo();
	            txtMontoRetiro.setText("");
			} else {
				JOptionPane.showMessageDialog(this, respuesta, "Éxito", JOptionPane.INFORMATION_MESSAGE);
			}
		
	} catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(this, "Por favor, ingresa un monto numérico válido.", "Error de Formato", JOptionPane.ERROR_MESSAGE);
    } catch (NullPointerException ex) {
        JOptionPane.showMessageDialog(this, "Asegúrate de seleccionar una cuenta y una moneda.", "Atención", JOptionPane.WARNING_MESSAGE);
    }
	}	
	
}

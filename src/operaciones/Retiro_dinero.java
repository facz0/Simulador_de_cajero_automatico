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
import servicio.Sesion;

public class Retiro_dinero extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	private VentanaPrincipal ventanaPrincipal;
	private CuentaService cuentaService = new CuentaService();
	private JComboBox<String> comboMoneda;
	private JTextField txtSaldo;
	private JTextField txtMontoRetiro;
	private JSeparator separator;
	private JButton btnRetirar, btnLimpiar, btnCancelar;
	private JButton btnVolver;
	private JComboBox comboCuenta;
	
	public Retiro_dinero(VentanaPrincipal principal) {
		
		this.ventanaPrincipal = principal;

		setLayout(null);
		setBackground(Color.WHITE);
		setPreferredSize(new java.awt.Dimension(1000, 620));

		// BOTON VOLVER
		btnVolver = new JButton("< VOLVER");
		btnVolver.setBounds(26, 23, 138, 34);
		add(btnVolver);
		btnVolver.addActionListener(this);
		btnVolver.setBackground(new Color(128, 191, 33));
	    btnVolver.setForeground(new Color(255, 255, 255));
		btnVolver.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnVolver.setContentAreaFilled(false); 
	    btnVolver.setOpaque(true);

		// TITULO
	    JLabel lblTitulo = new JLabel("RETIRO DE DINERO");
	    lblTitulo.setBounds(174, 29, 600, 40);
	    lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 28));
	    lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
	    lblTitulo.setForeground(new Color(2, 64, 89));
	    add(lblTitulo);
	    
	    JSeparator separator = new JSeparator();
        separator.setBounds(199, 90, 600, 2);
        add(separator);
		
	    JLabel lblNDeCuenta = new JLabel("N° DE CUENTA");
	    lblNDeCuenta.setForeground(new Color(2, 64, 89));
	    lblNDeCuenta.setFont(new Font("Tahoma", Font.BOLD, 20));
	    lblNDeCuenta.setBounds(199, 133, 200, 25);
	    add(lblNDeCuenta);
        
		JLabel lblMoneda = new JLabel("MONEDA");
		lblMoneda.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblMoneda.setForeground(new Color(2, 64, 89));
		lblMoneda.setBounds(199, 191, 120, 25);
		add(lblMoneda);

		JLabel lblSaldo = new JLabel("SALDO ACTUAL");
		lblSaldo.setForeground(new Color(2, 64, 89));
		lblSaldo.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblSaldo.setBounds(199, 253, 200, 25);
		add(lblSaldo);

		JLabel lblMonto = new JLabel("MONTO A RETIRAR");
		lblMonto.setForeground(new Color(2, 64, 89));
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
	    btnLimpiar.setForeground(new Color(255, 215, 0));
	    btnLimpiar.setBounds(421, 502, 151, 39);
	    btnLimpiar.setFont(new Font("Tahoma", Font.BOLD, 20));
	    
	    btnLimpiar.addActionListener(e -> limpiarCampos());
	    add(btnLimpiar);
        
	    btnCancelar = new JButton("CANCELAR");
	    btnCancelar.setForeground(new Color(178, 34, 34));
	    btnCancelar.setBounds(630, 502, 167, 39);
	    btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 20));
	    
	    btnCancelar.addActionListener(e -> ventanaPrincipal.menu_usuario());
	    add(btnCancelar);
	    
        
	    // BOTONES PRINCIPALES
	    btnRetirar = new JButton("RETIRAR");
	    btnRetirar.setBounds(199, 501, 159, 40);
	    add(btnRetirar);
	    btnRetirar.addActionListener(this);
	    btnRetirar.setBackground(new Color(128, 191, 33));
	    btnRetirar.setForeground(new Color(255, 255, 255));
	    btnRetirar.setFont(new Font("Tahoma", Font.BOLD, 20));
	    btnRetirar.setContentAreaFilled(false); 
	    btnRetirar.setOpaque(true);
	    
	    
        
	    actualizarInterfaz();
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
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

	private void ejecutarRetiro() {
		try {
			Cuenta cuenta = ventanaPrincipal.getCuentaActual();
			if (cuenta == null) {
				JOptionPane.showMessageDialog(this, "Error: Sesión no encontrada.");
				return;
			}

			double monto = Double.parseDouble(txtMontoRetiro.getText());

			cuentaService.retirarDinero(cuenta, monto);

			JOptionPane.showMessageDialog(this,
					"Retiro exitoso.\nSu nuevo saldo es: " + String.format(Locale.US, "%.2f", cuenta.getSaldo()));

			actualizarInterfaz();
			txtMontoRetiro.setText("");

		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(this, "Por favor, ingrese un monto válido.");
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(this, ex.getMessage());
		}
	}
	
	public void actualizarInterfaz() {

		if (ventanaPrincipal.getCuentaActual() != null) {
			double saldoActual = ventanaPrincipal.getCuentaActual().getSaldo();
			txtSaldo.setText(String.format(Locale.US, "%.2f", saldoActual));
		}
	}
	
	private void limpiarCampos() {
		txtMontoRetiro.setText("");
		actualizarInterfaz();
	}
}

package operaciones;

import javax.swing.JPanel;
import javax.swing.JLabel;

// se importa Joptionpane
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingConstants;
import gui.VentanaPrincipal;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.util.Locale; 
import datos.AlmacenDatos;
import modelos.Cuenta;
import modelos.Usuario;
import modelos.Moneda;
import modelos.Transaccion;
import servicio.TransaccionService; 

public class DepositoDinero extends JPanel implements ActionListener {

    private static final long serialVersionUID = 1L;
    private VentanaPrincipal ventanaPrincipal;
    private JLabel lblTitulo;
    private JSeparator separator;
    private JLabel lblIngreseMonto;
    private JLabel lblMiCuenta;
    private JLabel lblCuentaDestino;
    private JLabel lblSaldoActual;
    private JButton btnConfirmar;
    private JButton btnCancelar;
    private JButton btnVolver;
    private JTextField txtMontoDepositar;
    private JTextField txtCuentaDestino;
    private JTextField txtSaldoActual;
    private JComboBox<String> cmbMiCuenta;

    public DepositoDinero(VentanaPrincipal principal) {

        this.ventanaPrincipal = principal;

        setBackground(new Color(2, 64, 89));
        setPreferredSize(new java.awt.Dimension(1000, 620));
        setLayout(null);

        lblTitulo = new JLabel("DEPÓSITO DE DINERO");
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 28));
        lblTitulo.setBounds(199, 41, 600, 40);
        lblTitulo.setForeground(new Color(255, 255, 255));
        add(lblTitulo);

        separator = new JSeparator();
        separator.setBounds(199, 90, 600, 2);
        add(separator);

        lblIngreseMonto = new JLabel("Ingrese monto a depositar");
        lblIngreseMonto.setForeground(new Color(255, 255, 255));
        lblIngreseMonto.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblIngreseMonto.setBounds(346, 117, 383, 30);
        add(lblIngreseMonto);

        txtMontoDepositar = new JTextField();
        txtMontoDepositar.setFont(new Font("Tahoma", Font.BOLD, 15));
        txtMontoDepositar.setBounds(346, 158, 270, 30);
        add(txtMontoDepositar);

        lblMiCuenta = new JLabel("Número de cuenta ORIGEN:");
        lblMiCuenta.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblMiCuenta.setBounds(127, 223, 350, 30);
        lblMiCuenta.setForeground(new Color(255, 255, 255));
        add(lblMiCuenta);

        cmbMiCuenta = new JComboBox<>();
        cmbMiCuenta.setBounds(538, 223, 261, 30);
        add(cmbMiCuenta);

        lblCuentaDestino = new JLabel("Número de cuenta DESTINO:");
        lblCuentaDestino.setForeground(new Color(255, 255, 255));
        lblCuentaDestino.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblCuentaDestino.setBounds(127, 279, 350, 30);
        add(lblCuentaDestino);

        txtCuentaDestino = new JTextField();
        txtCuentaDestino.setFont(new Font("Tahoma", Font.BOLD, 15));
        txtCuentaDestino.setBounds(538, 282, 261, 30);
        add(txtCuentaDestino);

        lblSaldoActual = new JLabel("Saldo actual:");
        lblSaldoActual.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblSaldoActual.setBounds(127, 337, 200, 40);
        lblSaldoActual.setForeground(new Color(255, 255, 255));
        add(lblSaldoActual);

        txtSaldoActual = new JTextField();
        txtSaldoActual.setEditable(false);
        txtSaldoActual.setForeground(new Color(2, 64, 89));
        txtSaldoActual.setFont(new Font("Tahoma", Font.BOLD, 14));
        txtSaldoActual.setBounds(538, 340, 261, 40);
        add(txtSaldoActual);

        btnConfirmar = new JButton("CONFIRMAR");
        btnConfirmar.addActionListener(this);
        btnConfirmar.setForeground(Color.WHITE);
        btnConfirmar.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnConfirmar.setFocusPainted(false);
        btnConfirmar.setBackground(new Color(128, 191, 33));
        btnConfirmar.setBounds(199, 450, 210, 50);
        btnConfirmar.setContentAreaFilled(false);
        btnConfirmar.setOpaque(true);
        add(btnConfirmar);

        btnCancelar = new JButton("CANCELAR");
        btnCancelar.addActionListener(this);
        btnCancelar.setForeground(Color.WHITE);
        btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnCancelar.setFocusPainted(false);
        btnCancelar.setBackground(new Color(3, 120, 166));
        btnCancelar.setBounds(599, 450, 200, 50);
        btnCancelar.setContentAreaFilled(false);
        btnCancelar.setOpaque(true);
        add(btnCancelar);

        btnVolver = new JButton("VOLVER");
        btnVolver.addActionListener(this);
        btnVolver.setForeground(Color.WHITE);
        btnVolver.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnVolver.setFocusPainted(false);
        btnVolver.setBackground(new Color(128, 191, 33));
        btnVolver.setBounds(393, 540, 200, 50);
        btnVolver.setContentAreaFilled(false);
        btnVolver.setOpaque(true);
        add(btnVolver);
        
        // AL CAMBIAR EL COMBOBOX SE ACTUALIZA EL SALDO
        cmbMiCuenta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarSaldoCuentaOrigen();
            }
        });

        cargarCuentasEnCombo();
        mostrarSaldoCuentaOrigen();
        
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnConfirmar) {
            confirmarOperacion();
        }
        
        if (e.getSource() == btnCancelar || e.getSource() == btnVolver) {
            ventanaPrincipal.menu_usuario();
        }
    }

    private void mostrarSaldoCuentaOrigen() {
    	if (cmbMiCuenta.getSelectedItem() == null) {
            txtSaldoActual.setText("0.00");
            return;
        }
    	
    	String texto = cmbMiCuenta.getSelectedItem().toString();
        String numCuenta = texto.split(" - ")[0];
        Cuenta cuentaOrigen = AlmacenDatos.cuentaPorNumero(numCuenta);
        if (cuentaOrigen != null) {
            txtSaldoActual.setText(String.format(Locale.US, "%.2f", cuentaOrigen.getSaldo())); // ✅ CAMBIO
        } else {
            txtSaldoActual.setText("0.00");
        }
    }
    
    // RECARGA LAS CUENTAS Y SALDO MOSTRADO EN LA PANTALLA
    @Override
    public void addNotify() {
        super.addNotify();
        cargarCuentasEnCombo();
        mostrarSaldoCuentaOrigen();
    }
    
    // METODO MUESTRA LAS CUENTAS DEL USUARIO LOGEADO
    private void cargarCuentasEnCombo() {

    	cmbMiCuenta.removeAllItems();
        Usuario user = ventanaPrincipal.getUsuarioActual();
        if (user == null) {
            return;
        }
        
        for (int i = 0; i < AlmacenDatos.listaCuentas.size(); i++) {
            Cuenta c = AlmacenDatos.listaCuentas.get(i);
            if (c.getUsuario() != null && c.getUsuario().getDNI().equals(user.getDNI())) { 
                String item = c.getNumeroCuenta() + " - " + c.getMoneda().getNombre();
                cmbMiCuenta.addItem(item);
            }
        }
    }
    
    // METODO CONVIERTE MONEDA DISTINTAS
    private double convertirMonto(double monto, Moneda origen, Moneda destino) {

        if (origen == null || destino == null) return monto;

        if (origen.getNombre().equalsIgnoreCase(destino.getNombre())) {
            return monto;
        }

        double tcOrigen = origen.getTipoCambio();
        double tcDestino = destino.getTipoCambio();

        double montoEnSoles = monto * tcOrigen;
        return montoEnSoles / tcDestino;
    }

    // METODO DE TRANSACCION
    private void registrarTransaccion(Cuenta cuenta, Transaccion.Tipo tipo, double monto) {
        if (cuenta == null) return;

        Transaccion trans = new Transaccion(
                cuenta.getNumeroCuenta(),
                tipo,
                monto
        );

        TransaccionService ts = new TransaccionService();
        ts.registrarTransaccion(cuenta, trans);
    }
    
    // METODO CONFIRMA DEPOSITO / TRANSFERENCIA 
    private void confirmarOperacion() {
        try {
            double monto = Double.parseDouble(txtMontoDepositar.getText());
            if (monto <= 0) {
                JOptionPane.showMessageDialog(this, "Ingrese un monto válido.");
                return;
            }
            
            if (cmbMiCuenta.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(this, "Seleccione su cuenta de origen.");
                return;
            }
            // ORIGEN
            String textoOrigen = cmbMiCuenta.getSelectedItem().toString();
            String numOrigen = textoOrigen.split(" - ")[0];

            Cuenta cuentaOrigen = AlmacenDatos.cuentaPorNumero(numOrigen);
            if (cuentaOrigen == null) {
                JOptionPane.showMessageDialog(this, "No se encontró la cuenta de origen.");
                return;
            }

            // DESTINO SI ESTA VACIO = DEPOSITO
            String numDestino = txtCuentaDestino.getText().trim();
            if (numDestino.isEmpty()) {
                numDestino = numOrigen;
            }
            
            Cuenta cuentaDestino = AlmacenDatos.cuentaPorNumero(numDestino);
            if (cuentaDestino == null) {
                JOptionPane.showMessageDialog(this, "No existe el número de cuenta destino: " + numDestino);
                return;
            }
            
            // DEPÓSITO MISMA CUENTA
            if (numOrigen.equals(numDestino)) {

                cuentaOrigen.setSaldo(cuentaOrigen.getSaldo() + monto);
                txtSaldoActual.setText(String.format(Locale.US, "%.2f", cuentaOrigen.getSaldo())); 
                registrarTransaccion(cuentaOrigen, Transaccion.Tipo.Deposito, monto);
                JOptionPane.showMessageDialog(this, "Depósito realizado con éxito.");
                limpiarCampos();
                return;
            }
            
            // TRANSFERENCIA
            if (cuentaOrigen.getSaldo() < monto) {
                JOptionPane.showMessageDialog(this, "Saldo insuficiente.");
                return;
            }
            
            //  DESCUENTA CTA ORIGEN
            cuentaOrigen.setSaldo(cuentaOrigen.getSaldo() - monto);

            // CONVIERTE MONTO A MONEDA FINAL
            double montoConvertido = convertirMonto(monto, cuentaOrigen.getMoneda(), cuentaDestino.getMoneda());        

            // SUMA
            cuentaDestino.setSaldo(cuentaDestino.getSaldo() + montoConvertido);
            txtSaldoActual.setText(String.format(Locale.US, "%.2f", cuentaOrigen.getSaldo()));       

            registrarTransaccion(cuentaOrigen, Transaccion.Tipo.Transferencia, monto);
            registrarTransaccion(cuentaDestino, Transaccion.Tipo.Transferencia, montoConvertido);
            
            JOptionPane.showMessageDialog(this,
                    "Transferencia realizada con éxito.\n" +
                    "Monto enviado: " + String.format(Locale.US, "%.2f", monto) + " (" + cuentaOrigen.getMoneda().getNombre() + ")\n" +
                    "Monto recibido: " + String.format(Locale.US, "%.2f", montoConvertido) + " (" + cuentaDestino.getMoneda().getNombre() + ")"
            );
            
            limpiarCampos();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Ingrese un número válido.");
        }
    }
    
    private void limpiarCampos() {
        txtMontoDepositar.setText("");
        txtCuentaDestino.setText("");
    }
    
    
}
  

	
	
	
	
	
	
	
	
	
	
	
package operaciones;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingConstants;
import gui.VentanaPrincipal;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;
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
    private JTextField txtMontoDepositar;
    private JTextField txtCuentaDestino;
    private JTextField txtSaldoActual;
    private JComboBox<String> cmbMiCuenta;//

    public DepositoDinero(VentanaPrincipal principal) {
        this.ventanaPrincipal = principal;
        
      //ICONOS
        ImageIcon titulo = new ImageIcon(getClass().getResource("/iconos/tituloMoney.png"));
        ImageIcon saldo = new ImageIcon(getClass().getResource("/iconos/monedas.png"));
        ImageIcon monto = new ImageIcon(getClass().getResource("/iconos/billeteReporte.png"));
        ImageIcon cuenta = new ImageIcon(getClass().getResource("/iconos/cuentaBancaria.png"));
        ImageIcon salir = new ImageIcon(getClass().getResource("/iconos/salirReporte.png"));
        ImageIcon confirmar = new ImageIcon(getClass().getResource("/iconos/listarReporte2.png"));

        
        
        setBackground(new Color(2, 64, 89));
        setPreferredSize(new java.awt.Dimension(1000, 620));
        setLayout(null);

        lblTitulo = new JLabel("DEPÓSITO DE DINERO");
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 28));
        lblTitulo.setBounds(199, 88, 600, 40);
        lblTitulo.setForeground(new Color(255, 255, 255));
        lblTitulo.setIcon(titulo);
        add(lblTitulo);

        separator = new JSeparator();
        separator.setBackground(new Color(255, 255, 255));
        separator.setBounds(199, 155, 600, 2);
        add(separator);

        lblIngreseMonto = new JLabel("Ingrese monto a depositar:");
        lblIngreseMonto.setBackground(new Color(255, 255, 255));
        lblIngreseMonto.setForeground(new Color(255, 255, 255));
        lblIngreseMonto.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblIngreseMonto.setBounds(199, 191, 383, 30);
        lblIngreseMonto.setIcon(monto);
        add(lblIngreseMonto);

        txtMontoDepositar = new JTextField();
        txtMontoDepositar.setFont(new Font("Tahoma", Font.BOLD, 15));
        txtMontoDepositar.setBounds(538, 194, 261, 30);
        add(txtMontoDepositar);

        lblMiCuenta = new JLabel("Número de cuenta origen:");
        lblMiCuenta.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblMiCuenta.setBounds(199, 257, 350, 30);
        lblMiCuenta.setForeground(new Color(255, 255, 255));
        lblMiCuenta.setIcon(cuenta);
        add(lblMiCuenta);

        cmbMiCuenta = new JComboBox<>();
        cmbMiCuenta.setBounds(538, 261, 261, 30);
        add(cmbMiCuenta);

        lblCuentaDestino = new JLabel("Número de cuenta destino:");
        lblCuentaDestino.setForeground(new Color(255, 255, 255));
        lblCuentaDestino.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblCuentaDestino.setBounds(199, 320, 350, 30);
        lblCuentaDestino.setIcon(cuenta);
        add(lblCuentaDestino);

        txtCuentaDestino = new JTextField();
        txtCuentaDestino.setFont(new Font("Tahoma", Font.BOLD, 15));
        txtCuentaDestino.setBounds(538, 323, 261, 30);
        add(txtCuentaDestino);

        lblSaldoActual = new JLabel("Saldo actual del Usuario:");
        lblSaldoActual.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblSaldoActual.setBounds(199, 389, 282, 40);
        lblSaldoActual.setForeground(new Color(255, 255, 255));
        lblSaldoActual.setIcon(saldo);
        add(lblSaldoActual);

        txtSaldoActual = new JTextField();
        txtSaldoActual.setEditable(false);
        txtSaldoActual.setEnabled(false);
        txtSaldoActual.setFont(new Font("Tahoma", Font.BOLD, 14));
        txtSaldoActual.setBounds(538, 397, 261, 30);
        add(txtSaldoActual);

        btnConfirmar = new JButton("CONFIRMAR");
        btnConfirmar.addActionListener(this);
        btnConfirmar.setForeground(Color.WHITE);
        btnConfirmar.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnConfirmar.setFocusPainted(false);
        btnConfirmar.setBackground(new Color(128, 191, 33));
        btnConfirmar.setBounds(589, 479, 210, 50);
        btnConfirmar.setContentAreaFilled(false);
        btnConfirmar.setOpaque(true);
        btnConfirmar.setIcon(confirmar);
        add(btnConfirmar);

        btnCancelar = new JButton("SALIR");
        btnCancelar.addActionListener(this);
        btnCancelar.setForeground(Color.WHITE);
        btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnCancelar.setFocusPainted(false);
        btnCancelar.setBackground(new Color(96, 125, 139));
        btnCancelar.setBounds(199, 479, 210, 50);
        btnCancelar.setContentAreaFilled(false);
        btnCancelar.setOpaque(true);
        btnCancelar.setIcon(salir);
        add(btnCancelar);

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

    // METODO MOSTRARA SALDO CON 2 DECIMALES
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
                txtMontoDepositar.setText("");
                txtMontoDepositar.requestFocus();
                return;
            }
            if (cmbMiCuenta.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(this, "Seleccione su cuenta de origen.");
                return;
            }
            String textoOrigen = cmbMiCuenta.getSelectedItem().toString();
            String numOrigen = textoOrigen.split(" - ")[0];

            Cuenta cuentaOrigen = AlmacenDatos.cuentaPorNumero(numOrigen);
            if (cuentaOrigen == null) {
                JOptionPane.showMessageDialog(this, "No se encontró la cuenta de origen.");
                return;
            }
            String numDestino = txtCuentaDestino.getText().trim();
            if (numDestino.isEmpty()) {
                numDestino = numOrigen;
            }

            Cuenta cuentaDestino = AlmacenDatos.cuentaPorNumero(numDestino);

            if (cuentaDestino == null) {
                JOptionPane.showMessageDialog(this,
                        "No existe el número de cuenta destino: " + numDestino);

                txtCuentaDestino.setText("");
                txtMontoDepositar.setText("");
                txtCuentaDestino.requestFocus();
                return;
            }

            if (numOrigen.equals(numDestino)) {

                cuentaOrigen.setSaldo(cuentaOrigen.getSaldo() + monto);
                txtSaldoActual.setText(String.format(java.util.Locale.US, "%.2f", cuentaOrigen.getSaldo()));

                registrarTransaccion(cuentaOrigen, Transaccion.Tipo.Deposito, monto);

                JOptionPane.showMessageDialog(this, "Depósito realizado con éxito.");
                limpiarCampos();
                return;
            }

            if (cuentaOrigen.getSaldo() < monto) {
                JOptionPane.showMessageDialog(this, "Saldo insuficiente.");

                txtMontoDepositar.setText("");
                txtMontoDepositar.requestFocus();
                return;
            }

            // Descuenta cta origen
            cuentaOrigen.setSaldo(cuentaOrigen.getSaldo() - monto);

            // convierte monto si es moneda distinta
            double montoConvertido = convertirMonto(monto, cuentaOrigen.getMoneda(), cuentaDestino.getMoneda());

            // suma monto a la cuenta destino
            cuentaDestino.setSaldo(cuentaDestino.getSaldo() + montoConvertido);

            // Actualiza saldo
            txtSaldoActual.setText(String.format(java.util.Locale.US, "%.2f", cuentaOrigen.getSaldo()));

            // Registrar transacciones 
            registrarTransaccion(cuentaOrigen, Transaccion.Tipo.Transferencia, monto);
            registrarTransaccion(cuentaDestino, Transaccion.Tipo.Transferencia, montoConvertido);

            JOptionPane.showMessageDialog(this,
                    "Transferencia realizada con éxito.\n" +
                    "Monto enviado: " + String.format(java.util.Locale.US, "%.2f", monto) +
                    " (" + cuentaOrigen.getMoneda().getNombre() + ")\n" +
                    "Monto recibido: " + String.format(java.util.Locale.US, "%.2f", montoConvertido) +
                    " (" + cuentaDestino.getMoneda().getNombre() + ")");

            limpiarCampos();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Ingrese un número válido.");
            txtMontoDepositar.setText("");
            txtMontoDepositar.requestFocus();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }
    private void limpiarCampos() {
        txtMontoDepositar.setText("");
        txtCuentaDestino.setText("");
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnConfirmar) {
        	
            confirmarOperacion();
        }

        if (e.getSource() == btnCancelar) {
            ventanaPrincipal.menu_usuario();
        }
    }
}
  

	
	
	
	
	
	
	
	
	
	
	
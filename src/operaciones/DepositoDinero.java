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
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.util.Locale;
import datos.AlmacenDatos;
import modelos.Cuenta;
import modelos.Usuario;
import servicio.MetodoOperacionTransferencias;

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

    private MetodoOperacionTransferencias os = new MetodoOperacionTransferencias();

    public DepositoDinero(VentanaPrincipal principal) {
        this.ventanaPrincipal = principal;

        setBackground(new Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1000, 620));
        setLayout(null);

        lblTitulo = new JLabel("DEPÓSITO DE DINERO");
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 28));
        lblTitulo.setBounds(199, 41, 600, 40);
        lblTitulo.setForeground(new Color(2, 64, 89));
        add(lblTitulo);

        separator = new JSeparator();
        separator.setBounds(199, 90, 600, 2);
        add(separator);

        lblIngreseMonto = new JLabel("Ingrese monto a depositar");
        lblIngreseMonto.setForeground(new Color(2, 64, 89));
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
        lblMiCuenta.setForeground(new Color(2, 64, 89));
        add(lblMiCuenta);

        cmbMiCuenta = new JComboBox<>();
        cmbMiCuenta.setBounds(538, 223, 261, 30);
        add(cmbMiCuenta);

        lblCuentaDestino = new JLabel("Número de cuenta DESTINO:");
        lblCuentaDestino.setForeground(new Color(2, 64, 89));
        lblCuentaDestino.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblCuentaDestino.setBounds(127, 279, 350, 30);
        add(lblCuentaDestino);

        txtCuentaDestino = new JTextField();
        txtCuentaDestino.setFont(new Font("Tahoma", Font.BOLD, 15));
        txtCuentaDestino.setBounds(538, 282, 261, 30);
        add(txtCuentaDestino);

        lblSaldoActual = new JLabel("Saldo actual:");
        lblSaldoActual.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblSaldoActual.setBounds(178, 337, 200, 40);
        lblSaldoActual.setForeground(new Color(2, 64, 89));
        add(lblSaldoActual);

        txtSaldoActual = new JTextField();
        txtSaldoActual.setEditable(false);
        txtSaldoActual.setEnabled(false);
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

        //  Al cambiar combobox se actualizar saldo
        cmbMiCuenta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarSaldoCuentaOrigen();
            }
        });

        cargarCuentasEnCombo();
        mostrarSaldoCuentaOrigen();
    }

    public void addNotify() {
        super.addNotify();
        cargarCuentasEnCombo();
        mostrarSaldoCuentaOrigen();
    }

    // Cargar cuentas del usuario logueado en el combo
    private void cargarCuentasEnCombo() {
        cmbMiCuenta.removeAllItems();

        Usuario user = ventanaPrincipal.getUsuarioActual();
        if (user == null) return;

        for (int i = 0; i < AlmacenDatos.listaCuentas.size(); i++) {
            Cuenta c = AlmacenDatos.listaCuentas.get(i);
            if (c.getUsuario() != null && c.getUsuario().getDNI().equals(user.getDNI())) {
                String item = c.getNumeroCuenta() + " - " + c.getMoneda().getNombre();
                cmbMiCuenta.addItem(item);
            }
        }
    }

    //  Mostrar saldo del origen
    private void mostrarSaldoCuentaOrigen() {
        if (cmbMiCuenta.getSelectedItem() == null) {
            txtSaldoActual.setText("0.00");
            return;
        }

        String texto = cmbMiCuenta.getSelectedItem().toString();
        String numCuenta = texto.split(" - ")[0];

        Cuenta cuentaOrigen = AlmacenDatos.cuentaPorNumero(numCuenta);

        if (cuentaOrigen != null) {
            txtSaldoActual.setText(String.format(Locale.US, "%.2f", cuentaOrigen.getSaldo()));
        } else {
            txtSaldoActual.setText("0.00");
        }
    }

    // Confirmar
    private void confirmarOperacion() {
        try {
            //  Monto
            double monto = Double.parseDouble(txtMontoDepositar.getText().trim());
            if (monto <= 0) {
                JOptionPane.showMessageDialog(this, "Ingrese un monto válido.");
                txtMontoDepositar.setText("");
                txtMontoDepositar.requestFocus();
                return;
            }
            //  Origen
            if (cmbMiCuenta.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(this, "Seleccione su cuenta de origen.");
                return;
            }

            String textoOrigen = cmbMiCuenta.getSelectedItem().toString();
            String numOrigen = textoOrigen.split(" - ")[0];

            // Destino (si está vacío se deposita en la misma cuenta)
            String numDestino = txtCuentaDestino.getText().trim();
            if (numDestino.isEmpty()) {
                //  depósito
                String msg = os.depositar(numOrigen, monto);
                mostrarSaldoCuentaOrigen();
                JOptionPane.showMessageDialog(this, msg);
                limpiarCampos();
                return;
            }

            // transferencia
            String msg = os.transferir(numOrigen, numDestino, monto);
            mostrarSaldoCuentaOrigen();
            JOptionPane.showMessageDialog(this, msg);
            limpiarCampos();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Ingrese un número válido.");
            txtMontoDepositar.setText("");
            txtMontoDepositar.requestFocus();
        } catch (Exception ex) {
            //  limpiar, campos y avisar
            JOptionPane.showMessageDialog(this, ex.getMessage());
            txtMontoDepositar.setText("");
            txtCuentaDestino.setText("");
            txtCuentaDestino.requestFocus();
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

        if (e.getSource() == btnCancelar || e.getSource() == btnVolver) {
            ventanaPrincipal.menu_usuario();
        }
    }
}
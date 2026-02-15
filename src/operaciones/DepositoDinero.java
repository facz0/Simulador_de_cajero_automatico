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
import javax.swing.JRadioButton;
import javax.swing.JComboBox;

//Esto permite acceder a la lista ListaCuentas y a los objetos Cuenta
// Esteban
import datos.AlmacenDatos;
import modelos.Cuenta;

public class DepositoDinero extends JPanel implements ActionListener {

    private static final long serialVersionUID = 1L;
    private VentanaPrincipal ventanaPrincipal;
    private JLabel lblTitulo;
    private JSeparator separator;
    private JLabel lblClaveActual;
    private JLabel lblConfirmar;
    private JButton btnConfirmar;
    private JButton btnCancelar;
    private JTextField txtMontoDepositar;
    private JLabel lblSaldoActal;
    private JButton btnVolver;
    private JTextField txtSaldoActual;
    private JComboBox<String> cmbNumeroCuenta;

    // ===== MÉTODO PARA LLENAR EL COMBO =====
    private void cargarCuentasEnCombo() {

        cmbNumeroCuenta.removeAllItems();

        for (Cuenta c : AlmacenDatos.listaCuentas) {
            cmbNumeroCuenta.addItem(c.getNumeroCuenta());
        }
    }

    // ===== CONSTRUCTOR =====
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

        lblClaveActual = new JLabel("Ingrese monto a depositar");
        lblClaveActual.setForeground(new Color(2, 64, 89));
        lblClaveActual.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblClaveActual.setBounds(346, 117, 383, 30);
        add(lblClaveActual);

        lblConfirmar = new JLabel("Número de cuenta:");
        lblConfirmar.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblConfirmar.setBounds(178, 244, 200, 30);
        lblConfirmar.setForeground(new Color(2, 64, 89));
        add(lblConfirmar);

        btnConfirmar = new JButton("CONFIRMAR");
        btnConfirmar.addActionListener(this);
        btnConfirmar.setForeground(Color.WHITE);
        btnConfirmar.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnConfirmar.setFocusPainted(false);
        btnConfirmar.setBackground(new Color(128, 191, 33));
        btnConfirmar.setBounds(199, 406, 210, 50);
        btnConfirmar.setContentAreaFilled(false);
        btnConfirmar.setOpaque(true);
        add(btnConfirmar);

        btnCancelar = new JButton("CANCELAR");
        btnCancelar.addActionListener(this);
        btnCancelar.setForeground(Color.WHITE);
        btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnCancelar.setFocusPainted(false);
        btnCancelar.setBackground(new Color(3, 120, 166));
        btnCancelar.setBounds(599, 406, 200, 50);
        btnCancelar.setContentAreaFilled(false);
        btnCancelar.setOpaque(true);
        add(btnCancelar);

        txtMontoDepositar = new JTextField();
        txtMontoDepositar.setFont(new Font("Tahoma", Font.BOLD, 15));
        txtMontoDepositar.setColumns(10);
        txtMontoDepositar.setBounds(346, 158, 270, 30);
        add(txtMontoDepositar);

        lblSaldoActal = new JLabel("Saldo actúal:");
        lblSaldoActal.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblSaldoActal.setBounds(178, 307, 200, 30);
        lblSaldoActal.setForeground(new Color(2, 64, 89));
        add(lblSaldoActal);

        btnVolver = new JButton("VOLVER");
        btnVolver.addActionListener(this);
        btnVolver.setForeground(Color.WHITE);
        btnVolver.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnVolver.setFocusPainted(false);
        btnVolver.setBackground(new Color(128, 191, 33));
        btnVolver.setBounds(400, 504, 200, 50);
        btnVolver.setContentAreaFilled(false);
        btnVolver.setOpaque(true);
        add(btnVolver);

        txtSaldoActual = new JTextField();
        txtSaldoActual.setFont(new Font("Tahoma", Font.BOLD, 14));
        txtSaldoActual.setEditable(false);
        txtSaldoActual.setBounds(538, 307, 261, 30);
        txtSaldoActual.setColumns(10);
        add(txtSaldoActual);

        cmbNumeroCuenta = new JComboBox<>();
        cmbNumeroCuenta.setBounds(538, 244, 261, 30);
        add(cmbNumeroCuenta);

        // ===== CARGAR CUENTAS =====
        cargarCuentasEnCombo();

        // ===== LISTENER DEL COMBO  =====
        cmbNumeroCuenta.addActionListener(e -> {

            String numeroCuenta = (String) cmbNumeroCuenta.getSelectedItem();

            for (Cuenta c : AlmacenDatos.listaCuentas) {
                if (c.getNumeroCuenta().equals(numeroCuenta)) {
                    txtSaldoActual.setText(String.valueOf(c.getSaldo()));
                    break;
                }
            }
        });

        if (cmbNumeroCuenta.getItemCount() > 0) {
            cmbNumeroCuenta.setSelectedIndex(0);
        }
    }

    // ===== EVENTOS BOTONES =====
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnConfirmar) {
            actionPerformedBtnConfirmar();
        }

        if (e.getSource() == btnCancelar || e.getSource() == btnVolver) {
            ventanaPrincipal.menu_usuario();
        }
    }

    // ===== LÓGICA DEPÓSITO =====
    protected void actionPerformedBtnConfirmar() {

        try {
            double monto = Double.parseDouble(txtMontoDepositar.getText());

            if (monto <= 0) {
                JOptionPane.showMessageDialog(this, "Ingrese un monto válido.");
                return;
            }

            String numeroCuenta = (String) cmbNumeroCuenta.getSelectedItem();

            for (Cuenta c : AlmacenDatos.listaCuentas) {
                if (c.getNumeroCuenta().equals(numeroCuenta)) {

                    c.setSaldo(c.getSaldo() + monto);

                    txtSaldoActual.setText(String.valueOf(c.getSaldo()));

                    JOptionPane.showMessageDialog(this, "Depósito realizado con éxito.");

                    txtMontoDepositar.setText("");

                    return;
                }
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Ingrese un número válido.");
        }
    }
}

  

	
	
	
	
	
	
	
	
	
	
	
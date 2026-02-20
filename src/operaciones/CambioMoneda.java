package operaciones;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import gui.VentanaPrincipal;
import datos.AlmacenDatos;
import modelos.Moneda;
import servicio.MetodosCambioMoneda;

public class CambioMoneda extends JPanel implements ActionListener {

    private static final long serialVersionUID = 1L;
    private VentanaPrincipal ventanaPrincipal;
    private JLabel lblTitulo;
    private JLabel lblCantidad;
    private JLabel lblDe;
    private JLabel lblA;
    private JLabel lblResultadoTexto;
    private JTextField txtCantidad;
    private JTextField txtResultado;
    private JComboBox<String> cbDe;
    private JComboBox<String> cbA;
    private JButton btnConvertir;
    private JButton btnCancelar;

    private MetodosCambioMoneda mcm = new MetodosCambioMoneda();

    public CambioMoneda(VentanaPrincipal principal) {
        setBackground(new Color(255, 255, 255));
        this.ventanaPrincipal = principal;

        setPreferredSize(new java.awt.Dimension(1000, 620));
        setLayout(null);

        lblTitulo = new JLabel("CAMBIO DE MONEDA");
        lblTitulo.setForeground(new Color(2, 64, 89));
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 28));
        lblTitulo.setBounds(340, 40, 400, 40);
        add(lblTitulo);

        lblCantidad = new JLabel("CANTIDAD A CONVERTIR:");
        lblCantidad.setForeground(new Color(2, 64, 89));
        lblCantidad.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblCantidad.setBounds(150, 140, 250, 30);
        add(lblCantidad);

        txtCantidad = new JTextField();
        txtCantidad.setBounds(520, 140, 250, 30);
        add(txtCantidad);

        lblDe = new JLabel("DE:");
        lblDe.setForeground(new Color(2, 64, 89));
        lblDe.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblDe.setBounds(150, 220, 100, 30);
        add(lblDe);

        cbDe = new JComboBox<>();
        cbDe.setBounds(620, 220, 150, 30);
        add(cbDe);

        lblA = new JLabel("A:");
        lblA.setForeground(new Color(2, 64, 89));
        lblA.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblA.setBounds(150, 290, 100, 30);
        add(lblA);

        cbA = new JComboBox<>();
        cbA.setBounds(620, 290, 150, 30);
        add(cbA);

        lblResultadoTexto = new JLabel("RESULTADO:");
        lblResultadoTexto.setForeground(new Color(2, 64, 89));
        lblResultadoTexto.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblResultadoTexto.setBounds(150, 380, 150, 30);
        add(lblResultadoTexto);

        txtResultado = new JTextField();
        txtResultado.setEditable(false);
        txtResultado.setBounds(520, 380, 250, 30);
        add(txtResultado);

        btnConvertir = new JButton("CONVERTIR");
        btnConvertir.setForeground(Color.WHITE);
        btnConvertir.setBackground(new Color(128, 191, 33));
        btnConvertir.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnConvertir.setBounds(220, 470, 220, 50);
        btnConvertir.setContentAreaFilled(false);
        btnConvertir.setOpaque(true);
        btnConvertir.addActionListener(this);
        add(btnConvertir);

        btnCancelar = new JButton("CANCELAR");
        btnCancelar.setForeground(Color.WHITE);
        btnCancelar.setBackground(new Color(3, 120, 166));
        btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnCancelar.setBounds(560, 470, 220, 50);
        btnCancelar.setContentAreaFilled(false);
        btnCancelar.setOpaque(true);
        btnCancelar.addActionListener(this);
        add(btnCancelar);
        // Carga monedas en combos
        cargarMonedasEnCombos();
    }

    // Carga las monedas desde almace de datos
    private void cargarMonedasEnCombos() {
        cbDe.removeAllItems();
        cbA.removeAllItems();

        for (int i = 0; i < AlmacenDatos.listaMonedas.size(); i++) {
            Moneda m = AlmacenDatos.listaMonedas.get(i);
            cbDe.addItem(m.getNombre());
            cbA.addItem(m.getNombre());
        }

        if (cbDe.getItemCount() > 0) cbDe.setSelectedIndex(0);
        if (cbA.getItemCount() > 0) cbA.setSelectedIndex(0);
    }

    public void addNotify() {
        super.addNotify();
        // Si el admin agrega monedas aquí se recarga automático!
        cargarMonedasEnCombos();
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnCancelar) {
            txtCantidad.setText("");
            txtResultado.setText("");
            ventanaPrincipal.menu_usuario();
            return;
        }

        if (e.getSource() == btnConvertir) {
            try {
                double monto = Double.parseDouble(txtCantidad.getText().trim());

                String nombreDe = (String) cbDe.getSelectedItem();
                String nombreA  = (String) cbA.getSelectedItem();

                if (nombreDe == null || nombreA == null) {
                    JOptionPane.showMessageDialog(this, "Seleccione monedas.");
                    txtResultado.setText("");
                    return;
                }

                Moneda de = AlmacenDatos.monedaPorNombre(nombreDe);
                Moneda a  = AlmacenDatos.monedaPorNombre(nombreA);

                if (de == null || a == null) {
                    JOptionPane.showMessageDialog(this, "No se encontró la moneda.");
                    txtResultado.setText("");
                    return;
                }

                double resultado = mcm.convertir(monto, de, a);

                txtResultado.setText(String.format("%.2f", resultado));

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Ingrese un número válido.");
                txtCantidad.setText("");
                txtResultado.setText("");
                txtCantidad.requestFocus();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
                txtResultado.setText("");
            }
        }
    }
}
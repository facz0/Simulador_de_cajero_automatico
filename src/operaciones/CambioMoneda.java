package operaciones;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import gui.VentanaPrincipal;
import datos.AlmacenDatos;
import modelos.Moneda;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.Color;
import gui.VentanaPrincipal;
import javax.swing.JSeparator;


public class CambioMoneda extends JPanel implements ActionListener{

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
    private JButton btnVolver;
    
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

        btnCancelar = new JButton("LIMPIAR");
        btnCancelar.setForeground(Color.WHITE);
        btnCancelar.setBackground(new Color(3, 120, 166));
        btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnCancelar.setBounds(560, 470, 220, 50);
        btnCancelar.setContentAreaFilled(false);
        btnCancelar.setOpaque(true);
        btnCancelar.addActionListener(this);
        add(btnCancelar);
        
        btnVolver = new JButton("< VOLVER");
        btnVolver.addActionListener(this);
        btnVolver.setForeground(Color.WHITE);
        btnVolver.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnVolver.setFocusPainted(false);
        btnVolver.setBackground(new Color(128, 191, 33));
        btnVolver.setBounds(30, 23, 150, 50);
        btnVolver.setContentAreaFilled(false);
        btnVolver.setOpaque(true);
        add(btnVolver);
        
        cargarMonedasEnCombos();
    }
    
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnCancelar) {
            txtCantidad.setText("");
            txtResultado.setText("");
            return;
        }
        
        if (e.getSource() == btnVolver) {
        	ventanaPrincipal.menu_usuario();
        }

        if (e.getSource() == btnConvertir) {

            try {
                double monto = Double.parseDouble(txtCantidad.getText().trim());

                if (monto <= 0) {
                    JOptionPane.showMessageDialog(this, "Ingrese una cantidad válida.");
                    return;
                }

                String nombreDe = (String) cbDe.getSelectedItem();
                String nombreA = (String) cbA.getSelectedItem();

                if (nombreDe == null || nombreA == null) {
                    JOptionPane.showMessageDialog(this, "Seleccione monedas.");
                    return;
                }

                Moneda de = AlmacenDatos.monedaPorNombre(nombreDe);
                Moneda a = AlmacenDatos.monedaPorNombre(nombreA);

                if (de == null || a == null) {
                    JOptionPane.showMessageDialog(this, "No se encontró la moneda.");
                    return;
                }

                double resultado = convertir(monto, de, a);
                txtResultado.setText(String.format("%.2f", resultado));

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Ingrese un número válido.");
            } catch (RuntimeException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        }
    }
    
    // METODO CAMBIO DE DINERO
    private void cargarMonedasEnCombos() {
        cbDe.removeAllItems();
        cbA.removeAllItems();

        for (int i = 0; i < AlmacenDatos.listaMonedas.size(); i++) {
            Moneda m = AlmacenDatos.listaMonedas.get(i);
            String item = m.getNombre(); 
            cbDe.addItem(item);
            cbA.addItem(item);
        }
        if (cbDe.getItemCount() > 0) cbDe.setSelectedIndex(0);
        if (cbA.getItemCount() > 0) cbA.setSelectedIndex(0);
    }
    
    public void addNotify() {
        super.addNotify();
        if (cbDe != null && cbA != null) {
            cargarMonedasEnCombos();
        }
    }
    
    private double obtenerValorMoneda(Moneda m) {
    	if (m == null) {
            throw new IllegalArgumentException("La moneda no puede ser null");
        }
        return m.getTipoCambio(); 
    }

    // METODO CONVERTIR - formula
    private double convertir(double monto, Moneda monedaOrigen, Moneda monedaDestino) {
    	if (monedaOrigen == null || monedaDestino == null) {
            throw new IllegalArgumentException("Las monedas no pueden ser null");
        }
    	
    	if (monedaDestino.getTipoCambio() == 0) {
            throw new ArithmeticException("El tipo de cambio destino no puede ser 0");
        }
    	
    	return monto * (monedaOrigen.getTipoCambio() / monedaDestino.getTipoCambio());
    }
	
}

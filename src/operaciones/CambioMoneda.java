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
import javax.swing.ImageIcon;


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
    private JSeparator separator;
    
    public CambioMoneda(VentanaPrincipal principal) {
    	setBackground(new Color(2, 64, 89));
        this.ventanaPrincipal = principal;
        setPreferredSize(new java.awt.Dimension(1000, 620));
        setLayout(null);
        
        ImageIcon titulo = new ImageIcon(getClass().getResource("/iconos/tituloMoneda.png"));
        ImageIcon salir = new ImageIcon(getClass().getResource("/iconos/salirReporte.png"));
        ImageIcon cantidad = new ImageIcon(getClass().getResource("/iconos/billete2Reporte.png"));
        ImageIcon moneda = new ImageIcon(getClass().getResource("/iconos/moneda.png"));
        ImageIcon monedas = new ImageIcon(getClass().getResource("/iconos/monedas.png"));
        ImageIcon convertir = new ImageIcon(getClass().getResource("/iconos/generarReporte.png"));

        lblTitulo = new JLabel("CAMBIO DE MONEDA");
        lblTitulo.setForeground(new Color(255, 255, 255));
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 28));
        lblTitulo.setBounds(210, 85, 600, 40);
		lblTitulo.setIcon(titulo);
        add(lblTitulo);
        
        separator = new JSeparator();
		separator.setBounds(210, 144, 600, 2);
		add(separator);

        lblCantidad = new JLabel("CANTIDAD A CONVERTIR:");
        lblCantidad.setForeground(new Color(255, 255, 255));
        lblCantidad.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblCantidad.setBounds(210, 185, 293, 30);
		lblCantidad.setIcon(cantidad);
        add(lblCantidad);

        txtCantidad = new JTextField();
        txtCantidad.setBounds(520, 188, 250, 30);
        add(txtCantidad);

        lblDe = new JLabel("DE:");
        lblDe.setForeground(new Color(2, 64, 89));
        lblDe.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblDe.setBounds(210, 250, 200, 30);
		lblDe.setForeground(new Color(255, 255, 255));
		lblDe.setIcon(moneda);
        add(lblDe);

        cbDe = new JComboBox<>();
        cbDe.setBounds(520, 253, 250, 30);
        add(cbDe);

        lblA = new JLabel("A:");
        lblA.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblA.setBounds(210, 302, 200, 30);
		lblA.setForeground(new Color(255, 255, 255));
		lblA.setIcon(monedas);
        add(lblA);

        cbA = new JComboBox<>();
        cbA.setBounds(520, 316, 250, 30);
        add(cbA);
        
        btnVolver = new JButton("SALIR"); 
        btnVolver.addActionListener(this);
        btnVolver.setForeground(Color.WHITE);
        btnVolver.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnVolver.setBackground(new Color(128, 191, 33));
        btnVolver.setBounds(30, 23, 150, 50); // Posición arriba
        btnVolver.setContentAreaFilled(false);
        btnVolver.setOpaque(true);
        btnVolver.setIcon(salir);
        add(btnVolver);
        
        lblResultadoTexto = new JLabel("RESULTADO:");
        lblResultadoTexto.setForeground(new Color(255, 255, 255));
        lblResultadoTexto.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblResultadoTexto.setBounds(210, 377, 150, 30);
        add(lblResultadoTexto);

        txtResultado = new JTextField();
        txtResultado.setEditable(false);
        txtResultado.setBounds(520, 380, 250, 30);
        add(txtResultado);

        btnConvertir = new JButton("CONVERTIR");
        btnConvertir.setForeground(Color.WHITE);
        btnConvertir.setBackground(new Color(128, 191, 33));
        btnConvertir.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnConvertir.setBounds(600, 505, 210, 50);
        btnConvertir.setContentAreaFilled(false);
        btnConvertir.setOpaque(true);
        btnConvertir.addActionListener(this);
        btnConvertir.setIcon(convertir);
        add(btnConvertir);
        
        btnCancelar = new JButton("LIMPIAR");
        btnCancelar.addActionListener(this);
        btnCancelar.setForeground(Color.WHITE);
        btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnCancelar.setBackground(new Color(96, 125, 139)); // Color grisáceo
        btnCancelar.setBounds(210, 505, 210, 50); // Posición abajo
        btnCancelar.setContentAreaFilled(false);
        btnCancelar.setOpaque(true);
        add(btnCancelar);
        
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

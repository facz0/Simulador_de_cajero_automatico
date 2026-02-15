package reportes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import CLASES_REPORTE_ADMIN.Metodo_reporte_admin;
import modelos.Cuenta;
import modelos.Usuario;



import java.awt.Image;
import javax.swing.ImageIcon;
//github.com/facz0/Simulador_de_cajero_automatico.git

public class Saldo_cliente extends JPanel implements ActionListener {

    private static final long serialVersionUID = 1L;

    private JTextField txtCliente;
    private JTextArea txtResultado;
    private JButton btnGenerar, btnLimpiar;

    public Saldo_cliente() {
    	
    	setBackground(new Color(2, 64, 89));  //color del fondo azul
        setLayout(null);
        
        ImageIcon usuarioReporte = new ImageIcon(getClass().getResource("/iconos/usuarioReporte.png"));
        ImageIcon generarReporte = new ImageIcon(getClass().getResource("/iconos/generarReporte.png"));
        ImageIcon limpiarReporte = new ImageIcon(getClass().getResource("/iconos/limpiarReporte.png"));

        JLabel lblTitulo = new JLabel("Saldo de cliente");
        lblTitulo.setForeground(new Color(255, 255, 255));
        lblTitulo.setBounds(30, 20, 300, 30);
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 16));
        add(lblTitulo);

        JSeparator sep = new JSeparator();
        sep.setBounds(30, 55, 860, 2);
        add(sep);

        JLabel lblCliente = new JLabel("Nombre del cliente:");
        lblCliente.setForeground(new Color(255, 255, 255));
        lblCliente.setBounds(30, 90, 136, 25);
        lblCliente.setBackground(new Color(255, 255, 255));
        lblCliente.setIcon(usuarioReporte);//icono
        add(lblCliente);

        txtCliente = new JTextField();
        txtCliente.setBounds(200, 90, 250, 28);
        add(txtCliente);

        btnGenerar = new JButton("Generar");
        btnGenerar.setForeground(new Color(255, 255, 255));
        btnGenerar.setBackground(new Color(128, 191, 33)); // color deseado
        btnGenerar.setContentAreaFilled(false); //fondo de color
        btnGenerar.setOpaque(true);//fondo de color
        btnGenerar.setBounds(570, 87, 120, 30);
        btnGenerar.addActionListener(this);
        btnGenerar.setIcon(generarReporte);//icono
        add(btnGenerar);

        btnLimpiar = new JButton("Limpiar");
        btnLimpiar.setForeground(new Color(255, 255, 255));
        btnLimpiar.setBackground(new Color(128, 191, 33)); // color deseado
        btnLimpiar.setContentAreaFilled(false); //fondo de color
        btnLimpiar.setOpaque(true);//fondo de color
        btnLimpiar.setBounds(730, 87, 120, 30);
        btnLimpiar.addActionListener(this);
        btnLimpiar.setIcon(limpiarReporte);//icono
        add(btnLimpiar);

        JScrollPane scroll = new JScrollPane();
        scroll.setBounds(30, 191, 860, 251);
        add(scroll);
                
        txtResultado = new JTextArea();
        scroll.setViewportView(txtResultado);
        txtResultado.setEditable(false);
     // LA FUENTE MONOSPACED ES LO QUE HACE QUE LA TABLA NO SE DESORDENE
        txtResultado.setFont(new Font("Monospaced", Font.BOLD, 12));
        txtResultado.setBackground(new Color(250, 250, 250));
        scroll.setViewportView(txtResultado);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    	if (e.getSource() == btnGenerar) {

    		 
    		        String nombre = txtCliente.getText().trim();

    		        // Validación
    		        if (nombre.isEmpty()) {
    		            JOptionPane.showMessageDialog(
    		                this,
    		                "Ingrese el nombre del cliente",
    		                "Error",
    		                JOptionPane.ERROR_MESSAGE
    		            );
    		            return;
    		        }

    		        // Buscar usuario
    		        Usuario usuario = Metodo_reporte_admin.clientePorNombre(nombre);

    		        if (usuario == null) {
    		            JOptionPane.showMessageDialog(
    		                this,
    		                "No existe un cliente con ese nombre",
    		                "Error",
    		                JOptionPane.ERROR_MESSAGE
    		            );
    		            return;
    		        }

    		        // 🔥 Obtener TODAS las cuentas del usuario
    		        Cuenta[] cuentas = Metodo_reporte_admin.cuentasPorNombre(nombre);

    		        // Encabezado por cliente
    		        this.txtResultado.append("__________________________________________________________________________________________________________________________\n");
    		        this.txtResultado.append(" DNI: " + usuario.getDNI() + "\t" + "Nombre: " + usuario.getNombre() + "\t");

    		        // Mostrar todas sus cuentas
    		        for (Cuenta c : cuentas) {
    		            txtResultado.append(
    		                "Nro Cuenta: " + c.getNumeroCuenta() + "\t" +
    		                "Moneda: " + c.getMoneda() + "\t" +
    		                "Saldo: " + c.getSaldo() + "\t" +
    		                "Estado: " + c.getEstado() + "\n__________________________________________________________________________________________________________________________\n"
    		               
    		            );
    		           
    		        }
    		        

    		        // Limpiar solo el campo de texto
    		        txtCliente.setText("");

    		        // Scroll automático al final
    		        txtResultado.setCaretPosition(
    		            txtResultado.getDocument().getLength()
    		        );
    		    }

    		    if (e.getSource() == btnLimpiar) {
    		        txtCliente.setText("");
    		        txtResultado.setText("");
    		    }
    		}
    }
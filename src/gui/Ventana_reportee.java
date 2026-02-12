package gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Ventana_reportee extends JPanel implements ItemListener, ActionListener {

    private static final long serialVersionUID = 1L;
    private VentanaPrincipal ventanaPrincipal;

    private JComboBox<String> cboReportes;
    private JPanel pnlContenedor;

    // Subpaneles
    private Saldo_cliente pnlSaldoCliente;
    private Saldo_rango_montos pnlRangoMontos;
    private saldo_rango_fecha pnlRangoFechas;
    private JButton btnSalir;

    public Ventana_reportee(VentanaPrincipal principal) {
    	
        setLayout(null);
        setBorder(new EmptyBorder(10, 10, 10, 10));
        this.ventanaPrincipal = principal;
        setPreferredSize(new Dimension(1000, 620));
        //setBackground(new Color(2, 64, 89));//color montos
        setBackground(new Color(4, 40, 56));  //color reporte principal

        //imagenes
        ImageIcon volver = new ImageIcon(getClass().getResource("/iconos/Volver.png"));
        ImageIcon reporte =new ImageIcon(getClass().getResource("/iconos/reporte.png"));//iamgnereporte
        //Image imgEscalada = volver.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        
 
        
        JLabel lblTipo = new JLabel("TIPO DE REPORTE");
        lblTipo.setForeground(new Color(255, 255, 255));
        lblTipo.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lblTipo.setBounds(198, 65, 206, 25);
        
        lblTipo.setIcon(reporte);
        add(lblTipo);

        cboReportes = new JComboBox<>();
        cboReportes.setBounds(414, 60, 320, 30);
        cboReportes.addItem("Saldo de cliente");
        cboReportes.addItem("Clientes con saldo entre rango de montos");
        cboReportes.addItem("Transacciones por rango de fecha");
        cboReportes.addItemListener(this);
        add(cboReportes);

        // ===== CONTENEDOR =====
        pnlContenedor = new JPanel(null);
        pnlContenedor.setBounds(30, 120, 925, 474);
        pnlContenedor.setBackground(new Color(230, 235, 240));
        pnlContenedor.setBorder(BorderFactory.createLineBorder(new Color(180, 180, 180)));
        add(pnlContenedor);
        
        btnSalir = new JButton(" VOLVER"); //esel boton salir, me dio frojera poner el icono :)
        btnSalir.setForeground(new Color(255, 255, 255)); //blanquito
        btnSalir.setBackground(new Color(220, 53, 69)); // color deseado ROJO
        btnSalir.setContentAreaFilled(false); //fondo de color
        btnSalir.setOpaque(true);//fondo de color
        btnSalir.addActionListener(this);
        btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnSalir.setBounds(10, 26, 127, 35);//tomaño
        
        btnSalir.setIcon(volver);//icono
        add(btnSalir);

        // Crear subpaneles
        pnlSaldoCliente = new Saldo_cliente();
        pnlRangoMontos = new Saldo_rango_montos();
        pnlRangoFechas = new saldo_rango_fecha();

        // Mostrar el primero
        mostrarPanel(pnlSaldoCliente);
    }

    // ===== CAMBIO DE PANELES =====
    private void mostrarPanel(JPanel panel) {
        pnlContenedor.removeAll();
        panel.setBounds(0, 0, 925, 474);
        pnlContenedor.add(panel);
        pnlContenedor.revalidate();
        pnlContenedor.repaint();
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
        	switch (cboReportes.getSelectedIndex()) {
            case 0:
                mostrarPanel(pnlSaldoCliente);
                break;
            case 1:
                mostrarPanel(pnlRangoMontos);
                break;
            case 2:
                mostrarPanel(pnlRangoFechas);
                break;
        	}
        }
    }
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSalir) {
			actionPerformedBtnNewButton(e);
		}
	}
	
	//boton salir :v
	protected void actionPerformedBtnNewButton(ActionEvent e) {
		if(e.getSource()==btnSalir) {
			ventanaPrincipal.Panel_inicio();
		}
	}
}
package reportes;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import gui.VentanaPrincipal;

import java.awt.*;
import java.awt.event.*;

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
        setBackground(new Color(21, 58, 76));
        
        ImageIcon volver = new ImageIcon(getClass().getResource("/iconos/Volver.png"));
        ImageIcon reporte =new ImageIcon(getClass().getResource("/iconos/reporte.png"));//iamgnereporte

        JLabel lblTitulo = new JLabel("TIPO DE REPORTES");
        lblTitulo.setForeground(new Color(255, 255, 255));
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lblTitulo.setBounds(226, 60, 253, 30);
        lblTitulo.setIcon(reporte);
        add(lblTitulo);

        cboReportes = new JComboBox<>();
        cboReportes.setBounds(456, 60, 320, 30);
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
        
        btnSalir = new JButton(" VOLVER");
        btnSalir.setForeground(new Color(255, 255, 255)); //blanquito
        btnSalir.setBackground(new Color(192, 57, 43)); // color deseado
        btnSalir.setContentAreaFilled(false); //fondo de color
        btnSalir.setOpaque(true);//fondo de color
        btnSalir.addActionListener(this);
        btnSalir.setBounds(30, 29, 109, 30);
        btnSalir.setIcon(volver);
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
	
	
	
	//boton salir
	protected void actionPerformedBtnNewButton(ActionEvent e) {
		if(e.getSource()==btnSalir) {
		    limpiarTodo();
            // Regresar al panel inicio
            ventanaPrincipal.Panel_inicio();
			
		}
	}
	public void limpiarTodo() {
	    pnlSaldoCliente.limpiar();
	    pnlRangoMontos.limpiar();
	    pnlRangoFechas.limpiar();
	    cboReportes.setSelectedIndex(0);
	}
}
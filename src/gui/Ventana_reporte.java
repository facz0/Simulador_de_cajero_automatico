package gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;

public class Ventana_reporte extends JPanel implements ItemListener, ActionListener {

    private static final long serialVersionUID = 1L;
    private VentanaPrincipal ventanaPrincipal;

    private JComboBox<String> cboReportes;
    private JPanel pnlContenedor;

    // Subpaneles
    private Saldo_cliente pnlSaldoCliente;
    private Saldo_rango_montos pnlRangoMontos;
    private saldo_rango_fecha pnlRangoFechas;
    private JButton btnSalir;

    public Ventana_reporte(VentanaPrincipal principal) {

        setLayout(null);
        setBorder(new EmptyBorder(10, 10, 10, 10));
        this.ventanaPrincipal = principal;
        setPreferredSize(new Dimension(1000, 620));
        setBackground(new Color(245, 247, 250));

        JLabel lblTitulo = new JLabel("REPORTES");
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lblTitulo.setBounds(430, 10, 200, 30);
        add(lblTitulo);

        JLabel lblTipo = new JLabel("Tipo de reporte:");
        lblTipo.setBounds(30, 60, 150, 25);
        add(lblTipo);

        cboReportes = new JComboBox<>();
        cboReportes.setBounds(220, 60, 320, 30);
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
        
        btnSalir = new JButton("<---"); //esel boton salir, me dio frojera poner el icono :)
        btnSalir.setForeground(new Color(255, 255, 255)); //blanquito
        btnSalir.setBackground(new Color(220, 53, 69)); // color deseado
        btnSalir.setContentAreaFilled(false); //fondo de color
        btnSalir.setOpaque(true);//fondo de color
        btnSalir.addActionListener(this);
        btnSalir.setBounds(30, 19, 89, 23);
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
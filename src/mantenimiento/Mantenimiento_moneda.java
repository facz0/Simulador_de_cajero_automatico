package mantenimiento;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;

import gui.VentanaPrincipal;

public class Mantenimiento_moneda extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	private VentanaPrincipal ventanaPrincipal;
	private JButton btnListar;
	private JButton btnCrear;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnVolver;
	private JPanel panelPrincipal;
	private ListarMoneda listarMoneda;
	private CrearMoneda crearMoneda;
	private ModificarMoneda modificarMoneda;
	private EliminarMoneda eliminarMoneda;

	/**
	 * Create the panel.
	 */
	public Mantenimiento_moneda(VentanaPrincipal principal) {
		setBackground(new Color(2, 64, 89));
		setLayout(null);
		this.ventanaPrincipal = principal;		
		setPreferredSize(new java.awt.Dimension(1000, 620));
		
		//ICONOS
        ImageIcon monedas = new ImageIcon(getClass().getResource("/iconos/monedas.png"));
        ImageIcon listar = new ImageIcon(getClass().getResource("/iconos/listarReporte2.png"));
        ImageIcon crear = new ImageIcon(getClass().getResource("/iconos/crearReporte.png"));
        ImageIcon modificar = new ImageIcon(getClass().getResource("/iconos/modificarReportar.png"));
        ImageIcon eliminar = new ImageIcon(getClass().getResource("/iconos/limpiarReporte.png"));
        ImageIcon volver = new ImageIcon(getClass().getResource("/iconos/volver.png"));
		
		JSeparator separator = new JSeparator();
		separator.setBounds(98, 83, 792, 20);
		add(separator);
		
		JLabel lblNewLabel = new JLabel("Moneda");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(98, 38, 393, 34);
		lblNewLabel.setIcon(monedas);
		add(lblNewLabel);
		
		btnListar = new JButton("Listar");
		btnListar.setBounds(98, 114, 150, 42);
		btnListar.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnListar.setForeground(new Color(255, 255, 255));
		btnListar.addActionListener(this);
		btnListar.setBackground(new Color(128, 191, 33));
		add(btnListar);
		btnListar.setContentAreaFilled(false); 
		btnListar.setIcon(listar);
		btnListar.setOpaque(true); 
		
		btnCrear = new JButton("Crear");
		btnCrear.setBounds(98, 209, 150, 42);
		btnCrear.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnCrear.setForeground(new Color(255, 255, 255));
		btnCrear.addActionListener(this);
		btnCrear.setBackground(new Color(128, 191, 33));
		add(btnCrear);
		btnCrear.setContentAreaFilled(false); 
		btnCrear.setIcon(crear);
		btnCrear.setOpaque(true); 
		
		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(98, 305, 150, 42);
		btnModificar.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnModificar.setForeground(new Color(255, 255, 255));
		btnModificar.addActionListener(this);
		btnModificar.setBackground(new Color(128, 191, 33));
		add(btnModificar);
		btnModificar.setContentAreaFilled(false); 
		btnModificar.setIcon(modificar);
		btnModificar.setOpaque(true); 
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(98, 401, 150, 42);
		btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnEliminar.setForeground(new Color(255, 255, 255));
		btnEliminar.addActionListener(this);
		btnEliminar.setBackground(new Color(128, 191, 33));
		add(btnEliminar);
		btnEliminar.setContentAreaFilled(false); 
		btnEliminar.setIcon(eliminar);
		btnEliminar.setOpaque(true);
		
		btnVolver = new JButton("VOLVER");
		btnVolver.setForeground(new Color(255, 255, 255));
		btnVolver.setBackground(new Color(192, 57, 43));
		btnVolver.addActionListener(this);
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnVolver.setBounds(767, 40, 123, 35);
		add(btnVolver);
		btnVolver.setContentAreaFilled(false); 
		btnVolver.setIcon(volver);
		btnVolver.setOpaque(true);
		
		panelPrincipal = new JPanel();
		panelPrincipal.setBounds(278, 114, 612, 455);
		add(panelPrincipal);
		
		listarMoneda = new ListarMoneda();
		crearMoneda = new CrearMoneda();
		modificarMoneda = new ModificarMoneda();
		eliminarMoneda = new EliminarMoneda();
		
		mostrarPanel(listarMoneda);
	}
	
	private void mostrarPanel(JPanel panel) {
        panelPrincipal.removeAll();
        panel.setBounds(0, 0, 612, 455);
        panelPrincipal.add(panel);
        panelPrincipal.revalidate();
        panelPrincipal.repaint();
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == btnVolver) {
			ventanaPrincipal.Menu_mantenimiento();
		}
		if(e.getSource() == btnListar) {
			actionPerformedbtnListar(e);
		}
		if(e.getSource() == btnCrear) {
			actionPerformedbtnCrear(e);
		}
		if(e.getSource() == btnModificar) {
			modificarMoneda.actualizar();
			mostrarPanel(modificarMoneda);
		}
		if(e.getSource() == btnEliminar) {
			eliminarMoneda.actualizar();
			mostrarPanel(eliminarMoneda);
		}
	}
	
	private void actionPerformedbtnListar(ActionEvent e) {
		listarMoneda.cargarDatos();
		mostrarPanel(listarMoneda);
	}
	
	private void actionPerformedbtnCrear(ActionEvent e) {
		mostrarPanel(crearMoneda);
		crearMoneda.limpiarCampos();
	}
}

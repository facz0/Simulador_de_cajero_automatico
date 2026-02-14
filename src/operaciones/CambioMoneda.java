package operaciones;

import javax.swing.JPanel;
import javax.swing.JLabel;
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
import javax.swing.DefaultComboBoxModel;

public class CambioMoneda extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	private VentanaPrincipal ventanaPrincipal;
	private JLabel lblTitulo;
	private JSeparator separator;
	private JLabel lblClaveActual;
	private JLabel lblClaveNueva;
	private JLabel lblConfirmar;
	private JButton btnCambiar;
	private JButton btnCancelar;
	private JLabel lblNota;
	private JTextField textField;
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	private JLabel lblResultado;
	private JLabel lblEur;

	/**
	 * Create the panel.
	 */
	public CambioMoneda(VentanaPrincipal principal) {
		setBackground(new Color(255, 255, 255));
		this.ventanaPrincipal = principal;
		setPreferredSize(new java.awt.Dimension(1000, 620));
		setLayout(null);
		
		lblTitulo = new JLabel("CAMBIO DE MONEDA");
		lblTitulo.setForeground(new Color(2, 64, 89));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblTitulo.setBounds(210, 11, 600, 40);
		add(lblTitulo);
		
		separator = new JSeparator();
		separator.setBounds(210, 61, 600, 2);
		add(separator);
		
		lblClaveActual = new JLabel("CANTIDAD A CONVERTIR:");
		lblClaveActual.setForeground(new Color(2, 64, 89));
		lblClaveActual.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblClaveActual.setBounds(210, 106, 269, 30);
		add(lblClaveActual);
		
		lblClaveNueva = new JLabel("DE:");
		lblClaveNueva.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblClaveNueva.setBounds(210, 177, 200, 30);
		lblClaveNueva.setForeground(new Color(2, 64, 89));
		add(lblClaveNueva);
		
		lblConfirmar = new JLabel("A:");
		lblConfirmar.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblConfirmar.setBounds(210, 247, 200, 30);
		lblConfirmar.setForeground(new Color(2, 64, 89));
		add(lblConfirmar);
		
		btnCambiar = new JButton("CONVERTIR");
		btnCambiar.setForeground(Color.WHITE);
		btnCambiar.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnCambiar.setFocusPainted(false);
		btnCambiar.setBackground(new Color(128, 191, 33));
		btnCambiar.setBounds(210, 444, 210, 50);
		add(btnCambiar);
		btnCambiar.setContentAreaFilled(false); 
		btnCambiar.setOpaque(true);
		
		btnCancelar = new JButton("CANCELAR");
		btnCancelar.addActionListener(this);
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnCancelar.setFocusPainted(false);
		btnCancelar.setBackground(new Color(3, 120, 166));
		btnCancelar.setBounds(610, 444, 200, 50);
		add(btnCancelar);
		btnCancelar.setContentAreaFilled(false); 
		btnCancelar.setOpaque(true);
		
		lblNota = new JLabel("Tipo de cambio:             Dólar  3.30      Euro 3.99      Soles 1.00");
		lblNota.setHorizontalAlignment(SwingConstants.CENTER);
		lblNota.setForeground(new Color(128, 128, 128));
		lblNota.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblNota.setBounds(231, 312, 492, 20);
		add(lblNota);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 16));
		textField.setColumns(10);
		textField.setBounds(560, 108, 250, 30);
		add(textField);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"    SOLES - PEN", "    DÓLARES - USD", "    EUROS - EUR"}));
		comboBox.setBounds(684, 181, 126, 30);
		add(comboBox);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"    SOLES - PEN", "    DÓLARES - USD", "    EUROS - EUR"}));
		comboBox_1.setBounds(684, 251, 126, 30);
		add(comboBox_1);
		
		lblResultado = new JLabel("RESULTADO:");
		lblResultado.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblResultado.setForeground(new Color(2, 64, 89));
		lblResultado.setBounds(260, 366, 200, 30);
		add(lblResultado);
		
		lblEur = new JLabel(" 37.59 EUR");
		lblEur.setHorizontalAlignment(SwingConstants.CENTER);
		lblEur.setForeground(Color.GRAY);
		lblEur.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblEur.setBounds(510, 366, 250, 20);
		add(lblEur);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == btnCancelar) {
			ventanaPrincipal.menu_usuario();
		}
	}
}

package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JRadioButton;

public class DepositoDinero extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	private VentanaPrincipal ventanaPrincipal;
	private JLabel lblTitulo;
	private JSeparator separator;
	private JLabel lblClaveActual;
	private JLabel lblConfirmar;
	private JButton btnCambiar;
	private JButton btnCancelar;
	private JLabel lblNota;
	private JTextField textField;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnDlarUsd;
	private JRadioButton rdbtnEuroEur;
	private JTextField textField_1;
	private JLabel lblSaldoActal;
	private JButton btnVolver;

	/**
	 * Create the panel.
	 */
	public DepositoDinero(VentanaPrincipal principal) {
		setBackground(new Color(255, 255, 255));
		this.ventanaPrincipal = principal;
		setPreferredSize(new java.awt.Dimension(1000, 620));
		setLayout(null);
		
		lblTitulo = new JLabel("DEPÓSITO DE DINERO");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblTitulo.setBounds(199, 41, 600, 40);
		add(lblTitulo);
		lblTitulo.setForeground(new Color(2, 64, 89));
		
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
		lblConfirmar.setBounds(199, 276, 200, 30);
		add(lblConfirmar);
		lblConfirmar.setForeground(new Color(2, 64, 89));
		
		btnCambiar = new JButton("CONFIRMAR");
		btnCambiar.setForeground(Color.WHITE);
		btnCambiar.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnCambiar.setFocusPainted(false);
		btnCambiar.setBackground(new Color(128, 191, 33));
		btnCambiar.setBounds(199, 406, 210, 50);
		btnCambiar.setContentAreaFilled(false); 
		btnCambiar.setOpaque(true);
		add(btnCambiar);
		
		btnCancelar = new JButton("CANCELAR");
		btnCancelar.addActionListener(this);
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnCancelar.setFocusPainted(false);
		btnCancelar.setBackground(new Color(3, 120, 166));
		btnCancelar.setBounds(599, 406, 200, 50);
		add(btnCancelar);
		btnCancelar.setContentAreaFilled(false); 
		btnCancelar.setOpaque(true);
		
		
		
		lblNota = new JLabel("S/. 1200.00");
		lblNota.setHorizontalAlignment(SwingConstants.CENTER);
		lblNota.setForeground(Color.GRAY);
		lblNota.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblNota.setBounds(538, 317, 270, 30);
		add(lblNota);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 15));
		textField.setColumns(10);
		textField.setBounds(342, 158, 270, 30);
		add(textField);
		
		rdbtnNewRadioButton = new JRadioButton("SOLES - PEN");
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		rdbtnNewRadioButton.setBounds(272, 223, 127, 23);
		rdbtnNewRadioButton.setForeground(new Color(2, 64, 89));
		add(rdbtnNewRadioButton);
		
		
		rdbtnDlarUsd = new JRadioButton("DÓLAR - USD");
		rdbtnDlarUsd.setFont(new Font("Tahoma", Font.BOLD, 14));
		rdbtnDlarUsd.setBounds(445, 223, 117, 23);
		add(rdbtnDlarUsd);
		rdbtnDlarUsd.setForeground(new Color(2, 64, 89));
		
		
		rdbtnEuroEur = new JRadioButton("EURO - EUR");
		rdbtnEuroEur.setFont(new Font("Tahoma", Font.BOLD, 14));
		rdbtnEuroEur.setBounds(607, 223, 122, 23);
		add(rdbtnEuroEur);
		rdbtnEuroEur.setForeground(new Color(2, 64, 89));
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		textField_1.setColumns(10);
		textField_1.setBounds(538, 276, 270, 30);
		add(textField_1);
		
		lblSaldoActal = new JLabel("Saldo actúal:");
		lblSaldoActal.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblSaldoActal.setBounds(199, 316, 200, 30);
		lblSaldoActal.setForeground(new Color(2, 64, 89));
		add(lblSaldoActal);
		
		btnVolver = new JButton("VOLVER");
		btnVolver.addActionListener(this);
		btnVolver.setForeground(Color.WHITE);
		btnVolver.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnVolver.setFocusPainted(false);
		btnVolver.setBackground(new Color(128, 191, 33));
		btnVolver.setBounds(400, 486, 200, 50);
		add(btnVolver);
		btnVolver.setContentAreaFilled(false); 
		btnVolver.setOpaque(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == btnVolver) {
			ventanaPrincipal.menu_usuario();
		}
		if(e.getSource() == btnCancelar) {
			ventanaPrincipal.menu_usuario();
		}
	}
}

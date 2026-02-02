package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;

public class Cambio_clave extends JPanel implements ActionListener{

	 private static final long serialVersionUID = 1L;
	 private VentanaPrincipal ventanaPrincipal;
	 private JPasswordField txtClaveActual;
	 private JPasswordField txtClaveNueva;
	 private JPasswordField txtConfirmarClave;
	 private JButton btnVolver;
	 private JButton btnCancelar;

	/**
	 * Create the panel.
	 */
	public Cambio_clave(VentanaPrincipal principal) {
		
		setBackground(new Color(255, 255, 255));
        setBorder(new EmptyBorder(10, 10, 10, 10));
        setPreferredSize(new java.awt.Dimension(1000, 620));
        this.ventanaPrincipal = principal;
        setLayout(null); 
        
        JLabel lblTitulo = new JLabel("CAMBIO DE CLAVE");
        lblTitulo.setForeground(new Color(2, 64, 89));
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 28));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setBounds(200, 30, 600, 40);
        add(lblTitulo);
        
        JSeparator separator = new JSeparator();
        separator.setBounds(200, 80, 600, 2);
        add(separator);
        
        JLabel lblClaveActual = new JLabel("Clave Actual:");
        lblClaveActual.setForeground(new Color(2, 64, 89));
        lblClaveActual.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblClaveActual.setBounds(250, 130, 200, 30);
        add(lblClaveActual);

        txtClaveActual = new JPasswordField();
        txtClaveActual.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txtClaveActual.setBounds(480, 130, 250, 35);
        add(txtClaveActual);

        JLabel lblClaveNueva = new JLabel("Nueva Clave:");
        lblClaveNueva.setForeground(new Color(2, 64, 89));
        lblClaveNueva.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblClaveNueva.setBounds(250, 200, 200, 30);
        add(lblClaveNueva);

        txtClaveNueva = new JPasswordField();
        txtClaveNueva.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txtClaveNueva.setBounds(480, 200, 250, 35);
        add(txtClaveNueva);

        JLabel lblConfirmar = new JLabel("Confirmar Clave:");
        lblConfirmar.setForeground(new Color(2, 64, 89));
        lblConfirmar.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblConfirmar.setBounds(250, 270, 200, 30);
        add(lblConfirmar);

        txtConfirmarClave = new JPasswordField();
        txtConfirmarClave.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txtConfirmarClave.setBounds(480, 270, 250, 35);
        add(txtConfirmarClave);

        Color verdeBoton = new Color(128, 191, 33);
        
     // BOTÓN VOLVER
        btnVolver = new JButton("< Volver");
		btnVolver.setForeground(new Color(255, 255, 255));
		btnVolver.setBackground(new Color(128, 191, 33));
		btnVolver.addActionListener(this);
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnVolver.setBounds(10, 11, 97, 35);
		add(btnVolver);
		btnVolver.setContentAreaFilled(false); 
		btnVolver.setOpaque(true);

        // BOTÓN CAMBIAR CLAVE
        JButton btnCambiar = new JButton("CAMBIAR CLAVE");
        btnCambiar.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnCambiar.setBackground(verdeBoton); 
        btnCambiar.setForeground(Color.WHITE); 
        btnCambiar.setBounds(290, 420, 210, 50);
        btnCambiar.setFocusPainted(false);
        btnCambiar.setBorderPainted(false);    
        btnCambiar.setOpaque(true);            
        btnCambiar.setContentAreaFilled(true);
        add(btnCambiar);
        
        // BOTÓN CANCELAR
        btnCancelar = new JButton("CANCELAR");
        btnCancelar.addActionListener(this);
        btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnCancelar.setBackground(verdeBoton); 
        btnCancelar.setForeground(Color.WHITE);
        btnCancelar.setBounds(550, 420, 200, 50);
        btnCancelar.setFocusPainted(false);
        btnCancelar.setBorderPainted(false);    
        btnCancelar.setOpaque(true);            
        btnCancelar.setContentAreaFilled(true);
        add(btnCancelar);
        
        JLabel lblNota = new JLabel("Nota: use solo 4 dígitos numéricos.");
        lblNota.setHorizontalAlignment(SwingConstants.CENTER);
        lblNota.setForeground(Color.GRAY);
        lblNota.setFont(new Font("Tahoma", Font.ITALIC, 14));
        lblNota.setBounds(200, 330, 600, 20);
        add(lblNota);
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

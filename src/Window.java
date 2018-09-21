import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import java.awt.Insets;

public class Window {

	private JFrame frmGestorSocios;
	
	public Facade facade;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window window = new Window();
					window.frmGestorSocios.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Window() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGestorSocios = new JFrame();
		frmGestorSocios.setTitle("Gestor Socios");
		frmGestorSocios.setBounds(100, 100, 450, 300);
		frmGestorSocios.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGestorSocios.getContentPane().setLayout(null);
		
		JLabel lblEmpty = new JLabel("Empty");
		lblEmpty.setBounds(49, 76, 194, 43);
		frmGestorSocios.getContentPane().add(lblEmpty);
	}
}

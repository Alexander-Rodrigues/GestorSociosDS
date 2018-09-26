package visual;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Window.Type;

public class Warning {

	private JFrame frmWarning;
	private String warning;

	/**
	 * Launch the application.
	 */
	public static void newWarning(String message) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Warning window = new Warning(message);
					window.frmWarning.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Warning(String message) {
		warning = message;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmWarning = new JFrame();
		frmWarning.setAlwaysOnTop(true);
		frmWarning.setType(Type.UTILITY);
		frmWarning.setTitle("Warning");
		frmWarning.setFont(new Font("Ubuntu", Font.PLAIN, 12));
		frmWarning.setBounds(100, 100, 408, 275);
		frmWarning.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JLabel text = new JLabel(warning);
		text.setFont(new Font("Ubuntu", Font.BOLD, 18));
		text.setHorizontalAlignment(SwingConstants.CENTER);
		frmWarning.getContentPane().add(text, BorderLayout.CENTER);
	}

}

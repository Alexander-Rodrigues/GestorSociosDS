package visual;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Warning {

	private JFrame frmWarning;
	private String warning;

	/**
	 * Launch the application.
	 */
	public static void newWarning(String message) {
		EventQueue.invokeLater(new Runnable() {
			@Override
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
		frmWarning.setAutoRequestFocus(true);
		frmWarning.setResizable(false);


		frmWarning.setBounds(50, 50, 300, 150);
		
		JLabel lblNewLabel = new JLabel(warning);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		frmWarning.getContentPane().add(lblNewLabel, BorderLayout.CENTER);
	}

}

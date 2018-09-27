package visual;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JTabbedPane;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;

import quotas.Quotas;

import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JTable;

public class Payment {

	private JFrame frame;
	private JTextField textField;
	//private JTable table;
	//private Quotas quotas;
	private PaymentTable table;

	/**
	 * Launch the application.
	 */
	public static void newPaymentWindow(Quotas quotas) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Payment window = new Payment(quotas);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Payment(Quotas quotas) {
		table = new PaymentTable(quotas);
		//this.quotas = quotas;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{30, 136, 93, 89, 0, 30, 0};
		gridBagLayout.rowHeights = new int[]{30, 0, 0, 30, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 4;
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 1;
		frame.getContentPane().add(panel, gbc_panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);
		
		//table = new PaymentTable(new Quotas());
		scrollPane.setViewportView(table);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.BOTH;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 2;
		frame.getContentPane().add(textField, gbc_textField);
		textField.setColumns(10);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					table.add(Double.valueOf(textField.getText()));
				}
				catch (NumberFormatException e) {
					Warning.newWarning(e.getLocalizedMessage());
				}
				
			}
		});
		GridBagConstraints gbc_btnAdd = new GridBagConstraints();
		gbc_btnAdd.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAdd.insets = new Insets(0, 0, 5, 5);
		gbc_btnAdd.gridx = 2;
		gbc_btnAdd.gridy = 2;
		frame.getContentPane().add(btnAdd, gbc_btnAdd);
		
		JButton btnPay = new JButton("Pay");
		btnPay.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					int n = table.getSelectedRow();
					table.pay(n, Double.valueOf(textField.getText()));
					table.update();
				}
				catch (NumberFormatException e) {
					Warning.newWarning(e.getLocalizedMessage());
				}
				
			}
		});
		GridBagConstraints gbc_btnPay = new GridBagConstraints();
		gbc_btnPay.fill = GridBagConstraints.BOTH;
		gbc_btnPay.insets = new Insets(0, 0, 5, 5);
		gbc_btnPay.gridx = 3;
		gbc_btnPay.gridy = 2;
		frame.getContentPane().add(btnPay, gbc_btnPay);
		
		JButton btnDone = new JButton("Done");
		GridBagConstraints gbc_btnDone = new GridBagConstraints();
		gbc_btnDone.fill = GridBagConstraints.BOTH;
		gbc_btnDone.insets = new Insets(0, 0, 5, 5);
		gbc_btnDone.gridx = 4;
		gbc_btnDone.gridy = 2;
		frame.getContentPane().add(btnDone, gbc_btnDone);
		
		table.getTableHeader().addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        int col = table.columnAtPoint(e.getPoint());
		        table.sort(col);
		    }
		});
	}
	
	

}

package visual;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Font;
import javax.swing.JList;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Alunos.Facade;
import Alunos.SociosModelList;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollBar;
import javax.swing.AbstractListModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MainWindow implements Observer{

	private JFrame frmStudentManager;
	private JTextField txtAmount;
	private JButton btnPay;
	private JButton btnRemove;
	
	private Facade facade;
	private JPanel panel;
	private JScrollPane scrollPane;
	private StudentTable table;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frmStudentManager.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		facade = new Facade();
		table = new StudentTable(facade.getAlunos());
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		frmStudentManager = new JFrame();
		
		frmStudentManager.setResizable(false);
		frmStudentManager.setFont(new Font("Ubuntu Mono", Font.PLAIN, 12));
		frmStudentManager.setTitle("Student Manager");
		frmStudentManager.setBounds(100, 100, 601, 300);
		frmStudentManager.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 56, 124, 281, 0, 0};
		gridBagLayout.rowHeights = new int[]{30, 50, 50, 50, 50, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frmStudentManager.getContentPane().setLayout(gridBagLayout);
		
		MainWindow tmp = this;
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				NewStudent.newStudent(facade, tmp);
				
			}
		});
		GridBagConstraints gbc_btnAdd = new GridBagConstraints();
		gbc_btnAdd.gridwidth = 2;
		gbc_btnAdd.fill = GridBagConstraints.BOTH;
		gbc_btnAdd.insets = new Insets(0, 0, 5, 5);
		gbc_btnAdd.gridx = 1;
		gbc_btnAdd.gridy = 1;
		frmStudentManager.getContentPane().add(btnAdd, gbc_btnAdd);
		
		panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridheight = 4;
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 3;
		gbc_panel.gridy = 1;
		frmStudentManager.getContentPane().add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0};
		gbl_panel.rowHeights = new int[]{0, 0};
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		panel.add(scrollPane, gbc_scrollPane);
		
		
		
		
		
		scrollPane.setViewportView(table);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//NewStudent.newStudent(facade);
			}
		});
		GridBagConstraints gbc_btnEdit = new GridBagConstraints();
		gbc_btnEdit.gridwidth = 2;
		gbc_btnEdit.fill = GridBagConstraints.BOTH;
		gbc_btnEdit.insets = new Insets(0, 0, 5, 5);
		gbc_btnEdit.gridx = 1;
		gbc_btnEdit.gridy = 2;
		frmStudentManager.getContentPane().add(btnEdit, gbc_btnEdit);
		
		btnPay = new JButton("Pay");
		GridBagConstraints gbc_btnPay = new GridBagConstraints();
		gbc_btnPay.fill = GridBagConstraints.VERTICAL;
		gbc_btnPay.insets = new Insets(0, 0, 5, 5);
		gbc_btnPay.gridx = 1;
		gbc_btnPay.gridy = 3;
		frmStudentManager.getContentPane().add(btnPay, gbc_btnPay);
		
		txtAmount = new JTextField();
		txtAmount.setHorizontalAlignment(SwingConstants.CENTER);
		txtAmount.setFont(new Font("Ubuntu", Font.PLAIN, 28));
		txtAmount.setText("");
		GridBagConstraints gbc_txtAmount = new GridBagConstraints();
		gbc_txtAmount.insets = new Insets(0, 0, 5, 5);
		gbc_txtAmount.fill = GridBagConstraints.BOTH;
		gbc_txtAmount.gridx = 2;
		gbc_txtAmount.gridy = 3;
		frmStudentManager.getContentPane().add(txtAmount, gbc_txtAmount);
		txtAmount.setColumns(10);
		
		btnRemove = new JButton("Remove");
		btnRemove.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//table.update();
				update(null,null);
			}
		});
		GridBagConstraints gbc_btnRemove = new GridBagConstraints();
		gbc_btnRemove.fill = GridBagConstraints.BOTH;
		gbc_btnRemove.gridwidth = 2;
		gbc_btnRemove.insets = new Insets(0, 0, 5, 5);
		gbc_btnRemove.gridx = 1;
		gbc_btnRemove.gridy = 4;
		frmStudentManager.getContentPane().add(btnRemove, gbc_btnRemove);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		table.update();
	}

}

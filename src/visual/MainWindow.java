package visual;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import Alunos.Aluno;
import Alunos.Facade;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JScrollPane;
import javax.swing.JPanel;

public class MainWindow implements Observer {

	private JFrame frmStudentManager;
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
			@Override
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
	public MainWindow(){
		facade = new Facade("save");
		facade.addAluno(69, "Danny Deleto", 3, "???", "???");
		table = new StudentTable(facade.getAlunos());
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		frmStudentManager = new JFrame();
		frmStudentManager.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				System.out.println("keke");
				facade.socios.save("save");
			}
			
			@Override
			public void windowClosing(WindowEvent e) {
				facade.socios.save("save");
			}
		});
		frmStudentManager.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frmStudentManager.setResizable(false);
		frmStudentManager.setFont(new Font("Ubuntu Mono", Font.PLAIN, 12));
		frmStudentManager.setTitle("Student Manager");
		frmStudentManager.setBounds(100, 100, 601, 300);
		
		//frmStudentManager.pack();
		frmStudentManager.setLocationRelativeTo(null);
		frmStudentManager.setVisible(true);
		
		//frmStudentManager.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
				AddStudent.newStudent(facade, tmp);
				
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
				try {
					int id = getSelectedId();
					Aluno al = facade.getAluno(id);
					EditStudent.newEditStudent(facade, tmp, al.numero, al.nome, al.ano, al.curso, al.morada);
				}
				catch (Exception e) {
					
				}
				//
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
		btnPay.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					Payment.newPaymentWindow(facade.getAluno(getSelectedId()).quotas);
				}
				catch (Exception e) {
					
				}
			}
		});
		GridBagConstraints gbc_btnPay = new GridBagConstraints();
		gbc_btnPay.gridwidth = 2;
		gbc_btnPay.fill = GridBagConstraints.BOTH;
		gbc_btnPay.insets = new Insets(0, 0, 5, 5);
		gbc_btnPay.gridx = 1;
		gbc_btnPay.gridy = 3;
		frmStudentManager.getContentPane().add(btnPay, gbc_btnPay);
		
		btnRemove = new JButton("Remove");
		btnRemove.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					facade.socios.remove(getSelectedId());
					table.update();
				}
				catch (Exception e) {
					
				}
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

	public Integer getSelectedId() throws NullPointerException{
		String tmp = null;
		try {
			tmp = table.getModel().getValueAt(table.getSelectedRow(), 0).toString();
		}
		catch (Exception e) {
			throw new NullPointerException();
		}
		return Integer.valueOf(tmp);
	}
	
	@Override
	public void update(Observable arg0, Object arg1) {
		table.update();
	}

	

}

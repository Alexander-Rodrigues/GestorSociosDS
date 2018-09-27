package visual;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SpringLayout;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.SwingConstants;

import Alunos.Aluno;
import Alunos.Facade;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Observable;
import java.util.Observer;
import java.awt.Window.Type;

public class EditStudent extends Observable{

	private JFrame frame;
	private JTextField numberTextField;
	private JTextField NameTextField;
	private JTextField YearTextField;
	private JTextField CourseTextField;
	private JTextField AdressTextField;
	private JButton btnDone;
	
	private String title;
	
	private int newId;
	private int oldId;
	private String nome;
	private int ano;
	private String curso;
	private String morada;
	
	private Facade facade;
	

	/**
	 * Launch the application.
	 */
	
	public static void newEditStudent(Facade facade, Observer main, int id, String nome, int ano, String curso, String morada) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					EditStudent window = new EditStudent(facade, main, id, nome, ano, curso, morada);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public EditStudent(Facade facade, Observer main, int id, String nome, int ano, String curso, String morada) {
		addObserver(main);
		this.oldId = id;
		this.nome = nome;
		this.ano = ano;
		this.curso = curso;
		this.morada = morada;
		this.facade = facade;
		title = "Edit " + nome + "'s name";
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();

		frame.setTitle("hello");
		frame.setType(Type.NORMAL);
		frame.setResizable(false);
		frame.setBounds(100, 100, 475, 221);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{40, 0, 0, 315, 35, 0};
		gridBagLayout.rowHeights = new int[]{40, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JLabel lblNmnmnm = new JLabel("Number");
		GridBagConstraints gbc_lblNmnmnm = new GridBagConstraints();
		gbc_lblNmnmnm.anchor = GridBagConstraints.WEST;
		gbc_lblNmnmnm.insets = new Insets(0, 0, 5, 5);
		gbc_lblNmnmnm.gridx = 1;
		gbc_lblNmnmnm.gridy = 1;
		frame.getContentPane().add(lblNmnmnm, gbc_lblNmnmnm);
		
		numberTextField = new JTextField(String.valueOf(oldId));
		GridBagConstraints gbc_numberTextField = new GridBagConstraints();
		gbc_numberTextField.ipadx = 20;
		gbc_numberTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_numberTextField.insets = new Insets(0, 0, 5, 5);
		gbc_numberTextField.gridx = 3;
		gbc_numberTextField.gridy = 1;
		frame.getContentPane().add(numberTextField, gbc_numberTextField);
		numberTextField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Name");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 2;
		frame.getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
		NameTextField = new JTextField(nome);
		GridBagConstraints gbc_NameTextField = new GridBagConstraints();
		gbc_NameTextField.insets = new Insets(0, 0, 5, 5);
		gbc_NameTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_NameTextField.gridx = 3;
		gbc_NameTextField.gridy = 2;
		frame.getContentPane().add(NameTextField, gbc_NameTextField);
		NameTextField.setColumns(10);
		
		JLabel lblName = new JLabel("Year");
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.anchor = GridBagConstraints.WEST;
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridx = 1;
		gbc_lblName.gridy = 3;
		frame.getContentPane().add(lblName, gbc_lblName);
		
		YearTextField = new JTextField(String.valueOf(ano));
		GridBagConstraints gbc_YearTextField = new GridBagConstraints();
		gbc_YearTextField.insets = new Insets(0, 0, 5, 5);
		gbc_YearTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_YearTextField.gridx = 3;
		gbc_YearTextField.gridy = 3;
		frame.getContentPane().add(YearTextField, gbc_YearTextField);
		YearTextField.setColumns(10);
		
		JLabel lblYear = new JLabel("Course");
		GridBagConstraints gbc_lblYear = new GridBagConstraints();
		gbc_lblYear.anchor = GridBagConstraints.WEST;
		gbc_lblYear.insets = new Insets(0, 0, 5, 5);
		gbc_lblYear.gridx = 1;
		gbc_lblYear.gridy = 4;
		frame.getContentPane().add(lblYear, gbc_lblYear);
		
		CourseTextField = new JTextField(curso);
		GridBagConstraints gbc_CourseTextField = new GridBagConstraints();
		gbc_CourseTextField.insets = new Insets(0, 0, 5, 5);
		gbc_CourseTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_CourseTextField.gridx = 3;
		gbc_CourseTextField.gridy = 4;
		frame.getContentPane().add(CourseTextField, gbc_CourseTextField);
		CourseTextField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Adress");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 5;
		frame.getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		AdressTextField = new JTextField(morada);
		GridBagConstraints gbc_AdressTextField = new GridBagConstraints();
		gbc_AdressTextField.insets = new Insets(0, 0, 5, 5);
		gbc_AdressTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_AdressTextField.gridx = 3;
		gbc_AdressTextField.gridy = 5;
		frame.getContentPane().add(AdressTextField, gbc_AdressTextField);
		AdressTextField.setColumns(10);
		
		btnDone = new JButton("Done");
		btnDone.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					newId = Integer.valueOf(numberTextField.getText());
					nome = NameTextField.getText();
					ano = Integer.valueOf(YearTextField.getText());
					curso = CourseTextField.getText();
					morada = AdressTextField.getText();
					
				}
				catch (NumberFormatException e){
					Warning.newWarning("id and/or year must be numbers");
				}
				if (nome == null || curso == null || morada == null) {
					Warning.newWarning("Missed some fields");
				}
				else {
					facade.edit(oldId, newId, nome, ano, curso, morada);
					setChanged();
					notifyObservers();
					frame.dispose();
				}
				
			}
		});
		GridBagConstraints gbc_btnDone = new GridBagConstraints();
		gbc_btnDone.insets = new Insets(0, 0, 0, 5);
		gbc_btnDone.anchor = GridBagConstraints.EAST;
		gbc_btnDone.gridx = 3;
		gbc_btnDone.gridy = 7;
		frame.getContentPane().add(btnDone, gbc_btnDone);
	}
}
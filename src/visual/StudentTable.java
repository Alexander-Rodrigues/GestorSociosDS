package visual;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Alunos.Aluno;

public class StudentTable extends JTable{
	private static final long serialVersionUID = 1L;
	
	private HashMap<Integer, Aluno> map;
	
	public Observable obs;
	
	public StudentTable(HashMap<Integer, Aluno> map) {
		setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"ID", "Name", "Balance"
				}
			));
		this.map = map;
		update();
	}
	

	public void update() {
		Object[][] tmp = new Object[map.size()][3];
		int i = 0;
		for (Map.Entry<Integer, Aluno> entry : map.entrySet()) {
			tmp[i][0] = entry.getKey().toString();
			tmp[i][1] = entry.getValue().nome;
			tmp[i][2] = entry.getValue().quotas.balance();
			i++;
		}
		setModel(new DefaultTableModel(
				tmp,
				new String[] {
					"ID", "Name", "Balance"
				}
			));

		//this.updateUI();
		
	}
}

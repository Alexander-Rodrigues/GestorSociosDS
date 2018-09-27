package visual;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import quotas.*;

public class PaymentTable extends JTable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Quotas quotas;
	
	private boolean dateSort;
	private boolean valueSort;
	
	public PaymentTable(Quotas quotas) {
		this.quotas = quotas;
		setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Date", "Amount"
				}
			));
		update();
	}
	
	public void add(double val) {
		quotas.add(val);
		update();
	}
	
	public void pay(int n, double val) {
		quotas.pay(n, val);
	}
	
	public void sort(int n) {
		if (n == 0) {
			if (dateSort) {
				quotas.sortByDateAsc();
				
			}
			else {
				quotas.sortByDateDesc();
			}
			dateSort = !dateSort;
		}
		else {
			if (valueSort) {
				quotas.sortByValueAsc();
				
			}
			else {
				quotas.sortByValueDesc();
			}
			dateSort = !dateSort;
		}
		update();
	}
	
	public void update() {
		Object tmp[][] = new Object[quotas.size()][2];
		int i = 0;
		for (Quota q : quotas) {
			tmp[i][0] = q.date.toString();
			tmp[i][1] = q.value;
			i++;
		}
		setModel(new DefaultTableModel(
				tmp,
				new String[] {
					"Date", "Amount"
				}
			));
	}
}	

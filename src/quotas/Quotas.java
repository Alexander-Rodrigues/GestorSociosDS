package quotas;

import java.util.ArrayList;

public class Quotas {
	ArrayList<Quota> list;
	
	public double balance() {
		double r = 0;
		for (Quota q : list) {
			r += q.value;
		}
		return r;
	}
	
	public Quotas() {
		list = new ArrayList<Quota>();
	}
	
	public void sortByDateAsc() {
		list.sort(new sortByDateAsc());
	}
	
	public void sortByDateDesc() {
		list.sort(new sortByDateDesc());
	}
	
	public void sortByValueAsc() {
		list.sort(new sortByValueAsc());
	}
	
	public void sortByValueDesc() {
		list.sort(new sortByValueDesc());
	}
	
	public void pay(int n, double val) {
		Quota tmp = list.get(n);
		tmp.pay(val);
		if (tmp.value.equals(new Double(0))) {
			list.remove(n);
		}
		
	}
	
}

package quotas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class Quotas implements Iterable<Quota>, Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ArrayList<Quota> list;
	
	public double balance() {
		double r = 0;
		for (Quota q : list) {
			r += q.value;
		}
		return r;
	}
	
	public int size() {
		return list.size();
	}
	
	public void add(double val) {
		list.add(new Quota(val));
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
		try {
			Quota tmp = list.get(n);
			tmp.pay(val);
			if (tmp.value.equals(new Double(0))) {
				list.remove(n);
			}
		}
		catch (Exception e) {
			
		}
		
	}

	@Override
	public Iterator<Quota> iterator() {
		// TODO Auto-generated method stub
		return list.iterator();
	}

	
}

package Alunos;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import quotas.Quotas;

public class Socios implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	public HashMap<Integer, Aluno> alunos;
	
	public Socios() {
		alunos = new HashMap<Integer, Aluno>();
	}
	
	public boolean existe(int num) {
		return (alunos.containsKey(num));
	}
	
	public void add(Aluno aluno) {
		if (!alunos.containsKey(aluno.numero)) alunos.put(aluno.numero, aluno);
	}
	
	public void edit(int oldId, int newId, String nome, int ano, String curso, String morada) {
		if (!alunos.containsKey(oldId)) {
			//doesnt exist
		}
		else if (alunos.containsKey(newId)) {
			//ja existe alguem com este id no sistema, NO DUPLICATES
		}
		Aluno nAl = new Aluno(newId, nome, ano, curso, morada);
		Aluno oAl = alunos.get(oldId);
		nAl.quotas = oAl.quotas;
		alunos.remove(oldId);
		alunos.put(newId, nAl);
	}
	
	public void pagarQuota(int aluno,int n, double valor) {
		try {
			Aluno tmp = alunos.get(aluno);
			tmp.quotas.pay(n, valor);
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public Aluno getAluno(int num) {
		return alunos.get(num);
	}
	
	public void remove(int num) {
		alunos.remove(num);
	}
	
	@SuppressWarnings("unchecked")
	public Socios(String path) {
		Object o;
		try {
			FileInputStream fileIn = new FileInputStream(path);
			ObjectInputStream in = new ObjectInputStream(fileIn);
			o = in.readObject();
			if (o instanceof HashMap) {
				alunos = (HashMap<Integer, Aluno>) o;
			}
			in.close();
			fileIn.close();
		}
		catch (Exception e) {
			e.printStackTrace();
			return;
		}
	}
	
	public void save (String path) {
		try {
			FileOutputStream fileout = new FileOutputStream(path);
			ObjectOutputStream out = new ObjectOutputStream(fileout);
			out.writeObject(alunos);
			out.close();
			fileout.close();
		}
		catch (Exception e) {
			e.printStackTrace();
			return;
		}
	}
	
	public HashMap<Integer, Aluno>getAlunos() {
		return this.alunos;
	}
}

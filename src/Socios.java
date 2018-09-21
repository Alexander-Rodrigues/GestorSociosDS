import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Socios implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	public Map<Integer, Aluno> alunos;
	
	public Socios() {
		alunos = new HashMap<Integer, Aluno>();
	}
	
	public void add(Aluno aluno) {
		alunos.put(aluno.numero, aluno);
	}
	
	public void remove(int numero) {
		alunos.remove(numero);
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
		return new HashMap<Integer, Aluno>(this.alunos);
	}
}

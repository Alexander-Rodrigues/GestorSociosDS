package Alunos;
import java.util.HashMap;
import java.util.Observable;


public class Facade {
	
	public Socios socios;
	public Observable observable;
	
	public Facade () {
		socios = new Socios();
		observable = new Observable();
	}
	
	public Facade(String save) {
		socios = new Socios(save);
	}

	public void addAluno(int numero, String nome, int ano, String curso, String morada) {
		socios.add(new Aluno(numero,nome,ano,curso,morada));
	}
	
	public void edit(int oldId, int newId, String nome, int ano, String curso, String morada) {
		socios.edit(oldId, newId, nome, ano, curso, morada);
	}
	
	public Aluno getAluno(int id) {
		return socios.alunos.get(id);
	}
	
	public double getBalance(int id) {
		return socios.alunos.get(id).quotas.balance();
	}
	
	public HashMap<Integer, Aluno> getAlunos() {
		return socios.getAlunos();
	}
	
}

import java.util.HashMap;


public class Facade {
	
	public Socios socios;
	
	public Aluno aluno;
	
	public void registar(int numero, String nome, int ano, String curso, String morada) {
		aluno = new Aluno(numero, nome, ano, curso, morada);
	}
	
	public void pagarQuota(Aluno aluno) {
		aluno.quota = 0;
	}
	
	public HashMap<Integer, Aluno> getAlunos() {
		return socios.getAlunos();
	}
	
}


public class Aluno {
	public int numero;
	public String nome;
	public int ano;
	public String curso;
	public String morada;
	
	public double quota;
	
	

	public Aluno(int numero, String nome, int ano, String curso, String morada) {
		super();
		this.numero = numero;
		this.nome = nome;
		this.ano = ano;
		this.curso = curso;
		this.morada = morada;
	}



	@Override
	public String toString() {
		return "Aluno [numero=" + numero + ", nome=" + nome + ", ano=" + ano + ", curso=" + curso + ", morada=" + morada
				+ ", quota=" + quota + "]";
	}
	
	
	
}

package classes;

public class Jogador {
	private String nome;

	public Jogador(String nome) {
		super();
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "" + nome ;
	}

}

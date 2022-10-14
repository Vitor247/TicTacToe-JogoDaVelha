package classes;

public class Tabuleiro {
	private char[][] tabuleiro;
	
	public Tabuleiro(int linhas, int colunas) {
		tabuleiro = new char[linhas][colunas];
		limpar();
	}
	
	public void inserirSimbolo(int linha, int coluna, char simbolo) 
	throws ArrayIndexOutOfBoundsException{
		tabuleiro[linha][coluna] = simbolo;
	}
	
	@Override
	public String toString() {
		String imagem = "\n";
		for(int i = 0; i < tabuleiro.length;i++) {
			imagem += "| ";
			for(int j = 0; j < tabuleiro[0].length; j++) {
				imagem += tabuleiro[i][j];
				if(j == 0 || j == 1) {
					imagem += " | ";
				}
			}
			imagem += " |\n";
		}	
		imagem += "-------------";
		return imagem;
	}
	
	public void limpar() {
		for(int i = 0; i < tabuleiro.length;i++) {
			for(int j = 0; j < tabuleiro[0].length; j++) {
				tabuleiro[i][j] = ' ';
			}
		}
	}
	
	public char[][] getEstadoTabuleiro(){
		return tabuleiro;
	}
}

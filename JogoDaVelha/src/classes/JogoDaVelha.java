package classes;

import java.util.ArrayList;
import java.util.Arrays;

public class JogoDaVelha {
	
	private ArrayList<Jogador> jogadores;
	private Tabuleiro tabuleiro;
	private int jogadorDaVez = 0;
	
	public JogoDaVelha(ArrayList<Jogador> jogadores) {
		tabuleiro = new Tabuleiro(3,3);
		this.jogadores = jogadores;
	}
	
	public JogoDaVelha(Jogador jogador1, Jogador jogador2) {
		tabuleiro = new Tabuleiro(3,3);
		this.jogadores = new ArrayList<Jogador>(Arrays.asList(jogador1, jogador2));
	}
	
	public void inicializaJogo() {
		tabuleiro.limpar();
		jogadorDaVez = 0;
	}
	
	public boolean haGanhador() {
		char[][] estadoTabuleiro = tabuleiro.getEstadoTabuleiro();
		return verificaLinha(estadoTabuleiro) || 
			   verificaColuna(estadoTabuleiro) ||
			   verificaDiagonal(estadoTabuleiro);

	}
	
	public void alternarJogador() {
		if(jogadorDaVez == 0)
			jogadorDaVez = 1;
		else
			jogadorDaVez = 0;
	}
	
	public int getJogadorDaVez() {
		return jogadorDaVez;
	}

	public void jogada(int linha, int coluna) {
		tabuleiro.inserirSimbolo(linha, coluna, getSimbolo());
	}
	
	public char getSimbolo() {
		return jogadorDaVez == 0 ? 'X' : 'O';
	}
	
	@Override
	public String toString() {
		return tabuleiro.toString();
	}
	
	private boolean verificaLinha(char[][] estadoTabuleiro) {
		char simbolo = getSimbolo();
		for(int i = 0; i < estadoTabuleiro.length;i++) {
			int aux = 0;
			for(int j = 0; j < estadoTabuleiro[0].length; j++) {
				if(estadoTabuleiro[i][j] == simbolo) {
					aux++;
				}else {
					break;
				}
			}
			if(aux == 3)
				return true;
		}
		return false;
	}
	
	private boolean verificaColuna(char[][] estadoTabuleiro) {
		char simbolo = getSimbolo();
		for(int i = 0; i < estadoTabuleiro.length;i++) {
			int aux = 0;
			for(int j = 0; j < estadoTabuleiro[0].length; j++) {
				if(estadoTabuleiro[j][i] == simbolo) {
					aux++;
				}else {
					break;
				}
			}
			if(aux == 3)
				return true;
		}
		return false;
	}	
	
	private boolean verificaDiagonal(char[][] estadoTabuleiro) {
		char simbolo = getSimbolo();
		if(estadoTabuleiro[0][0] == simbolo && estadoTabuleiro[1][1] == simbolo
				&& estadoTabuleiro[2][2] == simbolo) {
			return true;
		}
		if(estadoTabuleiro[0][2] == simbolo && estadoTabuleiro[1][1] == simbolo
				&& estadoTabuleiro[2][0] == simbolo) {
			return true;
		}
		return false;
	}
	
}






package app;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import classes.Jogador;
import classes.JogoDaVelha;

public class App {
	public static void main(String [] args) {
		Jogador jogador;
		ArrayList<Jogador> jogadores = new ArrayList<Jogador>();
		Scanner sc = new Scanner(System.in);
		
		for(int i = 0; i < 2; i++) {
			jogador = new Jogador("Jogador " + (i + 1));
			jogadores.add(jogador);
		}
		
		//falta o método de validar se a posição está ocupada
		
		JogoDaVelha jogoDaVelha = new JogoDaVelha(jogadores);
		jogoDaVelha.inicializaJogo();
		System.out.println("---------------");
		System.out.println("Inicio de jogo!");
		System.out.println("---------------");
		for(int i = 0; i < 9; i++) {
			System.out.println("Rodada " + (i + 1));
			System.out.println(jogadores.get(jogoDaVelha.getJogadorDaVez()));
			System.out.println("Linha: ");
			int linha = validarDigitacao() - 1;
			System.out.println("Coluna: ");
			int coluna = validarDigitacao() - 1;
			jogoDaVelha.jogada(linha, coluna);
			System.out.println(jogoDaVelha);
			if(jogoDaVelha.haGanhador()) {
				System.out.println(jogadores.get(jogoDaVelha.getJogadorDaVez()) + " ganhou!");
				break;
			}else if(i == 8) {
				System.out.println("Empate!");
			}
			jogoDaVelha.alternarJogador();
		}
	}
	
	//não foi feito o tratamento da exceção
	public static int validarDigitacao() throws InputMismatchException { 
		int x;
		Scanner scanner = new Scanner(System.in);
		do {
			x = scanner.nextInt();
			if(x != 1 && x != 2 && x != 3) {
				System.out.println("Digite um numero entre 1 e 3");
			}
		}while(x != 1 && x != 2 && x != 3);
		return x;
	}
}






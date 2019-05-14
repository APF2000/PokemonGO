package game;
import java.util.Random;

public class Tile {
	private final boolean comum = false;
	private final boolean gramado = true;

	private final int direita = 1; 
	private final int esquerda = 2; 
	private final int cima = 3; 
	private final int baixo = 4;

	private boolean tipo;
	private int linha_atual;
	private int coluna_atual;

	public Tile() {
		Random rand = new Random();

		// random fica com um numero entre 0 e 6
		// queremos que a probabilidade de ser gramado
		// seja 1/6, e de ser normal de 5/6
		int random = rand.nextInt(7);
		for(int i = 0; i < 100; i++) {
			random = rand.nextInt(7);
			tipo = (random % 6 == 0);
			System.out.println(random + "\n" + tipo);
		}
	}

	public Tile[][] criaMapa(int linhas, int colunas) {
		Tile[][] mapa = new Tile[linhas][colunas]; 
		for(int i = 0; i < linhas; i++) {
			for(int j = 0; j < colunas; j++) {
				mapa[i][j] = new Tile();
			}
		}
		
		Random rand = new Random();
		linha_atual = rand.nextInt(linhas);
		coluna_atual = rand.nextInt(colunas);
		
		return mapa;
	}

	
}

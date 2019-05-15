package game;
import java.util.Random;

public class Tile {
	public static final boolean comum = false;
	public static final boolean gramado = true;

	public static final int direita = 1, cima = 2;
	public static final int esquerda = 3, baixo = 4;

	private boolean tipo;
	private static int atual_lin;
	private static int atual_col;


	public Tile() {
		Random rand = new Random();

		// random fica com um numero entre 0 e 6
		// queremos que a probabilidade de ser gramado
		// seja 1/6, e de ser normal de 5/6
		int random = rand.nextInt(7);
		random = rand.nextInt(7);
		tipo = (random % 6 == 0);
		//System.out.println("random % 6 == " + random % 6 + " " + (random%6==0));
	}

	public boolean tipo() {
		return tipo;
	}

	public static Tile[][] criaMapa(int linhas, int colunas) {
		Tile[][] mapa = new Tile[linhas][colunas]; 
		for(int i = 0; i < linhas; i++) {
			for(int j = 0; j < colunas; j++) {
				mapa[i][j] = new Tile();
			}
		}


		Random rand = new Random();
		atual_lin = rand.nextInt(linhas);
		atual_col = rand.nextInt(colunas);

		return mapa;
	}

	public static void anda(int direcao, int linhas, int colunas) {
		System.out.println("\nMovido da posicao (" + atual_lin + ", " 
				+ atual_col + ")");

		if(direcao == direita) {
			atual_lin += 1 + linhas;
			atual_lin %= linhas;
		}
		else if(direcao == esquerda){
			atual_col += -1 + colunas;
			atual_col %= colunas;
		}
		else if(direcao == cima){
			atual_col += + 1 + colunas;
			atual_col %= colunas;
		}
		else if(direcao == baixo){
			atual_col += - 1 + colunas;
			atual_col %= colunas;
		}

		System.out.println("para (" + atual_lin + ", " 
				+ atual_col + ")");

	}	

	/*public static void main(String[] args) {
		Tile[][] mapa;
		mapa = criaMapa(30, 30);
		for(int i = 0; i < 30; i++) {
			for(int j = 0; j < 30; j++) {
				Tile.anda(direita, 30, 30);
				System.out.print("Onde há ");

				if(mapa[i][j].tipo() == gramado) {
					System.out.println("grama");
				}
				else if(mapa[i][j].tipo() == comum) {
					System.out.println("chão");
				}
			}
			Tile.anda(baixo, 30, 30);
		}
	}
	 */
}

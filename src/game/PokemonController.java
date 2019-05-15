package game;
import java.util.Random;

import pokemons.Bubasauro;
import pokemons.Caterpie;
import pokemons.Charmander;
import pokemons.Cubone;
import pokemons.Ekans;
import pokemons.Gardevoir;
import pokemons.Gyarados;
import pokemons.Pidgeot;
import pokemons.Pikachu;
import pokemons.Rattata;
import pokemons.Raychu;
import pokemons.Spearow;
import java.util.Scanner;

public class PokemonController extends Controller{
	public static final boolean comum = false;
	public static final boolean gramado = true;

	public static final String direita = "D", cima = "C";
	public static final String esquerda = "E", baixo = "B";

	private final int atacar = 0, item = 1, trocar = 2, fugir = 3;

	public PokemonController() {
		super();
	}

	public void addEvent() {
		System.out.println("Evento adicionado");
	}


	private class Select extends Event{
		private String saida;
		Treinador esponja = new Treinador("Esponja", true);

		int selecao;

		public Select(Treinador a, int selecao) {
			esponja = a;
			this.selecao=selecao;
		}

		public void prioridade() {
			saida = esponja.selectedPoke().getNome();

		}

		public String description() {
			return ("(" + esponja.getNome() +") selecionou "+ saida);
		}

	}
	private class Acao extends Event{
		Treinador a;
		Treinador b;
		String move= "";
		int acao_t1=0;
		int sel_t1=0;
		int acao_t2=0;
		int sel_t2=0;
		boolean alvo;//true: alvo é o inimigo / false: o alvo é ele mesmo 

		public Acao(Treinador a, int acao_t1, int sel_t1, 
				Treinador b,  int acao_t2, int sel_t2, boolean alvo) {
			this.a=a;
			this.b=b;

			this.acao_t1=acao_t1;
			this.sel_t1=sel_t1;

			this.acao_t2=acao_t2;
			this.sel_t2=sel_t2;
		}

		public void prioridade() {

			if(acao_t1>acao_t2) {
				if(alvo==true) {
					move += a.movimentoSelect(acao_t1,sel_t1,b.selectedPoke());	
					move += b.movimentoSelect(acao_t2,sel_t2,a.selectedPoke());
				}
				else {
					move += a.movimentoSelect(acao_t1,sel_t1,a.selectedPoke());	
					move += b.movimentoSelect(acao_t2,sel_t2,b.selectedPoke());	
				}

			}
			else {
				if(alvo==true) {
					move += b.movimentoSelect(acao_t2,sel_t2,a.selectedPoke());
					move += a.movimentoSelect(acao_t1,sel_t1,b.selectedPoke());	
				}
				else {
					move += b.movimentoSelect(acao_t2,sel_t2,b.selectedPoke());
					move += a.movimentoSelect(acao_t1,sel_t1,a.selectedPoke());		
				}
			}
		}

		public String description() {

			return(move);
			/*return ("(" + a.getNome() + ") usou " + 
					a.selPoke().getNome() + " para atacar o "
					+ b.selPoke().getNome()+" de ("+ b.getNome() + ") com " + move);
			 */
		}

	}

	private class Restart extends Event {

		public Restart() {}
		public String description() {
			return "";
		}

		private Treinador jogador = new Treinador("Você", true);
		private Treinador selvagem = new Treinador("Pokemon Selvagem", false);


		public void prioridade() {
			long tm = System.currentTimeMillis();

			Scanner scanf = new Scanner(System.in);
			String poke;


			// Esqueleto do jogo de verdade
			int n = 3;
			System.out.println("Adicione " + n + " Pokemons à pokedex");
			for(int i = 0; i < n; i++) {
				poke = scanf.nextLine();
				jogador.addPoke(poke);
			}

			selvagem.addPoke("Gardevoir");

			/*System.out.println("\nCOMECOU A BATALHA\n");
			addEvent(new Select(esponja,0));
			addEvent(new Select(construtor,0));
			addEvent(new Acao(esponja,0, 0,construtor,2,1,true));
			addEvent(new Acao(esponja,2, 1,construtor,0,0,false)); */	

			Tile[][] mapa;
			Tile aux = new Tile();
			String direcao;

			int linhas = 20;
			int colunas = 20;

			mapa = aux.criaMapa(linhas, colunas);

			while(System.currentTimeMillis() - tm <= 10E8) {
				System.out.print("\nPra qual lado você vai? (D = direita, E = esquerda"
						+ ", C = cima, B = baixo)");					
				direcao = scanf.next();
				aux.anda(direcao, linhas, colunas);
				System.out.print(", onde há ");

				if(mapa[ aux.atualLin() ][ aux.atualCol() ].tipo() == gramado) {
					System.out.println("grama");
					

					Random rand = new Random();
					
					// random fica com um numero entre 0 e 10
					// queremos que a probabilidade de surgir
					// um poquemon selvagem seja de 10%
					int random = rand.nextInt(11);
					random = rand.nextInt(11);
					if(random % 10 != 0) {
						System.out.println("\nOh não, um pokemon selvagem!!");
						int acao_jogador = 0;
						int sel_jogador = 0;
						
						while( (jogador.proxComHp() != -1 && selvagem.proxComHp() != -1) 
									&& acao_jogador != fugir) {
							
							System.out.println("Atacar = 0, Item = 1, TrocarPoke = 2, Fugir = 3, ");
							acao_jogador = scanf.nextInt();

							if(acao_jogador == atacar) {
								System.out.println("Ataques disponíveis:");
								jogador.selectedPoke().listaAtaques();
								sel_jogador = scanf.nextInt();								
							}
							else if(acao_jogador == item) {
								sel_jogador = scanf.nextInt();								
							}
							else if(acao_jogador == trocar) {
								sel_jogador = scanf.nextInt();								
							}
							
							addEvent(new Acao(jogador,acao_jogador, sel_jogador,selvagem,item,0,true));

							System.out.println("EAEMEN ");
						}
					}
				}

				else if(mapa[ aux.atualLin() ][ aux.atualCol() ].tipo() == comum) {
					System.out.println("chão");
				}
			}
		}

		public Restart(long time) {
			super(time);
		}

	}

	public static void main(String[] args) {

		PokemonController poke = new PokemonController();
		long tm = System.currentTimeMillis();
		poke.addEvent(poke.new Restart(tm));
		poke.run();
	}

}

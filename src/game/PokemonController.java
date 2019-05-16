package game;

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
import java.util.Random;

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
	private class Status extends Event {
		private Treinador a;
		private Treinador b;
		
		private boolean nojogo1=true;
		private boolean nojogo2=true;
		public Status(Treinador a, Treinador b){
			this.a = a;
			this.b = b;
		}
		public void prioridade() {
			nojogo1 = a.noJogo();
			nojogo2 = b.noJogo();
				
		}
		public boolean nojogo() {
			if( (!nojogo1) || (!nojogo2) ){
				return(false);
			}
			return(true);
				
		}

		public String description() {
			return("-------------------------------------\n" 
					+ a.selectedPoke().getNome() +  " HP " + a.selectedPoke().getHp()+"\n"+
					b.selectedPoke().getNome() +  " HP " + b.selectedPoke().getHp());
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
		boolean alvo1;//true: alvo é o inimigo / false: o alvo é ele mesmo 
		boolean alvo2;

		public Acao(Treinador a, int acao_t1, int sel_t1,boolean alvo1, 
				Treinador b,  int acao_t2, int sel_t2, boolean alvo2) {
			this.a = a;
			this.b = b;
			this.acao_t1 = acao_t1;
			this.sel_t1 = sel_t1;
			this.alvo1 = alvo1;

			this.acao_t2 = acao_t2;
			this.sel_t2 = sel_t2;
			this.alvo2 = alvo2;


		}

		public void prioridade() {



			if(acao_t1>acao_t2) {
				if(alvo1==true) {

					move += a.movimentoSelect(acao_t1,sel_t1,b.selectedPoke());	

					if(alvo2==true)
						move += b.movimentoSelect(acao_t2,sel_t2,a.selectedPoke());
					else
						move += b.movimentoSelect(acao_t2,sel_t2,b.selectedPoke());	
				}
				else {
					move += a.movimentoSelect(acao_t1,sel_t1,a.selectedPoke());	

					if(alvo2==true)

						move += b.movimentoSelect(acao_t2,sel_t2,a.selectedPoke());
					else

						move += b.movimentoSelect(acao_t2,sel_t2,b.selectedPoke());	
				}

			}
			else {
				if(alvo2==true) {

					move += b.movimentoSelect(acao_t2,sel_t2,a.selectedPoke());

					if(alvo1==true) {

						move += a.movimentoSelect(acao_t1,sel_t1,b.selectedPoke());	

					}
					else {
						move += a.movimentoSelect(acao_t1,sel_t1,a.selectedPoke());	
					}
				}
				else {

					move += b.movimentoSelect(acao_t2,sel_t2,b.selectedPoke());

					if(alvo1==true) {
						move += a.movimentoSelect(acao_t1,sel_t1,b.selectedPoke());	
					}
					else {
						move += a.movimentoSelect(acao_t1,sel_t1,a.selectedPoke());	
					}		
				}
			}

			
			System.out.println(move);
		}
		public String description() {

			return("");
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


			Tile[][] mapa;
			Tile aux = new Tile();
			String direcao;

			int linhas = 20;
			int colunas = 20;

			mapa = aux.criaMapa(linhas, colunas);

			while(System.currentTimeMillis() - tm <= 30000) {
				System.out.print("\nPra qual lado você vai? (D = direita, E = esquerda"
						+ ", C = cima, B = baixo)");					
				direcao = scanf.next();
				aux.anda(direcao, linhas, colunas);
				System.out.print(", onde há ");

				if(mapa[ aux.atualLin() ][ aux.atualCol() ].tipo() == gramado) {
					System.out.println("grama");
				}

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

						addEvent(new Acao(jogador,acao_jogador, sel_jogador,true,selvagem,item,0,true));

					}
				}
				else if(mapa[ aux.atualLin() ][ aux.atualCol() ].tipo() == comum) {
					System.out.println("chão");
				}
				for(int i=0;i<100;i++)
					addEvent(new Acao(jogador,0, 0,selvagem,item,0,true));
			}
		}

		public Restart(long time) {
			super(time);
		}

	}private class Parte1_evento extends Event {
		
		Treinador a;
		Treinador b;
		
		public Parte1_evento(Treinador a, Treinador b) {
			this.a=a;
			this.b=b;
		}
		
		public void prioridade() {
			
			addEvent(new Status(a,b));
			if((new Status(a,b)).nojogo()){
				System.out.println((new Status(a,b)).nojogo());
				addEvent(new Acao(a,0, 1,true,b, 0,0,true));
				addEvent(new Parte1_evento(a,b));
			}
		}
		public String description() {
			return "";
		}
	}
	
	private class Parte1 extends Event {

		public Parte1() {}
		public String description() {
			return "";
		}



		public void prioridade() {
			Treinador esponja = new Treinador("Bob Esponja",true);
			Treinador construtor = new Treinador("Bob, o Contrutor",true);

			esponja.addPoke("Pikachu");
			esponja.addPoke("Gyarados");
			esponja.addPoke("Gardevoir");
			esponja.addPoke("Pidgeot");
			esponja.addPoke("Spearow");
			esponja.addPoke("Cubone");

			construtor.addPoke("Charmander");
			construtor.addPoke("Ekans");
			construtor.addPoke("Rattata");
			construtor.addPoke("Bubasauro");
			construtor.addPoke("Raychu");
			construtor.addPoke("Caterpie");
			
			addEvent(new Parte1_evento(esponja,construtor));
			
			
		}
	}

	public static void main(String[] args) {

		PokemonController poke = new PokemonController();
		long tm = System.currentTimeMillis();
		poke.addEvent(poke.new Parte1());
		poke.run();
	}

}

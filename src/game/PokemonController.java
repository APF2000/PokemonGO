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

public class PokemonController extends Controller{

	public PokemonController() {
		super();
	}
	private class Select extends Event{
		private String saida;
		Treinador a = new Treinador("Esponja");
		int selecao;

		public Select(Treinador a, int selecao) {
			this.a=a;
			this.selecao=selecao;
		}

		public void prioridade() {
			saida = a.selectedPoke().getNome();

		}

		public String description() {
			return ("(" + a.getNome() +") selecionou "+ saida);
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

		public String description() {
			return "";
		}

		private Treinador esponja = new Treinador("Bob esponja");
		private Treinador construtor = new Treinador("Bob, o construtor");


		public void prioridade() {
			long tm = System.currentTimeMillis();
			Scanner scanf = new Scanner(System.in);
			String poke;
			
			
			// Esqueleto do jogo de verdade
			System.out.println("Adicione 2 Pokemons");
			for(int i = 0; i < 2; i++) {
				poke = scanf.nextLine();
				esponja.addPoke(poke);
			}
			
			System.out.println("Adicione 2 Pokemons vc tbm");
			for(int i = 0; i < 2; i++) {
				poke = scanf.nextLine();
				construtor.addPoke(poke);
			}
			/*esponja.addPoke(new Pikachu());
			esponja.addPoke(new Gyarados());
			esponja.addPoke(new Gardevoir());
			esponja.addPoke(new Caterpie());
			esponja.addPoke(new Pidgeot());
			esponja.addPoke(new Spearow());

			construtor.addPoke(new Bubasauro());
			construtor.addPoke(new Charmander());
			construtor.addPoke(new Rattata());
			construtor.addPoke(new Raychu());
			construtor.addPoke(new Cubone());
			construtor.addPoke(new Ekans()); */

			System.out.println("\nCOMECOU A BATALHA\n");
			addEvent(new Select(esponja,0));
			addEvent(new Select(construtor,0));
			addEvent(new Acao(esponja,0, 0,construtor,2,1,true));
			addEvent(new Acao(esponja,2, 1,construtor,0,0,false));		

		}

		public Restart(long time) {
			super(time);
		}
	}

	public void addEvent() {
		//System.out.println("Evento adicionado");
	}

	public static void main(String[] args) {

		PokemonController poke = new PokemonController();
		long tm = System.currentTimeMillis();
		poke.addEvent(poke.new Restart(tm));
		poke.run();
	}

}

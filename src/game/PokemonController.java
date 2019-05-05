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

import br.usp.ime.mac0321.Pokemons.Bubasauro;
import br.usp.ime.mac0321.Pokemons.Caterpie;
import br.usp.ime.mac0321.Pokemons.Charmander;
import br.usp.ime.mac0321.Pokemons.Cubone;
import br.usp.ime.mac0321.Pokemons.Ekans;
import br.usp.ime.mac0321.Pokemons.Gardevoir;
import br.usp.ime.mac0321.Pokemons.Gyarados;
import br.usp.ime.mac0321.Pokemons.Pidgeot;
import br.usp.ime.mac0321.Pokemons.Pikachu;
import br.usp.ime.mac0321.Pokemons.Rattata;
import br.usp.ime.mac0321.Pokemons.Raychu;
import br.usp.ime.mac0321.Pokemons.Spearow;

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

		public void action() {
			saida=a.selectPoke(selecao);

		}

		public String description() {
			return ("(" + a.getNome() +") selecionou "+ saida);
		}

	}
	private class Acao extends Event{
		Treinador a;
		Treinador b;
		String move= "";
		int selecao1=0;
		int selecao2=0;
		int selecao3=0;
		int selecao4=0;
		boolean alvo1;//true: alvo é o inimigo / false o alvo é ele mesmo 
		boolean alvo2;

		public Acao(Treinador a, int selecao1, int selecao2, boolean alvo1, Treinador b,  int selecao3, int selecao4, boolean alvo2) {
			this.a=a;
			this.b=b;
			this.selecao1=selecao1;
			this.selecao2=selecao2;
			this.selecao3=selecao3;
			this.selecao4=selecao4;
		}

		public void action() {
			
			if(selecao1>selecao3) {
				if(alvo1==true) {
					move+=a.movimentoSelect(selecao1,selecao2,b.selPoke());	
				}
				else {
					move+=a.movimentoSelect(selecao1,selecao2,a.selPoke());	
				}
				if(alvo2==true) {
					move+=b.movimentoSelect(selecao3,selecao4,a.selPoke());	
				}
				else {
					move+=b.movimentoSelect(selecao3,selecao4,b.selPoke());	
				}
			}
			else {
				if(alvo2==true) {
					move+=b.movimentoSelect(selecao3,selecao4,a.selPoke());	
				}
				else {
					move+=b.movimentoSelect(selecao3,selecao4,b.selPoke());	
				}
				if(alvo1==true) {
					move+=a.movimentoSelect(selecao1,selecao2,b.selPoke());	
				}
				else {
					move+=a.movimentoSelect(selecao1,selecao2,a.selPoke());	
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


		public void action() {
			long tm = System.currentTimeMillis();

			esponja.addPoke(new Pikachu());
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
			construtor.addPoke(new Ekans());

			System.out.println("\nCOMECOU A BATALHA\n");
			addEvent(new Select(esponja,0));
			addEvent(new Select(construtor,0));
			addEvent(new Acao(esponja,0, 0,true,construtor,2,1,false));

			

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

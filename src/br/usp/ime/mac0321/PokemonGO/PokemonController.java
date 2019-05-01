package br.usp.ime.mac0321.PokemonGO;

public class PokemonController extends Controller{

	public PokemonController() {
		super();
	}
	private class Select extends Event{
		private String saida;
		Treinador a;
		int selecao;
		public Select(Treinador a, int selecao) {
			this.a=a;
			this.selecao=selecao;
		}

		public void action() {
			saida=a.selectPoke(selecao);
			
		}

		public String description() {
			return (a.getNome() +" selecionou "+ saida);
		}
		
	}
	private class Restart extends Event {

		public String description() {
			return "";
		}

		private Treinador esponja = new Treinador("Bob esponja");
		private Treinador construtor = new Treinador("Bob, o construtor");

		public void teste1() {
			esponja.addPoke(new Pikachu());
			esponja.addPoke(new Gyarados());

			construtor.addPoke(new Bubasauro());
			construtor.addPoke(new Charmander());
		}
		
		
		public void teste2() {
			Restart teste = new Restart(2);
			teste.teste1();
		}
		public void action() {
			long tm = System.currentTimeMillis();
			System.out.println("comecou a batalha");
			addEvent(new Select(esponja,1));
			addEvent();
			addEvent();
			addEvent();
		}

		public Restart(long time) {
			super();
		}
	}

	public void addEvent() {
		System.out.println("Evento adicionado");
	}
	
	public static void main(String[] args) {

		PokemonController poke = new PokemonController();
		long tm = System.currentTimeMillis();
		poke.addEvent(poke.new Restart(tm));
		poke.run();
	}

}

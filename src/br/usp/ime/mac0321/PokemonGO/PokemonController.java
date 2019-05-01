package br.usp.ime.mac0321.PokemonGO;

public class PokemonController extends Controller{
	
	public PokemonController() {
		super();
	}
	
	private class Restart extends Event {
		
		public void action() {}
		public String description() {
			return "description";
		}
		
		private Treinador esponja = new Treinador("Bob esponja");
		private Treinador construtor = new Treinador("Bob, o construtor");
		
		private Pikachu teste = new Pikachu();
		
		
		esponja.addPoke(new Gyarados);
		construtor.addPoke(new Bubasauro);
		construtor.addPoke(new Charmander);


		public Restart() {
			super();
		}	
		
		
	}
    
	
	public static void main(String[] args) {

		PokemonController poke = new PokemonController();
		long tm = System.currentTimeMillis();
		poke.addEvent(poke.new Restart(tm));
		poke.run();
	}
	
}

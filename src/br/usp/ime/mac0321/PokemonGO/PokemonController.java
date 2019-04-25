package br.usp.ime.mac0321.PokemonGO;

public class PokemonController extends Controller{
		
	private class Restart extends Event {
		
		Treinador esponja = new Treinador("Bob esponja");
		Treinador construtor = new Treinador("Bob, o construtor");
		esponja.addPoke(new Pikachu);
		esponja.addPoke(new Gyarados);
		construtor.addPoke(new Bubasauro);
		construtor.addPoke(new Charmander);
		
		System.out.println("vai, se não o Pires me mata...");
		
		
		
	}
    
	
	public static void main(String[] args) {

		PokemonController poke = new PokemonController();
		long tm = System.currentTimeMillis();
		poke.addEvent(poke.new Restart(tm));
		poke.run();
	}
	
}

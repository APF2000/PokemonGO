package pokemons;

import game.Move;
import game.Pokemon;

public class Caterpie extends Pokemon {

	
	public Caterpie() {
		nome = "Caterpie";
		ataques[0]=new Move("Vento na asas",10);
		ataques[1]=new Move("Pega e atira",10);
		ataques[2]=new Move("Voo neurotico",10);
		ataques[3]=new Move("Rasante",10);
		tipo = "Bug";
	}
}
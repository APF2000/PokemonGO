package pokemons;

import game.Move;
import game.Pokemon;

public class Rattata extends Pokemon {

	
	public Rattata() {
		nome = "Rattata";
		ataques[0]=new Move("Mordida",10);
		ataques[1]=new Move("Peste Negra",80);
		ataques[2]=new Move("Roer",30);
		ataques[3]=new Move("Arranhar",10);
		tipo = "Normal";
	}
}
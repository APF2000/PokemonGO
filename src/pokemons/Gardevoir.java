package pokemons;

import game.Move;
import game.Pokemon;

public class Gardevoir extends Pokemon {
	
	public Gardevoir() {
		nome = "Gardevoir";
		ataques[0]=new Move("Choque mental",50);
		ataques[1]=new Move("Confus�o",10);
		ataques[2]=new Move("Medo",30);
		ataques[3]=new Move("Dor de cabe�a",30);
		tipo = "Mind";
	}
}

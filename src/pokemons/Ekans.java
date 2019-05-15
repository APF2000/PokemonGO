package pokemons;

import game.Move;
import game.Pokemon;

public class Ekans extends Pokemon {

	public Ekans() {
		nome = "Ekans";
		ataques[0]=new Move("Veneno",70);
		ataques[1]=new Move("Mordida",20);
		ataques[2]=new Move("Esmargar",30);
		ataques[3]=new Move("Sufocar",10);
		tipo = "Poison";
	}
}
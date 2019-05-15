package pokemons;

import game.Move;
import game.Pokemon;

public class Gyarados extends Pokemon{
	
	public Gyarados() {
		nome = "Gyarados";
		ataques[0]=new Move("Jato de agua",10);
		ataques[1]=new Move("Onda",10);
		ataques[2]=new Move("Mordida",10);
		ataques[3]=new Move("Agua fervente",10);
		tipo = "Water";
	}
}

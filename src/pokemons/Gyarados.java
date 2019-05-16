package pokemons;

import game.Move;
import game.Pokemon;

public class Gyarados extends Pokemon{
	
	public Gyarados() {
		nome = "Gyarados";
		ataques[0]=new Move("Jato de agua",90);
		ataques[1]=new Move("Onda",90);
		ataques[2]=new Move("Mordida",90);
		ataques[3]=new Move("Agua fervente",90);
		tipo = "Water";
	}
}

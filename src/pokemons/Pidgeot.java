package pokemons;

import game.Move;
import game.Pokemon;

public class Pidgeot extends Pokemon{
	
	
	public Pidgeot() {
		nome = "Pidgeot";
		ataques[0]=new Move("Rasante",50);
		ataques[1]=new Move("Garras afiadas",20);
		ataques[2]=new Move("Bicadas",30);
		ataques[3]=new Move("Uivo",10);
		tipo="Flying";
	}
}

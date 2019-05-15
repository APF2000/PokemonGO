package pokemons;

import game.Move;
import game.Pokemon;

public class Spearow extends Pokemon {
	
	
	public Spearow() {
		nome = "Spearow";
		ataques[0]=new Move("Rasante",40);
		ataques[1]=new Move("Bicadas",20);
		ataques[2]=new Move("Agarrar e soltar",30);
		ataques[3]=new Move("penas afiadas",20);
		tipo = "Flying";
	}
}
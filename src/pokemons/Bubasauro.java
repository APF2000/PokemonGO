package pokemons;

import game.Move;
import game.Pokemon;

public class Bubasauro extends Pokemon{
	public Bubasauro() {
		nome = "Bubasauro";
		ataques[0]=new Move("Grama navalha",40);
		ataques[1]=new Move("Veneno",30);
		ataques[2]=new Move("desconforto",1);
		ataques[3]=new Move("mordida",20);
		tipo = "Grass";
		
	}
}

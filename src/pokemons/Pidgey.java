package pokemons;

import game.Move;
import game.Pokemon;

public class Pidgey extends Pokemon {
	
	public Pidgey() {
		nome = "Pidgey";
		ataques[0]=new Move("teste1",10);
		ataques[1]=new Move("teste2",10);
		ataques[2]=new Move("teste3",10);
		ataques[3]=new Move("teste4",10);
		tipo = "Flying";
	}
}
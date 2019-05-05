package pokemons;

import game.Move;
import game.Pokemon;

public class Pikachu extends Pokemon{
	public Pikachu () {
		nome = "Pikachu";
		Move[] ataques= {new Move("teste0",10),new Move("teste1",10), new Move("teste2",10),new Move("teste3",10)};
		tipo = "Electric";
	}
}

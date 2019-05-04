package br.usp.ime.mac0321.Pokemons;

import br.usp.ime.mac0321.PokemonGO.Move;
import br.usp.ime.mac0321.PokemonGO.Pokemon;

public class Pikachu extends Pokemon{
	public Pikachu () {
		nome = "Pikachu";
		ataques[0]=new Move("teste1",10);
		ataques[1]=new Move("teste2",10);
		ataques[2]=new Move("teste3",10);
		ataques[3]=new Move("teste4",10);
		tipo = "Electric";
	}
}

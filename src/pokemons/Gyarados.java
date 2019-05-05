<<<<<<< HEAD:src/br/usp/ime/mac0321/Pokemons/Gyarados.java
package br.usp.ime.mac0321.Pokemons;

import br.usp.ime.mac0321.PokemonGO.Move;
import br.usp.ime.mac0321.PokemonGO.Pokemon;
=======
package pokemons;
import game.Pokemon;
import game.Move;
>>>>>>> ed1812ffe0b0acec7a543371b11e45baba8b21e9:src/pokemons/Gyarados.java

public class Gyarados extends Pokemon{
	
	public Gyarados() {
		nome = "Gyarados";
		ataques[0]=new Move("teste1",10);
		ataques[1]=new Move("teste2",10);
		ataques[2]=new Move("teste3",10);
		ataques[3]=new Move("teste4",10);
		tipo = "Water";
	}
}

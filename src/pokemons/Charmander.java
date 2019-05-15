package pokemons;

import game.Move;
import game.Pokemon;

public class  Charmander extends Pokemon{	
	public Charmander() {
		nome = "Charmander";
		ataques[0]=new Move("Bola de fogo",35);
		ataques[1]=new Move("Rastejo de fogo",7);
		ataques[2]=new Move("Bafo de Fogo",18);
		ataques[3]=new Move("Ataque Padrao",19);
		tipo = "Fire";
	}
}

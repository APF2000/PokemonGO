package pokemons;

import game.Move;
import game.Pokemon;

public class Cubone extends Pokemon {
	public Cubone() {
		nome = "Cubone";
		ataques[0]=new Move("Ataque simples",40);
		ataques[1]=new Move("Cabeçada",60);
		ataques[2]=new Move("Mordida",30);
		ataques[3]=new Move("Batida",10);
		tipo = "Flying";
	}
}

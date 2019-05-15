package pokemons;

import game.Move;
import game.Pokemon;

public class Raychu extends Pokemon {
	
	public Raychu() {
		nome = "Raychu";
		ataques[0]=new Move("Choque do trovao",20);
		ataques[1]=new Move("Raio padrao",16);
		ataques[2]=new Move("Tempestade furiosa",80);
		ataques[3]=new Move("Corrente continua",20);
		tipo = "Eletric";
	}

}

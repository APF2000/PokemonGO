package pokemons;
import game.Pokemon;
import game.Move;

public class Pikachu extends Pokemon{
	Move[] ataques = new Move[4];
	public Pikachu () {
		nome = "Pikachu";
		ataques[0]=new Move("teste1",10);
		ataques[1]=new Move("teste2",10);
		ataques[2]=new Move("teste3",10);
		ataques[3]=new Move("teste4",10);
		tipo = "Electric";
	}
}

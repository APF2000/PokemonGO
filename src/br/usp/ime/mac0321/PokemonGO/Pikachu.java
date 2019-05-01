package br.usp.ime.mac0321.PokemonGO;

public class Pikachu extends Pokemon{
	final String nome = "Pikachu";
	final Move[] ataques= {new Move("teste0",10),new Move("teste1",10),new Move("teste2",10),new Move("teste3",10)};
	
	public Pikachu() {
		System.out.println("Naceu um pikachu");
	}
}

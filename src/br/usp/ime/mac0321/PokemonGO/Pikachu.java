package br.usp.ime.mac0321.PokemonGO;

public class Pikachu extends Pokemon{
	final String nome = "Pikachu";
	final Move[] ataques = {new Move("Raio simples",10), new Move("raio maximo",10), new Move("teste2",10), new Move("teste3",10) };
	
	public Pikachu() {
		System.out.println("Naceu um pikachu");
	}
}

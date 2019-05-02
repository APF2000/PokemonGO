package br.usp.ime.mac0321.PokemonGO;

public class Move {
	private String nome;
	private int dano;
	
	Move(String nome, int dano){
		this.nome=nome;
		this.dano=dano;
	}
	public int damage() {
		return(dano);
	}
	public String name() {
		return(nome);
	}
}

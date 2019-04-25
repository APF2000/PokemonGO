package br.usp.ime.mac0321.PokemonGO;

public class Pokemon {
	int life = 100;
	String nome;
	Move[] ataques = new Move[4]; 
	
	public String action(int num_act,Pokemon inimigo) {
		
		inimigo.attackDamage(ataques[num_act].damage());
		
		return(nome);
	}
	public void attackDamage (int dano) {
		life-=dano;
	}
	public String getNome() {
		return(nome);
	}
}

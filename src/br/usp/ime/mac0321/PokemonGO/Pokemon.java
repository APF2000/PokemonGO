package br.usp.ime.mac0321.PokemonGO;

abstract public class Pokemon {
	protected int hp;
	protected String nome;
	protected Move[] ataques = new Move[4];
	protected String tipo;
	
	
	public String action(int num_act,Pokemon inimigo) {
		inimigo.attackDamage(ataques[num_act].damage());		
		return(ataques[num_act].name());
	}
	public void attackDamage (int dano) {
		hp -= dano; 
	}
	public String getNome() {
		return(nome);
	}
	public int getHP() {
		return(hp);
	}
}
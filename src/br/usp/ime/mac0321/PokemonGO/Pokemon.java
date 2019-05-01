package br.usp.ime.mac0321.PokemonGO;

abstract class Pokemon {
	protected int hp;
	protected String nome;
	protected Move[] ataques = new Move[4]; 
	
	public Pokemon() {
		System.out.println("Nasceu um Pokemon");
	}
	
	public String action(int num_act,Pokemon inimigo) {
		
		inimigo.attackDamage(ataques[num_act].damage());
		
		return(nome);
	}
	public void attackDamage (int dano) {
		hp -= dano;
	}
	public String getNome() {
		return(nome);
	}
}
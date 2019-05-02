package br.usp.ime.mac0321.PokemonGO;

abstract public class Pokemon {
	protected int hp;
	protected String nome;
	protected Move[] ataques = new Move[4];
	protected String tipo;
	
	
	public String action(int num_act,Pokemon inimigo) {
		
		System.out.println("NUMERO; " + num_act );
		System.out.println("lenth " +ataques.length);
		System.out.println("inimigo " +inimigo.getNome());
		System.out.println("dano: " +ataques[0].damage());
		inimigo.attackDamage(5);
		
		return(nome);
	}
	public void attackDamage (int dano) {
		hp -= dano; 
	}
	public String getNome() {
		return(nome);
	}
}
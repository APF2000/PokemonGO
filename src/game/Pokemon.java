package game;

abstract public class Pokemon {
	protected int hp=100;
	protected String nome;
	protected Move[] ataques = new Move[4];
	protected String tipo;
	
	
	public String action(int num_act,Pokemon inimigo) {
		
		inimigo.attackDamage(ataques[num_act].damage());		
		return(ataques[num_act].getNome());
	}
	public void attackDamage (int dano) {
		hp -= dano; 
	}
	public String getNome() {
		return(nome);
	}
	public int getHp() {
		return(hp);
	}
	
	public void listaAtaques() {
		for(int i = 0; i < 4; i++) {
			System.out.println( i + ". " + ataques[i].getNome());
		}
	}
}
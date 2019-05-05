package game;

public class Move {
	private String nome;
	private int dano;
	
	public Move(String nome, int dano){
		this.nome=nome;
		this.dano=dano;
	}
	public int damage() {
		//System.out.println(dano);
		return(dano);
	}
	public String name() {
		return(nome);
	}
}

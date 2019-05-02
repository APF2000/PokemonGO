package br.usp.ime.mac0321.PokemonGO;

public class Treinador {
	private String nome;
	private Pokemon[] pokedex= new Pokemon[6];
	private int selecao = 0;
	private int indice_de_pokes = 0;
	
	public Treinador(String nome) {
		this.nome=nome;
	}
	
	public String getNome() {
		return(nome);
	}
	public String selectPoke (int selecao) {
		this.selecao=selecao;
		return(nome + " selecionou " + pokedex[selecao].getNome());
	}
	public void movimento (int num_mov,Pokemon alvo) {
		pokedex[selecao].action(num_mov, alvo);
	}
	
	public void addPoke (Pokemon poke) {
		pokedex[indice_de_pokes]= poke;
		indice_de_pokes++;
		System.out.println(nome+" adicionou " + 
				poke.getNome()+" na sua pokedex");
	}	
	public Pokemon selPoke () {
		return(pokedex[selecao]);
	}
}

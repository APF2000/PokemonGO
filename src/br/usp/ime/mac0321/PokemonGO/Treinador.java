package br.usp.ime.mac0321.PokemonGO;

public class Treinador {
	private String nome;
	private Pokemon[] pokedex= new Pokemon[6];
	private int selecao = 0;
	private int indice_de_pokes = 0;
	private Move[] inventario = new Move[5];
	private int inventIndex = 0;
	private boolean nojogo=true;
	
	
	
	public Treinador(String nome) {
		this.nome=nome;
	}
	
	public boolean noJogo() {
		if(proxComHp()!=-1) {
			return(nojogo);
		}
		else {
			return(false);
		}
	}
	private int proxComHp() {

		for(int i=0; i<6; i++) {
			if(pokedex[i].getHP()>0){
				selecao=i;
				return(i);
			}
		}
		return -1;
	}
	public String getNome() {
		return(nome);
	}
	
	public String selectPoke (int selecao) {
		this.selecao=selecao;
		return(pokedex[selecao].getNome());
	}
	
	public String movimentoPoke (int num_mov,Pokemon alvo) {
		String saida;
		//System.out.println("teste: " + alvo.getNome());
		saida = pokedex[selecao].action(num_mov, alvo);
		return("(" + nome + ") usou " + 
				pokedex[selecao].getNome() + " para atacar o adversario com "
				+ saida);
	}
	
	public void addPoke (Pokemon poke) {
		pokedex[indice_de_pokes]= poke;
		indice_de_pokes++;
		System.out.println("(" + nome + ") adicionou " + 
				poke.getNome()+" na sua pokedex");
	}	
	public Pokemon selPoke () {
		return(pokedex[selecao]);
	}

	public void addItem(Move item) {
		if(inventIndex < 4) {
			inventario[inventIndex] = item;
			inventIndex++;
		}
		else {
			System.out.println("Erro: invetario cheio. Nao foi possivel adicionar "
					+ item.name());
		}
	}
	
	public String usarItem(int num_item,Pokemon alvo) {
		alvo.attackDamage(inventario[num_item].damage());
		return("(" + nome + ") usou "
				+ inventario[num_item].name())+ " em " + alvo.getNome();
	}
	public String movimentoSelect(int sel1, int sel2,Pokemon alvo) {
		// sel1 diz que tipo de acao sera tomada(ataque, usar item, fugir ou trocar pokemon
		// sel2 especifica a acao de sel1 (ex: sel1 = ataque, sel2 = choque do trovao
		String saida="Error 404";
		if(sel1 == 0) {
			// Ataque
			saida=movimentoPoke (sel2,alvo);
		}
		else if(sel1==1) {
			// Item
			saida=usarItem(sel2, alvo);
		}
		else if(sel1==2) {
			// Fugir
			nojogo=false;
			saida=(nome +" fugiu da batalha");
		}
		else if(sel1==3) {
			// Trocar pokemon
			System.out.println("trocou" + sel2);
			selecao=sel2;
			System.out.println("trocou " + selecao);
			saida=(nome +" trocou o seu pokemon para " + pokedex[selecao].getNome());
		}
		return(saida);
	}
}

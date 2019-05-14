package game;
import pokemons.Bubasauro;
import pokemons.Caterpie;
import pokemons.Charmander;
import pokemons.Cubone;
import pokemons.Ekans;
import pokemons.Gardevoir;
import pokemons.Geodude;
import pokemons.Gyarados;
import pokemons.Pidgeot;
import pokemons.Pidgey;
import pokemons.Pikachu;
import pokemons.Poliwrath;
import pokemons.Raticate;
import pokemons.Rattata;
import pokemons.Raychu;
import pokemons.Sandshrew;
import pokemons.Spearow;
import pokemons.Squirtle;
import pokemons.Weedle;

public class Treinador{
	// Treinadores podem ser Pokemons sozinhos
	private String nome;
	private Pokemon[] pokedex;
	private int selecao=0;
	private int indice_de_pokes = 0;
	private Move[] inventario = new Move[5];
	private int inventIndex = 0;
	private boolean nojogo=true;



	public Treinador(String nome, boolean jogador) {
		this.nome=nome;
		
		// Jogador será true se o treinador treinado for 
		// a pessoa que controla o jogo.
		if(jogador == true) {
			pokedex = new Pokemon[6];
		}
		else {
			pokedex = new Pokemon[1];
		}
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
				if(pokedex[selecao].getHP()<0)
					selecao=i;
				return(i);
			}
		}
		return -1;
	}
	public String getNome() {
		return(nome);
	}
	
	public Pokemon selectedPoke () {
		return(pokedex[selecao]);
	}

	public void addPoke (Pokemon poke) {
		pokedex[indice_de_pokes]= poke;
		indice_de_pokes++;
		System.out.println("(" + nome + ") adicionou " + 
				pokedex[indice_de_pokes - 1].getNome()+" na sua pokedex");
	}	
	public void addPoke (String poke) {
		addPoke(whichPoke(poke));
		return;
	}
	public Pokemon whichPoke(String poke) {
		Pokemon[] list = new Pokemon[19];

		list[0] = new Weedle();
		list[1] = new Bubasauro();
		list[2] = new Caterpie();
		list[3] = new Charmander();
		list[4] = new Cubone();
		list[5] = new Ekans();
		list[6] = new Gardevoir();
		list[7] = new Geodude();
		list[8] = new Gyarados();
		list[9] = new Pidgeot();
		list[10] = new Pidgey();
		list[11] = new Pikachu();
		list[12] = new Poliwrath();
		list[13] = new Raticate();
		list[14] = new Rattata();
		list[15] = new Raychu();
		list[16] = new Sandshrew();
		list[17] = new Spearow();
		list[18] = new Squirtle();
		
		System.out.println("ate aqui de boa");

		for(int i = 0; i < 19; i++) {
			if(list[i].getNome().equalsIgnoreCase(poke)) {
				return list[i];
			}
		}
		return new Pikachu();
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
		while(num_item != 4 && inventario[num_item+1]!=null) {
			inventario[num_item]=inventario[num_item+1];
		}
		return("(" + nome + ") usou "
				+ inventario[num_item].name())+ " em " + alvo.getNome();
	}
	public String movimentoSelect(int sel1, int sel2, Pokemon alvo) {
		
		// sel1 diz que tipo de acao sera tomada(ataque, usar item, fugir ou trocar pokemon
		// sel2 especifica a acao de sel1 (ex: sel1 = ataque, sel2 = choque do trovao)
		String saida="Error 404-classe: treinador";
		
		// Ataque
		if(sel1 == 0) {
			saida=movimentoPoke (sel2,alvo);
		}
		
		// Item
		else if(sel1==1) {
			saida=usarItem(sel2, alvo);
		}
		
		// Trocar pokemon
		else if(sel1==2) {
			selecao=sel2;
			saida=("("+nome +") trocou o seu pokemon para " + pokedex[selecao].getNome()+"\n");
		}
		
		// Fugir
		else if(sel1==3) {
			nojogo=false;
			saida=(nome +" fugiu da batalha"+"\n");
		}

		return(saida);
	}
	


	public String movimentoPoke (int num_mov,Pokemon alvo) {
		String saida;
		//System.out.println("teste: " + selecao);
		saida = pokedex[selecao].action(num_mov, alvo);
		return("(" + nome + ") usou " + 
				pokedex[selecao].getNome() + " para atacar o adversario com "
				+ saida+"\n");
	}
}

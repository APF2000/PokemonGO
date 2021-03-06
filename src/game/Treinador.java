package game;
import pokemons.Bubasauro;
import pokemons.Caterpie;
import pokemons.Charmander;
import pokemons.Cubone;
import pokemons.Ekans;
import pokemons.Gardevoir;
import pokemons.Gyarados;
import pokemons.Pidgeot;
import pokemons.Pikachu;
import pokemons.Rattata;
import pokemons.Raychu;
import pokemons.Spearow;

public class Treinador {
	// Treinadores podem ser Pokemons sozinhos
	private String nome;
	private Pokemon[] pokedex;
	private int selecao=0;
	private int indice_de_pokes = 0;
	private Move[] inventario = new Move[5];
	private int inventIndex = 0;
	private boolean nojogo=true;

	private final int atacar = 0, item = 1, trocar = 2, fugir = 3;


	public Treinador(String nome, boolean jogador) {
		this.nome=nome;

		// Jogador ser� true se o treinador treinado for 
		// a pessoa que controla o jogo.
		if(jogador == true) {
			pokedex = new Pokemon[6];
			for(int i = 0; i < 5; i++) {
				inventario[i] = new Move("Pokebola com espinhos", 100);
			}
		}
		else {
			pokedex = new Pokemon[1];
			for(int i = 0; i < 5; i++) {
				inventario[i] = new Move("Casca de banana", 10);
			}
		}
	}

	public boolean noJogo() {
		if(proxComHp()==-1) {
			System.out.println(nome +" foi derrotado");
			nojogo=false;

		}
		return(nojogo);
	}
	public int proxComHp() {

		for(int i=0; i<6; i++) {
			if(pokedex[i].getHp()>0){
				if(pokedex[selecao].getHp()<=0)
					System.out.println(pokedex[selecao].getNome() + " de " + nome +" saiu do jogo\n" +
				pokedex[i].getNome() + " foi selecionado");
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
		Pokemon[] list = new Pokemon[12];

		list[0] = new Spearow();
		list[1] = new Bubasauro();
		list[2] = new Caterpie();
		list[3] = new Charmander();
		list[4] = new Cubone();
		list[5] = new Ekans();
		list[6] = new Gardevoir();
		list[7] = new Gyarados();
		list[8] = new Pidgeot();
		list[9] = new Pikachu();
		list[10] = new Rattata();
		list[11] = new Raychu();


		for(int i = 0; i < 12; i++) {
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
					+ item.getNome());
		}
	}

	public String usarItem(int num_item,Pokemon alvo) {
		alvo.attackDamage(inventario[num_item].damage());
		while(num_item != 4 && inventario[num_item+1]!=null) {
			inventario[num_item]=inventario[num_item+1];
		}
		return("(" + nome + ") usou "
				+ inventario[num_item].getNome())+ " em " + alvo.getNome();
	}


	public String movimentoPoke (int num_mov,Pokemon alvo) {
		String saida;
		//System.out.println("teste: " + selecao);
		if(alvo.getHp()>0) {
			saida = pokedex[selecao].action(num_mov, alvo);
			return("(" + nome + ") usou " + 
					pokedex[selecao].getNome() + " para atacar o adversario com "
					+ saida+"\n");
		}
		else {
			return("N�o foi possivel atacar");
		}
		
	}
	
	public String movimentoSelect(int sel1, int sel2, Pokemon alvo) {

		// sel1 diz que tipo de acao sera tomada(ataque, usar item, fugir ou trocar pokemon
		// sel2 especifica a acao de sel1 (ex: sel1 = ataque, sel2 = choque do trovao)
		String saida="Error 404-classe: treinador";

		// Ataque
		
		if(sel1 == atacar) {
			saida = movimentoPoke (sel2,alvo);
		}

		// Item
		else if(sel1 == item) {
			saida = usarItem(sel2, alvo);
		}

		// Trocar pokemon
		else if(sel1 == trocar) {
			selecao = sel2;
			saida = ("("+nome +") trocou o seu pokemon para " + pokedex[selecao].getNome()+"\n");
		}

		// Fugir
		else if(sel1 == fugir) {
			nojogo = false;
			saida = (nome +" fugiu da batalha"+"\n");
		}

		return(saida);
	}
}

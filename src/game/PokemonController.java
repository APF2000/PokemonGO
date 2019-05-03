package game;

public class PokemonController extends Controller{

	public PokemonController() {
		super();
	}
	private class Select extends Event{
		private String saida;
		Treinador a = new Treinador("Esponja");
		int selecao;

		public Select(Treinador a, int selecao) {
			this.a=a;
			this.selecao=selecao;
		}

		public void action() {
			saida=a.selectPoke(selecao);

		}

		public String description() {
			return ("(" + a.getNome() +") selecionou "+ saida);
		}

	}
	private class Acao extends Event{
		Treinador a;
		Treinador b;
		String move= "error 434:strign não recebida";
		int selecao1=0;
		int selecao2=0;

		public Acao(Treinador a, Treinador b, int selecao1,int selecao2) {
			this.a=a;
			this.b=b;
			this.selecao1=selecao1;
			this.selecao2=selecao2;
		}

		public void action() {
			if(a.noJogo()) {
				move=a.movimentoSelect(selecao1,selecao2,b.selPoke());	
			}
		}

		public String description() {

			return(move);
			/*return ("(" + a.getNome() + ") usou " + 
					a.selPoke().getNome() + " para atacar o "
					+ b.selPoke().getNome()+" de ("+ b.getNome() + ") com " + move);
			 */
		}

	}

	private class Restart extends Event {

		public String description() {
			return "";
		}

		private Treinador esponja = new Treinador("Bob esponja");
		private Treinador construtor = new Treinador("Bob, o construtor");


		public void action() {
			long tm = System.currentTimeMillis();

			esponja.addPoke(new Pikachu());
			esponja.addPoke(new Gyarados());
			esponja.addPoke(new Gardevoir());
			esponja.addPoke(new Caterpie());
			esponja.addPoke(new Pidgeot());
			esponja.addPoke(new Spearow());

			construtor.addPoke(new Bubasauro());
			construtor.addPoke(new Charmander());
			construtor.addPoke(new Rattata());
			construtor.addPoke(new Raychu());
			construtor.addPoke(new Cubone());
			construtor.addPoke(new Ekans());

			System.out.println("\nCOMECOU A BATALHA\n");
			addEvent(new Select(esponja,0));
			addEvent(new Select(construtor,0));
			addEvent(new Acao(esponja,construtor,0, 1));
			addEvent(new Acao(esponja,construtor,3, 1));
			addEvent(new Acao(esponja,construtor,0, 1));
			

		}

		public Restart(long time) {
			super(time);
		}
	}

	public void addEvent() {
		//System.out.println("Evento adicionado");
	}

	public static void main(String[] args) {

		PokemonController poke = new PokemonController();
		long tm = System.currentTimeMillis();
		poke.addEvent(poke.new Restart(tm));
		poke.run();
	}

}

package br.usp.ime.mac0321.PokemonGO;

public class PokemonController extends Controller{
		
	private class Restart extends Event {
		
		Treinador esponja = new Treinador("Bob esponja");
		Treinador construtor = new Treinador("Bob, o construtor");
		
		
		
		
		public Restart(long eventTime) {
			super(eventTime);
		}

		public void action() {
		
			long tm = System.currentTimeMillis();

			// Instead of hard-wiring, you could parse

			// configuration information from a text

			// file here:

			rings = 5;

			addEvent(new );

			addEvent(new LightOn(tm + 1000));

			addEvent(new LightOff(tm + 2000));

			addEvent(new WaterOn(tm + 3000));

			addEvent(new WaterOff(tm + 8000));

			addEvent(new Bell(tm + 9000));

			addEvent(new ThermostatDay(tm + 10000));

			// Can even add a Restart object!

			addEvent(new Restart(tm + 20000));

		}

		public String description() {

			return "Restarting system";

		}

	}
	
	public static void main(String[] args) {

		PokemonController poke = new PokemonController();
		long tm = System.currentTimeMillis();
		poke.addEvent(poke.new Restart(tm));
		poke.run();
	}
}

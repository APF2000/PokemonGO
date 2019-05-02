package br.usp.ime.mac0321.PokemonGO;

public class Controller {
	private EventSet es = new EventSet();
	
	public Controller() {
		//System.out.println("Controller");
	}
	
	public void addEvent(Event c) { 
		es.add(c);
	}
	
	public void run() {
		Event e = new Event();
		while((e = es.getNext()) != null) {
			if(e.ready()) {
				e.action();
				System.out.println(e.description());
				es.removeCurrent();
			}
		}
	}
}
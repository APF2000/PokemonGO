package br.usp.ime.mac0321.PokemonGO;
	
	
abstract public class Event {
	private long evtTime;
	public Event(long eventTime) {
		evtTime = eventTime;
	}
	
	public boolean ready() {
		return System.currentTimeMillis() >= evtTime;
	}
	
	public Event() {
		System.out.println("bora");
	}
	
	abstract public void action();
	abstract public String description();
}


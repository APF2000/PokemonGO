package br.usp.ime.mac0321.PokemonGO;
	
	
public class Event {
	private long evtTime;
	
	public Event(long eventTime) {
		evtTime = eventTime;
	}	
	public Event() {
		//System.out.println("bora");
	}
	
	public void setTime(long tm) {
		evtTime = tm;
	}
	
	public boolean ready() {
		return System.currentTimeMillis() >= evtTime;
	}
	
	public void action() {}
	public String description() {
		return "description";
	}
}
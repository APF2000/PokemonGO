package game;
	
	
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
	
	protected void prioridade() {}
	public String description() {
		return "description";
	}
}
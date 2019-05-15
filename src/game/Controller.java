package game;

public class Controller {
	private EventSet es = new EventSet();
	
	public Controller() {}
	
	public void addEvent(Event c) { 
		es.add(c);
	}
	
	public void run() {
		Event e = new Event();
		while((e = es.getNext()) != null) {
			if(e.ready()) {
				e.prioridade();
				System.out.println(e.description());
				es.removeCurrent();
			}
		}
	}
}
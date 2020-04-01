import java.util.ArrayList;
import java.util.List;

public class Subject {
	
	private List<Observer> observers = new ArrayList<Observer>();
	private int state;
	
	public int getstate() {
		return state;
	}
	
	public void setstate(int state) {
		this.state = state;
		notifyAllObservers();	
	}
	
	public void attach(Observer observer) {
		observers.add(observer);
	}
	
	public void notifyAllObservers() {
		for(Observer observer:observers) {
			observer.update();
		}
	}
}



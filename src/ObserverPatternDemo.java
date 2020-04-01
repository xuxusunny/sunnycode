
public class ObserverPatternDemo {
	public static void main(String[] args) {
		Subject subject = new Subject();
		new OneObserver(subject);
		new TwoObserver(subject);
		
		subject.setstate(3);
	}

}

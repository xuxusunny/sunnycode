
public class TwoObserver extends Observer {

	public TwoObserver(Subject subject) {
		// TODO Auto-generated constructor stub
		this.subject = subject;
		this.subject.attach(this);
	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		System.out.println("TwoObserver:"+Integer.toBinaryString(subject.getstate()));
		
	}

}

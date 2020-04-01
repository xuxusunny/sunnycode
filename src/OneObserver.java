
public class OneObserver extends Observer {
	
	public OneObserver(Subject subject) {
		// TODO Auto-generated constructor stub
		this.subject = subject;
		this.subject.attach(this);
	}
	@Override
	public void update() {
		// TODO Auto-generated method stub
		System.out.println("OneObsever:"+ Integer.toBinaryString(subject.getstate()));
		
	}

}

package core_java.chap_04;

public class ConcurrentWorker extends Worker {

	public ConcurrentWorker() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void work() {
		System.out.println("Concurrent worker");
		Thread t = new Thread(super::work);
		t.start();
	}

}

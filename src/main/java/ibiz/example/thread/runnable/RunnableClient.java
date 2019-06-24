package ibiz.example.thread.runnable;

public class RunnableClient implements Runnable {

	private String test1;
	private int index = 0;
	public RunnableClient(String test1) {
		this.test1 = test1;
	}
	
	@Override
	public void run() {
		while(index < 5) {
			System.out.println(Thread.currentThread().getName() + "::" +test1+index);
			index++;
		}
	}

}

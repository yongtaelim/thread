package ibiz.example.thread.runnable;

import java.io.InputStream;

public class RunnableClass {

	private InputStream input;
	
	public RunnableClass(InputStream input) {
			this.input = input;
	}
	
	public void start() {
		for (int i = 0; i < 10; i++) {
			Thread thread = new Thread(new RunnableStreamClient(input));
			
			thread.start();
		}
	}
}

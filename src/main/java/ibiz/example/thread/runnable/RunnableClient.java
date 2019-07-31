package ibiz.example.thread.runnable;

import ibiz.example.thread.common.Sync;
import ibiz.example.thread.data.ThreadTestData;

public class RunnableClient implements Runnable {

	private long waitTime;
	private Sync sync;
	
	private int index = 0;
	public RunnableClient(long waitTime, Sync sync) {
		this.waitTime = waitTime;
		this.sync = sync;
	}
	
	@Override
	public void run() {
		while(index < 3) {
			sync.syncMethod(Thread.currentThread().getName(), waitTime);
			index++;
		}
		ThreadTestData.running++;
	}
	
	

}

package ibiz.example.thread.runnable;

import ibiz.example.thread.handler.callback.ThreadListener;

public class ListenerRunnable implements Runnable {
	private ThreadListener listener;
		
	public ListenerRunnable(ThreadListener listener) {
		this.listener = listener;
	}
	
	@Override
	public void run() {
		try {
			listener.completed("성공했다네!!!");
			Thread.sleep(5000L);
			listener.completed("5초 후....");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
}

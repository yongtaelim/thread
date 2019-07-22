package ibiz.example.thread.common;

public class Sync {
	public synchronized String syncMethod(String threadName, long waitTime) {
		try {
			Thread.sleep(waitTime);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(threadName);
		return threadName + "syncMethod";
	}
}

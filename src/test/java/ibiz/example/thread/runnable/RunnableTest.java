package ibiz.example.thread.runnable;

import org.junit.Ignore;
import org.junit.Test;

import ibiz.example.thread.runnable.RunnableCallbackClient;
import ibiz.example.thread.runnable.RunnableClient;

public class RunnableTest {
	
	@Test
	@Ignore
	public void makeThread() {
		String[] threadNames = {"thread1", "thread2", "thread3", "thread4"}; 
		for(String name : threadNames) {
			Thread t1 = new Thread(new RunnableClient(name + "test"));
			
			t1.setName(name);
			t1.start();
		}
	}
	
	@Test
	public void CompleteHandlerTest() {
		RunnableCallbackClient handler = new RunnableCallbackClient();
		handler.doWork("test");
		handler.doWork("test1");
	}
}

package ibiz.example.thread.client;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.assertj.core.util.Arrays;

import ibiz.example.thread.handler.callback.ThreadListener;
import ibiz.example.thread.runnable.ListenerRunnable;

public class ThreadListenerClient  {
	
	private Set<Thread> threads;
	
	public ThreadListenerClient(Map<String, ThreadListener> listenerMap) {
		threads = new HashSet<Thread>();
		
		for(String key : listenerMap.keySet()) {
			Thread thread = new Thread(new ListenerRunnable(listenerMap.get(key)));
			thread.setName(key);
			threads.add(new Thread(new ListenerRunnable(listenerMap.get(key))));
		}
	}
	
	public void run() throws InterruptedException {
		for(Thread thread : threads) {
			//run을 사용하면 안된다. ( 클래스에 오버라이딩 된 메소드를 호출해서 사용하는 것 뿐 )
//			thread.run();
			thread.start();
		}
		
		while(true) {
			List<Boolean> threadAlives = new ArrayList<Boolean>();
			for(Thread thread : threads) 
				threadAlives.add(thread.isAlive());
			
			if(!threadAlives.contains(true))
				break;
			
			TimeUnit.SECONDS.sleep(2L);
		}
	}
}

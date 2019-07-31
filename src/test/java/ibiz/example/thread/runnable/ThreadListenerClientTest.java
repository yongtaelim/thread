package ibiz.example.thread.runnable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import org.assertj.core.util.Arrays;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ibiz.example.thread.client.ThreadListenerClient;
import ibiz.example.thread.handler.callback.ThreadListener;

public class ThreadListenerClientTest {
	
	private ThreadListenerClient threadListenerClient;
	
	
	private Logger logger = LoggerFactory.getLogger(ThreadListenerClientTest.class);
	
	@Before
	@Ignore
	public void setUp() {
		Map<String, ThreadListener> listenerMap = new HashMap<String, ThreadListener>();
		String[] threadNames = {"thread1", "thread2", "thread3"};
		
		for(String threadName : threadNames) 
			listenerMap.put(threadName, getHandler(threadName));
		
		threadListenerClient = new ThreadListenerClient(listenerMap);
	}
	
	@Test
	@Ignore
	public void runTest() throws InterruptedException {
		threadListenerClient.run();
	}
	
	private ThreadListener getHandler(String threadName) {
		return new ThreadListener() {
			@Override
			public void completed(String msg) {
				logger.info("Success!!!   Thread name is {}....., message :: {}", threadName, msg);
			}

			@Override
			public void failed(String msg) {
				logger.info("Failed!!!      Thread name is {}....., message :: {}", threadName, msg);
			}
		}; 
	}
}

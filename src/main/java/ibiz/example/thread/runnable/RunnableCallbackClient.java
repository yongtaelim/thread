package ibiz.example.thread.runnable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import ibiz.example.thread.handler.callback.CallbackHandler;
import ibiz.example.thread.handler.callback.YongCompletionHandlerInterface;

public class RunnableCallbackClient {
	private ExecutorService executorService;
	private CallbackHandler handler;
		
	public RunnableCallbackClient(CallbackHandler handler) {
		this.executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
		this.handler = handler;
	}
	
	public void doWork(String test) {
		Runnable task = new Runnable() {

			@Override
			public void run() {
				int index = 0;
				System.out.println(test);
				String testArray[] = {"test1", "test2","test3", "test4"};
				for(String testString : testArray) {
					System.out.println(testString);
					if(test.equals("test")) {
						handler.callback.completed(index, null);
						handler.callback.completed("Yong Complete handler Test!!!");						
					}
					else
						handler.callback.failed(new Exception(), null);
					index++;
				}
			}
		};
		executorService.submit(task);
	}
	
	 public void finish() {
		  executorService.shutdown();
	 }
}

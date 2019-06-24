package ibiz.example.thread.runnable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import ibiz.example.thread.handler.callback.Callback;

public class RunnableCallbackClient {
	private ExecutorService executorService;
		
	public RunnableCallbackClient() {
		executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
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
						Callback.callback.completed(index, null);
						Callback.callback.completed("Yong Complete handler Test!!!");						
					}
					else
						Callback.callback.failed(new Exception(), null);
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

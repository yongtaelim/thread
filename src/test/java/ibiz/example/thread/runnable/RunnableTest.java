package ibiz.example.thread.runnable;

import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;

import ibiz.example.thread.common.Sync;
import ibiz.example.thread.data.ThreadTestData;
import ibiz.example.thread.handler.callback.CallbackHandler;
import ibiz.example.thread.handler.callback.YongCompletionHandlerInterface;
import ibiz.example.thread.runnable.RunnableCallbackClient;
import ibiz.example.thread.runnable.RunnableClient;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RunnableTest {

	private String[] threadNames = {"thread1", "thread2", "thread3"};
	private long[] timeWaits = {1000L, 2000L, 500L};
	
	@Test
	@Ignore
	public void makeThread() {
		
		//synchronized 테스트를 위한 클래스
		Sync sync = new Sync();
		
		/**
		 * 테스트 내용 
		 * 4개의 쓰레드를 생성 후 sync 클래스를 호출
		 * sync의 메소드 사용시간은 각 쓰레드마다 다르다.
		 */
		for (int i = 0; i < timeWaits.length; i++) {
			Thread t1 = new Thread(new RunnableClient(timeWaits[i], sync));
			
			t1.setName(threadNames[i]);
			t1.start();
			
		}
		
		/**
		 * 호출 결과
		 * thread1이 sync 클래스 사용중일 때에는 다른 Thread이 사용하지 못한다.
		 */
		
		while(true) {
			if(ThreadTestData.running == 4)
				return;
		}
	}
	
	@Test
//	@Ignore
	public void CompleteHandlerTest() {
		CallbackHandler callback = new CallbackHandler();
		
		RunnableCallbackClient handler = new RunnableCallbackClient(callback);
		handler.doWork("test");
		handler.doWork("test1");
	}
}

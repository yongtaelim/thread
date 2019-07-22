package ibiz.example.thread.handler.callback;

import java.nio.channels.CompletionHandler;

public interface YongCompletionHandlerInterface extends CompletionHandler<Object, Object>{
	public static String a = "";
	String b = "";
	
	default void setTest(String a, String b) {
	}
	
	default String getATest() {
		return a;
	};
	
	default String getBTest() {
		return b;
	};
}

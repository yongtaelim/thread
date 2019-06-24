package ibiz.example.thread.handler.callback;

import java.nio.channels.CompletionHandler;

public class YongCompletionHandler implements CompletionHandler<Object, Object>{
	public void completed(String result) {
		System.out.println(result);
	}

	@Override
	public void completed(Object result, Object attachment) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void failed(Throwable exc, Object attachment) {
		// TODO Auto-generated method stub
		
	}

}

package ibiz.example.thread.handler.callback;

public interface ThreadListener {
	void completed(String msg);
	
	void failed(String msg);
}

package ibiz.example.thread.handler.callback;

public class CallbackHandler {
	public YongCompletionHandler callback = new YongCompletionHandler() {
		public void completed(String result) {
			System.out.println(result);
		}
	};
}

package ibiz.example.thread.handler.callback;

public class Callback {
	public static YongCompletionHandler callback = new YongCompletionHandler() {

		public void completed(String result) {
			System.out.println(result);
		}
	};
}

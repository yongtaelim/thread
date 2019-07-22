package ibiz.example.thread.runnable;

import java.io.InputStream;

import ibiz.example.thread.common.IOUtil;

public class RunnableStreamClient implements Runnable {

	private InputStream input;
	
	public RunnableStreamClient(InputStream input) {
		this.input = input;
	}
	
	@Override
	public void run() {
//		long copy = IOUtil.copy(input, output);
//		System.out.println(copy);
		byte[] byteArray = IOUtil.toByteArray(input);
		System.out.println(byteArray.length);
	}

}

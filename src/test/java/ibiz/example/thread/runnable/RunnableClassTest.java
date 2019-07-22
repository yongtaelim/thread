package ibiz.example.thread.runnable;

import java.io.ByteArrayInputStream;

import org.junit.Before;
import org.junit.Test;

public class RunnableClassTest {

	private RunnableClass RunnableClass;
	
	@Before
	public void setUp() {
		String a = "adfasdafasdf";
		ByteArrayInputStream input = new ByteArrayInputStream(a.getBytes()); 
		this.RunnableClass = new RunnableClass(input);
	}
	
	@Test
	public void startTest() {
		RunnableClass.start();
	}
}

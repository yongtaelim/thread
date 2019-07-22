package ibiz.example.thread.common;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class IOUtil {
	/** maximum buffer to be read is 16 KB. */
	private static final int MAX_BUFFER_LENGTH = 16384;

	/** Returns the byte array. */
	public static byte[] toByteArray(InputStream in) {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		copy(in, out);
		return out.toByteArray();
	}
	
	public synchronized static long copy(InputStream from, OutputStream to) {
		byte[] buf = new byte[MAX_BUFFER_LENGTH];
	    long total = 0;
	    try {
		    while (true) {
		    	int r;
					r = from.read(buf);
		    	if (r == -1) {
		    		break;
		    	}
		    	to.write(buf, 0, r);
		    	total += r;
		    }
	    } catch (IOException e) {
	    	// TODO Auto-generated catch block
	    	e.printStackTrace();
	    } finally {
	    	try {
				from.reset();
			} catch (IOException e) {
			}
		}
	    return total;
	}
}

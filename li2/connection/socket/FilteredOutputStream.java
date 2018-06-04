package connection.socket;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class FilteredOutputStream<T> extends ObjectOutputStream {

	FilteredOutputStream(OutputStream i) throws IOException {
		super(i);
	}
	
	@SuppressWarnings("unchecked")
	public void writeObjectOverride(Object t) throws IOException {
		try {
			T cast = (T) t;
			super.writeObject(cast);
		} catch (ClassCastException c) {
			throw new IllegalArgumentException("Object needs to be castable to the parameterized type of this stream!");
		}
	}
	
	
}

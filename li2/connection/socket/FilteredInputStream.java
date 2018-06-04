package connection.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

public class FilteredInputStream<T> extends ObjectInputStream {

	protected FilteredInputStream(InputStream i) throws IOException, SecurityException {
		super(i);
		// 
	}
	
	@SuppressWarnings("unchecked")
	public final T readObjectOverride() throws ClassNotFoundException, IOException {
		Object info = super.readObject();
		try {
			T converted = (T) info;
			return converted;
		} catch (ClassCastException c) {
			throw new ClassNotFoundException("The inputStream returned an input that doesn't coorespond to the parameterized type of this stream.");
		}
	}

}

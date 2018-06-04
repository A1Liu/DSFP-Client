package connection;

import java.io.Serializable;

public abstract class Packet implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final Object[] data;
	private final int tag;
	
	protected Packet(int tag, Object... data) {
		this.data = data;
		this.tag = tag;
	}
	
	public int getTag() {
		return tag;
	}
	
	public Object[] getData() {
		return data;
	}
}

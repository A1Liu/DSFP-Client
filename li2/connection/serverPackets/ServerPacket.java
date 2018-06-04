package connection.serverPackets;

import connection.Packet;

/**
 * Object that holds information in a way that can be interpreted easily by server and client
 * @author aliu
 *
 */
public class ServerPacket extends Packet {
	
	private static final long serialVersionUID = 1L;

	
	public ServerPacket(int label, Object... data) {
		super(label,data);
	}
}
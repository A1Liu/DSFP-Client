package server;

import static util.Const.SERVER_IP;
import static util.Const.SERVER_PORT;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ConnectException;
import java.net.Socket;

import connection.clientRequests.ClientRequest;
import connection.serverPackets.ServerPacket;
import data.queue.*;

public class Connection extends Thread {
	
	private Socket socket;
	private ObjectOutputStream out;
	private ObjectInputStream in;
	private volatile Queue<ServerPacket> received;
	private volatile boolean connected;
	
	public Connection() {
		received = new Queue<ServerPacket>();
		connected = false;
		
	}
	
	public void run() {
		System.out.println( "Connection: Loading contents of URL: " + SERVER_IP );
		try {
            // Connect to the server
            socket = new Socket( SERVER_IP, SERVER_PORT );
	        out = new ObjectOutputStream( socket.getOutputStream() );
	        out.writeObject("Header");
	        out.flush();
	       	in = new ObjectInputStream( socket.getInputStream() );
	       	in.readObject();
	       	connected = true;
        } catch (ConnectException c) {
        	System.out.println("Connection: Couldn't connect!");
        	connected = false;
        } catch( Exception e ) {
            e.printStackTrace();
        }
	}
	
	public synchronized void sendPacket(ClientRequest request) {
		 // Create input and output streams to read from and write to the server
		System.out.println("albert");
				try {
	
					System.out.println("Something to send");
					out.writeObject(request);
					out.flush();
					Thread.sleep(1000);
					System.out.println("Sent something!");
					Object packet = in.readObject();
					if (packet instanceof ServerPacket) {
						ServerPacket serverPacket = (ServerPacket) packet;
						received.add(serverPacket);
					} else {
						disconnect();
					}
				} catch (IOException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
	}
	
	public boolean hasReceived() {
		return !received.isEmpty();
	}
	
	public synchronized ServerPacket receivePacket() {
		int counter = 0;
		boolean sentinel = received.isEmpty();
		while (sentinel) {
			if (counter > 15)
				sentinel= false;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			counter++;
		}
		return received.poll();
	}
	
	public void disconnect() {
		try {
			if (in != null) in.close();
			if (out != null) out.close();
			if (socket != null) socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		connected = false;
	}
	
	
	public boolean isConnected() {
		return connected;
	}
}

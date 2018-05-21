package server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import static util.Const.*;

public class ExampleClient {
    public static void main( String[] args ) {

        System.out.println( "Loading contents of URL: " + SERVER_IP );

        try {
            // Connect to the server
            Socket socket = new Socket( SERVER_IP, SERVER_PORT );

            // Create input and output streams to read from and write to the server
            PrintStream out = new PrintStream( socket.getOutputStream() );
            BufferedReader in = new BufferedReader( new InputStreamReader( socket.getInputStream() ) );

            BufferedReader consoleLine;
            boolean on = true;
            String userIn;
            while (on) {
            	consoleLine = new BufferedReader (new InputStreamReader(System.in) );
            	userIn = consoleLine.readLine();
            	if (userIn.equals("stop")) {
            		on = false;
            	} else {
            		out.println(userIn);
            		String line = in.readLine();
                    while( line != null) {
                        System.out.println( line );
                        line = in.readLine();
                    }
            	}
            	if(!on) {
            		in.close();
            		out.close();
            		socket.close();
            	}
            }
        } catch( Exception e ) {
            e.printStackTrace();
        }
    }
}

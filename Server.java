import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			ServerSocket listener = new ServerSocket(8008);
			while(true){
				//this waits (blocks) until a client tries to connect to this machine on port 8808
				Socket clientConnection = listener.accept();
				//gives us a data structure that the client will send us messages from
				OutputStream  fromClient = clientConnection.getOutputStream();
				PrintWriter out = new PrintWriter(fromClient, true);
				
				InputStream in = clientConnection.getInputStream();
				BufferedReader streamFromServer = new BufferedReader(new InputStreamReader(in));
				String message = streamFromServer.readLine();
				
				System.out.println(clientConnection.getInetAddress() +": " +message);
				
				out.println(message);
				
				clientConnection.close();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

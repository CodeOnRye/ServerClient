import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;


public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Socket connectionToServer = new Socket("IP.ADDR", 3823);
			
			OutputStream  fromClient = connectionToServer.getOutputStream();
			PrintWriter out = new PrintWriter(fromClient, true);
			out.println("nooo!!!");
			
			
			
			
			
			InputStream in = connectionToServer.getInputStream();
			BufferedReader streamFromServer = new BufferedReader(new InputStreamReader(in));
			String message = streamFromServer.readLine();
			
			System.out.println(message);
			connectionToServer.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

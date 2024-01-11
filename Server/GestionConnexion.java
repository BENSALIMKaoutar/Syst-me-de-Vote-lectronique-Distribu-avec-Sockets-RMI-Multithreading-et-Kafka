import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class GestionConnexion implements Runnable{
	
	private Socket socket;

    public GestionConnexion(Socket clientSocket) {
        socket = clientSocket;
    }
	
	
	 @Override
	    public void run() {
		 try {
	        	BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	    		
					System.out.println(br.readLine());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					System.out.println("Prob en gestion connexion");
				}
	               

	                try {
						socket.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	            
	        }
	    }



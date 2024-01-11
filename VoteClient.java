import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.Socket;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class VoteClient {
	public static void main(String[] args) throws IOException {
        	int ID=3;
        	Vote obj = null;
			try {
				obj = (Vote) java.rmi.Naming.lookup("rmi://localhost/A");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	if (obj.Authentifier(ID)) {
        		System.out.println("Authentification réussie ! ");
        		Socket socket = new Socket("localhost", 12345);
                //ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                //ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

                System.out.println("Connexion établie avec le serveur Socket");
                writer.println("Voilà mon choix:  ksfvn");
                writer.flush();
                
        		
        	}
        	else System.out.println("Echec d'authentification !");
        		
        		
            
            
        
    }

}

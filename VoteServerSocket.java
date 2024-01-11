import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class VoteServerSocket {
	public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(12345);
            System.out.println("Serveur Socket prêt...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                new Thread(new GestionConnexion(clientSocket)).run();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
	}

}

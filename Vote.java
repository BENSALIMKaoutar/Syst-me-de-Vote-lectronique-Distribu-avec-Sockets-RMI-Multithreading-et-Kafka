import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Vote extends Remote {
	boolean Authentifier(int ID) throws RemoteException;

}

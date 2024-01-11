import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VoteServer extends UnicastRemoteObject implements Vote {
	List<Integer> identifiants=new ArrayList<Integer>();

	protected VoteServer(List args) throws RemoteException {
		super();
		identifiants=args;
	}

	@Override
	public boolean Authentifier(int ID) throws RemoteException {
		if (identifiants.contains(ID)) {
			return true;	
		}
		else return false;
		
	}
	
	public static void main(String[] args) {
        try {
        	java.rmi.registry.LocateRegistry.createRegistry(1099);
        	
        	List<Integer> liste = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
            VoteServer obj = new VoteServer(liste);
            java.rmi.Naming.rebind("rmi://localhost/A", obj);
            System.out.println("Serveur RMI prêt...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

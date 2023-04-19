import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class MainServer {
    public static void main(String[] args) throws RemoteException, MalformedURLException {		
		System.setProperty("java.rmi.server.hostname","127.0.0.1");		
		ServerInterface server = new Server();
		LocateRegistry.createRegistry(1098);		
		Naming.rebind("rmi://127.0.0.1:1098/ServerGroups", server);		
		System.out.println("ServerGroups Starterd.");		
	}
}

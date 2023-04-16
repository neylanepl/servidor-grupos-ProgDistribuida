import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class MainClient {
    public static void main(String[] args) throws RemoteException, MalformedURLException, NotBoundException {
		ServerInterface server = (ServerInterface) 
				Naming.lookup("rmi://127.0.0.1:1098/ServerCallbak");
		ClientInterface client = new Client();
        int idClient = server.registerClient(client);   
        GUI.principalMenu(server, idClient);
    }
}
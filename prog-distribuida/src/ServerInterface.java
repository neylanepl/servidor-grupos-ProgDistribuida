import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServerInterface extends Remote {
    public int registerClient(ClientInterface client) throws RemoteException;
    public int createGroup(String name, int idMember) throws RemoteException;
    public int addMember(int idGroup, int idMember) throws RemoteException;    
    public boolean removeMember(int idGroup, int idMember) throws RemoteException;
    public int sendMessage(int idGroup, int idMember) throws RemoteException;
}

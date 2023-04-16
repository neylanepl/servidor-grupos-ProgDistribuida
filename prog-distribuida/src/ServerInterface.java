import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServerInterface extends Remote {
    public void registerClient(ClientInterface client) throws RemoteException;
    int createGroup(int idGroup, int idMember) throws RemoteException;
    int addMember(int idGroup, int idMember) throws RemoteException;    
    boolean removeMember(int idGroup, int idMember) throws RemoteException;
    int sendMessage(int idGroup, int idMember) throws RemoteException;
}

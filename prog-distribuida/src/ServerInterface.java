import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServerInterface extends Remote {
    public int registerClient(ClientInterface client) throws RemoteException;
    public int createGroup(String name, Member creator) throws RemoteException;
    public boolean addMember(int idGroup, Member member) throws RemoteException;    
    public boolean removeMember(int idGroup, int idMember) throws RemoteException;
    public boolean sendMessage(int idGroup, int idMember, String text) throws RemoteException;
    public void distributeMessages(int idGroup, int idMember) throws RemoteException;
}

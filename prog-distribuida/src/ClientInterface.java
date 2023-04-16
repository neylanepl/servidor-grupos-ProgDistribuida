import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ClientInterface extends Remote {
    int sendMessageToGroup(int idGroup, int idMember, Message message) throws RemoteException;
    byte[] receiveMessage(int idGroup) throws RemoteException;
}

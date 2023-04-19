import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface ClientInterface extends Remote {
    public void sendMessageToGroup(List<Message> messages) throws RemoteException;
}

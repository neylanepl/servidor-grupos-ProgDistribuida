import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class Client extends UnicastRemoteObject implements ClientInterface {
    protected Client() throws RemoteException {
        super();
    }

    @Override
    public void sendMessageToGroup(List<Message> messages) throws RemoteException {
        for(Message message : messages) {
            System.out.println(message.toString());
        }
    }
}

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Client extends UnicastRemoteObject implements ClientInterface {
    protected Client() throws RemoteException {
        super();
    }

    @Override
    public int sendMessageToGroup(int idGroup, int idMember, Message message) throws RemoteException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'sendMessageToGroup'");
    }

    @Override
    public byte[] receiveMessage(int idGroup) throws RemoteException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'receiveMessage'");
    }
}

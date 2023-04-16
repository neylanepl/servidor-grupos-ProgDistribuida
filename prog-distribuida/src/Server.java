import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Server extends UnicastRemoteObject implements ServerInterface {
    protected Server() throws RemoteException {
        super();
        //TODO Auto-generated constructor stub
    }

    @Override
    public void registerClient(ClientInterface client) throws RemoteException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'registerClient'");
    }

    @Override
    public int createGroup(int idGroup, int idMember) throws RemoteException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createGroup'");
    }

    @Override
    public int addMember(int idGroup, int idMember) throws RemoteException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addMember'");
    }

    @Override
    public boolean removeMember(int idGroup, int idMember) throws RemoteException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeMember'");
    }

    @Override
    public int sendMessage(int idGroup, int idMember) throws RemoteException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'sendMessage'");
    }
}

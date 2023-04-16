import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class Server extends UnicastRemoteObject implements ServerInterface {
    private volatile List<ClientInterface> clients = new ArrayList<ClientInterface>();
    private volatile List<Group> groups = new ArrayList<Group>();
    
    protected Server() throws RemoteException {
        super();
    }

    @Override
    public int registerClient(ClientInterface client) throws RemoteException {
        clients.add(client);
		System.out.println("Novo cliente registrado com sucesso! Total: "+clients.size());
        return clients.indexOf(client);
    }

    @Override
    public int createGroup(String name, Member creator) throws RemoteException {
        Group temp = new Group(name, groups.size()+1, creator);
        groups.add(temp);
		System.out.println("Novo grupo registrado com sucesso! Total: "+groups.size());
        System.out.println("Nome do grupo: "+name);
        return groups.size();
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

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
        Group temp = new Group(name, groups.size(), creator);
        groups.add(temp);
		System.out.println("Novo grupo registrado com sucesso! Total: "+groups.size());
        System.out.println("Nome do grupo: "+name);
        return groups.size();
    }

    @Override
    public boolean addMember(int idGroup, Member member) throws RemoteException {
        Group group = groups.get(idGroup);
        if(group != null) {
            group.addMember(member);
            System.out.println("Novo membro adicionado com sucesso! Total: "+group.getMembersNumber());
            System.out.println("Novo membro: "+member.getName());
            return true;
        }
        return false;
    }

    @Override
    public boolean removeMember(int idGroup, int idMember) throws RemoteException {
        Group group = groups.get(idGroup);
        if(group != null) {            
            group.removeMember(idMember);
            System.out.println("Membro retirado com sucesso! Total: "+group.getMembersNumber());
            return true;
        }
        return false;
    }

    @Override
    public boolean sendMessage(int idGroup, int idMember, String text) throws RemoteException {
        Group group = groups.get(idGroup);
        Member member = group.getMemberById(idMember);
        if(group != null) {
            if(member != null) {
                group.addMessage(new Message(text, member, idGroup));
                System.out.println("Mensagem enviada com sucesso! Total: "+group.getMessagesNumber());
                return true;
            }
        }
        return false;
    }
}

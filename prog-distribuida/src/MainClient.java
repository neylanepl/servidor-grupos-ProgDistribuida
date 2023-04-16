import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class MainClient {
    public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
        Scanner sc = new Scanner(System.in);
        boolean menu = true;
        int idGroup, idMember;

		ServerInterface server = (ServerInterface) 
				Naming.lookup("rmi://127.0.0.1:1098/ServerCallbak");

		ClientInterface client = new Client();

        while (menu) {
            System.out.println("Escolha uma das opções.");
            System.out.println("1. Registrar usuário\n"
                    + "2. Criar novo grupo\n"
                    + "3. Adicionar membro a um grupo\n"
                    + "4. Remover membro de um grupo\n"
                    +  "5. Enviar mensagem a um grupo \n"
                    + "6. Sair");
            System.out.println("Digite a opção:");

            switch (sc.nextInt()) {
                case 1:
                    System.out.println("\t_______________REGISTRAR USUÁRIO_______________");

                    server.registerClient(client);

                    System.out.println("Usário adicionado!");
                    System.out.println("\t---------------------------------------------------");

                    break; 
                case 2:
                    System.out.println("\t_______________CRIAR GRUPO_______________");
                    System.out.printf("Insira o ID do grupo: ");
                    idGroup=sc.nextInt();

                    System.out.printf("Insira o ID do proprietario: ");
                    idMember=sc.nextInt();

                    server.createGroup(idGroup, idMember);

                    System.out.println("Grupo criado!");
                    System.out.println("\t---------------------------------------------------");
                        
                    break;

                case 3:
                    System.out.println("\t_______________ADICIONAR MEMBRO_______________");
                    System.out.printf("Insira o ID do grupo: ");
                    idGroup=sc.nextInt();

                    System.out.printf("Insira o ID do membro: ");
                    idMember=sc.nextInt();

                    server.addMember(idGroup, idMember);

                    System.out.println("Membro adicionado!");
                    System.out.println("\t---------------------------------------------------");
                    break;

                case 4:
                    System.out.println("\t_______________REMOVER MEMBRO_______________");
                    System.out.printf("Insira o ID do grupo: ");
                    idGroup=sc.nextInt();

                    System.out.printf("Insira o ID do membro: ");
                    idMember=sc.nextInt();

                    server.removeMember(idGroup, idMember);

                    System.out.println("Membro removido!");
                    System.out.println("\t---------------------------------------------------");

                    break;
                
                case 5:
                    System.out.println("\t_______________ENVIAR MENSAGEM_______________");
                    System.out.printf("Insira o ID do grupo: ");
                    idGroup=sc.nextInt();

                    System.out.printf("Insira o ID do membro: ");
                    idMember=sc.nextInt();

                    server.sendMessage(idGroup, idMember);

                    System.out.println("Mensagem enviada!");
                    System.out.println("\t---------------------------------------------------");
                    break;

                case 6:
                    System.out.println("Saindo... ");
                    menu = false;
                    break;
            }

        }
	}
}
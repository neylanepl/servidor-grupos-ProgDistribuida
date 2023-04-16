import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.Scanner;

public class GUI implements Serializable {
    private static Scanner sc = new Scanner(System.in);

    public static void principalMenu(ServerInterface server, int idClient) throws RemoteException {
        int idGroup = 0, idMember = idClient;
        String nameGroup;
        boolean menu = true;
        while (menu) {
            System.out.println("Escolha uma das opções.");
            System.out.println("1. Criar novo grupo\n"
                    + "2. Adicionar membro a um grupo\n"
                    + "3. Remover membro de um grupo\n"
                    + "4. Enviar mensagem a um grupo \n"
                    + "5. Sair");
            System.out.println("Digite a opção:");

            switch (sc.nextInt()) {
                case 1:
                    System.out.println("\t_______________CRIAR GRUPO_______________");
                    System.out.println("Insira o nome do grupo: ");
                    nameGroup=sc.next();

                    server.createGroup(nameGroup, idMember);

                    System.out.println("Grupo criado!");
                    System.out.println("Grupo criado por "+idMember+"!");
                    System.out.println("\t---------------------------------------------------");
                        
                    break;

                case 2:
                    System.out.println("\t_______________ADICIONAR MEMBRO_______________");
                    System.out.printf("Insira o ID do grupo: ");
                    idGroup=sc.nextInt();

                    System.out.printf("Insira o ID do membro: ");
                    idMember=sc.nextInt();

                    server.addMember(idGroup, idMember);

                    System.out.println("Membro adicionado!");
                    System.out.println("\t---------------------------------------------------");
                    break;

                case 3:
                    System.out.println("\t_______________REMOVER MEMBRO_______________");
                    System.out.printf("Insira o ID do grupo: ");
                    idGroup=sc.nextInt();

                    System.out.printf("Insira o ID do membro: ");
                    idMember=sc.nextInt();

                    server.removeMember(idGroup, idMember);

                    System.out.println("Membro removido!");
                    System.out.println("\t---------------------------------------------------");

                    break;
                
                case 4:
                    System.out.println("\t_______________ENVIAR MENSAGEM_______________");
                    System.out.printf("Insira o ID do grupo: ");
                    idGroup=sc.nextInt();

                    System.out.printf("Insira o ID do membro: ");
                    idMember=sc.nextInt();

                    server.sendMessage(idGroup, idMember);

                    System.out.println("Mensagem enviada!");
                    System.out.println("\t---------------------------------------------------");
                    break;

                case 5:
                    System.out.println("Saindo... ");
                    menu = false;
                    break;
            }

        }
    }
}

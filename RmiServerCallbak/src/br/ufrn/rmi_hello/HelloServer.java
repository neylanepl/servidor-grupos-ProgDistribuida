package br.ufrn.rmi_hello;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import br.ufrn.rmi.model.Message;

public class HelloServer extends UnicastRemoteObject implements HelloServerInterface {

	private volatile List<HelloClientInterface> clients = new ArrayList<HelloClientInterface>();
	
	protected HelloServer() throws RemoteException {
		super();	
		
		new Notify().start();
	}

	@Override
	public void registerClient(HelloClientInterface client) throws RemoteException {
			
		clients.add(client);
		System.out.println("Novo cliente registrado com sucesso! Total: "+clients.size());
	}
	
	
	private class Notify extends Thread{
		
		public void run() {
			
			for(;;) {
				
				if(clients.size() > 0) {
					
					System.out.println("Notificando clientes");
					
					int i = 0;
					for (HelloClientInterface helloClientInterface : clients) {
						
						try {
							helloClientInterface.printMessage(new Message("Hello client " + (i++)));
						} catch (RemoteException e) {
							e.printStackTrace();
						}
					}
					
					
					try {
						Thread.sleep(15 * 1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					
				}
				
			}
			
		}
	}

	
}

package br.ufrn.rmi_hello;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import br.ufrn.rmi.model.Message;


public class HelloClient extends UnicastRemoteObject implements HelloClientInterface {

	protected HelloClient() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void printMessage(Message message) throws RemoteException {
		
		System.out.println(message);
		
	}

}

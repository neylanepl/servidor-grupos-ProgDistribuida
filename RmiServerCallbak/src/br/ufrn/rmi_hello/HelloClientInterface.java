package br.ufrn.rmi_hello;

import java.rmi.Remote;
import java.rmi.RemoteException;

import br.ufrn.rmi.model.Message;

public interface HelloClientInterface extends Remote {
	
	public void printMessage(Message message) throws RemoteException;

}

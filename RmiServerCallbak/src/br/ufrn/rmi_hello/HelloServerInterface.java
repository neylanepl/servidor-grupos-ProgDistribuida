package br.ufrn.rmi_hello;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface HelloServerInterface extends Remote{

	public void registerClient(HelloClientInterface client) throws RemoteException;
	

}

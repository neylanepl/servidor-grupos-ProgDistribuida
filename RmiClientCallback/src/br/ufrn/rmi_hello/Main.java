package br.ufrn.rmi_hello;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Main {

	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		
		HelloServerInterface server = (HelloServerInterface) 
				Naming.lookup("rmi://127.0.0.1:1098/HelloServerCallbak");

		HelloClientInterface client = new HelloClient();
		
		server.registerClient(client);
	}

}

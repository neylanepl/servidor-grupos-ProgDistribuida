package br.ufrn.rmi.model;

import java.io.Serializable;
import java.util.Date;

public class Message implements Serializable{
	
	private String message;
	private Date date;
	
	public Message(String message) {
		this.message = message;
		this.date = new Date();
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Message [message=" + message + ", date=" + date + "]";
	}
	
	
	
	

}

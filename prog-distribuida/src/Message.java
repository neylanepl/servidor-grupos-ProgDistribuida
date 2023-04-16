import java.io.Serializable;
import java.util.Date;

public class Message implements Serializable {	
	private String text;
	private Date date;
	private Member member;
	private int idGroup;

	public Message(String text) {
		this.text = text;
		this.date = new Date();
	}
	
	public String getMessage() {
		return text;
	}
	public void setMessage(String text) {
		this.text = text;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public int getIdGroup() {
		return idGroup;
	}

	public void setIdGroup(int idGroup) {
		this.idGroup = idGroup;
	}

	@Override
	public String toString() {
		return "Message [text=" + text + ", date=" + date + "]";
	}	
}

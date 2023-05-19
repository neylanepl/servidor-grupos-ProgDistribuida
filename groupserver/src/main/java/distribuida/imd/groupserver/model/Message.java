package distribuida.imd.groupserver.model;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message implements Serializable {	
	private String text;
	private Date date;
	private Member member;
	private int idGroup;
}

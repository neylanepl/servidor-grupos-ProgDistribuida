import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Group implements Serializable {
    private String name;
    private int id, membersNumber = 1;
    private List<Member> members = new ArrayList<>();
    private List<Message> messages = new ArrayList<>();

    public Group(String name, int id, Member creator) {
        this.name = name;
        this.id = id;
        this.members.add(creator);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMembersNumber() {
        return this.membersNumber;
    }

    public void setMembersNumber(int membersNumber) {
        this.membersNumber = membersNumber;
    }
}

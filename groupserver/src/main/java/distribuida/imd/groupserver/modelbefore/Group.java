package distribuida.imd.groupserver.modelbefore;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Group {
    private int id;
    private String name;
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
        return members.size();
    }

    public boolean addMember(Member member) {
        if(!members.contains(member)) {
            return members.add(member);
        }
        return false;
    }

    public boolean removeMember(int idMember) {
        return members.removeIf(member -> member.getId() == idMember);
    }

    public boolean isMember(int idMember) {
        Predicate<Member> pred = member -> member.getId() == idMember;
        boolean isMember = members.stream().anyMatch(pred);
        return isMember ? true : false;
    }

    public Member getMemberById(int idMember) {
        for(Member member : members) {
            if (member.getId() == idMember) {
                return member;
            }
        }
        return null;
    }

    public boolean addMessage(Message message) {
        return messages.add(message);
    }

    public List<Message> getMessages() {
        return messages;
    }
    
    public int getMessagesNumber() {
        return messages.size();
    }
}

package distribuida.imd.groupserver.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import distribuida.imd.groupserver.model.Group;
import distribuida.imd.groupserver.model.Member;
import distribuida.imd.groupserver.model.Message;
import distribuida.imd.groupserver.model.NewGroup;

@Repository
public class GroupRepository {
    private List<Group> groups = new ArrayList<>();
    private Map<Member, List<Integer>> members = new HashMap<>();
    private Map<Message, Integer> messages = new HashMap<>();
    
    public Group createGroup(NewGroup newGroup) {
        int idGroup = groups.size()+1;
        Group groupReceived = new Group(idGroup, newGroup.getName());
        groups.add(groupReceived);
        members.put(newGroup.getCreator(), List.of(idGroup));
        return groupReceived;
    }

    public List<Group> getGroups() {
        return groups;
    }
    
    public Group findById(int id){
        for (int i = 0; i < groups.size(); i++) {
            if (groups.get(i).getId() == (id)) {
                return groups.get(i);
            }
        }
        return null;
    }

    public boolean addMember(Member member, int idGroup) {
        boolean isAdded = false;
        if(!members.containsKey(member)) {
            members.put(member, List.of(idGroup));
            isAdded = true;
        }
        return isAdded;
    }

    public boolean removeMember(Member member, int idGroup) {
        boolean isRemoved = false;
        if(members.containsKey(member)) {
            members.remove(member);
            isRemoved = true;
        }
        return isRemoved;
    }

    private boolean isMember(int idGroup, Member memberReceived) {
        for (Map.Entry<Member, List<Integer>> member : members.entrySet()) {
            if (member.getKey().equals(memberReceived)  && member.getValue().contains(idGroup)) {
                return true;
            }
        }
        return false;
    }

    public boolean addMessage(Message message, int idGroup, Member member) {
        if(isMember(idGroup, member)) {
            messages.put(message, idGroup);
            return true;
        }
        return false;
    }

    public List<Message> getMessages(int idGroup, Member member) {
        List<Message> messagesByGroup = new ArrayList<>();
        System.out.println("é membro " + member.toString());
        if(isMember(idGroup, member)) {
            for (Map.Entry<Message, Integer> message : messages.entrySet()) {
                if (message.getValue().equals(idGroup)) {
                    messagesByGroup.add(message.getKey());
                }
            }
        }
        return messagesByGroup;
    }
}

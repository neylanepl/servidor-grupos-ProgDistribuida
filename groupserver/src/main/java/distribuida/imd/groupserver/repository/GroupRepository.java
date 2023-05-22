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

    public void addMessage(Message message, int idGroup) {
        messages.put(message, idGroup);
    }

    public List<Message> getMessages(int idGroup) {
        List<Message> messagesByGroup = new ArrayList<>();
        for (Map.Entry<Message, Integer> message : messages.entrySet()) {
            if (message.getValue() == idGroup) {
                messagesByGroup.add(message.getKey());
            }
        }
        return messagesByGroup;
    }
}

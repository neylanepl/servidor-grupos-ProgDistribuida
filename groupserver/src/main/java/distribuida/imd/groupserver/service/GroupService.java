package distribuida.imd.groupserver.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import distribuida.imd.groupserver.model.Group;
import distribuida.imd.groupserver.model.Member;
import distribuida.imd.groupserver.model.Message;
import distribuida.imd.groupserver.model.NewGroup;
import distribuida.imd.groupserver.repository.GroupRepository;

@Service
public class GroupService {
    @Autowired
    private GroupRepository groupRepository;

    public Group createGroup(NewGroup newGroup) {
        return groupRepository.createGroup(newGroup);
    }

    public List<Group> getGroups() {
        return groupRepository.getGroups();
    }

    public String addMember(int idGroup, Member member) {
        String message = "Enter in group with sucess!";
        if (groupRepository.addMember(member, idGroup) == false) 
            message = "Try again! Has some problem...";
        return message;
    }

    public String removeMember(int idGroup, Member member) {
        String message = "Leave group with sucess!";
        if (groupRepository.removeMember(member, idGroup) == false) 
            message = "Try again! Has some problem...";
        return message;
    }

    public String addMessage(int idGroup, Message message) {
        groupRepository.addMessage(message, idGroup);
        return "Send message with sucess!";
    }

    public List<Message> getMessages(int idGroup) {
        return groupRepository.getMessages(idGroup);
    }
}

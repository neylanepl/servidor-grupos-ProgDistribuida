package distribuida.imd.groupserver.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import distribuida.imd.groupserver.model.Group;
import distribuida.imd.groupserver.model.Member;
import distribuida.imd.groupserver.model.Message;

@Repository
public class GroupRepository {
    private List<Group> groups = new ArrayList<>();
    
    public void createGroup(String name, int id, Member creator) {
        groups.add(new Group(id, name, List.of(creator)));
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
        List<Member> members = groups.get(idGroup).getMembers();
        if(!members.contains(member)) {
            return members.add(member);
        }
        return false;
    }

    public boolean removeMember(int idMember, int idGroup) {
        List<Member> members = groups.get(idGroup).getMembers();
        return members.removeIf(member -> member.getId() == idMember);
    }


}

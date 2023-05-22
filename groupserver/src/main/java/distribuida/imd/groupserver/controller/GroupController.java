package distribuida.imd.groupserver.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import distribuida.imd.groupserver.model.Group;
import distribuida.imd.groupserver.model.Member;
import distribuida.imd.groupserver.model.Message;
import distribuida.imd.groupserver.model.NewGroup;
import distribuida.imd.groupserver.service.GroupService;

@RestController
@RequestMapping("/group")
public class GroupController {
    @Autowired
    private GroupService groupService;

    @PostMapping
    public Group createGroup(@RequestBody NewGroup newGroup) {
        return groupService.createGroup(newGroup);
    }

    @GetMapping
    public List<Group> getGroups() {
        return groupService.getGroups();
    }

    @PostMapping("entergroup/{idGroup}")
    public String enterGroup(@PathVariable int idGroup, @RequestBody Member member) {
        return groupService.addMember(idGroup, member);
    }

    @PostMapping("leavegroup/{idGroup}")
    public String leaveGroup(@PathVariable int idGroup, @RequestBody Member member) {
        return groupService.removeMember(idGroup, member);
    }

    @PostMapping("sendmessage/{idGroup}")
    public String sendMessage(@PathVariable int idGroup, @RequestBody Message message) {
        return groupService.addMessage(idGroup, message);
    }

    @GetMapping("readmessages/{idGroup}")
    public List<Message> readMessages(@PathVariable int idGroup, @RequestBody Member member) {
        return groupService.getMessages(idGroup, member);
    }
}

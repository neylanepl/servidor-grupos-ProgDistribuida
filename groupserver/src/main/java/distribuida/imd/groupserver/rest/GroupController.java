package distribuida.imd.groupserver.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/group")
public class GroupController {

    @PostMapping("/registergroup")
    public int registerGroup() {
        return 1;
    }

    @GetMapping("/getgroups")
    public String getGroups() {
        return "groups";
    }
}

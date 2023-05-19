package distribuida.imd.groupserver.model;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Group {
    private int id;
    private String name;
    private List<Member> members = new ArrayList<>();
}

package iuh.fit.se.annotationbased;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
    private int id;
    private String username;
    private String password;
    @Autowired
    private Group group;

    @Autowired
    public void setGroup(Group group) {
        this.group = group;
    }

    @Autowired
    public User(Group group) {
        this.group = group;
    }
}

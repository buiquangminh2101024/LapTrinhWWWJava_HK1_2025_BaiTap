package iuh.fit.se.xmlbased;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Student {
    private long id;
    private String name;
    private Class_ class_;
}

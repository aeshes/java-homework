package aoizora.domain;

import aoizora.orm.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
    @Id
    private Integer id;
    private String name;
    private String email;
    private String password;
}

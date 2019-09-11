package aoizora.domain;

import aoizora.orm.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    @Id
    private Integer id;
    private Integer amount;
    private String type;
}

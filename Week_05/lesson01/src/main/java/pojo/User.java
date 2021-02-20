package pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author zlm
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {

    private Long id;

    private Integer age;

    private String name;

}

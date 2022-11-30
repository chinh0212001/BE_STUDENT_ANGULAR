package chinh.linh.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignUpForm {
    private String name;
    private String username;
    private String email;
    private String password;
    private Set<String>roles;
}

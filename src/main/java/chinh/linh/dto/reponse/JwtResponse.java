package chinh.linh.dto.reponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JwtResponse {
    String token;
    private String type = "bearer";
    private String name;
    private Collection<? extends GrantedAuthority>roles;

    public JwtResponse(String token, String name, Collection<? extends GrantedAuthority> authorities) {
        this.token = token;
        this.name = name;
        this.roles = authorities;
    }
}

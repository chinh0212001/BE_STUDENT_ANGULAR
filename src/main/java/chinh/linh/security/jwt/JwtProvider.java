package chinh.linh.security.jwt;

import chinh.linh.security.userpincal.UserPrinciple;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;
@Component
public class JwtProvider {
    private static final Logger logger = LoggerFactory.getLogger(JwtProvider.class);
    private String jwtSecret = "chinh.duong@linh";
    private int jwtExpiration = 86400;
    public String createToken(Authentication authentication){
        UserPrinciple userPrinciple = (UserPrinciple) authentication.getPrincipal();
        return Jwts.builder().setSubject(userPrinciple.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime()+jwtExpiration*1000))
                .signWith(SignatureAlgorithm.HS512,jwtSecret)
                .compact();
    }
    public boolean validateToken(String token){
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
            return true;
        } catch (SignatureException e){
            logger.error("Invalid JWT signature -> ResponseMessage: {}",e);
        } catch (MalformedJwtException e){
            logger.error("Invalid format Token -> ResponseMessage: {}",e);
        } catch (ExpiredJwtException e){
            logger.error("Expired JWT token -> ResponseMessage: {}",e);
        } catch (UnsupportedJwtException e){
            logger.error("Unsupported JWT token -> ResponseMessage: {}",e);
        } catch (IllegalArgumentException e){
            logger.error("JWT claims string is empty --> ResponseMessage {}",e);
        }
        return false;
    }
    public String getUsernameFormToken(String token){
        String userName = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
        return userName;
    }

}

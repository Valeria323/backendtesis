package ec.edu.insteclrg.service.jwt;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import ec.edu.insteclrg.service.manejoExepciones.ExepcionEcommerce;

@Component
public class JwtTokenProvider {

  @Value("${app.jwt-secret}")
  private String jwtSecret;

  @Value("${app.jwt-expiration-milliseconds}")
  private int jwtEXpirationInMs;

  public String generarToken(Authentication authentication) {
    String username = authentication.getName();
    Date fechaActual = new Date();
    Date fechaExpiracion = new Date(fechaActual.getTime() + jwtEXpirationInMs);
    String token = Jwts.builder().setSubject(username).setIssuedAt(new Date()).setExpiration(fechaExpiracion)
        .signWith(SignatureAlgorithm.HS512, jwtSecret).compact();
    return token;
  }

  public String obtenerUserNameDelJWT(String token) {
    Claims claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
    return claims.getSubject();
  }

  public boolean validarToken(String token) {
    try {
      Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
      return true;
    } catch (SignatureException e) {
      throw new ExepcionEcommerce(HttpStatus.BAD_REQUEST, "Jwt no valido");
    } catch (MalformedJwtException e) {
      throw new ExepcionEcommerce(HttpStatus.BAD_REQUEST, "Token no valido");
    } catch (ExpiredJwtException e) {
      throw new ExepcionEcommerce(HttpStatus.BAD_REQUEST, "Token Caducado");
    } catch (UnsupportedJwtException e) {
      throw new ExepcionEcommerce(HttpStatus.BAD_REQUEST, "Token No campatible");
    } catch (IllegalArgumentException e) {
      throw new ExepcionEcommerce(HttpStatus.BAD_REQUEST, "Los clains esta vacio");
    }
  }
}

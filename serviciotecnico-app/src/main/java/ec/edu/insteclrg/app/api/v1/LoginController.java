package ec.edu.insteclrg.app.api.v1;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.insteclrg.domain.Registrar;
import ec.edu.insteclrg.domain.Usuario;
import ec.edu.insteclrg.service.crud.UsuarioService;
import ec.edu.insteclrg.service.crud.ImplementarLogin;
import ec.edu.insteclrg.service.jwt.JwtAuthResponseDTO;
import ec.edu.insteclrg.service.jwt.JwtTokenProvider;

@RestController
@RequestMapping(value = "/api/v1.0/autorizacion")
public class LoginController {

  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  private UsuarioService servicioUsuario;

  @Autowired
  private BCryptPasswordEncoder codificarPassword;

  @Autowired
  HttpSession session;

  @Autowired
  private JwtTokenProvider jwtTokenProvider;

  @PostMapping("/iniciarSesion")
  public ResponseEntity<JwtAuthResponseDTO> authenticateUser(@RequestBody ImplementarLogin implementarLogin) {
    // public String authenticateUser(@RequestBody ImplementarLogin
    // implementarLogin) {
    Optional<Usuario> usuario = servicioUsuario.findEmail(implementarLogin);
    Authentication authentication = authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(implementarLogin.getEmail(), implementarLogin.getPassword()));
    SecurityContextHolder.getContext().setAuthentication(authentication);
    session.setAttribute("idUsuario", usuario.get().getId());

    String token = jwtTokenProvider.generarToken(authentication);

    return ResponseEntity.ok(new JwtAuthResponseDTO(token));
    // return "0";
  }

  @PostMapping("/registrar")
  public ResponseEntity<?> registrarUsuario(@RequestBody Registrar registrar) {
    Optional<Usuario> usuarioRepetido = servicioUsuario.findEmail2(registrar);
    if (usuarioRepetido.isPresent()) {
      return new ResponseEntity<>("Este email ya existe", HttpStatus.BAD_REQUEST);
    }
    Usuario usuario = new Usuario();
    usuario.setNombre(registrar.getNombre());
    usuario.setEmail(registrar.getEmail());
    usuario.setUserName(registrar.getUserName());
    usuario.setApellido(registrar.getApellido());
    usuario.setDireccion(registrar.getDireccion());
    usuario.setTelefono(registrar.getTelefono());
    usuario.setPassword(codificarPassword.encode(registrar.getPassword()));
    usuario.setRol("usuario");
    servicioUsuario.guardarUsuario(usuario);
    return ResponseEntity.ok(new JwtAuthResponseDTO("registro"));
  }

  @GetMapping("/logout")
  public ResponseEntity<?> salir(HttpServletRequest request,
      HttpServletResponse response) {
    // public String salir(HttpServletRequest request, HttpServletResponse response)
    // {
    System.out.println(session.getAttribute("idUsuario"));
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    if (auth != null) {
      new SecurityContextLogoutHandler().logout(request, response, auth);
    }
    System.out.println(session.getAttribute("idUsuario"));
    return ResponseEntity.ok(new JwtAuthResponseDTO("salida"));
    // return "Salida Exitosa";
  }
}

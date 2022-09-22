package ec.edu.insteclrg.service.crud;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ec.edu.insteclrg.domain.Usuario;
import ec.edu.insteclrg.persistence.UsuarioRepository;

@Service
@Transactional
public class ImplemetarServicioSeguridad implements UserDetailsService {

  public final Logger log = LoggerFactory.getLogger(ImplemetarServicioSeguridad.class);

  @Autowired
  UsuarioRepository usuarioDAO;

  @Autowired
  HttpSession session;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Optional<Usuario> us = usuarioDAO.findByEmail(username);
    log.info("usuario 234{}", us);
    if (us.isPresent()) {
      session.setAttribute("idUsuario", us.get().getId());
    } else {
      log.info("el usuario no esxiste");
    }
    List<GrantedAuthority> roles = new ArrayList<>();
    roles.add(new SimpleGrantedAuthority(us.get().getRol()));

    // UserDetails userdt = (UserDetails) new User(username, us.get().getPassword(),
    // roles);
    // return userdt;
    return new User(username, us.get().getPassword(), roles);
  }

}

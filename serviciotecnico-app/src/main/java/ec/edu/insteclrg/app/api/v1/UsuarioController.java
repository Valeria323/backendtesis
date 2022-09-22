package ec.edu.insteclrg.app.api.v1;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ec.edu.insteclrg.common.dto.ApiResponseDTO;
import ec.edu.insteclrg.domain.Usuario;
import ec.edu.insteclrg.dto.UsuarioDTO;
import ec.edu.insteclrg.service.crud.UsuarioService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/api/v1.0/usuario")
public class UsuarioController {

  @Autowired
  UsuarioService service;

  @PostMapping
  public ResponseEntity<Object> save(@RequestBody UsuarioDTO dto) {
    service.save(dto);
    return new ResponseEntity<>(new ApiResponseDTO<>(true, null), HttpStatus.CREATED);
  }

  @PutMapping
  public ResponseEntity<Object> update(@RequestBody UsuarioDTO dto) {
    service.update(dto);
    return new ResponseEntity<>(new ApiResponseDTO<>(true, null), HttpStatus.CREATED);
  }

  @GetMapping
  public ResponseEntity<Object> findAll() {
    List<UsuarioDTO> list = service.findAll(new UsuarioDTO());
    if (!list.isEmpty()) {
      ApiResponseDTO<List<UsuarioDTO>> response = new ApiResponseDTO<>(true, list);
      return (new ResponseEntity<Object>(response, HttpStatus.OK));
    } else {
      return new ResponseEntity<>(new ApiResponseDTO<>(false, null), HttpStatus.NOT_FOUND);
    }
  }

  @GetMapping(path = "/{id}")
  public ResponseEntity<Object> find(@PathVariable Long id) {
    UsuarioDTO dto = new UsuarioDTO();
    dto.setId(id);
    Optional<Usuario> usuario = service.find(dto);
    if (usuario.isPresent()) {
      ApiResponseDTO<Usuario> response = new ApiResponseDTO<>(true, usuario.get());
      return (new ResponseEntity<Object>(response, HttpStatus.OK));
    } else {
      return new ResponseEntity<>(new ApiResponseDTO<>(false, null), HttpStatus.NOT_FOUND);
    }
  }

  // borrar
  @DeleteMapping
  public ResponseEntity<Object> delete(@RequestBody UsuarioDTO dto) {
    service.delete(dto);
    return new ResponseEntity<>(new ApiResponseDTO<>(true, null), HttpStatus.OK);
  }
}

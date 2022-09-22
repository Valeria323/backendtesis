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
import ec.edu.insteclrg.domain.Tecnico;
import ec.edu.insteclrg.dto.TecnicoDTO;
import ec.edu.insteclrg.service.crud.TecnicoService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/api/v1.0/tecnico")
public class TecnicoController {

  @Autowired
  TecnicoService service;

  @PostMapping
  public ResponseEntity<Object> save(@RequestBody TecnicoDTO dto) {
    service.save(dto);
    return new ResponseEntity<>(new ApiResponseDTO<>(true, null), HttpStatus.CREATED);
  }

  @PutMapping
  public ResponseEntity<Object> update(@RequestBody TecnicoDTO dto) {
    service.update(dto);
    return new ResponseEntity<>(new ApiResponseDTO<>(true, null), HttpStatus.CREATED);
  }

  @GetMapping
  public ResponseEntity<Object> findAll() {
    List<TecnicoDTO> list = service.findAll(new TecnicoDTO());
    if (!list.isEmpty()) {
      ApiResponseDTO<List<TecnicoDTO>> response = new ApiResponseDTO<>(true, list);
      return (new ResponseEntity<Object>(response, HttpStatus.OK));
    } else {
      return new ResponseEntity<>(new ApiResponseDTO<>(false, null), HttpStatus.NOT_FOUND);
    }
  }

  @GetMapping(path = "/{id}")
  public ResponseEntity<Object> find(@PathVariable Long id) {
    TecnicoDTO dto = new TecnicoDTO();
    dto.setId(id);
    Optional<Tecnico> tecnico = service.find(dto);
    if (tecnico.isPresent()) {
      ApiResponseDTO<Tecnico> response = new ApiResponseDTO<>(true, tecnico.get());
      return (new ResponseEntity<Object>(response, HttpStatus.OK));
    } else {
      return new ResponseEntity<>(new ApiResponseDTO<>(false, null), HttpStatus.NOT_FOUND);
    }
  }

  // borrar
  @DeleteMapping
  public ResponseEntity<Object> delete(@RequestBody TecnicoDTO dto) {
    service.delete(dto);
    return new ResponseEntity<>(new ApiResponseDTO<>(true, null), HttpStatus.OK);
  }
}

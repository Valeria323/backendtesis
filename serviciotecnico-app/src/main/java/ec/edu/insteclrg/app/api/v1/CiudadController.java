package ec.edu.insteclrg.app.api.v1;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ec.edu.insteclrg.common.dto.ApiResponseDTO;
import ec.edu.insteclrg.domain.Ciudad;
import ec.edu.insteclrg.dto.CiudadDTO;
import ec.edu.insteclrg.service.crud.CiudadService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/api/v1.0/ciudad")
public class CiudadController {

  @Autowired
  CiudadService service;

  @PostMapping
  public ResponseEntity<Object> save(@RequestBody CiudadDTO dto) {
    service.save(dto);
    return new ResponseEntity<>(new ApiResponseDTO<>(true, null), HttpStatus.CREATED);
  }

  @PutMapping
  public ResponseEntity<Object> update(@RequestBody CiudadDTO dto) {
    service.update(dto);
    return new ResponseEntity<>(new ApiResponseDTO<>(true, null), HttpStatus.CREATED);
  }

  @GetMapping
  public ResponseEntity<Object> findAll() {
    List<CiudadDTO> list = service.findAll(new CiudadDTO());
    if (!list.isEmpty()) {
      ApiResponseDTO<List<CiudadDTO>> response = new ApiResponseDTO<>(true, list);
      return (new ResponseEntity<Object>(response, HttpStatus.OK));
    } else {
      return new ResponseEntity<>(new ApiResponseDTO<>(false, null), HttpStatus.NOT_FOUND);
    }
  }

  @GetMapping(path = "/{id}")
  public ResponseEntity<Object> find(@PathVariable Long id) {
    CiudadDTO dto = new CiudadDTO();
    dto.setId(id);
    Optional<Ciudad> Ciudad = service.find(dto);
    if (Ciudad.isPresent()) {
      ApiResponseDTO<Ciudad> response = new ApiResponseDTO<>(true, Ciudad.get());
      return (new ResponseEntity<Object>(response, HttpStatus.OK));
    } else {
      return new ResponseEntity<>(new ApiResponseDTO<>(false, null), HttpStatus.NOT_FOUND);
    }
  }
}

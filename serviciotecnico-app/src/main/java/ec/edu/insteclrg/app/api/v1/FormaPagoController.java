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
import ec.edu.insteclrg.domain.FormaPago;
import ec.edu.insteclrg.dto.FormaPagoDTO;
import ec.edu.insteclrg.service.crud.FormaPagoService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/api/v1.0/formapago")
public class FormaPagoController {

  @Autowired
  FormaPagoService service;

  @PostMapping
  public ResponseEntity<Object> save(@RequestBody FormaPagoDTO dto) {
    service.save(dto);
    return new ResponseEntity<>(new ApiResponseDTO<>(true, null), HttpStatus.CREATED);
  }

  @PutMapping
  public ResponseEntity<Object> update(@RequestBody FormaPagoDTO dto) {
    service.update(dto);
    return new ResponseEntity<>(new ApiResponseDTO<>(true, null), HttpStatus.CREATED);
  }

  @GetMapping
  public ResponseEntity<Object> findAll() {
    List<FormaPagoDTO> list = service.findAll(new FormaPagoDTO());
    if (!list.isEmpty()) {
      ApiResponseDTO<List<FormaPagoDTO>> response = new ApiResponseDTO<>(true, list);
      return (new ResponseEntity<Object>(response, HttpStatus.OK));
    } else {
      return new ResponseEntity<>(new ApiResponseDTO<>(false, null), HttpStatus.NOT_FOUND);
    }
  }

  @GetMapping(path = "/{codigo}")
  public ResponseEntity<Object> find(@PathVariable String codigo) {
    FormaPagoDTO dto = new FormaPagoDTO();
    dto.setCodigo(codigo);
    Optional<FormaPago> formaPago = service.find(dto);
    if (formaPago.isPresent()) {
      ApiResponseDTO<FormaPago> response = new ApiResponseDTO<>(true, formaPago.get());
      return (new ResponseEntity<Object>(response, HttpStatus.OK));
    } else {
      return new ResponseEntity<>(new ApiResponseDTO<>(false, null), HttpStatus.NOT_FOUND);
    }
  }

  @DeleteMapping
  public ResponseEntity<Object> delete(@RequestBody FormaPagoDTO dto) {
    service.delete(dto);
    return new ResponseEntity<>(new ApiResponseDTO<>(true, null), HttpStatus.OK);
  }
}

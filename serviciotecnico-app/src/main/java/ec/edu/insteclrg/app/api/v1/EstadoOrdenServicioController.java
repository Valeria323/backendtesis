package ec.edu.insteclrg.app.api.v1;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.insteclrg.common.dto.ApiResponseDTO;
import ec.edu.insteclrg.domain.EstadoOrdenServicio;
import ec.edu.insteclrg.dto.EstadoOrdenServicioDTO;
import ec.edu.insteclrg.service.crud.EstadoOrdenServicioService;

@RestController
@RequestMapping(value = "/api/v1.0/estadoordenservicio")
public class EstadoOrdenServicioController {

	@Autowired
	EstadoOrdenServicioService service;

	@PostMapping
	public ResponseEntity<Object> save(@RequestBody EstadoOrdenServicioDTO dto) {
		service.save(dto);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, null), HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<Object> findAll() {
		List<EstadoOrdenServicioDTO> list = service.findAll(new EstadoOrdenServicioDTO());
		if (!list.isEmpty()) {
			ApiResponseDTO<List<EstadoOrdenServicioDTO>> response = new ApiResponseDTO<>(true, list);
			return (new ResponseEntity<Object>(response, HttpStatus.OK));
		} else {
			return new ResponseEntity<>(new ApiResponseDTO<>(false, null), HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<Object> find(@PathVariable Long id) {
		EstadoOrdenServicioDTO dto = new EstadoOrdenServicioDTO();
		dto.setId(id);
		Optional<EstadoOrdenServicio> estadoordenservicio = service.find(dto);
		if (estadoordenservicio.isPresent()) {
			ApiResponseDTO<EstadoOrdenServicio> response = new ApiResponseDTO<>(true, estadoordenservicio.get());
			return (new ResponseEntity<Object>(response, HttpStatus.OK));
		} else {
			return new ResponseEntity<>(new ApiResponseDTO<>(false, null), HttpStatus.NOT_FOUND);
		}
	}
	
	
}

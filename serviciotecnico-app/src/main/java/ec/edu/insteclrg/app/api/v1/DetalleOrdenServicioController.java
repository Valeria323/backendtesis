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
import ec.edu.insteclrg.domain.DetalleOrdenServicio;
import ec.edu.insteclrg.dto.DetalleOrdenServicioDTO;
import ec.edu.insteclrg.service.crud.DetalleOrdenServicioService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/api/v1.0/detalleordenServicio")
public class DetalleOrdenServicioController {

	@Autowired
	DetalleOrdenServicioService service;

	@PostMapping
	public ResponseEntity<Object> save(@RequestBody DetalleOrdenServicioDTO dto) {
		service.save(dto);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, null), HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<Object> update( @RequestBody DetalleOrdenServicioDTO dto) {
		service.update(dto);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, null), HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<Object> findAll() {
		List<DetalleOrdenServicioDTO> list = service.findAll(new DetalleOrdenServicioDTO());
		if (!list.isEmpty()) {
			ApiResponseDTO<List<DetalleOrdenServicioDTO>> response = new ApiResponseDTO<>(true, list);
			return (new ResponseEntity<Object>(response, HttpStatus.OK));
		} else {
			return new ResponseEntity<>(new ApiResponseDTO<>(false, null), HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<Object> find(@PathVariable long id) {
		DetalleOrdenServicioDTO dto = new DetalleOrdenServicioDTO();
		dto.setId(id);
		Optional<DetalleOrdenServicio> test = service.find(dto);
		if (test.isPresent()) {
			ApiResponseDTO<DetalleOrdenServicio> response = new ApiResponseDTO<>(true, test.get());
			return (new ResponseEntity<Object>(response, HttpStatus.OK));
		} else {
			return new ResponseEntity<>(new ApiResponseDTO<>(false, null), HttpStatus.NOT_FOUND);
		}
	}
}

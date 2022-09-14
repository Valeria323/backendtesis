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
import ec.edu.insteclrg.domain.OrdenServicio;
import ec.edu.insteclrg.dto.OrdenServicioDTO;
import ec.edu.insteclrg.service.crud.OrdenServicioService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/api/v1.0/ordenServicio")
public class OrdenServicioController {

	@Autowired
	OrdenServicioService service;

	@PostMapping
	public ResponseEntity<Object> save(@RequestBody OrdenServicioDTO dto) {
		service.save(dto);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, null), HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<Object> update(@RequestBody OrdenServicioDTO dto) {
		service.update(dto);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, null), HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<Object> findAll() {
		List<OrdenServicioDTO> list = service.findAll(new OrdenServicioDTO());
		if (!list.isEmpty()) {
			ApiResponseDTO<List<OrdenServicioDTO>> response = new ApiResponseDTO<>(true, list);
			return (new ResponseEntity<Object>(response, HttpStatus.OK));
		} else {
			return new ResponseEntity<>(new ApiResponseDTO<>(false, null), HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping(path = "/{numOrden}")
	public ResponseEntity<Object> find(@PathVariable String numOrden) {
		OrdenServicioDTO dto = new OrdenServicioDTO();
		dto.setNumero_orden(numOrden);
		Optional<OrdenServicio> test = service.find(dto);
		if (test.isPresent()) {
			ApiResponseDTO<OrdenServicio> response = new ApiResponseDTO<>(true, test.get());
			return (new ResponseEntity<Object>(response, HttpStatus.OK));
		} else {
			return new ResponseEntity<>(new ApiResponseDTO<>(false, null), HttpStatus.NOT_FOUND);
		}
	}
}

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
import ec.edu.insteclrg.domain.PuntoEmision;
import ec.edu.insteclrg.dto.PuntoEmisionDTO;
import ec.edu.insteclrg.service.crud.PuntoEmisionService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/api/v1.0/puntoEmision")
public class PuntoEmisionController {

	@Autowired
	PuntoEmisionService service;

	@PostMapping
	public ResponseEntity<Object> save(@RequestBody PuntoEmisionDTO dto) {
		service.save(dto);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, null), HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<Object> update(@RequestBody PuntoEmisionDTO dto) {
		service.update(dto);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, null), HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<Object> findAll() {
		List<PuntoEmisionDTO> list = service.findAll(new PuntoEmisionDTO());
		if (!list.isEmpty()) {
			ApiResponseDTO<List<PuntoEmisionDTO>> response = new ApiResponseDTO<>(true, list);
			return (new ResponseEntity<Object>(response, HttpStatus.OK));
		} else {
			return new ResponseEntity<>(new ApiResponseDTO<>(false, null), HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<Object> find(@PathVariable Long id) {
		PuntoEmisionDTO dto = new PuntoEmisionDTO();
		dto.setId(id);
		Optional<PuntoEmision> puntoEmision = service.find(dto);
		if (puntoEmision.isPresent()) {
			ApiResponseDTO<PuntoEmision> response = new ApiResponseDTO<>(true, puntoEmision.get());
			return (new ResponseEntity<Object>(response, HttpStatus.OK));
		} else {
			return new ResponseEntity<>(new ApiResponseDTO<>(false, null), HttpStatus.NOT_FOUND);
		}
	}
}

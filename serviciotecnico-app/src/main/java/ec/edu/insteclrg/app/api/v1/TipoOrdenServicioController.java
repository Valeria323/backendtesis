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
import ec.edu.insteclrg.domain.TipoOrdenServicio;
import ec.edu.insteclrg.dto.TipoOrdenServicioDTO;

import ec.edu.insteclrg.service.crud.TipoOrdenServicioService;

@RestController
@RequestMapping(value = "/api/v1.0/tipoordenservicio")
public class TipoOrdenServicioController {
	@Autowired
	TipoOrdenServicioService service;

	@PostMapping
	public ResponseEntity<Object> save(@RequestBody TipoOrdenServicioDTO dto) {
		service.save(dto);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, null), HttpStatus.CREATED);
	}

	@PutMapping(path = "/{code}")
	public ResponseEntity<Object> update(@PathVariable String code, @RequestBody TipoOrdenServicioDTO dto) {
		service.update(code, dto);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, null), HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<Object> findAll() {
		List<TipoOrdenServicioDTO> list = service.findAll(new TipoOrdenServicioDTO());
		if (!list.isEmpty()) {
			ApiResponseDTO<List<TipoOrdenServicioDTO>> response = new ApiResponseDTO<>(true, list);
			return (new ResponseEntity<Object>(response, HttpStatus.OK));
		} else {
			return new ResponseEntity<>(new ApiResponseDTO<>(false, null), HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping(path = "/{code}")
	public ResponseEntity<Object> find(@PathVariable String code) {
		TipoOrdenServicioDTO dto = new TipoOrdenServicioDTO();
		dto.setCode(code);
		Optional<TipoOrdenServicio> TipoOrdenServicio = service.find(dto);
		if (TipoOrdenServicio.isPresent()) {
			ApiResponseDTO<TipoOrdenServicio> response = new ApiResponseDTO<>(true, TipoOrdenServicio.get());
			return (new ResponseEntity<Object>(response, HttpStatus.OK));
		} else {
			return new ResponseEntity<>(new ApiResponseDTO<>(false, null), HttpStatus.NOT_FOUND);
		}
	}
}

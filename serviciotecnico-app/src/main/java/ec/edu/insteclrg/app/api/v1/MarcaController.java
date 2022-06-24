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
import ec.edu.insteclrg.domain.Marca;
import ec.edu.insteclrg.dto.MarcaDTO;
import ec.edu.insteclrg.service.crud.MarcaService;

@RestController
@RequestMapping(value = "/api/v1.0/marca")
public class MarcaController {
	@Autowired
	MarcaService service;

	@PostMapping
	public ResponseEntity<Object> save(@RequestBody MarcaDTO dto) {
		service.save(dto);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, null), HttpStatus.CREATED);
	}
	
	@PutMapping(path = "/{id}")
	public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody MarcaDTO dto) {
		service.update(id, dto);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, null), HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<Object> findAll() {
		List<MarcaDTO> list = service.findAll(new MarcaDTO());
		if (!list.isEmpty()) {
			ApiResponseDTO<List<MarcaDTO>> response = new ApiResponseDTO<>(true, list);
			return (new ResponseEntity<Object>(response, HttpStatus.OK));
		} else {
			return new ResponseEntity<>(new ApiResponseDTO<>(false, null), HttpStatus.NOT_FOUND);
		}
		
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<Object> find(@PathVariable Long id) {
		MarcaDTO dto = new MarcaDTO();
		dto.setId(id);
		Optional<Marca> marca = service.find(dto);
		if (marca.isPresent()) {
			ApiResponseDTO<Marca> response = new ApiResponseDTO<>(true, marca.get());
			return (new ResponseEntity<Object>(response, HttpStatus.OK));
		} else {
			return new ResponseEntity<>(new ApiResponseDTO<>(false, null), HttpStatus.NOT_FOUND);
		}
	}
}

	
	

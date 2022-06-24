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
import ec.edu.insteclrg.domain.TarifaIVA;
import ec.edu.insteclrg.dto.TarifaIVADTO;
import ec.edu.insteclrg.service.crud.TarifaIVAService;

@RestController
@RequestMapping(value = "/api/v1.0/tarifaIVA")
public class TarifaIVAController {
	@Autowired
	TarifaIVAService service;

	@PostMapping
	public ResponseEntity<Object> save(@RequestBody TarifaIVADTO dto) {
		service.save(dto);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, null), HttpStatus.CREATED);
	}

	@PutMapping(path = "/{code}")
	public ResponseEntity<Object> update(@PathVariable String code, @RequestBody TarifaIVADTO dto) {
		service.update(code, dto);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, null), HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<Object> findAll() {
		List<TarifaIVADTO> list = service.findAll(new TarifaIVADTO());
		if (!list.isEmpty()) {
			ApiResponseDTO<List<TarifaIVADTO>> response = new ApiResponseDTO<>(true, list);
			return (new ResponseEntity<Object>(response, HttpStatus.OK));
		} else {
			return new ResponseEntity<>(new ApiResponseDTO<>(false, null), HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping(path = "/{code}")
	public ResponseEntity<Object> find(@PathVariable String code) {
		TarifaIVADTO dto = new TarifaIVADTO();
		dto.setCode(code);
		Optional<TarifaIVA> test = service.find(dto);
		if (test.isPresent()) {
			ApiResponseDTO<TarifaIVA> response = new ApiResponseDTO<>(true, test.get());
			return (new ResponseEntity<Object>(response, HttpStatus.OK));
		} else {
			return new ResponseEntity<>(new ApiResponseDTO<>(false, null), HttpStatus.NOT_FOUND);
		}
	}
}

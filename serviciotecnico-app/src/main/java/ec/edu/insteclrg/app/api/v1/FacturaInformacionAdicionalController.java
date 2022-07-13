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
import ec.edu.insteclrg.domain.FacturaInformacionAdicional;
import ec.edu.insteclrg.dto.FacturaInformacionAdicionalDTO;
import ec.edu.insteclrg.service.crud.FacturaInformacionAdicionalService;

@RestController
@RequestMapping(value = "/api/v1.0/facturainformacionadicional")
public class FacturaInformacionAdicionalController {
	
	@Autowired
	FacturaInformacionAdicionalService service;

	@PostMapping
	public ResponseEntity<Object> save(@RequestBody FacturaInformacionAdicionalDTO dto) {
		service.save(dto);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, null), HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<Object> update(@RequestBody FacturaInformacionAdicionalDTO dto) {
		service.update(dto);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, null), HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<Object> findAll() {
		List<FacturaInformacionAdicionalDTO> list = service.findAll(new FacturaInformacionAdicionalDTO());
		if (!list.isEmpty()) {
			ApiResponseDTO<List<FacturaInformacionAdicionalDTO>> response = new ApiResponseDTO<>(true, list);
			return (new ResponseEntity<Object>(response, HttpStatus.OK));
		} else {
			return new ResponseEntity<>(new ApiResponseDTO<>(false, null), HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<Object> find(@PathVariable Long id) {
		FacturaInformacionAdicionalDTO dto = new FacturaInformacionAdicionalDTO();
		dto.setId(id);
		Optional<FacturaInformacionAdicional> facturaInformacionAdicional = service.find(dto);
		if (facturaInformacionAdicional.isPresent()) {
			ApiResponseDTO<FacturaInformacionAdicional> response = new ApiResponseDTO<>(true, facturaInformacionAdicional.get());
			return (new ResponseEntity<Object>(response, HttpStatus.OK));
		} else {
			return new ResponseEntity<>(new ApiResponseDTO<>(false, null), HttpStatus.NOT_FOUND);
		}
	}
}

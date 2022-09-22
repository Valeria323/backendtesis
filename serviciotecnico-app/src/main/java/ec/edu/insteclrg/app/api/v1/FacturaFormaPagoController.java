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
import ec.edu.insteclrg.domain.FacturaFormaPago;
import ec.edu.insteclrg.dto.FacturaFormaPagoDTO;
import ec.edu.insteclrg.service.crud.FacturaFormaPagoService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/api/v1.0/facturaformapago")
public class FacturaFormaPagoController {
	
	@Autowired
	FacturaFormaPagoService service;

	@PostMapping
	public ResponseEntity<Object> save(@RequestBody FacturaFormaPagoDTO dto) {
		service.save(dto);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, null), HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<Object> update(@RequestBody FacturaFormaPagoDTO dto) {
		service.update(dto);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, null), HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<Object> findAll() {
		List<FacturaFormaPagoDTO> list = service.findAll(new FacturaFormaPagoDTO());
		if (!list.isEmpty()) {
			ApiResponseDTO<List<FacturaFormaPagoDTO>> response = new ApiResponseDTO<>(true, list);
			return (new ResponseEntity<Object>(response, HttpStatus.OK));
		} else {
			return new ResponseEntity<>(new ApiResponseDTO<>(false, null), HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<Object> find(@PathVariable Long id) {
		FacturaFormaPagoDTO dto = new FacturaFormaPagoDTO();
		dto.setId(id);
		Optional<FacturaFormaPago> facturaFormaPago = service.find(dto);
		if (facturaFormaPago.isPresent()) {
			ApiResponseDTO<FacturaFormaPago> response = new ApiResponseDTO<>(true, facturaFormaPago.get());
			return (new ResponseEntity<Object>(response, HttpStatus.OK));
		} else {
			return new ResponseEntity<>(new ApiResponseDTO<>(false, null), HttpStatus.NOT_FOUND);
		}
	}
}

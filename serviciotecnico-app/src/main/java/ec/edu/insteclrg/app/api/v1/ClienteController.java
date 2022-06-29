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
import ec.edu.insteclrg.domain.Cliente;
import ec.edu.insteclrg.dto.ClienteDTO;
import ec.edu.insteclrg.service.crud.ClienteService;

@RestController
@RequestMapping(value = "/api/v1.0/clientes")
public class ClienteController {

	@Autowired
	ClienteService service;

	@PostMapping
	public ResponseEntity<Object> save(@RequestBody ClienteDTO dto) {
		service.save(dto);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, null), HttpStatus.CREATED);
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody ClienteDTO dto) {
		service.update(id, dto);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, null), HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<Object> findAll() {
		List<ClienteDTO> list = service.findAll(new ClienteDTO());
		if (!list.isEmpty()) {
			ApiResponseDTO<List<ClienteDTO>> response = new ApiResponseDTO<>(true, list);
			return (new ResponseEntity<Object>(response, HttpStatus.OK));
		} else {
			return new ResponseEntity<>(new ApiResponseDTO<>(false, null), HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<Object> find(@PathVariable Long id) {
		ClienteDTO dto = new ClienteDTO();
		dto.setId(id);
		Optional<Cliente> clientes = service.find(dto);
		if (clientes.isPresent()) {
			ApiResponseDTO<Cliente> response = new ApiResponseDTO<>(true, clientes.get());
			return (new ResponseEntity<Object>(response, HttpStatus.OK));
		} else {
			return new ResponseEntity<>(new ApiResponseDTO<>(false, null), HttpStatus.NOT_FOUND);
		}
	}
}

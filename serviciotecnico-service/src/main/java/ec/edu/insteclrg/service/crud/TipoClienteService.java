package ec.edu.insteclrg.service.crud;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.insteclrg.common.exception.ResourceNotFoundException;
import ec.edu.insteclrg.domain.TipoCliente;
import ec.edu.insteclrg.dto.TipoClienteDTO;
import ec.edu.insteclrg.persistence.TipoClienteRepository;
import ec.edu.insteclrg.service.GenericCrudServiceImpl;

@Service
public class TipoClienteService extends GenericCrudServiceImpl<TipoCliente, TipoClienteDTO>{

	@Autowired
	private TipoClienteRepository repository;

	@Override
	public Optional<TipoCliente> find(TipoClienteDTO dto) {
		return repository.findById(dto.getId());
	}

	@Override
	public TipoClienteDTO mapToDto(TipoCliente domain) {
		TipoClienteDTO testDTO = new TipoClienteDTO();
		testDTO.setId(domain.getId());
		testDTO.setName(domain.getName());
		return testDTO;
	}

	@Override
	public TipoCliente mapToDomain(TipoClienteDTO dto) {
		TipoCliente test = new TipoCliente();
		test.setId(dto.getId());
		test.setName(dto.getName());
		return test;
	}

	public void update(Long id, TipoClienteDTO dto) {
		TipoClienteDTO testDto = new TipoClienteDTO();
		testDto.setId(id);
		Optional<TipoCliente> optionalTest = repository.findById(testDto.getId());
		if (!optionalTest.isPresent()) {
			throw new ResourceNotFoundException(String.format("El código %s no se encuentra registrado", id));
		}
		TipoCliente test = optionalTest.get();
		test.setName(dto.getName());
		repository.save(test);
	}
}

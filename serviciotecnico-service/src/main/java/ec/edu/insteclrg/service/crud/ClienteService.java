package ec.edu.insteclrg.service.crud;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.insteclrg.common.exception.ResourceNotFoundException;
import ec.edu.insteclrg.domain.Cliente;
import ec.edu.insteclrg.dto.ClienteDTO;
import ec.edu.insteclrg.persistence.ClienteRepository;
import ec.edu.insteclrg.service.GenericCrudServiceImpl;

@Service
public class ClienteService extends GenericCrudServiceImpl<Cliente, ClienteDTO>{

	@Autowired
	private ClienteRepository repository;

	private ModelMapper modelMapper = new ModelMapper();
	
	@Override
	public Optional<Cliente> find(ClienteDTO dto) {
		return repository.findById(dto.getId());
	}

	@Override
	public ClienteDTO mapToDto(Cliente domain) {
		ClienteDTO clienteDTO = new ClienteDTO();
		clienteDTO = modelMapper.map(domain, ClienteDTO.class);
		return clienteDTO;
	}

	@Override
	public Cliente mapToDomain(ClienteDTO dto) {
		Cliente cliente = new Cliente();
		cliente = modelMapper.map(dto, Cliente.class);
		return cliente;
	}
	
	public void delete(ClienteDTO dto) {
		Optional<Cliente> optional = repository.findById(dto.getId());
		if (!optional.isPresent()) {
			throw new ResourceNotFoundException(String.format("Registro %s no existe en la base de datos", dto));
		}
		Cliente cliente = optional.get();
		repository.delete(cliente);
	}
	
}

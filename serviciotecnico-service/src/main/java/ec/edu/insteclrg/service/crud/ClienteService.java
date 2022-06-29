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
		//clientesDTO.setId(domain.getId());
		//clientesDTO.setNombres(domain.getNombres());
		//clientesDTO.setApellidos(domain.getApellidos());
		clienteDTO = modelMapper.map(domain, ClienteDTO.class);
		return clienteDTO;
	}

	@Override
	public Cliente mapToDomain(ClienteDTO dto) {
		Cliente cliente = new Cliente();
		//clientes.setId(dto.getId());
		//clientes.setNombres(dto.getNombres());
		//clientes.setApellidos(dto.getApellidos());
		cliente = modelMapper.map(dto, Cliente.class);
		return cliente;
	}

	public void update(Long id, ClienteDTO dto) {
		ClienteDTO clientesDto = new ClienteDTO();
		clientesDto.setId(id);
		Optional<Cliente> optionalClientes = repository.findById(clientesDto.getId());
		if (!optionalClientes.isPresent()) {
			throw new ResourceNotFoundException(String.format("El id %s no se encuentra registrado", id));
		}
		Cliente clientes = optionalClientes.get();
		clientes.setNombres(dto.getNombres());
		repository.save(clientes);
	}
}

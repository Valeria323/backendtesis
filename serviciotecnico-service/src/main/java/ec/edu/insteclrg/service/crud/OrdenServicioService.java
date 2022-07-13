package ec.edu.insteclrg.service.crud;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.insteclrg.common.exception.ResourceNotFoundException;
import ec.edu.insteclrg.domain.OrdenServicio;
import ec.edu.insteclrg.dto.OrdenServicioDTO;
import ec.edu.insteclrg.persistence.OrdenServicioRepository;
import ec.edu.insteclrg.service.GenericCrudServiceImpl;

@Service
public class OrdenServicioService extends GenericCrudServiceImpl<OrdenServicio, OrdenServicioDTO> {

	@Autowired
	private OrdenServicioRepository repository;

	private ModelMapper modelMapper = new ModelMapper();

	@Override
	public Optional<OrdenServicio> find(OrdenServicioDTO dto) {
		return repository.findByNumOrder(dto.getNumber_order());
	}

	@Override
	public OrdenServicioDTO mapToDto(OrdenServicio domain) {
		OrdenServicioDTO dto = new OrdenServicioDTO();
		dto = modelMapper.map(domain, OrdenServicioDTO.class);
		return dto;
	}

	@Override
	public OrdenServicio mapToDomain(OrdenServicioDTO dto) {
		OrdenServicio domain = new OrdenServicio();
		domain = modelMapper.map(dto, OrdenServicio.class);
		return domain;
	}

	public void update(String numOrder, OrdenServicioDTO dto) {
		OrdenServicioDTO testDto = new OrdenServicioDTO();
		testDto.setNumber_order(numOrder);
		Optional<OrdenServicio> optionalTest = repository.findByNumOrder(testDto.getNumber_order());
		if (!optionalTest.isPresent()) {
			throw new ResourceNotFoundException(String.format("El código %s no se encuentra registrado", numOrder));
		}
		OrdenServicio test = optionalTest.get();
		test.setNumOrder(dto.getNumber_order());
		repository.save(test);
	}
}

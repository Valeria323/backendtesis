package ec.edu.insteclrg.service.crud;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		return repository.findByNumOrder(dto.getNumero_orden());
	}

	@Override
	public OrdenServicioDTO mapToDto(OrdenServicio domain) {
		return modelMapper.map(domain, OrdenServicioDTO.class);
	}

	@Override
	public OrdenServicio mapToDomain(OrdenServicioDTO dto) {
		return modelMapper.map(dto, OrdenServicio.class);
	}
}

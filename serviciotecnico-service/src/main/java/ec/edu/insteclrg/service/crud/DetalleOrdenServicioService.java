package ec.edu.insteclrg.service.crud;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.insteclrg.domain.DetalleOrdenServicio;
import ec.edu.insteclrg.dto.DetalleOrdenServicioDTO;
import ec.edu.insteclrg.persistence.DetalleOrdenServicioRepository;
import ec.edu.insteclrg.service.GenericCrudServiceImpl;

@Service
public class DetalleOrdenServicioService extends GenericCrudServiceImpl<DetalleOrdenServicio, DetalleOrdenServicioDTO>{

	@Autowired
	private DetalleOrdenServicioRepository repository;
	private ModelMapper modelMapper = new ModelMapper();

	@Override
	public Optional<DetalleOrdenServicio> find(DetalleOrdenServicioDTO dto) {
		return repository.findById(dto.getId());
	}

	@Override
	public DetalleOrdenServicioDTO mapToDto(DetalleOrdenServicio domain) {
		return modelMapper.map(domain, DetalleOrdenServicioDTO.class);
	}

	@Override
	public DetalleOrdenServicio mapToDomain(DetalleOrdenServicioDTO dto) {
		return modelMapper.map(dto, DetalleOrdenServicio.class);
	}
}

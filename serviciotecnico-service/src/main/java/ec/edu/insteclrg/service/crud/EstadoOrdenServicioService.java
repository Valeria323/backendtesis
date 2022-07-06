package ec.edu.insteclrg.service.crud;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.insteclrg.common.exception.ResourceNotFoundException;
import ec.edu.insteclrg.domain.EstadoOrdenServicio;
import ec.edu.insteclrg.dto.EstadoOrdenServicioDTO;
import ec.edu.insteclrg.persistence.EstadoOrdenServicioRepository;
import ec.edu.insteclrg.service.GenericCrudServiceImpl;

@Service
public class EstadoOrdenServicioService  extends GenericCrudServiceImpl<EstadoOrdenServicio, EstadoOrdenServicioDTO>{

	@Autowired
	private EstadoOrdenServicioRepository repository;

	private ModelMapper modelMapper = new ModelMapper();

	@Override
	public Optional<EstadoOrdenServicio> find(EstadoOrdenServicioDTO dto) {
		return repository.findById(dto.getId());
	}

	@Override
	public EstadoOrdenServicioDTO mapToDto(EstadoOrdenServicio domain) {
		EstadoOrdenServicioDTO estadoordenservicioDTO = new EstadoOrdenServicioDTO();
		// estadoordenservicioDTO.setId(domain.getId());
		//estadoordenservicioDTO.setState(domain.getState());
		estadoordenservicioDTO = modelMapper.map(domain, EstadoOrdenServicioDTO.class);
		return estadoordenservicioDTO;
	}

	@Override
	public EstadoOrdenServicio mapToDomain(EstadoOrdenServicioDTO dto) {
		EstadoOrdenServicio estadoordenservicio = new EstadoOrdenServicio();
		// estadoordenservicio.setId(dto.getId());
		// estadoordenservicio.setState(dto.getState());
		estadoordenservicio = modelMapper.map(dto, EstadoOrdenServicio.class);
		return estadoordenservicio;
	}

	public void update(Long id, EstadoOrdenServicioDTO dto) {
		EstadoOrdenServicioDTO estadoordenservicioDto = new EstadoOrdenServicioDTO();
		estadoordenservicioDto.setId(id);
		Optional<EstadoOrdenServicio> optionalEstadoOrdenServicio = repository.findById(estadoordenservicioDto.getId());
		if (!optionalEstadoOrdenServicio.isPresent()) {
			throw new ResourceNotFoundException(String.format("El id %s no se encuentra registrado", id));
		}
		EstadoOrdenServicio estadoordenservicio = optionalEstadoOrdenServicio.get();
		estadoordenservicio.setState(dto.getState());
		repository.save(estadoordenservicio);
	}
	
}
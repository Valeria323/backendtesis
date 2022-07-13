package ec.edu.insteclrg.service.crud;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.insteclrg.domain.PuntoEmision;
import ec.edu.insteclrg.dto.PuntoEmisionDTO;
import ec.edu.insteclrg.persistence.PuntoEmisionRepository;
import ec.edu.insteclrg.service.GenericCrudServiceImpl;

@Service
public class PuntoEmisionService extends GenericCrudServiceImpl<PuntoEmision, PuntoEmisionDTO>{

	@Autowired
	private PuntoEmisionRepository repository;
	private ModelMapper modelMapper = new ModelMapper();

	@Override
	public Optional<PuntoEmision> find(PuntoEmisionDTO dto) {
		return repository.findById(dto.getId());
	}

	@Override
	public PuntoEmisionDTO mapToDto(PuntoEmision domain) {
		return modelMapper.map(domain, PuntoEmisionDTO.class);
	}

	@Override
	public PuntoEmision mapToDomain(PuntoEmisionDTO dto) {
		return modelMapper.map(dto, PuntoEmision.class);
	}
}

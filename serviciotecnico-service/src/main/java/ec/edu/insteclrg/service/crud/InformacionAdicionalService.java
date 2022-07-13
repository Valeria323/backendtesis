package ec.edu.insteclrg.service.crud;

import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ec.edu.insteclrg.domain.InformacionAdicional;
import ec.edu.insteclrg.dto.InformacionAdicionalDTO;
import ec.edu.insteclrg.persistence.InformacionAdicionalRepository;
import ec.edu.insteclrg.service.GenericCrudServiceImpl;

@Service
public class InformacionAdicionalService extends GenericCrudServiceImpl<InformacionAdicional, InformacionAdicionalDTO>{

	@Autowired
	private InformacionAdicionalRepository repository;

	private ModelMapper modelMapper = new ModelMapper();

	@Override
	public Optional<InformacionAdicional> find(InformacionAdicionalDTO dto) {
		return repository.findById(dto.getId());
	}

	@Override
	public InformacionAdicionalDTO mapToDto(InformacionAdicional domain) {
		return modelMapper.map(domain, InformacionAdicionalDTO.class);
	}

	@Override
	public InformacionAdicional mapToDomain(InformacionAdicionalDTO dto) {
		return modelMapper.map(dto, InformacionAdicional.class);
	}
}

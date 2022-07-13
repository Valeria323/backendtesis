package ec.edu.insteclrg.service.crud;

import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ec.edu.insteclrg.domain.Tecnico;
import ec.edu.insteclrg.dto.TecnicoDTO;
import ec.edu.insteclrg.persistence.TecnicoRepository;
import ec.edu.insteclrg.service.GenericCrudServiceImpl;

@Service
public class TecnicoService extends GenericCrudServiceImpl<Tecnico, TecnicoDTO> {
	
	@Autowired
	private TecnicoRepository repository;

	private ModelMapper modelMapper = new ModelMapper();

	@Override
	public Optional<Tecnico> find(TecnicoDTO dto) {
		return repository.findById(dto.getId());
	}

	@Override
	public TecnicoDTO mapToDto(Tecnico domain) {
		return modelMapper.map(domain, TecnicoDTO.class);
	}

	@Override
	public Tecnico mapToDomain(TecnicoDTO dto) {
		return modelMapper.map(dto, Tecnico.class);
	}
}
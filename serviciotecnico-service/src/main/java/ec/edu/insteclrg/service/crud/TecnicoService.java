package ec.edu.insteclrg.service.crud;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.insteclrg.common.exception.ResourceNotFoundException;
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
		TecnicoDTO TecnicoDTO = new TecnicoDTO();
		
		TecnicoDTO = modelMapper.map(domain, TecnicoDTO.class);
		return TecnicoDTO;
	}
	
	@Override
	public Tecnico mapToDomain(TecnicoDTO dto) {
		Tecnico tecnico = new Tecnico();
		
		tecnico = modelMapper.map(dto, Tecnico.class);
		return tecnico;
}
	public void update(Long id, TecnicoDTO dto) {
		TecnicoDTO tecnicoDto = new TecnicoDTO();
		tecnicoDto.setId(id);
		Optional<Tecnico> optionalTecnico = repository.findById(tecnicoDto.getId());
		if (!optionalTecnico.isPresent()) {
			throw new ResourceNotFoundException(String.format("El código %s no se encuentra registrado", id));
		}
		Tecnico tecnico = optionalTecnico.get();
		tecnico.setNombre(dto.getNombre());
		repository.save(tecnico);
	}
}

package ec.edu.insteclrg.service.crud;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.insteclrg.common.exception.ResourceNotFoundException;
import ec.edu.insteclrg.domain.Provincia;
import ec.edu.insteclrg.dto.ProvinciaDTO;
import ec.edu.insteclrg.persistence.ProvinciaRepository;
import ec.edu.insteclrg.service.GenericCrudServiceImpl;

@Service
public class ProvinciaService extends GenericCrudServiceImpl<Provincia, ProvinciaDTO> {
	@Autowired
	private ProvinciaRepository repository;

	@Override
	public Optional<Provincia> find(ProvinciaDTO dto) {
		return repository.findById(dto.getId());
	}

	@Override
	public ProvinciaDTO mapToDto(Provincia domain) {
		ProvinciaDTO ProvinciaDTO = new ProvinciaDTO();
		ProvinciaDTO.setId(domain.getId());
		ProvinciaDTO.setNombre(domain.getNombre());
		return ProvinciaDTO;
	}

	@Override
	public Provincia mapToDomain(ProvinciaDTO dto) {
		Provincia Provincia = new Provincia();
		Provincia.setId(dto.getId());
		Provincia.setNombre(dto.getNombre());
		return Provincia;
	}
	
	public void update(Long id, ProvinciaDTO dto) {
		ProvinciaDTO ProvinciaDto = new ProvinciaDTO();
		ProvinciaDto.setId(id);
		Optional<Provincia> optionalmarca = repository.findById(ProvinciaDto.getId());
		if (!optionalmarca.isPresent()) {
			throw new ResourceNotFoundException(String.format("El id %s no se encuentra registrado", id));
		}
		Provincia Provincia = optionalmarca.get();
		Provincia.setNombre(dto.getNombre());
		repository.save(Provincia);

}

}

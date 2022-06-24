package ec.edu.insteclrg.service.crud;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ec.edu.insteclrg.domain.Marca;
import ec.edu.insteclrg.dto.MarcaDTO;
import ec.edu.insteclrg.persistence.MarcaRepository;
import ec.edu.insteclrg.service.GenericCrudServiceImpl;

@Service
public class MarcaService extends GenericCrudServiceImpl<Marca, MarcaDTO> {

	@Autowired
	private MarcaRepository repository;

	@Override
	public Optional<Marca> find(MarcaDTO dto) {
		return repository.findById(dto.getId());
	}

	@Override
	public MarcaDTO mapToDto(Marca domain) {
		MarcaDTO marcaDTO = new MarcaDTO();
		marcaDTO.setId(domain.getId());
		marcaDTO.setNombre(domain.getNombre());
		return marcaDTO;
	}

	@Override
	public Marca mapToDomain(MarcaDTO dto) {
		Marca marca = new Marca();
		marca.setId(dto.getId());
		marca.setNombre(dto.getNombre());
		return marca;
	}

}

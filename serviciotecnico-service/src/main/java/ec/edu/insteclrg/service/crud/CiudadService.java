package ec.edu.insteclrg.service.crud;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.insteclrg.common.exception.ResourceNotFoundException;
import ec.edu.insteclrg.domain.Ciudad;
import ec.edu.insteclrg.domain.Provincia;
import ec.edu.insteclrg.dto.CiudadDTO;
import ec.edu.insteclrg.dto.ProvinciaDTO;
import ec.edu.insteclrg.persistence.CiudadRepository;
import ec.edu.insteclrg.service.GenericCrudServiceImpl;


@Service
public class CiudadService extends GenericCrudServiceImpl<Ciudad, CiudadDTO> {
	@Autowired
	private CiudadRepository repository;

	@Override
	public Optional<Ciudad> find(CiudadDTO dto) {
		return repository.findById(dto.getId());
	}

	@Override
	public CiudadDTO mapToDto(Ciudad domain) {
		CiudadDTO CiudadDTO = new CiudadDTO();
		CiudadDTO.setId(domain.getId());
		CiudadDTO.setNombre(domain.getNombre());
		ProvinciaDTO provinciaDTO = new ProvinciaDTO();
		provinciaDTO.setId(domain.getProvincia().getId());
		provinciaDTO.setNombre(domain.getProvincia().getNombre());
		CiudadDTO.setProvincia(provinciaDTO);
		return CiudadDTO;
	}

	@Override
	public Ciudad mapToDomain(CiudadDTO dto) {
		Ciudad Ciudad = new Ciudad();
		Ciudad.setId(dto.getId());
		Ciudad.setNombre(dto.getNombre());
		Provincia provincia = new Provincia();
		provincia.setId(dto.getProvincia().getId());
		provincia.setNombre(dto.getNombre());
	    Ciudad.setProvincia(provincia);
		return Ciudad;
	}
	
	public void update(Long id, CiudadDTO dto) {
		CiudadDTO CiudadDto = new CiudadDTO();
		CiudadDto.setId(id);
		Optional<Ciudad> optionalCiudad = repository.findById(CiudadDto.getId());
		if (!optionalCiudad.isPresent()) {
			throw new ResourceNotFoundException(String.format("El id %s no se encuentra registrado", id));
					
		}
		
		
		Ciudad Ciudad = optionalCiudad.get();
		Ciudad.setNombre(dto.getNombre());
		repository.save(Ciudad);
	}

	
	
					

	}


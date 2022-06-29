package ec.edu.insteclrg.service.crud;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.insteclrg.common.exception.ResourceNotFoundException;
import ec.edu.insteclrg.domain.TipoOrdenServicio;
import ec.edu.insteclrg.dto.TipoOrdenServicioDTO;
import ec.edu.insteclrg.persistence.TipoOrdenServicioRepository;
import ec.edu.insteclrg.service.GenericCrudServiceImpl;

@Service
public class TipoOrdenServicioService extends GenericCrudServiceImpl<TipoOrdenServicio, TipoOrdenServicioDTO>{
	@Autowired
	private TipoOrdenServicioRepository repository;

	@Override
	public Optional<TipoOrdenServicio> find(TipoOrdenServicioDTO dto) {
		return repository.findByCode(dto.getCode());
	}

	@Override
	public TipoOrdenServicioDTO mapToDto(TipoOrdenServicio domain) {
		TipoOrdenServicioDTO TipoOrdenServicioDTO = new TipoOrdenServicioDTO();
		TipoOrdenServicioDTO.setId(domain.getId());
		TipoOrdenServicioDTO.setCode(domain.getCode());
		TipoOrdenServicioDTO.setName(domain.getName());
		return TipoOrdenServicioDTO;
	}
	@Override
	public TipoOrdenServicio mapToDomain(TipoOrdenServicioDTO dto) {
		TipoOrdenServicio TipoOrdenServicio = new TipoOrdenServicio();
		TipoOrdenServicio.setId(dto.getId());
		TipoOrdenServicio.setCode(dto.getCode());
		TipoOrdenServicio.setName(dto.getName());
		return TipoOrdenServicio;
	}

	public void update(String code, TipoOrdenServicioDTO dto) {
		TipoOrdenServicioDTO TipoOrdenServicioDto = new TipoOrdenServicioDTO();
		TipoOrdenServicioDto.setCode(code);
		Optional<TipoOrdenServicio> optionalTipoOrdenServicio = repository.findByCode(TipoOrdenServicioDto.getCode());
		if (!optionalTipoOrdenServicio.isPresent()) {
			throw new ResourceNotFoundException(String.format("El código %s no se encuentra registrado", code));
		}
		TipoOrdenServicio TipoOrdenServicio = optionalTipoOrdenServicio.get();
		TipoOrdenServicio.setName(dto.getName());
		repository.save(TipoOrdenServicio);
	}
}

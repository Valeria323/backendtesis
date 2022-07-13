package ec.edu.insteclrg.service.crud;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.insteclrg.domain.FacturaDetalle;
import ec.edu.insteclrg.dto.FacturaDetalleDTO;
import ec.edu.insteclrg.persistence.FacturaDetalleRepository;
import ec.edu.insteclrg.service.GenericCrudServiceImpl;

@Service
public class FacturaDetalleService extends GenericCrudServiceImpl<FacturaDetalle, FacturaDetalleDTO>{
	
	@Autowired
	private FacturaDetalleRepository repository;
	private ModelMapper modelMapper = new ModelMapper();

	@Override
	public Optional<FacturaDetalle> find(FacturaDetalleDTO dto) {
		return repository.findById(dto.getId());
	}
	
	@Override
	public FacturaDetalleDTO mapToDto(FacturaDetalle domain) {
		FacturaDetalleDTO testDTO = new FacturaDetalleDTO();
		testDTO = modelMapper.map(domain, FacturaDetalleDTO.class);
		return testDTO;
	}
	
	@Override
	public FacturaDetalle mapToDomain(FacturaDetalleDTO dto) {
		FacturaDetalle test = new FacturaDetalle();
		test = modelMapper.map(dto, FacturaDetalle.class);
		return test;
	}

}

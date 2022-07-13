package ec.edu.insteclrg.service.crud;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.insteclrg.domain.FacturaFormaPago;
import ec.edu.insteclrg.dto.FacturaFormaPagoDTO;
import ec.edu.insteclrg.persistence.FacturaFormaPagoRepository;
import ec.edu.insteclrg.service.GenericCrudServiceImpl;

@Service
public class FacturaFormaPagoService extends GenericCrudServiceImpl<FacturaFormaPago, FacturaFormaPagoDTO> {
	@Autowired
	private  FacturaFormaPagoRepository repository;

	private ModelMapper modelMapper = new ModelMapper();

	@Override
	public Optional<FacturaFormaPago> find(FacturaFormaPagoDTO dto) {
		return repository.findById(dto.getId());
	}

	@Override
	public  FacturaFormaPagoDTO mapToDto(FacturaFormaPago domain) {
		return modelMapper.map(domain, FacturaFormaPagoDTO.class);
	}

	@Override
	public FacturaFormaPago mapToDomain(FacturaFormaPagoDTO dto) {
		return modelMapper.map(dto,  FacturaFormaPago.class);
	}
}

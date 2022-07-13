package ec.edu.insteclrg.service.crud;

import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ec.edu.insteclrg.domain.FacturaInformacionAdicional;
import ec.edu.insteclrg.dto.FacturaInformacionAdicionalDTO;
import ec.edu.insteclrg.persistence.FacturaInformacionAdicionalRepository;
import ec.edu.insteclrg.service.GenericCrudServiceImpl;

@Service
public class FacturaInformacionAdicionalService  extends GenericCrudServiceImpl<FacturaInformacionAdicional,FacturaInformacionAdicionalDTO> {
	
	@Autowired
	private  FacturaInformacionAdicionalRepository repository;

	private ModelMapper modelMapper = new ModelMapper();

	@Override
	public Optional< FacturaInformacionAdicional> find( FacturaInformacionAdicionalDTO dto) {
		return repository.findById(dto.getId());
	}

	@Override
	public  FacturaInformacionAdicionalDTO mapToDto( FacturaInformacionAdicional domain) {
		return modelMapper.map(domain,  FacturaInformacionAdicionalDTO.class);
	}

	@Override
	public  FacturaInformacionAdicional mapToDomain( FacturaInformacionAdicionalDTO dto) {
		return modelMapper.map(dto,  FacturaInformacionAdicional.class);
	}
}
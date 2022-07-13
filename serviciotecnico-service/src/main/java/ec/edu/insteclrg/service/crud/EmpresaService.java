package ec.edu.insteclrg.service.crud;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.insteclrg.domain.Empresa;
import ec.edu.insteclrg.dto.EmpresaDTO;
import ec.edu.insteclrg.persistence.EmpresaRepository;
import ec.edu.insteclrg.service.GenericCrudServiceImpl;

@Service
public class EmpresaService extends GenericCrudServiceImpl<Empresa, EmpresaDTO>{
	
	@Autowired
	private EmpresaRepository repository;
	private ModelMapper modelMapper = new ModelMapper();

	@Override
	public Optional<Empresa> find(EmpresaDTO dto) {
		return repository.findById(dto.getId());
	}
	
	@Override
	public EmpresaDTO mapToDto(Empresa domain) {
		return modelMapper.map(domain, EmpresaDTO.class);
	}
	
	@Override
	public Empresa mapToDomain(EmpresaDTO dto) {
		return modelMapper.map(dto, Empresa.class);
	}
}

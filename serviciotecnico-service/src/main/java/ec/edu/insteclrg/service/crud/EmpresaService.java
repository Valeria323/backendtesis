package ec.edu.insteclrg.service.crud;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.insteclrg.common.exception.ResourceNotFoundException;
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
		EmpresaDTO testDTO = new EmpresaDTO();
		/*testDTO.setId(domain.getId());
		testDTO.setRuc(domain.getRuc());
		testDTO.setName(domain.getName());
		testDTO.setAddress(domain.getAddress());
		CuidadDTO cuidadDTO= new CiudadDTO;
		 * ciudadDTO.setId(domain.getCiudad().getId());
		 * ciudadDTO.setNombre(domain.getCiudad().getNombre());
		 * testDTO.setCiudad(ciudadDTO)
		testDTO.setPhone(domain.getPhone());
		testDTO.setEmail(domain.getEmail());*/
		testDTO = modelMapper.map(domain, EmpresaDTO.class);
		return testDTO;
	}
	
	@Override
	public Empresa mapToDomain(EmpresaDTO dto) {
		Empresa test = new Empresa();
		/*test.setId(dto.getId());
		test.setRuc(dto.getRuc());
		test.setName(dto.getName());
		test.setAddress(dto.getAddress());
		Ciudad ciudad=new Ciudad();
		 * ciudad.setId(dto.getCiudad().getId());
		 * ciudad.setNombre(dto.getNombre())
		test.setPhone(dto.getPhone());
		test.setEmail(dto.getEmail());*/
		test = modelMapper.map(dto, Empresa.class);
		return test;
	}
	
	public void update(Long id, EmpresaDTO dto) {
		EmpresaDTO testDto = new EmpresaDTO();
		testDto.setId(id);
		Optional<Empresa> optionalTest = repository.findById(testDto.getId());
		if (!optionalTest.isPresent()) {
			throw new ResourceNotFoundException(String.format("El código %s no se encuentra registrado", id));
		}
		Empresa test = optionalTest.get();
		test.setName(dto.getName());
		repository.save(test);
	}
	
}

package ec.edu.insteclrg.service.crud;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.insteclrg.common.exception.ResourceNotFoundException;
import ec.edu.insteclrg.domain.TarifaIVA;
import ec.edu.insteclrg.dto.TarifaIVADTO;
import ec.edu.insteclrg.persistence.TarifaIVARepository;
import ec.edu.insteclrg.service.GenericCrudServiceImpl;

@Service
public class TarifaIVAService extends GenericCrudServiceImpl<TarifaIVA, TarifaIVADTO>{
	@Autowired
	private TarifaIVARepository repository;

	@Override
	public Optional<TarifaIVA> find(TarifaIVADTO dto) {
		return repository.findByCode(dto.getCode());
	}

	@Override
	public TarifaIVADTO mapToDto(TarifaIVA domain) {
		TarifaIVADTO testDTO = new TarifaIVADTO();
		testDTO.setId(domain.getId());
		testDTO.setCode(domain.getCode());
		testDTO.setPercentageIVA(domain.getPercentageIVA());
		return testDTO;
	}

	@Override
	public TarifaIVA mapToDomain(TarifaIVADTO dto) {
		TarifaIVA test = new TarifaIVA();
		test.setId(dto.getId());
		test.setCode(dto.getCode());
		test.setPercentageIVA(dto.getPercentageIVA());
		return test;
	}

	public void update(String code, TarifaIVADTO dto) {
		TarifaIVADTO testDto = new TarifaIVADTO();
		testDto.setCode(code);
		Optional<TarifaIVA> optionalTest = repository.findByCode(testDto.getCode());
		if (!optionalTest.isPresent()) {
			throw new ResourceNotFoundException(String.format("El código %s no se encuentra registrado", code));
		}
		TarifaIVA test = optionalTest.get();
		test.setPercentageIVA(dto.getPercentageIVA());
		repository.save(test);
	}
}

package ec.edu.insteclrg.service.crud;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.insteclrg.common.exception.ResourceNotFoundException;
import ec.edu.insteclrg.domain.InformacionAdicional;
import ec.edu.insteclrg.dto.InformacionAdicionalDTO;
import ec.edu.insteclrg.persistence.InformacionAdicionalRepository;
import ec.edu.insteclrg.service.GenericCrudServiceImpl;

@Service
public class InformacionAdicionalService extends GenericCrudServiceImpl<InformacionAdicional, InformacionAdicionalDTO> {

  @Autowired
  private InformacionAdicionalRepository repository;

  private ModelMapper modelMapper = new ModelMapper();

  @Override
  public Optional<InformacionAdicional> find(InformacionAdicionalDTO dto) {
    return repository.findById(dto.getId());
  }

  @Override
  public List<InformacionAdicionalDTO> findAll(InformacionAdicionalDTO dto) {
    return repository.findAll().stream().map(obj -> mapToDto(obj)).collect(Collectors.toList());
  }

  @Override
  public InformacionAdicionalDTO mapToDto(InformacionAdicional domain) {
    return modelMapper.map(domain, InformacionAdicionalDTO.class);
  }

  @Override
  public InformacionAdicional mapToDomain(InformacionAdicionalDTO dto) {
    return modelMapper.map(dto, InformacionAdicional.class);
  }

  public void delete(InformacionAdicionalDTO dto) {

    Optional<InformacionAdicional> optional = repository.findById(dto.getId());

    if (!optional.isPresent()) {
      throw new ResourceNotFoundException(String.format("Registro %s no existe en la base de datos", dto));
    }
    InformacionAdicional informacionadicional = optional.get();
    repository.delete(informacionadicional);
  }
}

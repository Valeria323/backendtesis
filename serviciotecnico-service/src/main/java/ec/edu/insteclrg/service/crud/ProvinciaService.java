package ec.edu.insteclrg.service.crud;

import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.insteclrg.common.exception.ResourceNotFoundException;
import ec.edu.insteclrg.domain.Provincia;
import ec.edu.insteclrg.dto.ProvinciaDTO;
import ec.edu.insteclrg.persistence.ProvinciaRepository;
import ec.edu.insteclrg.service.GenericCrudServiceImpl;

@Service
public class ProvinciaService extends GenericCrudServiceImpl<Provincia, ProvinciaDTO> {

  @Autowired
  private ProvinciaRepository repository;

  private ModelMapper modelMapper = new ModelMapper();

  @Override
  public Optional<Provincia> find(ProvinciaDTO dto) {
    return repository.findById(dto.getId());
  }

  @Override
  public ProvinciaDTO mapToDto(Provincia domain) {
    System.out.println("*********service dto**************");
    System.out.println(modelMapper.map(domain, ProvinciaDTO.class));
    return modelMapper.map(domain, ProvinciaDTO.class);
  }

  @Override
  public Provincia mapToDomain(ProvinciaDTO dto) {
    System.out.println("*********service domain**************");
    System.out.println(modelMapper.map(dto, Provincia.class));
    return modelMapper.map(dto, Provincia.class);
  }

  public void delete(ProvinciaDTO dto) {

    Optional<Provincia> optional = repository.findById(dto.getId());

    if (!optional.isPresent()) {
      throw new ResourceNotFoundException(String.format("Registro %s no existe en la base de datos", dto));
    }
    Provincia provincia = optional.get();
    repository.delete(provincia);
  }
}

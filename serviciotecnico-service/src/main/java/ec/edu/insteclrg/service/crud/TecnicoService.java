package ec.edu.insteclrg.service.crud;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.insteclrg.common.exception.ResourceNotFoundException;
import ec.edu.insteclrg.domain.Tecnico;
import ec.edu.insteclrg.domain.Usuario;
import ec.edu.insteclrg.dto.TecnicoDTO;
import ec.edu.insteclrg.persistence.TecnicoRepository;
import ec.edu.insteclrg.service.GenericCrudServiceImpl;

@Service
public class TecnicoService extends GenericCrudServiceImpl<Tecnico, TecnicoDTO> {

  @Autowired
  private TecnicoRepository repository;

  private ModelMapper modelMapper = new ModelMapper();

  @Override
  public Optional<Tecnico> find(TecnicoDTO dto) {
    return repository.findById(dto.getId());
  }

  @Override
  public List<TecnicoDTO> findAll(TecnicoDTO dto) {
    return repository.findAll().stream().map(obj -> mapToDto(obj)).collect(Collectors.toList());
  }

  @Override
  public TecnicoDTO mapToDto(Tecnico domain) {
    return modelMapper.map(domain, TecnicoDTO.class);
  }

  @Override
  public Tecnico mapToDomain(TecnicoDTO dto) {
    return modelMapper.map(dto, Tecnico.class);
  }

  public void delete(TecnicoDTO dto) {

    Optional<Tecnico> optional = repository.findById(dto.getId());

    if (!optional.isPresent()) {
      throw new ResourceNotFoundException(String.format("Registro %s no existe en la base de datos", dto));
    }
    Tecnico tecnico = optional.get();
    repository.delete(tecnico);
  }

  @Override
  public Usuario guardarUsuario(Usuario usuario) {
    // TODO Auto-generated method stub
    return null;
  }
}
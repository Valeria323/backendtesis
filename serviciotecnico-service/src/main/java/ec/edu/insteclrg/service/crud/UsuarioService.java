package ec.edu.insteclrg.service.crud;

import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.insteclrg.common.exception.ResourceNotFoundException;
import ec.edu.insteclrg.domain.Registrar;
import ec.edu.insteclrg.domain.Usuario;
import ec.edu.insteclrg.dto.UsuarioDTO;
import ec.edu.insteclrg.persistence.UsuarioRepository;
import ec.edu.insteclrg.service.GenericCrudServiceImpl;

@Service
public class UsuarioService extends GenericCrudServiceImpl<Usuario, UsuarioDTO> {

  @Autowired
  private UsuarioRepository repository;

  private ModelMapper modelMapper = new ModelMapper();

  @Override
  public Optional<Usuario> find(UsuarioDTO dto) {
    return repository.findById(dto.getId());
  }

  public Optional<Usuario> findEmail(ImplementarLogin dto) {
    return repository.findByEmail(dto.getEmail());
  }

  public Optional<Usuario> findEmail2(Registrar dto) {
    return repository.findByEmail(dto.getEmail());

  }

  @Override
  public UsuarioDTO mapToDto(Usuario domain) {
    return modelMapper.map(domain, UsuarioDTO.class);
  }

  @Override
  public Usuario mapToDomain(UsuarioDTO dto) {
    return modelMapper.map(dto, Usuario.class);
  }

  public void delete(UsuarioDTO dto) {

    Optional<Usuario> optional = repository.findById(dto.getId());

    if (!optional.isPresent()) {
      throw new ResourceNotFoundException(String.format("Registro %s no existe en la base de datos", dto));
    }
    Usuario usuario = optional.get();
    repository.delete(usuario);
  }

  @Override
  public Usuario guardarUsuario(Usuario usuario) {
    return repository.save(usuario);
  }
}

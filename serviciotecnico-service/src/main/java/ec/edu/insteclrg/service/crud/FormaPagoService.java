package ec.edu.insteclrg.service.crud;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.insteclrg.common.exception.ResourceNotFoundException;
import ec.edu.insteclrg.domain.FormaPago;
import ec.edu.insteclrg.domain.Usuario;
import ec.edu.insteclrg.dto.FormaPagoDTO;
import ec.edu.insteclrg.persistence.FormaPagoRepository;
import ec.edu.insteclrg.service.GenericCrudServiceImpl;

@Service
public class FormaPagoService extends GenericCrudServiceImpl<FormaPago, FormaPagoDTO> {

  @Autowired
  private FormaPagoRepository repository;

  private ModelMapper modelMapper = new ModelMapper();

  @Override
  public Optional<FormaPago> find(FormaPagoDTO dto) {
    return repository.findById(dto.getId());
  }

  @Override
  public List<FormaPagoDTO> findAll(FormaPagoDTO dto) {
    return repository.findAll().stream().map(obj -> mapToDto(obj)).collect(Collectors.toList());
  }

  @Override
  public FormaPagoDTO mapToDto(FormaPago domain) {
    return modelMapper.map(domain, FormaPagoDTO.class);
  }

  @Override
  public FormaPago mapToDomain(FormaPagoDTO dto) {
    return modelMapper.map(dto, FormaPago.class);
  }

  public void delete(FormaPagoDTO dto) {

    Optional<FormaPago> optional = repository.findById(dto.getId());

    if (!optional.isPresent()) {
      throw new ResourceNotFoundException(String.format("Registro %s no existe en la base de datos", dto));
    }
    FormaPago formapago = optional.get();
    repository.delete(formapago);
  }

  @Override
  public Usuario guardarUsuario(Usuario usuario) {
    // TODO Auto-generated method stub
    return null;
  }
}

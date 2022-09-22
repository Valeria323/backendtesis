package ec.edu.insteclrg.service.crud;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.insteclrg.common.exception.ResourceNotFoundException;
import ec.edu.insteclrg.domain.EstadoOrdenServicio;
import ec.edu.insteclrg.domain.Usuario;
import ec.edu.insteclrg.dto.EstadoOrdenServicioDTO;
import ec.edu.insteclrg.persistence.EstadoOrdenServicioRepository;
import ec.edu.insteclrg.service.GenericCrudServiceImpl;

@Service
public class EstadoOrdenServicioService extends GenericCrudServiceImpl<EstadoOrdenServicio, EstadoOrdenServicioDTO> {

  @Autowired
  private EstadoOrdenServicioRepository repository;

  private ModelMapper modelMapper = new ModelMapper();

  @Override
  public Optional<EstadoOrdenServicio> find(EstadoOrdenServicioDTO dto) {
    return repository.findById(dto.getId());
  }

  @Override
  public List<EstadoOrdenServicioDTO> findAll(EstadoOrdenServicioDTO dto) {
    return repository.findAll().stream().map(obj -> mapToDto(obj)).collect(Collectors.toList());
  }

  @Override
  public EstadoOrdenServicioDTO mapToDto(EstadoOrdenServicio domain) {
    EstadoOrdenServicioDTO estadoordenservicioDTO = new EstadoOrdenServicioDTO();
    estadoordenservicioDTO = modelMapper.map(domain, EstadoOrdenServicioDTO.class);
    return estadoordenservicioDTO;
  }

  @Override
  public EstadoOrdenServicio mapToDomain(EstadoOrdenServicioDTO dto) {
    EstadoOrdenServicio estadoordenservicio = new EstadoOrdenServicio();
    estadoordenservicio = modelMapper.map(dto, EstadoOrdenServicio.class);
    return estadoordenservicio;
  }

  public void delete(EstadoOrdenServicioDTO dto) {
    Optional<EstadoOrdenServicio> optional = repository.findById(dto.getId());
    if (!optional.isPresent()) {
      throw new ResourceNotFoundException(String.format("Registro %s no existe en la base de datos", dto));
    }
    EstadoOrdenServicio estadoordenservicio = optional.get();
    repository.delete(estadoordenservicio);

  }

  @Override
  public Usuario guardarUsuario(Usuario usuario) {
    // TODO Auto-generated method stub
    return null;
  }
}

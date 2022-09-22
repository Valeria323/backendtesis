package ec.edu.insteclrg.service.crud;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.insteclrg.domain.FacturaDetalle;
import ec.edu.insteclrg.domain.Usuario;
import ec.edu.insteclrg.dto.FacturaDetalleDTO;
import ec.edu.insteclrg.persistence.FacturaDetalleRepository;
import ec.edu.insteclrg.service.GenericCrudServiceImpl;

@Service
public class FacturaDetalleService extends GenericCrudServiceImpl<FacturaDetalle, FacturaDetalleDTO> {

  @Autowired
  private FacturaDetalleRepository repository;
  private ModelMapper modelMapper = new ModelMapper();

  @Override
  public Optional<FacturaDetalle> find(FacturaDetalleDTO dto) {
    return repository.findById(dto.getId());
  }

  @Override
  public FacturaDetalleDTO mapToDto(FacturaDetalle domain) {
    return modelMapper.map(domain, FacturaDetalleDTO.class);
  }

  @Override
  public FacturaDetalle mapToDomain(FacturaDetalleDTO dto) {
    return modelMapper.map(dto, FacturaDetalle.class);
  }

  @Override
  public Usuario guardarUsuario(Usuario usuario) {
    // TODO Auto-generated method stub
    return null;
  }
}

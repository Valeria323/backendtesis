package ec.edu.insteclrg.service.crud;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.insteclrg.domain.Factura;
import ec.edu.insteclrg.domain.Usuario;
import ec.edu.insteclrg.dto.FacturaDTO;
import ec.edu.insteclrg.persistence.FacturaRepository;
import ec.edu.insteclrg.service.GenericCrudServiceImpl;

@Service
public class FacturaService extends GenericCrudServiceImpl<Factura, FacturaDTO> {

  @Autowired
  private FacturaRepository repository;
  private ModelMapper modelMapper = new ModelMapper();

  @Override
  public Optional<Factura> find(FacturaDTO dto) {
    return repository.findById(dto.getId());
  }

  @Override
  public FacturaDTO mapToDto(Factura domain) {
    return modelMapper.map(domain, FacturaDTO.class);
  }

  @Override
  public Factura mapToDomain(FacturaDTO dto) {
    return modelMapper.map(dto, Factura.class);
  }

  @Override
  public Usuario guardarUsuario(Usuario usuario) {
    // TODO Auto-generated method stub
    return null;
  }
}

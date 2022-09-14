package ec.edu.insteclrg.service.crud;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.insteclrg.common.exception.ResourceNotFoundException;
import ec.edu.insteclrg.domain.Producto;
import ec.edu.insteclrg.dto.ProductoDTO;
import ec.edu.insteclrg.persistence.ProductoRepository;
import ec.edu.insteclrg.service.GenericCrudServiceImpl;

@Service
public class ProductoService extends GenericCrudServiceImpl<Producto, ProductoDTO> {

  @Autowired
  private ProductoRepository repository;

  private ModelMapper modelMapper = new ModelMapper();

  @Override
  public Optional<Producto> find(ProductoDTO dto) {
    return repository.findById(dto.getId());
  }

  @Override
  public List<ProductoDTO> findAll(ProductoDTO dto) {
    return repository.findAll().stream().map(obj -> mapToDto(obj)).collect(Collectors.toList());
  }

  @Override
  public ProductoDTO mapToDto(Producto domain) {
    ProductoDTO productoDTO = new ProductoDTO();
    productoDTO = modelMapper.map(domain, ProductoDTO.class);
    return productoDTO;
  }

  @Override
  public Producto mapToDomain(ProductoDTO dto) {
    Producto producto = new Producto();
    producto = modelMapper.map(dto, Producto.class);
    return producto;
  }

  public void delete(ProductoDTO dto) {
    Optional<Producto> optional = repository.findById(dto.getId());
    if (!optional.isPresent()) {
      throw new ResourceNotFoundException(String.format("Registro %s no existe en la base de datos", dto));
    }
    Producto producto = optional.get();
    repository.delete(producto);

  }
}

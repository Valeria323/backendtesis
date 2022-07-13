package ec.edu.insteclrg.service.crud;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.insteclrg.domain.Producto;
import ec.edu.insteclrg.dto.ProductoDTO;
import ec.edu.insteclrg.persistence.ProductoRepository;
import ec.edu.insteclrg.service.GenericCrudServiceImpl;

@Service
public class ProductoService extends GenericCrudServiceImpl<Producto, ProductoDTO>{

	@Autowired
	private ProductoRepository repository;

	private ModelMapper modelMapper = new ModelMapper();

	@Override
	public Optional<Producto> find(ProductoDTO dto) {
		return repository.findById(dto.getId());
	}

	@Override
	public ProductoDTO mapToDto(Producto domain) {
		ProductoDTO productoDTO = new ProductoDTO();
		// productoDTO.setId(domain.getId());
		// productoDTO.setCodigo(domain.getCodigo());
		// productoDTO.setNombre(domain.getNombre());
		productoDTO = modelMapper.map(domain, ProductoDTO.class);
		return productoDTO;
	}

	@Override
	public Producto mapToDomain(ProductoDTO dto) {
		Producto producto = new Producto();
		// producto.setId(dto.getId());
		// producto.setCodigo(dto.getCodigo());
		// producto.setNombre(dto.getNombre());
		producto = modelMapper.map(dto, Producto.class);
		return producto;
	}
	
}

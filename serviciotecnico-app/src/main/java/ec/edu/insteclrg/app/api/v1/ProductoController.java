package ec.edu.insteclrg.app.api.v1;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import ec.edu.insteclrg.common.dto.ApiResponseDTO;
import ec.edu.insteclrg.domain.Producto;
import ec.edu.insteclrg.dto.ProductoDTO;
import ec.edu.insteclrg.service.crud.IServicioSubidaArchivos;
import ec.edu.insteclrg.service.crud.ProductoService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/api/v1.0/producto")
public class ProductoController {

  @Autowired
  ProductoService service;

  @Autowired
  private IServicioSubidaArchivos subirImagen;

  @PostMapping
  public ResponseEntity<Object> save(@RequestBody ProductoDTO dto) {
    service.save(dto);
    return new ResponseEntity<>(new ApiResponseDTO<>(true, null),
        HttpStatus.CREATED);
  }

  @PostMapping("/subir")
  public ResponseEntity<Object> save(@RequestParam MultipartFile imagen) throws IOException {
    System.out.println("*********************************imagen");
    String nombreImagen = subirImagen.guardarImagen(imagen);
    System.out.println(nombreImagen);
    // service.save(dto);
    return new ResponseEntity<>(new ApiResponseDTO<>(true, nombreImagen), HttpStatus.CREATED);
  }

  @PutMapping
  public ResponseEntity<Object> update(@RequestBody ProductoDTO dto) {
    service.update(dto);
    return new ResponseEntity<>(new ApiResponseDTO<>(true, null), HttpStatus.CREATED);
  }

  @GetMapping
  public ResponseEntity<Object> findAll() {
    List<ProductoDTO> list = service.findAll(new ProductoDTO());
    if (!list.isEmpty()) {
      ApiResponseDTO<List<ProductoDTO>> response = new ApiResponseDTO<>(true, list);
      return (new ResponseEntity<Object>(response, HttpStatus.OK));
    } else {
      return new ResponseEntity<>(new ApiResponseDTO<>(false, null), HttpStatus.NOT_FOUND);
    }
  }

  @GetMapping(path = "/{codigo}")
  public ResponseEntity<Object> find(@PathVariable String codigo) {
    ProductoDTO dto = new ProductoDTO();
    dto.setCodigo(codigo);
    Optional<Producto> producto = service.find(dto);
    if (producto.isPresent()) {
      ApiResponseDTO<Producto> response = new ApiResponseDTO<>(true, producto.get());
      return (new ResponseEntity<Object>(response, HttpStatus.OK));
    } else {
      return new ResponseEntity<>(new ApiResponseDTO<>(false, null), HttpStatus.NOT_FOUND);
    }
  }

  @DeleteMapping
  public ResponseEntity<Object> delete(@RequestBody ProductoDTO dto) {
    service.delete(dto);
    return new ResponseEntity<>(new ApiResponseDTO<>(true, null), HttpStatus.OK);
  }
}

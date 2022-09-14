package ec.edu.insteclrg.service.crud;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class IServicioSubidaArchivos {
  private String directorioImagen = "imagenes//";

  public String guardarImagen(MultipartFile imagen) throws IOException {
    String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyMMddHHmmss"));
    if (!imagen.isEmpty()) {
      byte[] imagenBytes = imagen.getBytes();
      Path directorio = Paths.get(directorioImagen + date + ".jpg");
      System.out.println("imagennnn" + imagen);
      Files.write(directorio, imagenBytes);
      return date;
    }
    return "avatarArticulo.jpg";
  }

  public void eliminarImagen(String nombreImagen) {

    File imagen = new File(directorioImagen + nombreImagen + ".jpg");
    imagen.delete();
  }
}

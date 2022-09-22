package ec.edu.insteclrg.service.manejoExepciones;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

// import ec.edu.insteclrg.service.manejoExepciones.DetallesErrores;

@ControllerAdvice
public class ExepcionesGlobales {

  @ExceptionHandler(ExepcionRecursoNoEncontrado.class)
  public ResponseEntity<DetallesErrores> manejarResourceNotFoundExeption(ExepcionRecursoNoEncontrado exepetion,
      WebRequest webRequest) {
    DetallesErrores detallesErrores = new DetallesErrores(new Date(), exepetion.getMessage(),
        webRequest.getDescription(false));
    return new ResponseEntity<>(detallesErrores, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(ExepcionEcommerce.class)
  public ResponseEntity<DetallesErrores> manejarEccomerceExeption(ExepcionEcommerce exepetion,
      WebRequest webRequest) {
    DetallesErrores detallesErrores = new DetallesErrores(new Date(), exepetion.getMessage(),
        webRequest.getDescription(false));
    return new ResponseEntity<>(detallesErrores, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<DetallesErrores> manejarGlobalExeption(
      Exception exepetion,
      WebRequest webRequest) {
    DetallesErrores detallesErrores = new DetallesErrores(new Date(), exepetion.getMessage(),
        webRequest.getDescription(false));
    return new ResponseEntity<>(detallesErrores, HttpStatus.INTERNAL_SERVER_ERROR);
  }
}

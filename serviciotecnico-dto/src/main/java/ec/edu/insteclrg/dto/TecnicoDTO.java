package ec.edu.insteclrg.dto;

import lombok.Data;

@Data
public class TecnicoDTO {
  private long id;

  private long cedula;

  private String nombre;

  private String apellido;

  private String email;

  private String telefono;

  private String direccion;

  private CiudadDTO ciudad;

  private EmpresaDTO empresa;

}

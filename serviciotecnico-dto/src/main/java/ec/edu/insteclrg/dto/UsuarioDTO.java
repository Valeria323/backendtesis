package ec.edu.insteclrg.dto;

import lombok.Data;

@Data
public class UsuarioDTO {

  private long id;

  private String nombre;

  private String apellido;

  private String userName;

  private String email;

  private String direccion;

  private String telefono;

  private String rol;

  private String password;

}

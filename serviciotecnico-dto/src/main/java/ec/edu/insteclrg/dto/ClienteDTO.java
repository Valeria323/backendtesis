package ec.edu.insteclrg.dto;

import lombok.Data;

@Data
public class ClienteDTO {

	private long id;

	private String nombres;

	private String apellidos;
	
	private long dni;

	private String direccion;

	private Long telefono;
	
	private long celular;

	private String email;

	private String estado;
	
}

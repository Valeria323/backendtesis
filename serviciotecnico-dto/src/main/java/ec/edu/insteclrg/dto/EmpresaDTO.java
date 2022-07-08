package ec.edu.insteclrg.dto;


import lombok.Data;


@Data
public class EmpresaDTO {
	
	private long id;

	private String ruc;

	private String nombre;

	private String direccion;
	
	private CiudadDTO ciudad;
	
	private String telefono;
	
	private String email;
	
	private float porcentajeIVA;
}

package ec.edu.insteclrg.dto;


import lombok.Data;


@Data
public class EmpresaDTO {
	
	private long id;

	private String ruc;

	private String name;

	private String address;
	
	private CiudadDTO ciudad;
	
	private String phone;
	
	private String email;
}

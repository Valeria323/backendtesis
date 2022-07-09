package ec.edu.insteclrg.dto;


import lombok.Data;

@Data
public class FormaPagoDTO {
	private long id;

	private String codigo;

	private String nombre;

	private EmpresaDTO empresa;
	
}

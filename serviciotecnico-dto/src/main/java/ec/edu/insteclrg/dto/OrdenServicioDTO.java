package ec.edu.insteclrg.dto;

import lombok.Data;

@Data
public class OrdenServicioDTO {
	
	private long id;
	
	private String numberOrder;
	
	private ClienteDTO cliente; 
	
	private String dateInput; 

	private String date; 

	private EstadoOrdenServicioDTO estadoOrdenServicio; 

	private String valueFin;

	private TecnicoDTO tecnico;

	private EmpresaDTO empresa;

}

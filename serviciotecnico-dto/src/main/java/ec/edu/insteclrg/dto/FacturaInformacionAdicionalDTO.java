package ec.edu.insteclrg.dto;

import lombok.Data;

@Data
public class FacturaInformacionAdicionalDTO {
	
	private long id;
	
	private FacturaDTO factura;

	private String nombre;
	
	private String descripcion;
	
	private EmpresaDTO empresa;
	

}

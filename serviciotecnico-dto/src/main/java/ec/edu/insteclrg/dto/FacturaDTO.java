package ec.edu.insteclrg.dto;

import java.time.LocalDate;
import java.util.Date;

import lombok.Data;

@Data
public class FacturaDTO {
	private long id;

	private String numero;

	private EmpresaDTO empresa;
	
	private ClienteDTO cliente;

	private LocalDate fechaEmision;
	
	private String guiaRemision;
	
	private float subtotalIVA;
	
	private float subtotalSinIVA;
	
	private float descuento;
	
	private float valorIVA;
	
	private float total;
	
	/*private OrdenServicioDTO ordenServicio;*/

}

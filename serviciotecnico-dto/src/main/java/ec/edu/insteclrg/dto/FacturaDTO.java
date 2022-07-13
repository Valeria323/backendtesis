package ec.edu.insteclrg.dto;

import java.time.LocalDate;
import lombok.Data;

@Data
public class FacturaDTO {
	private long id;

	private String numero;
	
	private String numeroEstablecimiento;
	
	private String numeroPuntoEmision;
	
	private String numeroSecuencial;
	
	private String codigoAcceso;

	private EmpresaDTO empresa;
	
	private ClienteDTO cliente;

	private LocalDate fechaEmision;
	
	private String guiaRemision;
	
	private float subtotalIVA;
	
	private float subtotalSinIVA;
	
	private float descuento;
	
	private float valorIVA;
	
	private float total;
	
	private OrdenServicioDTO ordenServicio;

}

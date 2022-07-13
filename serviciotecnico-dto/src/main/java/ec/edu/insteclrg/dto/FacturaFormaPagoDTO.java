package ec.edu.insteclrg.dto;

import lombok.Data;

@Data
public class FacturaFormaPagoDTO {
private long id;
	
private FacturaDTO factura;

private String codigo;

private String nombre;

private Float valor;

private EmpresaDTO empresa;

}

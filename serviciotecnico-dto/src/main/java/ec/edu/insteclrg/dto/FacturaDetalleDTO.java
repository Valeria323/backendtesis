package ec.edu.insteclrg.dto;

import lombok.Data;

@Data
public class FacturaDetalleDTO {
	private long id;

	private FacturaDTO factura;
	
	private float cantidad;

	private String codigoProducto;
	
	private String descripcion;
	
	private float precioUnitario;
	
	private float descuento;
	
	private float porcentajeIVA;
	
	private float valorIVA;
	
	private float total;

}

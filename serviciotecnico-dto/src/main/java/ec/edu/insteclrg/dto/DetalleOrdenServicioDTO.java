package ec.edu.insteclrg.dto;

import lombok.Data;

@Data
public class DetalleOrdenServicioDTO {
	
	private long id;
	
	private OrdenServicioDTO orden_servicio;
	
	private float cantidad;
		
	private ProductoDTO producto;
	
	private String descripcion;
	
	private float precio_unitario;
	
	private float descuento;

	private float porcentaje_IVA;
	
	private float valor_IVA;
	
	private float total;
	
	private String diagnostico_recepcion;
	
	private String diagnostico_tecnico;

	private String descripcion_diagnostico_tecnico;

	private EstadoOrdenServicioDTO estado_orden_servcio;
	
}

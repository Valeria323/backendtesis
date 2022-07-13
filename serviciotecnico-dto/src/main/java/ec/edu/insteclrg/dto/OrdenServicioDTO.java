package ec.edu.insteclrg.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class OrdenServicioDTO {
	
	private long id;
	
	private String numero_orden;
	
	private EmpresaDTO empresa;
	
	private ClienteDTO cliente;
	
	private LocalDate fecha_emision; 

	private EstadoOrdenServicioDTO estado_orden_servicio;
	
	private float sub_total_con_IVA;
	
	private float sub_total_sin_IVA;
	
	private TecnicoDTO tecnico;

	private float descuento;
	
	private float valor_IVA;
	
	private float total;
	
	private String observaciones;
	
}

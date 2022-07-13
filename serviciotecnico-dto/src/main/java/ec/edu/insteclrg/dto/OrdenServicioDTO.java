package ec.edu.insteclrg.dto;

import lombok.Data;

@Data
public class OrdenServicioDTO {
	
	private long id;
	
	private String number_order;
	
	private EmpresaDTO enterprise;
	
	private ClienteDTO client;
	
	private String date_issiue; 

	private EstadoOrdenServicioDTO service_order_status;
	
	private String sub_total_with_IVA;
	
	private String sub_total_without_IVA;
	
	private TecnicoDTO tecnic;

	private String discount;
	
	private String value_IVA;
	
	private String total;
	
	private String observations;
	
}

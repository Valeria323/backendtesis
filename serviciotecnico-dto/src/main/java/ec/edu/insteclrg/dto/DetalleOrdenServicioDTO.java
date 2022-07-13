package ec.edu.insteclrg.dto;

import lombok.Data;

@Data
public class DetalleOrdenServicioDTO {
	
	private long id;
	
	private OrdenServicioDTO service_order_id;
	
	private String quantity;
		
	private ProductoDTO product_code; 
	
	private String description; 
	
	private String unit_price;
	
	private String discount;

	private String IVA_percentaje;
	
	private String IVA_value;
	
	private String total;
	
	private String diagnosis_reception;
	
	private String technical_diagnosis;

	private String description_technical_diagnosis;

	private EstadoOrdenServicioDTO service_order_status_id; 
}

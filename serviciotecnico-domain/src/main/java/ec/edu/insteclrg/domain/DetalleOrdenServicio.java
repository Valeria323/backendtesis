package ec.edu.insteclrg.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class DetalleOrdenServicio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false)
	private long id;
	
	@ManyToOne
	@JoinColumn(name ="service_order_id")
	private OrdenServicio service_order;
	
	@Column(nullable = true, unique= true )
	private String quantity;
		
	@ManyToOne
	@JoinColumn(name ="product_code")
	private Producto product; 
	
	@Column(nullable = true)
	private String description; 
	
	@Column(nullable = true)
	private String unit_price;
	
	@Column(nullable = true)
	private String discount;
	
	@Column(nullable = true)
	private String IVA_percentaje;
	
	@Column(nullable = true)
	private String IVA_value;
	
	@Column(nullable = true)
	private String total;
	
	@Column(nullable = true)
	private String diagnosis_reception;
	
	@Column(nullable = true)
	private String technical_diagnosis;
	
	@Column(nullable = true)
	private String description_technical_diagnosis;
	
	@ManyToOne
	@JoinColumn(name ="service_order_status_id")
	private EstadoOrdenServicio service_order_status; 
}

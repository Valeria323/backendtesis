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
public class OrdenServicio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false)
	private long id;
	
	@Column(nullable = true, name= "number_order")
	private String numOrder;
	
	@ManyToOne
	@JoinColumn(name ="enterprise_id")
	private Empresa enterprise;
	
	@ManyToOne
	@JoinColumn(name ="client_id")
	private Cliente client;
	
	@Column(nullable = true)
	private String date_issiue; 

	@ManyToOne
	@JoinColumn(name ="service_order_status_id")
	private EstadoOrdenServicio service_order_status;
	
	@Column(nullable = true)
	private String sub_total_with_IVA;
	
	@Column(nullable = true)
	private String sub_total_without_IVA;
	
	@ManyToOne
	@JoinColumn(name ="tecnic_id")
	private Tecnico tecnic;

	@Column(nullable = true)
	private String discount;
	
	@Column(nullable = true)
	private String value_IVA;
	
	@Column(nullable = true)
	private String total;
	
	@Column(nullable = true)
	private String observations;
}
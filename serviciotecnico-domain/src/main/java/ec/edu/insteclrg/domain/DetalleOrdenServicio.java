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
	@JoinColumn(name ="id_orden_servicio")
	private OrdenServicio orden_servicio;
	
	@Column(nullable = true, unique= true )
	private float cantidad;
		
	@ManyToOne
	@JoinColumn(name ="codigo_producto")
	private Producto producto; 
	
	@Column(nullable = true)
	private String description; 
	
	@Column(nullable = true)
	private float precio_unitario;
	
	@Column(nullable = true)
	private float descuento;
	
	@Column(nullable = true)
	private float porcentaje_IVA;
	
	@Column(nullable = true)
	private float valor_IVA;
	
	@Column(nullable = true)
	private float total;
	
	@Column(nullable = true)
	private String diagnostico_recepcion;
	
	@Column(nullable = true)
	private String diagnostico_tecnico;;
	
	@Column(nullable = true)
	private String descripcion_diagnostico_tecnico;
	
	@ManyToOne
	@JoinColumn(name ="id_estado_orden_servcio")
	private EstadoOrdenServicio estado_orden_servcio; 
	
}

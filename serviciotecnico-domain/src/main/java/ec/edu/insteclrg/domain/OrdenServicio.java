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
	
	@Column(nullable = true, unique= true )
	private String numberOrder;
	
	@ManyToOne
	@JoinColumn(name ="idCliente")
	private Cliente cliente; 
	
	@Column(nullable = true)
	private String dateInput; 
	
	@Column(nullable = true)
	private String dateFin; 
	
	@ManyToOne
	@JoinColumn(name ="id_estado_orden_servicio")
	private EstadoOrdenServicio estadoOrdenServicio; 
	
	@Column(nullable = true)
	private String valueFin;
	
	@ManyToOne
	@JoinColumn(name ="id_tecnico")
	private Tecnico tecnico;
	
	@ManyToOne
	@JoinColumn(name ="id_empresa")
	private Empresa empresa;
	
}

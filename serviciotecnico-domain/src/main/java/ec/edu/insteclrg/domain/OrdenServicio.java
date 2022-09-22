package ec.edu.insteclrg.domain;

import java.time.LocalDate;

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
	
	@Column(nullable = true, name= "numero_orden")
	private String numOrden;
	
	@ManyToOne
	@JoinColumn(name ="id_empresa")
	private Empresa empresa;
	
	@ManyToOne
	@JoinColumn(name ="id_cliente")
	private Cliente cliente;
	
	@Column(nullable = true)
	private LocalDate fecha_emision; 

	@ManyToOne
	@JoinColumn(name ="id_estado_orden_servicio")
	private EstadoOrdenServicio estado_orden_servicio;
	
	@Column(nullable = true)
	private float sub_total_con_IVA;
	
	@Column(nullable = true)
	private float sub_total_sin_IVA;
	
	@ManyToOne
	@JoinColumn(name ="id_tecnico")
	private Tecnico tecnico;

	@Column(nullable = true)
	private float descuento;
	
	@Column(nullable = true)
	private float valor_IVA;
	
	@Column(nullable = true)
	private float total;
	
	@Column(nullable = true)
	private String observaciones;
}
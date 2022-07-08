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
public class Factura {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false)
	private long id;

	@Column(nullable = false)
	private String numero;

	@ManyToOne(optional = false)
	@JoinColumn(name = "empresa_id")
	private Empresa empresa;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;

	@Column(nullable = false)
	private LocalDate fechaEmision;

	@Column(nullable = false)
	private String guiaRemision;
	
	@Column(nullable = false)
	private float subtotalIVA;
	
	@Column(nullable = false)
	private float subtotalSinIVA;
	
	@Column(nullable = false)
	private float descuento;
	
	@Column(nullable = false)
	private float valorIVA;
	
	@Column(nullable = false)
	private float total;
	
	/*@ManyToOne(optional = false)
	@JoinColumn(name = "ordenServicio_id")
	private OrdenServicio ordenServicio;*/
}

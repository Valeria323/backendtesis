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
public class FacturaDetalle {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false)
	private long id;

	@ManyToOne(optional = false)
	@JoinColumn(name = "factura_id")
	private Factura factura;

	@Column(nullable = false)
	private long cantidad;

	@Column(nullable = false)
	private String codigoProducto;
	
	@Column(nullable = false)
	private String descripcion;
	
	@Column(nullable = false)
	private float precioUnitario;
	
	@Column(nullable = false)
	private float descuento;
	
	@Column(nullable = false)
	private float porcentajeIVA;
	
	@Column(nullable = false)
	private float valorIVA;
	
	@Column(nullable = false)
	private float total;

}

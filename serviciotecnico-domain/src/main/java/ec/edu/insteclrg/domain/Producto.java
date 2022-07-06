package ec.edu.insteclrg.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false)
	private long id;

	@Column(nullable = false, unique = true)
	private String codigo;

	@Column(nullable = false)
	private String nombre;

	@Column(nullable = false)
	private String precioventa;

	@Column(nullable = false)
	private String stockMin;
	
	@Column(nullable = false)
	private String stockMax;

	@Column(nullable = false)
	private String stock;
	
	@Column(nullable = false)
	private String controlaStock;

	@Column(nullable = false)
	private String aplicaIva ;

}

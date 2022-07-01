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
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false)
	private long id;

	@Column(nullable = false)
	private String nombres;

	@Column(nullable = false)
	private String apellidos;
	
	@Column(nullable = false, unique = true)
	private Long dni;
	
	@Column(nullable = false)
	private String direccion;
	
	@Column(nullable = false)
	private Long telefono;
	
	@Column(nullable = false)
	private Long celular;
	
	@Column(nullable = false, unique = true)
	private String email;
	
	@Column(nullable = false)
	private boolean isActive;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "tipoCliente_id")
   	private TipoCliente tipoCliente;
	
}

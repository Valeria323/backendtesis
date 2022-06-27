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
public class Clientes {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false)
	private long id;

	@Column(nullable = false, unique = true)
	private String nombres;

	@Column(nullable = false, unique = true)
	private String apellidos;
	
	@Column(nullable = false, unique = true)
	private Long dni;
	
	@Column(nullable = false, unique = true)
	private String direccion;
	
	@Column(nullable = false, unique = true)
	private Long telefono;
	
	@Column(nullable = false, unique = true)
	private Long celular;
	
	@Column(nullable = false, unique = true)
	private String email;
	
	@Column(nullable = false, unique = true)
	private String estado;
	
	@Column(nullable = false, unique = true)
	private String idTipoCliente;
	
}

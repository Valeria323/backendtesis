package ec.edu.insteclrg.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Tecnico {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false)
	private long id;
	
	@Column(nullable = false, unique = true)
    private long cedula;
	
	@Column(nullable = false)
	private String nombre; 
	
	@Column(nullable = false)
    private String apellido;
	
	@Column(nullable = false)
    private String email;
	
	@Column(nullable = false)
    private String telefono;
	
	@Column(nullable = false)
    private String direccion;
	
	
	/*idciudad*/
}

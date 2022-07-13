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
public class PuntoEmision {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false)
	private long id;
	
	@Column(nullable = true)
	private String nombre;
	
	@Column(nullable = true, name="numero_establecimiento")
	private String numEstablecimiento;
	
	@Column(nullable = true, name="numero_punto_emision")
	private String numPuntoEmision;
	
	@Column(nullable = true, name="numero_secuencial")
	private String numSecuencial;
}

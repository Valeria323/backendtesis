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
	
	@Column(nullable = true, unique= true )
	private String name;
	
	@ManyToOne
	@JoinColumn(name ="idTipoOrden")
	private TipoOrdenServicio tipoordenservicio; 
	
	@ManyToOne
	@JoinColumn(name ="idDiagnostico")
	private Marca marca; 
	
	@Column(nullable = true)
	private String diagnosticReception; 
	
	@Column(nullable = true)
	private String accesories; 
	
	@ManyToOne
	@JoinColumn(name ="idOrdenServicio")
	private OrdenServicio ordenservicio;
	
	@Column(nullable = true)
	private String diagnosticTecnic;
	
	@Column(nullable = true)
	private String descriptionSolutionTecnic;
}

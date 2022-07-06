package ec.edu.insteclrg.dto;

import lombok.Data;

@Data
public class DetalleOrdenServicioDTO {

	private long id;

	private String name;

	private TipoOrdenServicioDTO tipoOrdenServicio; 

	private String diagnosticReception; 

	private String accesories; 

	private OrdenServicioDTO ordenServicio;

	private String diagnosticTecnic;

	private String descriptionSolutionTenic;

}

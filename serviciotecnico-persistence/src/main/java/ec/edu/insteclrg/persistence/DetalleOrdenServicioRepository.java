package ec.edu.insteclrg.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.edu.insteclrg.domain.DetalleOrdenServicio;

public interface DetalleOrdenServicioRepository extends JpaRepository<DetalleOrdenServicio, Long>{

	Optional<DetalleOrdenServicio> findById(long id);
	
}

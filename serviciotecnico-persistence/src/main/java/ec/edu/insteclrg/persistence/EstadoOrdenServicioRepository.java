package ec.edu.insteclrg.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ec.edu.insteclrg.domain.EstadoOrdenServicio;

@Repository
public interface EstadoOrdenServicioRepository extends JpaRepository<EstadoOrdenServicio, Long> {
 
	Optional<EstadoOrdenServicio> findById(Long id);
	
}

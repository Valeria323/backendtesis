package ec.edu.insteclrg.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.edu.insteclrg.domain.FacturaDetalle;

public interface FacturaDetalleRepository extends JpaRepository<FacturaDetalle, Long> {

	Optional<FacturaDetalle> findById(Long id);
}

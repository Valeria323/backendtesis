package ec.edu.insteclrg.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ec.edu.insteclrg.domain.FacturaFormaPago;

@Repository
public interface FacturaFormaPagoRepository extends JpaRepository<FacturaFormaPago, Long> {
	Optional<FacturaFormaPago> findById(Long id);
}

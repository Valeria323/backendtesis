package ec.edu.insteclrg.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.edu.insteclrg.domain.FacturaFormaPago;



public interface FacturaFormaPagoRepository extends JpaRepository<FacturaFormaPago, Long> {
	Optional<FacturaFormaPago> findById(Long id);
}

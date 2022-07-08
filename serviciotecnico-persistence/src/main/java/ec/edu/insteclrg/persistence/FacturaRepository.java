package ec.edu.insteclrg.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ec.edu.insteclrg.domain.Factura;

@Repository
public interface FacturaRepository extends JpaRepository<Factura, Long> {

	Optional<Factura> findById(Long id);
}

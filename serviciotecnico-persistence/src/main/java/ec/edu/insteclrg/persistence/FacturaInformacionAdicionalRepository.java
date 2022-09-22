package ec.edu.insteclrg.persistence;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import ec.edu.insteclrg.domain.FacturaInformacionAdicional;

public interface FacturaInformacionAdicionalRepository extends JpaRepository<FacturaInformacionAdicional, Long> {
	Optional<FacturaInformacionAdicional> findById(Long id);
}

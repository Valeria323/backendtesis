package ec.edu.insteclrg.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ec.edu.insteclrg.domain.TarifaIVA;

@Repository
public interface TarifaIVARepository extends JpaRepository<TarifaIVA, Long>{
	Optional<TarifaIVA> findByCode(String code);
}

package ec.edu.insteclrg.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ec.edu.insteclrg.domain.PuntoEmision;

@Repository
public interface PuntoEmisionRepository extends JpaRepository<PuntoEmision, Long>{

	Optional<PuntoEmision> findById(Long id);
}

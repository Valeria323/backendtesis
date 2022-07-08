package ec.edu.insteclrg.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ec.edu.insteclrg.domain.InformacionAdicional;

@Repository
public interface InformacionAdicionalRepository extends JpaRepository<InformacionAdicional, Long> {

	Optional<InformacionAdicional> findById(String id);
}
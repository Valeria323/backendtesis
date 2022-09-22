package ec.edu.insteclrg.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ec.edu.insteclrg.domain.Ciudad;

@Repository
public interface CiudadRepository extends JpaRepository<Ciudad, Long> {

}

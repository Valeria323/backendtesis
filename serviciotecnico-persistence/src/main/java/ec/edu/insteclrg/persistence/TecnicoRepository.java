package ec.edu.insteclrg.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ec.edu.insteclrg.domain.Tecnico;

@Repository
public interface TecnicoRepository extends JpaRepository<Tecnico, Long> {
	

}

package ec.edu.insteclrg.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import ec.edu.insteclrg.domain.TipoOrdenServicio;

@Repository
public interface TipoOrdenServicioRepository extends JpaRepository<TipoOrdenServicio, Long> {
	
	Optional<TipoOrdenServicio> findByCode(String code);
}


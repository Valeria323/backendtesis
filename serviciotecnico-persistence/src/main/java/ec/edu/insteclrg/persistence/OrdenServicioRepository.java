package ec.edu.insteclrg.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.edu.insteclrg.domain.OrdenServicio;

public interface OrdenServicioRepository extends JpaRepository<OrdenServicio, Long> {

	Optional<OrdenServicio> findByNumOrder(String numOrder);
}

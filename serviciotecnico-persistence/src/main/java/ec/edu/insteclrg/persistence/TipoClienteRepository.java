package ec.edu.insteclrg.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.edu.insteclrg.domain.TipoCliente;

public interface TipoClienteRepository extends JpaRepository<TipoCliente, Long>{
	
	Optional<TipoCliente> findById(Long id);

}

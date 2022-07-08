package ec.edu.insteclrg.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ec.edu.insteclrg.domain.FormaPago;
@Repository
public interface FormaPagoRepository extends JpaRepository<FormaPago ,Long> {
	
	Optional<FormaPago> findByCodigo(String codigo);

}

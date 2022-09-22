package ec.edu.insteclrg.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ec.edu.insteclrg.domain.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long>  {

	Optional<Producto> findById(String id);
}

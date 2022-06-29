package ec.edu.insteclrg.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ec.edu.insteclrg.domain.Marca;

@Repository
public interface MarcaRepository extends JpaRepository<Marca, Long> {

}

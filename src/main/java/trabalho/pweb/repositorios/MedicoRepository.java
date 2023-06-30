package trabalho.pweb.repositorios;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import trabalho.pweb.entidades.Medico;



public interface MedicoRepository extends JpaRepository<Medico, Long>{
	List<Medico> findByNomeContaining(String nome);
}

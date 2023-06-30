package repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import trabalho.pweb.entidades.Consulta;

public interface ConsultaRepository extends JpaRepository<Consulta, Long>{

	List<Consulta> findByNomeContaining(String nome);
	
	List<Consulta> findAll();

}

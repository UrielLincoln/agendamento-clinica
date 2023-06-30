package trabalho.pweb.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import trabalho.pweb.entidades.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long>{

	List<Paciente> findByNomeContaining(String nome);

}

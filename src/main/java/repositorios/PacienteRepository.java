package repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import trabalho.pweb.entidades.Paciente;

public interface PacienteRepository extends JpaRepository{

	List<Paciente> findByNomeContaining(String nome);

}

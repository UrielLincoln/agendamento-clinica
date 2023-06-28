package trabalho.pweb.entidades;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity(name = "pacientes")
@Data
public class Paciente {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false, unique = true)
	private String email;
	
	@Column(nullable = false, unique = true)
	private String CPF;
	
	@Column(nullable = false, unique = true)
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "contato_id")
	private List<Telefone> telefone;
	private Endereco endereco;
	
	
	
	
	
	
}

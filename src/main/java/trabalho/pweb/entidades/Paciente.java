package trabalho.pweb.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
	//@OneToMany(cascade = CascadeType.ALL)
	//@JoinColumn(name = "contato_id")
	private String telefone;
	
	@Column(nullable = false, unique = true)
	private Endereco endereco;
	
	@Column(columnDefinition = "boolean default false")
    private boolean inativo;
	
	
	
	
	
}

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
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Entity(name = "medicos")
@Data
public class Medico {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String nome;
	
	@Email
	@Column(nullable = false, unique = true)
	private String email;
	
	@Column(nullable = false, unique = true)
	private String CRM;
	
	@Column(nullable = false, unique = true)
	//@OneToMany(cascade = CascadeType.ALL)
	//@JoinColumn(name = "contato_id")
	private String telefone;
	
	@Enumerated(EnumType.STRING)
	private Especialidades especialidade;
	
	@OneToOne
    @JoinColumn(name = "idEndereco", referencedColumnName = "idEndereco")
	private Endereco endereco;

	@Column(columnDefinition = "boolean default false")
    private boolean inativo;
	
	
	
}

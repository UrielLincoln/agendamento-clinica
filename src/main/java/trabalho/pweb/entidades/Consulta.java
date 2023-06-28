package trabalho.pweb.entidades;

import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity(name = "tb_consulta")
@Data
public class Consulta {
	
	public Consulta() {		
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private int minuto;
	private int hora;
	private int dias;
	private int mês;
	private int ano;
	
	@OneToOne
	@JoinColumn(name = "id_cpf")
	private Paciente paciente;
	
	@OneToOne
	@JoinColumn(name = "id_crm")
	private Medico medico;	

}

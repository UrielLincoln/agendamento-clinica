package trabalho.pweb.entidades;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity(name = "tb_consulta")
public class Consulta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
    private LocalDateTime horarioEntrada;
	
	@NotNull
    private LocalDateTime horarioSaida;

	@NotNull
    private LocalDate data;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_paciente")
	private Paciente paciente;
	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_medico")
	private Medico medico;

	public Consulta(Long id, @NotNull LocalDateTime horarioEntrada,
			@NotNull LocalDate data, Paciente paciente, Medico medico) {
		super();
		this.id = id;
		this.horarioEntrada = horarioEntrada;
		this.horarioSaida = horarioSaida.plusHours(1);
		this.data = data;
		this.paciente = paciente;
		this.medico = medico;
	}	
	
	

	
	
}
package trabalho.pweb.dtos;

import lombok.Data;
import trabalho.pweb.entidades.Especialidades;


public record MedicoDto(String nome,
		String email,
		String CRM,
		Especialidades especialidade
		) {

}

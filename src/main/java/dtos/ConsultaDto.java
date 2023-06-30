package dtos;

import java.time.*;

import trabalho.pweb.entidades.Medico;
import trabalho.pweb.entidades.Paciente;

public record ConsultaDto(Paciente paciente, Medico medico, LocalDateTime data) {

}

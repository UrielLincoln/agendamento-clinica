package trabalho.pweb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.validation.ValidationException;
import lombok.Data;
import trabalho.pweb.entidades.Consulta;

@Data
public class VerificarHora {

	// validação do funcionamento dos dias da semana e horarios disponiveis
	public static boolean Verificar(Consulta consulta, ConsultaService service) throws ValidationException {
		LocalTime horarioInicio = LocalTime.of(7, 0);
		LocalTime horarioFim = LocalTime.of(19, 0);
		List<Consulta> lista = service.retornaAll();

		if (consulta.getHorarioEntrada().toLocalTime().isBefore(horarioFim)
				|| consulta.getHorarioEntrada().toLocalTime().isAfter(horarioFim)) {
			throw new ValidationException("A clínica funciona de segunda a sábado, das 07:00 às 19:00.");
		}
		if (consulta.getHorarioEntrada().getDayOfWeek() == DayOfWeek.SUNDAY) {
			throw new ValidationException("A clínica não funciona aos domingos.");
		}

		for(Consulta item: lista) {
			if (consulta.getHorarioEntrada().isAfter(item.getHorarioEntrada()) && consulta.getHorarioEntrada().isBefore(item.getHorarioSaida())) {
                throw new ValidationException("Conflito de horario com outra consulta");
            }
        }

        
		
				

		return true;
	}

}

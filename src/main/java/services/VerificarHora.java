package services;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.validation.ValidationException;

public class VerificarHora {
	
	
	public static boolean Verificar(LocalTime hora, LocalDate dia) throws ValidationException{
		LocalTime horarioInicio = LocalTime.of(7, 0); 
        LocalTime horarioFim = LocalTime.of(19, 0);
		
        //validação do funcionamento dos dias da semana e horario
        if(hora.isBefore(horarioFim)||hora.isAfter(horarioFim)) {
        	throw new ValidationException("A clínica funciona de segunda a sábado, das 07:00 às 19:00.");
        }
        if (dia.getDayOfWeek() == DayOfWeek.SUNDAY) {
            throw new ValidationException("A clínica não funciona aos domingos.");
        }
        
        
        
		
		return true;
	}
	

}

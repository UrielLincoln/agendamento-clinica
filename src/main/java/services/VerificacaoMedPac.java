package services;

import trabalho.pweb.entidades.Medico;
import trabalho.pweb.entidades.Paciente;

public class VerificacaoMedPac {

	
	public static boolean MedicoDisponivel(Medico medico) {
		if(medico.isInativo()==true) {
			return false;
		}
		else
			return true;
	}
	
	public static boolean PacienteDisponivel(Paciente paciente) {
		if(paciente.isInativo()==true) {
			return false;
		}
		else
			return true;
	}
}

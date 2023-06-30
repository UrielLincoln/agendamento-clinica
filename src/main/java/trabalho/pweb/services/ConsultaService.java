package trabalho.pweb.services;

import java.time.*;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import trabalho.pweb.dtos.ConsultaDto;
import trabalho.pweb.dtos.PacienteDto;
import trabalho.pweb.repositorios.ConsultaRepository;
import trabalho.pweb.entidades.Consulta;
import trabalho.pweb.entidades.Medico;
import trabalho.pweb.entidades.Paciente;

@Service
public class ConsultaService {

	@Autowired
	private ConsultaRepository repository;
	
	public List<ConsultaDto> converteConsulta(List<Consulta> lista){
		return lista.stream().map(consulta -> new ConsultaDto(consulta.getPaciente(), consulta.getMedico(), consulta.getHorarioEntrada())).collect(Collectors.toList());
	}
	
	public List<ConsultaDto> listar(String nome){
		//if((nome!=null) && (!nome.equalsIgnoreCase(""))) {
		//	return this.converteConsulta(this.repository.findByNomeContaining(nome));
	//	}
		return this.converteConsulta(repository.findAll());
	}
	
	public ResponseEntity<ConsultaDto> buscaporId(Long id) {
		Optional<Consulta> op=this.repository.findById(id);
		if(op.isPresent()) {
			Consulta consulta=op.get();
			return new ResponseEntity<ConsultaDto>(new ConsultaDto(consulta.getPaciente(), consulta.getMedico(), consulta.getHorarioEntrada()),HttpStatus.OK);
		}
		return new ResponseEntity<ConsultaDto>(HttpStatus.NOT_FOUND);
	}
	
	
	public ResponseEntity<ConsultaDto> cadastrar(Consulta consulta){
		
		if(VerificacaoMedPac.MedicoDisponivel(consulta.getMedico())&&VerificacaoMedPac.PacienteDisponivel(consulta.getPaciente())==true){
			repository.save(consulta);
			return new ResponseEntity<ConsultaDto>(new ConsultaDto(consulta.getPaciente(), consulta.getMedico(), consulta.getHorarioEntrada()),HttpStatus.CREATED);
		}
		
		return new ResponseEntity<ConsultaDto>(HttpStatus.NO_CONTENT);
	}
	
	
	/*public Consulta agendar(LocalTime entrada, LocalDate data, Paciente paciente, Medico medico) {
		Consulta consulta = new Consulta();
		consulta.setHorarioEntrada(entrada);
		consulta.setHorarioSaida(entrada.plusHours(1));
		consulta.setPaciente(paciente);
		consulta.setMedico(medico);;
		
		return this.repository.save(consulta);
	}*/
	
	
	
	//falta implementar pra cancelar
	public ResponseEntity<ConsultaDto> deletar(Long id){
		Optional<Consulta> Consultaop = repository.findById(id);
		if(Consultaop.isPresent()) {
			repository.delete(Consultaop.get());
			return new ResponseEntity<>(HttpStatus.OK);
		}
		else
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	

	
	
	
	
	
	
}

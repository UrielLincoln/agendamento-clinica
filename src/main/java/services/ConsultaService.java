package services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import dtos.ConsultaDto;
import repositorios.ConsultaRepository;
import trabalho.pweb.entidades.Consulta;

public class ConsultaService {

	@Autowired
	private ConsultaRepository repository;
	
	public List<ConsultaDto> converteConsulta(List<Consulta> lista){
		return lista.stream().map(consulta -> new ConsultaDto(consulta.getPaciente(), consulta.getMedico())).collect(Collectors.toList());
	}
	
	public List<ConsultaDto> listar(String nome){
		if((nome!=null) && (!nome.equalsIgnoreCase(""))) {
			return this.converteConsulta(this.repository.findByNomeContaining(nome));
		}
		return this.converteConsulta(repository.findAll());
	}
	
	public ResponseEntity<ConsultaDto> buscaporId(Long id) {
		Optional<Consulta> op=this.repository.findById(id);
		if(op.isPresent()) {
			Consulta consulta=op.get();
			return new ResponseEntity<ConsultaDto>(new ConsultaDto(consulta.getPaciente(), consulta.getMedico()),HttpStatus.OK);
		}
		return new ResponseEntity<ConsultaDto>(HttpStatus.NOT_FOUND);
	}
	
	
	public ResponseEntity<ConsultaDto> cadastrar(Consulta proj){
		Consulta consulta = repository.save(proj);
		return new ResponseEntity<ConsultaDto>(new ConsultaDto(consulta.getPaciente(), consulta.getMedico()),HttpStatus.CREATED);
		
	}
	
	
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

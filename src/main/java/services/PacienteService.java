package services;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import dtos.MedicoDto;
import dtos.PacienteDto;
import repositorios.PacienteRepository;
import trabalho.pweb.entidades.Medico;
import trabalho.pweb.entidades.Paciente;

public class PacienteService {

	@Autowired
	private PacienteRepository repository;
	
	public List<PacienteDto> convertePaciente(List<Paciente> lista){
		return lista.stream().map(paciente -> new PacienteDto(paciente.getNome(), paciente.getEmail(), paciente.getCPF())).collect(Collectors.toList());
	}
	
	
	public List<PacienteDto> listar(String nome){
		if((nome!=null) && (!nome.equalsIgnoreCase(""))) {
			List<Paciente> lista = repository.findByNomeContaining(nome);
			lista.sort(Comparator.comparing(Paciente::getNome));
			return convertePaciente(lista);
		}
		return this.convertePaciente(repository.findAll());
	}
	
	
	public ResponseEntity<PacienteDto> buscaporId(Long id) {
		Optional<Paciente> op = this.repository.findById(id);
		if(op.isPresent()) {
			Paciente paciente=op.get();
			return new ResponseEntity<PacienteDto>(new PacienteDto(paciente.getNome(), paciente.getEmail(), paciente.getCPF()),HttpStatus.OK);
		}
		return new ResponseEntity<PacienteDto>(HttpStatus.NOT_FOUND);
	}
	
	
	public ResponseEntity<PacienteDto> salvar(Paciente pac){
		Paciente paciente = (Paciente) repository.save(pac);
		return new ResponseEntity<PacienteDto>(new PacienteDto(paciente.getNome(), paciente.getEmail(), paciente.getCPF()),HttpStatus.CREATED);
		
	}
	
	//falta adicionar restriçoes
	public ResponseEntity<PacienteDto> alterar(Paciente pac, Long id){
		Optional<Paciente> op = this.repository.findById(id);
		if(op.isPresent()) {
			pac.setNome(op.get().getNome());
			pac.setTelefone(op.get().getTelefone());
			pac.setEndereco(op.get().getEndereco());
			repository.save(pac);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		
		return new ResponseEntity<PacienteDto>(HttpStatus.NOT_FOUND);
	}
	
	public ResponseEntity<PacienteDto> deletar(Long id){
		Optional<Paciente> paciente = repository.findById(id);
		if(paciente.isPresent()) {
			paciente.get().setInativo(true);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		else
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	
}

package trabalho.pweb.services;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import trabalho.pweb.dtos.MedicoDto;
import trabalho.pweb.repositorios.MedicoRepository;
import trabalho.pweb.entidades.Medico;

//A listagem deve ser ordenada pelo nome do médico, de maneira crescente, bem como ser paginada, trazendo 10 registros por página.
@Service
public class MedicoService {

	@Autowired
	private MedicoRepository repository;
	
	public List<MedicoDto> converteMedico(List<Medico> lista){
		return lista.stream().map(medico -> new MedicoDto(medico.getNome(), medico.getEmail(), medico.getCRM(), medico.getEspecialidade())).collect(Collectors.toList());
	}
	
	
	public List<MedicoDto> listar(String nome){
		if((nome!=null) && (!nome.equalsIgnoreCase(""))) {
			List<Medico> lista = repository.findByNomeContaining(nome);
			lista.sort(Comparator.comparing(Medico::getNome));
			return converteMedico(lista);
		}
		return this.converteMedico(repository.findAll());
	}
	
	
	public ResponseEntity<MedicoDto> buscaporId(Long id) {
		Optional<Medico> op = this.repository.findById(id);
		if(op.isPresent()) {
			Medico medico=op.get();
			return new ResponseEntity<MedicoDto>(new MedicoDto(medico.getNome(), medico.getEmail(), medico.getCRM(), medico.getEspecialidade()),HttpStatus.OK);
		}
		return new ResponseEntity<MedicoDto>(HttpStatus.NOT_FOUND);
	}
	
	
	public ResponseEntity<MedicoDto> salvar(Medico med){
		Medico medico = (Medico) repository.save(med);
		return new ResponseEntity<MedicoDto>(new MedicoDto(medico.getNome(), medico.getEmail(), medico.getCRM(), medico.getEspecialidade()),HttpStatus.CREATED);
		
	}
	
	//falta adicionar restriçoes
	public ResponseEntity<MedicoDto> alterar(Medico med, Long id){
		Optional<Medico> op = this.repository.findById(id);
		if(op.isPresent()) {
			med.setNome(op.get().getNome());
			med.setTelefone(op.get().getTelefone());
			med.setEndereco(op.get().getEndereco());
			repository.save(med);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		
		return new ResponseEntity<MedicoDto>(HttpStatus.NOT_FOUND);
	}
	
	public ResponseEntity<MedicoDto> deletar(Long id){
		Optional<Medico> medico = repository.findById(id);
		if(medico.isPresent()) {
			repository.delete(medico.get());
			return new ResponseEntity<>(HttpStatus.OK);
		}
		else
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	
	
}

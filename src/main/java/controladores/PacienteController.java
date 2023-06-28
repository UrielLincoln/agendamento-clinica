package controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dtos.PacienteDto;
import services.PacienteService;
import trabalho.pweb.entidades.Paciente;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
	
	@Autowired
	private PacienteService service;
	
	@GetMapping
	public List<PacienteDto> listar(@RequestParam(required = false) String nome){
		return service.listar(nome);
	}
	
	
	@PostMapping()
	public ResponseEntity<PacienteDto> cadastrar(@RequestBody Paciente paciente){
		return service.salvar(paciente);
	}
	
	
	@RequestMapping("alterar/{id}")
	public ResponseEntity<PacienteDto> alterar(@RequestBody Paciente paciente, @PathVariable("id") Long id) {
		
		return service.alterar(paciente, id);
	} 
}

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
import dtos.MedicoDto;
import services.MedicoService;
import trabalho.pweb.entidades.Medico;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

	@Autowired
	private MedicoService service;
	
	@GetMapping
	public List<MedicoDto> listar(@RequestParam(required = false) String nome){
		return service.listar(nome);
	}
	
	
	@PostMapping()
	public ResponseEntity<MedicoDto> cadastrar(@RequestBody Medico medico){
		return service.salvar(medico);
	}
	
	
	@RequestMapping("alterar/{id}")
	public ResponseEntity<MedicoDto> alterar(@RequestBody Medico medico, @PathVariable("id") Long id) {
		
		return service.alterar(medico, id);
	} 
	
	
	
	
	
	
}

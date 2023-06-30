package controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import dtos.ConsultaDto;
import dtos.PacienteDto;
import services.ConsultaService;
import trabalho.pweb.entidades.Consulta;
import trabalho.pweb.entidades.Paciente;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

	@Autowired
	private ConsultaService service;
	
	@GetMapping
	public List<ConsultaDto> listar(@RequestParam(required = false) String nome){
		return service.listar(nome);
	}
	
	
	@PostMapping("/criarconsulta")
    public ResponseEntity<ConsultaDto> create(@RequestBody Consulta consulta) throws Exception{
        return service.cadastrar(consulta);
    }
	
}

package controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dtos.ConsultaDto;
import services.ConsultaService;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

	@Autowired
	private ConsultaService service;
	
	@GetMapping
	public List<ConsultaDto> listar(@RequestParam(required = false) String nome){
		return service.listar(nome);
	}
	
	
	
}

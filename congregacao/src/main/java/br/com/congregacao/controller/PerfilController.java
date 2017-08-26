package br.com.congregacao.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.congregacao.service.PerfilService;

@Controller
@RequestMapping( value = "/autenticado" )
public class PerfilController {
	
	@Autowired
	private PerfilService perfilService;
	
	@RequestMapping( value = "/perfil" )
	public String perfil( Model model ){
		model.addAttribute( "perfil", perfilService.buscarPorDataEIdPregador(LocalDate.of(2017, 5, 25), 3) );
		return "autenticado/perfil/index";
	}
}

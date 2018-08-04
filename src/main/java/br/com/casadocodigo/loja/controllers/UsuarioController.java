package br.com.casadocodigo.loja.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.casadocodigo.loja.dao.UsuarioDAO;
import br.com.casadocodigo.loja.models.Usuario;
import br.com.casadocodigo.loja.validation.UsuarioValidation;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioDAO dao;
	
	@Autowired
	UsuarioValidation usuarioValidation;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(usuarioValidation);
	}
	
	@RequestMapping("/form")
	public ModelAndView form(Usuario usuario) {
		ModelAndView modelAndView = new ModelAndView("/usuario/cadastro");
		return modelAndView;
	}

	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView cadastra(@Valid Usuario usuario, BindingResult result) {
		if(result.hasErrors()) {
			return form(usuario);
		}
		dao.gravar(usuario);
		
		return new ModelAndView("redirect:/usuarios");
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView lista() {
		List<Usuario> usuarios = dao.listar();
		ModelAndView modelAndView = new ModelAndView("/usuario/usuarios");
		modelAndView.addObject("usuarios", usuarios);
		return modelAndView;
	}
}

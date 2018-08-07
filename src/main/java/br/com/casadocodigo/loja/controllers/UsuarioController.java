package br.com.casadocodigo.loja.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.casadocodigo.loja.dao.RoleDAO;
import br.com.casadocodigo.loja.dao.UsuarioDAO;
import br.com.casadocodigo.loja.models.Role;
import br.com.casadocodigo.loja.models.Usuario;
import br.com.casadocodigo.loja.validation.UsuarioValidation;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioDAO dao;
	
	@Autowired
	private RoleDAO roleDao;
	
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
		usuario.setSenha(new BCryptPasswordEncoder().encode(usuario.getSenha()));
		usuario.setSenhaRepetida(new BCryptPasswordEncoder().encode(usuario.getSenhaRepetida()));
		dao.gravar(usuario);
		
		return new ModelAndView("redirect:/usuarios");
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView lista() {
		List<Usuario> usuarios = dao.listarUsuariosComRoles();
		ModelAndView modelAndView = new ModelAndView("/usuario/usuarios");
		modelAndView.addObject("usuarios", usuarios);
		return modelAndView;
	}
	
	@RequestMapping("/permissoes")
	public ModelAndView permissoes(String email) {
		Usuario usuario = dao.loadUserByUsername(email);
		ModelAndView modelAndView = new ModelAndView("/usuario/permissoes","command",usuario);
		return modelAndView;
	}
	
	@ModelAttribute("rolesList")
	public List<Role> getRoles(){
		return roleDao.listar();
		
	}
	
	@RequestMapping(value="/atualiza", method=RequestMethod.POST)
	public ModelAndView atualiza(@ModelAttribute("SpringWeb") Usuario usuario, RedirectAttributes redirectAttributes) {
		dao.atualizar(usuario);
		redirectAttributes.addFlashAttribute("message", "Permissões alteradas com sucesso!");
		return new ModelAndView("redirect:/usuarios");
	}
}

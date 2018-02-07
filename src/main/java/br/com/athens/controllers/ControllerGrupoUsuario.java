package br.com.athens.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.athens.domains.Grupo;
import br.com.athens.domains.Publicacao;
import br.com.athens.domains.Usuario;
import br.com.athens.services.ServiceGrupo;
import br.com.athens.services.ServiceUsuario;

@Controller
public class ControllerGrupoUsuario {

	@Autowired
	ServiceGrupo serviceGrupo;
	
	@Autowired
	ServiceUsuario serviceUsuario;
	
	@RequestMapping(value = "/incluirGrupoUsuario", method = RequestMethod.GET)
	ModelAndView incluirGrupoUsuario(ModelAndView modelAndView) {
		
		modelAndView.getModel().put("grupo", new Grupo());
		modelAndView.setViewName("/grupo/form");
		return modelAndView;
	}
	
	@RequestMapping(value = "/salvarGrupoUsuario", method = RequestMethod.POST)
	ModelAndView salvarGrupoUsuario(ModelAndView modelAndView, @Valid Grupo grupo, BindingResult result) {
		modelAndView.setViewName("/grupo/form");
		if (!result.hasErrors()) {
			serviceGrupo.save(grupo);
			return listarGrupoUsuario();
		}
		return modelAndView;
	}
	
	@RequestMapping(value = "/listarGruposUsuarios", method = RequestMethod.GET)
	ModelAndView listarGrupoUsuario() {
		ModelAndView modelAndView = new ModelAndView();
		List<Grupo> grupos = (List<Grupo>) serviceGrupo.getAllNotDelete();
		modelAndView.getModel().put("grupos", grupos);
		modelAndView.setViewName("/grupo/lista");
		return modelAndView;
	}	

	@RequestMapping(value = "/deleteGrupoUsuario/{id}", method = RequestMethod.GET)
	ModelAndView deleteGrupoUsuario(@PathVariable("id") Long id) {
		serviceGrupo.delete(id);
		return listarGrupoUsuario();
	}	
	
	@RequestMapping(value = "/editarGrupoUsuario/{id}", method = RequestMethod.GET)
	ModelAndView editarGrupoUsuario(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView();
		Grupo grupo = serviceGrupo.findById(id);
		modelAndView.getModel().put("grupo", grupo);
		modelAndView.setViewName("/grupo/form");
		return modelAndView;
	}	
	
	
}

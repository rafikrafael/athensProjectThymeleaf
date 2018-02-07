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

import br.com.athens.domains.Publicacao;
import br.com.athens.domains.Usuario;
import br.com.athens.services.ServicePublicacao;
import br.com.athens.services.ServiceUsuario;

@Controller
public class ControllerPublicacao {
	
	@Autowired
	ServiceUsuario serviceUsuario;
	
	@Autowired
	ServicePublicacao servicePublicacao;

	@RequestMapping(value = "/incluirPublicacao", method = RequestMethod.GET)
	ModelAndView editaPerfilUsuario(ModelAndView modelAndView) {

		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		Usuario usuario = serviceUsuario.getUsuarioByEmail(user.getUsername());
		Publicacao publicacao = new Publicacao();
		publicacao.setUsuario(usuario);
		modelAndView.getModel().put("publicacao", publicacao);
		modelAndView.setViewName("/publicacao/form");
		return modelAndView;
	}
	
	@RequestMapping(value = "/salvarPublicacao", method = RequestMethod.POST)
	ModelAndView editStatus(ModelAndView modelAndView, @Valid Publicacao publicacao, BindingResult result) {
		modelAndView.setViewName("/publicacao/form");
		if (!result.hasErrors()) {
			servicePublicacao.save(publicacao);
			return listarPublicacoes();
		}
		return modelAndView;
	}
	
	@RequestMapping(value = "/listarPublicacoes", method = RequestMethod.GET)
	ModelAndView listarPublicacoes() {
		ModelAndView modelAndView = new ModelAndView();
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		Usuario usuario = serviceUsuario.getUsuarioByEmail(user.getUsername());
		List<Publicacao> posts = servicePublicacao.findByUsuarioAndStatusExcluido(usuario);
		modelAndView.getModel().put("posts", posts);
		modelAndView.setViewName("/publicacao/lista");
		return modelAndView;
	}	

	@RequestMapping(value = "/deletePublicacao/{id}", method = RequestMethod.GET)
	ModelAndView deletePublicacao(@PathVariable("id") Long id) {
		servicePublicacao.delete(id);
		return listarPublicacoes();
	}	
	
	

}

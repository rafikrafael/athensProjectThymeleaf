package br.com.athens.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.athens.domains.Grupo;
import br.com.athens.domains.Publicacao;
import br.com.athens.domains.Usuario;
import br.com.athens.services.ServicePublicacao;

@Controller
@EnableGlobalMethodSecurity(securedEnabled=true)
public class ControllerIndex {
	
	@Autowired
	ServicePublicacao servicePublicacao;
	
	@RequestMapping(method=RequestMethod.GET, value="/")
	public ModelAndView index(){
		ModelAndView modelAndView = new ModelAndView();
		List<Publicacao> posts = servicePublicacao.getAllLast10();
		modelAndView.getModel().put("posts", posts);
		modelAndView.setViewName("/index");
		return modelAndView;
	}
	
	
}

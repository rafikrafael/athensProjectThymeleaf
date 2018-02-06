package br.com.athens.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.athens.domains.Usuario;
import br.com.athens.services.ServiceUsuario;

@Controller
public class ControllerLogin {
	
	@Autowired
	ServiceUsuario serviceUsuario;
	
	@RequestMapping("/login")
	String admin(){
		return "login";
	}
	
	@RequestMapping(value="/registrar", method=RequestMethod.GET )
	ModelAndView register(ModelAndView modelAndView){

		Usuario usuario= new Usuario();
		modelAndView.getModel().put("usuario", usuario);
		modelAndView.setViewName("registrar");
		return modelAndView;
	}
	
	@RequestMapping(value="/registrar", method=RequestMethod.POST)
	ModelAndView register(ModelAndView modelAndView, @Valid @ModelAttribute("usuario") Usuario usuario, BindingResult result) {
	    System.out.println("Teste -> " + usuario.getEmail() + " id " + usuario.getId());
		
		modelAndView.setViewName("registrar");
		if(!result.hasErrors()){			
			serviceUsuario.save(usuario);			
			modelAndView.setViewName("redirect:/");
		}
		return modelAndView;
	}
		
}

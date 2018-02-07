package br.com.athens.controllers;

import org.springframework.security.core.userdetails.User;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.athens.domains.Usuario;
import br.com.athens.services.ServiceUsuario;

@Controller
public class ControllerUsuario {

	@Autowired
	ServiceUsuario serviceUsuario;

	@RequestMapping(value = "/editarPerfilUsuario", method = RequestMethod.GET)
	ModelAndView editaPerfilUsuario(ModelAndView modelAndView) {

		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		Usuario usuario = serviceUsuario.getUsuarioByEmail(user.getUsername());
		System.out.println(" ID _>" + usuario.getId());
		modelAndView.getModel().put("usuario", usuario);
		modelAndView.setViewName("/perfil/editarPerfilUsuario");
		return modelAndView;
	}

	@RequestMapping(value = "/salvaPerfil", method = RequestMethod.POST)
	ModelAndView salvarPerfil(ModelAndView modelAndView, @Valid Usuario usuario, BindingResult result) {
		modelAndView.setViewName("/perfil/editarPerfilUsuario");
		if (!result.hasErrors()) {
			serviceUsuario.save(usuario);
			modelAndView.setViewName("redirect:/");
		}
		return modelAndView;
	}

}

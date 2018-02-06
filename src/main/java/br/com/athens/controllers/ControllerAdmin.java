package br.com.athens.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ControllerAdmin {

	@RequestMapping(method=RequestMethod.GET, value="/admin")
	public String adminPage(){
		return "/admin/admin";
	}
	
}

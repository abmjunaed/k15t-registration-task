package com.k15t.pat.client.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.k15t.pat.server.model.UserDTO;

/**
 * 
 * This class serves the views
 *
 */
@Controller
public class RegistrationController {

	@GetMapping("/registration")
	public String register(final Model model) {
		model.addAttribute("userData", new UserDTO());
		return "registration";
	}

}

package com.k15t.pat.client.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.k15t.pat.common.data.UserData;

@Controller
public class RegistrationController {
//	Logger logger = LoggerFactory.getLogger(RegistrationController.class);
//	@Autowired
//	private UserServiceRestClient userServiceRestClient;
//	@Autowired
//	private RestTemplate restTemplate;
//	@Autowired
//	private MessageSource messageSource;// Internationalization is not added.
	// But I am adding MessageSource so that in future we can easily add
	// Internationalization if needed

	@GetMapping("/registration")
	public String register(final Model model) {
		model.addAttribute("userData", new UserData());
		return "registration";
	}

//	@PostMapping("/registration")
//	public String register(final @Valid UserData userData, final BindingResult bindingResult, final Model model) {
//		if (bindingResult.hasErrors()) {
//			model.addAttribute("registrationForm", userData);
//			return "registration";
//		}
//		try {
//			userServiceRestClient.register(userData);
//		} catch (EmailAlreadyExistsException userEX) {
//			bindingResult.rejectValue("email", "userData.email", "Account already exists with this email.");
//			model.addAttribute("registrationForm", userData);
//			return "registration";
//		}
//		// TODO using hard-coded US to show how to do translation. Adapt it if we want
//		// to support Internationalization in future
//		model.addAttribute("registrationMsg", messageSource.getMessage("registration.success", null, Locale.US));
//		return "registration-success";
//	}
//	@PostMapping("/registration")
//	public String register(final UserData userData, final Model model) {
//		ResponseEntity<?> response = userServiceRestClient.register(userData);
//		logger.error("AAAAAAAAAAAAAAAAAAAAAAAAAA");
//		logger.error("err" + response.toString());
//		if (response.getStatusCode() == HttpStatus.CREATED) {
//			model.addAttribute("registrationMsg", messageSource.getMessage("registration.success", null, Locale.US));
//			return "registration-success";
//		} else if (response.getStatusCode() == HttpStatus.BAD_REQUEST) {
//			logger.error("AAAAAAAAAAAAAAAAAAAAAAAAAA");
//			logger.error(response.getBody().toString());
//			JsonObject o = JsonParser.parseString(response.getBody().toString()).getAsJsonObject();
//			List<ErrorResponse> errorResponse = new ArrayList<>();
//			for (Map.Entry<String, JsonElement> entry : o.entrySet()) {
//				errorResponse.add(new ErrorResponse(entry.getKey(), entry.getValue().toString()));
//			}
//			model.addAttribute("errorResponse", errorResponse);
//			model.addAttribute("registrationForm", userData);
//			return "registration";
//		}
//		restTemplate.getForObject(url, responseType)
//		if (bindingResult.hasErrors()) {
//			model.addAttribute("registrationForm", userData);
//			return "registration";
//		}
//		try {
//			userServiceRestClient.register(userData);
//		} catch (EmailAlreadyExistsException userEX) {
//			bindingResult.rejectValue("email", "userData.email", "Account already exists with this email.");
//			model.addAttribute("registrationForm", userData);
//			return "registration";
//		}
		// TODO using hard-coded US to show how to do translation. Adapt it if we want
		// to support Internationalization in future
//		return "registration";
//	}
}

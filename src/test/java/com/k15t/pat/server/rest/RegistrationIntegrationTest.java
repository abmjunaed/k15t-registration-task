package com.k15t.pat.server.rest;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class RegistrationIntegrationTest {
	@Autowired
	private MockMvc mockMvc;

	String userUrlEncoded = "firstName=a&lastName=b&email=email@email.com"
			+ "&password=password&matchingPassword=password"
			+ "&street=street&houseNumber=houseNumber&zip=zip&city=city&additional=additional&country=country"
			+ "&phoneNumber=phoneNumber";

	@Test
	void registrationTests() throws Exception {
		// create user
		mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/registration").content(userUrlEncoded)
				.contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE).with(csrf()))
				.andExpect(MockMvcResultMatchers.status().isCreated());

		// duplicate email is not supported
		mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/registration").content(userUrlEncoded)
				.contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE).with(csrf()))
				.andExpect(MockMvcResultMatchers.status().isConflict());

		// name can't be a number
		String wrongName = userUrlEncoded.replace("firstName=a", "firstName=12").replace("email=email@email.com",
				"email=newemail@email.com");
		mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/registration").content(wrongName)
				.contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE).with(csrf()))
				.andExpect(MockMvcResultMatchers.status().isBadRequest());

	}

}

package com.k15t.pat.server.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.k15t.pat.server.model.UserDTO;

public class PasswordMatchValidator implements ConstraintValidator<ValidPassword, Object> {

	@Override
	public boolean isValid(Object obj, ConstraintValidatorContext context) {
		UserDTO user = (UserDTO) obj;
		return user.getPassword().equals(user.getMatchingPassword());
	}
}

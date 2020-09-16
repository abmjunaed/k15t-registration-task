package com.k15t.pat.server.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.k15t.pat.common.data.UserData;

public class PasswordMatchValidator implements ConstraintValidator<ValidPassword, Object> {

	@Override
	public void initialize(ValidPassword constraintAnnotation) {
	}

	@Override
	public boolean isValid(Object obj, ConstraintValidatorContext context) {
		UserData user = (UserData) obj;
		return user.getPassword().equals(user.getMatchingPassword());
	}
}

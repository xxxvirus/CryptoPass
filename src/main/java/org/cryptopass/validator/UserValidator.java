package org.cryptopass.validator;

import java.util.regex.Pattern;

import org.cryptopass.entity.User;
import org.cryptopass.service.UserService;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class UserValidator implements Validator {

	private final static Pattern REG = Pattern
			.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
					+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
	private final UserService userService;

	public UserValidator(UserService userService) {
		this.userService = userService;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		User user = (User) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login", "",
				"Can't be empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "",
				"Can't be empty");
		if (!REG.matcher(user.getEmail()).matches()) {
			errors.rejectValue("email", "", "Enter correct email");
		}
		if (errors.getFieldError("email") == null) {
			if (userService.findByEmail(user.getEmail()) != null) {
				errors.rejectValue("email", "", "Already exist");
			}
		}
	}

}

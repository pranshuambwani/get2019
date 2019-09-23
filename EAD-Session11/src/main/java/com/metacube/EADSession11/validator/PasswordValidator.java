package com.metacube.EADSession11.validator;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import com.metacube.EADSession11.entities.Employee;

@Qualifier("PasswordValidator")
@Component
public class PasswordValidator implements CustomValidator {

	@Override
	public void passwordMisMatch(Object target, BindingResult errors) {
		Employee employee = (Employee)target;
        String password = employee.getPassword();
        String confPassword = "1Abcdefg";//employee.getCpassword();
        
        if(!(password.equals(confPassword))){
        	ObjectError oe = new ObjectError("confirmPassword", "password must be same");
        	errors.addError(oe);
        }

	}

}

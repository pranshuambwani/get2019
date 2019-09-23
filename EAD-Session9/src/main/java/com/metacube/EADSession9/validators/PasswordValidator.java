package com.metacube.EADSession9.validators;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import com.metacube.EADSession9.entities.Employee;

@Qualifier("PasswordValidator")
@Component
public class PasswordValidator implements CustomValidator {

	@Override
	public void passwordMisMatch(Object target, BindingResult errors) {
		Employee employee = (Employee)target;
        String password = employee.getPassword();
        String confPassword = employee.getCpassword();
        
        if(!(password.equals(confPassword))){
        	ObjectError oe = new ObjectError("confirmPassword", "password must be same");
        	errors.addError(oe);
        }

	}

}

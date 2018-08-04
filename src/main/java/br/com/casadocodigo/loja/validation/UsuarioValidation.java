package br.com.casadocodigo.loja.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import br.com.casadocodigo.loja.dao.UsuarioDAO;
import br.com.casadocodigo.loja.models.Usuario;

@Component
public class UsuarioValidation implements Validator{

	@Autowired
	UsuarioDAO dao;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Usuario.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "nome", "field.required");
		ValidationUtils.rejectIfEmpty(errors, "email", "field.required");
		ValidationUtils.rejectIfEmpty(errors, "senha", "field.required");
		ValidationUtils.rejectIfEmpty(errors, "senhaRepetida", "field.required");
		
		Usuario usuario = (Usuario) target;
		int passwordLength = usuario.getSenha().length();
		if(passwordLength < 5 && passwordLength > 0) {
			errors.rejectValue("senha", "short.password");
		}
		if(passwordLength >= 5 && !usuario.getSenha().equals(usuario.getSenhaRepetida())) {
			errors.rejectValue("senha", "mismatch.password");
			errors.rejectValue("senhaRepetida", "mismatch.password");
		}
		if(!dao.checkNewUser(usuario.getEmail())) {
			errors.rejectValue("email", "existing.user");
		}
		
	}

}

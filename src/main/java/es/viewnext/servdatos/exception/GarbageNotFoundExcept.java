package es.viewnext.servdatos.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Registro Not Found")
public class GarbageNotFoundExcept extends RuntimeException{

	/**
	 * Default serial UID
	 */
	private static final long serialVersionUID = 1L;

}
